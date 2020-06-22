package jetpack.zmkj.com.jetpack.http;

import java.util.List;

public class GoodsDetailEntity {
    private String detailHtml;
    private String detailHtmlPC;
    private String goodsName;
    private String id;
    private String itemNo;

    private List<PropertyModel> property;
    private List<ServiceModel> service;

    private List<GoodImgModel> slideshow;
    private List<GoodImgModel> slideshowPC;

    private List<SpecEntity> spec;
    private String subTitle;

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml;
    }

    public String getDetailHtmlPC() {
        return detailHtmlPC;
    }

    public void setDetailHtmlPC(String detailHtmlPC) {
        this.detailHtmlPC = detailHtmlPC;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public List<PropertyModel> getProperty() {
        return property;
    }

    public void setProperty(List<PropertyModel> property) {
        this.property = property;
    }

    public List<ServiceModel> getService() {
        return service;
    }

    public void setService(List<ServiceModel> service) {
        this.service = service;
    }

    public List<GoodImgModel> getSlideshow() {
        return slideshow;
    }

    public void setSlideshow(List<GoodImgModel> slideshow) {
        this.slideshow = slideshow;
    }

    public List<GoodImgModel> getSlideshowPC() {
        return slideshowPC;
    }

    public void setSlideshowPC(List<GoodImgModel> slideshowPC) {
        this.slideshowPC = slideshowPC;
    }

    public List<SpecEntity> getSpec() {
        return spec;
    }

    public void setSpec(List<SpecEntity> spec) {
        this.spec = spec;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
