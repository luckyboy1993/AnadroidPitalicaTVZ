package com.example.pitalicatvzandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucian on 2/12/2018.
 */

public class Question {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("examId")
    @Expose
    private int examId;
    @SerializedName("exam")
    @Expose
    private Exam exam;
    @SerializedName("questionText")
    @Expose
    private int questionText;
    @SerializedName("correctAnswer")
    @Expose
    private int correctAnswer;
    @SerializedName("wrongAnswers")
    @Expose
    private int wrongAnswers;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("row")
    @Expose
    private int row;
    @SerializedName("definition")
    @Expose
    private String definition;
    @SerializedName("visibility")
    @Expose
    private boolean visibility;

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getQuestionText() {
        return questionText;
    }

    public void setQuestionText(int questionText) {
        this.questionText = questionText;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }


}
