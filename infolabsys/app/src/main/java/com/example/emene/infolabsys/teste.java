package com.example.emene.infolabsys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class teste extends AppCompatActivity {

    Button sair, limpar, novo, salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        sair = (Button) findViewById(R.id.btn_sair);
        limpar = (Button)findViewById(R.id.btn_limpar);
        novo = (Button) findViewById(R.id.btn_novo);
        salvar = (Button)findViewById(R.id.btn_salvar);

        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sair.setClickable(true);
                limpar.setClickable(true);
                salvar.setClickable(true);
            }
        });

    }
}
