package com.example.huadong.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.huadong.R;
import com.example.huadong.been.DisplayListTestData;
import com.example.huadong.been.DisplayTestData;
import com.example.huadong.recycleView.DisplayAdapter;
import com.example.huadong.recycleView.DisplayListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentDisplay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentDisplay extends Fragment {
    private RecyclerView display_recycleView,display_recycleView_list;
    private List<DisplayListTestData> list_img =new ArrayList<>();
    private final DisplayListAdapter displayListAdapter=new DisplayListAdapter(list_img);


    private final List<DisplayTestData> list =new ArrayList<>();

    private final DisplayAdapter displayAdapter=new DisplayAdapter(list);


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentDisplay() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment4.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentDisplay newInstance(String param1, String param2) {
        BlankFragmentDisplay fragment = new BlankFragmentDisplay();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_display, container, false);
        return view ;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        SearchView searchView =(SearchView) view.findViewById(R.id.searchView);
        DataInit();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
                //这里return false不需要修改，false的作用是当你输入要搜索的文字点击搜索按钮后，手机键盘会自动消失，你把false改成true，键盘不会消失。
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                //此方法的作用是对搜索框里的文字实时监听

                return false;
            }
        });
        display_recycleView=view.findViewById(R.id.display_recycleView);
        display_recycleView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        display_recycleView.setAdapter(displayAdapter);
}

    private void DataInit() {
        DisplayListTestData displayListTestData1 =new DisplayListTestData();
        DisplayListTestData displayListTestData2 =new DisplayListTestData();
        displayListTestData1.setImg(R.drawable.nvidia_4060);
        displayListTestData2.setImg(R.drawable.intel_cpu);
        list_img.add(displayListTestData1);
        list_img.add(displayListTestData2);


        DisplayTestData displayTestData=new DisplayTestData();
        displayTestData.setDisplay_avatar(R.drawable.display_user_img_gwen);
        displayTestData.setDisplay_img(list_img);
        displayTestData.setDisplay_userName("YSLC");
        displayTestData.setDisplay_title("i9-14900k+RTX4090 超级生产力");
        displayTestData.setDisplay_user_price("￥11999");
        displayTestData.setDisplay_user_ThumbsUpNun("999");
        list.add(displayTestData);

        DisplayTestData displayTestData1=new DisplayTestData();
        displayTestData1.setDisplay_avatar(R.drawable.nvidia_4060);
        displayTestData1.setDisplay_img(list_img);
        displayTestData1.setDisplay_userName("XHX");
        displayTestData1.setDisplay_user_price("￥4699");
        displayTestData1.setDisplay_title("i5-12490k+RTX4060ti" +"牙膏是要挤的，但是性能还是够的");
        displayTestData1.setDisplay_user_ThumbsUpNun("999");
        list.add(displayTestData1);

        DisplayTestData displayTestData2=new DisplayTestData();
        displayTestData2.setDisplay_avatar(R.drawable.nvidia_4060);
        displayTestData2.setDisplay_img(list_img);
        displayTestData2.setDisplay_userName("XHX");
        displayTestData2.setDisplay_user_price("￥4699");
        displayTestData2.setDisplay_title("i5-12490k+RTX4060ti" +"牙膏是要挤的，但是性能还是够的");
        displayTestData2.setDisplay_user_ThumbsUpNun("999");
        list.add(displayTestData2);
    }
}