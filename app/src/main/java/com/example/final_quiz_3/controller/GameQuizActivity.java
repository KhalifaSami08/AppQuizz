package com.example.final_quiz_3.controller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_quiz_3.model.Question;
import com.example.final_quiz_3.model.Theme;
import com.example.final_quiz_3.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameQuizActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTextView;
    private Button[] buttons;

    private int points;
    private int currentQuestion;

    public static Theme theme;
    public static List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_quiz);

        questionTextView = findViewById(R.id.question);

        buttons = new Button[]{
                findViewById(R.id.b1),
                findViewById(R.id.b2),
                findViewById(R.id.b3),
                findViewById(R.id.b4)
        };

        for (Button button : buttons) {
            button.setOnClickListener(this);
        }

        points = 0;
        currentQuestion = 0;
        displayQuestion();
    }

    private void displayQuestion() {
        Question question = questions.get(currentQuestion);
        questionTextView.setText(question.getQuestion());

        String[] propositions = shuffle(question.getPropositions());
        for (int i = 0; i < propositions.length; i++) {
            buttons[i].setText(propositions[i]);
        }
    }

    @Override
    public void onClick(View v) {
        String proposition = ((Button) v).getText().toString();
        Question question = questions.get(currentQuestion);
        String goodAnswer = question.getGoodAnswer();

        if (proposition.equals(goodAnswer)) {
            points++;
            Toast.makeText(this, "Bonne réponse...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect...", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "La bonne réponse était " + goodAnswer, Toast.LENGTH_LONG).show();
        }
        showAnecdote();

        Log.d("MY_LOG", "c" + currentQuestion + "/" + questions.size());
        if (++currentQuestion < questions.size()) {
            displayQuestion();
        } else {
            endGame();
        }
    }

    private void showAnecdote() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Anecdote")
                .setMessage(questions.get(currentQuestion).getAnecdote())
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();

    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fin !")
                .setMessage("Ton score est de : " + points+" / "+questions.size())
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                })
                .create()
                .show();

        /*
            int channelid = 1;
            NotificationCompat.Builder build = new NotificationCompat.Builder(this, "1")
                    .setContentTitle("Fin !")
                    .setContentText("Ton score est de : " + points)
                    .setPriority(NotificationCompat.PRIORITY_HIGH);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(channelid,build.build());
        */
    }

    private static String[] shuffle(String[] array) {
        List<String> list = Arrays.asList(array);
        Collections.shuffle(list);
        return (String[]) list.toArray();
    }
}
