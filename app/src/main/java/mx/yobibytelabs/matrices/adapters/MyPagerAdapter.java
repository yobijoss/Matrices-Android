package mx.yobibytelabs.matrices.adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import mx.yobibytelabs.matrices.fragments.FragmentMatriz;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager manager) {
        super(manager);

    }

    @Override
    public Fragment getItem(int i) {
        FragmentMatriz fragmentMatriz = new FragmentMatriz();
        Bundle bundle = new Bundle();
        bundle.putInt("index", i + 1);
        fragmentMatriz.setArguments(bundle);
        return fragmentMatriz;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
