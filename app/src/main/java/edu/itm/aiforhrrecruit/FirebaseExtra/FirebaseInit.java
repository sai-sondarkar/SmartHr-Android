package edu.itm.aiforhrrecruit.FirebaseExtra;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by saiso on 07-04-2018.
 */

public class FirebaseInit {
    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }


}
