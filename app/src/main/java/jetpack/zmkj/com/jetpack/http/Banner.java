package jetpack.zmkj.com.jetpack.http;

import java.util.List;

public class Banner {
    private String bizId;//商品id
    private List<Goods> goods;
    private String h5Url;
    private String id;
    private GoodImgModel img;
    private int platform;
    private int pushType;
    private String title;
    private int type;


    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
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

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public int getPushType() {
        return pushType;
    }

    public void setPushType(int pushType) {
        this.pushType = pushType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
