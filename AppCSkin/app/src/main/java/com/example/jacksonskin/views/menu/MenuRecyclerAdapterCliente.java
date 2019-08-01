package com.example.jacksonskin.views.menu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.jacksonskin.Data.Usuario;
import com.example.jacksonskin.R;

import java.util.List;

public class MenuRecyclerAdapterCliente extends RecyclerView.Adapter<MenuRecyclerAdapterCliente.RecyclerTesteViewHolder> {

    private Context mctx;
    private List<Usuario> cList;

    MenuRecyclerAdapterCliente(Context ctx, List<Usuario> list) {
        this.mctx = ctx;
        this.cList = list;
    }

    @NonNull
    @Override
    public MenuRecyclerAdapterCliente.RecyclerTesteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_produto_cliente, viewGroup, false);
        return new RecyclerTesteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuRecyclerAdapterCliente.RecyclerTesteViewHolder recyclerTesteViewHolder, int i) {
        Usuario usuario = cList.get(i);
        recyclerTesteViewHolder.viewNome.setText(usuario.getNome());
        recyclerTesteViewHolder.viewEmail.setText(usuario.getEmail());
        recyclerTesteViewHolder.viewSenha.setText(Integer.toString(Integer.parseInt(usuario.getPass())));
        recyclerTesteViewHolder.viewNota.setRating((usuario.getNota()));
    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

  class RecyclerTesteViewHolder extends RecyclerView.ViewHolder {

        TextView viewNome;
        TextView viewEmail;
        TextView viewSenha;
        ImageView viewSexo;
        RatingBar viewNota;


        RecyclerTesteViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNome = itemView.findViewById(R.id.nome_id);
            viewEmail = itemView.findViewById(R.id.email_id);
            viewSenha = itemView.findViewById(R.id.senha_id);
            viewSexo = itemView.findViewById(R.id.sexo_id);
            viewNota = itemView.findViewById(R.id.nota_id);

        }
    }
}


