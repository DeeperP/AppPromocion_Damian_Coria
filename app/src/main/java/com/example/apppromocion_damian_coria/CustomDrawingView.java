package com.example.apppromocion_damian_coria;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class CustomDrawingView extends View {

    private Paint paint;
    private List<Forma> formas;
    private int color = Color.BLUE;
    private String forma = "circulo";
    private int tamanio = 30;

    public CustomDrawingView(Context context) {
        super(context);
        inicializar();
    }

    public CustomDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializar();
    }

    private void inicializar() {
        paint = new Paint();
        paint.setAntiAlias(true);
        formas = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Forma f : formas) {
            paint.setColor(f.color);
            if (f.tipo.equals("circulo")) {
                canvas.drawCircle(f.punto.x, f.punto.y, f.tamanio, paint);
            } else if (f.tipo.equals("cuadrado")) {
                float half = f.tamanio;
                canvas.drawRect(f.punto.x - half, f.punto.y - half,
                        f.punto.x + half, f.punto.y + half, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                formas.add(new Forma(new PointF(event.getX(), event.getY()), color, forma, tamanio));
                invalidate(); // Redibuja
                return true;
        }
        return false;
    }

    // Setters públicos
    public void setColor(int nuevoColor) {
        this.color = nuevoColor;
    }

    public void setForma(String nuevaForma) {
        this.forma = nuevaForma;
    }

    public void setTamanio(int nuevoTamanio) {
        this.tamanio = nuevoTamanio;
    }

    public void limpiar() {
        formas.clear();
        invalidate();
    }

    // Clase interna para representar figuras
    private static class Forma {
        PointF punto;
        int color;
        String tipo;
        int tamanio;

        Forma(PointF punto, int color, String tipo, int tamanio) {
            this.punto = punto;
            this.color = color;
            this.tipo = tipo;
            this.tamanio = tamanio;
        }
    }
}
