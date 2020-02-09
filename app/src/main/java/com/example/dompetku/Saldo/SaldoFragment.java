package com.example.dompetku.Saldo;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dompetku.Database.Pemasukan.Pemasukan;
import com.example.dompetku.Database.Pengeluaran.Pengeluaran;
import com.example.dompetku.HomeActivity;
import com.example.dompetku.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class SaldoFragment extends Fragment {


    private SQLiteDatabase db;
    TextView nominal_pemasukan,nominal_pengeluaran,total_all;

    public SaldoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_saldo, container, false);
        nominal_pemasukan = view.findViewById(R.id.nominal_pemasukan);
        nominal_pengeluaran = view.findViewById(R.id.nominal_pengeluaran);
        total_all = view.findViewById(R.id.nominal_all);

        Locale localeId = new Locale("in","ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeId);

        int totalPemasukan = 0;

        List<Pemasukan> getTotal = HomeActivity.databasePemasukan.daoPemasukan().getData();
        for(Pemasukan pemasukan : getTotal){
            int i = pemasukan.getNominal();
            totalPemasukan = totalPemasukan + i;
        }
        nominal_pemasukan.setText(""+formatRupiah.format((double)totalPemasukan));

        int totalPengeluaran = 0;
        List<Pengeluaran> getTotalPengeluaran = HomeActivity.databasePengeluaran.daoPengeluran().getData();
        for (Pengeluaran pengeluaran : getTotalPengeluaran){
            int i = pengeluaran.getNominal();
            totalPengeluaran = i + totalPengeluaran;
        }
        nominal_pengeluaran.setText(""+formatRupiah.format((double)totalPengeluaran));
        int total = totalPemasukan-totalPengeluaran;
        total_all.setText(""+formatRupiah.format((double)total));
        
        return view;
    }

}
