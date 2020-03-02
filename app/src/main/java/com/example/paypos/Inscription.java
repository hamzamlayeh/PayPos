package com.example.paypos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Inscription extends AppCompatActivity {

//    @BindView(R.id.nom)
//    TextInputEditText Nom;
//    @BindView(R.id.prenom)
//    TextInputEditText Prenom;
//    @BindView(R.id.email)
//    TextInputEditText Email;
//    @BindView(R.id.password)
//    TextInputEditText Password;
//    @BindView(R.id.numeroGSM)
//    TextInputEditText NumGSM;

//    @BindView(R.id.namelayout)
//    TextInputLayout layoutNom;
//    @BindView(R.id.prenomlayout)
//    TextInputLayout layoutPrenom;
//    @BindView(R.id.emaillayout)
//    TextInputLayout layoutEmail;
//    @BindView(R.id.passwordlayout)
//    TextInputLayout layoutPassword;
//    @BindView(R.id.GSMLayout)
//    TextInputLayout layoutGSM;
//    String nom, prenom, email, password, numGSM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void Inscrire() {
//        email = Email.getText().toString().trim();
//        password = Password.getText().toString().trim();
//        nom = Nom.getText().toString().trim();
//        prenom = Prenom.getText().toString().trim();
//        numGSM = NumGSM.getText().toString().trim();
//        if (Valider()) {
//            startActivity(new Intent(this, MainActivity.class));
//        }
    }

//    private boolean Valider() {
//        boolean valide = true;
//        if (email.isEmpty()) {
//            layoutEmail.setError(getString(R.string.champs_obligatoir));
//            valide = false;
//        } else {
//            layoutEmail.setError(null);
//        }
//        if (!email.isEmpty() && (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
//            layoutEmail.setError(getString(R.string.email_invalide));
//            valide = false;
//        }
//        if (nom.isEmpty()) {
//            layoutNom.setError(getString(R.string.champs_obligatoir));
//            valide = false;
//        } else {
//            layoutNom.setError(null);
//        }
//        if (prenom.isEmpty()) {
//            layoutPrenom.setError(getString(R.string.champs_obligatoir));
//            valide = false;
//        } else {
//            layoutPrenom.setError(null);
//        }
//        if (numGSM.isEmpty()) {
//            layoutGSM.setError(getString(R.string.champs_obligatoir));
//            valide = false;
//        } else {
//            layoutGSM.setError(null);
//        }
//        if (password.isEmpty()) {
//            layoutPassword.setError(getString(R.string.champs_obligatoir));
//            valide = false;
//        } else {
//            layoutPassword.setError(null);
//        }
//        return valide;
//    }
}
