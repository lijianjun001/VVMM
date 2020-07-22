package jetpack.zmkj.com.jetpack;


import io.reactivex.disposables.CompositeDisposable;

public class AccountManager {
    private static volatile AccountManager accountManager;

    public AccountManager() {

    }

    public static AccountManager getInstance() {
        if (accountManager == null) {
            synchronized (AccountManager.class) {
                if (accountManager == null) {
                    accountManager = new AccountManager();
                }
            }
        }
        return accountManager;
    }


    public String getToken() {

        return null;
    }

}
