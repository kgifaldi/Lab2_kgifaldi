package com.cs60333.kgifaldi.lab2_kgifaldi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] teams = new String[]{"Ohio State", "Florida State", "Wake Forest", "Boston College", "North Carolina State", "Georgia Tech", "North Virginia", "Chicago State"};

        ArrayList<String[]> al = new ArrayList<String[]>();
        String[] temp = new String[]{"FS", "Florida State", "Feb 11"};
        String[] temp1 = new String[]{"BC", "Boston College", "Feb 14"};
        String[] temp2 = new String[]{"NCS", "North Carolina State", "Feb 18"};
        String[] temp3 = new String[]{"GT", "Georgia Tech", "Feb 26"};
        String[] temp4 = new String[]{"BC", "Boston College", "March 1"};
        String[] temp5 = new String[]{"L", "Louisville", "March 4"};
        String[] temp6 = new String[]{"T", "ACC Tournament", "March 7"};
        String[] temp7 = new String[]{"T", "NCAA Tournament", "March 16"};

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


    }
}
