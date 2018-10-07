package com.item.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.ConstantsCode;
import com.base.cache.serviceCache.CacheAdd;
import com.base.cache.serviceCache.CacheRemove;
import com.item.dao.CodeMapper;
import com.item.dao.model.Code;
import com.item.dao.model.CodeExample;

import javax.annotation.PostConstruct;

@Service
public class CodeService {

    private final static Logger logger = LoggerFactory.getLogger(CodeService.class);
    @Autowired
    private CodeMapper codeMapper;



    public int countByExample(CodeExample example) {
        return this.codeMapper.countByExample(example);
    }

    @CacheAdd(cache = ConstantsCode.SERVICE_CACHE, group = "'CodeService'", key = "#code")
    public Code selectByPrimaryKey(String code) {
        return this.codeMapper.selectByPrimaryKey(code);
    }

    public List<Code> selectByExample(CodeExample example) {
        return this.codeMapper.selectByExample(example);
    }

    @CacheRemove(cache = ConstantsCode.SERVICE_CACHE, group = "'CodeService'", key = "#code")
    public int deleteByPrimaryKey(String code) {
        return codeMapper.deleteByPrimaryKey(code);
    }

    @CacheRemove(cache = ConstantsCode.SERVICE_CACHE, group = "'CodeService'", key = "#record.code")
    public int updateByPrimaryKeySelective(Code record) {
        return codeMapper.updateByPrimaryKeySelective(record);
    }

    @CacheRemove(cache = ConstantsCode.SERVICE_CACHE, group = "'CodeService'", key = "#record.code")
    public int updateByPrimaryKey(Code record) {
        return codeMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(CodeExample example) {
        return codeMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Code record, CodeExample example) {
        return codeMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Code record, CodeExample example) {
        return codeMapper.updateByExample(record, example);
    }

    public int insert(Code record) {
        return codeMapper.insert(record);
    }

    public int insertSelective(Code record) {
        return codeMapper.insertSelective(record);
    }

    public String getCode(String code) {
        Code c = selectByPrimaryKey(code);
        return c.getValue();
    }

    @CacheAdd(cache = ConstantsCode.SERVICE_CACHE, group = "'CodeService'", key = "#code")
    public Code getByCode(String code) {
        return selectByPrimaryKey(code);
    }

//    public static   List<String> getExpressList() {
//        if (expressList==null){
//            synchronized (expressList){
//                if (expressList==null){
//                    loadData();
//                }
//            }
//        }
//        return expressList;
//    }
//
//    public static Map<String, String> getExpressMap() {
//        if (expressMap==null){
//            synchronized (expressMap){
//                if (expressMap==null){
//                    loadData();
//                }
//            }
//        }
//        return expressMap;
//    }

    //    public static void main(String[] args) {
////        Map<String,String> comMap=new HashMap<>();
////        comMap.put("中通速递", "zhongtong");
////        comMap.put("邮政速递", "ems");
////        comMap.put("圆通速递", "yuantong");
////        comMap.put("韵达快运", "yunda");
////        comMap.put("韵达速递", "yunda");
////        comMap.put("汇通快运", "huitongkuaidi");
////        comMap.put("百世汇通", "huitongkuaidi");
////        comMap.put("申通快递", "shentong");
////        comMap.put("顺丰快递", "shunfeng");
////        comMap.put("shunfeng", "shunfeng");
////        System.out.println(JSONObject.toJSONString(comMap));
//        String json="{\"申通快递\":\"shentong\",\"shunfeng\":\"shunfeng\",\"百世汇通\":\"huitongkuaidi\",\"韵达快运\":\"yunda\",\"邮政速递\":\"ems\",\"中通速递\":\"zhongtong\",\"汇通快运\":\"huitongkuaidi\",\"圆通速递\":\"yuantong\",\"顺丰快递\":\"shunfeng\",\"韵达速递\":\"yunda\"}";
//        Map<String,String> map=(Map)JSONObject.parse(json);
//        System.out.println(map.get("百世汇通"));
//    }
//}

}