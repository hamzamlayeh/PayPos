package com.example.paypos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paypos.Model.RSResponse;
import com.example.paypos.Model.TransfertArgent;
import com.example.paypos.Model.UserInfos;
import com.example.paypos.Utils.Constants;
import com.example.paypos.Utils.Helpers;
import com.example.paypos.Utils.Loader;
import com.example.paypos.WebService.WebService;
import com.example.paypos.session.RSSession;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.paypos.Utils.Util.getUname;

public class TransfertArgentActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtEmail)
    EditText Email;
    @BindView(R.id.txtMontant)
    EditText Montant;
    String email, montant;
    int id_recepteur;
    Context context;
    View popupInputDialogView = null;
    DialogFragment Loding = Loader.getInstance();
    UserInfos userInfos = new UserInfos();
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfert_argent);
        ButterKnife.bind(this);
        context = this;

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
                        //Toast.makeText(HistoriqueMenu.this, "Home", Toast.LENGTH_LONG).show();
                    }
                }
        );
        userInfos = RSSession.getLocalStorage(context);
    }

    @OnClick(R.id.btn_envoyer)
    public void Envoyer() {
        email = Email.getText().toString().trim();
        montant = Montant.getText().toString().trim();
        if (Valider()) {
            if (Helpers.isConnected(context)) {
                Loding.show(getSupportFragmentManager(), Constants.LODING);
                Call<RSResponse> callUpload = WebService.getInstance().getApi().VerifUserByEmail(email);
                callUpload.enqueue(new Callback<RSResponse>() {
                    @Override
                    public void onResponse(Call<RSResponse> call, Response<RSResponse> response) {
                        if (response.body() != null) {
                            Loding.dismiss();
                            if (response.body().getStatus() == 1) {
                                UserInfos userInfos = new Gson().fromJson(new Gson().toJson(response.body().getData()), UserInfos.class);
                                id_recepteur = userInfos.getId_client();
                                LayoutInflater layoutInflater = LayoutInflater.from(context);
                                popupInputDialogView = layoutInflater.inflate(R.layout.item_dialog, null);
                                TextView montant = popupInputDialogView.findViewById(R.id.montant_text);
                                montant.setText(String.format("%s DT", Montant.getText().toString()));
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                                alertDialogBuilder.setCancelable(true);
                                alertDialogBuilder.setView(popupInputDialogView);
                                alertDialog = alertDialogBuilder.create();
                                alertDialog.show();
                                //Toast.makeText(context, userInfos.getId_client()+"", Toast.LENGTH_SHORT).show();
                                // RSSession.saveIntoSharedPreferences(response.body().getData(), context);
                                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else if (response.body().getStatus() == 0) {
                                Toast.makeText(context, "connexion echoueé", Toast.LENGTH_SHORT).show();
                            } else if (response.body().getStatus() == 2) {
                                Toast.makeText(context, "Email n'ai existe pas!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
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
        if (montant.isEmpty()) {
            Montant.setError(getString(R.string.champs_obligatoir));
            valide = false;
        }
        return valide;
    }

    public void Accepter(View view) {
        if (Helpers.isConnected(context)) {
//            Loding.show(getSupportFragmentManager(), Constants.LODING);
//            Call<RSResponse> callUpload = WebService.getInstance().getApi().VerifUserByEmail(email);
//            callUpload.enqueue(new Callback<RSResponse>() {
//                @Override
//                public void onResponse(Call<RSResponse> call, Response<RSResponse> response) {
//                    if (response.body() != null) {
//                        Loding.dismiss();
//                        if (response.body().getStatus() == 1) {
//                            UserInfos userInfos = new Gson().fromJson(new Gson().toJson(response.body().getData()), UserInfos.class);
//                            id_recepteur = userInfos.getId_client();
//
//                            //Toast.makeText(context, userInfos.getId_client()+"", Toast.LENGTH_SHORT).show();
//                            // RSSession.saveIntoSharedPreferences(response.body().getData(), context);
//                            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        } else if (response.body().getStatus() == 0) {
//                            Toast.makeText(context, "connexion echoueé", Toast.LENGTH_SHORT).show();
//                        } else if (response.body().getStatus() == 2) {
//                            Toast.makeText(context, "Email n'ai existe pas!", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Loding.dismiss();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<RSResponse> call, Throwable t) {
//                    Loding.dismiss();
//                    Log.i("err", t.getMessage());
//                }
//            });

        } else {
            Helpers.ShowMessageConnection(context);
        }
        Toast.makeText(context, id_recepteur+"/"+montant, Toast.LENGTH_SHORT).show();
    }

    public void annulerDialog(View view) {
        alertDialog.cancel();
    }

    private RequestBody createPartFormString(String value) {
        return RequestBody.create(MultipartBody.FORM, value);
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
