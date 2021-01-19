package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity implements DialogCwiczenia.DialogListener {

    private Button dodajCw;
    Button zakoncz;
    private TextView textViewNazwa;
    private TextView textViewSerie;
    private TextView textViewPowt;
    private TextView textViewObc;
    private ArrayList<Cwiczenia> cwiczenia;

    private RecyclerView mRecyclerViewC;
    private AdapterCwiczenia mAdapterC;
    private RecyclerView.LayoutManager mLayoutManagerC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        cwiczenia = (ArrayList<Cwiczenia>) PrefConfig.readCwiczenieFromPref(this);
        createCwiczenie();
        buildCwiczenia();


        zakoncz = findViewById(R.id.zakoncz);
        textViewNazwa = (TextView)findViewById(R.id.textViewNazwa);
        textViewSerie = (TextView) findViewById(R.id.textViewSerie);
        textViewPowt = (TextView) findViewById(R.id.textViewPowt);
        textViewObc = (TextView) findViewById(R.id.textViewObc);

        dodajCw = findViewById(R.id.addCw);

        zakoncz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                PrefConfig.writeCwiczenieInPref(getApplicationContext(), cwiczenia);

                showMainActivity2();
            }
        });

        dodajCw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogCwiczenia();
            }
        });

    }
    public void openDialogCwiczenia(){
            DialogCwiczenia dialogCwiczenia = new DialogCwiczenia();
            dialogCwiczenia.show(getSupportFragmentManager(), "dialog");
    }

    public void buildCwiczenia(){
        mRecyclerViewC = findViewById(R.id.recyclerViewCwiczenia);
        mRecyclerViewC.setHasFixedSize(true);

        mLayoutManagerC = new LinearLayoutManager(this);
        mAdapterC = new AdapterCwiczenia(cwiczenia);

        mRecyclerViewC.setLayoutManager(mLayoutManagerC);
        mRecyclerViewC.setAdapter(mAdapterC);

        mAdapterC.setOnItemClickListener(new AdapterCwiczenia.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    public void addItem(){
        int index = cwiczenia.size();
        cwiczenia.add(index, new Cwiczenia(String.valueOf(index+1), textViewNazwa.getText().toString(), textViewSerie.getText().toString(), textViewPowt.getText().toString(), textViewObc.getText().toString()));
        PrefConfig.writeCwiczenieInPref(getApplicationContext(), cwiczenia);
        mAdapterC.notifyDataSetChanged();
    }

    public void removeItem(int position){
        cwiczenia.remove(position);
        PrefConfig.writeCwiczenieInPref(getApplicationContext(), cwiczenia);
        mAdapterC.notifyItemRemoved(position);
    }

    public void createCwiczenie(){
        if(cwiczenia == null)
        cwiczenia = new ArrayList<>();

    }

    public void showMainActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    @Override
    public void sendText(String nazwaCw, String serieCw, String powtCw, String obciCw) {
        textViewNazwa.setText(nazwaCw);
        textViewSerie.setText(serieCw);
        textViewPowt.setText(powtCw);
        textViewObc.setText(obciCw);
        addItem();
    }
}