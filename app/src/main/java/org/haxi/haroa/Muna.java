package org.haxi.haroa;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Muna extends Activity {
    OrientationEventListener orient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_muna);

        final Button nextbutton = (Button) findViewById(R.id.nextbutton);
        nextbutton.setVisibility(View.GONE);

        final TextView hint = (TextView) findViewById(R.id.hinttext);
        hint.setVisibility(View.GONE);

        orient = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL) {
            @Override
            public void onOrientationChanged(int i) {
                Log.d("Orientaatio", String.valueOf(i));
                if (i == 270) {
                    nextbutton.setVisibility(View.VISIBLE);
                }
            }
        };

        if (orient.canDetectOrientation() == true) {
            Log.d("Orientaatio", "Can detect");
            orient.enable();
        } else {
            Log.d("Orientaatio", "Cant detect");
            orient.disable();
        }

        Handler handel = new Handler();
        handel.postDelayed(new Runnable() {
            @Override
            public void run() {
                hint.setVisibility(View.VISIBLE);
            }
        },10000);

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchWaitActivity();
            }
        });

    }

    @Override
    public void onBackPressed() {

    }

    public void launchWaitActivity() {
        Intent intent = new Intent(this, Wait.class);
        startActivity(intent);
    }
}
