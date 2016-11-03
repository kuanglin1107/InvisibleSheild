package com.kuang.readhtml;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
public class intro extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
/**
 * Created by SONY on 2016/10/27.
 */


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent intent = new Intent();
                intent.setClass(intro.this, MenuActivity.class);
                startActivity(intent);
                intro.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
