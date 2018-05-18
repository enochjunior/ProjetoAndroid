package com.example.emene.infolabsys.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.emene.infolabsys.R;
import com.example.emene.infolabsys.teste;

public class Principal extends Activity {

    private Button tsuario;
    private Button tpaciente;
    private Button tprocedimento;
    private Button tlista;
    private Button tresultado;
    private Button tsair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tsuario = (Button) findViewById(R.id.btn_user);
        tpaciente = (Button)findViewById(R.id.btn_pac);
        tprocedimento = (Button) findViewById(R.id.btn_proce);
        tlista = (Button) findViewById(R.id.btn_list);
        tresultado = (Button) findViewById(R.id.btn_result);
        tsair = (Button) findViewById(R.id.btn_sair);

        tsuario.setOnClickListener(e->OnButton());
        tpaciente.setOnClickListener(e->OnPaciente());
        tprocedimento.setOnClickListener(e->OnProcedimento());
        tlista.setOnClickListener(e->OnLista());
        tresultado.setOnClickListener(e->OnResultado());
        tsair.setOnClickListener(e->OnSair());

   }
    public void OnPaciente(){

        Intent inte = new Intent(Principal.this, Paciente.class);
        Bundle bun = new Bundle();
        inte.putExtras(bun);
        startActivity(inte);

    }

    public void OnButton(){


            Intent inte = new Intent(Principal.this, Usuario.class);
            Bundle bun = new Bundle();
            inte.putExtras(bun);
            startActivity(inte);

    }

    public void OnProcedimento(){

        Intent inte = new Intent(Principal.this, Procedimento.class);
        Bundle bun = new Bundle();
        inte.putExtras(bun);
        startActivity(inte);


    }

    public void OnLista(){

        Intent inte = new Intent(Principal.this, Lista.class);
        Bundle bun = new Bundle();
        inte.putExtras(bun);
        startActivity(inte);

    }

    public void OnResultado(){

        Intent inte = new Intent(Principal.this, teste.class);
        Bundle bun = new Bundle();
        inte.putExtras(bun);
        startActivity(inte);

   }

    public void OnSair(){

        //Intent intent = new Intent(Principal.this,Login.class);
        //startActivity(intent);

        Intent  it = new Intent(getApplicationContext(), Login.class);
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        it.putExtra("SAIR", true);
        startActivity(it);

    }

}
