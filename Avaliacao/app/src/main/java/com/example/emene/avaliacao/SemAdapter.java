package com.example.emene.avaliacao;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SemAdapter extends BaseAdapter {

    private Activity act;
    private List<Semestre> lista;
    public SemAdapter(Activity act,List<Semestre> lista){
        this.act = act;
        this.lista = lista;
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = act.getLayoutInflater().inflate(R.layout.listasemestre, viewGroup, false);
        //TextView id = (TextView) view.findViewById(R.id.i);
        TextView nome = (TextView) view.findViewById(R.id.nom_sem);

        //id.setText( sem.get(i).getId()+"" );
        nome.setText( lista.get(i).getNome() );



        return view;
    }
}
