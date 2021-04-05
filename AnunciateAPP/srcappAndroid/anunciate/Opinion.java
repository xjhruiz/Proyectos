package com.example.jhonatan.anunciate;

/**
 * Created by Jhonatan on 09/06/2018.
 */

public class Opinion {

    private Integer id;
    private int puntuacion;
    private String mensaje;
    private Usuario critico;
    private Usuario criticado;

    public Opinion(Integer id, int puntuacion, String mensaje, Usuario critico, Usuario criticado) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.mensaje = mensaje;
        this.critico = critico;
        this.criticado = criticado;
    }

    public Opinion() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getCritico() {
        return critico;
    }

    public void setCritico(Usuario critico) {
        this.critico = critico;
    }

    public Usuario getCriticado() {
        return criticado;
    }

    public void setCriticado(Usuario criticado) {
        this.criticado = criticado;
    }
}
