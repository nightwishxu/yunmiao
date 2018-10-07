package com.paidang.utils;

import com.base.date.DateUnit;
import com.base.date.DateUtil;
import com.util.PaidangConst;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Lee on 2017/11/20.
 */
public class CostGenerator {

    private static final BigDecimal MIN_COST = new BigDecimal("0.01");

    //求综合费和赎当利息 本金principal不能小于0，利率rate传百分数且不能小于0，pawnMonth是当期数，必须为正整数
    public static BigDecimal getInterest(BigDecimal principal, BigDecimal rate, Integer pawnMonth){
        BigDecimal total;
        if(principal == null || rate == null || pawnMonth == null)
            return null;
        if (principal.compareTo(BigDecimal.ZERO) == -1)
            return null;
        if (rate.compareTo(BigDecimal.ZERO) == -1)
            return null;
        if (pawnMonth <= 0 || pawnMonth % 1 != 0 )
            return null;
        if(pawnMonth % 2 == 0){
            total = principal.multiply(rate.divide(new BigDecimal("100"))).multiply(new BigDecimal(pawnMonth/2));
        }else {
            //一个当期（15天）的综合费
            BigDecimal halfMonthInterest = principal.multiply(rate.divide(new BigDecimal("100"))).divide(new BigDecimal("2"));
            if (pawnMonth == 1){
                total =  halfMonthInterest;
            }else {
                BigDecimal integralPart = principal.multiply(rate.divide(new BigDecimal("100"))).multiply(new BigDecimal(pawnMonth/2));
                total = integralPart.add(halfMonthInterest);
            }
        }
        total = total.setScale(2,BigDecimal.ROUND_HALF_UP);//四舍五入，保留2位小数
        if (total.compareTo(MIN_COST) == -1){//若四舍五入后仍然小于一分钱，返回一分钱
            total = new BigDecimal("0.01");
        }
        return total;
    }

    //计算逾期费
    public static BigDecimal getOverdue(BigDecimal principal,Date expiryDate,BigDecimal redeemRate){
        Date today = new Date();
        BigDecimal overdue;
        if (expiryDate == null || principal == null || redeemRate == null)
            return null;
        if (principal.compareTo(BigDecimal.ZERO) == -1)
            return null;
        if(today.before(expiryDate)){// 未逾期
            return new BigDecimal("0");
        }else{
            long l = DateUtil.between(today,expiryDate, DateUnit.DAY);
            if (l > PaidangConst.BUFFER_DAYS){
                l = PaidangConst.BUFFER_DAYS;
            }
//          overdue =  principal.multiply(PaidangConst.REDEEM_OVERRATE.divide(new BigDecimal("1000"))).multiply(new BigDecimal(l));
            overdue =  principal.multiply(redeemRate.divide(new BigDecimal("1000"))).multiply(new BigDecimal(l));
        }
        overdue = overdue.setScale(2,BigDecimal.ROUND_HALF_UP);
        if (overdue.compareTo(MIN_COST) == -1){//若四舍五入后仍然小于一分钱，返回一分钱
            overdue = new BigDecimal("0.01");
        }
        return overdue;
    }

    //平台服务费
    public static BigDecimal getPlatformFee(BigDecimal amount){
        if (amount == null)
            return null;
        BigDecimal platformFee = amount.multiply(PaidangConst.PLATFORM_INTEREST);
        return platformFee.setScale(2,BigDecimal.ROUND_HALF_UP);
    }


    public static void main(String[] args) {
/*        System.out.println(getInterest(new BigDecimal("8888"),new BigDecimal("2.1"),1).toString());
       // System.out.println(new BigDecimal("0.415").setScale(2,BigDecimal.ROUND_HALF_UP).toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");

        Date date=null;
        try {
             date = dateFormat.parse("2017-12-1 13:24:16");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(DateUtil.between(new Date(),date, DateUnit.DAY));
        System.out.println(getOverdue(new BigDecimal("1000"),date));
        */
    }

}
