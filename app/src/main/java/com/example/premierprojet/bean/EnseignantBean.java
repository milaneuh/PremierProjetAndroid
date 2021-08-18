package com.example.premierprojet.bean;

public class EnseignantBean {
    //-----------------------
    //      ATTRIBUTS
    //-----------------------

    private String nom;
    private String prenom;

    //-----------------------
    //     CONSTRUCTEUR
    //-----------------------

    public EnseignantBean() {
    }


    public EnseignantBean(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    //-----------------------
    //   GETTER / SETTER
    //-----------------------


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
