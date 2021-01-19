package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
    private EditText editTextnazwa;
    private EditText editTextdzien;
    private DialogListener dListener;
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog, null);

        builder.setView(view).setTitle("Wprowadź dane: ")
                .setNegativeButton("Wyjdź", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Dodaj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nazwaTreningu = editTextnazwa.getText().toString();
                        String dzienTyg = editTextdzien.getText().toString();
                        dListener.sendText(nazwaTreningu, dzienTyg);

                    }
        });

        editTextnazwa = view.findViewById(R.id.nazwa_T);
        editTextdzien = view.findViewById(R.id.dzien_T);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            dListener =(DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException((context).toString() + " must implement Dialog Listener");
        }
    }

    public interface DialogListener{
        void sendText(String nazwa, String dzien);
    }
}
