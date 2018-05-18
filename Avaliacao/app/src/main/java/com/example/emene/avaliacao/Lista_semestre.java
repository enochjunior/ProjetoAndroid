package com.example.emene.avaliacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lista_semestre extends AppCompatActivity {
    private List<Semestre> lista = todossemestres();
    ListView listV;
    //TextView sem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_semestre);

        listV = (ListView)findViewById(R.id.lis_sem);

       //ArrayAdapter<Semestre> adapter = new ArrayAdapter<Semestre>(this,
                //android.R.layout.simple_list_item_1, lista);
        SemAdapter adapter = new SemAdapter(this, lista);
        listV.setAdapter(adapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplication(), Lista_disciplina.class);

                intent.putExtra("id",lista.get(i).getId());
                startActivity(intent);



            }
        });

    }
    private List<Semestre> todossemestres() {
        return new ArrayList<>(Arrays.asList(
                new Semestre(1, "Primeiro Semestre"),
        new Semestre(2, "Segundo Semestre"),
        new Semestre(3, "Terceiro Semestre"),
            new Semestre(4, "Quarto Semestre"),
        new Semestre(5, "Quinto Semestre")));
    }
}
