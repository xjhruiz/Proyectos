package com.example.jhonatan.anunciate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by user on 11/02/2018.
 */
                                    //Siempre desde el support
public class DialogoAlerta extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =  //para recuperar una clase desde una externa
                new AlertDialog.Builder(getActivity());
        builder.setMessage("No tiene ningun anuncio creado . ¡Empiece a solicitar ayuda a cambio de dinero!")
                .setTitle("Información")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    //referencia a la ventania que se lanza
                    public void onClick(DialogInterface dialog, int id) {
                        //cierra la ventana lanzada
                        dialog.cancel();
                    }
                });
        //crea la ventanita
        return builder.create();
    }
}
