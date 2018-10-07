//package com.util;
//
//import com.ihidea.core.support.exception.ServiceException;
//import com.ihidea.core.util.HttpClientUtils;
//import com.ihidea.core.util.JSONUtilsEx;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 快递api
// *
// * @author lilin
// * @version [版本号, 2016年4月23日]
// */
//@Service
//public class LogisticsService {
//
//    private static final Logger logger = LoggerFactory.getLogger(LogisticsService.class);
//
//    /**
//     * 快递公司map集合
//     */
//    private Map<String, String> comMap;
//
//    /**
//     * 初始化
//     *
//     */
//    @PostConstruct
//    private void init() {
//        comMap = new HashMap<String, String>();
//        comMap.put("yuantong", "yuantong");
//        comMap.put("yunda", "yunda");
//        comMap.put("huitongkuaidi", "huitongkuaidi");
//        comMap.put("zhongtong", "zhongtong");
//        comMap.put("shentong", "shentong");
//        comMap.put("ems", "ems");
//        comMap.put("中通速递", "zhongtong");
//        comMap.put("邮政速递", "ems");
//        comMap.put("圆通速递", "yuantong");
//        comMap.put("韵达快运", "yunda");
//        comMap.put("韵达速递", "yunda");
//        comMap.put("汇通快运", "huitongkuaidi");
//        comMap.put("百世汇通", "huitongkuaidi");
//        comMap.put("申通快递", "shentong");
//        comMap.put("顺丰", "shunfeng");
//    }
//
//    /**
//     * 返回HTML5页面形式的快递查询
//     *
//     * @param com 快递公司名称或编号
//     * @param no 快递运单号
//     * @param referer 前一地址
//     * @return url
//     */
//    public String searchWapExpress(String com, String no, String referer) {
//        String co = comMap.get(com);
//        if (StringUtils.isEmpty(co)) {
//            co = com;
//        }
//        StringBuilder url = new StringBuilder();
//        url.append("https://m.kuaidi100.com/index_all.html?type=");
//        url.append(co).append("&postid=").append(no);
//        if (StringUtils.isNotEmpty(referer)) {
//            url.append("&callbackurl=" + referer);
//        }
//        return url.toString();
//    }
//
//    /**
//     *
//     * 根据快递公司和快递单号查询快递信息(json)
//     *
//     * @param logisticsComp
//     * @param logisticsNo
//     * @return
//     *
//     */
//    public Map<String, Object> expresssInfo(String logisticsComp, String logisticsNo) {
//        if ((StringUtils.isEmpty(logisticsComp)) || (StringUtils.isEmpty(logisticsNo))) {
//            throw new ServiceException("无效的快递信息");
//        }
//        String co = (String)this.comMap.get(logisticsComp);
//        if (StringUtils.isEmpty(co)) {
//            co = logisticsComp;
//        }
//
//        try {
//
//            String queryUrl = "https://m.kuaidi100.com/query?type=" + co + "&postid=" + logisticsNo + "&id=1&valicode=&temp="
//                + System.currentTimeMillis();
//            String result = HttpClientUtils.get(queryUrl);
//            if (StringUtils.isNotBlank(result)) {
//                Map jsonObject = (Map)JSONUtilsEx.deserialize(result, Map.class);
//                if (jsonObject.containsKey("status")) {
//                    String status = (String)jsonObject.get("status");
//                    if ("0".equals(status)) {
//                        throw new ServiceException("物流单暂无结果");
//                    }
//                    if ("2".equals(status)) {
//                        throw new ServiceException("物流信息查询失败");
//                    }
//                    if ("200".equals(status) || "1".equals(status)) {
//                        // 解析物流信息
//                        Map<String, Object> retResult = new HashMap<>();
//                        retResult.put("logisticsComp", logisticsComp);
//                        retResult.put("logisticsNo", logisticsNo);
//                        retResult.put("status", (String)jsonObject.get("state"));
//
//                        List<Map<String, Object>> progress = new ArrayList<>();
//                        List<Map<String, Object>> data = (List)jsonObject.get("data");
//                        if (CollectionUtils.isNotEmpty(data)) {
//                            for (Map<String, Object> map : data) {
//                                Map<String, Object> detail = new HashMap<>();
//                                detail.put("time", map.get("time"));
//                                detail.put("detail", map.get("context"));
//
//                                progress.add(detail);
//                            }
//                        }
//                        retResult.put("progress", progress);
//
//                        return retResult;
//                    }
//                    logger.error("快递信息接口返回异常:{}", result);
//                    String message = (String)jsonObject.get("message");
//                    if (StringUtils.isNotEmpty(message)) {
//                        throw new ServiceException("物流信息查询失败");
//                    }
//                }
//            }
//        } catch (Exception e) {
//            logger.error("快递信息查询异常", e);
//        }
//        throw new ServiceException("物流单暂无结果");
//    }
//}
