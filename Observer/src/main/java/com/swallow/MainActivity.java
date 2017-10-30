package com.swallow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ILinster {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Observable<Weather> observable = new Observable<Weather>();
        Observer<Weather> observer1 = new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {
                System.out.println("观察者1：" + data.toString());
            }
        };
        Observer<Weather> observer2 = new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {
                System.out.println("观察者2：" + data.toString());
            }
        };

        observable.register(observer1);
        observable.register(observer2);

        try {
            Weather weather4 = (Weather) Class.forName("com.swallow.Weather").newInstance();
            weather4.setDescription("晴");
            observable.notifyObservers(weather4);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Weather weather5 = new Weather();
        Class<Weather> aClass = (Class<Weather>) weather5.getClass();
        try {
            Weather weather6 = aClass.newInstance();
            weather6.setDescription("雨");
            observable.notifyObservers(weather6);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Weather weather = new Weather("晴转多云");
        observable.notifyObservers(weather);

        Weather weather1 = new Weather("多云转阴");
        observable.notifyObservers(weather1);

        observable.unregister(observer1);

        Weather weather2 = new Weather("台风");
        observable.notifyObservers(weather2);

        String s = String.valueOf(Type.TYPE2.name());
        Log.d("type", s);
    }

    private static Map<String, Weather> map = new HashMap<>();

    @Override
    public  <T extends Weather> T generatePhone(Class<T> clazz) throws Exception {

        if (map.containsKey(clazz.getName())) {
            return (T) map.get(clazz.getName());
        } else {
            T t = (T) Class.forName(clazz.getName()).newInstance();
            map.put(clazz.getName(), t);
            return t;
        }
    }
}
