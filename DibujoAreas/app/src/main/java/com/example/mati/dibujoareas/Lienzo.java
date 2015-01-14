package com.example.mati.dibujoareas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mati.dibujoareas.R;

public class Lienzo extends Activity {

    boolean seleccion;
    double x;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new miVista(this));

    }

    public class miVista extends View{
        public miVista(Context contexto){
            super(contexto);
        }
        protected void onDraw(Canvas canvas){
            bundle = getIntent().getExtras();

            seleccion = bundle.getBoolean("SELECCION");
            x = bundle.getDouble("LONGITUD");

            Paint pincel = new Paint();
            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.FILL);

            if(seleccion == false){
                float radio = ((float) x);
                canvas.drawCircle(getWidth()/2, getHeight()/2, radio, pincel);
            }
            else{
                float left = getWidth() / 2 - ((float) x / 2);
                float right = getWidth() / 2 + ((float) x / 2);
                float bottom = getHeight() / 2 - ((float) x / 2);
                float top = getHeight() / 2 + ((float) x / 2);
                canvas.drawRect(left, top, right, bottom, pincel);
            }
        }
    }


}
