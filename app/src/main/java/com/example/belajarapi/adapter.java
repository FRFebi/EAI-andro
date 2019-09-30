package com.example.belajarapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.dataViewHolder> {

    ArrayList<dataAPI> dataHolderArrayList;
    Context context;

    public adapter(ArrayList<dataAPI> dataHolderArrayList, Context context){
        this.dataHolderArrayList= dataHolderArrayList;
        this.context= context;
    }

    @NonNull
    @Override
    public adapter.dataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new adapter.dataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.dataViewHolder dataViewHolder, int i) {
        dataViewHolder.item_lagu.setText(dataHolderArrayList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataHolderArrayList.size();
    }

    public class dataViewHolder extends RecyclerView.ViewHolder{

        TextView item_lagu;

        public dataViewHolder(@NonNull View itemView){
            super(itemView);
            item_lagu = itemView.findViewById(R.id.data_lagu);
        }
    }
}
