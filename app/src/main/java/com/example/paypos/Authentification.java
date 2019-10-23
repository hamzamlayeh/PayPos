package com.example.paypos;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paypos.Model.RSResponse;
import com.example.paypos.Model.User;
import com.example.paypos.Utils.Constants;
import com.example.paypos.Utils.Helpers;
import com.example.paypos.Utils.Loader;
import com.example.paypos.WebService.WebService;
import com.example.paypos.session.RSSession;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.paypos.Utils.Util.getImei;

public class Authentification extends AppCompatActivity {

    @BindView(R.id.txtLogin)
    EditText Email;
    @BindView(R.id.txtPassword)
    EditText Password;
    String iemi, email, password;
    Context context;
    DialogFragment Loding = Loader.getInstance();

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
                Loding.show(getSupportFragmentManager(), Constants.LODING);
                User user = new User(email, password);
                Call<RSResponse> callUpload = WebService.getInstance().getApi().loginUser(user);
                callUpload.enqueue(new Callback<RSResponse>() {
                    @Override
                    public void onResponse(Call<RSResponse> call, Response<RSResponse> response) {
                        if (response.body() != null) {
                            Loding.dismiss();
                            if (response.body().getStatus() == 1) {
                                RSSession.saveIntoSharedPreferences(response.body().getData(), context);
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else if (response.body().getStatus() == 0) {
                                Toast.makeText(context, "connexion echoueé", Toast.LENGTH_SHORT).show();
                            } else if (response.body().getStatus() == 2) {
                                Toast.makeText(context, getString(R.string.EmailOuMotDePasseInvalide), Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Loding.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<RSResponse> call, Throwable t) {
                        Loding.dismiss();
                        Log.i("err", t.getMessage());
                    }
                });
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
