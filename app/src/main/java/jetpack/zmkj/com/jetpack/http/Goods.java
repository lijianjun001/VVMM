package jetpack.zmkj.com.jetpack.http;

public class Goods {
    private String coinState;
    private String gcPrice;
    private String id;
    private GoodImgModel img;
    private boolean isAllProductDown;
    private boolean isOpenUPVas;
    private String name;
    private double ncPrice;
    private String param;
    private String subTitle;

    public String getCoinState() {
        return coinState;
    }

    public void setCoinState(String coinState) {
        this.coinState = coinState;
    }

    public String getGcPrice() {
        return gcPrice;
    }

    public void setGcPrice(String gcPrice) {
        this.gcPrice = gcPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GoodImgModel getImg() {
        return img;
    }

    public void setImg(GoodImgModel img) {
        this.img = img;
    }

    public boolean isAllProductDown() {
        return isAllProductDown;
    }

    public void setAllProductDown(boolean allProductDown) {
        isAllProductDown = allProductDown;
    }

    public boolean isOpenUPVas() {
        return isOpenUPVas;
    }

    public void setOpenUPVas(boolean openUPVas) {
        isOpenUPVas = openUPVas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNcPrice() {
        return ncPrice;
    }

    public void setNcPrice(double ncPrice) {
        this.ncPrice = ncPrice;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
