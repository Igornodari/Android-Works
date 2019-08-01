package com.example.jacksonskin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jacksonskin.adapter.ProductAdapter;
import com.example.jacksonskin.base.BaseActivity;
import com.example.jacksonskin.dao.UserDao;
import com.example.jacksonskin.data.Product;
import com.example.jacksonskin.R;
import com.example.jacksonskin.data.User;
import com.example.jacksonskin.preferences.AppPreferencesHelper;
import com.example.jacksonskin.utils.AppConstants;
import com.example.jacksonskin.utils.CommonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, ProductAdapter.OnClickCartProductListener {

    private static final String TAG = HomeActivity.class.getSimpleName();

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView badge;
    private TextView userName;
    private TextView userEmail;
    private int badgeNumberBuy = 0;
    ProductAdapter adapter;
    private List<Product> itemList = new ArrayList<>();
    private static final int PURCHASE_CODE_REQUEST = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setUp();
    }

    public void setupRecyclerView() {

        RecyclerView mRecyclerView = findViewById(R.id.rv_recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new ProductAdapter(this, itemList, this);
        mRecyclerView.setAdapter(adapter);
        adapter.addList(getItemList());
    }

    private void navigationDrawerConfig() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    private List<Product> getItemList() {
        List<Product> optionList = new ArrayList<>();
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        Type type = new TypeToken<List<Product>>() {
        }
                .getType();
        try {
            optionList = gson.fromJson(
                    CommonUtils.loadJSONFromAsset(this,
                            AppConstants.SEED_DATABASE_OPTIONS),
                    type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return optionList;
    }

    private void setUser() {
        UserDao dao = new UserDao(this);
        User user = dao.buscaUser().get(0);
        if (user != null) {
            userName.setText(user.getName());
            userEmail.setText(user.getEmail());
        }
    }

    private boolean isEmptyShoppingCart() {
        return badgeNumberBuy <= 0;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_item_account: {
                break;
            }
            case R.id.nav_item_cart: {
                if (isEmptyShoppingCart()) {
                    showMessage(getString(R.string.error_empty_shopping_cart));
                    break;
                }
                Intent intent = new Intent(getApplicationContext(), ShoppingCartActivity.class);
                startActivityForResult(intent, PURCHASE_CODE_REQUEST);
                break;
            }
            case R.id.nav_item_orders: {
                break;
            }

            case R.id.nav_item_logout: {
                Log.e("nav_item_logout", "click");
                appPreferencesHelper.setUserLogged(false);
                startActivity(new Intent(this, SignInActivity.class));
                finish();
                break;
            }
            default:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PURCHASE_CODE_REQUEST) {
            badgeNumberBuy = 0;
            CommonUtils.addBadge(this, badgeNumberBuy, badge);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }

    @Override
    protected void setUp() {
        appPreferencesHelper = new AppPreferencesHelper(this, AppConstants.PREF_NAME);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayoutCLIENTE);
        View headerView = navigationView.getHeaderView(0);
        userEmail = headerView.findViewById(R.id.nav_header_emailView);
        userName = headerView.findViewById(R.id.nav_header_name);
        badge = findViewById(R.id.badge);
        ImageView badgeIcon = findViewById(R.id.badgeIcon);
        badgeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmptyShoppingCart()) {
                    showMessage(getString(R.string.error_empty_shopping_cart));
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), ShoppingCartActivity.class);
                startActivityForResult(intent, PURCHASE_CODE_REQUEST);
            }
        });
        setUser();
        navigationDrawerConfig();
        setupRecyclerView();
    }

    @Override
    public void onClickProductOrder() {
        badgeNumberBuy = badgeNumberBuy + 1;
        CommonUtils.addBadge(this, badgeNumberBuy, badge);
    }
}
