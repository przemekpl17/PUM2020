package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements Dialog.DialogListener {
    private Button addBTN;
    private ArrayList<Trening> trening ;
    private RecyclerView mRecyclerViewT;
    private AdapterTrening mAdapterT;
    private RecyclerView.LayoutManager mLayoutManagerT;
    private TextView test1,test2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        trening = (ArrayList<Trening>) PrefConfig.readTreningFromPref(this);
        createTrening();
        buildRecyclerViewTrening();

        test1 = findViewById(R.id.test1);
        test2 = findViewById(R.id.test2);

        addBTN = (Button) findViewById(R.id.addBTN);

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }

    public void openDialog(){
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "Dialog");
    }

    public void addItem(){
        int index = trening.size();
        trening.add(index, new Trening(test1.getText().toString(),  test2.getText().toString()));
        PrefConfig.writeTreningInPref(getApplicationContext(), trening);
        mAdapterT.notifyDataSetChanged();
    }

    public void removeItem(int position){
        trening.remove(position);
        PrefConfig.writeTreningInPref(getApplicationContext(), trening);
        mAdapterT.notifyItemRemoved(position);
    }

    private void createTrening(){
        if(trening == null)
        trening = new ArrayList<>();
    }
    public void showMainActivity5(){
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    private void buildRecyclerViewTrening(){
        mRecyclerViewT = findViewById(R.id.recyclerViewTrening);
        mRecyclerViewT.setHasFixedSize(true);

        mLayoutManagerT = new LinearLayoutManager(this);
        mAdapterT = new AdapterTrening(trening);

        mRecyclerViewT.setLayoutManager(mLayoutManagerT);
        mRecyclerViewT.setAdapter(mAdapterT);

        mAdapterT.setOnItemClickListener(new AdapterTrening.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                showMainActivity5();
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    @Override
    public void sendText(String nazwa, String dzien) {
        test1.setText(nazwa);
        test2.setText(dzien);
        addItem();

    }
}