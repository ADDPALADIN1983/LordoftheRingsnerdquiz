package com.example.alangregos.lordoftheringsnerdquiz;

public class Question {

    String questionText;
    int numberOfCorrectAnswers;
    String correctAnswerTextOne;
    String correctAnswerTextTwo;
    String correctAnswerTextThree;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;
    String answer6;
    int image;

    //constructor for questions that only have 1 correct answer.
    public Question(String question, String correct, String text1, String text2, String text3, String text4,
                    String text5, String text6, int imageToDisplay) {
        this.questionText = question;
        this.correctAnswerTextOne = correct;
        this.answer1 = text1;
        this.answer2 = text2;
        this.answer3 = text3;
        this.answer4 = text4;
        this.answer5 = text5;
        this.answer6 = text6;
        this.image = imageToDisplay;

    }

    // constructor for check boxes that supports up to 3 correct answers.
    public Question(String question, String correct, String correctAlso, String correctToo, String text1, String text2, String text3, String text4,
                    String text5, String text6, int imageToDisplay) {
        this.questionText = question;
        this.correctAnswerTextOne = correctAlso;
        this.correctAnswerTextTwo = correctToo;
        this.correctAnswerTextThree = correct;
        this.answer1 = text1;
        this.answer2 = text2;
        this.answer3 = text3;
        this.answer4 = text4;
        this.answer5 = text5;
        this.answer6 = text6;
        this.image = imageToDisplay;

    }

    public Question(String question, String correctAnswer, int imageToDisplay) {
        this.questionText = question;
        this.correctAnswerTextOne = correctAnswer;
        this.image = imageToDisplay;
    }


}
