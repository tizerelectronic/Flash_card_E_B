package com.example.emflashcard;

public class QuestionModal {
    private String question;
    private String reponsv;
    private String reponsf1;
    private String reponsf2;
    private int id;

    // creating getter and setter methods

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponsv() {
        return reponsv;
    }

    public void setReponsv(String reponsv) {
        this.reponsv = reponsv;
    }

    public String getReponsf1() {
        return reponsf1;
    }

    public void setReponsf1(String reponsf1) {
        this.reponsf1 = reponsf1;
    }

    public String getReponsf2() {
        return reponsf2;
    }

    public void setReponsf2(String reponsf2) {
        this.reponsf2 = reponsf2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //  Creating Constructor
    public QuestionModal(String question, String reponsv, String reponsf1, String reponsf2) {
        this.question = question;
        this.reponsv = reponsv;
        this.reponsf1 = reponsf1;
        this.reponsf2 = reponsf2;

    }
}

