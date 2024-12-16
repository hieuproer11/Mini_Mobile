package com.example.p2025_2sio_mobile_tran_beriot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private TextView textViewDetailJeu;
    private TextView textViewNom;
    private TextView textViewDesc;
    private TextView textViewAuteur;
    private TextView textViewPrix;
    private TextView textViewNbjou;
    private ImageView imageViewJeu;
    private Button buttonRetour;
    private ArrayList <JeuDeSociete> mesJeux = new ArrayList<>();
    private String nom;
    private String desc;
    private String auteur;
    private Double prix;
    private int nbjou;
    private String photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        initialisation();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void initialisation() {

        mesJeux = (ArrayList<JeuDeSociete>) getIntent().getSerializableExtra("MesJeux");

        textViewDetailJeu = (TextView) findViewById(R.id.textViewDetailJeu);
        Intent intent = getIntent();
        textViewNom = (TextView) findViewById(R.id.textViewNom);
        if(intent.hasExtra("nom")){
            nom = intent.getStringExtra("nom");
            textViewNom.setText(nom);
        }
        textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        if(intent.hasExtra("desc")){
            desc = intent.getStringExtra("desc");
            textViewDesc.setText("Description: " + desc);
        }
        textViewAuteur = (TextView) findViewById(R.id.textViewAuteur);
        if(intent.hasExtra("auteur")){
            auteur = intent.getStringExtra("auteur");
            textViewAuteur.setText("Crée par: " + auteur);
        }
        textViewPrix = (TextView) findViewById(R.id.textViewPrix);
        if(intent.hasExtra("prix")){
            prix = intent.getDoubleExtra("prix",0);
            textViewPrix.setText("le prix pour un set est: " + prix + " euros");
        }
        textViewNbjou = (TextView) findViewById(R.id.textViewNbjou);
        if(intent.hasExtra("nbjou")){
            nbjou = intent.getIntExtra("nbjou",0);
            textViewNbjou.setText("Le nombre de joueurs total est: " + nbjou);
        }
        imageViewJeu = (ImageView) findViewById(R.id.imageViewJeu);
        if(intent.hasExtra("photo")){
            photo = intent.getStringExtra("photo");
            if(photo.equals("monopoly")){
                    this.imageViewJeu.setImageResource(R.drawable.monopoly);
            }
            if(photo.equals("echec")){
                    this.imageViewJeu.setImageResource(R.drawable.echec);
            }
            if(photo.equals("uno")){
                this.imageViewJeu.setImageResource(R.drawable.uno);
            }
            if(photo.equals("")){
                this.imageViewJeu.setImageResource(R.drawable.fondecran1);
            }
        }

        buttonRetour = (Button) findViewById(R.id.buttonRetour);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DetailActivity.this, SelectActivity.class);
                intent1.putExtra("MesJeux", mesJeux);
                startActivity(intent1);
            }
        });


    }

}