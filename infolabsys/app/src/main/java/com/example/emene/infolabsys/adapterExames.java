package com.example.emene.infolabsys;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.emene.infolabsys.Classes.Exame;

import java.util.List;

/**
 * Created by emene on 03/04/2018.
 */

public class adapterExames extends BaseAdapter {

    private List<Exame> lista;
    private Activity act;

    public adapterExames(List<Exame>lista, Activity act){
        this.lista = lista;
        this.act = act;

    }


    @Override
    public int getCount()
    {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = act.getLayoutInflater().inflate(R.layout.solicita_exames,parent,false);
        TextView cod  =  vi.findViewById(R.id.codexa);
        CheckBox usa =  vi.findViewById(R.id.id_usa);
        Button novo = vi.findViewById(R.id.btn_novo);
        Button sair = vi.findViewById(R.id.btn_sair);
        Button limpar = vi.findViewById(R.id.btn_limpar);
        Button salvar = vi.findViewById(R.id.btn_salvar);


        cod.setText(lista.get(position).getCodigo());

        lista.get(position).setSel(usa.isChecked());

        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sair.setClickable(true);
                limpar.setClickable(true);
                salvar.setClickable(true);


                }
        });
        return vi;
    }
}
