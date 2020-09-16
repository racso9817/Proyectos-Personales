package com.example.examenpracticojorgeayala;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListView extends ArrayAdapter<String> {
    private String [] posicion;
    private String [] fecha;
    private Activity context;

    public CustomListView(Activity context, String[] posicion,String[] fecha) {
        super(context, R.layout.diseno,posicion);
        this.context=context;
        this.posicion=posicion;
        this.fecha=fecha;
    }

    @NonNull
    @Override

    public View getView(int p, @Nullable View convertView, @NonNull ViewGroup parent){
        View r = convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.diseno,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)r.getTag();
        }
            viewHolder.tvw1.setText(posicion[p]);
            viewHolder.tvw2.setText(fecha[p]);


        return r;
    }

    class ViewHolder{
        TextView tvw1;
        TextView tvw2;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvposicion);
            tvw2=(TextView)v.findViewById((R.id.tvfecha));
        }
    }

}
