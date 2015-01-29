package com.example.mati.examen2eval_alejandrobenadero;

/**
 * Created by mati on 29/01/15.
 */
public class Zonas {
    String zona;
    String continente;
    int precio;

    public Zonas (String zona, String continente, int precio){
        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
    }

    public String getZona(){
        return zona;
    }

    public String getContinente(){
        return continente;
    }

    public int getPrecio(){
        return precio;
    }

    public String toString(){
        String cad = zona +" "+continente+" "+ precio;
        return cad;
    }
}
