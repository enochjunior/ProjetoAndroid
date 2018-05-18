package com.example.emene.avaliacao;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class adapter extends BaseAdapter {


    private List<Disciplina> list;
    private Activity act;

    public adapter(List<Disciplina> list, Activity act) {
        this.list = list;
        this.act = act;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        final ViewMy viewMy;
        LayoutInflater inflater = (LayoutInflater) act.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listadisciplina, parent, false);
            viewMy = new ViewMy(convertView);
            convertView.setTag(viewMy);
        } else {

            viewMy = (ViewMy) convertView.getTag();
        }

        viewMy.id.setText(String.valueOf(list.get(position).getId()));
        viewMy.nome.setText(list.get(position).getNome());

        viewMy.avalia.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //mostra na tela o valor setado
                viewMy.nota.setText(String.valueOf(rating));
                //grava no item da lista o valor que por ultimo fora setado.
                list.get(position).setValor(rating);
            }
        });
        //devolve a lista p/o listview
        return convertView;
    }


    private static class ViewMy {
        TextView id;
        TextView nome;
        TextView nota;
        RatingBar avalia;


        public ViewMy(View view) {

            id = (TextView) view.findViewById(R.id.disc_id);
            nome = (TextView) view.findViewById(R.id.disc_nome);
            avalia = (RatingBar) view.findViewById(R.id.ava);
            nota = (TextView) view.findViewById(R.id.disc_nota);

        }

    }


}