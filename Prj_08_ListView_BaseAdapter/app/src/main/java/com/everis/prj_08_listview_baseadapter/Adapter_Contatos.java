package com.everis.prj_08_listview_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter_Contatos extends BaseAdapter {

    private Context context;
    private int resource;
    private List<HMAux> dados;
    private LayoutInflater mInflater; // ler xml transforme binario

    private long itemSelecionado = -1L;

    public void setItemSelecionado(long itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
        notifyDataSetChanged();
    }

    private int contador = 0;

    public Adapter_Contatos(Context context, int resource, List<HMAux> dados) {
        this.context = context;
        this.resource = resource;
        this.dados = dados;
//        this.mInflater = (LayoutInflater)
//                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mInflater = LayoutInflater.from(context);
    }

    // devolve a quantidade de registros na minha colecao
    @Override
    public int getCount() {
        return dados.size();
    }


    // Devolve o registro da posicao referenciada pelo parametro position
    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    @Override
    public long getItemId(int position) {
        HMAux item = dados.get(position);

        return Long.parseLong(item.get(HMAux.ID));

        //return Long.parseLong(dados.get(position).get(HMAux.ID));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        boolean bNew = false;

        if (convertView == null){
            convertView = mInflater.inflate(resource, parent, false);
            bNew = true;
            contador++;
        }

        // ACESSAR O RESTRIDO DA POSICAO
        HMAux item = dados.get(position);

        LinearLayout ll_status = convertView.findViewById(R.id.celula_ll_status);
        TextView tv_nome = convertView.findViewById(R.id.celula_tv_nome);
        TextView tv_telefone = convertView.findViewById(R.id.celula_tv_telefone);
        TextView tv_contador = convertView.findViewById(R.id.celula_tv_contador);

        // Movimentar os dados
        tv_nome.setText(item.get(HMAux.NOME));
        tv_telefone.setText(item.get(HMAux.TELEFONE));
        //
        if (bNew){
            tv_contador.setText(String.valueOf(contador));
        }

        if (Long.parseLong(item.get(HMAux.ID)) == itemSelecionado){
            ll_status.setBackgroundColor(context.getColor(R.color.cinza_selecionado));
        } else {
            ll_status.setBackgroundColor(context.getColor(R.color.transparente_nao_selecionado));
        }

        return convertView;
    }
}
