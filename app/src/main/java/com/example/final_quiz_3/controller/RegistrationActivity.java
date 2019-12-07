package com.example.final_quiz_3.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.final_quiz_3.R;
import com.example.final_quiz_3.application.MyApplication;
import com.example.final_quiz_3.model.User;

public class RegistrationActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstNameEditText = findViewById(R.id.first_name);
        lastNameEditText = findViewById(R.id.last_name);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
    }

    public void create(View view) {
        User user = new User(
                firstNameEditText.getText().toString(),
                lastNameEditText.getText().toString(),
                usernameEditText.getText().toString(),
                passwordEditText.getText().toString()
        );

        boolean created = MyApplication.getDatabaseAdapter().addUser(user);
        if (created) {
            Log.d("MY_TAG", "Création utilisateur réussie");
            Toast.makeText(getApplicationContext(),"Inscrition Reiussie ! ",Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Log.d("MY_TAG", "Création utilisateur échouée");
            Toast.makeText(getApplicationContext(),"Isciption échouée !",Toast.LENGTH_LONG).show();
        }
    }

    public void quit(View view) {
        finish();
    }
}
