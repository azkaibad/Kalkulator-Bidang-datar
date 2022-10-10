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


public class KetigaFragment extends Fragment {
    private Button btnHasil;
    private EditText txt_diameter;
    private TextView hasil, hasil2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ketiga, container, false);

        btnHasil = v.findViewById(R.id.btnHasil);
        txt_diameter = v.findViewById(R.id.txt_diameter);
        hasil = v.findViewById(R.id.hasil);
        hasil2 = v.findViewById(R.id.hasil2);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                String nilai = txt_diameter.getText().toString();
                if (nilai.isEmpty()){
                    txt_diameter.setError("Data tidak boleh kosong");
                    txt_diameter.requestFocus();
                }else {
                    Double diameter = Double.parseDouble(nilai);
                    Double luas = 3.14 * (diameter * diameter) * 0.25;
                    Double keliling = 3.14 * diameter;
                    hasil.setText(String.format("%.2f",luas));
                    hasil2.setText(String.format("%.2f", keliling));
                }
            }
        });

        return v;
    }
}