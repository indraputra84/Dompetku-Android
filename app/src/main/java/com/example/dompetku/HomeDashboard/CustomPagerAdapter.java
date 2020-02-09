package com.example.dompetku.HomeDashboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.dompetku.HomeDashboard.Pemasukan.ReadPemasukanFragment;
import com.example.dompetku.HomeDashboard.Pengeluaran.ReadPengeluaranFragment;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] childFragments;

    public CustomPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        childFragments = new Fragment[]{
                new ReadPemasukanFragment(),
                new ReadPengeluaranFragment()
        };
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return childFragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Pemasukan";
        } else {
            title = "Pengeluaran";
        }
        return title.subSequence(title.lastIndexOf(".") + 1, title.length());
    }


}
