package jetpack.zmkj.com.jetpack.http;

import java.util.List;

public class HomeDataEntity {

    private List<Banner> banner;
    private List<CategoryModel> category;
    private NewGoodsModel newgoods;
    private List<Normalgoods> normalgoods;
    private int userType;


    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public List<CategoryModel> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryModel> category) {
        this.category = category;
    }

    public NewGoodsModel getNewgoods() {
        return newgoods;
    }

    public void setNewgoods(NewGoodsModel newgoods) {
        this.newgoods = newgoods;
    }

    public void setNormalgoods(List<Normalgoods> normalgoods) {
        this.normalgoods = normalgoods;
    }


    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
