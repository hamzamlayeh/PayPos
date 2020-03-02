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

public class PaiementFactMenu extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiement_fact_menu);
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
                        //Toast.makeText(PaiementFactMenu.this, "Home", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    @OnClick(R.id.btn_org1)
    public void btn_org1() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","STEG");
        startActivity(i);
    }

    @OnClick(R.id.btn_org2)
    public void btn_org2() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","SONEDE");
        startActivity(i);    }

    @OnClick(R.id.btn_org3)
    public void btn_org3() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","TT");
        startActivity(i);    }

    @OnClick(R.id.btn_org4)
    public void btn_org4() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","ORD");
        startActivity(i);    }

    @OnClick(R.id.btn_org5)
    public void btn_org5() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","ORG");
        startActivity(i);    }

    @OnClick(R.id.btn_org6)
    public void btn_org6() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","TOPNET");
        startActivity(i);    }

    @OnClick(R.id.btn_org7)
    public void btn_org7() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CNSS");
        startActivity(i);    }

    @OnClick(R.id.btn_org8)
    public void btn_org8() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CNSSFNS");
        startActivity(i);    }

    @OnClick(R.id.btn_org9)
    public void btn_org9() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CNSSEMPLO");
        startActivity(i);    }

    @OnClick(R.id.btn_org10)
    public void btn_org10() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CNRPS");
        startActivity(i);    }

    @OnClick(R.id.btn_org11)
    public void btn_org11() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","SNIT");
        startActivity(i);    }

    @OnClick(R.id.btn_org12)
    public void btn_org12() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CRDANABE");
        startActivity(i);    }

    @OnClick(R.id.btn_org13)
    public void btn_org13() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CRDAJAND");
        startActivity(i);    }

    @OnClick(R.id.btn_org14)
    public void btn_org14() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CRDAAROU");
        startActivity(i);    }

    @OnClick(R.id.btn_org15)
    public void btn_org15() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CRDAARIA");
        startActivity(i);    }

    @OnClick(R.id.btn_org16)
    public void btn_org16() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CRDASILI");
        startActivity(i);    }

    @OnClick(R.id.btn_org17)
    public void btn_org17() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CNEL");
        startActivity(i);    }

    @OnClick(R.id.btn_org18)
    public void btn_org18() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","SPROLSLO");
        startActivity(i);    }

    @OnClick(R.id.btn_org19)
    public void btn_org19() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","SPROLSAC");
        startActivity(i);    }

    @OnClick(R.id.btn_org20)
    public void btn_org20() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","CRDABIZE");
        startActivity(i);    }

    @OnClick(R.id.btn_org21)
    public void btn_org21() {
        Intent i = new Intent(getApplicationContext(), PaiementFactActivity.class);
        i.putExtra("organisme","TTN");
        startActivity(i);    }

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
