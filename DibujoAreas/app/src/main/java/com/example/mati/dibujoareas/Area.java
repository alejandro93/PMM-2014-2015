package com.example.mati.dibujoareas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mati.dibujoareas.R;

public class Area extends Activity {

    Spinner miSpinner;
    final String eleccion[] = {"Círculo", "Cuadrado"};
    TextView texto;
    EditText editText;
    Button boton;
    boolean seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        texto = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        boton = (Button) findViewById(R.id.button);
        miSpinner = (Spinner) findViewById(R.id.spinner);
        final ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, eleccion);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner.setAdapter(miAdaptador);

        seleccion = false;

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int i, long l) {
                String mensaje = eleccion[i];
                showToast(mensaje);

                if (mensaje.equals("Círculo")) {
                    texto.setText("Especifica el radio:");
                    seleccion = false;

                }
                if (mensaje.equals("Cuadrado")) {
                    texto.setText("Especifica la longitud del lado:");
                    seleccion = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent= new Intent(Area.this, Lienzo.class);
                Bundle bundle = new Bundle();
                double longitud= Double.parseDouble(editText.getText().toString());
                bundle.putDouble("LONGITUD", longitud);
                bundle.putBoolean("SELECCION", seleccion);
                miIntent.putExtras(bundle);
                startActivity(miIntent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.area, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}

