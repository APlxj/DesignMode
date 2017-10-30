package com.swallow.client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.swallow.R;
import com.swallow.factory.IGenerator;
import com.swallow.factory.ProductGenerator;
import com.swallow.model.AndroidPhone;
import com.swallow.model.IPhone;
import com.swallow.model.IosPhone;
import com.swallow.model.MyPhone;
import com.swallow.model.SanbPhone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IGenerator iGenerator = new ProductGenerator();
        try {
            IPhone phone = (IPhone) iGenerator.generateIPhone(AndroidPhone.class);
            String name = phone.getName();
            Log.e("phone.name=", name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            IPhone phone = (IPhone) iGenerator.generateIPhone(IosPhone.class);
            String name = phone.getName();
            Log.e("phone.name=", name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            IPhone phone = (IPhone) iGenerator.generateIPhone(SanbPhone.class);
            String name = phone.getName();
            Log.e("phone.name=", name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            MyPhone phone = (MyPhone) iGenerator.generateIPhone(MyPhone.class);
            String name = phone.getPhoneName();
            Log.e("phone.name=", name);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
