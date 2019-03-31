package edu.itm.aiforhrrecruit.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.itm.aiforhrrecruit.R;

public class SplashActivity extends AppCompatActivity {

    protected int _splashTime = 3000; // time to display the splash screen in ms
    public boolean is_first = false;
    public boolean isInterent = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while ((waited < _splashTime)) {
                        sleep(100);
//                        if (_active) {
                        waited += 100;
//                            if(waited>_splashTime-200)
//                            {
//
////                            }
//                        }
                    }
                } catch (Exception e) {

                } finally {                    {

                    if(isInterent){
                        startActivity(new Intent(SplashActivity.this,
                                LoginActivity.class));
                    }else{

                        finish();
                    }
                }
                    finish();
                }
            };
        };

        splashTread.start();
    }
}
