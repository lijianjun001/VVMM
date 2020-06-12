package jetpack.zmkj.com.jetpack.http;

import java.util.List;

public class Normalgoods {

    private List<Goods> goods;
    private GoodImgModel icon;
    private int moduleType;
    private int rowsNumber;
    private int styleType;
    private String subTitle;
    private String title;

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public GoodImgModel getIcon() {
        return icon;
    }

    public void setIcon(GoodImgModel icon) {
        this.icon = icon;
    }

    public int getModuleType() {
        return moduleType;
    }

    public void setModuleType(int moduleType) {
        this.moduleType = moduleType;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public void setRowsNumber(int rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    public int getStyleType() {
        return styleType;
    }

    public void setStyleType(int styleType) {
        this.styleType = styleType;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
