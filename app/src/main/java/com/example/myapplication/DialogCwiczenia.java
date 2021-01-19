package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogCwiczenia extends AppCompatDialogFragment {
    private EditText editTextNazwaCw;
    private EditText editTextSerieCw;
    private EditText editTextPowtCw;
    private EditText editTextObciazenieCw;
    private DialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogcwiczenia, null);

        builder.setView(view)
                .setTitle("Wprowadź dane: ")
                .setNegativeButton("Wyjdź", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Dodaj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nazwaCw = editTextNazwaCw.getText().toString();
                        String serieCw = editTextSerieCw.getText().toString();
                        String powtCw = editTextPowtCw.getText().toString();
                        String obciCw = editTextObciazenieCw.getText().toString();
                        listener.sendText(nazwaCw, serieCw, powtCw, obciCw);
                    }
                });
        editTextNazwaCw = view.findViewById(R.id.editNazwaCw);
        editTextSerieCw = view.findViewById(R.id.editSerieCw);
        editTextPowtCw = view.findViewById(R.id.editPowtCw);
        editTextObciazenieCw = view.findViewById(R.id.editObciazenieCw);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener =(DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DialogListener");
        }
    }

    public interface  DialogListener{
        void sendText(String nazwaCw, String serieCw, String powtCw, String obciCw);
    }

}
