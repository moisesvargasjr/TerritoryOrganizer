package com.example.territoryorganizer;

/*The main activity is never really seen by the user. It immediately calls the
* MainMenu activity when launched. It used to also create and open the database before I had
* Implemented the room abstratction */

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = openOrCreateDatabase("Territories",MODE_PRIVATE,null);
//        Scanner scan = new Scanner(getResources().openRawResource(R.raw.territories));
//        String query ="";
//        while(scan.hasNextLine())
//        {
//            // build and execute queries
//            query += scan.nextLine() +"\n";
//            if (query.trim().endsWith(";"))
//            {
//                db.execSQL(query);
//                query ="";
//            }
//        }

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);

    }






}
