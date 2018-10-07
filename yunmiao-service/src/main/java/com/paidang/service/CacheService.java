package com.paidang.service;

import com.alibaba.fastjson.JSONObject;
import com.base.spring.SpringContextUtil;
import com.item.dao.CodeMapper;
import com.item.dao.SysDictMapper;
import com.item.dao.UserMapper;
import com.item.dao.model.Code;
import com.item.dao.model.CodeExample;
import com.item.dao.model.SysDict;
import com.item.dao.model.SysDictExample;
import com.item.service.CodeService;
import com.paidang.dao.GoodsMapper;
import com.paidang.dao.model.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @Auther: xuwenwei
 * @Date: 2018/8/6 08:29
 * @Description:
 */
@Component
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CacheService {

    private final static Logger logger = LoggerFactory.getLogger(CacheService.class);

    public  static List<String> expressList=new ArrayList<>();
    public  static Map<String, String> expressMap=new HashMap<>();


    @Autowired
    private SysDictMapper sysDictMapper;

    @PostConstruct
    public void load() {

        logger.info("[内存数据]-开始加载物流公司数据任务");
        try {
            loadData();
            logger.info("[内存数据]-物流公司加载完成");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public  void loadData() {
        SysDictExample example = new SysDictExample();
        example.createCriteria().andTypeEqualTo("express").andLabelNameEqualTo("express");
        List<SysDict> dicts = sysDictMapper.selectByExample(example);
        SysDict dict = dicts.get(0);
        Map<String, String> map = (Map) JSONObject.parse(dict.getValue());
        expressMap.clear();
        expressList.clear();
        expressMap.putAll(map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            expressList.add(entry.getKey());
        }

    }

}
