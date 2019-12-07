package com.example.final_quiz_3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {
    private int id;
    private Theme theme;
    private String question;
    private String[] propositions;
    private int indexGoodAnswer;
    private String goodAnswer;
    private String anecdote;

    public Question(Theme theme, String question, String[] propositions, int indexGoodAnswer, String anecdote) {
        this.theme = theme;
        this.question = question;
        this.indexGoodAnswer = indexGoodAnswer;
        this.goodAnswer = propositions[indexGoodAnswer];
        this.propositions = propositions;
        this.anecdote = anecdote;
    }

    public Question(int id, Theme theme, String question, String[] propositions, int indexGoodAnswer, String anecdote) {
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.indexGoodAnswer = indexGoodAnswer;
        this.goodAnswer = propositions[indexGoodAnswer];
        this.propositions = propositions;
        this.anecdote = anecdote;
    }

    protected Question(Parcel in) {
        id = in.readInt();
        theme = in.readParcelable(Theme.class.getClassLoader());
        question = in.readString();
        propositions = in.createStringArray();
        indexGoodAnswer = in.readInt();
        goodAnswer = in.readString();
        anecdote = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeParcelable(theme, flags);
        dest.writeString(question);
        dest.writeStringArray(propositions);
        dest.writeInt(indexGoodAnswer);
        dest.writeString(goodAnswer);
        dest.writeString(anecdote);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public int getId() {
        return id;
    }

    public Theme getTheme() {
        return theme;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getPropositions() {
        return propositions;
    }

    public int getIndexGoodAnswer() {
        return indexGoodAnswer;
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }

    public String getAnecdote() {
        return anecdote;
    }

    public static Creator<Question> getCREATOR() {
        return CREATOR;
    }
}
