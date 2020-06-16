package jetpack.zmkj.com.jetpack.http;

public class HomeDataModel {
    private HomeDataEntity homeData;
    private int userType;


    public HomeDataEntity getHomeData() {
        return homeData;
    }

    public void setHomeData(HomeDataEntity homeData) {
        this.homeData = homeData;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
