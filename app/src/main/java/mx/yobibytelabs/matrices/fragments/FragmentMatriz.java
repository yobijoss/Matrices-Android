package mx.yobibytelabs.matrices.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.yobibytelabs.matrices.R;

/**
 * Created by jagspage2013 on 24/08/14.
 */
public class FragmentMatriz extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_matriz,null);
        return view;
    }
}
