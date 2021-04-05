package com.example.jhonatan.anunciate;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jhonatan on 09/06/2018.
 */

public class AdaptadorOpiniones extends ArrayAdapter<Opinion> {
    List<Opinion> listaOpiniones;
    public AdaptadorOpiniones(Context context, List<Opinion> listaOpiniones) {
        super(context,R.layout.items_anuncio,listaOpiniones);
        this.listaOpiniones=listaOpiniones;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.items_opiniones,null,true);
        TextView tvCritico = (TextView) view.findViewById(R.id.itemCritico);
        RatingBar  ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        TextView tvOpinion = (TextView) view.findViewById(R.id.itemMensaje);
        tvCritico.setText(listaOpiniones.get(position).getCritico().getUserName());
        int num = listaOpiniones.get(position).getPuntuacion();
        Log.i("puntuacon",""+num);
        ratingBar.setRating(num);
        tvOpinion.setText(listaOpiniones.get(position).getMensaje());

        return view;
    }

}
