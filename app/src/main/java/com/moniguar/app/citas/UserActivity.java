package com.moniguar.app.citas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class UserActivity extends AppCompatActivity {

    Button btnActualizar, btnBack;
    private EditText txtNombres, txtIdentificacion, txtDireccion, txtCiudad, txtCelular, txtFijo, txtEmail, txtLogin, txtPassword;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        btnActualizar = findViewById(R.id.btnActualzar);
        btnBack = findViewById(R.id.btnBackSearch);

        txtNombres = findViewById(R.id.txtNombres);
        txtIdentificacion = findViewById(R.id.txtIdentificacion);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtCiudad = findViewById(R.id.txtCiudad);
        txtCelular = findViewById(R.id.txtCelular);
        txtFijo = findViewById(R.id.txtFijo);
        txtEmail = findViewById(R.id.txtEmail);
        txtLogin = findViewById(R.id.txtLogin);
        txtPassword = findViewById(R.id.editTextTextPassword);

        /*+ Para evemto actualizar */
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UserActivity", "Botón actualizar pulsado");
                Toast.makeText(UserActivity.this, "Pulsamos botón actualizar", Toast.LENGTH_SHORT).show();
                registrar();
            }
        });

        /*+ Para regresar al Menú */
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this,MenuActivity.class);
                startActivity(i);
            }
        });
    }

    private void registrar() {
        Map<String, Object> usuario = new HashMap<>();
        usuario.put("nombres", txtNombres.getText().toString());
        usuario.put("numeroIdentificacion", txtIdentificacion.getText().toString());
        usuario.put("direccion", txtDireccion.getText().toString());
        usuario.put("ciudad", txtCiudad.getText().toString());
        usuario.put("celular", txtCelular.getText().toString());
        usuario.put("fijo", txtFijo.getText().toString());
        usuario.put("eMail", txtEmail.getText().toString());
        usuario.put("login", txtLogin.getText().toString());
        usuario.put("password", txtPassword.getText().toString());

        firestore.collection("Usuario").document(txtIdentificacion.getText().toString()).set(usuario);
        registrarLogin(txtLogin.getText().toString(), txtPassword.getText().toString());
    }

    public void registrarLogin(String eMail, String password) {
        auth.createUserWithEmailAndPassword(eMail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = auth.getCurrentUser().getUid();
                    Map<String, Object> datos = new HashMap<>();
                    datos.put("eMail", eMail);
                    datos.put("password", password);
                    firestore.collection("Usuarios").document(id).set(datos).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                Toast.makeText(UserActivity.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(UserActivity.this, "Error en el Registro!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}