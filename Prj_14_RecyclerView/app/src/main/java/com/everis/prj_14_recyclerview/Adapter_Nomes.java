package com.everis.prj_14_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_Nomes extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private int resource;
    private List<HMAux> data;

    public interface ItemClickListener {
        void onItemClick(int position, HMAux item);
    }

    private ItemClickListener mItemClickListener;

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public Adapter_Nomes(Context context, int resource, List<HMAux> data) {
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    protected class DefaultVH extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        ConstraintLayout cl_status;
        TextView tv_nome;

        public DefaultVH(View viewModel) {
            super(viewModel);

            cl_status = itemView.findViewById(R.id.celula_cl_status);
            tv_nome = itemView.findViewById(R.id.celula_tv_nome);


            cl_status.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                int position = getAdapterPosition();
                HMAux item = data.get(position);

                mItemClickListener.onItemClick(position, item);
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewModel;

        viewModel = inflater.inflate(resource, parent, false);
        viewHolder = new DefaultVH(viewModel);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        processDefault(holder, position);
    }

    private void processDefault(RecyclerView.ViewHolder holder, int position) {
        HMAux item = data.get(position);

        DefaultVH defaultVH = (DefaultVH) holder;
        defaultVH.tv_nome.setText(item.get(Constantes.NOME));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
