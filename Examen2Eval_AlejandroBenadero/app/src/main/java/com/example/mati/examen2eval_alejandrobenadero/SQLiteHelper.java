package com.example.mati.examen2eval_alejandrobenadero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by Administrador on 28/01/2015.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    String cadenasql = "CREATE TABLE Prueba (zona TEXT, costefinal DOUBLE)";

    public SQLiteHelper(Context contexto, String nombre, CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }
    @Override
    public void onCreate(SQLiteDatabase bd) {

        bd.execSQL(cadenasql);
    }

    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {

        bd.execSQL("DROP TABLE IF EXISTS Prueba");

        bd.execSQL(cadenasql);
    }

}