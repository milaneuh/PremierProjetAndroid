package com.example.premierprojet.bean;

import java.util.Random;

public class EleveBean {
    //-----------------------
    //      CONSTANTES
    //-----------------------

    private static final Random random = new Random();
    public static final int AGE_ADULTE = 18;

    //-----------------------
    //      ATTRIBUTS
    //-----------------------

    public  String nom,prenom;
    private int age;

    //-----------------------
    //       METHODES
    //-----------------------

    public boolean isAdult(){
        return  age >= AGE_ADULTE;
    }

    public EleveBean(){
        this.age = random.nextInt(100);
    }
    public EleveBean(String nom,String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.age = random.nextInt(100);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
