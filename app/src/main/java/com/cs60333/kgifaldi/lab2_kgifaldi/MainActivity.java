package com.cs60333.kgifaldi.lab2_kgifaldi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Context;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Team> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyCsvFileReader cr = new MyCsvFileReader(this.getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Team teams = new String[]{"Ohio State", "Florida State", "Wake Forest", "Boston College", "North Carolina State", "Georgia Tech", "North Virginia", "Chicago State"};
/*
        Team temp = new Team("fs", "Florida State", "Feb 11", "Osceola and Renegade", "(5-20)", "55-99");
        Team temp1 = new Team("bc", "Boston College", "Feb 14", "The Eagles", "(19-9)", "76 - 84");
        Team temp2 = new Team("ncs", "North Carolina State", "Feb 18", "Rameses", "(5-24)", "59 - 69");
        Team temp3 = new Team("gt", "Georgia Tech", "Feb 26", "The Buzz", "(15-15)", "77 - 85");
        Team temp4 = new Team("bc", "Boston College", "March 1", "The Eagles", "(19-9)", "TBD");
        Team temp5 = new Team("l", "Louisville", "March 4", "Cardinal Bird", "(15-20)", "TBD");
        Team temp6 = new Team("t", "ACC Tournament", "March 7", "ACC", "(NA-NA)", "TBD");
        Team temp7 = new Team("t", "NCAA Tournament", "March 16", "NCAA", "(NA-NA)", "TBD");
*/
        al = cr.readCsvFile(R.raw.schedule);
/*
        al.add(temp);
        al.add(temp1);
        al.add(temp2);
        al.add(temp3);
        al.add(temp4);
        al.add(temp5);
        al.add(temp6);
        al.add(temp7);
*/

        ScheduleAdapter<ArrayList<Team>> scheduleAdapter = new ScheduleAdapter<ArrayList<Team>>(this, android.R.layout.simple_list_item_1, al);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);



        scheduleListView.setAdapter(scheduleAdapter);



        final AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView parent, View view, int position, long id) {

//Write code here to open the activity that will show details of the game event,i.e. if //you click on Florida State, you should see details of the match between Florida State //and Notre Dame. You need to do the following three steps.

//create the intent to start DetailActivity

                Intent gameIntent = new Intent(getApplicationContext(), DetailActivity.class);
//create a bundle object using the following:

                gameIntent.putExtra("team", al.get(position)); //where al is your ArrayList holding team information.

//start the activity using the intent with the bundle you just created.

                startActivity(gameIntent);
                //finish();

            }

        };

// this will automatically attach the listener to each item of the listview.

        scheduleListView.setOnItemClickListener (clickListener);


    }
}
