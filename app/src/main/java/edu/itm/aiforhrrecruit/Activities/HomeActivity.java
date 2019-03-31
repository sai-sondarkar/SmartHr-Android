package edu.itm.aiforhrrecruit.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.itm.aiforhrrecruit.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void onClickMrf (View view){

        Intent intent = new Intent(getApplicationContext(),MRFActivity.class);
        startActivity(intent);
    }

    public void onClickPanel (View view){

        Intent intent = new Intent(getApplicationContext(),InterviewerActivity.class);
        startActivity(intent);

    }

    public void onClickResults (View view){

        Intent intent = new Intent(getApplicationContext(),ResultsActivity.class);
        startActivity(intent);
    }

    public void onClickCandidateDataUpload(View view){

    }

}
