package com.cs60333.kgifaldi.lab2_kgifaldi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String[]> al = new ArrayList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] teams = new String[]{"Ohio State", "Florida State", "Wake Forest", "Boston College", "North Carolina State", "Georgia Tech", "North Virginia", "Chicago State"};

        String[] temp = new String[]{"fs", "Florida State", "Feb 11", "Osceola and Renegade", "(5-20)", "55-99"};
        String[] temp1 = new String[]{"bc", "Boston College", "Feb 14", "The Eagles", "(19-9)", "76 - 84"};
        String[] temp2 = new String[]{"ncs", "North Carolina State", "Feb 18", "Rameses", "(5-24)", "59 - 69"};
        String[] temp3 = new String[]{"gt", "Georgia Tech", "Feb 26", "The Buzz", "(15-15)", "77 - 85"};
        String[] temp4 = new String[]{"bc", "Boston College", "March 1", "The Eagles", "(19-9)", "TBD"};
        String[] temp5 = new String[]{"l", "Louisville", "March 4", "Cardinal Bird", "(15-20)", "TBD"};
        String[] temp6 = new String[]{"t", "ACC Tournament", "March 7", "ACC", "(NA-NA)", "TBD"};
        String[] temp7 = new String[]{"t", "NCAA Tournament", "March 16", "NCAA", "(NA-NA)", "TBD"};




        al.add(temp);
        al.add(temp1);
        al.add(temp2);
        al.add(temp3);
        al.add(temp4);
        al.add(temp5);
        al.add(temp6);
        al.add(temp7);


        ScheduleAdapter<ArrayList<String[]>> scheduleAdapter = new ScheduleAdapter<ArrayList<String[]>>(this, android.R.layout.simple_list_item_1, al);
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
