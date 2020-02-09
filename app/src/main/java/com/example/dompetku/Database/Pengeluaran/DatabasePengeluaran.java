package com.example.dompetku.Database.Pengeluaran;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Pengeluaran.class},version = 1)
public abstract class DatabasePengeluaran extends RoomDatabase {
    public abstract DaoPengeluran daoPengeluran();
}
