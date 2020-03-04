package jetpack.zmkj.com.jetpack.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import jetpack.zmkj.com.jetpack.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;


    private TextView loginTv1;
    private TextView nameTv1;
    private TextView nameTv2;
    private RecyclerView recyclerView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        loginTv1 = view.findViewById(R.id.login_tv);
        nameTv1 = view.findViewById(R.id.first_name_tv);
        nameTv2 = view.findViewById(R.id.last_name_tv);
        loginTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.login("11111", "11111");
            }
        });
        recyclerView = view.findViewById(R.id.recyclerView);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.getUserMutableLiveData().observe(this.getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                nameTv1.setText(user.getFirstName());
                nameTv2.setText(user.getLastName());
            }
        });//绑定数据，view不和model直接交互，通过viewModel交互
        final UserAdapter userAdapter = new UserAdapter();
        mViewModel.userList.observe(this, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(PagedList<User> users) {
                userAdapter.submitList(users);
            }
        });
        recyclerView.setAdapter(userAdapter);
    }

}
