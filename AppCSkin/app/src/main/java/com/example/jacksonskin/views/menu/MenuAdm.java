package com.example.jacksonskin.views.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jacksonskin.Data.ADM;
import com.example.jacksonskin.Data.Produto;
import com.example.jacksonskin.R;
import com.example.jacksonskin.Utils.LoginValidate;
import com.example.jacksonskin.views.crud.ClientesActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class MenuAdm extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar_ADM;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ADM adm;
    private LoginValidate loginValidate;
    private ImageView logouser;
    private TextView nomeadm;
    private TextView emailadm;
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mLayoutMenager;
    MenuRecyclerAdapterAdm adapter;
    private List<Produto> itemList;
    private Button button;
    private CarouselView carouselView;

    int[] sampleImages = {R.drawable.arma9, R.drawable.arma2,
            R.drawable.arma10,
            R.drawable.arma5, R.drawable.arma1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);

        iniciarVariaveis();

        iniciarAcao();



    }

    private void setCarrousel() {
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


    private void iniciarVariaveis() {

        loginValidate = new LoginValidate();
        itemList = new ArrayList<>();
        adapter = new MenuRecyclerAdapterAdm(this, itemList);
        adm = new ADM();

        navigationView = findViewById(R.id.nv_adm);
        View headerView = navigationView.getHeaderView(0);
        carouselView = findViewById(R.id.id_adm_carousel);
        logouser = headerView.findViewById(R.id.nav_header_imageView);
        emailadm = headerView.findViewById(R.id.nav_header_emailView);
        nomeadm = headerView.findViewById(R.id.nav_header_name);
        drawerLayout = findViewById(R.id.drawerLayoutADM);
        toolbar_ADM = findViewById(R.id.toolbarADM);

    }

    private void iniciarAcao() {
        getAdmData();
        clientPopulate();
        NavigationDrawerConfig();
        populaListaProduto();
        setaRecyclerView();
        setCarrousel();
    }


    private List<Produto> populaListaProduto() {

        Produto produto1 = new Produto();
        produto1.setTitle("Baioneta");
        produto1.setDesc("FACA");
        produto1.setNota(5.0);
        produto1.setImage(1);
        produto1.setQuantidade(5);
        produto1.setPreco(1000.0000);

        Produto produto2 = new Produto();
        produto2.setTitle("M4A1-Dragon");
        produto2.setDesc("Rifle");
        produto2.setNota(10.0);
        produto2.setImage(1);
        produto2.setQuantidade(5);
        produto2.setPreco(1000.0000);

        Produto produto3 = new Produto();
        produto3.setTitle("Ak-47 RedLine");
        produto3.setDesc("Rifle");
        produto3.setNota(5.0);
        produto3.setImage(1);
        produto3.setQuantidade(5);
        produto3.setPreco(1000.0000);

        adapter.notifyDataSetChanged();
        itemList.add(produto1);
        itemList.add(produto2);
        itemList.add(produto3);

        return itemList;
    }

    public void clientPopulate() {
        nomeadm.setText(adm.getNome());
        emailadm.setText(adm.getEmail());
    }

    public void setaRecyclerView() {

        //Aqui é instanciado o Recyclerview
        mRecycler = findViewById(R.id.rv_recycler);
        mLayoutMenager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayoutMenager);
        adapter = new MenuRecyclerAdapterAdm(this, itemList);
        mRecycler.setAdapter(adapter);

        mLayoutMenager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(mLayoutMenager);
    }

    public void getAdmData() {
        adm = (ADM) getIntent().getSerializableExtra("ADM");
    }

    private void NavigationDrawerConfig() {
        setSupportActionBar(toolbar_ADM);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar_ADM, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_item_clientes: {
                Intent intent = new Intent(this, ClientesActivity.class);
                startActivity(intent);
                loginValidate.showToast(this,"LETS TO CRUD CLIENTE");
                break;
            }
            case R.id.nav_item_produtos: {
                loginValidate.showToast(this, "Menu2");
                break;
            }
            case R.id.nav_item_estoque: {
                loginValidate.showToast(this, "Menu3");
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
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }
}

