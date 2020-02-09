package com.example.dompetku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.dompetku.Database.Pemasukan.DatabasePemasukan;
import com.example.dompetku.Database.Pengeluaran.DatabasePengeluaran;
import com.example.dompetku.HomeDashboard.AccountFragment;
import com.example.dompetku.HomeDashboard.HomeFragment;
import com.example.dompetku.Saldo.SaldoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static FragmentManager fragmentManager;
    public static DatabasePengeluaran databasePengeluaran;
    public static DatabasePemasukan databasePemasukan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        databasePengeluaran = Room.databaseBuilder(getApplicationContext(), DatabasePengeluaran.class,"pengeluaran").allowMainThreadQueries().build();
        databasePemasukan = Room.databaseBuilder(getApplicationContext(), DatabasePemasukan.class,"pemasukan").allowMainThreadQueries().build();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home_menu:
                fragment = new HomeFragment();
                break;
            case R.id.saldo_menu:
                fragment = new SaldoFragment();
                break;
            case R.id.home_account_menu:
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,fragment).commit();
            return true;
        }
        return false;
    }

}
