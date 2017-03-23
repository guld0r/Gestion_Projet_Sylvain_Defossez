package com.example.utilisateur.gestionprojet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Utilisateur on 23/03/2017.
 */

public class Main extends Activity {

    EditText id, mot_de_passe;
    String Id, Mot_de_passe;
    Context ctx=this;
    String ID=null, MOT_DE_PASSE=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        id = (EditText) findViewById(R.id.main_id);
        mot_de_passe = (EditText) findViewById(R.id.main_mot_de_passe);
    }

    public void main_login(View v){
        Id = id.getText().toString();
        Mot_de_passe = mot_de_passe.getText().toString();
        BackGround b = new BackGround();
        b.execute(Id, Mot_de_passe);
    }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String id = params[0];
            String mot_de_passe = params[1];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://10.0.2.2/web_service/login.php");
                String urlParams = "id="+id+"&mot_de_passe="+mot_de_passe;

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                while((tmp=is.read())!=-1){
                    data+= (char)tmp;
                }

                is.close();
                httpURLConnection.disconnect();

                return data;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            String err=null;
            try {
                JSONObject root = new JSONObject(s);
                JSONObject user_data = root.getJSONObject("user");
                ID = user_data.getString("id");
                MOT_DE_PASSE = user_data.getString("mot_de_passe");
            } catch (JSONException e) {
                e.printStackTrace();
                err = "Exception: "+e.getMessage();
            }

            Intent i = new Intent(ctx, Home.class);
            i.putExtra("id", ID);
            i.putExtra("mot_de_passe", MOT_DE_PASSE);
            i.putExtra("err", err);
            if(ID!=null) {
                startActivity(i);
            }
            else{
                Toast.makeText(getBaseContext(),"identifiant ou mot de passe incorrect ",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
