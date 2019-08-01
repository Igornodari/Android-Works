package com.example.jacksonskin.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.jacksonskin.R;
import com.example.jacksonskin.adapter.ShoppingCartAdapter;
import com.example.jacksonskin.base.BaseActivity;
import com.example.jacksonskin.data.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingCartActivity extends BaseActivity {

    @BindView(R.id.lav_windmill)
    LottieAnimationView animationView;

    @BindView(R.id.rv_recycler_shopping)
    RecyclerView mRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    ShoppingCartAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        ButterKnife.bind(this);
        setUp();
    }

    @Override
    protected void setUp() {
        /* Inside the activity */
// Sets the Toolbar to act as the ActionBar for this Activity window.
        setSupportActionBar(toolbar);
// Remove default title text
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                finish();
            }
        });


        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                showMessage(getString(R.string.title_thanks_purchases));
                Intent devolve = new Intent();
                setResult(RESULT_OK, devolve);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new ShoppingCartAdapter(this, new ArrayList<Product>());
        mRecyclerView.setAdapter(adapter);
        adapter.addList(getItemList());
    }

    private List<Product> getItemList() {
        return new ArrayList<>();
    }

    @OnClick(R.id.btn_continue_shopping)
    void onClickContinueShoppingButton() {
        Log.e("OnClick", "onClickContinueShoppingButton");
        finish();
    }

    @OnClick(R.id.btn_finish_purchases)
    void onClickFinishedPurchasesButton() {
        animationView.setVisibility(View.VISIBLE);
        animationView.playAnimation();
    }
}
