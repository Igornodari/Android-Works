package com.example.jacksonskin.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.jacksonskin.data.Product;
import com.example.jacksonskin.R;
import com.example.jacksonskin.utils.LabelView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mctx;
    private List<Product> mList;
    private OnClickCartProductListener listener;

    public ProductAdapter(Context ctx, List<Product> list, OnClickCartProductListener onClickCartProductListener) {
        this.mctx = ctx;
        this.mList = list;
        this.listener = onClickCartProductListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, viewGroup, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder productViewHolder, int position) {
        Product product = mList.get(position);
        if (product != null) {
            if (product.getTitle() != null)
                productViewHolder.title.setText(product.getTitle());
            productViewHolder.price.setNum("R$" + product.getPrice());
            productViewHolder.orderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productViewHolder.animationView.setMinFrame(18);
                    productViewHolder.animationView.setMaxFrame(110);
                    productViewHolder.animationView.setSpeed(2.5F);
                    productViewHolder.animationView.addAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            productViewHolder.animationView.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    productViewHolder.animationView.setVisibility(View.VISIBLE);
                    productViewHolder.animationView.playAnimation();
                    listener.onClickProductOrder();
                }
            });
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
        LabelView price;
        ImageView thumb;
        Button orderButton;
        LottieAnimationView animationView;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.product_title);
            price = itemView.findViewById(R.id.product_price);
            thumb = itemView.findViewById(R.id.product_image);
            orderButton = itemView.findViewById(R.id.btn_add_order);
            animationView = itemView.findViewById(R.id.lav_windmill);
        }
    }

    public interface OnClickCartProductListener {
        void onClickProductOrder();
    }
}


