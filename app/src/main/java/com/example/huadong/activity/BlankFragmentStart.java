package com.example.huadong.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.huadong.R;
import com.example.huadong.untils.OrderDataBase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentStart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentStart extends Fragment {
    public Button btn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentStart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentStart newInstance(String param1, String param2) {
        BlankFragmentStart fragment = new BlankFragmentStart();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view =inflater.inflate(R.layout.fragment_blank_start,container,false);
        btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long timestamp = System.currentTimeMillis();
                int time =(int)timestamp;
                OrderDataBase.getInstance(getActivity()).infoParts("瑷珈4060ti",time,R.drawable.nvidia_4060,"显卡","RTX 4060 Ti 是一款显卡，拥有 4352 CUDA 核心，配备 8GB / 16GB 128bit GDDR6 显存，TGP 功耗 160W / 165W，采用 PCIe 4.08 连接，售价 3199 元起，5 月 24 日开卖。 RTX 4060 显卡拥有 3072 CUDA 核心，配备 8GB GDDR6 128bit 显存，功耗 115W，采用 PCIe 4.08 连接，售价 2399 元起，7 月上市","2023/7",2399);
                OrderDataBase.getInstance(getActivity()).infoParts("铭瑄电竞之心",time,R.drawable.nvidia_4060,"显卡","铭瑄电竞之心","2023/7",2199);
                OrderDataBase.getInstance(getActivity()).infoParts("铭瑄电竞终结者",time,R.drawable.nvidia_4060,"显卡","铭瑄电竞终结者","2023/7",2399);
                OrderDataBase.getInstance(getActivity()).infoParts("猛禽",time,R.drawable.nvidia_4060,"显卡","猛禽","2023/7",2499);
                Log.d("点击了","点击了按钮");
                Intent intent =new Intent(getActivity(),ToolsActivity.class);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}