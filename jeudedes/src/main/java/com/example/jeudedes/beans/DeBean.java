package com.example.jeudedes.beans;

import java.util.Random;

public class DeBean {
    //-----------------------
    //      ATTRIBUTS
    //-----------------------
    private static final Random random = new Random();
    private static final int NB_FACE = 6;
    private int valeur;

    //-----------------------
    //      METHODES
    //-----------------------

    public DeBean() {
    }

    public int getValeur() {
        return valeur;
    }

    public void lancer() {
        this.valeur = random.nextInt(NB_FACE);
    }
}
