package com.example.i7.changescenecircle;
// http://learn-android.ru/news/osnovy_raboty_s_perekhodami/2015-01-14-13
// http://habrahabr.ru/post/243363/
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.RelativeLayout;

import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.Scene;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;

public class MainActivity extends AppCompatActivity {

    //Сцены для перехода:
    private Scene sceneBlue, sceneRed, sceneGreen, sceneYellow, sceneOrange;

    //Переход для передвижения между сценами:
    private Transition transition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_blue);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //Hide StatusBar
        getSupportActionBar().hide(); //Hide ActionBar

        //Получаем layout ID
        RelativeLayout FL = (RelativeLayout) findViewById(R.id.bg);

        //Первая сцена
        ViewGroup startBlueView = (ViewGroup) getLayoutInflater().inflate(R.layout.layout_blue, FL, false);
        ViewGroup startGreenView = (ViewGroup) getLayoutInflater().inflate(R.layout.layout_green, FL, false);
        ViewGroup startOrangeView = (ViewGroup) getLayoutInflater().inflate(R.layout.layout_orange, FL, false);
        ViewGroup startRedView = (ViewGroup) getLayoutInflater().inflate(R.layout.layout_red, FL, false);
        ViewGroup startYellowView = (ViewGroup) getLayoutInflater().inflate(R.layout.layout_yellow, FL, false);

        //Создание сцен
        sceneBlue = new Scene(FL, startBlueView);
        sceneRed = new Scene(FL, startRedView);
        sceneGreen = new Scene(FL, startGreenView);
        sceneYellow = new Scene(FL, startYellowView);
        sceneOrange = new Scene(FL, startOrangeView);

        //Настраиваем переход и его свойства:
        transition = new ChangeBounds();
        //Настраиваем длительность перехода 5 секунд:
        transition.setDuration(600);
        transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));

    }

    // Функция нажатие на кнопки
    public void changeScene(View view) {
        switch (view.getId()) {
            case R.id.redBtn:
                TransitionManager.go(sceneRed, transition);
                break;
            case R.id.blueBtn:
                TransitionManager.go(sceneBlue, transition);
                break;
            case R.id.orangeBtn:
                TransitionManager.go(sceneOrange, transition);
                break;
            case R.id.yellowBtn:
                TransitionManager.go(sceneYellow, transition);
                break;
            case R.id.greenBtn:
                TransitionManager.go(sceneGreen, transition);
                break;
        }
    }

}