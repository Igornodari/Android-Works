package com.example.jacksonskin.views.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.jacksonskin.Data.Produto;
import com.example.jacksonskin.R;

import java.util.List;

public class MenuRecyclerAdapterAdm extends RecyclerView.Adapter<MenuRecyclerAdapterAdm.RecyclerTesteViewHolder> {

    Context mctx;
    private List<Produto> aList;

    MenuRecyclerAdapterAdm(Context ctx, List<Produto> list) {
        this.mctx = ctx;
        this.aList = list;
    }

    @NonNull
    @Override
    public MenuRecyclerAdapterAdm.RecyclerTesteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_adm, viewGroup, false);
        return new RecyclerTesteViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MenuRecyclerAdapterAdm.RecyclerTesteViewHolder recyclerTesteViewHolder, int i) {
        Produto produto = aList.get(i);
        recyclerTesteViewHolder.viewTitle.setText(produto.getTitle());
        recyclerTesteViewHolder.viewDesc.setText(produto.getDesc());
        recyclerTesteViewHolder.viewPreco.setText(Double.toString(produto.getPreco()));
        recyclerTesteViewHolder.viewNota.setRating(Float.parseFloat(Double.toString(produto.getNota())));
        recyclerTesteViewHolder.viewQuantidade.setText(Integer.toString(produto.getQuantidade()));
//        recyclerTesteViewHolder.viewSexo.setImageResource(produto.getImage());
    }

    @Override
    public int getItemCount() {
        return aList.size();
    }

    class RecyclerTesteViewHolder extends RecyclerView.ViewHolder {

        TextView viewTitle;
        TextView viewDesc;
        TextView viewPreco;
        ImageView viewImage;
        RatingBar viewNota;
        TextView viewQuantidade;


        public RecyclerTesteViewHolder(@NonNull View itemView) {
            super(itemView);

            viewTitle = itemView.findViewById(R.id.tv_produtoTitle_adm);
            viewDesc = itemView.findViewById(R.id.tv_produtoDesc_adm);
            viewPreco = itemView.findViewById(R.id.tv_produtoPreco_adm);
            viewImage = itemView.findViewById(R.id.iv_imagePruduto_adm);
            viewNota = itemView.findViewById(R.id.notaProduto_id_adm);
            viewQuantidade = itemView.findViewById(R.id.tv_quantidadeN_adm);
        }
    }
}


