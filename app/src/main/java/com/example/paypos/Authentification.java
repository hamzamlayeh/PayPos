package com.example.paypos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Authentification extends AppCompatActivity {

    @BindView(R.id.email)
    TextInputEditText Email;
    @BindView(R.id.password)
    TextInputEditText Password;
    @BindView(R.id.loginLayout)
    TextInputLayout layoutEmail;
    @BindView(R.id.pwdLayout)
    TextInputLayout layoutPassword;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.newAccount)
    public void InscrirePage() {
        startActivity(new Intent(this, Inscription.class));
    }

    @OnClick(R.id.btn_login)
    public void Login() {
        email = Email.getText().toString().trim();
        password = Password.getText().toString().trim();
        if (Valider()){
            startActivity(new Intent(this, MainActivity.class));
        }
    }
    private boolean Valider() {
        boolean valide = true;
        if (email.isEmpty()) {
            layoutEmail.setError(getString(R.string.champs_obligatoir));
            valide = false;
        } else {
            layoutEmail.setError(null);
        }
        if (!email.isEmpty() && (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
            layoutEmail.setError(getString(R.string.email_invalide));
            valide = false;
        }
        if (password.isEmpty()) {
            layoutPassword.setError(getString(R.string.champs_obligatoir));
            valide = false;
        } else {
            layoutPassword.setError(null);
        }
        return valide;
    }
}
