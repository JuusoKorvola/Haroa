package org.haxi.haroa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Wait extends Activity {

    private int bCount = 0;
    TextView warni;
    Handler delay2;
    Runnable run2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        warni = (TextView) findViewById(R.id.warning);

        //Pitkän tekstin scroll animaatio
        TextView scrolling = (TextView) findViewById(R.id.scrolling);
        Animation scroll = new TranslateAnimation(1500,-6500,0,0);
        scroll.setDuration(30000);
        scroll.setFillAfter(true);
        scroll.setInterpolator(new LinearInterpolator());
        scrolling.setAnimation(scroll);

        //Timer tekstin tuonti esiin 25 sekunnin päästä
        final TextView timeri = (TextView) findViewById(R.id.timeri);
        final Handler delay = new Handler();
        delay.postDelayed(new Runnable() {
            @Override
            public void run() {
                new CountDownTimer(437000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timeri.setText(String.format("%d",millisUntilFinished / 1000));
                    }

                    @Override
                    public void onFinish() {
                        timeri.setText("DONE");
                    }
                }.start();
            }
        }, 25000);

        //Toasti tekstien alustus ja tuominen esille 35 sekunnin kuluttua
        final ArrayList<String> suggestions = new ArrayList<>();
        suggestions.add("Hmm...");
        suggestions.add("something just came up");
        suggestions.add("lets try this out");
        suggestions.add("try tapping a corner 5 times");
        final int toastduration = Toast.LENGTH_SHORT;

        delay2 = new Handler();
        run2 = new Runnable() {
            @Override
            public void run() {
                new CountDownTimer(15000, 5000) {
                    int index = 0;
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Toast toast = Toast.makeText(getApplicationContext(), suggestions.get(index), toastduration);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                        index++;
                    }

                    @Override
                    public void onFinish() {
                        Toast toast = Toast.makeText(getApplicationContext(), suggestions.get(3), toastduration);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                    }
                }.start();
            }
        };
        delay2.postDelayed(run2,35000);

        //Näkymättömät painikkeet kulmissa
        Button invi1 = (Button) findViewById(R.id.invisible1);
        Button invi2 = (Button) findViewById(R.id.invisible2);
        Button invi3 = (Button) findViewById(R.id.invisible3);
        Button invi4 = (Button) findViewById(R.id.invisible4);
        invi1.setBackgroundColor(Color.TRANSPARENT);
        invi2.setBackgroundColor(Color.TRANSPARENT);
        invi3.setBackgroundColor(Color.TRANSPARENT);
        invi4.setBackgroundColor(Color.TRANSPARENT);

        clickListenerToButton(invi1);
        clickListenerToButton(invi2);
        clickListenerToButton(invi3);
        clickListenerToButton(invi4);

        onTouchListenerToButton(invi1);
        onTouchListenerToButton(invi2);
        onTouchListenerToButton(invi3);
        onTouchListenerToButton(invi4);

    }

    private void clickListenerToButton(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inviButtonClicked();
            }
        });
    }

    private void onTouchListenerToButton (Button button) {
        final Handler handel = new Handler();
        final Runnable run = new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        };
        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event){
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handel.postDelayed(run, 5000);
                        break;

                    case MotionEvent.ACTION_UP:
                        handel.removeCallbacks(run);
                        view.performClick();
                        break;

                    default:
                        break;

                }
                return true;
            }

        });
    }

    private void inviButtonClicked () {
        switch (bCount) {
            case 5:
                warni.setText("WRONG CORNER");
                bCount++;
                break;
            case 10:
                warni.setText("WRONG AGAIN");
                bCount++;
                break;
            case 15:
                warni.setText("WONT WORK");
                bCount++;
                break;
            case 20:
                warni.setText("STOP IT");
                bCount++;
                break;
            case 25:
                warni.setText("JUST WAIT");
                bCount++;
                break;
            case 30:
                warni.setText("WHY?");
                bCount++;
                break;
            case 35:
                warni.setText("WHAT DO YOU WANT?");
                bCount++;
                break;
            case 40:
                warni.setText("THIS: COCK?");
                bCount++;
                break;
            case 45:
                warni.setText("OK. IM OUT.");
                bCount++;
                break;
            case 50:
                warni.setText("COCK COCK COCK COCK COCK COCK COCK COCK COCK COCK COCK COCK COCK COCK COCK COCK COCK COCK");
                bCount++;
                suggestions2();
                break;
            default:
                bCount++;
                break;
        }
    }

    private void suggestions2 () {
        final ArrayList<String> suggestions = new ArrayList<>();
        suggestions.add("Ah, crap I misread the code, sorry");
        suggestions.add("Instead of tapping 5 times...");
        suggestions.add("press corner for 5 SECONDS");
        suggestions.add("sorry...");
        final int toastduration = Toast.LENGTH_SHORT;

        Handler handeli = new Handler();
        handeli.postDelayed(new Runnable() {
            @Override
            public void run() {
                new CountDownTimer(15000, 5000) {
                    int index = 0;
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Toast toast = Toast.makeText(getApplicationContext(), suggestions.get(index), toastduration);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                        index++;
                    }

                    @Override
                    public void onFinish() {
                        Toast toast = Toast.makeText(getApplicationContext(), suggestions.get(3), toastduration);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                    }
                }.start();
            }
        }, 2000);
    }

    private void nextActivity() {
        delay2.removeCallbacks(run2);
        Intent intent = new Intent(this, Mane.class);
        startActivity(intent);
    }
}
