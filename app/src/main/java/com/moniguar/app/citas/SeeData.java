package com.moniguar.app.citas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SeeData extends AppCompatActivity {

    GridView gridDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_data);

        gridDate = (GridView) findViewById(R.id.gridDate);

        ArrayList<Elements> ModelElement = new ArrayList<Elements>();
        ModelElement.add(new Elements("2021-11-20 10:00", "Pepito Perez"));
        ModelElement.add(new Elements("2021-11-20 11:30", "Diego Ruiz"));
        ModelElement.add(new Elements("2021-11-20 12:00", "Laura Pelaez"));
        ModelElement.add(new Elements("2021-11-21 09:00", "Luis Ferrer"));
        ModelElement.add(new Elements("2021-11-21 11:00", "Daniela Real"));
        ModelElement.add(new Elements("2021-11-21 11:30", "Ana Fernandez"));

        AdapterElements adapter = new AdapterElements(this, ModelElement);
        gridDate.setAdapter(adapter);

        gridDate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Toast.makeText(getApplicationContext(), "Elegiste " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}