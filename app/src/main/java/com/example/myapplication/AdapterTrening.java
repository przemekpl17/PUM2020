package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterTrening extends RecyclerView.Adapter<AdapterTrening.ViewHolder>  {

    private ArrayList<Trening> mTrening;
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nazwa_t;
        public TextView dzien_t;
        public ImageView usunIMG;


        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            nazwa_t = itemView.findViewById(R.id.nazwa_treningu);
            dzien_t = itemView.findViewById(R.id.dzien_tyg);
            usunIMG = itemView.findViewById(R.id.usunBTN);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            usunIMG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });

        }
    }

    public AdapterTrening(ArrayList<Trening> trening){
        mTrening = trening;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewtrening, parent, false);
        ViewHolder vh = new ViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Trening currentItem = mTrening.get(position);
            holder.nazwa_t.setText(currentItem.getNazwa_treningu());
            holder.dzien_t.setText(currentItem.getDzien_tygodnia());



    }

    @Override
    public int getItemCount() {
        return mTrening.size();
    }
}
