package com.example.dompetku.HomeDashboard.Pengeluaran;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dompetku.Database.Pengeluaran.Pengeluaran;
import com.example.dompetku.HomeActivity;
import com.example.dompetku.HomeDashboard.Pemasukan.AddPemasukanFragment;
import com.example.dompetku.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadPengeluaranFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Pengeluaran> dataSet = new ArrayList<>();

    FloatingActionButton add_btn;
    public ReadPengeluaranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_pengeluaran, container, false);

        dataSet =new ArrayList<Pengeluaran>();
        recyclerView =view.findViewById(R.id.rv_pengeluaran);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Pengeluaran> getData = (ArrayList<Pengeluaran>) HomeActivity.databasePengeluaran.daoPengeluran().getData();
        adapter = new AdapterRVPengeluaran(getContext(), getData);
        recyclerView.setAdapter(adapter);

        add_btn = view.findViewById(R.id.btn_add_pengeluaran);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.fragmentManager.beginTransaction().replace(R.id.fl_container,new AddPengeluaranFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
