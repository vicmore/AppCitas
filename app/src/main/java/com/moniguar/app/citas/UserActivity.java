package com.moniguar.app.citas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    Button btnActualizar, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        btnActualizar = findViewById(R.id.btnActualzar);
        btnBack = findViewById(R.id.btnBackSearch);


        /*+ Para evemto actualizar */
        btnActualizar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("UserActivity", "Button actualizar pulsado");
                        Toast.makeText(UserActivity.this, "Pulsamos botón actualizar", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        /*+ Para regresar al Menú */
        btnBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(UserActivity.this,MenuActivity.class);
                        startActivity(i);
                    }
                }
        );
    }
}