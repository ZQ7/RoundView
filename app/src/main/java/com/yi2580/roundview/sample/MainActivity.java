package com.yi2580.roundview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.yi2580.roundview.EnabledTextView;
import com.yi2580.roundview.RoundTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RoundTextView rt1;
    RoundTextView rt2;
    RoundTextView rt3;
    RoundTextView rtSetting;
    EnabledTextView rt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        rt1 = (RoundTextView) findViewById(R.id.tv_main_1);
        rt1.setOnClickListener(this);
        rt2 = (RoundTextView) findViewById(R.id.tv_main_2);
        rt2.setOnClickListener(this);
        rt3 = (RoundTextView) findViewById(R.id.tv_main_3);
        rt3.setOnClickListener(this);
        rtSetting = (RoundTextView) findViewById(R.id.tv_main_setting);
        rtSetting.setOnClickListener(this);
        rt4 = (EnabledTextView) findViewById(R.id.tv_main_4);
        rt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_main_1:
                rt1.setSelected(!rt1.isSelected());
                break;
            case R.id.tv_main_2:
                rt2.setSelected(!rt2.isSelected());
                break;
            case R.id.tv_main_3:
                rt3.setSelected(!rt3.isSelected());
                break;
            case R.id.tv_main_setting:
                rt4.setEnabled(!rt4.isEnabled());
                break;
            case R.id.tv_main_4:
                Toast.makeText(this,"登录",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
