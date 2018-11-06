package mx.yobibytelabs.matrices.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import mx.yobibytelabs.matrices.R;

/**
 * Created by jagspage2013 on 24/08/14.
 */
public class FragmentMatriz extends Fragment {

    private int arg;
    private EditText valores[][];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arg = getArguments().getInt("index");
        valores = new EditText[4][4];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_matriz_4_4, null);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int id = getResources().getIdentifier("R.id.editText" + i + j, "id", "mx.yobibytelabs.matrices");
                valores[i][j] = (EditText) view.findViewById(id);
            }
        }
        return view;
    }
}
