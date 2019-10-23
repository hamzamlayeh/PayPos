package com.example.paypos.Model;

import java.io.Serializable;

public class TransfertArgent implements Serializable {

    private int id_TArg;
    private int id_destinateur;
    private int id_recepteur;
    private int montant;

    public TransfertArgent() {
    }

    public TransfertArgent(int id_destinateur,  int montant) {
        this.id_destinateur = id_destinateur;
        this.montant = montant;
    }

    public int getId_TArg() {
        return id_TArg;
    }

    public void setId_TArg(int id_TArg) {
        this.id_TArg = id_TArg;
    }

    public int getId_destinateur() {
        return id_destinateur;
    }

    public void setId_destinateur(int id_destinateur) {
        this.id_destinateur = id_destinateur;
    }

    public int getId_recepteur() {
        return id_recepteur;
    }

    public void setId_recepteur(int id_recepteur) {
        this.id_recepteur = id_recepteur;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
