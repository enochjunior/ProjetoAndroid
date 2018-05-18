package com.example.emene.infolabsys.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.emene.infolabsys.BackgroundTask;
import com.example.emene.infolabsys.Conexao;
import com.example.emene.infolabsys.R;

import java.io.IOException;

public class Login extends Activity {

    EditText u_name, u_pass;
    Button log;
    String url = "";
    String parametros = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        u_name = (EditText) findViewById(R.id.edit_nome);
        u_pass = (EditText) findViewById(R.id.edit_senha);
        log = (Button)findViewById(R.id.btn_log);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo !=null && networkInfo.isConnected()){
;
                    String login = u_name.getText().toString();
                    String pass = u_pass.getText().toString();


                    if (login.isEmpty() || pass.isEmpty()){

                        Toast.makeText(getApplicationContext(),
                                "Usuário e/ou Senha vazio",Toast.LENGTH_LONG).show();

                    }else {

                        url = "http://10.0.0.30/infolabsys/login.php";

                    parametros = "nome=" + login + "&senha=" + pass;

                    new solicitaDados().execute(url);

                    }


                }else {

                    Toast.makeText(getApplicationContext(),
                            "Nenhuma conexão detectada",Toast.LENGTH_LONG).show();
                }

            }
        });


    }



    private class solicitaDados extends AsyncTask< String, Void, String >{


        @Override
        protected String doInBackground(String... urls) {

                return Conexao.postDados(urls[0],parametros);

        }

        protected void onPostExecute(String resultado){

          if (resultado.contains("logado")){

                Intent intent = new Intent(Login.this,Principal.class);
                startActivity(intent);
                u_name.setText("");
                u_pass.setText("");


            }else {

              u_name.setText("");
              u_pass.setText("");


              Toast.makeText(getApplicationContext(),
                        "Usuário ou Senha incorretos",Toast.LENGTH_LONG).show();



          }
        }
    }
    @Override
    protected void onResume() {
        if(getIntent().getBooleanExtra("SAIR", false)){
            finish();
        }
        super.onResume();
    }
}


