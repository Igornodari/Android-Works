package com.example.jacksonskin.views.FormA;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.jacksonskin.Data.ADM;
import com.example.jacksonskin.R;

public class FormularioAdmHelper extends FormAdm {

    private final EditText campoNome;
    private final EditText campoEmail;
    private final EditText campoSenha;
    private final EditText campoSexo;
    private final RatingBar campoNota;
    private final EditText campoCpf;
    private final EditText campoRg;
    private final EditText campoCep;

    private ADM adm;

    public FormularioAdmHelper(FormAdm activity) {
        campoNome = activity.findViewById(R.id.nome_id_adm);
        campoEmail = activity.findViewById(R.id.email_id_adm);
        campoSenha = activity.findViewById(R.id.senha_id_adm);
        campoSexo = activity.findViewById(R.id.sexo_id_adm);
        campoNota = activity.findViewById(R.id.nota_id_adm);
        campoCpf = activity.findViewById(R.id.cpf_id_adm);
        campoRg = activity.findViewById(R.id.rg_id_adm);
        campoCep=activity.findViewById(R.id.cep_id_adm);

        adm=new ADM();
    }


    public ADM pegaUser() {

        adm.setNome(campoNome.getText().toString());
        adm.setEmail(campoEmail.getText().toString().toLowerCase().trim());
        adm.setSexo(campoSexo.getText().toString());
        adm.setPass(campoSenha.getText().toString().trim());
        adm.setNota(((double) campoNota.getProgress()));
        adm.setCpf(campoCpf.getText().toString().trim());
        adm.setRg(campoRg.getText().toString().trim());
        adm.setCep(campoCep.getText().toString().trim());

        return adm;
    }

    public void preencheForm(ADM adm) {

        campoNome.setText(adm.getNome());
        campoEmail.setText(adm.getEmail());
        campoSenha.setText(adm.getPass());
        campoSexo.setText(adm.getSexo());
        campoNota.setProgress(adm.getNota().intValue());
        campoCpf.setText(adm.getCpf());
        campoRg.setText(adm.getRg());
        campoCep.setText(adm.getCep());

        this.adm = adm;

    }
}
