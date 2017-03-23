package com.example.utilisateur.gestionprojet;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Utilisateur on 23/03/2017.
 */

public class Home extends Activity {

    String id, mot_de_passe, Err;
    TextView idTV, mot_de_passeTV, err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        idTV = (TextView) findViewById(R.id.home_id);
        mot_de_passeTV = (TextView) findViewById(R.id.home_mot_de_passe);
        err = (TextView) findViewById(R.id.err);

        id = getIntent().getStringExtra("id");
        mot_de_passe = getIntent().getStringExtra("mot_de_passe");
        Err = getIntent().getStringExtra("err");
        idTV.setText("Welcome " + id);
        mot_de_passeTV.setText("Your password is " + mot_de_passe);
        err.setText(Err);
    }
}
