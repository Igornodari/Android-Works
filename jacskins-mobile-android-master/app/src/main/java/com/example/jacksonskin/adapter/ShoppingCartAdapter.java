package com.example.jacksonskin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jacksonskin.R;
import com.example.jacksonskin.data.Product;

import java.util.List;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ProductViewHolder> {

    private Context mctx;
    private List<Product> mList;
    private OnClickCartProductListener listener;

    public ShoppingCartAdapter(Context ctx, List<Product> list) {
        this.mctx = ctx;
        this.mList = list;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shopping_cart, viewGroup, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder productViewHolder, int position) {
        Product product = mList.get(position);
        if (product != null) {
            if (product.getTitle() != null)
                productViewHolder.title.setText(product.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addList(List<Product> itemList) {
        mList.addAll(itemList);
        notifyDataSetChanged();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView thumb;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.product_title);
            thumb = itemView.findViewById(R.id.product_image);
        }
    }

    public interface OnClickCartProductListener {
        void onClickProductOrder();
    }
}


