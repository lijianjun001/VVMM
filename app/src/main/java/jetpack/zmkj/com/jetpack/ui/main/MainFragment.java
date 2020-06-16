package jetpack.zmkj.com.jetpack.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import jetpack.zmkj.com.jetpack.R;
import jetpack.zmkj.com.jetpack.http.LoginModel;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;


    private TextView loginTv;
    private TextView getVCodeTv;
    private TextView get_goods_tv;
    private TextView get_goods_detail_tv;
    private TextView createOrderTv;

    private EditText nameEt, vCodeEt;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        nameEt = view.findViewById(R.id.name_et);
        vCodeEt = view.findViewById(R.id.v_code_et);
        getVCodeTv = view.findViewById(R.id.get_v_code_tv);
        loginTv = view.findViewById(R.id.login_tv);
        get_goods_tv = view.findViewById(R.id.get_goods_tv);
        get_goods_detail_tv = view.findViewById(R.id.get_goods_detail_tv);
        createOrderTv = view.findViewById(R.id.create_order_tv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.login("13260213625", "G20W1auq/PLzs8Py");
            }
        });

        mViewModel.getUserMutableLiveData().observe(this.getViewLifecycleOwner(), new Observer<LoginModel>() {
            @Override
            public void onChanged(@Nullable LoginModel loginModel) {

            }
        });//绑定数据，view不和model直接交互，通过viewModel交互

        getVCodeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.getVCode(nameEt.getText().toString());
            }
        });

        get_goods_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.getGoods();
            }
        });

        get_goods_detail_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mViewModel.getGoodsDetail();
            }
        });

        createOrderTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mViewModel.getGoodsDetail();
            }
        });

    }


}
