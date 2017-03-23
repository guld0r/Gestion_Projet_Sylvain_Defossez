package com.example.utilisateur.gestionprojet;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;

/**
 * Created by Utilisateur on 23/03/2017.
 */

public class Projet extends Activity {
    ListView l;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projet);

        l=(ListView) findViewById(R.id.lstProjet);
    }
}
