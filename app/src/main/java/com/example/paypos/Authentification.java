package com.example.paypos;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paypos.Model.User;
import com.example.paypos.Utils.Helpers;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.paypos.Utils.Util.getImei;

public class Authentification extends AppCompatActivity {

    @BindView(R.id.txtLogin)
    EditText Email;
    @BindView(R.id.txtPassword)
    EditText Password;
    String iemi, email, password;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        ButterKnife.bind(this);
        context = this;
        iemi = getImei(this);
//        Toast.makeText(this, iemi+"", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_login)
    public void Login() {
        email = Email.getText().toString().trim();
        password = Password.getText().toString().trim();
        if (Valider()) {
            if (Helpers.isConnected(context)) {
                User user = new User(email, password);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                Helpers.ShowMessageConnection(context);
            }
        }
    }

    private boolean Valider() {
        boolean valide = true;
        if (email.isEmpty()) {
            Email.setError(getString(R.string.champs_obligatoir));
            valide = false;
        }
        if (!email.isEmpty() && (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
            Email.setError(getString(R.string.email_invalide));
            valide = false;
        }
        if (password.isEmpty()) {
            Password.setError(getString(R.string.champs_obligatoir));
            valide = false;
        }
        return valide;
    }
}
