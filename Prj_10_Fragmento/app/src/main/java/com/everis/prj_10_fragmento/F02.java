package com.everis.prj_10_fragmento;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class F02 extends Fragment {

    private Context context;

    private TextView tv_vo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.f02, container, false);

        inicializarVariavel(view);
        inicializarAcao();

        return view;
    }

    private void inicializarVariavel(View view) {
        context = getActivity();

        tv_vo = view.findViewById(R.id.f02_tv_vo);

    }

    private void inicializarAcao() {

    }

    public void changeTexto(String texto){
        if (tv_vo != null){
            tv_vo.setText(texto);
        }
    }
}
