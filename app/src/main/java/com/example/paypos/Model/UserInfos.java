package com.example.paypos.Model;

import java.io.Serializable;

public class UserInfos implements Serializable {
    private int id_client;
    private String email;
    private String password;
    private int solde;

    public UserInfos() {
    }

    public UserInfos(String email, String password, int solde) {
        this.email = email;
        this.password = password;
        this.solde = solde;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
}
