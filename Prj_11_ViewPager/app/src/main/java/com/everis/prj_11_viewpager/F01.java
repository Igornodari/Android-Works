package com.everis.prj_11_viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class F01 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.f01, container, false);


        inicializarVariavel(view);
        inicializarAcao();

        return view;
    }

    private void inicializarVariavel(View view) {

    }

    private void inicializarAcao() {

    }
}
