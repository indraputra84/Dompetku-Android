package com.example.dompetku.HomeDashboard.Pemasukan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dompetku.Database.Pemasukan.Pemasukan;
import com.example.dompetku.Database.Pengeluaran.Pengeluaran;
import com.example.dompetku.HomeActivity;
import com.example.dompetku.HomeDashboard.HomeFragment;
import com.example.dompetku.HomeDashboard.Pengeluaran.AdapterRVPengeluaran;
import com.example.dompetku.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ReadPemasukanFragment extends Fragment {


    public ReadPemasukanFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Pemasukan> dataSet = new ArrayList<>();
    FloatingActionButton add_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_pemasukan, container, false);

        dataSet =new ArrayList<Pemasukan>();
        recyclerView =view.findViewById(R.id.rv_pemasukan);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Pemasukan> getData = (ArrayList<Pemasukan>) HomeActivity.databasePemasukan.daoPemasukan().getData();
        adapter = new AdapterRVPemasukan(getContext(), getData);
        recyclerView.setAdapter(adapter);

        add_btn = view.findViewById(R.id.btn_add_pemasukan);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fl_container, new AddPemasukanFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

}