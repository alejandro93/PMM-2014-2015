package com.example.administrador.solobici;

import android.app.Activity;
import android.os.Bundle;

public class AcercaDe extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Hacemos visible la interfaz/layoutque se encuentra en acercade.xml
        setContentView(R.layout.activity_acerca_de);
    }
}
