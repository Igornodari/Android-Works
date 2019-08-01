package com.example.jacksonskin.views.menu;

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

import com.example.jacksonskin.Data.Usuario;
import com.example.jacksonskin.R;
import com.example.jacksonskin.Utils.LoginValidate;
import com.example.jacksonskin.dao.UsuarioDao;
import com.example.jacksonskin.views.FormC.FormularioClienteHelper;

import java.util.ArrayList;
import java.util.List;

public class MenuCliente extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private LoginValidate loginValidate = new LoginValidate();
    private ImageView logouser;
    private TextView nomeuser;
    private TextView emailuser;
    private Usuario usuario = new Usuario();
    private FormularioClienteHelper helper;

    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mLayoutMenager;
    MenuRecyclerAdapterCliente adapter;
    private List<Usuario> itemList = new ArrayList<>();
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cliente);
//        listenersButtons();
        iniciarVariaveis();
        iniciarAcao();

    }


    //    private void listenersButtons() {
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loginValidate.showToast(getApplicationContext(),"CLICKCLECK");
//
//
//            }
//        });
//    }


    private void iniciarVariaveis() {
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayoutCLIENTE);
        View headerView = navigationView.getHeaderView(0);
        adapter = new MenuRecyclerAdapterCliente(this, itemList);
        button = findViewById(R.id.button);
        logouser = headerView.findViewById(R.id.nav_header_imageView);
        emailuser = headerView.findViewById(R.id.nav_header_emailView);
        nomeuser = headerView.findViewById(R.id.nav_header_name);

    }

    public void setaRecyclerView() {

        //Aqui é instanciado o Recyclerview
        mRecycler = findViewById(R.id.rv_recycler);
        mLayoutMenager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayoutMenager);
        adapter = new MenuRecyclerAdapterCliente(this, itemList);
        mRecycler.setAdapter(adapter);
        mLayoutMenager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(mLayoutMenager);

    }

    public void getClientData() {
        usuario = (Usuario) getIntent().getSerializableExtra("user");
    }

    private void NavigationDrawerConfig() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void iniciarAcao() {
        getClientData();
        clientPopulate();
        NavigationDrawerConfig();
        populaListaProduto();
        setaRecyclerView();
    }

    private List<Usuario> populaListaProduto() {

        usuario = new Usuario();
        adapter.notifyDataSetChanged();
        itemList.add(usuario);

        return itemList;
    }


    public void clientPopulate() {
        nomeuser.setText(usuario.getNome());
        emailuser.setText(usuario.getEmail());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:

                Usuario usuario = helper.pegaUser();
                UsuarioDao dao = new UsuarioDao(this);

                if (usuario.getId() != null) {
                    dao.altera(usuario);
                } else if (usuario.getTipo().equals("CLIENTE") && !usuario.getNome().equals("igor")) {
                    dao.insere(usuario);
                    loginValidate.showToast(getApplicationContext(), "Cliente " + usuario.getNome() + " salvo!");
                } else {
                    loginValidate.showToast(getApplicationContext(), "Usuario " + usuario.getNome() + " Restrito para ADM!");
                }
                dao.close();
                finish();
                break;
        }
        return onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_item_one: {
                loginValidate.showToast(this, "Menu1");

                break;
            }
            case R.id.nav_item_two: {
                loginValidate.showToast(this, "Menu2");
                break;
            }
            case R.id.nav_item_three: {
                loginValidate.showToast(this, "Menu3");
                break;
            }

            case R.id.nav_item_four: {
                loginValidate.showToast(this, "Menu4");
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
