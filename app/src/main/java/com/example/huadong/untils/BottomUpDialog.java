package com.example.huadong.untils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.huadong.R;

public class BottomUpDialog extends Dialog {

    public BottomUpDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_bottom_up);

        // 设置弹窗的宽度和高度等属性
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.BOTTOM; // 位于底部
            window.setAttributes(params);
        }

        // 设置弹窗动画
//        getWindow().getAttributes().windowAnimations = R.style.BottomUpDialogAnimation;
    }
}

