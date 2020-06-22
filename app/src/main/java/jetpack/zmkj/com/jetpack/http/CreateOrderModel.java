package jetpack.zmkj.com.jetpack.http;

public class CreateOrderModel {
    private String orderNo;
    private String orderId;
    private String ifCanSaveTea;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getIfCanSaveTea() {
        return ifCanSaveTea;
    }

    public void setIfCanSaveTea(String ifCanSaveTea) {
        this.ifCanSaveTea = ifCanSaveTea;
    }
}
