package com.example.final_quiz_3.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.final_quiz_3.R;
import com.example.final_quiz_3.application.MyApplication;
import com.example.final_quiz_3.model.User;

public class ConnectionActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
    }

    public void connection(View view) {
        User user = new User(
                usernameEditText.getText().toString(),
                passwordEditText.getText().toString()
        );

        boolean connected = MyApplication.getDatabaseAdapter().checkUserCredentials(user);
        Log.d("MY_TAG", "Username:" + user.getUsername() + " Password: " + user.getPassword() +
                "Connection réussie: " + connected);

        if(connected) {
            Intent intent = new Intent(this, ChoiceThemeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Mauvaises informations", Toast.LENGTH_SHORT).show();
        }
    }

    public void registration(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

}
