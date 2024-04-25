package com.example.huadong.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.been.HomeTestData;
import com.example.huadong.recycleView.HomeAdapter;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class BlankFragmentHome extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public Banner banner;
    private RecyclerView homeRecycleView;
    private List<HomeTestData> list =new ArrayList<>();

    private final List<Integer> banner_data =new ArrayList<Integer>();


    public BlankFragmentHome() {

    }
    public static BlankFragmentHome newInstance(String param1, String param2) {
        BlankFragmentHome fragment = new BlankFragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void setFullscreen(boolean isShowStatusBar, boolean isShowNavigationBar) {
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        if (!isShowStatusBar) {
            uiOptions |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        if (!isShowNavigationBar) {
            uiOptions |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        getActivity().getWindow().getDecorView().setSystemUiVisibility(uiOptions);

//        setNavigationStatusColor(Color.TRANSPARENT);
        getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        setFullscreen(true,true);




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_blank_home, container, false);
        return view;

    }




    private void DateInit() {
        HomeTestData homeTestData =new HomeTestData();
        homeTestData.setHomeTitle("老黄刀法精准，这牙膏我还能再挤十年");
        homeTestData.setHomeImage(R.drawable.intel_core);
        homeTestData.setHomeDay("2024/3/17");
        homeTestData.setHomeNum(999);
        HomeTestData homeTestData1 =new HomeTestData();
        homeTestData1.setHomeTitle("红色'农民崛起'，AMD yes！战未来");
        homeTestData1.setHomeImage(R.drawable.rx7900xtx);
        homeTestData1.setHomeDay("2024/3/16");
        homeTestData1.setHomeNum(999);
        HomeTestData homeTestData2 =new HomeTestData();
        homeTestData2.setHomeTitle("4060居然不敌3060ti？到底如何让我们揭晓");
        homeTestData2.setHomeImage(R.drawable.nvidia_4060);
        homeTestData2.setHomeDay("2024/1/17");
        homeTestData2.setHomeNum(999);
        HomeTestData homeTestData3 =new HomeTestData();
        homeTestData3.setHomeTitle("6750gre究极对决4060，谁强孰弱？");
        homeTestData3.setHomeImage(R.drawable.amd_6750gre);
        homeTestData3.setHomeDay("2024/3/15");
        homeTestData.setHomeNum(999);
        HomeTestData homeTestData4 =new HomeTestData();
        homeTestData4.setHomeTitle("4090究极生产力");
        homeTestData4.setHomeImage(R.drawable.rtx_4090);
        homeTestData4.setHomeDay("2024/3/14");
        homeTestData4.setHomeNum(999);
        list.add(homeTestData);
        list.add(homeTestData1);
        list.add(homeTestData2);
        list.add(homeTestData3);
        list.add(homeTestData4);

    }
    private void bannerInit(View view){
        homeRecycleView=view.findViewById(R.id.home_recycleView);
        homeRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        HomeAdapter homeAdapter=new HomeAdapter(list,getActivity());
        homeRecycleView.setAdapter(homeAdapter);
        DateInit();
        banner_data.add(R.drawable.intel_cpu);
        banner_data.add(R.drawable.nvidia_4060);
        banner_data.add(R.drawable.intel_cpu);
        banner_data.add(R.drawable.nvidia_4060);
        banner= view.findViewById(R.id.start_banner);
        banner.setAdapter(new BannerImageAdapter<Integer>(banner_data) {
            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }
        });
        banner.isAutoLoop(true);
        banner.setIndicator(new CircleIndicator(requireContext()));
        banner.setScrollBarFadeDuration(5000);
        banner.setIndicatorSelectedColor(Color.GREEN);
        banner.start();
        // Inflate the layout for this fragment
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bannerInit(view);

    }
}