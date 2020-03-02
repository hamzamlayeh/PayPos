package com.example.paypos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.paypos.Utils.Util.getUname;

public class ModePaiement extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Bundle extras = new Bundle();
    Intent i;
    String Montant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_paiement);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setBackgroundResource(R.drawable.arriere_plan_barre);
        toolbar.setNavigationIcon(R.drawable.icon_retour);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.icon_menu);
        toolbar.setOverflowIcon(drawable);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(i);
                        //Toast.makeText(ModePaiement.this, "Home", Toast.LENGTH_LONG).show();
                    }
                }
        );
        extras = getIntent().getExtras();
        if (extras != null) {
            Montant=extras.getString("numberTo");
        }
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
                new androidx.appcompat.app.AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setTitle(getUname(this))
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

    @OnClick(R.id.btn_versement)
    public void Versment() {
        i = new Intent(getApplicationContext(),AlimentationCompte.class);
        extras.putString("numberTo",Montant);
        extras.putString("mode","versement");
        i.putExtras(extras);
        startActivity(i);
    }

    @OnClick(R.id.btn_virement)
    public void Virement() {
        i = new Intent(getApplicationContext(),AlimentationCompte.class);
        extras.putString("mode","virement");
        i.putExtras(extras);
        startActivity(i);
    }

    @OnClick(R.id.btnPointCash)
    public void PointCash() {
        i = new Intent(getApplicationContext(),ActivityEnConstruction.class);
        extras.putString("mode","pointcash");
        i.putExtras(extras);
        startActivity(i);
    }

    @OnClick(R.id.btnCarteEdinar)
    public void CarteEdinar() {
        i = new Intent(getApplicationContext(),ActivityEnConstruction.class);
        extras.putString("mode","carteedinar");
        i.putExtras(extras);
        startActivity(i);
    }

    @OnClick(R.id.btnCarteBencaire)
    public void CarteBencaire() {
        i = new Intent(getApplicationContext(),ActivityEnConstruction.class);
        extras.putString("mode","cartebq");
        i.putExtras(extras);
        startActivity(i);
    }

    @OnClick(R.id.btnCarteVCN)
    public void CarteVCN() {
        i = new Intent(getApplicationContext(),ActivityEnConstruction.class);
        extras.putString("mode","cartevcn");
        i.putExtras(extras);
        startActivity(i);
    }
}
