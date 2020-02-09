package com.example.dompetku.HomeDashboard.Pengeluaran;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dompetku.Database.Pengeluaran.Pengeluaran;
import com.example.dompetku.HomeActivity;
import com.example.dompetku.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPengeluaranFragment extends Fragment {

    TextInputLayout layout_pengeluaran,layout_nominal;
    EditText et_pengeluaran,et_nominal;
    Button save;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String date;

    public AddPengeluaranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_pengeluaran, container, false);
        init(view);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valdiate()){
                    Pengeluaran pengeluaran = new Pengeluaran();
                    pengeluaran.setNominal(Integer.parseInt(et_nominal.getText().toString()));
                    pengeluaran.setPengeluaran(et_pengeluaran.getText().toString());
                    pengeluaran.setDateNow(date);

                    Toast.makeText(getContext(), "Data berhasil tersimpan", Toast.LENGTH_LONG).show();
                    HomeActivity.databasePengeluaran.daoPengeluran().AddData(pengeluaran);

                    et_nominal.setText("");
                    et_pengeluaran.setText("");
                }
            }
        });

        return view;
    }

    public void init(View view){
        et_pengeluaran = view.findViewById(R.id.et_pengeluaran);
        et_nominal = view.findViewById(R.id.et_nominal);

        layout_pengeluaran = view.findViewById(R.id.layout_pengeluaran);
        layout_nominal = view.findViewById(R.id.layout_nominal);
        save = view.findViewById(R.id.btn_save);
//        Show date now;
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("EEE, MMM d, ''yyyy");
        date = simpleDateFormat.format(calendar.getTime());
    }

    public boolean valdiate(){
        boolean valid = false;

        String pengeluaran = et_pengeluaran.getText().toString();
        String nominal = et_nominal.getText().toString();

        if(pengeluaran.isEmpty()){
            valid = false;
            layout_pengeluaran.setError("Mohon isi pengeluaran");
        }else{
            valid = true;
            layout_pengeluaran.setError(null);
        }

        if (nominal.isEmpty()){
            valid = false;
            layout_nominal.setError("Mohon isi nominal");
        }
        else{
            valid = true;
            layout_nominal.setError(null);
        }

        return valid;
    }

}
