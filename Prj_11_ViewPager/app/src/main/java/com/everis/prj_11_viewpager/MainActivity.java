package com.everis.prj_11_viewpager;

import android.Manifest;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private TabLayout tabs;
    private ViewPager viewPager;

    private ArrayList<Fragment> telas = new ArrayList<>();
    private F01 mF01;
    private F02 mF02;
    private F03 mF03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);


        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        context = MainActivity.this;
        //
        tabs = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        //
        cfgTelas();

    }

    private void cfgTelas() {
        mF01 = new F01();
        mF02 = new F02();
        mF03 = new F03();
        //
        telas.add(mF01);
        telas.add(mF02);
        telas.add(mF03);
        //
        viewPager.setAdapter(
                new AdapterTelas(
                        getSupportFragmentManager(),
                        telas
                )
        );

        tabs.setupWithViewPager(viewPager);

        cfgTabIcons();
    }

    private void cfgTabIcons() {
        TextView tabBackUp = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabBackUp.setText("BackUp");
        tabBackUp.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_backup_black_24dp, 0, 0);
        tabs.getTabAt(0).setCustomView(tabBackUp);

        TextView tabBeach = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabBeach.setText("Beach");
        tabBeach.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_beach_access_black_24dp, 0, 0);
        tabs.getTabAt(1).setCustomView(tabBeach);

        TextView tabPhone = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabPhone.setText("Phone");
        tabPhone.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_local_phone_black_24dp, 0, 0);
        tabs.getTabAt(2).setCustomView(tabPhone);

    }

    private void inicializarAcao() {

    }

    private class AdapterTelas extends FragmentPagerAdapter {

        private List<Fragment> telas;

        public AdapterTelas(FragmentManager fm, List<Fragment> telas) {
            super(fm);
            this.telas = telas;
        }

        @Override
        public Fragment getItem(int position) {
            return telas.get(position);
        }

        @Override
        public int getCount() {
            return telas.size();
        }
    }
}
