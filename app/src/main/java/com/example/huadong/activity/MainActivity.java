package com.example.huadong.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.huadong.MainActivityAdapter;
import com.example.huadong.Mydatabase;
import com.example.huadong.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Fragment> fragmentList = new ArrayList<>();
    BlankFragmentUser userFragment;

    private Mydatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.main_vp);
        BottomNavigationView bottomNavigationView = findViewById(R.id.main_bnv);
        mydatabase = new Mydatabase(this, "Test.db", null, 1);
        mydatabase.getWritableDatabase();
        initData();
        MainActivityAdapter adapter = new MainActivityAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        //setOffscreenPageLimit控制viewPager缓存的数量。（以当前位置中心与隔壁相邻的数量）
        viewPager.setOffscreenPageLimit(3);
//        页面更改监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.menu_home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.menu_rich);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.menu_news);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.menu_user);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // 图标选择监听
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home) {
                    viewPager.setCurrentItem(0);
                } else if (item.getItemId() == R.id.menu_rich) {
                    viewPager.setCurrentItem(1);
                } else if (item.getItemId() == R.id.menu_news) {
                    viewPager.setCurrentItem(2);
                } else if (item.getItemId() == R.id.menu_user) {
                    userFragment.loadData();
                    viewPager.setCurrentItem(3);

                }
                return true;
            }
        });
    }

    private void initData() {
        BlankFragmentHome homeFragment = BlankFragmentHome.newInstance("首页", "");
        fragmentList.add(homeFragment);
        BlankFragmentStart richFragment = BlankFragmentStart.newInstance("开始", "");
        fragmentList.add(richFragment);
        BlankFragmentDisplay newsFragment = BlankFragmentDisplay.newInstance("展示", "");
        fragmentList.add(newsFragment);
        userFragment = BlankFragmentUser.newInstance("个人中心","");
        fragmentList.add(userFragment);
    }
}

