package com.example.jacksonskin.views.FormC;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.jacksonskin.Data.Usuario;
import com.example.jacksonskin.R;

public class FormularioClienteHelper extends FormCliente {

    private final EditText campoNome;
    private final EditText campoEmail;
    private final EditText campoSenha;
    private final EditText campoSexo;
    private final RatingBar campoNota;

    private Usuario user;

    public FormularioClienteHelper(FormCliente activity) {
        campoNome = activity.findViewById(R.id.nome_id);
        campoEmail = activity.findViewById(R.id.email_id);
        campoSenha = activity.findViewById(R.id.senha_id);
        campoSexo = activity.findViewById(R.id.sexo_id);
        campoNota = activity.findViewById(R.id.nota_id);

        user=new Usuario();
    }


    public Usuario pegaUser() {

        user.setNome(campoNome.getText().toString());
        user.setEmail(campoEmail.getText().toString().toLowerCase().trim());
        user.setSexo(campoSexo.getText().toString());
        user.setPass(campoSenha.getText().toString().trim());
        user.setNota((float) campoNota.getProgress());

        return user;
    }

    public void preencheForm(Usuario usuario) {

        campoNome.setText(usuario.getNome());
        campoEmail.setText(usuario.getEmail());
        campoSenha.setText(usuario.getPass());
        campoSexo.setText(usuario.getSexo());
        campoNota.setProgress(usuario.getNota().intValue());
        this.user = usuario;

    }
}
