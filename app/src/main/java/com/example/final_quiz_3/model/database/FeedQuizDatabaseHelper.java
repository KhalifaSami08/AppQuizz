package com.example.final_quiz_3.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FeedQuizDatabaseHelper extends SQLiteOpenHelper {

    public FeedQuizDatabaseHelper(Context context) {
        super(context, FeedQuiz.DATABASE_NAME, null, FeedQuiz.DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("MY_LOG", "Création de la base de données");
        db.execSQL(FeedQuiz.THEME_SQL_CREATE_TABLE);
        db.execSQL(FeedQuiz.QUESTION_SQL_CREATE_TABLE);
        db.execSQL(FeedQuiz.USER_SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("MY_LOG", "Mise à jour de la base de données (DROP)");
        db.execSQL(FeedQuiz.THEME_SQL_DROP_TABLE);
        db.execSQL(FeedQuiz.QUESTION_SQL_DROP_TABLE);
        db.execSQL(FeedQuiz.USER_SQL_DROP_TABLE);
        onCreate(db);
    }
}
