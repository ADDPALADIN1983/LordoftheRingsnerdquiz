package com.example.alangregos.lordoftheringsnerdquiz;

public class Question {

    int index;
    String questionStyle;
    String questionText;
    String correctAnswerTextOne = "";
    String correctAnswerTextTwo = "";
    String correctAnswerTextThree = "";
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;
    String answer6;
    int image;

    //constructor for questions that only have 1 correct answer.
    public Question(int questionNumber, String questionType, String question, String correct, String text1, String text2, String text3, String text4,
                    String text5, String text6, int imageToDisplay) {
        this.index = questionNumber;
        this.questionStyle = questionType;
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
    public Question(int questionNumber, String questionType, String question, String correct, String correctAlso, String correctToo, String text1, String text2, String text3, String text4,
                    String text5, String text6, int imageToDisplay) {
        this.index = questionNumber;
        this.questionStyle = questionType;
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

    public Question(int questionNumber, String questionType, String question, String correctAnswer, int imageToDisplay) {
        this.index = questionNumber;
        this.questionStyle = questionType;
        this.questionText = question;
        this.correctAnswerTextOne = correctAnswer;
        this.image = imageToDisplay;
    }

    public int checkAnswer(String submitted, String correct1, String correct2, String correct3) {
        int numberCorrect = 0;
        if (correct1.trim().equalsIgnoreCase(submitted.trim())) {
            numberCorrect++;
        }
        if (correct2.trim().equalsIgnoreCase(submitted.trim())) {
            numberCorrect++;
        }
        if (correct3.trim().equalsIgnoreCase(submitted.trim())) {
            numberCorrect++;
        }
        return numberCorrect;
    }

    public int getIndex() {
        return index;
    }

    public String getQuestionStyle() {
        return questionStyle;
    }
}
