package com.example.kalkulatorbangundatar;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KeduaFragment extends Fragment {
    private EditText txt_alas, txt_tinggi;
    private Button btnHasil;
    private TextView hasil, hasil2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kedua, container, false);

        txt_alas = v.findViewById(R.id.txt_alas);
        txt_tinggi = v.findViewById(R.id.txt_tinggi);
        btnHasil = v.findViewById(R.id.btnHasil);
        hasil = v.findViewById(R.id.hasil);
        hasil2 = v.findViewById(R.id.hasil2);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                String nilai1 = txt_alas.getText().toString();
                String nilai2 = txt_tinggi.getText().toString();

                if (nilai1.isEmpty()){
                    txt_alas.setError("Data tidak boleh kosong");
                    txt_alas.requestFocus();
                }else if (nilai2.isEmpty()){
                    txt_tinggi.setError("Data tidak boleh kosong");
                    txt_tinggi.requestFocus();
                }else {
                    Double alas = Double.parseDouble(nilai1);
                    Double tinggi = Double.parseDouble(nilai2);

                    Double luas = 0.5 * alas * tinggi;
                    Double keliling = tinggi + tinggi + alas;
                    hasil.setText(String.format("%.2f", luas));
                    hasil2.setText(String.format("%.2f", keliling));
                }
            }

        });

        return v;
    }
}