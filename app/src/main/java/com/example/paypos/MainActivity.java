package com.example.paypos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setBackgroundResource(R.drawable.arriere_plan_barre);
        toolbar.setNavigationIcon(R.drawable.logo_point_cash);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.icon_menu);
        toolbar.setOverflowIcon(drawable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.action_profil:
                new android.support.v7.app.AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setTitle("hamza")//remplacer par getUname(this)
                        .setNeutralButton("Ok", null)
                        .show();
                break;
            case R.id.action_contact:
                i = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(i);
                break;
            case R.id.action_rib:
                i = new Intent(getApplicationContext(), RibActivity.class);
                startActivity(i);
                break;
            case R.id.action_manuel:
                i = new Intent(getApplicationContext(), ManuelPDFActivity.class);
                startActivity(i);
                break;
            case R.id.action_settings:
                i = new Intent(getApplicationContext(), ParametreMenuActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return true;
    }

    @OnClick(R.id.alimCompte)
    public void AlimenterCompte() {
        startActivity(new Intent(getApplicationContext(), AlimentationCompteSolde.class));
    }

    @OnClick(R.id.consltSolde)
    public void ConsolterSolde() {
        startActivity(new Intent(getApplicationContext(), ConsulteSoldeMenu.class));
    }

    @OnClick(R.id.rechargeTel)
    public void RechargeTel() {
        startActivity(new Intent(getApplicationContext(), RechargeTelMenu.class));
    }

    @OnClick(R.id.paiementFact)
    public void PaiementFact() {
        startActivity(new Intent(getApplicationContext(), PaiementFactMenu.class));
    }

    @OnClick(R.id.rechargeCrt)
    public void RechargeCarte() {
        startActivity(new Intent(getApplicationContext(), RechargeCrtMenu.class));
    }

    @OnClick(R.id.transfertArg)
    public void TransfertArgent() {
        startActivity(new Intent(getApplicationContext(), TransfertArgentActivity.class));
    }

//    @OnClick(R.id.billetEve)
//    public void BilletEve() {
//        startActivity(new Intent(getApplicationContext(), ActivityEnConstruction.class));
//    }

    @OnClick(R.id.paiementCom)
    public void PaiementCommercant() {
        startActivity(new Intent(getApplicationContext(), PaimentCommercantActivity.class));
    }

    @OnClick(R.id.billetAv)
    public void BilletAv() {
        startActivity(new Intent(getApplicationContext(), ActivityEnConstruction.class));
    }

    @OnClick(R.id.promotion)
    public void Promotion() {
        startActivity(new Intent(getApplicationContext(), ActivityEnConstruction.class));
    }

    @OnClick(R.id.historique)
    public void Historique() {
        startActivity(new Intent(getApplicationContext(), HistoriqueMenu.class));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(keyCode, event);
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Veuillez cliquer à nouveau sur RETOUR pour quitter", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
