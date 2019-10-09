package com.example.paypos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoriqueServiceMenu extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Bundle extra = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique_service_menu);
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
                        // Toast.makeText(HistoriqueServiceMenu.this, "Home", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    @OnClick(R.id.btnHisPaiement)
    public void btnHisPaiement() {
        Intent i = new Intent(getApplicationContext(),HistoriqueRechercheFilter.class);
        extra.putString("Hist","PF");
        i.putExtras(extra);
        startActivity(i);
    }

    @OnClick(R.id.btnHisRecharge)
    public void btnHisRecharge() {
        Intent i = new Intent(getApplicationContext(),HistoriqueRechercheFilter.class);
        extra.putString("Hist","RC");
        i.putExtras(extra);
        startActivity(i);
    }

    @OnClick(R.id.btnHisTransfert)
    public void btnHisTransfert() {
        startActivity(new Intent(getApplicationContext(), ActivityEnConstruction.class));
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
                        .setTitle("hamza")
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
}
