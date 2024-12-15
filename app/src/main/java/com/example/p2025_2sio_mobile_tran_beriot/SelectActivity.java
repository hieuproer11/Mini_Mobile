package com.example.p2025_2sio_mobile_tran_beriot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selection);
        initialisation();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.selectPage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private TextView textViewSelection;
    private JeuDeSociete leJeu;
    private ArrayList<JeuDeSociete> mesJeux;
    private Spinner spinnerJeux;
    private Button bConfirmer;
    private Button bSupprimer;
    private Button bRetour;


    private void initialisation()
    {
        mesJeux = (ArrayList<JeuDeSociete>) getIntent().getSerializableExtra("MesJeux");
        textViewSelection =(TextView) findViewById(R.id.textViewSelection);
        spinnerJeux = (Spinner) findViewById(R.id.spinnerJeux);
        bConfirmer = (Button) findViewById(R.id.bConfirmer);
        bSupprimer = (Button) findViewById(R.id.bSupprimer);
        bRetour = (Button) findViewById(R.id.bRetour);
        spinnerJeux.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                leJeu = mesJeux.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        bConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, DetailActivity.class);
                intent.putExtra("MesJeux", mesJeux);
                intent.putExtra("nom", leJeu.getNom());
                intent.putExtra("desc", leJeu.getDesc());
                intent.putExtra("auteur", leJeu.getAuteur());
                intent.putExtra("prix", leJeu.getPrix());
                intent.putExtra("nbjou", leJeu.getNbjou());
                startActivity(intent);
            }});

        bRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, AccueilActivity.class);
                intent.putExtra("MesJeux", mesJeux);
                startActivity(intent);
            }});

    }
}
