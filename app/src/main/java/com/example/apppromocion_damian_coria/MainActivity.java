package com.example.apppromocion_damian_coria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void irADibujo(View view) {
        Intent intent = new Intent(this, DibujoActivity.class);
        startActivity(intent);
    }

    public void irAFiguras(View view) {
        Intent intent = new Intent(this, FigurasActivity.class);
        startActivity(intent);
    }

}
