package com.moniguar.app.citas;

import static android.R.layout.simple_list_item_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FindDate extends AppCompatActivity {

    private ListView listview;
    private ArrayList<String> strDates;
    Button btnSearch, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_date);

        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        listview = (ListView) findViewById(R.id.listDates);

                        strDates = new ArrayList<String>();

                        strDates.add("2021-10-03 10:00");
                        strDates.add("2021-10-03 10:30");
                        strDates.add("2021-10-03 10:45");
                        strDates.add("2021-10-03 11:00");
                        strDates.add("2021-10-03 11:15");

                        ArrayAdapter<String> adapter;
                        adapter = new ArrayAdapter<String>(FindDate.this, simple_list_item_1, strDates);

                        listview.setAdapter(adapter);
                    }
                }
        );

        btnBack = findViewById(R.id.btnBackSearch);
        btnBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(FindDate.this,MenuActivity.class);
                        startActivity(i);
                    }
                }
        );
    }
}