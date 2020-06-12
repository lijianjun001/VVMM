package jetpack.zmkj.com.jetpack.http;

public class CategoryModel {
    private String categoryAbName;

    private GoodImgModel categoryBanner;
    private GoodImgModel categoryIcon;
    private String categoryBannerType;
    private String categoryId;
    private String categoryName;

    public String getCategoryAbName() {
        return categoryAbName;
    }

    public void setCategoryAbName(String categoryAbName) {
        this.categoryAbName = categoryAbName;
    }

    public GoodImgModel getCategoryBanner() {
        return categoryBanner;
    }

    public void setCategoryBanner(GoodImgModel categoryBanner) {
        this.categoryBanner = categoryBanner;
    }

    public GoodImgModel getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(GoodImgModel categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public String getCategoryBannerType() {
        return categoryBannerType;
    }

    public void setCategoryBannerType(String categoryBannerType) {
        this.categoryBannerType = categoryBannerType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
