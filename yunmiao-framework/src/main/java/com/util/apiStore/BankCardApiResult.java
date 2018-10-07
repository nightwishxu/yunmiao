package com.util.apiStore;

/**
 * 接口返回
 */
public class BankCardApiResult {
    /**
     * 0代表成功
     */
    private int error_code;
    private String reason;
    private BankCardResult result;
    private String ordersign;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BankCardResult getResult() {
        return result;
    }

    public void setResult(BankCardResult result) {
        this.result = result;
    }

    public String getOrdersign() {
        return ordersign;
    }

    public void setOrdersign(String ordersign) {
        this.ordersign = ordersign;
    }
}
