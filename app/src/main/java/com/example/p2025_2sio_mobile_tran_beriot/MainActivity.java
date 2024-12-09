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

public class MainActivity extends AppCompatActivity {

    private TextView textViewMain;
    private TextView textViewTitre;
    private TextView textViewLogin;
    private TextView textViewMdp;
    private TextView textViewMessage;
    private EditText editTextLogin;
    private EditText editTextMdp;
    private Button buttonConnect;
    private ArrayList<Utilisateur> mesUtilisateurs = new ArrayList<>();
    private Utilisateur user;
    private ArrayList <JeuDeSociete> mesJeux = new ArrayList<>();
    private JeuDeSociete jeu1;
    private JeuDeSociete jeu2;
    private String login;
    private String mdp;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initialisation();
        init_Utilisateur();
        init_listeJeux();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void init_listeJeux(){
        jeu1 = new JeuDeSociete("Monopoly","Lorem Ipsum, bla bla bla","Hasbro",15.65,"monopoly",4);
        jeu2 = new JeuDeSociete("Echec","un jeu de gros cerveaux","un mec",20.19,"echec",4);
        mesJeux.add(jeu1);
        mesJeux.add(jeu2);
    }

    public void initialisation(){

        textViewMain =(TextView) findViewById(R.id.textViewMain);
        textViewTitre =(TextView) findViewById(R.id.textViewTitre);
        textViewLogin =(TextView) findViewById(R.id.textViewLogin);
        textViewMdp =(TextView) findViewById(R.id.textViewMdp);
        textViewMessage =(TextView) findViewById(R.id.textViewMessage);
        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextMdp=(EditText) findViewById(R.id.editTextMdp);
        buttonConnect=(Button) findViewById(R.id.buttonConnect);
        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = editTextLogin.getText().toString();
                mdp = editTextMdp.getText().toString();
                if(controle(login,mdp)){
                    msg ="Connexion avec succès";
                    Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                    intent.putExtra("MesJeux", mesJeux);
                    startActivity(intent);
                } else {
                    msg ="Connexion échoué";
                }
                textViewMessage.setText(msg);
            }
        });

    }
    public void init_Utilisateur(){
        Utilisateur user1 = new Utilisateur("hieu","1122");
        Utilisateur user2 = new Utilisateur("alexis", "1234");
        mesUtilisateurs = new ArrayList<Utilisateur>();
        mesUtilisateurs.add(user1);
        mesUtilisateurs.add(user2);
    }

    public boolean controle(String login, String mdp){
        for(Utilisateur user: mesUtilisateurs) {
            if (user.getLogin().equals(login) && user.getMdp().equals(mdp)) {
                return true;
            }
        }
        return false;
    }
}