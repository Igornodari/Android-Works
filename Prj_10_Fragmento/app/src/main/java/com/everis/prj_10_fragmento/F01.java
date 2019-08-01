package com.everis.prj_10_fragmento;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class F01 extends Fragment {

    private boolean bStatus = false;

    private Context context;

    private CheckBox cb_android;
    private Button btn_mmv;

    public interface Abacaxi {
        void mudarTexto(String texto);
    }

    private Abacaxi delegate;

    public void setOnMudarTextoListener(Abacaxi delegate) {
        this.delegate = delegate;
    }

    //private MainActivity host;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.f01, container, false);

        inicializarVariavel(view);
        inicializarAcao();

        return view;
    }

    private void inicializarVariavel(View view) {
        context = getActivity();
        //host = (MainActivity) getActivity();
        //
        cb_android = view.findViewById(R.id.f01_cb_android);
        btn_mmv = view.findViewById(R.id.f01_btn_mmv);
    }

    private void inicializarAcao() {
        btn_mmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb_android.isChecked()){
                    //host.fazendoM("Android");
                    if (delegate != null){
                        bStatus = !bStatus;
                        if (bStatus){
                            delegate.mudarTexto("Android");
                        } else {
                            delegate.mudarTexto("Valor Original");
                        }
                    }

                } else {
                    Toast.makeText(context, "É nóis na fita", Toast.LENGTH_SHORT).show();

                    //getActivity().finish();
                }

            }
        });
    }
}
