package com.example.Bienvenido_cocinas_MC_activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.example.presentacion_activity.Aviso_legalActivity;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private final int MI_PERMISO_TELEFONO = 23;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //aqui estamos enlazando 2 actividades para mostrar aviso legal

        if (id == R.id.aviso_legal) {
            Intent intent = new Intent(MainActivity.this, Aviso_legalActivity.class);
            /* esto sirve para enviar una especie de parametros utilizando el intent.putExtra
            aqui tambien declaramos una variable que almacena lo que contiene nuestros text view
            que tiene como nombre o id "aviso legal"
            en otras palabras la variable "accion" almacena el valor de variable "aviso legal"
             */
            intent.putExtra("accion","aviso_Legal");
           startActivity(intent);
            return true;
        }
        //aqui estamos enlazando 2 actividades para mostrar condiciones generales
        if (id == R.id.condiciones_generales) {
            Intent intent = new Intent(MainActivity.this, Aviso_legalActivity.class);
            intent.putExtra("accion","condiciones_generales");
            startActivity(intent);
            return true;

        }
        //aqui estamos enlazando 2 actividades para mostrar politica de privacidad
        if (id == R.id.politica_privacidad) {
            Intent intent = new Intent(MainActivity.this, Aviso_legalActivity.class);
            intent.putExtra("accion","politica_privacidad");
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.productos) {
            // Handle the camera action
        } else if (id == R.id.web) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.es/"));
            startActivity(intent);

 // linea de codigo para hacer llamada aqui tambien pedimos el permiso para poder
            // tener acceso a las llamadas
        } else if (id == R.id.llamar) {
            if(ActivityCompat.checkSelfPermission(
                    MainActivity.this, Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED){
                //Aquí tiene el permiso para llamar concedido
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:656410219"));
                startActivity(intent);
            }else{
                //lanzamos un dialog para que el usuario confirme o no el permiso
                ActivityCompat.requestPermissions(
                        MainActivity.this,

                        new String[] {Manifest.permission.CALL_PHONE},
                        MI_PERMISO_TELEFONO);
            }
        } else if (id == R.id.informacion) {
            Intent intent = new Intent(MainActivity.this, Aviso_legalActivity.class);
            intent.putExtra("accion","informacion");
            startActivity(intent);
            return true;

        } else if (id == R.id.ideas) {
            Intent intent = new Intent(MainActivity.this, Ideas_cocinasActivity.class);
            startActivity(intent);


    //aqui tenemos codigo para ver la localizacion del negocio
            } else if (id == R.id.localizacion) {
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://goo.gl/maps/SZ5ZJ4LmkjFwvwCj7"));
            startActivity(i);


        } else if (id == R.id.compartir_aplicacion) {
          //LINEA DE CODIGO para compartir aplicacion
            Intent i=new Intent();
            i.setAction(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.facebook.katana&hl=es_419");
            i.setType("text/plain");
            startActivity(i);

    } else if (id == R.id.compartir_localizacion) {
        //LINEA DE CODIGO para compartir aplicacion
        Intent i=new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_TEXT,"https://goo.gl/maps/nr5LZANXuWtdF5on7");
        i.setType("text/plain");
        startActivity(i);

        } else if (id == R.id.compartir_web) {
            //LINEA DE CODIGO para compartir aplicacion
            Intent i=new Intent();
            i.setAction(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_TEXT,"https://animeflv.net/browse?q=goku");
            i.setType("text/plain");
            startActivity(i);
    }


    DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }

