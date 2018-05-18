package com.example.emene.infolabsys.View;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.emene.infolabsys.Conexao;
import com.example.emene.infolabsys.R;

public class Paciente extends AppCompatActivity {

    EditText nome_pac, rg_pac, sus_pac, dn_pac;
    Button sair, salvar, limpar;
    Spinner sex_pac;
    String url = "";
    String parametros = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        nome_pac = (EditText) findViewById(R.id.pc_nome);
        rg_pac = (EditText) findViewById(R.id.pc_rg);
        sus_pac = (EditText) findViewById(R.id.pc_sus);
        dn_pac = (EditText) findViewById(R.id.pc_data);
        sex_pac = (Spinner) findViewById(R.id.sp_sex);

        sair = (Button) findViewById(R.id.btn_sair);
        salvar = (Button) findViewById(R.id.btn_salvar);
        limpar = (Button) findViewById(R.id.btn_limpar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo !=null && networkInfo.isConnected()){

                    String nom = nome_pac.getText().toString();
                    String rg = rg_pac.getText().toString();
                    String sus = sus_pac.getText().toString() ;
                    String dn = dn_pac.getText().toString()  ;
                    String sex = sex_pac.getSelectedItem().toString();


                    if (nom.isEmpty() || rg.isEmpty() || sus.isEmpty() || dn.isEmpty() || sex.isEmpty()){

                        Toast.makeText(getApplicationContext(),
                                "Preencha todos os campos",Toast.LENGTH_LONG).show();

                    }else {


                        url = "http://10.0.0.172/infolabsys/paciente.php";

                        parametros = "nome=" + nom + "&rg=" + rg + "&sus=" + sus
                        + "&dn=" + dn + "&sexo=" + sex;

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

                nome_pac.setText("");
                rg_pac.setText("");
                sus_pac.setText("");
                dn_pac.setText("");
                sex_pac.setSelection(0);
                nome_pac.requestFocus();



            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Paciente.this,Principal.class);
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


            if (resultado.contains("Paciente já cadastrado")){

                Toast.makeText(getApplicationContext(),
                        "Paciente já cadastrado",Toast.LENGTH_LONG).show();

                nome_pac.setText("");
                rg_pac.setText("");
                sus_pac.setText("");
                dn_pac.setText("");
                sex_pac.setSelection(0);



                Intent intent = new Intent(Paciente.this,Principal.class);
                startActivity(intent);

            } else if(resultado.contains("Dados inseridos com sucesso!")){

                Toast.makeText(getApplicationContext(),
                        "Cadastrado com sucesso!",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Paciente.this,Principal.class);
                startActivity(intent);

            }

            else {

                nome_pac.setText("");
                rg_pac.setText("");
                sus_pac.setText("");
                dn_pac.setText("");
                sex_pac.setSelection(0);

                nome_pac.requestFocus();


                Toast.makeText(getApplicationContext(),
                        "Falha no cadastro",Toast.LENGTH_LONG).show();

            }
        }
    }


}
