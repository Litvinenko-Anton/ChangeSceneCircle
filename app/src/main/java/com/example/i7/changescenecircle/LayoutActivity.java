package com.example.i7.changescenecircle;
// http://learn-android.ru/news/osnovy_raboty_s_perekhodami/2015-01-14-13
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

import com.transitionseverywhere.AutoTransition;
import com.transitionseverywhere.Scene;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;

public class LayoutActivity extends AppCompatActivity {

    //Сцены для перехода:
    private Scene scene1, scene2;

    //Переход для передвижения между сценами:
    private Transition transition;

    //Флажок для переключения между сценами:
    private boolean start;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //Получаем layout ID
        RelativeLayout FL=(RelativeLayout)findViewById(R.id.bg);

        //Первая сцена
        ViewGroup startView=(ViewGroup)getLayoutInflater().inflate(R.layout.layout,FL,false);

        //Вторая сцена
        ViewGroup stopView=(ViewGroup)getLayoutInflater().inflate(R.layout.layout2,FL,false);


        //Создание 2-х сцен
        scene1=new Scene(FL, startView);
        scene2=new Scene(FL, stopView);

        //Настраиваем переход и его свойства:
        transition = new AutoTransition();
        //Настраиваем длительность перехода 1 секунд:
        transition.setDuration(1000);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        //Настраиваем запуск перехода:
        start=true;

    }
    // Функция нажатие на кнопки
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void changeScene(View view) {
        if (start) {
            TransitionManager.go(scene2, transition);
            start=false;
        }
        else {
            TransitionManager.go(scene1,transition);
            start=true;
        }
    }
}
