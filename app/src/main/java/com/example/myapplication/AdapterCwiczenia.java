package com.example.myapplication;

import android.content.DialogInterface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterCwiczenia extends RecyclerView.Adapter<AdapterCwiczenia.ViewHolder>{

    private ArrayList<Cwiczenia> mCwiczenia;
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener){ mListener = listener;}

    public interface OnItemClickListener{
        void onDeleteClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView numerCw;
        public TextView nazwaCw;
        public TextView serieCw;
        public TextView powtCw;
        public TextView obciazenieCw;
        public ImageView usunCw;
        public ViewHolder(@NonNull View itemView, final AdapterCwiczenia.OnItemClickListener listener) {
            super(itemView);

            numerCw = itemView.findViewById(R.id.numer);
            nazwaCw = itemView.findViewById(R.id.nazwaCw);
            serieCw = itemView.findViewById(R.id.serieVar);
            powtCw = itemView.findViewById(R.id.powtorzeniaVar);
            obciazenieCw = itemView.findViewById(R.id.obciazenieVar);
            usunCw = itemView.findViewById(R.id.usunBTNCw);

            usunCw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public AdapterCwiczenia(ArrayList<Cwiczenia> cwiczenia){
        mCwiczenia = cwiczenia;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewcwiczenia, parent, false);
        ViewHolder vh = new ViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cwiczenia currItem = mCwiczenia.get(position);

        holder.numerCw.setText(currItem.getNumerCwiczenia());
        holder.nazwaCw.setText(currItem.getNazwaCwiczenia());
        holder.serieCw.setText(currItem.getSerieCwiczenia());
        holder.powtCw.setText(currItem.getPowtorzeniaCwiczenia());
        holder.obciazenieCw.setText(currItem.getObciazenieCwiczenia());

    }

    @Override
    public int getItemCount() {

        return mCwiczenia.size();
    }
}
