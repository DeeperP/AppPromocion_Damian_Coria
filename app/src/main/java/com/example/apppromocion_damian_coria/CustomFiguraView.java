package com.example.apppromocion_damian_coria;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomFiguraView extends View {

    private Paint paint;

    public CustomFiguraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        // -------------------------------
        // 1. RECTÁNGULOS
        // -------------------------------
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawRect(100, 100, 300, 250, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
        canvas.drawRect(350, 100, 550, 250, paint);

        // -------------------------------
        // 2. CÍRCULOS (alineados horizontalmente)
        // -------------------------------
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(150, 400, 50, paint);

        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(350, 400, 30, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(550, 400, 70, paint);

        // -------------------------------
        // 3. LÍNEAS (estrella)
        // -------------------------------
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(5);
        canvas.drawLine(200, 600, 300, 700, paint);
        canvas.drawLine(300, 700, 400, 600, paint);
        canvas.drawLine(400, 600, 250, 750, paint);
        canvas.drawLine(250, 750, 350, 750, paint);
        canvas.drawLine(350, 750, 200, 600, paint);

        // -------------------------------
        // 4. TEXTO CENTRADO
        // -------------------------------
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setTextSize(60);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("App de Damian Coria", getWidth() / 2f, getHeight() - 100, paint);
    }
}
