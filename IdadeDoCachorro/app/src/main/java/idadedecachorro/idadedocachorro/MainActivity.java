package idadedecachorro.idadedocachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText idadeDog;
    private Button botao;
    private TextView idadehumana;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     idadeDog=(EditText)findViewById(R.id.idadeDogID);
     botao=(Button)findViewById(R.id.buttonid);
     idadehumana=(TextView)findViewById(R.id.resultId);

     botao.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             String idadeDoCachorro=idadeDog.getText().toString();

             Double valorCachorro=Double.parseDouble(idadeDoCachorro);

             Double resultadoF=valorCachorro*7;

             if(valorCachorro!=0){
                 idadehumana.setText("Idade do Cachorro: "+resultadoF+" anos");
             }

         }
     });

    }
}
