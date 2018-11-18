package com.vovroslyakov.chappie;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {

    private TextView textLogoElectric;
    private TextView textLogoGo;
    private TextView textLogoKart;
    private ImageView imageLogo;

    private Handler h;
    private Runnable wordElectric;
    private Runnable wordGo;
    private Runnable wordkart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textLogoElectric = findViewById(R.id.tv_logo1_id);
        textLogoGo = findViewById(R.id.tv_logo2_id);
        textLogoKart = findViewById(R.id.tv_logo3_id);
        imageLogo = findViewById(R.id.iv_img_kart_id);


        // Появление слов на экране друг за другом
        h = new Handler();

        // Анимацию можно сделать в ресурсах
        Animation animImgLogo = AnimationUtils.loadAnimation(this, R.anim.transition);
        imageLogo.startAnimation(animImgLogo);

        wordElectric = new Runnable() {
            @Override
            public void run() {
                // Анимацию также можно сделать в коде
                Animation animElectric = new AlphaAnimation(0.0F, 1.0F);
                animElectric.setDuration(1000);
                textLogoElectric.setVisibility(View.VISIBLE);
                textLogoElectric.startAnimation(animElectric);
            }
        };

        wordGo = new Runnable() {
            @Override
            public void run() {
                Animation animGo = new AlphaAnimation(0.0F, 1.0F);
                animGo.setDuration(1000);
                textLogoGo.setVisibility(View.VISIBLE);
                textLogoGo.startAnimation(animGo);
            }
        };

        wordkart = new Runnable() {
            @Override
            public void run() {
                Animation animKart = new AlphaAnimation(0.0F, 1.0F);
                animKart.setDuration(1000);
                textLogoKart.setVisibility(View.VISIBLE);
                textLogoKart.startAnimation(animKart);
            }
        };


        final Intent intent = new Intent(this, MainActivity.class);

        Thread t = new Thread() {
            @Override
            public void run() {

                try {
                    TimeUnit.MILLISECONDS.sleep(1500);
                    h.post(wordElectric);
                    TimeUnit.MILLISECONDS.sleep(1500);
                    h.post(wordGo);
                    TimeUnit.MILLISECONDS.sleep(1500);
                    h.post(wordkart);
                    TimeUnit.MILLISECONDS.sleep(1500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                }
            }
        };
        t.start();
    }
}
