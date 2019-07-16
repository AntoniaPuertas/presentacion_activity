package com.example.Bienvenido_cocinas_MC_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.Bienvenido_cocinas_MC_activity.Imagenes_adapter;
import java.util.ArrayList;

public class Ideas_cocinasActivity extends AppCompatActivity {
    Context contexto;
    Imagenes_adapter imagenes_adapter;
    ListView list_imagenes;
    ArrayList<String> lista_imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas_cocinas);


        this.contexto = this;
        this.list_imagenes = ((ListView)findViewById(R.id.list_imagenes));
        this.lista_imagenes = new ArrayList();
        this.lista_imagenes.add("imagenes_01");
        this.lista_imagenes.add("imagenes_02");
        this.lista_imagenes.add("imagenes_03");
        this.lista_imagenes.add("imagenes_04");
        this.lista_imagenes.add("imagenes_05");
        this.lista_imagenes.add("imagenes_06");
        this.lista_imagenes.add("imagenes_07");
        this.lista_imagenes.add("imagenes_08");
        this.lista_imagenes.add("imagenes_09");
        this.lista_imagenes.add("imagenes_10");
        this.lista_imagenes.add("imagenes_11");
        this.lista_imagenes.add("imagenes_12");
        this.lista_imagenes.add("imagenes_13");
        this.lista_imagenes.add("imagenes_14");
        this.imagenes_adapter = new Imagenes_adapter(this.contexto, this.lista_imagenes);
        this.list_imagenes.setAdapter(this.imagenes_adapter);
    }
}