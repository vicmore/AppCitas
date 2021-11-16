package com.moniguar.app.citas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    ImageButton imgMenuUser, imgFindDate, imgSeeDate, imgBtnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /* Me permite ir a la ventana de Actualización */
        imgMenuUser = findViewById(R.id.imageButton5);
        imgMenuUser.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MenuActivity.this,UserActivity.class);
                        startActivity(i);
                    }
                }
        );

        /* Va a la vista de buscar Cita */
        imgFindDate=findViewById(R.id.imgFindDate);
        imgFindDate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MenuActivity.this,FindDate.class);
                        startActivity(i);
                    }
                }
        );

        imgBtnExit=findViewById(R.id.imgBtnExit);
        imgBtnExit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_MAIN);
                        finish();

                    }
                }
        );
        imgSeeDate=findViewById(R.id.imgSeeDate);
        imgSeeDate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MenuActivity.this,SeeData.class);
                        startActivity(i);

                    }
                }
        );
    }
}