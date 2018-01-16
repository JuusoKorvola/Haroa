package org.haxi.haroa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Mane extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mane);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button hiddenb = (Button) findViewById(R.id.hiddenb);
        hiddenb.setVisibility(View.GONE);
        hiddenb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchValiActivity();
            }
        });


        final ArrayList<String> nappisanat = new ArrayList();
        nappisanat.add("BUTT");
        nappisanat.add("PUSSY");
        nappisanat.add("COCK");
        nappisanat.add("CUNT");
        nappisanat.add("DICK");
        nappisanat.add("ASS");
        nappisanat.add("PRICK");
        nappisanat.add("JESU CRISTO");
        nappisanat.add("WATCH YOUR PROFANITY!");



        Button poopybutton = (Button) findViewById(R.id.poopybutton);
        final TextView teksib = (TextView) findViewById(R.id.testiteksti);
        poopybutton.setOnClickListener(new View.OnClickListener() {
            int eka = 0;
            int painetut = 0;
            @Override
            public void onClick(View view) {
                teksib.setText(nappisanat.get(eka));
                if (eka < nappisanat.size() - 1){
                    eka++;
                }
                else {
                    eka = 0;
                }
                painetut++;
                if (painetut > 18){
                    hiddenb.setVisibility(View.VISIBLE);
                }
                Log.d("painettuja korotettu",Integer.toString(painetut));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mane, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchValiActivity() {
        Intent valiintent = new Intent(this, Valiliha.class);
        startActivity(valiintent);
    }
}
