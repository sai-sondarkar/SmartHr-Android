package edu.itm.aiforhrrecruit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

import edu.itm.aiforhrrecruit.FirebaseExtra.FirebaseInit;
import edu.itm.aiforhrrecruit.R;
import edu.itm.aiforhrrecruit.model.CompetencyModel;
import edu.itm.aiforhrrecruit.model.ProfileModel;
import edu.itm.aiforhrrecruit.model.TeamLeadModel;

public class MRFActivity extends AppCompatActivity {

    List<TeamLeadModel> teamLeadModelList = new ArrayList<TeamLeadModel>();;
    List<CompetencyModel> competencyModelList = new ArrayList<CompetencyModel>();
    List<String> NameList = new ArrayList<String>();
    private Spinner spinner1;
    ArrayAdapter<String> dataAdapter;

    TextView question,comp1,comp2,comp3,comp4;
    boolean comp1_b,comp2_b,comp3_b,comp4_b;

    EditText ed1,ed2;

    int counter=0;
    Button button;

    int max =0 ;
    boolean isFirst = true;

    CompetencyModel model;

    String competency ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrf);

        comp1_b = true;
        comp2_b = true;
        comp3_b = true;
        comp4_b = true;


        initUi();




    }

    public void initUi(){

        spinner1 = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.next);

        ed1 = (EditText) findViewById(R.id.role);
        ed2 = (EditText) findViewById(R.id.applicationNumber_li);
        dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, NameList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        question = (TextView) findViewById(R.id.quest);
        comp1 = (TextView) findViewById(R.id.comp1);
        comp2 = (TextView) findViewById(R.id.comp2);
        comp3 = (TextView) findViewById(R.id.comp3);
        comp4 = (TextView) findViewById(R.id.comp4);

        getDataBase();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(comp1_b){
                    competency = competency + " " + comp1.getText().toString();
                }

                if(comp2_b){
                    competency = competency + " " + comp2.getText().toString();
                }

                if(comp3_b){
                    competency = competency + " " + comp3.getText().toString();
                }

                if(comp4_b){
                    competency = competency + " " + comp4.getText().toString();
                }

                if(counter<competencyModelList.size()-1){
                    counter++;
                    compMapping();
                }else{

                    ProfileModel profileModel = new ProfileModel();

                    profileModel.setProfile(ed1.getText().toString());
                    profileModel.setSrno(ed2.getText().toString());
                    profileModel.setProfile_competencies(competency);
                    int pos = NameList.indexOf(String.valueOf(spinner1.getSelectedItem()));
                    profileModel.setTeaml_competencies(teamLeadModelList.get(pos).getCompetencyList());

                    FirebaseInit.getDatabase().getReference().child("mrfs").push().setValue(profileModel);

                    Toast.makeText(getApplicationContext(),"We have successfully created the MRF in System",Toast.LENGTH_SHORT).show();

                    finish();
                }

            }
        });

        comp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comp1_b){
                    comp1_b = false;
                    comp1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.blue));
                }else{
                    comp1_b = true;
                    comp1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                }
            }
        });

        comp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comp2_b){
                    comp2_b = false;
                    comp2.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.blue));
                }else{
                    comp2_b = true;
                    comp2.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                }
            }
        });

        comp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comp3_b){
                    comp3_b = false;
                    comp3.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.blue));
                }else{
                    comp3_b = true;
                    comp3.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                }
            }
        });
        comp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comp4_b){
                    comp4_b = false;
                    comp4.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.blue));
                }else{
                    comp4_b = true;
                    comp4.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                }
            }
        });


    }





    public void compMapping(){



        comp1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
        comp2.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
        comp3.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
        comp4.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));


        comp1.setVisibility(View.GONE);
        comp2.setVisibility(View.GONE);
        comp3.setVisibility(View.GONE);
        comp4.setVisibility(View.GONE);


            model = competencyModelList.get(counter);
            question.setText(model.getCompetencyName());

            for(int i =0; i<model.getCompetencyLevel().size();i++){
                if(i == 0 ){
                    comp1.setVisibility(View.VISIBLE);
                    comp1.setText(model.getCompetencyLevel().get(i));
                }else if(i == 1){
                    comp2.setVisibility(View.VISIBLE);
                    comp2.setText(model.getCompetencyLevel().get(i));
                }else if(i == 2){
                    comp3.setVisibility(View.VISIBLE);
                    comp3.setText(model.getCompetencyLevel().get(i));
                }else if(i == 3){
                    comp4.setVisibility(View.VISIBLE);
                    comp4.setText(model.getCompetencyLevel().get(i));
                }
            }



        comp1_b = false;
        comp2_b = false;
        comp3_b = false;
        comp4_b = false;


    }





    public void getDataBase(){

        FirebaseInit.getDatabase().getReference().child("employeesCompetencies").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                    try{

                        TeamLeadModel teamLeadModel = dataSnapshot.getValue(TeamLeadModel.class);
                        teamLeadModel.setKey(dataSnapshot.getKey());
                        teamLeadModelList.add(teamLeadModel);
                        dataAdapter.add(teamLeadModel.getName());
                        spinner1.setAdapter(dataAdapter);
                        Toast.makeText(getApplicationContext(),"in DB Retrive",Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Error in DB Retrive " + e,Toast.LENGTH_SHORT).show();
                        Log.d("Error parsing",""+e);
                    }



            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        FirebaseInit.getDatabase().getReference().child("competencyMapping").child("salesRole").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(max<5) {
                    max++;

                    try {
                        CompetencyModel competencyModel = dataSnapshot.getValue(CompetencyModel.class);
                        competencyModelList.add(competencyModel);

                        if (isFirst) {
                            compMapping();
                        }


                    } catch (Exception e) {

                    }

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




}
