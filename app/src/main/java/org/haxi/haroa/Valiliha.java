package org.haxi.haroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Valiliha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valiliha);

        final EditText cocktext = (EditText) findViewById(R.id.cocktext);
        cocktext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("tekstikenttä", "tekstiä vaihdettu");
                if(cocktext.getText().toString().equalsIgnoreCase("cock")){
                    launchMunaActivity();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    public void launchMunaActivity() {
        Intent uusintent = new Intent(this, Muna.class);
        startActivity(uusintent);
    }
}
