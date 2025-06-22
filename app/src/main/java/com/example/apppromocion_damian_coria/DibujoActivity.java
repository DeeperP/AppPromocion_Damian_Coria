package com.example.apppromocion_damian_coria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class DibujoActivity extends AppCompatActivity {

    private CustomDrawingView drawingView;
    private Spinner spTamanio;
    private String colorSeleccionado = "";
    private int colorFinal = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo);

        drawingView = findViewById(R.id.customDrawingView);
        spTamanio = findViewById(R.id.sp_1);

        // Cargar opciones de tamaño en el Spinner
        String[] tamanios = {"10", "20", "30", "40", "50"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tamanios);
        spTamanio.setAdapter(adapter);

        // Cambiar tamaño automáticamente al seleccionar
        spTamanio.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                int size = Integer.parseInt(spTamanio.getSelectedItem().toString());
                drawingView.setTamanio(size);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {}
        });
    }

    public void seleccionarColor(View view) {
        Button boton = (Button) view;
        String texto = boton.getText().toString().toLowerCase();

        switch (texto) {
            case "rojo":
                colorFinal = Color.parseColor("#B83D3D");
                break;
            case "azul":
                colorFinal = Color.parseColor("#3D6AB8");
                break;
            case "amarillo":
                colorFinal = Color.parseColor("#B8AE3D");
                break;
            case "verde":
                colorFinal = Color.parseColor("#76B83D");
                break;
            default:
                colorFinal = Color.BLACK;
        }

        drawingView.setColor(colorFinal);
    }

    public void borrarDibujo(View view) {
        drawingView.limpiar();
    }

    public void cambiarFormaRedonda(View view) {
        drawingView.setForma("circulo");
    }

    public void cambiarFormaCuadrada(View view) {
        drawingView.setForma("cuadrado");
    }

    public void volverAMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
