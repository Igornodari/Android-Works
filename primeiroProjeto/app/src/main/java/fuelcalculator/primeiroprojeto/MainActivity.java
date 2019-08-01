package fuelcalculator.primeiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

private EditText precoAlcool;
private  EditText precoGasolina;
private Button botao;
private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           //Localiza os componentes da TELA

        precoAlcool=(EditText) findViewById(R.id.precoAlcoolID);
        precoGasolina=(EditText)findViewById(R.id.precoGasolinaID);
        botao=(Button) findViewById(R.id.botaoID);
        result=(TextView) findViewById(R.id.resultID);

    botao.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Recuperar os valores digitados
            String txtprecoAlcool=precoAlcool.getText().toString();
            String txtprecoGasolina=precoGasolina.getText().toString();

            //Convertendo valores

            Double valorAlcool=Double.parseDouble(txtprecoAlcool);
            Double valorGasolina=Double.parseDouble(txtprecoGasolina);

            // ALCOOL/GASOLINA

            Double resultado=valorAlcool/valorGasolina;

            if(resultado>=0.7){
                result.setText("Melhor Gasolina");
            }else {
                result.setText("Melhor Alcool");
            }


        }
    });

    }
}
