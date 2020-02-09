package com.example.dompetku.Database.Pemasukan;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pemasukan")
public class Pemasukan {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "pemasuakan")
    String pemasukan;

    @ColumnInfo(name = "nominal")
    int nominal;

    @ColumnInfo(name = "dateNow")
    String dateNow;

    public String getDateNow() {
        return dateNow;
    }

    public void setDateNow(String dateNow) {
        this.dateNow = dateNow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(String pemasukan) {
        this.pemasukan = pemasukan;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}
