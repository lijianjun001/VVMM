package jetpack.zmkj.com.jetpack.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jetpack.zmkj.com.jetpack.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    private TextView loginTv1;
    private TextView nameTv1;
    private TextView nameTv2;

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
                mViewModel.login("11111","11111");
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.getUserMutableLiveData().observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(@Nullable UserEntity userEntity) {
                nameTv1.setText(userEntity.getFirstName());
                nameTv2.setText(userEntity.getLastName());
            }
        });//绑定数据，view不和model直接交互，通过viewModel交互
    }

}
