package jetpack.zmkj.com.jetpack.ui.main;

import java.util.List;

import jetpack.zmkj.com.jetpack.http.AddressModel;
import jetpack.zmkj.com.jetpack.http.OrderGoodModel;

public class CreateOrderModel2 {

    private AddressModel addressModel;
    private List<OrderGoodModel> goods;
    private float freight;
    private double totalFee;
    private String addressId;
    private String invoiceId;//发票
    private String teaCouponId;
    private String type;
    private String uid;
    private String sid;


    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public List<OrderGoodModel> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderGoodModel> goods) {
        this.goods = goods;
    }

    public float getFreight() {
        return freight;
    }

    public void setFreight(float freight) {
        this.freight = freight;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getTeaCouponId() {
        return teaCouponId;
    }

    public void setTeaCouponId(String teaCouponId) {
        this.teaCouponId = teaCouponId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
