package com.vovroslyakov.chappie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView textLogo;
    private ImageView imageLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textLogo = findViewById(R.id.tv_logo_id);
        imageLogo = findViewById(R.id.iv_img_kart_id);

        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.transition);
        textLogo.startAnimation(myAnim);
        imageLogo.startAnimation(myAnim);

        final Intent intent = new Intent(this, MainActivity.class);

        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}
