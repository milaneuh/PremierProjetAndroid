package com.example.jeudedes.beans;

public class PartieBean {
    //-----------------------
    //      ATTRIBUTS
    //-----------------------

    public static final int NBR_TOUR = 10;
    public static final int VALEUR_A_ATTEINDRE = 7;
    JoueurBean j1, j2;
    private int numTour;
    private JoueurBean ProchainJoueur;

    public PartieBean(String nomJ1, String nomJ2) {
        j1 = new JoueurBean(nomJ1);
        j2 = new JoueurBean(nomJ2);
        ProchainJoueur = j1;
        numTour = 1;
    }


    public void changerJoueur() {
        if (ProchainJoueur == j2) {
            ProchainJoueur = j1;
        } else {
            ProchainJoueur = j2;
        }

    }

    public int getNumTour() {
        return numTour;
    }

    public void setNumTour(int numTour) {
        this.numTour = numTour;
    }

    public JoueurBean getJ2() {
        return j2;
    }

    public JoueurBean getJ1() {
        return j1;
    }

    public JoueurBean getProchainJoueur() {
        return ProchainJoueur;
    }
}

