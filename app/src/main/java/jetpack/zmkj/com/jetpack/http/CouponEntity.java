package jetpack.zmkj.com.jetpack.http;

public class CouponEntity {
    private String categoryId;
    private int expiryDays;
    private String goodsId;
    private String id;
    private long invalidTime;
    private String name;
    private String ruleDesc;//茶具类20元代金券
    private String scope;
    private String tid;
    private int type;
    private int usableOrigin;
    private int[] usePlatform;
    private String value;


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getExpiryDays() {
        return expiryDays;
    }

    public void setExpiryDays(int expiryDays) {
        this.expiryDays = expiryDays;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(long invalidTime) {
        this.invalidTime = invalidTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUsableOrigin() {
        return usableOrigin;
    }

    public void setUsableOrigin(int usableOrigin) {
        this.usableOrigin = usableOrigin;
    }

    public int[] getUsePlatform() {
        return usePlatform;
    }

    public void setUsePlatform(int[] usePlatform) {
        this.usePlatform = usePlatform;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
