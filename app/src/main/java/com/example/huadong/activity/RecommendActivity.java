package com.example.huadong.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.huadong.R;
import com.example.huadong.untils.OrderDataBase;

public class RecommendActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        Init();
    }

    private void Init() {
        toolbar = findViewById(R.id.recommend_back);
        webView =  findViewById(R.id.recommend_detail);
        String name = getIntent().getStringExtra("name");
        toolbar.setTitle(name);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.loadUrl( OrderDataBase.getInstance(RecommendActivity.this).getWebView(name));
//        https://zhuanlan.zhihu.com/p/630784566
//        webView.loadUrl("https://zhuanlan.zhihu.com/p/630784566");
    }
}