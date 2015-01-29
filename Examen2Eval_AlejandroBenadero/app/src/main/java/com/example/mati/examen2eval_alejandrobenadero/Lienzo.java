package com.example.mati.examen2eval_alejandrobenadero;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Lienzo extends Activity {

    float radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujo(this));
        radio= 50;
    }


    class Dibujo extends View {

        public Dibujo(Context c) {

            super(c);
        }

        protected void onDraw(Canvas lienzo) {

            lienzo.drawColor(Color.WHITE);
            Paint pincel= new Paint();

            pincel.setStyle(Paint.Style.STROKE);
            pincel.setColor(Color.BLACK);
            pincel.setStrokeWidth(7);

            //Cabeza
            lienzo.drawCircle(lienzo.getWidth()/3, lienzo.getHeight()/3, radio, pincel);


            //Vestido
            pincel.setColor(Color.GREEN);

            lienzo.drawLine(lienzo.getWidth()/3, (lienzo.getHeight()/3)+radio, (lienzo.getWidth()/3)-50,
                    (lienzo.getHeight()/3)+radio*2, pincel);


            lienzo.drawLine(lienzo.getWidth()/3, (lienzo.getHeight()/3)+radio, (lienzo.getWidth()/3)+50,
                    (lienzo.getHeight()/3)+radio*2, pincel);

            lienzo.drawLine((lienzo.getWidth()/3)-50, (lienzo.getHeight()/3)+radio*2, (lienzo.getWidth()/3)+50,
                    (lienzo.getHeight()/3)+radio*2, pincel);

            pincel.setColor(Color.BLACK);

            //Brazos
            lienzo.drawLine(lienzo.getWidth()/3, (lienzo.getHeight()/3)+radio, (lienzo.getWidth()/3)-60,
                    (lienzo.getHeight()/3)+radio, pincel);

            lienzo.drawLine(lienzo.getWidth()/3, (lienzo.getHeight()/3)+radio, (lienzo.getWidth()/3)+60,
                    (lienzo.getHeight()/3)+radio, pincel);
            //Piernas
            lienzo.drawLine((lienzo.getWidth()/3)-30, (lienzo.getHeight()/3)+radio*2, (lienzo.getWidth()/3)-30,
                    (lienzo.getHeight()/3)+radio*3, pincel);

            lienzo.drawLine((lienzo.getWidth()/3)+30, (lienzo.getHeight()/3)+radio*2, (lienzo.getWidth()/3)+30,
                    (lienzo.getHeight()/3)+radio*3, pincel);

        }
    }
}