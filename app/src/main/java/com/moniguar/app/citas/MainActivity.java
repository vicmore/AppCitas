package com.moniguar.app.citas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail, txtPassword;
    Button btnIngreso, btnRegistro;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIngreso = findViewById(R.id.button2);
        btnRegistro = findViewById(R.id.button);
        txtEmail = findViewById(R.id.editTextTextPersonName4);
        txtPassword = findViewById(R.id.editTextTextPersonName5);

        /* Para ir a la vista de Menú, habiéndose Logueado */
        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eMail = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                ingresarLogin(eMail, password);
            }
        });

        /* Para ir a la vista de Registro o actualización */
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void ingresarLogin(String eMail, String password) {
        auth.signInWithEmailAndPassword(eMail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}