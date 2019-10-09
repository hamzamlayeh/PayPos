package com.example.paypos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ParametreMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre_menu);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_modifier)
    public void Modifier(){
        startActivity(new Intent(getApplicationContext(),ParametreActivity.class));
    }
}
