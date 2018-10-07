package com.item.task;

import com.base.date.DateUtil;
import com.paidang.dao.model.GoodsExample;
import com.paidang.dao.model.Order;
import com.paidang.dao.model.OrderExample;
import com.paidang.daoEx.model.OrderEx;
import com.paidang.daoEx.model.UserPawnEx;
import com.paidang.service.GoodsService;
import com.paidang.service.OrderService;
import com.util.PaidangConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GoodsCron {
    private static Logger logger = LoggerFactory.getLogger(GoodsCron.class);

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表查询
     */
    //每24小时执行一次 0 */1 * * * ?
    public void pawn(){
        long start = System.currentTimeMillis();

        //查询24小时未付款的订单
        OrderExample example = new OrderExample();
        example.createCriteria().andStateEqualTo(1);

        Map<String, Object> map = new HashMap<>();
        map.put("time", DateUtil.offsetSecond(new Date(),-PaidangConst.ORDER_TIME));
        List<OrderEx> list =   orderService.selectByTask(map);

        for (OrderEx ex : list){
                ex.setState(-1);
                orderService.updateByPrimaryKeySelective(ex);
            }

        }

}
