package edu.itm.aiforhrrecruit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

import edu.itm.aiforhrrecruit.Adapters.SingleTextAdapter;
import edu.itm.aiforhrrecruit.FirebaseExtra.FirebaseInit;
import edu.itm.aiforhrrecruit.R;
import edu.itm.aiforhrrecruit.model.ProfileModel;
import edu.itm.aiforhrrecruit.model.predictModel;

public class ResultsActivity extends AppCompatActivity {

    ListView cityListView;
    TextView textView;
    String tempTuid,tempUserId;



    private Spinner spinner1,spinner2;
    ArrayAdapter<String> dataAdapter,dataAdapter2;

    private List<predictModel> predictModels = new ArrayList<>();
    private List<ProfileModel> profileModelList = new ArrayList<>();
    List<String> PositionList = new ArrayList<String>();
    private SingleTextAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        textView = (TextView) findViewById(R.id.itmbs);
        cityListView = (ListView) findViewById(R.id.listViewAndroid);

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, PositionList);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        adapter = new SingleTextAdapter(this, predictModels);
        cityListView.setAdapter(adapter);


        getDatabase();

    }



    public void onClickShow(View view){

        adapter.notifyDataSetChanged();
    }

    public void getDatabase(){
        FirebaseInit.getDatabase().getReference().child("predictList").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                try{
                    predictModel tree = dataSnapshot.getValue(predictModel.class);
                    adapter.add(tree);

                }catch (Exception e){

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



        FirebaseInit.getDatabase().getReference().child("mrfs").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                try{
                    ProfileModel profileModel = dataSnapshot.getValue(ProfileModel.class);
                    profileModelList.add(profileModel);
                    dataAdapter2.add(profileModel.getProfile());
                    spinner2.setAdapter(dataAdapter2);
                }catch (Exception e){

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
