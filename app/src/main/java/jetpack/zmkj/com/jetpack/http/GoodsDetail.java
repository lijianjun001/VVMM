package jetpack.zmkj.com.jetpack.http;

public class GoodsDetail {
    private int userType;
    private GoodsDetailEntity goodsDetail;
    private String vasId;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public GoodsDetailEntity getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(GoodsDetailEntity goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getVasId() {
        return vasId;
    }

    public void setVasId(String vasId) {
        this.vasId = vasId;
    }
}
