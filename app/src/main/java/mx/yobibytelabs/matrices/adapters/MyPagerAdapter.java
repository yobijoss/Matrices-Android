package mx.yobibytelabs.matrices.adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import mx.yobibytelabs.matrices.fragments.MatrixFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager manager) {
        super(manager);

    }

    @Override
    public Fragment getItem(int i) {
        MatrixFragment matrixFragment = new MatrixFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", i + 1);
        matrixFragment.setArguments(bundle);
        return matrixFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
