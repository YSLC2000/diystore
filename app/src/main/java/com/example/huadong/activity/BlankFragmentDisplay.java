package com.example.huadong.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.huadong.R;
import com.example.huadong.been.DisplayListTestData;
import com.example.huadong.been.DisplayTestData;
import com.example.huadong.recycleView.DisplayAdapter;
import com.example.huadong.recycleView.DisplayListAdapter;
import com.example.huadong.recycleView.OrderAdapter;
import com.example.huadong.untils.OrderDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentDisplay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentDisplay extends Fragment {
    private RecyclerView display_recycleView;
    private List<DisplayTestData> list =new ArrayList<>();
    private DisplayAdapter displayAdapter;
    private Button btn_flush,btn_search;
    private android.widget.SearchView searchView;
    private List<DisplayTestData> search_data;




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
        btn_flush =view.findViewById(R.id.flush);
        btn_search=view.findViewById(R.id.search_btn);

        SearchView searchView =(SearchView) view.findViewById(R.id.searchView);
//        DataInit();
        list= OrderDataBase.getInstance(getActivity()).share_display();
        Log.d("DataInit",list.toString());
        displayAdapter = new DisplayAdapter(list,getActivity());
        btn_flush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadData();
                Toast.makeText(getActivity(),"点击了flush按钮",Toast.LENGTH_SHORT).show();
            }
        });
        display_recycleView=view.findViewById(R.id.display_recycleView);
        display_recycleView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        display_recycleView.setAdapter(displayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
                //这里return false不需要修改，false的作用是当你输入要搜索的文字点击搜索按钮后，手机键盘会自动消失，你把false改成true，键盘不会消失。
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                //此方法的作用是对搜索框里的文字实时监听

                search_data=OrderDataBase.getInstance(getActivity()).displaySearch(newText);
                Log.d("search_data",search_data.toString());
                return false;
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(search_data==null){
                    Toast.makeText(getActivity(),"请输入搜索内容",Toast.LENGTH_SHORT).show();
                }else {
                    displayAdapter.setDisplayAdapter(search_data,getActivity());
                    display_recycleView.setAdapter(displayAdapter);
                }

            }
        });

}

    public void LoadData(){
        List<DisplayTestData> list=OrderDataBase.getInstance(getActivity()).share_display();
        displayAdapter.setDisplayAdapter(list,getActivity());
        display_recycleView.setAdapter(displayAdapter);
    }
}