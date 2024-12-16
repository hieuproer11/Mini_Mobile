package com.example.p2025_2sio_mobile_tran_beriot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AccueilActivity extends AppCompatActivity {
    private TextView textViewHeader;
    public Button createButton;
    public Button viewButton;
    public Button bDeconnecter;
    private ListView listViewJeux;
    private ArrayList<JeuDeSociete> mesJeux;
    private ArrayAdapter dataAdapter;
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

    public void initialisation(){
        textViewHeader = (TextView) findViewById(R.id.textViewHeader);
        createButton = (Button) findViewById(R.id.createButton);
        listViewJeux =(ListView) findViewById(R.id.listViewJeux);
        viewButton = (Button) findViewById(R.id.viewButton);
        bDeconnecter = (Button) findViewById(R.id.bDeconnecter);

        if(getIntent().getSerializableExtra("MesJeux") == null){
            mesJeux = new ArrayList<JeuDeSociete>();
        }else {
            mesJeux = (ArrayList<JeuDeSociete>) getIntent().getSerializableExtra("MesJeux");
        }

        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mesJeux.stream().map(JeuDeSociete::getNom).collect(Collectors.toList()));
        listViewJeux.setAdapter(dataAdapter);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccueilActivity.this, AjouterActivity.class);
                intent.putExtra("MesJeux",mesJeux);
                startActivity(intent);
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(AccueilActivity.this, SelectActivity.class);
                intent1.putExtra("MesJeux", mesJeux);
                startActivity(intent1);
            }
        });

        bDeconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AccueilActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }



}