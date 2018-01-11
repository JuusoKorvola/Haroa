package org.haxi.haroa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Mane extends AppCompatActivity {

    private static final String LOG_TAG = Mane.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "org.haxi.haroa.extra.MESSAGE";
    private EditText editteksti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mane);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editteksti = (EditText) findViewById(R.id.editti);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final ArrayList<String> nappisanat = new ArrayList();
        nappisanat.add("CUNT");
        nappisanat.add("DICK");
        nappisanat.add("COCK");
        nappisanat.add("PUSSY");
        nappisanat.add("BUTT");
        nappisanat.add("ASS");
        nappisanat.add("PRICK");
        nappisanat.add("JESU CRISTO");
        nappisanat.add("WATCH YOUR PROFANITY");



        Button poopybutton = (Button) findViewById(R.id.poopybutton);
        final TextView teksib = (TextView) findViewById(R.id.testiteksti);
        poopybutton.setOnClickListener(new View.OnClickListener() {
            int eka = 0;
            @Override
            public void onClick(View view) {
                teksib.setText(nappisanat.get(eka));
                if (eka < nappisanat.size() - 1){
                    eka++;
                }
                else {
                    eka = 0;
                }
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

    public void launchMunaActivity(View view) {
        Log.d(LOG_TAG, "Painettu painiketta");
        Intent uusintent = new Intent(this, Muna.class);
        String viesti = editteksti.getText().toString();
        uusintent.putExtra(EXTRA_MESSAGE, viesti);
        startActivity(uusintent);
    }
}
