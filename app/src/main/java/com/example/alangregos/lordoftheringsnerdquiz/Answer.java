package com.example.alangregos.lordoftheringsnerdquiz;

public class Answer {

    private String answerText;
    private boolean isCorrect;

    public Answer(String text, boolean right) {
        this.answerText = text;
        this.isCorrect = right;
    }

    public void setIsCorrect(boolean right){
        isCorrect = right;
    }

    public boolean checkIsCorrect(){
        return isCorrect;
    }

    public void setAnswerText(String text){
        answerText = text;
    }

    public String getAnswerText(){
        return answerText;
    }
}
