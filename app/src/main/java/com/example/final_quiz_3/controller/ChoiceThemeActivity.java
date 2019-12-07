package com.example.final_quiz_3.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.final_quiz_3.R;
import com.example.final_quiz_3.application.MyApplication;
import com.example.final_quiz_3.model.Question;
import com.example.final_quiz_3.model.Theme;

import java.util.List;

public class ChoiceThemeActivity extends AppCompatActivity {

    private Spinner themeSpinner;
    private List<Theme> themes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_theme);

        themeSpinner = findViewById(R.id.theme_spinner);

        themes = MyApplication.getDatabaseAdapter().getThemes();

        ArrayAdapter<Theme> data = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, themes);
        data.setDropDownViewResource(android.R.layout.simple_spinner_item);
        themeSpinner.setAdapter(data);
    }

    public void onClick(View view) {

        int position = themeSpinner.getSelectedItemPosition();

        if (position != -1) {
            Theme theme = themes.get(position);
            List<Question> questions = MyApplication.getDatabaseAdapter().getQuestions(theme);

            if (questions.isEmpty()) {
                Toast.makeText(ChoiceThemeActivity.this, "Aucune quesiton n'a été trouvé !", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(ChoiceThemeActivity.this, GameQuizActivity.class);
                GameQuizActivity.theme = theme;
                GameQuizActivity.questions = questions;
                startActivity(intent);
            }
        }
    }
}
