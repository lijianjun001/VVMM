package jetpack.zmkj.com.jetpack.http;

public class LoginModel {

    private UserEntity user;
    private String sid;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
