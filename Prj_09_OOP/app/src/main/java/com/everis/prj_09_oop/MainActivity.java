package com.everis.prj_09_oop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.everis.prj_09_oop.shugo.Veiculo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Veiculo ve1 = new Veiculo();
        HMAux aux = new HMAux();

        ve1.fazerSaudacao("Hugo");
        ve1.fazerSaudacao("Hugo");

        Carro ca1 = new Carro();


        String res = ca1.herdeiro("Hugo");

        BotaoHugo btna = new BotaoA();
        btna.setOnClickListener(new BotaoHugo.IBB() {
            @Override
            public void click() {

            }

            @Override
            public void maiscoisa() {

            }
        });


        teste(new CarroDao());
        teste(new PQLiteDao());





    }

    public void teste(Dao carroDao){

    }
}
