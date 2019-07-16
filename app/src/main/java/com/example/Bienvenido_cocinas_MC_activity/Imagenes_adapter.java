package com.example.Bienvenido_cocinas_MC_activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Imagenes_adapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> listaimagenes;

    public Imagenes_adapter(Context paramContext, ArrayList<String> paramArrayList)
    {
        super(paramContext, R.layout.item_imagenes, paramArrayList);
        this.context = paramContext;
        this.listaimagenes = paramArrayList;
    }

    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        if (paramView == null)
            paramView = LayoutInflater.from(getContext()).inflate(R.layout.item_imagenes, paramViewGroup, false);
        ImageView localImageView = (ImageView)paramView.findViewById(R.id.img_item);
        String str = (String)this.listaimagenes.get(paramInt);
        localImageView.setImageResource(this.context.getResources().getIdentifier(str, "drawable", this.context.getPackageName()));


        localImageView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(context, ZoomActivity.class);
                ImageView imageView = (ImageView)v;
                //Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                //ByteArrayOutputStream btStream = new ByteArrayOutputStream();
                //bitmap.compress(Bitmap.CompressFormat.PNG, 100, btStream);
                //byte[] byteArray = btStream.toByteArray();

                //intent.putExtra("imagen", byteArray);
                intent.putExtra("nombre", listaimagenes.get(paramInt));
                context.startActivity(intent);
                Toast.makeText(context,"pulsa imagen",Toast.LENGTH_LONG).show();
            }
        });

        return paramView;
    }
}
