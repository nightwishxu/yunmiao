package com.base.service;

import java.util.*;

/**
 * @param
 * @Auther: xuwenwei
 * @Date: 2018/7/24 13:14
 * @Description:
 */
public class SensitiveWordDfaFilter {

    private static Map sensitiveWordMap = null;
    public static int minMatchTYpe = 1;
    public static int maxMatchType = 2;

    public SensitiveWordDfaFilter() {
//        if (sensitiveWordMap == null) {
//            throw new Exception("请先调用initKeyWordS方法初始化敏感词库");
//        }
    }

    public static synchronized void initKeyWords(Set<String> keyWordSet) {
        if (sensitiveWordMap == null) {
            sensitiveWordMap = new HashMap(keyWordSet.size());
            String key = null;
            Map nowMap = null;
            Map<String, String> newWorMap = null;
            Iterator iterator = keyWordSet.iterator();

            while(iterator.hasNext()) {
                key = (String)iterator.next();
                nowMap = sensitiveWordMap;

                for(int i = 0; i < key.length(); ++i) {
                    char keyChar = key.charAt(i);
                    Object wordMap = ((Map)nowMap).get(keyChar);
                    if (wordMap != null) {
                        nowMap = (Map)wordMap;
                    } else {
                        newWorMap = new HashMap();
                        newWorMap.put("isEnd", "0");
                        ((Map)nowMap).put(keyChar, newWorMap);
                        nowMap = newWorMap;
                    }

                    if (i == key.length() - 1) {
                        ((Map)nowMap).put("isEnd", "1");
                    }
                }
            }
        }

    }

    public boolean existsSensitiveWord(String txt, int matchType) {
        for(int i = 0; i < txt.length(); ++i) {
            int matchFlag = this.sensitiveWordCnt(txt, i, matchType);
            if (matchFlag > 0) {
                return true;
            }
        }

        return false;
    }

    public Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordList = new HashSet();

        for(int i = 0; i < txt.length(); ++i) {
            int length = this.sensitiveWordCnt(txt, i, matchType);
            if (length > 0) {
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;
            }
        }

        return sensitiveWordList;
    }

    public String replaceSensitiveWord(String txt, int matchType, String replaceChar) {
        String resultTxt = txt;
        Set<String> set = this.getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word = null;

        for(String replaceString = null; iterator.hasNext(); resultTxt = resultTxt.replaceAll(word, replaceString)) {
            word = (String)iterator.next();
            replaceString = this.getReplaceChars(replaceChar, word.length());
        }

        return resultTxt;
    }

    private String getReplaceChars(String replaceChar, int length) {
        String resultReplace = replaceChar;

        for(int i = 1; i < length; ++i) {
            resultReplace = resultReplace + replaceChar;
        }

        return resultReplace;
    }

    private int sensitiveWordCnt(String txt, int beginIndex, int matchType) {
        boolean flag = false;
        int matchFlag = 0;
        //char word = false;
        Map nowMap = sensitiveWordMap;

        for(int i = beginIndex; i < txt.length(); ++i) {
            char word = txt.charAt(i);
            nowMap = (Map)nowMap.get(word);
            if (nowMap == null) {
                break;
            }

            ++matchFlag;
            if ("1".equals(nowMap.get("isEnd"))) {
                flag = true;
                if (minMatchTYpe == matchType) {
                    break;
                }
            }
        }

        if (matchFlag < 2 || !flag) {
            matchFlag = 0;
        }

        return matchFlag;
    }

    public static void main(String[] args) {
        Set<String> keyWordSet = new HashSet();
        keyWordSet.add("我们");
        keyWordSet.add("习近平");
        keyWordSet.add("法轮功");
        initKeyWords(keyWordSet);
        SensitiveWordDfaFilter filter = new SensitiveWordDfaFilter();
        System.out.println("敏感词的数量：" + sensitiveWordMap.size());
        String string = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。";
        System.out.println("待检测语句字数：" + string.length());
        long beginTime = System.currentTimeMillis();
        Set<String> set = filter.getSensitiveWord(string, 2);
        System.out.println("替换后字符串:" + filter.replaceSensitiveWord(string, 2, "*"));
        long endTime = System.currentTimeMillis();
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("总共消耗时间为：" + (endTime - beginTime));
    }

}
