package org.haxi.haroa;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.util.Log;
import android.view.OrientationEventListener;
import android.view.Window;
import android.view.WindowManager;
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

        orient = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL) {
            @Override
            public void onOrientationChanged(int i) {
                Log.d("Orientaatio", String.valueOf(i));
                if (i == 270) {
                    Log.d("Orientaatio", "NAPPULA ESIIN");
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

    }

    @Override
    public void onBackPressed() {

    }
}
