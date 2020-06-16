package jetpack.zmkj.com.jetpack.http;

import java.util.List;

public class SpecModel {

    private List<SpecEntity>spec;
    private String subTitle;

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
