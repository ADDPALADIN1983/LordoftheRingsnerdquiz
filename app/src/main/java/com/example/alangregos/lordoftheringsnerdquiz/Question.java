package com.example.alangregos.lordoftheringsnerdquiz;

public class Question {

    private int index;
    // must be either "radio", "multiple", or "text"
    private String questionStyle;
    private String questionText;
    private String correctAnswerTextOne = "";
    private String correctAnswerTextTwo = null;
    private String correctAnswerTextThree = null;
    private String answer1;
    private boolean answer1Correct;
    private String answer2;
    private boolean answer2Correct;
    private String answer3;
    private boolean answer3Correct;
    private String answer4;
    private boolean answer4Correct;
    private String answer5;
    private boolean answer5Correct;
    private String answer6;
    private boolean answer6Correct;
    private int image;

    //constructor for radio button questions that only have 1 correct answer.
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

    // constructor for check boxes style questions.
    public Question(int questionNumber, String questionType, String question, String text1, boolean textOneCorrect, String text2, boolean textTwoCorrect,
                    String text3, boolean textThreeCorrect, String text4, boolean textFourCorrect, String text5, boolean textFiveCorrect, String text6,
                    boolean textSixCorrect, int imageToDisplay) {
        this.index = questionNumber;
        this.questionStyle = questionType;
        this.questionText = question;
        this.answer1 = text1;
        this.answer1Correct = textOneCorrect;
        this.answer2 = text2;
        this.answer2Correct = textTwoCorrect;
        this.answer3 = text3;
        this.answer3Correct = textThreeCorrect;
        this.answer4 = text4;
        this.answer4Correct = textFourCorrect;
        this.answer5 = text5;
        this.answer5Correct = textFiveCorrect;
        this.answer6 = text6;
        this.answer6Correct = textSixCorrect;
        this.image = imageToDisplay;

    }

    //Constructor for fill in the blank style questions
    public Question(int questionNumber, String questionType, String question, String correctAnswer, int imageToDisplay) {
        this.index = questionNumber;
        this.questionStyle = questionType;
        this.questionText = question;
        this.correctAnswerTextOne = correctAnswer;
        this.image = imageToDisplay;
    }


    public String getQuestionStyle() {
        return questionStyle;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public String getAnswer6() {
        return answer6;
    }


    public int getImage() {
        return image;
    }


    //validates multiple choice and text box answers
    public int checkAnswer(String submitted) {
        int numberCorrect = 0;
        if (correctAnswerTextOne != null && correctAnswerTextOne.trim().equalsIgnoreCase(submitted.trim())) {
            numberCorrect++;
        }
        if (correctAnswerTextTwo != null && correctAnswerTextTwo.trim().equalsIgnoreCase(submitted.trim())) {
            numberCorrect++;
        }
        if (correctAnswerTextThree != null && correctAnswerTextThree.trim().equalsIgnoreCase(submitted.trim())) {
            numberCorrect++;
        }
        return numberCorrect;
    }

    //validates check box answers
    public int checkAnswer(boolean boxOne, boolean boxTwo, boolean boxThree, boolean boxFour, boolean boxFive, boolean boxSix) {
        int numberCorrect = 0;
        if (boxOne == answer1Correct) {
            numberCorrect++;
        }
        if (boxTwo == answer2Correct) {
            numberCorrect++;
        }

        if (boxThree == answer3Correct) {
            numberCorrect++;
        }
        if (boxFour == answer4Correct) {
            numberCorrect++;
        }
        if (boxFive == answer5Correct) {
            numberCorrect++;
        }
        if (boxSix == answer6Correct) {
            numberCorrect++;
        }
        return numberCorrect;

    }

}
