package com.example.littledaffy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    private EditText nombres;
    private EditText apellidos;
    private EditText correo;
    private EditText contraseña;
    private Button registrar;



    //Variable de datos a registrar

    private String name = "";
    private String ape = "";
    private String email = "";
    private String pass = "";
    private String tipo = "";
    String id;

    FirebaseAuth mAuth;
    DatabaseReference mDatabse;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
        mDatabse = FirebaseDatabase.getInstance().getReference();


        nombres = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellido);
        correo =  findViewById(R.id.correo);
        contraseña =  findViewById(R.id.contra);
        registrar = findViewById(R.id.registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = nombres.getText().toString();
                ape = apellidos.getText().toString();
                email = correo.getText().toString();
                pass = contraseña.getText().toString();

                if (!name.isEmpty() && !ape.isEmpty() && !email.isEmpty() && !pass.isEmpty()){
                    if (pass.length()>=6){
                        registrarU();
                    }



                }


            }
        });
    }
    private void registrarU(){
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    String name1 = nombres.getText().toString();
                    String ape1 = apellidos.getText().toString();
                    String email1 = correo.getText().toString();
                    String pass1 = contraseña.getText().toString();
                    id = mAuth.getCurrentUser().getUid();
                    int tipou = 1;
                    String idu= id;
                    RegisterHelper registerHelper = new RegisterHelper(name1,ape1,email1,pass1,idu,tipou);



                    mDatabse.child("usuarios").child(id).setValue(registerHelper).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                startActivity(new Intent(RegistroActivity.this,OrganizacionActivity.class));
                                finish();
                            }
                            else {
                                Toast.makeText(RegistroActivity.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}