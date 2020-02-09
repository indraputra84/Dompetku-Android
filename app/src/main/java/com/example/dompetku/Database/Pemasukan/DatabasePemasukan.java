package com.example.dompetku.Database.Pemasukan;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pemasukan.class},version = 1)
public abstract class DatabasePemasukan extends RoomDatabase {
    public abstract DaoPemasukan daoPemasukan();
}
