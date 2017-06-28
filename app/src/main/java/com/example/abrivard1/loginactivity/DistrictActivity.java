package com.example.abrivard1.loginactivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DistrictActivity extends AppCompatActivity {
    public GridView gridView;
    public DistrictAdapter districtAdapter;
    public ArrayList<District> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
        Intent intent= getIntent();
        Bundle extra = intent.getExtras();
        String pseudo = extra.getString("pseudo");
        TextView pseudoTextView = (TextView) findViewById(R.id.TextViewPseudoDistrict);

        pseudoTextView.setText("Bonjour "+pseudo);

        gridView=(GridView) findViewById(R.id.Grid);
        //gridView.
        list=prepareStaticList();
        districtAdapter=new DistrictAdapter(DistrictActivity.this,R.layout.item_district,list);
        gridView.setAdapter(districtAdapter);
        SearchView filter= (SearchView) findViewById(R.id.filter);


        filter.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Toast.makeText(DistrictActivity.this, newText, Toast.LENGTH_SHORT).show();

                districtAdapter.getFilter().filter(newText);
                return false;
            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                District dist=list.get(position);
                DistrictDialog dialog = new DistrictDialog(DistrictActivity.this , dist.getDescription() );
                dialog.setTitle(dist.getName());
                dialog.getCall().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(DistrictActivity.this, MapActivity.class);
                      //  Bundle extra= new Bundle();
                        //intent2.putExtras(extra);
                        startActivity(intent2);

                    }
                });

                dialog.show();

                Toast.makeText(DistrictActivity.this, list.get(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    protected void onResume() {

        super.onResume();

    }

    public ArrayList<District> prepareStaticList(){
        ArrayList<District> listDistrict=new ArrayList<District>();
        listDistrict.add(new District(1,"Louvre","Le 1er arrondissement de Paris est l'un des arrondissements les plus centraux du cœur ... ",R.drawable.img_district1));
        listDistrict.add(new District(2,"Bourse","Le 2e arrondissement de Paris est le produit de l'extension de Paris aux XV et XVI siècles ...",R.drawable.img_district2));
        listDistrict.add(new District(3,"Temple","Le 3e arrondissement de Paris est le résultat de l'extension de la ville aux XIII e et XIV e siècles ...",R.drawable.img_district3));
        listDistrict.add(new District(4,"Hôtel-de-Ville","Le 4e arrondissement de Paris se situe sur la rive droite de la Seine ...",R.drawable.img_district4));
        listDistrict.add(new District(5,"Panthéon","Le 5ᵉ arrondissement de Paris est le plus ancien quartier de la ville ...",R.drawable.img_district5));
        listDistrict.add(new District(6,"Luxembourg","Le 6e arrondissement de Paris se situe au centre de la ville, sur la rive gauche de la Seine ... ",R.drawable.img_district6));
        listDistrict.add(new District(7,"Palais-Bourbon","Le 7e arrondissement de Paris est le résultat de l'extension de la ville de Paris au début du XIX siècle ...",R.drawable.img_district7));
        listDistrict.add(new District(8,"Élysée","Le 8e arrondissement de Paris est l'un des 20 arrondissements de Paris ... ",R.drawable.img_district8));
        listDistrict.add(new District(9,"Opéra","Le 9e arrondissement de Paris est un des vingt arrondissements de Paris, situé sur la rive ... ",R.drawable.img_district9));
        listDistrict.add(new District(10,"Enclos","Le 10e arrondissement de Paris est un des vingt arrondissements de Paris, situé sur la rive ... ",R.drawable.img_district10));
        listDistrict.add(new District(11,"Popincourt","Le 11e arrondissement de Paris est un des vingt arrondissements de Paris. Il est situé sur la ... ",R.drawable.img_district11));
        listDistrict.add(new District(12,"Reuilly","Le 12e arrondissement de Paris est l'un des vingt arrondissements de Paris, la capitale française ...",R.drawable.img_district12));
        listDistrict.add(new District(13,"Gobelins","Le 13e arrondissement de Paris est un des vingt arrondissements de Paris. Il est situé sur la ..... ",R.drawable.img_district13));
        listDistrict.add(new District(14,"Observatoire","Le 14e arrondissement de Paris est un des vingt arrondissements de la capitale. Il est situé sur ... ",R.drawable.img_district14));
        listDistrict.add(new District(15,"Vaugirard","Le 15e arrondissement de Paris est l'un des vingt arrondissements de la capitale française. Il est situé sur la rive gauche de la Seine ...",R.drawable.img_district15));
        listDistrict.add(new District(16,"Passy","Le 16e arrondissement de Paris, l'un des vingt arrondissements de Paris, est situé sur la rive droite de la Seine, à l'ouest de la ville ...",R.drawable.img_district16));
        listDistrict.add(new District(17,"Batignolles-Monceau","Le 17ᵉ arrondissement de Paris est l'un des vingt arrondissements de Paris. Il est situé sur la rive droite de la Seine  ...",R.drawable.img_district17));
        listDistrict.add(new District(18,"Buttes-Montmartre","Le 18e arrondissement de Paris est un des vingt arrondissements de Paris. Situé sur la rive droite de la Seine, il comprend  ...",R.drawable.img_district18));
        listDistrict.add(new District(19,"Buttes-Chaumont","Le 19e arrondissement de Paris se situe à l'extrémité nord-est de la ville. Il est bordé au nord par la commune d'Aubervilliers, à l'est par les communes de ...",R.drawable.img_district19));
        listDistrict.add(new District(20,"Ménilmontant","Le 20e arrondissement est le dernier des vingt arrondissements de Paris. Situé sur la rive droite de la Seine, il est bordé au nord par le 19e arrondissement, ...",R.drawable.img_district20));



        return listDistrict;
    }
}
