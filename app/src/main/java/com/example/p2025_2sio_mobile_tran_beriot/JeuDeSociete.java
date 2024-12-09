package com.example.p2025_2sio_mobile_tran_beriot;

import java.io.Serializable;

public class JeuDeSociete implements Serializable {
    private String nom;
    private String desc;
    private String auteur;
    private double prix;
    private String photo;
    private int nbjou;

    public JeuDeSociete(String nom, String desc, String auteur, double prix, String photo, int nbjou) {
        this.nom = nom;
        this.desc = desc;
        this.auteur = auteur;
        this.prix = prix;
        this.photo = photo;
        this.nbjou = nbjou;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNbjou() {
        return nbjou;
    }

    public void setNbjou(int nbjou) {
        this.nbjou = nbjou;
    }
}
