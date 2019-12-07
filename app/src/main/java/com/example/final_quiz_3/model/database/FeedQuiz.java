package com.example.final_quiz_3.model.database;

import android.provider.BaseColumns;

public class FeedQuiz implements BaseColumns {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";
    public static final String THEME_TABLE_NAME = "Theme";
    public static final String THEME_COLUMN_ID = "id";
    public static final String THEME_COLUMN_THEME = "theme";
    public static final String THEME_SQL_CREATE_TABLE = "CREATE TABLE " + THEME_TABLE_NAME + " (" +
            THEME_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            THEME_COLUMN_THEME + " TEXT);";
    public static final String THEME_SQL_DROP_TABLE = "DROP TABLE " + THEME_TABLE_NAME + ";";
    public static final String QUESTION_TABLE_NAME = "Question";
    public static final String QUESTION_COLUMN_ID = "id";
    public static final String QUESTION_COLUMN_ID_THEME = "id_theme";
    public static final String QUESTION_COLUMN_QUESTION = "question";
    public static final String QUESTION_COLUMN_PROPOSITION_1 = "proposition_1";
    public static final String QUESTION_COLUMN_PROPOSITION_2 = "proposition_2";
    public static final String QUESTION_COLUMN_PROPOSITION_3 = "proposition_3";
    public static final String QUESTION_COLUMN_PROPOSITION_4 = "proposition_4";
    public static final String QUESTION_COLUMN_GOOD_ANSWER = "good_answer";
    public static final String QUESTION_COLUMN_ANECDOTE = "anecdote";
    public static final String QUESTION_SQL_CREATE_TABLE = "CREATE TABLE " + QUESTION_TABLE_NAME + " (" +
            QUESTION_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            QUESTION_COLUMN_ID_THEME + " INTEGER, " +
            QUESTION_COLUMN_QUESTION + " TEXT, " +
            QUESTION_COLUMN_PROPOSITION_1 + " TEXT, " +
            QUESTION_COLUMN_PROPOSITION_2 + " TEXT, " +
            QUESTION_COLUMN_PROPOSITION_3 + " TEXT, " +
            QUESTION_COLUMN_PROPOSITION_4 + " TEXT, " +
            QUESTION_COLUMN_GOOD_ANSWER + " INTEGER, " +
            QUESTION_COLUMN_ANECDOTE + " TEXT, " +
            "FOREIGN KEY(" + QUESTION_COLUMN_ID_THEME + ") REFERENCES " + THEME_TABLE_NAME + "(" + THEME_COLUMN_ID + "));";
    public static final String QUESTION_SQL_DROP_TABLE = "DROP TABLE " + QUESTION_TABLE_NAME + ";";
    public static final String USER_TABLE_NAME = "User";
    public static final String USER_COLUMN_ID_USER = "id";
    public static final String USER_COLUMN_NAME_FIRST_NAME = "first_name";
    public static final String USER_COLUMN_NAME_LAST_NAME = "last_name";
    public static final String USER_COLUMN_NAME_USERNAME = "username";
    public static final String USER_COLUMN_NAME_PASSWORD = "password";
    public static final String USER_SQL_CREATE_TABLE = "CREATE TABLE " + USER_TABLE_NAME + " (" +
            USER_COLUMN_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            USER_COLUMN_NAME_FIRST_NAME + " TEXT, " +
            USER_COLUMN_NAME_LAST_NAME + " TEXT, " +
            USER_COLUMN_NAME_USERNAME + " TEXT, " +
            USER_COLUMN_NAME_PASSWORD + " TEXT);";
    public static final String USER_SQL_DROP_TABLE = "DROP TABLE " + USER_TABLE_NAME + ";";
}
