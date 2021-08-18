package com.example.premierprojet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.premierprojet.bean.EleveBean;
import com.example.premierprojet.bean.EnseignantBean;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Composants graphique
    TextView tv_console;
    Button bt_ajouter;
    Button bt_ajouterPlusieurs;
    Button bt_suppDernier;
    EditText et_nom;
    EditText et_prenom;
    SeekBar sb_sb1;
    RadioButton rb_eleve;
    RadioButton rb_parent;
    //Données
    ArrayList<EleveBean> eleves;
    ArrayList<EnseignantBean> enseignants;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Indique le fichier XML à charger
        setContentView(R.layout.activity_main);


        //EXERCICE PROJET
        tv_console = (TextView) findViewById(R.id.tv_console);


        bt_ajouter = (Button) findViewById(R.id.bt_ajouter);
        bt_ajouterPlusieurs = (Button) findViewById(R.id.bt_ajouterPlusieurs);
        bt_suppDernier = (Button) findViewById(R.id.bt_suppDernier);

        et_nom = (EditText) findViewById(R.id.et_nom);
        et_prenom = (EditText) findViewById(R.id.et_prenom);

        sb_sb1 = (SeekBar) findViewById(R.id.sb_sb1);

        rb_eleve = (RadioButton) findViewById(R.id.rb_eleve);
        rb_parent = (RadioButton) findViewById(R.id.rb_parent);

        bt_ajouter.setOnClickListener(this);
        bt_ajouterPlusieurs.setOnClickListener(this);
        bt_suppDernier.setOnClickListener(this);


        eleves = new ArrayList<>();
        enseignants = new ArrayList<>();
        tv_console.setText("");
    }

 /*   @Override
    public void onClick(View view) {
        if (view == bt_ajouter) {
            String nom = et_nom.getText().toString();
            String prenom = et_prenom.getText().toString();

            ajouter(nom, prenom, 1);
            rafraichirEcran();

        } else if (view == bt_ajouterPlusieurs) {
            int nb = sb_sb1.getProgress();
            String nom = et_nom.getText().toString();
            String prenom = et_prenom.getText().toString();

            ajouter(nom, prenom, nb);

            rafraichirEcran();
        } else {
            supprimerDernier();
            rafraichirEcran();

        }
    }
*/
    public String concat(String nom, String prenom) {
        String result = "Nom : " + nom + " Prenom : " + prenom;
        if (nom.length() == 0) {
            return "Le nom est vide";
        } else if (prenom.length() == 0) {
            return "Le prenom est vide";
        }
        return result;
    }

    public void ajouter(String nom, String prenom, int nb) {
        if (nom.length() == 0) {
            Toast.makeText(this, "Le nom est vide", Toast.LENGTH_SHORT).show();
            return;
        }
        if (prenom.length() == 0) {
            Toast.makeText(this, "Le prénom est vide", Toast.LENGTH_SHORT).show();
            return;
        }
        for (int i = 0; i < nb; i++) {
            if (rb_eleve.isChecked()) {
                EleveBean eleve = new EleveBean(nom, prenom);
                eleves.add(eleve);
            } else {
                EnseignantBean enseignant = new EnseignantBean(nom, prenom);
                enseignants.add(enseignant);
            }
        }
    }

    public void rafraichirEcran() {
        String result = "Élèves : \n";
        for (EleveBean eleve : eleves) {
            if (eleve.isAdult()) {
                result += "(Adult) ";
            } else {
                result += "(Enfant) ";
            }
            result += eleve.nom + " " + eleve.prenom + "\n";

        }

        result += "Enseignants : \n";

        for (EnseignantBean enseignant : enseignants) {
            result += enseignant.getNom() + " " + enseignant.getPrenom() + "\n";

        }
        tv_console.setText(result);
    }

    public void supprimerDernier() {
        if (rb_eleve.isChecked()) {
            if (eleves.isEmpty()) {
                Toast.makeText(this, "La liste est vide", Toast.LENGTH_SHORT).show();
            } else {
                eleves.remove(eleves.size() - 1);
            }
        } else {
            if (enseignants.isEmpty()) {
                Toast.makeText(this, "La liste est vide", Toast.LENGTH_SHORT).show();
            } else {
                enseignants.remove(enseignants.size() - 1);
            }
        }
    }
}