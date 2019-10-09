package com.example.paypos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ParametreActivity extends AppCompatActivity {

    @BindView(R.id.txtLastCode)
    EditText txtLastCode;
    @BindView(R.id.txtNewCode)
    EditText txtNewCode;
    @BindView(R.id.txtVrfCode)
    EditText txtVrfCode;
    @BindView(R.id.txtVrf)
    TextView txtVrf;
    @BindView(R.id.txtLastVrf)
    TextView txtLastVrf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_enregistrer)
    public void Enregistrer() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
