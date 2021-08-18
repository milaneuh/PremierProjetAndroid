package com.example.jeudedes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jeudedes.beans.PartieBean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_turnCount;
    private TextView tv_scoreJoueur1;
    private ImageView iv_tourJoueur1;
    private TextView tv_scoreJoueur2;
    private ImageView iv_tourJoueur2;
    private Button bt_lancer;
    private TextView tv_de1;
    private TextView tv_de2;
    private TextView tv_joueur1;
    private TextView tv_joueur2;
    private PartieBean partie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_turnCount = (TextView) findViewById(R.id.tv_turnCount);
        tv_scoreJoueur1 = (TextView) findViewById(R.id.tv_scoreJoueur1);
        iv_tourJoueur1 = (ImageView) findViewById(R.id.iv_tourJoueur1);
        tv_scoreJoueur2 = (TextView) findViewById(R.id.tv_scoreJoueur2);
        iv_tourJoueur2 = (ImageView) findViewById(R.id.iv_tourJoueur2);
        tv_joueur1 = (TextView) findViewById(R.id.tv_joueur1);
        tv_joueur2 = (TextView) findViewById(R.id.tv_joueur2);
        bt_lancer = (Button) findViewById(R.id.bt_lancer);
        tv_de1 = (TextView) findViewById(R.id.tv_de1);
        tv_de2 = (TextView) findViewById(R.id.tv_de2);

        bt_lancer.setOnClickListener((View.OnClickListener) this);

        partie = new PartieBean("Joueur 1", "Joueur 2");
        tv_joueur1.setText("Joueur 1");
        tv_joueur2.setText("Joueur 2");


    }

    @Override
    public void onClick(View v) {
        if (v == bt_lancer) {
            // Handle clicks for bt_lancer
            partie.getProchainJoueur().lancer();

            if (partie.getProchainJoueur().getScoreDes() >= PartieBean.VALEUR_A_ATTEINDRE) {
                partie.getProchainJoueur().setScore(partie.getProchainJoueur().getScore() + 1);
            }

            partie.changerJoueur();

            if (partie.getProchainJoueur() == partie.getJ1()) {
                partie.setNumTour(partie.getNumTour() + 1);
            }
            rafraichirEcran();
        }
    }


    public void rafraichirEcran() {
        tv_turnCount.setText(partie.getNumTour() + "");

        tv_scoreJoueur1.setText(partie.getJ1().getScore() + "");
        tv_scoreJoueur2.setText(partie.getJ2().getScore() + "");

        if (partie.getJ1() == partie.getProchainJoueur()) {
            tv_de1.setText(partie.getJ2().getScoreDe1() + "");
            tv_de2.setText(partie.getJ2().getScoreDe2() + "");
            iv_tourJoueur1.setVisibility(View.VISIBLE);
            iv_tourJoueur2.setVisibility(View.INVISIBLE);
        } else {
            tv_de1.setText(partie.getJ1().getScoreDe1() + "");
            tv_de2.setText(partie.getJ1().getScoreDe2() + "");
            iv_tourJoueur2.setVisibility(View.VISIBLE);
            iv_tourJoueur1.setVisibility(View.INVISIBLE);
        }

        if (partie.getNumTour() >= PartieBean.NBR_TOUR + 1) {
            Toast.makeText(this, "Fin", Toast.LENGTH_SHORT).show();
        }
    }

}