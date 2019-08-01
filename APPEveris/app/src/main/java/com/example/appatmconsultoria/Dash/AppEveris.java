package com.example.appatmconsultoria.Dash;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.appatmconsultoria.DialReciver;
import com.example.appatmconsultoria.Menu.ACT.clientesACT;
import com.example.appatmconsultoria.Menu.ACT.contatoACT;
import com.example.appatmconsultoria.Menu.ACT.servicosACT;
import com.example.appatmconsultoria.R;


public class AppEveris extends AppCompatActivity implements View.OnClickListener {

    private ImageView contato;
    private ImageView empresa;
    private ImageView servicos;
    private ImageView clientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_everis);

        requestPhonePermission();
        openBroadCastReceiver();
        closeBroadCastReceiver();

        contato = findViewById(R.id.contatoid);
        clientes = findViewById(R.id.clienteid);
        servicos = findViewById(R.id.servicosid);
        empresa = findViewById(R.id.empresaid);

        contato.setOnClickListener(v -> {
            startActivity(new Intent(AppEveris.this, contatoACT.class));
        });
        servicos.setOnClickListener(this);

        empresa.setOnClickListener(this);
        clientes.setOnClickListener(v -> startActivity(new Intent(AppEveris.this, clientesACT.class)));

    }


    private void openBroadCastReceiver() {
        PackageManager pm = AppEveris.this.getPackageManager();
        ComponentName componentName = new ComponentName(AppEveris.this, DialReciver.class);

        pm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void closeBroadCastReceiver() {
        PackageManager pm = AppEveris.this.getPackageManager();
        ComponentName componentName = new ComponentName(AppEveris.this, DialReciver.class);
        pm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void requestPhonePermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.PROCESS_OUTGOING_CALLS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.PROCESS_OUTGOING_CALLS)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS}, 1);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v == empresa) {
            openBroadCastReceiver();
            startActivity(new Intent(AppEveris.this, clientesACT.class));
        } else if (v == servicos) {
            closeBroadCastReceiver();
            startActivity(new Intent(AppEveris.this, servicosACT.class));
        }
    }
}

