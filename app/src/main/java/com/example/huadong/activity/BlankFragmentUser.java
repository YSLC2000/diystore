package com.example.huadong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.been.OrderData;
import com.example.huadong.been.UserInfo;
import com.example.huadong.recycleView.OrderAdapter;
import com.example.huadong.untils.OrderDataBase;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentUser extends Fragment {
    List<String> order = new ArrayList<>();
    List<String> test = new ArrayList<>();

    JSONObject jsonObject;
    OrderAdapter orderAdapter = new OrderAdapter();

    private RecyclerView orderRecycleView;
    private TextView textView;
    public Button btn_manage;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentUser() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment5.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentUser newInstance(String param1, String param2) {
        BlankFragmentUser fragment = new BlankFragmentUser();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        try {
//            order = OrderDataBase.getInstance(getContext()).order_display();
//            for (int i = 0; i < order.size(); i++) {
//                String str = order.get(i);
//                jsonObject = new JSONObject(str);
//                String data = jsonObject.getString("order_name");
//                Gson gson = new Gson();
//                OrderTestData orderTestData = gson.fromJson(String.valueOf(jsonObject), OrderTestData.class);
//
//
//                Log.d("order_table表遍历数据", orderTestData.toString());
//            }

        //将数据库保存对象转化为json对象


//            jsonObject.getString("order_id");

//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=view.findViewById(R.id.user_name);
        textView.setText(UserInfo.getsUserInfo().getUsername());
        orderRecycleView = view.findViewById(R.id.order_recycleview);
        orderRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        orderRecycleView.setAdapter(orderAdapter);
        orderRecycleView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        loadData();
        orderAdapter.setOnItemClickListener(new OrderAdapter.onItemClickListener() {
            @Override
            public void onItemClick(OrderData orderData, int position) {
                Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
                Log.d("OrderDetailsActivity",orderData.toString());
                intent.putExtra("orderData", orderData);
                startActivity(intent);
            }

            @Override
            public int delete(OrderData orderData, int position) {
                  int i =  OrderDataBase.getInstance(getActivity()).delete_order(orderData.getOrder_name()+"");
                  loadData();
                  return i;
            }

            @Override
            public int share(OrderData orderData, int position) {
                String sysTime = String.valueOf(System.currentTimeMillis());
                String user_name=UserInfo.getsUserInfo().getUsername();
                String orderName=orderData.getOrder_name();
                int row = OrderDataBase.getInstance(getActivity()).addShare(user_name,sysTime,orderName,orderName,"R.drawable.nvidia_4060",String.valueOf(orderData.getOrder_price()),999);
                loadData();
//                OrderDataBase.getInstance(getActivity()).commentsInfo((int)System.currentTimeMillis(),user_name,orderName,1,String.valueOf(System.currentTimeMillis()),String.valueOf(System.currentTimeMillis()),"shiwo","test");

                return row;
            }
        });
    }


    public void loadData() {
        UserInfo userInfo= UserInfo.getsUserInfo();
        String login_name = userInfo.getUsername();
        List<OrderData> list = OrderDataBase.instance.queryCarList(login_name);
        orderAdapter.setOrderAdapter(list,getActivity());
        orderRecycleView.setAdapter(orderAdapter);
    }
}