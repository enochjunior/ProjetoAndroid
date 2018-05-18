package com.example.emene.infolabsys.View;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.emene.infolabsys.BackgroundTask;
import com.example.emene.infolabsys.Conexao;
import com.example.emene.infolabsys.R;

import java.util.ArrayList;

public class Usuario extends AppCompatActivity {

    EditText nome, senha;
    Spinner nivel;
    Button salvar, limpar, sair;
    String url = "";
    String parametros = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);


        nome = (EditText) findViewById(R.id.us_nome);
        senha = (EditText) findViewById(R.id.us_senha);
        nivel = (Spinner) findViewById(R.id.sp_user);
        salvar = (Button)findViewById(R.id.btn_salvar);
        limpar = (Button)findViewById(R.id.btn_limpar);
        sair = (Button)findViewById(R.id.btn_sair);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo !=null && networkInfo.isConnected()){

                    String user = nome.getText().toString();
                    String pas = senha.getText().toString();
                    String niv = nivel.getSelectedItem().toString();

                    //Toast.makeText(getApplicationContext(),
                    //"Conectado",Toast.LENGTH_LONG).show();



                    if (user.isEmpty() || pas.isEmpty() || niv.isEmpty()){

                        Toast.makeText(getApplicationContext(),
                                "Preencha todos os campos",Toast.LENGTH_LONG).show();

                    }else {
                        //Toast.makeText(getApplicationContext(),
                        //"usuario",Toast.LENGTH_LONG).show();


                        url = "http://10.0.0.172/infolabsys/registro.php";

                        parametros = "nome=" + user + "&senha=" + pas + "&permissao=" + niv;

                        new solicitaDados().execute(url);

                    }


                }else {

                    Toast.makeText(getApplicationContext(),
                            "Nenhuma conexão detectada",Toast.LENGTH_LONG).show();
                }


            }
        });


        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nome.setText("");
                senha.setText("");
                nivel.setSelection(0);
                nome.requestFocus();

            }
        });


        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Usuario.this,Principal.class);
                startActivity(intent);

            }
        });

    }




    private class solicitaDados extends AsyncTask< String, Void, String > {


        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0],parametros);

        }

        protected void onPostExecute(String resultado){


           if (resultado.contains("Usuário já cadastrado")){

               Toast.makeText(getApplicationContext(),
                       "Usuário já cadastrado",Toast.LENGTH_LONG).show();

               nome.setText("");
               senha.setText("");
               nivel.setSelection(0);
               nome.requestFocus();



               //Intent intent = new Intent(Usuario.this,Principal.class);
               // startActivity(intent);

            } else if(resultado.contains("Dados inseridos com sucesso!")){

               Toast.makeText(getApplicationContext(),
                       "Cadastrado com sucesso!",Toast.LENGTH_LONG).show();

               Intent intent = new Intent(Usuario.this,Principal.class);
               startActivity(intent);

           }

            else {

                Toast.makeText(getApplicationContext(),
                        "Falha no cadastro",Toast.LENGTH_LONG).show();

            }
        }
    }


}
