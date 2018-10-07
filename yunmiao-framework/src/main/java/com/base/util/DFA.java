package com.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.base.CoreConstants;
import com.base.io.IoUtil;

public class DFA {
	//关键词头字符哈希表
	public static Map<Character, SingleChar> keyMap = null;
    //是否最大匹配
    static boolean isMax = true;
    private static final Logger logger = Logger.getLogger(DFA.class);
    /**
     * 字符对象在DFA词表中表示一个关键词节点
     */
	static class SingleChar implements Comparable<SingleChar> {
		private Character ch;	//该节点表示字符
		private boolean isEnd = false;	//是否为关键词结尾字符
		private CharList nextChars = null;	//子节点集合
		
		/**
		 * 在该字符子节点中查找，没找到返回null，找到返回子节点对象
		 * @param c
		 * @return
		 */
		public SingleChar findNextChar(char c) {
			if(this.hasNext())
				return this.nextChars.findChar(c);
			else //该字符节点没有子节点，直接返回null
				return null;
		}
		
		/**
		 * 添加一个子节点，并返回
		 * @param c
		 * @param flag
		 * @return
		 */
		public SingleChar addNextChar(char c, boolean flag) {
			return this.nextChars.addNewChar(c, flag);
		}
		
		/**
		 * 该字符节点是否有下一个
		 * @return
		 */
		public boolean hasNext() {
			return nextChars != null;
		}

		public Character getCh() {
			return ch;
		}
		public void setCh(Character ch) {
			this.ch = ch;
		}
		
