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
        webView.loadUrl("https://ms.mbd.baidu.com/r/1i1wbpkbJUQ?f=cp&u=f415030d9d391153&urlext=%7B%22cuid%22%3A%22_uHYugucS80IOvizgaS9ulPjvu_6PStQ_avlijiOBfKo0qqSB%22%7D");
    }
}