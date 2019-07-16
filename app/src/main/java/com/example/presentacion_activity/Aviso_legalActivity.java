package com.example.presentacion_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.Bienvenido_cocinas_MC_activity.R;

public class Aviso_legalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        /*para mostrar de terminado contenido en un textview
        primero debemos declarar el tipo de varible que utilizaremos
        en este caso "accion" tipo string
        txtTitulo= es el nombre del TextView

         */

        String accion = getIntent().getExtras().getString("accion");
        TextView txtTitulo = findViewById(R.id.txtTitulo2);
        TextView txttexto = findViewById(R.id.txtContenido);
        /*aqui decimos que si la accion o seleccion del usuario es "aviso legal"
        entonces muestro lo que se guarda en el strings xml con dicho nombre
        de la misma manera lo hacaemos con titulo y las demas opciones
         */
        if (accion.equals("aviso_Legal")) {
            txtTitulo.setText("Aviso Legal");  // aqui estamos diciendo que en el texview que tiene como nombre "txtTitulo" se muestre "aviso legal"
            txttexto.setText(R.string.aviso_legal);
        }
            if (accion.equals("condiciones_generales")) {
                txtTitulo.setText("Condiciones Generales");
                txttexto.setText(R.string.condiciones_generales);
            }
            if (accion.equals("politica_privacidad")) {
                txtTitulo.setText("Politica de Privacidad");
                txttexto.setText(R.string.politica_privacidad);
                }
        if (accion.equals("informacion")) {
            txtTitulo.setText("Información");
            txttexto.setText("Bienvenido a Cocinas MC\n" +
                    "Dirección ETXE ONDO N-2 BAJO \n" +
                    "20250 BILLABONA  (GIPUZKOA)\n" +
                    "Nuestros horarios de atención son los siguientes:\n" +
                    "De lunes a viernes de  16:00 a 20:00\n" +
                    "Por las mañanas de lunes a sábado se atiende con cita previa llamando a\n" +
                    "Teléfono: 943694529\n" +
                    "Móvil: 656410219 (atendemos también WhatsApp)\n" +
                    "Y  por correo electrónico: cocinasmc@gmail.com\n");
        }
        }
    }
