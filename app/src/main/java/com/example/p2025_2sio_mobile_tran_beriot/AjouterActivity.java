package com.example.p2025_2sio_mobile_tran_beriot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class AjouterActivity extends AppCompatActivity {
    private TextView textViewAjouter;
    private EditText editTextNom;
    private EditText editTextDesc;
    private EditText editTextAuteur;
    private EditText editTextPrix;
    private EditText editTextNbjou;
    private Button buttonAjouer;
    private JeuDeSociete monJeu;
    private String nom;
    private String desc;
    private String auteur;
    private Double prix;
    private int nbjou;
    private ArrayList<JeuDeSociete> mesJeux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ajouter);
        initialisation();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void initialisation(){
        // Récupération de la liste des jeux
        mesJeux = (ArrayList<JeuDeSociete>) getIntent().getSerializableExtra("MesJeux");

        textViewAjouter =(TextView) findViewById(R.id.textViewAjouter);
        editTextNom = (EditText) findViewById(R.id.editTextNom);
        editTextDesc = (EditText) findViewById(R.id.editTextDesc);
        editTextAuteur = (EditText) findViewById(R.id.editTextAuteur);
        editTextPrix = (EditText) findViewById(R.id.editTextPrix);
        editTextNbjou = (EditText) findViewById(R.id.editTextNbjou);
        buttonAjouer = (Button) findViewById(R.id.buttonAjouter);

        // Ajouter un article à la liste
        buttonAjouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nom = editTextNom.getText().toString();
                desc = editTextDesc.getText().toString();
                auteur = editTextAuteur.getText().toString();
                prix = Double.parseDouble(editTextPrix.getText().toString());
                nbjou = Integer.parseInt(editTextNbjou.getText().toString());
                monJeu = new JeuDeSociete(nom, desc, auteur, prix,"", nbjou);
                mesJeux.add(monJeu);

                // Retourner la liste mise à jour à AccueilActivity
                Intent intent = new Intent(AjouterActivity.this, AccueilActivity.class);
                intent.putExtra("MesJeux", mesJeux);
                startActivity(intent);
                finish();

            }
        });




    }
}