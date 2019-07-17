package com.example.Bienvenido_cocinas_MC_activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class ZoomActivity extends AppCompatActivity {



    ImageView img_zoom;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);

        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        img_zoom=findViewById(R.id.img_zoom);

        String nombreImagen = getIntent().getExtras().getString("nombre");

        img_zoom.setImageResource(getResources().getIdentifier(nombreImagen, "drawable", this.getOpPackageName()));

    }

}
