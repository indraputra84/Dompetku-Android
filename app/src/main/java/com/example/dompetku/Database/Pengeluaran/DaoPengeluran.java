package com.example.dompetku.Database.Pengeluaran;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dompetku.Database.Pemasukan.Pemasukan;

import java.util.List;

@Dao
public interface DaoPengeluran {
    @Insert
    public void AddData(Pengeluaran pengeluaran);

    @Query("SELECT * FROM pengeluaran")
    public List<Pengeluaran> getData();

    @Update
    public  void updateData(Pengeluaran pengeluaran);

    @Delete
    public  void deleteData(Pengeluaran pengeluaran);

}
