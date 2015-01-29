package com.example.mati.examen2eval_alejandrobenadero;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.SurfaceHolder;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Principal extends Activity {

    String mensaje;
    ArrayList <Zonas> arrayList;
    Spinner spinner;
    Button calcular;
    CheckBox caja1;
    CheckBox caja2;
    String texto;
    double peso;
    double precio;
    EditText editText;
    RadioButton radio1;
    RadioButton radio2;
    Zonas objeto;
    String zona;
    String tarifa;
    String decoracion;
    String continente;
    double valorkilo;

    double resultado;
    float costefinal;

    SQLiteHelper datosdb;
    SQLiteDatabase dbr;
    SQLiteDatabase dbw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        spinner = (Spinner) findViewById(R.id.spinner);
        calcular = (Button) findViewById(R.id.calcular);
        editText = (EditText) findViewById(R.id.editext);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        caja1 = (CheckBox) findViewById(R.id.checkBox1);
        caja2 = (CheckBox) findViewById(R.id.checkBox2);

        arrayList = new ArrayList<Zonas>();

        datosdb = new SQLiteHelper(this, "Prueba", null, 1);
        dbw = datosdb.getWritableDatabase();
        dbr = datosdb.getReadableDatabase();

        arrayList.add(new Zonas("A", "Asia y Oceania", 30));
        arrayList.add(new Zonas("B", "America y Africa", 20));
        arrayList.add(new Zonas("C", "Europa", 10));

        ArrayAdapter<Zonas> miAdaptador = new ArrayAdapter<Zonas>(this, android.R.layout.simple_spinner_item, arrayList);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(miAdaptador);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                texto = editText.getText().toString();
                peso = Integer.parseInt(texto);
                objeto = (Zonas) spinner.getSelectedItem();
                precio = objeto.getPrecio();
                if (peso <= 5) {
                    valorkilo = 1;
                }
                else if (peso > 5 && peso <= 10) {
                    valorkilo = 1.5;
                }
                else if (peso > 10) {
                    valorkilo = 2;
                }

                if(radio1.isChecked()){
                    resultado = precio + peso * valorkilo;
                    tarifa = "Normal";
                }
                else if(radio2.isChecked()){
                    resultado = (precio + peso * valorkilo) * 0.3 + (precio + peso * valorkilo);
                    tarifa = "Urgente";
                }
                if(caja1.isChecked()){
                    if(caja2.isChecked()){
                        decoracion = "Con caja regalo y dedicatoria";
                    }
                    else{
                        decoracion = "Con caja regalo";
                    }
                }
                else{
                    if(caja2.isChecked()){
                        decoracion = "Con dedicatoria";
                    }
                    else {
                        decoracion = "Sin decoracion";
                    }
                }
                Intent miIntent = new Intent(Principal.this, Envio.class);
                Bundle bundle = new Bundle();

                zona = objeto.getZona();
                continente = objeto.getContinente();
                bundle.putDouble("resultado", resultado);
                bundle.putDouble("peso", peso);
                bundle.putString("tarifa", tarifa);
                bundle.putString("zona", zona);
                bundle.putString("decoracion", decoracion);
                bundle.putString("continente", continente);

                miIntent.putExtras(bundle);
                startActivity(miIntent);
            }

        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent miIntent;
        String zonaS;
        int codigo = 0;
        switch (item.getItemId()) {

            case R.id.datos:
                costefinal = (float) resultado;
                dbw.execSQL("INSERT INTO Prueba (zona, costefinal) " +
                            "VALUES ('"+zona + "', " + costefinal + ")");
                mensaje= "INSERT INTO Prueba (zona, costefinal) " +
                    "VALUES ('" + zona + "', " + costefinal + ")";


                showToast(mensaje);
                codigo++;
                return true;
            case R.id.lienzos:
                miIntent = new Intent(Principal.this, Lienzo.class);
                startActivity(miIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
/*
    class AdaptadorS extends ArrayAdapter{

        Activity context;
        @SuppressWarnings("unchecked")
        public AdaptadorS(Activity context) {
            super(context, R.layout.downspinner,arrayList);
            this.context=context;

        }

        public View getDropDownView(int posicion,View convertView,ViewGroup parent){
            return getView(posicion,convertView,parent);
        }

        public View getView(int posicion,View convertView,ViewGroup parent){
            View item=convertView;
            ViewHolder holder;
            if(item==null){
                LayoutInflater inflater=context.getLayoutInflater();
                item=inflater.inflate(R.layout.downspinner,null);

                holder=new ViewHolder();
                holder.zona=(TextView)item.findViewById(R.id.zona);
                holder.continente=(TextView)item.findViewById(R.id.continente);
                holder.precio=(TextView)item.findViewById(R.id.precio);


                item.setTag(holder);

            }
            else
                holder=(ViewHolder)item.getTag();

            holder.zona.setText(arrayList[posicion].getZona());
            holder.continente.setText(arrayList[posicion].getContinente());
            holder.precio.setText(arrayList[posicion].getPrecio());

            return item;
        }

    }
*/
}

