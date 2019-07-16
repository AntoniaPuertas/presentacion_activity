package com.example.Bienvenido_cocinas_MC_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class ZoomActivity extends AppCompatActivity {
    ScaleGestureDetector scaleGestureDetector;
    float scala;


    ImageView img_zoom;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        img_zoom=findViewById(R.id.img_zoom);
        context = this;

        String nombreImagen = getIntent().getExtras().getString("nombre");

        img_zoom.setImageResource(getResources().getIdentifier(nombreImagen, "drawable", context.getOpPackageName()));

        //para el zoom
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        scala = 1.0f;
    }

    // Este método redirecciona todos los eventos touch de la actividad hacia el gesture detector
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return scaleGestureDetector.onTouchEvent(event);
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        // Cuando se detecta el gesto de escala este método redimensiona la imagen
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            //establecemos un tamaño máximo y mínimo para la escala
            scala = Math.max(0.1f, Math.min(scala, 5.0f));
            scala *= scaleGestureDetector.getScaleFactor();
            img_zoom.setScaleX(scala);
            img_zoom.setScaleY(scala);
            return true;
        }
}
}
