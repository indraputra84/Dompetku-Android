package com.example.dompetku.Database.Pemasukan;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoPemasukan {

    @Insert
    public void AddData(Pemasukan pemasukan);

    @Query("SELECT * FROM pemasukan")
    public List<Pemasukan> getData();

    @Update
    public  void updateData(Pemasukan pemasukan);

    @Delete
    public  void deleteData(Pemasukan pemasukan);

//    @Query("SELECT SUM(nominal) From pemasukan")
//    public List<Pemasukan> getTotal();
}
