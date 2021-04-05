package com.example.jhonatan.anunciate;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;
import android.util.Log;



/**
 * Created by Jhonatan on 10/06/2018.
 */

public class DialogoOpinar extends DialogFragment {
    private OpinarListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("¿ Quiere opinar sobre este usuario ?")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    //referencia a la ventania que se lanza
                    public void onClick(DialogInterface dialog, int id) {
                        //cierra la ventana lanzada
                        Log.i("Quere opinar","si");
                        listener.opinar();
                        listener.eliminar();
                        listener.cerrar();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("Quere opinar","NO");
                        dialog.cancel();
                        listener.cerrar();
                        listener.eliminar();
                    }
                })
        ;
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OpinarListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    public interface OpinarListener{
        void opinar();
        void cerrar();
        void eliminar();

    }

}
