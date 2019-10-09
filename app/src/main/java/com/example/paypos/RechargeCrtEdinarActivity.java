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
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RechargeCrtEdinarActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtCodeClt)
    EditText txtCodeClt;
    @BindView(R.id.txtMontant)
    EditText txtMontant;
    @BindView(R.id.txtEdtNumcode)
    TextView txtEdtNumcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_crt_edinar);
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
                        // Toast.makeText(RechargeCrtEdinarActivity.this, "Home", Toast.LENGTH_LONG).show();
                    }
                }
        );
        txtCodeClt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txtEdtNumcode.setVisibility(View.VISIBLE);
                } else {
                    txtEdtNumcode.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick(R.id.btn_envoyer)
    public void Envoyer() {

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
