package com.example.paypos;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoriqueRechercheFilter extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lv)
    LinearLayout lv;
    @BindView(R.id.ll_filter)
    LinearLayout ll_filter;
    @BindView(R.id.ll_valeur)
    LinearLayout ll_valeur;
    @BindView(R.id.showDateDebut)
    TextView showDateDebut;
    @BindView(R.id.showDateFin)
    TextView showDateFin;
    @BindView(R.id.spinner1)
    Spinner spinner1;
    @BindView(R.id.spinner2)
    Spinner spinner2;
    Bundle extra = new Bundle();
    Calendar calendar;
    int year, month, day;
    Boolean aBoolean = false;
    String etat = "1", valeur = "1000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique_recherche_filter);
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
                        //Toast.makeText(HistoriqueRechercheFilter.this, "Home", Toast.LENGTH_LONG).show();
                    }
                }
        );
        extra = getIntent().getExtras();
        if (extra.getString("Hist").equals("AL")) {
            ll_filter.setVisibility(View.INVISIBLE);
            lv.setBackgroundResource(R.drawable.bg_alimentation_compte);
        }
        if (extra.getString("Hist").equals("Voucher")) {
            ll_filter.setVisibility(View.GONE);
            ll_valeur.setVisibility(View.VISIBLE);
            lv.setBackgroundResource(R.drawable.bg_historique_f_voucher);

        }
        if (extra.getString("Hist").equals("Light")) {
            lv.setBackgroundResource(R.drawable.bg_historique_f_light);
        }
        if (extra.getString("Hist").equals("RC")) {
            lv.setBackgroundResource(R.drawable.bg_historique_f_recharge_carte);
        }
        if (extra.getString("Hist").equals("PF")) {
            lv.setBackgroundResource(R.drawable.bg_historique_f_paiement_facture);
        }
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day, showDateDebut);
        showDate(year, month + 1, day, showDateFin);

        // Initializing a String Array
        final String[] type = new String[]{
                "Etat...",
                "Echec",
                "Succès",
                "En attente"
        };

        final String[] type2 = new String[]{
                "Valeur...",
                "1 DT",
                "5 DT"
        };
        final List<String> typeidList = new ArrayList<>(Arrays.asList(type));
        final List<String> typeidList2 = new ArrayList<>(Arrays.asList(type2));
        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, typeidList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
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
        final ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this, R.layout.spinner_item, typeidList2) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
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
        spinner1.setAdapter(spinnerArrayAdapter);
        spinnerArrayAdapter2.setDropDownViewResource(R.layout.spinner_item);
        spinner2.setAdapter(spinnerArrayAdapter2);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    etat = String.valueOf(position - 1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    if (String.valueOf(position - 1).equals("0")) {
                        valeur = "1000";
                    } else valeur = "5000";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick(R.id.picDateDebut)
    public void picDateDebut() {
        aBoolean = false;
        setDate(lv);
    }

    @OnClick(R.id.picDateFin)
    public void picDateFin() {
        aBoolean = true;
        setDate(lv);
    }

    @OnClick(R.id.btn_filtrer)
    public void btn_filtrer() {

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    if (!aBoolean) {
                        showDate(arg1, arg2 + 1, arg3, showDateDebut);

                    } else {
                        showDate(arg1, arg2 + 1, arg3, showDateFin);

                    }
                }
            };

    private void showDate(int year, int month, int day, TextView textView) {
        textView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
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
