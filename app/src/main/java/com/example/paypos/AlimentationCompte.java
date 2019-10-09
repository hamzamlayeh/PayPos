package com.example.paypos;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.paypos.Utils.Util.getUname;

public class AlimentationCompte extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.spnBanq)
    Spinner spnBanq;
    @BindView(R.id.txtRefBord)
    EditText txtRefBord;
    @BindView(R.id.txtMontant)
    EditText txtMontant;
    @BindView(R.id.txtMode)
    TextView txtMode;
    Bundle extras = new Bundle();
    int solde;
    String banqId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentation_compte);
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
                        //Toast.makeText(AlimentationCompte.this, "Home", Toast.LENGTH_LONG).show();
                    }
                }
        );
        extras = getIntent().getExtras();
        if (extras != null) {
            txtMode.setText(extras.getString("mode").toUpperCase());
            txtMontant.setText(extras.getString("numberTo"));
            //Toast.makeText(this, extras.getString("numberTo")+"/", Toast.LENGTH_SHORT).show();
        }
        banqId = "-1";
        // Initializing a String Array
        final String[] banq = new String[]{
                "Banque...",
                "BIAT",
                "Attijari bank",
                "BH",
                "BNA",
                "STB",
                "zitouna",
                "la poste"
        };
        final List<String> banqList = new ArrayList<>(Arrays.asList(banq));
        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, banqList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else if (position == 1) {
                    txtRefBord.setText("TT");
                    int pos = txtRefBord.getText().length();
                    txtRefBord.setSelection(pos);
                    return true;
                } else {
                    txtRefBord.setText("");
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spnBanq.setAdapter(spinnerArrayAdapter);

        spnBanq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    banqId = selectedItemText;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @OnClick(R.id.btn_envoyer)
    public void Envoyer() {
        //startActivity(new Intent(getApplicationContext(), AlimentationCompteSolde.class));
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
}
