package com.example.jeudedes.beans;

public class JoueurBean {
    //-----------------------
    //      ATTRIBUTS
    //-----------------------

    private GobeletBean gobelet;
    private int score;
    private String nom;

    //-----------------------
    //      METHODES
    //-----------------------
    public JoueurBean(String nom) {
        this.nom = nom;
        gobelet = new GobeletBean();
        score = 0;
    }

    public void lancer() {
        gobelet.lancer();
    }

    public int getScoreDes() {
        return gobelet.getScoresDes();
    }

    public int getScoreDe1() {
        return gobelet.getDe1().getValeur();
    }

    public int getScoreDe2() {
        return gobelet.getDe2().getValeur();
    }

    public JoueurBean() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
