package com.example.emene.infolabsys.View;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.example.emene.infolabsys.Classes.Exame;
import com.example.emene.infolabsys.Conexao;
import com.example.emene.infolabsys.R;
import com.example.emene.infolabsys.adapterExames;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Procedimento extends AppCompatActivity {

   private List<Exame> listaExames = new ArrayList<>();
   private ArrayAdapter<Exame> adapter;
   private ListView listatela;

    String url = "";
    String parametros = "";
    Button sair, limpar, novo;
    CheckBox sel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedimento);

        listatela =  findViewById(R.id.list_exa);

        adapterExames adapter = new adapterExames(listaExames,this);
        listatela.setAdapter(adapter);

        sair = (Button)findViewById(R.id.btn_sair);
        limpar = (Button)findViewById(R.id.btn_limpar);
        novo = (Button)findViewById(R.id.btn_novo);
        sel = (CheckBox) findViewById(R.id.hem);

novo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


       /* new Thread(){

            @Override
            public void run() {
                JSONObject js = null;
                Conexao com = new Conexao();


                try {

                }catch (){

            }
        }*/



    }
});


        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Procedimento.this,Principal.class);
                startActivity(intent);

            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sel.setChecked(false);

            }
        });


        }



}