		public boolean isEnd() {
			return isEnd;
		}
		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}
		public CharList getNextChars() {
			return nextChars;
		}
		public void setNextChars(CharList nextChars) {
			this.nextChars = nextChars;
		}
		public int compareTo(SingleChar o) {
			if(o.ch > this.ch) {
				return -1;
			} else if(o.ch < this.ch) {
				return 1;
			} else {
				return 0;
			}
		}
	} 
	
	/**
	 * 存储字符，代替DFA中map
	 *
	 */
	static class CharList {
		private int startChar;	//字符表开头字符值
		private int endChar;	//字符表结尾字符值
		private List<SingleChar> chars = new ArrayList<SingleChar>();	//字符表
		
		/**
		 * 查找字符，没有返回null
		 * @param c
		 * @return
		 */
		public SingleChar findChar(char c) {
			if(c < startChar) {	//如果小于自小字符，不在表中
				return null;
			}
			if(c > endChar) {	//如果大于自小字符，不在表中
				return null;
			}
			for(int i = 0, len = chars.size(); i < len; i++) {
				SingleChar sc = chars.get(i);
				if(sc.getCh() == c)
					return sc;
			}
			return null;
		}
		
		/**
		 * 添加字符
		 * @param c
		 * @param isEnd
		 */
		public SingleChar addNewChar(char c, boolean isEnd) {
			SingleChar sc = new SingleChar();
			sc.setCh(c);
			sc.setEnd(isEnd);
			if(c <= startChar) {	//小于开始字符，插入到头
				chars.add(0, sc);
				startChar = c;
			} else if(c >= endChar) {	//大于结尾字符，插入到尾部
				chars.add(chars.size(), sc); 
				endChar = c;
			} else {
				chars.add(sc);
				Collections.sort(chars);	//重新排序
			}
			return sc;
		}

		public int getStartChar() {
			return startChar;
		}

		public void setStartChar(int startChar) {
			this.startChar = startChar;
		}

		public int getEndChar() {
			return endChar;
		}

		public void setEndChar(int endChar) {
			this.endChar = endChar;
		}
	}
	
	
	
	/**
	 * 加载关键词表，生成关键词树
	 * @param keyStr
	 * @param separator
	 */
	private static void loadKeywords(String keyStr, String separator) {
		String[] keys = keyStr.split(separator);
		for(String key : keys) {
			if(key != null && !key.isEmpty()) {
				char firstC = key.charAt(0);
				int len = key.length();
				SingleChar keyChar = keyMap.get(firstC);
				if(keyChar == null) {	//在词表头Map中没有节点时，创建新节点
					keyChar = new SingleChar();
					keyChar.setCh(firstC);
					keyMap.put(firstC, keyChar);
				}
				
				if(len == 1)//该关键词为单个字符时，设置为结尾字符
					keyChar.setEnd(true);
					
				for(int i = 1; i < len; i++) {	//加载后续字符节点
					boolean isEnd = i == len - 1;	//是否为最后一个字符
					char c = key.charAt(i);
					if(keyChar.hasNext()) {	//上一个字符及节点有子节点时
						SingleChar sc = keyChar.findNextChar(c);
						if(sc == null) {
							keyChar = keyChar.addNextChar(c, isEnd);
						} else {
							keyChar = sc;
							if(isEnd)	//如果该字符为结尾字符，设置isEnd
								keyChar.setEnd(isEnd);
						}
					} else {	//没有子节点表，创建并添加节点
						keyChar.setNextChars(new CharList());
						keyChar = keyChar.addNextChar(c, isEnd);
					}
				}
			}			
		}
	}
	
	public static void reloadData(){
		keyMap.clear();
		String txt = "";
		String filePath = CoreConstants.FILE_PATH+CoreConstants.getProperty("social.sensitive_word_filepath");
		if(StringUtils.isNotBlank(filePath)){
			File file = new File(filePath);
			if(file.isFile() && file.exists()){
				try {
					txt = IoUtil.read(new FileInputStream(file), "utf-8");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("敏感词加载失败~");
				}
			}
		}
		if(txt.length()>0) {
			//加载过滤词表
			loadKeywords(txt, ",");
		}
	}

	private static void loadData(){
		if(keyMap == null){
			keyMap = new HashMap<Character, SingleChar>();
		}
		String txt = "";
		String filePath = CoreConstants.FILE_PATH+CoreConstants.getProperty("social.sensitive_word_filepath");
		if(StringUtils.isNotBlank(filePath)){
			File file = new File(filePath);
			if(file.isFile() && file.exists()){
				try {
					txt = IoUtil.read(new FileInputStream(file), "utf-8");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("敏感词加载失败~");
				}
			}
		}
		if(txt.length()>0) {
			//加载过滤词表
			loadKeywords(txt, ",");
		}
	}
	
	/**
	 * 是否存在关键字
	 * @param str
	 * @return
	 */
	public static boolean hasKeys(String str){
		if(keyMap == null){
			keyMap = new HashMap<Character, SingleChar>();
			loadData();
		}
		if(StringUtils.isBlank(str))//为空返回空
			return false;
		
		char[] chars = str.toCharArray();
		int klen = 0;	//关键词匹配长度
		int maxlen = 0;	//最大匹配模式下关键词匹配长度
		
		for(int i = 0, len = chars.length; i < len;) {
			char c = chars[i];
			SingleChar keyChar = keyMap.get(c);	//在词表中有无以该字符开头的字符
			if(keyChar != null) {	//当有以该字符开头的关键词时，进入后续匹配
				do {	
					klen++;//
					if(i + klen < len) {
						c = chars[i + klen];
						if(keyChar.isEnd()) {	//这个keyChar是上一个字符的
							maxlen = klen;	//正好多一个给substring
							if(!isMax) {	//如果是最大匹配模式，继续匹配，否则结束
								break;
							} 
						} 
					} else {	//匹配最后一个字符，检查上一个字符是否是关键词结尾
						if(keyChar.isEnd())	//因为使用do{}while();的，所以这里必须检验
							maxlen = klen;
						break;
					}
				} while((keyChar = keyChar.findNextChar(c)) != null);
				if(maxlen > 0)	//如果成功匹配到了
					return true;
				else
					i++;
				klen = 0;
				maxlen = 0;
			} else {
				i++;
			}
		}
		return false;
	}
	
	/**
	 * 查找目标文本所有关键词
	 * @param str
	 * @return
	 */
	public static String replaceKeys(String str) {
		if(keyMap == null){
			keyMap = new HashMap<Character, SingleChar>();
			loadData();
		}
		
		if(StringUtils.isBlank(str))//为空返回空
			return "";
		char[] chars = str.toCharArray();
		int klen = 0;	//关键词匹配长度
		int maxlen = 0;	//最大匹配模式下关键词匹配长度
		
		for(int i = 0, len = chars.length; i < len;) {
			char c = chars[i];
			SingleChar keyChar = keyMap.get(c);	//在词表中有无以该字符开头的字符
			if(keyChar != null) {	//当有以该字符开头的关键词时，进入后续匹配
				do {	
					klen++;//
					if(i + klen < len) {
						c = chars[i + klen];
						if(keyChar.isEnd()) {	//这个keyChar是上一个字符的
							maxlen = klen;	//正好多一个给substring
							if(!isMax) {	//如果是最大匹配模式，继续匹配，否则结束
								break;
							} 
						} 
					} else {	//匹配最后一个字符，检查上一个字符是否是关键词结尾
						if(keyChar.isEnd())	//因为使用do{}while();的，所以这里必须检验
							maxlen = klen;
						break;
					}
				} while((keyChar = keyChar.findNextChar(c)) != null);
				if(maxlen > 0)	//如果成功匹配到了，替换为‘*’
					Arrays.fill(chars, i, i = i + maxlen, '*');
				else
					i++;
				klen = 0;
				maxlen = 0;
			} else {
				i++;
			}
		}
		
		return String.valueOf(chars);
	}
	
	//e.g.
    public static void main(String[] args) {
        String txt = "安局办公楼你好中国把学生人大主任我真是需要办理资格女优干他乱交，他练过法轮功我不是骗人的安局办公楼安局办公楼安局办";
        System.out.println(DFA.replaceKeys(txt));
    }
}
