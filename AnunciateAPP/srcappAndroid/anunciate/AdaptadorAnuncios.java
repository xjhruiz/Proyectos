package com.example.jhonatan.anunciate;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jhonatan on 03/06/2018.
 */

public class AdaptadorAnuncios extends ArrayAdapter<Anuncio>{
    List<Anuncio> listaanuncios;
    public AdaptadorAnuncios(Context context,List<Anuncio> listaanuncios) {
       super(context,R.layout.items_anuncio,listaanuncios);
        this.listaanuncios=listaanuncios;
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.items_anuncio,null,true);
        TextView tvfuncion = (TextView) view.findViewById(R.id.itemfuncion);
        TextView tvciudad = (TextView) view.findViewById(R.id.itemciudad);
        TextView tvpago = (TextView) view.findViewById(R.id.itempago);
        TextView tvfecha = (TextView) view.findViewById(R.id.itemfecha);
        TextView tvestado = (TextView) view.findViewById(R.id.itemestado);

        tvfuncion.setText(listaanuncios.get(position).getFuncionLaboral());
        tvciudad.setText(listaanuncios.get(position).getCiudad());
        tvpago.setText(listaanuncios.get(position).getPago());
        tvfecha.setText(listaanuncios.get(position).getFechaAnuncio());

        tvestado.setText(listaanuncios.get(position).getEstado());
        if(listaanuncios.get(position).getEstado().equalsIgnoreCase("pendiente")){
            tvestado.setTextColor(Color.parseColor("#FF0000"));
        }else if (listaanuncios.get(position).getEstado().equalsIgnoreCase("solicitado")){
            tvestado.setTextColor(Color.parseColor("#FFFF00"));
        }else if(listaanuncios.get(position).getEstado().equalsIgnoreCase("realizado")){
            tvestado.setTextColor(Color.parseColor("#00FF00"));
        }


        return view;
    }


}
