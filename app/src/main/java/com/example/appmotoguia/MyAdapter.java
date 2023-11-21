package com.example.appmotoguia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList umarca, umodelo;
    LayoutInflater layoutInflater;

    public MyAdapter(Context context, ArrayList umarca, ArrayList umodelo){
        this.context = context;
        this.umarca = umarca;
        this.umodelo = umodelo;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_items, parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.marcas.setText(String.valueOf(umarca.get(position)));
        holder.modelos.setText(String.valueOf(umodelo.get(position)));

    }

    @Override
    public int getItemCount() {
        return umarca.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView marcas, modelos;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            marcas = itemView.findViewById(R.id.textView);
            modelos = itemView.findViewById(R.id.textView2);

        }
    }
}
