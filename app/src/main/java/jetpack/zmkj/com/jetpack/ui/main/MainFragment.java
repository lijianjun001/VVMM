package jetpack.zmkj.com.jetpack.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    private TextView addUserTv;
    private TextView get_goods_tv;
    private TextView get_goods_detail_tv;
    private TextView get_address_tv;
    private TextView createOrderTv;
    private TextView pre_create_order_tv;
    private TextView pre_create_coupon_tv;

    private EditText nameEt, passwordEt;

    private Map<String, String> users = new HashMap<>();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        nameEt = view.findViewById(R.id.name_et);
        passwordEt = view.findViewById(R.id.password_et);
        addUserTv = view.findViewById(R.id.add_user_tv);
        loginTv = view.findViewById(R.id.login_tv);
        get_goods_tv = view.findViewById(R.id.get_goods_tv);
        get_goods_detail_tv = view.findViewById(R.id.get_goods_detail_tv);
        get_address_tv = view.findViewById(R.id.get_address_tv);
        pre_create_order_tv = view.findViewById(R.id.pre_create_order_tv);
        createOrderTv = view.findViewById(R.id.create_order_tv);
        pre_create_coupon_tv = view.findViewById(R.id.pre_create_coupon_tv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 10);
        calendar.set(Calendar.MINUTE, 20);

        long delay = calendar.getTimeInMillis() - date.getTime();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewModel.createOrder();
            }
        }, delay);

        users.put("13260213625", "G20W1auq/PLzs8Py");

        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Map.Entry<String, String> entry : users.entrySet()) {
                    mViewModel.login(entry.getKey(), entry.getValue());
                }

            }
        });

        mViewModel.getUserMutableLiveData().observe(this.getViewLifecycleOwner(), new Observer<LoginModel>() {
            @Override
            public void onChanged(@Nullable LoginModel loginModel) {

            }
        });//绑定数据，view不和model直接交互，通过viewModel交互

        addUserTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users.put(nameEt.getText().toString(), passwordEt.getText().toString());

                mViewModel.login(nameEt.getText().toString(), passwordEt.getText().toString());
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
        get_address_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mViewModel.getAddress();
            }
        });

        pre_create_order_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mViewModel.preCreateOrder();
            }
        });

        pre_create_coupon_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mViewModel.getCoupon();
            }
        });
        createOrderTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mViewModel.createOrder();
            }
        });

    }


}
