package jetpack.zmkj.com.jetpack.http;

import java.util.List;

public class BuyIngDetailVoEntity {

    private AddressModel addresses;
    private float freight;
    private String freightContent;
    private List<OrderGoodModel>goods;
    private int isInvoice;
    private String remark;
    private double totalFee;

    public AddressModel getAddresses() {
        return addresses;
    }

    public void setAddresses(AddressModel addresses) {
        this.addresses = addresses;
    }

    public float getFreight() {
        return freight;
    }

    public void setFreight(float freight) {
        this.freight = freight;
    }

    public String getFreightContent() {
        return freightContent;
    }

    public void setFreightContent(String freightContent) {
        this.freightContent = freightContent;
    }

    public List<OrderGoodModel> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderGoodModel> goods) {
        this.goods = goods;
    }

    public int getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(int isInvoice) {
        this.isInvoice = isInvoice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }
}
