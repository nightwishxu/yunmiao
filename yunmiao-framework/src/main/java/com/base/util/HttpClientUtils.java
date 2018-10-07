package com.base.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLHandshakeException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {
	private static Log logger = LogFactory.getLog(HttpClientUtils.class);
	private static final String DEFAULT_CHARSET = "GBK";
	private static final String SSL_DEFAULT_SCHEME = "https";
	private static final int SSL_DEFAULT_PORT = 443;
	private static HttpParams httpParams = new BasicHttpParams();

	private static PoolingClientConnectionManager manager = new PoolingClientConnectionManager();
	private static final int TIMEOUT = 30000;
	private static Map<String, DefaultHttpClient> httpClientPool;
	private static HttpRequestRetryHandler requestRetryHandler;
	private static ResponseHandler<byte[]> responseHandler;

	static {
		HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);

		HttpProtocolParams.setUseExpectContinue(httpParams, Boolean.FALSE.booleanValue());
		HttpProtocolParams.setUserAgent(httpParams, "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");

		HttpConnectionParams.setConnectionTimeout(httpParams, 30000);

		HttpConnectionParams.setSoTimeout(httpParams, 30000);

		manager.setMaxTotal(100);

		httpClientPool = new HashMap();

		requestRetryHandler = new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if (executionCount >= 3) {
					return false;
				}

				if ((exception instanceof NoHttpResponseException)) {
					return true;
				}

				if ((exception instanceof SSLHandshakeException)) {
					return false;
				}

				HttpRequest request = (HttpRequest) context.getAttribute("http.request");
				boolean idempotent = request instanceof HttpEntityEnclosingRequest;

				return !idempotent;
			}
		};
		responseHandler = new ResponseHandler() {
			public byte[] handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String charset = EntityUtils.getContentCharSet(entity) == null ? "GBK" : EntityUtils.getContentCharSet(entity);
					return EntityUtils.toByteArray(entity);
				}
				return null;
			}
		};
	}

	public static byte[] getContent(String url, Map<String, String> params, String requestCharset) {
		if ((url == null) || (StringUtils.isEmpty(url))) {
			return null;
		}
		List qparams = getParamsList(params);
		if ((qparams != null) && (qparams.size() > 0)) {
			requestCharset = requestCharset == null ? "GBK" : requestCharset;
			String formatParams = URLEncodedUtils.format(qparams, requestCharset);
			url = url.substring(0, url.indexOf("?") + 1) + formatParams;
		}
		DefaultHttpClient httpclient = getHttpClient(requestCharset);

		HttpGet hg = new HttpGet(url);

		byte[] responseByte = (byte[]) null;
		try {
			responseByte = (byte[]) httpclient.execute(hg, responseHandler);
		} catch (ClientProtocolException e) {
			throw new RuntimeException("客户端连接协议错误", e);
		} catch (IOException e) {
			throw new RuntimeException("IO操作异常,查看是否超过请求设定时间:30000毫秒!", e);
		} finally {
			abortConnection(hg, httpclient);
		}
		return responseByte;
	}

	public static byte[] getContent(String url) {
		return getContent(url, null, null);
	}

	public static byte[] getContent(String url, Map<String, String> params) {
		return getContent(url, null);
	}

	public static String get(String url, Map<String, String> params, String requestCharset, String responseCharset) {
		String responseStr = null;
		try {
			byte[] responseByte = getContent(url, params, requestCharset);
			responseStr = new String(responseByte, StringUtils.isBlank(responseCharset) ? DEFAULT_CHARSET : responseCharset);
		} catch (IOException e) {
			throw new RuntimeException("IO操作异常,查看是否超过请求设定时间:30000毫秒!", e);
		}

		return responseStr;
	}

	public static String get(String url) {
		return get(url, null, null, null);
	}

	public static String get(String url, Map<String, String> params) {
		return get(url, params, null, null);
	}

	public static String get(String url, Map<String, String> params, String requestCharset) {
		return get(url, params, requestCharset, null);
	}

	public static String post(String url, Map<String, String> params, String requestCharset, String responseCharset, Header[] headers) {
		if ((url == null) || (StringUtils.isEmpty(url))) {
			return null;
		}

		DefaultHttpClient httpclient = getHttpClient(requestCharset);
		UrlEncodedFormEntity formEntity = null;
		try {
			if ((requestCharset == null) || (StringUtils.isEmpty(requestCharset)))
				formEntity = new UrlEncodedFormEntity(getParamsList(params));
			else
				formEntity = new UrlEncodedFormEntity(getParamsList(params), requestCharset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("不支持的编码集", e);
		}
		HttpPost hp = new HttpPost(url);
		hp.setEntity(formEntity);
		if ((headers != null) && (headers.length > 0)) {
			for (Header header : headers) {
				if (hp.getFirstHeader(header.getName()) != null)
					hp.setHeader(header);
				else {
					hp.addHeader(header);
				}
			}
		}

		hp.getAllHeaders();

		String responseStr = null;
		try {
			byte[] responseByte = (byte[]) httpclient.execute(hp, responseHandler);
			responseStr = new String(responseByte, StringUtils.isBlank(responseCharset) ? DEFAULT_CHARSET : responseCharset);
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("客户端连接协议错误", e);
		} catch (IOException e) {
			throw new RuntimeException("IO操作异常,查看是否超过请求设定时间:30000毫秒!", e);
		} finally {
			abortConnection(hp, httpclient);
		}
		return responseStr;
	}

	public static String post(String url, Map<String, String> params, String requestCharset) {
		return post(url, params, requestCharset, null, new Header[0]);
	}

	public static String post(String url) {
		return post(url, null);
	}

	public static String post(String url, Map<String, String> params) {
		return post(url, params, null, null, new Header[0]);
	}

	public static String post(String url, String body, String charset, String responseCharset, Header[] headers) {
		if ((url == null) || (StringUtils.isEmpty(url))) {
			return null;
		}

		DefaultHttpClient httpclient = getHttpClient(charset);
		StringEntity entity = null;
		entity = new StringEntity(body, charset);
		HttpPost hp = new HttpPost(url);
		hp.setEntity(entity);
		if ((headers != null) && (headers.length > 0)) {
			for (Header header : headers) {
				if (hp.getFirstHeader(header.getName()) != null)
					hp.setHeader(header);
				else {
					hp.addHeader(header);
				}
			}

		}

		String responseStr = null;
		try {
			byte[] responseByte = (byte[]) httpclient.execute(hp, responseHandler);
			responseStr = new String(responseByte, StringUtils.isBlank(responseCharset) ? DEFAULT_CHARSET : responseCharset);
		} catch (ClientProtocolException e) {
			throw new RuntimeException("客户端连接协议错误", e);
		} catch (IOException e) {
			throw new RuntimeException("IO操作异常", e);
		} finally {
			abortConnection(hp, httpclient);
		}
		return responseStr;
	}

	public static String post(String url, Map<String, String> params, String charset, URL keystoreUrl, String keystorePassword,
			URL truststoreUrl, String truststorePassword, String responseCharset) {
		if ((url == null) || (StringUtils.isEmpty(url))) {
			return null;
		}
		DefaultHttpClient httpclient = getHttpClient(charset, keystoreUrl, keystorePassword, truststoreUrl, truststorePassword);
		UrlEncodedFormEntity formEntity = null;
		try {
			if ((charset == null) || (StringUtils.isEmpty(charset)))
				formEntity = new UrlEncodedFormEntity(getParamsList(params));
			else
				formEntity = new UrlEncodedFormEntity(getParamsList(params), charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("不支持的编码集", e);
		}
		HttpPost hp = null;
		String responseStr = null;
		try {
			hp = new HttpPost(url);
			hp.setEntity(formEntity);
			byte[] responseByte = (byte[]) httpclient.execute(hp, responseHandler);
			responseStr = new String(responseByte, StringUtils.isBlank(responseCharset) ? DEFAULT_CHARSET : responseCharset);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("keystore文件不存在", e);
		} catch (IOException e) {
			throw new RuntimeException("I/O操作失败或中断 ", e);
		} finally {
			abortConnection(hp, httpclient);
		}
		return responseStr;
	}

	private static DefaultHttpClient getHttpClient(String charset) {
		return getHttpClient(charset, null, null, null, null);
	}

	private static DefaultHttpClient getHttpClient(String charset, URL keystoreUrl, String keystorePassword, URL truststoreUrl,
			String truststorePassword) {
		String httpCilentName = "default";

		if (keystoreUrl != null) {
			httpCilentName = keystoreUrl.toString();
		}

		if (!httpClientPool.containsKey(httpCilentName)) {
			HttpProtocolParams.setContentCharset(httpParams, charset == null ? "GBK" : charset);

			DefaultHttpClient httpclient = new DefaultHttpClient(manager, httpParams);

			httpclient.setHttpRequestRetryHandler(requestRetryHandler);

			if (keystoreUrl != null) {
				try {
					KeyStore keyStore = createKeyStore(keystoreUrl, keystorePassword);
					KeyStore trustStore = createKeyStore(truststoreUrl, keystorePassword);
					SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore, keystorePassword, trustStore);

					Scheme scheme = new Scheme("https", socketFactory, 443);
					httpclient.getConnectionManager().getSchemeRegistry().register(scheme);
				} catch (KeyStoreException e) {
					throw new RuntimeException("keytore解析异常", e);
				} catch (NoSuchAlgorithmException e) {
					throw new RuntimeException("指定的加密算法不可用", e);
				} catch (CertificateException e) {
					throw new RuntimeException("信任证书过期或解析异常", e);
				} catch (IOException e) {
					throw new RuntimeException("I/O操作失败或中断 ", e);
				} catch (KeyManagementException e) {
					throw new RuntimeException("处理密钥管理的操作异常", e);
				} catch (UnrecoverableKeyException e) {
					throw new RuntimeException("keystore中的密钥无法恢复异常", e);
				}
			}

			httpClientPool.put(httpCilentName, httpclient);
		}

		return (DefaultHttpClient) httpClientPool.get(httpCilentName);
	}

	private static void abortConnection(HttpRequestBase hrb, HttpClient httpclient) {
		if (hrb != null) {
			hrb.abort();
		}

		if ((httpclient != null) && (httpclient.getConnectionManager() != null) && (!httpClientPool.containsValue(httpclient)))
			httpclient.getConnectionManager().shutdown();
	}

	private static KeyStore createKeyStore(URL url, String password) throws KeyStoreException, NoSuchAlgorithmException,
			CertificateException, IOException {
		if (url == null) {
			throw new IllegalArgumentException("Keystore url may not be null");
		}
		KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		InputStream is = null;
		try {
			is = url.openStream();
			keystore.load(is, password != null ? password.toCharArray() : null);
		} finally {
			if (is != null) {
				is.close();
				is = null;
			}
		}
		return keystore;
	}

	private static List<NameValuePair> getParamsList(Map<String, String> paramsMap) {
		List params = new ArrayList();

		if ((paramsMap != null) && (paramsMap.size() > 0)) {
			for (Map.Entry map : paramsMap.entrySet()) {
				params.add(new BasicNameValuePair((String) map.getKey(), (String) map.getValue()));
			}
		}

		return params;
	}
}