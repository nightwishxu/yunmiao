package com.item.task;

import com.base.cron.task.Task;
import com.paidang.service.ExpressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpressCron {
    private static Logger logger = LoggerFactory.getLogger(ExpressCron.class);

    @Autowired
    private ExpressService expressService;

    /**
     * 定时查询快递
     */
    public void query(){
        logger.debug("查询快递");
        expressService.queryAuto();
    }

    //查询更新机构从平台取回绝当品的快递状态
    public void updateOrgFetchBackExpress(){
        logger.debug("查询快递--机构取回");
        expressService.updateOrgFetchBackExpress();
    }
    //更新快递表机构/平台寄给当户的数据，并更新相应字段
    public void updateSendToWinnerExpress(){
        logger.debug("查询快递--机构/平台寄给当户");
        expressService.updateSendToWinnerExpress();
    }


}
