package com.example.jacksonskin.views.crud;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.jacksonskin.Data.Usuario;
import com.example.jacksonskin.R;

import java.util.List;

public class ListaClientesAdapter extends Adapter<ListaClientesAdapter.ListaViewHolder> {

    Context mctx;
    private List<Usuario> aList;

    public ListaClientesAdapter(ClientesActivity clientesActivity, List<Usuario> itemList) {
    }

    @NonNull
    @Override
    public ListaClientesAdapter.ListaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_adm, viewGroup, false);
        return new ListaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaClientesAdapter.ListaViewHolder listaViewHolder, int i) {
        Usuario usuario = aList.get(i);
        listaViewHolder.viewNome.setText(usuario.getNome());
        listaViewHolder.viewEmail.setText(usuario.getNome());
        listaViewHolder.viewSexo.setText(usuario.getNome());
        listaViewHolder.viewNota.setRating(( usuario.getNota()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ListaViewHolder extends RecyclerView.ViewHolder {

        TextView viewNome;
        TextView viewEmail;
        TextView viewSexo;
        RatingBar viewNota;

        public ListaViewHolder(View itemView) {
            super(itemView);
            viewNome= itemView.findViewById(R.id.nome_id);
            viewSexo= itemView.findViewById(R.id.sexo_id);
            viewEmail= itemView.findViewById(R.id.email_id);
            viewNota= itemView.findViewById(R.id.nota_id);


        }
    }
}
