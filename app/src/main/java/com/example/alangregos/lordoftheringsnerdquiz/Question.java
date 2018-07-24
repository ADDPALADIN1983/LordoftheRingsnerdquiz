package com.example.alangregos.lordoftheringsnerdquiz;

public class Question {

    String questionText;
    String answerText;
    Answer answer1;
    Answer answer2;
    Answer answer3;
    Answer answer4;
    Answer answer5;
    Answer answer6;
    int image;


    //Nested class for coding the answers. Moved hear because it would only ever be used in conjunction with a question and isn't very mich code.
    public class Answer {

        private String answerText;
        private boolean isCorrect;
        private String textAnswer;

        public Answer(String text, boolean right) {
            this.answerText = text;
            this.isCorrect = right;
        }

        public Answer(String text) {
            this.textAnswer = text;
        }

        public boolean checkIsCorrect() {
            return isCorrect;
        }

        public String getTextAnswer() {
            return this.textAnswer;
        }

    }


    public Question(String question, String text1, boolean correct1, String text2, boolean correct2, String text3, boolean correct3, String text4,
                    boolean correct4, String text5, boolean correct5, String text6, boolean correct6, int imageToDisplay) {
        this.questionText = question;
        this.answer1 = new Answer(text1, correct1);
        this.answer2 = new Answer(text2, correct2);
        this.answer3 = new Answer(text3, correct3);
        this.answer4 = new Answer(text4, correct4);
        this.answer5 = new Answer(text5, correct5);
        this.answer6 = new Answer(text6, correct6);
        this.image = imageToDisplay;

    }

    public Question(String question, String correctAnswer, int imageToDisplay) {
        this.questionText = question;
        this.answerText = correctAnswer;
        this.image = imageToDisplay;
    }


}
