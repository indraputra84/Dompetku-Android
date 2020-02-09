package com.example.dompetku.HomeDashboard.Pemasukan;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dompetku.Database.Pemasukan.Pemasukan;
import com.example.dompetku.HomeActivity;
import com.example.dompetku.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPemasukanFragment extends Fragment {

    Button save;
    EditText et_pemasukan,et_nominal;
    TextInputLayout layoutPemasukan, layoutNominal;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String date;

    public AddPemasukanFragment() {
        // Required empty public constructor
    }

    public void initViews(View view){
        save = view.findViewById(R.id.btn_save);
        et_nominal = view.findViewById(R.id.et_nominal);
        et_pemasukan = view.findViewById(R.id.et_pemasukan);
        layoutPemasukan = view.findViewById(R.id.layout_pemasukan);
        layoutNominal = view.findViewById(R.id.layout_nominal);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("EEE, MMM d, ''yyyy");
        date = simpleDateFormat.format(calendar.getTime());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_pemasukan, container, false);
        initViews(view);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    Pemasukan pemasukan = new Pemasukan();
                    pemasukan.setPemasukan(et_pemasukan.getText().toString());
                    pemasukan.setNominal(Integer.parseInt(et_nominal.getText().toString()));
                    pemasukan.setDateNow(date);

                    Toast.makeText(getContext(), "Data berhasil tersimpan", Toast.LENGTH_LONG).show();
                    HomeActivity.databasePemasukan.daoPemasukan().AddData(pemasukan);

                    et_pemasukan.setText("");
                    et_nominal.setText("");
                }
            }
        });

        return view;
    }

    public boolean validate(){
        boolean valid = false;
        String Pemasukan = et_pemasukan.getText().toString();
        String Nominal = et_nominal.getText().toString();

        if (Pemasukan.isEmpty()){
            valid = false;
            layoutPemasukan.setError("Mohon isi pemasukan");
        }else {
            valid = true;
            layoutPemasukan.setError(null);
        }

        if (Nominal.isEmpty()){
            valid = false;
            layoutNominal.setError("Mohon isi nominal");
        }else {
            valid = true;
            layoutNominal.setError(null);
        }


        return valid;
    }

}
