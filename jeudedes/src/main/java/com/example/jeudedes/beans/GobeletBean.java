package com.example.jeudedes.beans;

public class GobeletBean {
    //-----------------------
    //      ATTRIBUTS
    //-----------------------

    private DeBean de1, de2;

    //-----------------------
    //      METHODES
    //-----------------------
    public void lancer() {
        de1.lancer();
        de2.lancer();
    }

    public GobeletBean() {
        de1 = new DeBean();
        de2 = new DeBean();
    }

    public DeBean getDe1() {
        return de1;
    }

    public DeBean getDe2() {
        return de2;
    }

    public int getScoresDes() {
        return de1.getValeur() + de2.getValeur();
    }

}
