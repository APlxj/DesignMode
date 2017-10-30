package com.swallow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bean bean = new Bean.Builder()
                .setName("张三")
                .setAge(15)
                .setWeight(56)
                .setHeight(172)
                .setAddress("成都")
                .build();
    }
}
