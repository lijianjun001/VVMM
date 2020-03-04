package jetpack.zmkj.com.jetpack;

public class Page {

    public static int PAGE_INIT = 1;
    private int pageIndex = PAGE_INIT;
    private int totalPage = Integer.MAX_VALUE;

    public Page() {
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Page(int totalPage) {
        this.totalPage = totalPage;
    }

    private boolean canLoad() {
        return pageIndex <= totalPage;
    }

    public void loadNextPage(OnLoadListener onLoadListener) {
        if (canLoad()) {
            pageIndex++;
            if (onLoadListener != null) {
                onLoadListener.onLoad();
            }
        }
    }

    public boolean hasNextPage() {
        return pageIndex < totalPage;
    }

    public interface OnLoadListener {
        void onLoad();
    }

    public int getPageIndex() {
        return pageIndex;
    }


    public void reset() {
        pageIndex = PAGE_INIT;
    }
}
