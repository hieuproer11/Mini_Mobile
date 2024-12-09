package com.example.p2025_2sio_mobile_tran_beriot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accueil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    public Button createButton;
    private ListView listViewJeux;

    private ArrayList<JeuDeSociete> mesJeux = new ArrayList<JeuDeSociete>();

    private void init()
    {
        mesJeux.add(new JeuDeSociete("Monopoly","Lorem Ipsum, bla bla bla","Hasbro",15.65,"photo",1));
        mesJeux.add(new JeuDeSociete("TTMC","Lorem Ipsum, bla bla bla","A",20,"photo",2500));
        mesJeux.add(new JeuDeSociete("AAAAAA","Lorem Ipsum, bla bla bla","AAAAAA",15.65,"photo",0));
    }
}