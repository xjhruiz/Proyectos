package com.example.jhonatan.anunciate;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Jhonatan on 10/06/2018.
 */

public class AdaptadorMisAnuncios extends ArrayAdapter<Anuncio> {
    List<Anuncio> listaanuncios;
    public AdaptadorMisAnuncios(Context context, List<Anuncio> listaanuncios) {
        super(context, R.layout.items_mis_anuncios, listaanuncios);
        this.listaanuncios = listaanuncios;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.items_mis_anuncios, null, true);
        TextView tvfuncion = (TextView) view.findViewById(R.id.itemmimifuncion);
        TextView tvciudad = (TextView) view.findViewById(R.id.itemmiciudad);
        TextView tvpago = (TextView) view.findViewById(R.id.itemmipago);
        TextView tvfecha = (TextView) view.findViewById(R.id.itemmifecha);
        TextView tvestado = (TextView) view.findViewById(R.id.itemmiestado);
        TextView tvdetalles = (TextView) view.findViewById(R.id.itemmisdetalles);
        tvfuncion.setText(listaanuncios.get(position).getFuncionLaboral());
        tvciudad.setText(listaanuncios.get(position).getCiudad());
        tvpago.setText(listaanuncios.get(position).getPago());
        tvfecha.setText(listaanuncios.get(position).getFechaAnuncio());
        tvdetalles.setText(listaanuncios.get(position).getDetalles());

        tvestado.setText(listaanuncios.get(position).getEstado());
        if (listaanuncios.get(position).getEstado().equalsIgnoreCase("pendiente")) {
            tvestado.setTextColor(Color.parseColor("#FF0000"));
        } else if (listaanuncios.get(position).getEstado().equalsIgnoreCase("solicitado")) {
            tvestado.setTextColor(Color.parseColor("#FFFF00"));
        } else if (listaanuncios.get(position).getEstado().equalsIgnoreCase("realizado")) {
            tvestado.setTextColor(Color.parseColor("#00FF00"));
        }

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public String getEditex(String texto){

        return texto;
    }
}
