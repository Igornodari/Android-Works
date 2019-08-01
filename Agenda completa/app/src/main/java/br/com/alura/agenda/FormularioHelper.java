package br.com.alura.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.alura.agenda.modelo.Aluno;


public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoSite;
    private final RatingBar campoNota;
    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {

        campoNome = activity.findViewById(R.id.nome_id);
        campoEndereco = activity.findViewById(R.id.end_id);
        campoTelefone = activity.findViewById(R.id.tell_id);
        campoSite = activity.findViewById(R.id.site_id);
        campoNota = activity.findViewById(R.id.nota_id);
        aluno=new Aluno();
    }


    public Aluno pegaAluno() {

        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota((Double.valueOf(campoNota.getProgress())));

        return aluno;
    }

    public void preencheForm(Aluno aluno) {

        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoSite.setText(aluno.getSite());
        campoTelefone.setText(aluno.getTelefone());
        campoNota.setProgress(aluno.getNota().intValue());
        this.aluno = aluno;

    }
}
