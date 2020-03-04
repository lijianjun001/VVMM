package jetpack.zmkj.com.jetpack.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import jetpack.zmkj.com.jetpack.R;

public class UserAdapter extends PagedListAdapter<User, UserHolder> {


    protected UserAdapter() {
        super(DIFF_CALLBACK);
    }

    protected UserAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    protected UserAdapter(@NonNull AsyncDifferConfig<User> config) {
        super(config);
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {

        User user = getItem(position);

    }

    private static DiffUtil.ItemCallback<User> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<User>() {
                @Override
                public boolean areItemsTheSame(User oldUser, User oneUser) {
                    return oldUser.getUid() == oneUser.getUid();
                }

                @Override
                public boolean areContentsTheSame(User oldUser,
                                                  User oneUser) {
                    return oldUser.equals(oneUser);
                }
            };

}
