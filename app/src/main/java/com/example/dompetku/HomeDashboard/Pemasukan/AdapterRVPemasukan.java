package com.example.dompetku.HomeDashboard.Pemasukan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dompetku.Database.Pemasukan.Pemasukan;
import com.example.dompetku.HomeDashboard.Pengeluaran.AdapterRVPengeluaran;
import com.example.dompetku.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdapterRVPemasukan extends RecyclerView.Adapter<AdapterRVPemasukan.ViewHolder> {

    private ArrayList<Pemasukan> data;

    public AdapterRVPemasukan(Context context,ArrayList<Pemasukan> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pemasukan,parent,false);
        AdapterRVPemasukan.ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Locale localeId = new Locale("in","ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeId);

        final Pemasukan pemasukan = data.get(position);
        holder.pemasukan.setText(pemasukan.getPemasukan());
        int uang = pemasukan.getNominal();
        holder.nominal.setText(formatRupiah.format((double)uang));
        holder.dateNow.setText(pemasukan.getDateNow());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pemasukan,nominal,dateNow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pemasukan = itemView.findViewById(R.id.txt_pemasukan);
            nominal = itemView.findViewById(R.id.txt_nominal);
            dateNow = itemView.findViewById(R.id.txt_dateNow);
        }
    }
}
