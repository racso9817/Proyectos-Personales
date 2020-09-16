package com.example.proyectotema4pst;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListView extends ArrayAdapter<String> {
    private String [] cedula;
    private String [] nombre;
    private String [] apellido;
    private String [] temp;
    private String [] gel;
    private String [] fecha;
    private String [] hora;
    private Activity context;

    public CustomListView(Activity context, String[] cedula,String[] nombre,String[] apellido,String[] temp, String[] gel,String[] fecha,String[] hora) {
        super(context, R.layout.diseno,nombre);
        this.context=context;
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.temp=temp;
        this.gel=gel;
        this.fecha=fecha;
        this.hora=hora;
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

        String ing = (temp[p]).replace("C","");
        float compare = Float.parseFloat(ing);
        if(compare>=37f){
            viewHolder.tvw1.setText(nombre[p]);
            viewHolder.tvw1.setTextColor(android.graphics.Color.RED);
            viewHolder.tvw2.setText(apellido[p]);
            viewHolder.tvw2.setTextColor(android.graphics.Color.RED);
            viewHolder.tvw.setText(cedula[p]);
            viewHolder.tvw.setTextColor(android.graphics.Color.RED);
            viewHolder.tvw3.setText(fecha[p]);
            viewHolder.tvw3.setTextColor(android.graphics.Color.RED);
            viewHolder.tvw4.setText(hora[p]);
            viewHolder.tvw4.setTextColor(android.graphics.Color.RED);
            viewHolder.tvw5.setText(gel[p]);
            viewHolder.tvw5.setTextColor(android.graphics.Color.RED);
            viewHolder.tvw6.setText(temp[p]);
            viewHolder.tvw6.setTextColor(android.graphics.Color.RED);
        }
        else{
            viewHolder.tvw1.setText(nombre[p]);
            viewHolder.tvw2.setText(apellido[p]);
            viewHolder.tvw.setText(cedula[p]);
            viewHolder.tvw3.setText(fecha[p]);
            viewHolder.tvw4.setText(hora[p]);
            viewHolder.tvw5.setText(gel[p]);
            viewHolder.tvw6.setText(temp[p]);
        }

        return r;
    }

    class ViewHolder{
        TextView tvw;
        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        TextView tvw4;
        TextView tvw5;
        TextView tvw6;
        ImageView iv;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvname);
            tvw2=(TextView)v.findViewById((R.id.tvapellido));
            tvw=(TextView)v.findViewById(R.id.tvcedula);
            tvw3=(TextView)v.findViewById(R.id.tvfecha);
            tvw4=(TextView)v.findViewById(R.id.tvhora);
            tvw5=(TextView)v.findViewById(R.id.tvgel);
            tvw6=(TextView)v.findViewById(R.id.tvtemp);
        }
    }

}
