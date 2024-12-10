package com.example.p2025_2sio_mobile_tran_beriot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accueil);
        initialisation();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private JeuDeSociete leJeu;
    private ArrayList<JeuDeSociete> mesJeux = new ArrayList<JeuDeSociete>();

    private ArrayAdapter dataAdapter;
    private Button createButton;

    private ListView listViewJeux;

    private Button viewButton;

    public void initialisation()
    {
        mesJeux = (ArrayList<JeuDeSociete>) getIntent().getSerializableExtra("MesJeux");


        createButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(AccueilActivity.this, AjouterActivity.class);
            startActivity(intent);
        }});
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, SelectActivity.class);
                startActivity(intent);
            }});


        listViewJeux.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                leJeu = mesJeux.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }





//    private void init()
//    {
//        mesJeux.add(new JeuDeSociete("Monopoly","Lorem Ipsum, bla bla bla","Hasbro",15.65,"photo",1));
//        mesJeux.add(new JeuDeSociete("TTMC","Lorem Ipsum, bla bla bla","A",20,"photo",2500));
//        mesJeux.add(new JeuDeSociete("AAAAAA","Lorem Ipsum, bla bla bla","AAAAAA",15.65,"photo",0));
//    }
}