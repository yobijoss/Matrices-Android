package mx.yobibytelabs.matrices.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mx.yobibytelabs.matrices.fragments.FragmentMatriz;

/**
 * Created by jagspage2013 on 24/08/14.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager manager){
        super(manager);

    }

    @Override
    public Fragment getItem(int i) {
        FragmentMatriz fragmentMatriz = new FragmentMatriz();
        Bundle bundle = new Bundle();
        bundle.putInt("index",i +1);
        fragmentMatriz.setArguments(bundle);
        return fragmentMatriz;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
