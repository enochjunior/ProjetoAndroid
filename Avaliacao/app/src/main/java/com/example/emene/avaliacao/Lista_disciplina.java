package com.example.emene.avaliacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lista_disciplina extends AppCompatActivity {

    private List<Disciplina> list = new ArrayList<>();
    private ListView listd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_disciplina);

        /*listView = (ListView) findViewById(R.id.lis_disc);

        lista.add(new Disciplina(1,"Algoritimos"));
        adapter adapter = new adapter(lista, this);

        listView.setAdapter(adapter);*/


        Bundle bundle = getIntent().getExtras();
        listd = (ListView) findViewById(R.id.lis_disc);

        if(bundle != null){
            int i = bundle.getInt("id", 0);
            switch (i){
                case 1:
                    list.add(new Disciplina(1,"Algoritmo", 0.0f));
                    list.add(new Disciplina(2,"Etica",0.0f));
                    list.add(new Disciplina(3,"Gestão Empresarial",0.0f));
                    list.add(new Disciplina(4,"Redes",0.0f));
                    list.add(new Disciplina(5,"Arquitetura",0.0f));
                    adapter a = new adapter(list, this);
                    listd.setAdapter(a);
                    break;
                case 2:
                    list.add(new Disciplina(1,"G.E.T.I",0.0f));
                    list.add(new Disciplina(2,"BANCO DE DADOS",0.0f));
                    list.add(new Disciplina(3,"LÍNGUA PORTUGUESA",0.0f));
                    list.add(new Disciplina(4,"Programação 1",0.0f));
                    list.add(new Disciplina(5,"PROJETOS DE REDES",0.0f));
                    list.add(new Disciplina(6,"PROJETO INTEGRADO I",0.0f));
                    adapter at = new adapter(list, this);
                    listd.setAdapter(at);
                    break;

                case 3:
                    list.add(new Disciplina(1,"PROGRAMAÇÃO 2 ",0.0f));
                    list.add(new Disciplina(2,"ADM DE BANCO DE DADOS",0.0f));
                    list.add(new Disciplina(3,"ANÁLISE E PROJETOS",0.0f));
                    list.add(new Disciplina(4,"LEGISLAÇÃO",0.0f));
                    list.add(new Disciplina(5,"ECONOMIA",0.0f));
                    list.add(new Disciplina(6,"DESEN. GERENCIAL",0.0f));
                    adapter att = new adapter(list, this);
                    listd.setAdapter(att);
                    break;
                case 4:
                    list.add(new Disciplina(1,"ANÁLISE E PROJETOS 2",0.0f));
                    list.add(new Disciplina(2,"TÓPICOS ESPECIAIS",0.0f));
                    list.add(new Disciplina(3,"GOVERNANÇA DE TI",0.0f));
                    list.add(new Disciplina(4,"SISTEMAS DE INFORMAÇÕES",0.0f));
                    list.add(new Disciplina(5,"ESTÁGIO 1",0.0f));
                    list.add(new Disciplina(6,"PROJETO INTEGRADO II",0.0f));
                    adapter aat = new adapter(list, this);
                    listd.setAdapter(aat);
                    break;

                case 5:
                    list.add(new Disciplina(1,"TÓPICOS ESPECIAIS 2",0.0f));
                    list.add(new Disciplina(2,"GERENCIAMENTO DE PROJETOS",0.0f));
                    list.add(new Disciplina(3,"EMEPREENDEDORISMO",0.0f));
                    list.add(new Disciplina(4,"SEGURANÇA DA INFORMAÇÃO",0.0f));
                    list.add(new Disciplina(5,"ESTÁGIO 2",0.0f));
                    adapter aatt = new adapter(list, this);
                    listd.setAdapter(aatt);
                    break;
            }
        }






    }
}
