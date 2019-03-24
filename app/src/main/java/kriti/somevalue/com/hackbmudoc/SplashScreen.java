package kriti.somevalue.com.hackbmudoc;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private ImageView imgSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        if(Build.VERSION.SDK_INT>21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        //set animation
        imgSplash=(ImageView) findViewById(R.id.imgSplash);
//        RotateAnimation anim= new RotateAnimation(0f,350f,15f,15f);
//        anim.setInterpolator(new LinearInterpolator());
//        anim.setRepeatCount(Animation.INFINITE);
//        anim.setDuration(2000);
//        imgSplash.startAnimation(anim);
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scroll_out);

        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scroll_in);

// Start animation
        slide_down.setDuration(2000);
        imgSplash.startAnimation(slide_down);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentToHome=new Intent(SplashScreen.this,QRCodeScan.class);
                startActivity(intentToHome);
                finish();
            }
        },3000);

    }

}
