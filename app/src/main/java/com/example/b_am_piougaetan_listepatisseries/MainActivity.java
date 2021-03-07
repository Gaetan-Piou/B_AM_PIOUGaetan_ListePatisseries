package com.example.b_am_piougaetan_listepatisseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView monRecyclerView;
    private rec_adapter monAdapter;
    private RecyclerView.LayoutManager monLayoutManager;
    private EditText barreRecherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_patisserieList);
        monRecyclerView.setHasFixedSize(true); //Taille fixe des éléments de la liste = optimisation du recyclerView

        monLayoutManager = new LinearLayoutManager(this);
        monRecyclerView.setLayoutManager(monLayoutManager);

        ArrayList<Patisserie> patisserieList = new ArrayList<Patisserie>();
        initList(patisserieList);

        monAdapter = new rec_adapter(patisserieList); //cf. rec_adapµter.java, classe de l’adaptateur
        monRecyclerView.setAdapter(monAdapter);

        barreRecherche = (EditText) findViewById(R.id.editTextSearch);

        barreRecherche.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String sName = s.toString();

                filtrer(sName, patisserieList);
            }
        });
    }

    private void initList(ArrayList<Patisserie> patisserieList) {
        Patisserie patisserie = new Patisserie();
        patisserie.setPatisserieName("Macaron");
        patisserie.setPatisserieDescription("1.70€");
        patisserie.setPatisserieId(getResources().getIdentifier("macaron" , "drawable", getPackageName()));
        patisserieList.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setPatisserieName("Tarte au citron meringuée");
        patisserie.setPatisserieDescription("3.50€ (la part)");
        patisserie.setPatisserieId(getResources().getIdentifier("tartecitronmeringuee" , "drawable", getPackageName()));
        patisserieList.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setPatisserieName("Eclair");
        patisserie.setPatisserieDescription("1.80€");
        patisserie.setPatisserieId(getResources().getIdentifier("eclair" , "drawable", getPackageName()));
        patisserieList.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setPatisserieName("Mille-feuille");
        patisserie.setPatisserieDescription("3.60€");
        patisserie.setPatisserieId(getResources().getIdentifier("millefeuille" , "drawable", getPackageName()));
        patisserieList.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setPatisserieName("Marbré");
        patisserie.setPatisserieDescription("12.00€");
        patisserie.setPatisserieId(getResources().getIdentifier("marbre" , "drawable", getPackageName()));
        patisserieList.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setPatisserieName("Madeleine au chocolat");
        patisserie.setPatisserieDescription("1.00€");
        patisserie.setPatisserieId(getResources().getIdentifier("madeleinechoco" , "drawable", getPackageName()));
        patisserieList.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setPatisserieName("Meringue");
        patisserie.setPatisserieDescription("1.50€");
        patisserie.setPatisserieId(getResources().getIdentifier("meringue" , "drawable", getPackageName()));
        patisserieList.add(patisserie);
    }

    private void filtrer(String text,  ArrayList<Patisserie> patisserieList) {
        ArrayList<Patisserie> filteredList = new ArrayList<Patisserie>();

        for (Patisserie item : patisserieList) {
            if(item.getPatisserieName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        monAdapter.filterList(filteredList);
    }
}