package com.example.dompetku.HomeDashboard.Pengeluaran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dompetku.Database.Pengeluaran.Pengeluaran;
import com.example.dompetku.R;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.Inflater;

public class AdapterRVPengeluaran extends RecyclerView.Adapter<AdapterRVPengeluaran.ViewHolder> {

    private ArrayList<Pengeluaran> data;

    public AdapterRVPengeluaran(Context context, ArrayList<Pengeluaran> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AdapterRVPengeluaran.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pengeluaran,parent,false);
        ViewHolder vh =new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRVPengeluaran.ViewHolder holder, int position) {
        Locale localeId = new Locale("in","ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeId);

        final Pengeluaran pengeluaran = data.get(position);
        holder.pengeluaran.setText(pengeluaran.getPengeluaran());
        int uang = pengeluaran.getNominal();
        holder.nominal.setText(formatRupiah.format((double)uang));
        holder.dateNow.setText(pengeluaran.getDateNow());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pengeluaran,nominal,dateNow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pengeluaran = itemView.findViewById(R.id.txt_pengeluaran);
            nominal = itemView.findViewById(R.id.txt_nominal);
            dateNow = itemView.findViewById(R.id.txt_dateNow);
        }
    }
}
