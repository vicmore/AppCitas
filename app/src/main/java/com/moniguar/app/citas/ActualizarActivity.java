package com.moniguar.app.citas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ActualizarActivity extends AppCompatActivity {

    Button btnActualizar, btnBack;
    EditText txtNombres, txtIdentificacion, txtDireccion, txtCiudad, txtCelular, txtFijo, txtEmail, txtContacto, txtCelContacto, txtLogin, txtPassword, txtNombre;

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        FirebaseUser user = auth.getCurrentUser();
        btnActualizar = findViewById(R.id.btnActualzar);
        btnBack = findViewById(R.id.btnBackSearch);
        txtNombres = findViewById(R.id.txtNombres);
        txtIdentificacion = findViewById(R.id.txtIdentificacion);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtCiudad = findViewById(R.id.txtCiudad);
        txtCelular = findViewById(R.id.txtCelular);
        txtFijo = findViewById(R.id.txtFijo);
        txtEmail = findViewById(R.id.txtEmail);
        txtContacto = findViewById(R.id.txtContacto);
        txtCelContacto = findViewById(R.id.txtCelContacto);
        txtLogin = findViewById(R.id.txtLogin);
        txtPassword = findViewById(R.id.editTextTextPassword);
        txtNombre = findViewById(R.id.textView5);

        //txtNombre.setText(user.getProviderId());

        /*+ Para evento actualizar */
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UserActivity", "Botón actualizar pulsado");
                Toast.makeText(ActualizarActivity.this, "Pulsamos botón actualizar", Toast.LENGTH_SHORT).show();
                registrar();
            }
        });

        /*+ Para regresar al Menú */
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActualizarActivity.this, MenuActivity.class);
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
        usuario.put("contacto", txtContacto.getText().toString());
        usuario.put("celContacto", txtCelContacto.getText().toString());
        usuario.put("login", txtLogin.getText().toString());
        usuario.put("password", txtPassword.getText().toString());

        firestore.collection("Usuario").document(txtIdentificacion.getText().toString()).update(usuario);
    }
}