package com.example.alangregos.lordoftheringsnerdquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    // TODO: 7/26/2018 at some point convert the questions into an array of question objects
    private Question question1 = new Question(0, "radio", "What is the name of the weapon shown in this picture?", "Anduril", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.Anduril);
    private Question question2 = new Question(1, "radio", "What is the name of the weapon shown in this picture?", "Glamdring", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.Glamdring);
    private Question question3 = new Question(2, "radio", "What is the name of the weapon shown in this picture?", "Sting", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.LOTR_Sting);
    private Question question4 = new Question(3, "radio", "What is the name of the weapon shown in this picture?", "Morgul Blade", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.Morgul_Blade);
    private Question question5 = new Question(4, "radio", "What is the name of the weapon shown in this picture", "Orcrist", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.Orcrist);
    private Question question6 = new Question(5, "multiple", "Who fought wielding this weapon?", "Bilbo", "Bilbo", "Aaragorn",
            "Gandalf", "Leglas", "Thranduil", "Frodo", R.drawable.The_Hobbit_Sting);
    private Question question7 = new Question(6, "multiple", "Who fought wielding this weapon?", "Legolas", "Thorin", null, "Bilbo", "Aragorn",
            "Gandalf", "Legolas", "Thranduil", "Thorin", R.drawable.Orcrist);
    private Question question8 = new Question(7, "multiple", "Who are descended from kings?", "Aragorn", "Legolas", "Thranduil", "Bilbo", "Aragorn",
            "Gandalf", "Legolas", "Thranduil", "Faramir", R.drawable.throne);

    private Question question9 = new Question(8, "text", "What is the name of the battering ram from Return of the King?", "Grond", R.drawable.Grond);
    private Question question10 = new Question(9, "text", "What is the name of Gandalf's horse ", "Shadowfax", R.drawable.Shadowfax);

    private Question currentQuestion;
    private int currentQuestionIndex = 0;
    private int numberOfCorrectAnswer = 0;
    private int totalNumberOfQuestions = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // question answers need to be 40 chars or less

    // TODO: 7/23/2018 script radio buttons and link to questions and answers
    // TODO: 7/23/2018 script check boxes and link to questions and answers
    // TODO: 7/23/2018script edit text and link to questions and answers
//method called when reset button is called to reset the quiz questiong to the first one in the index.
    public void resetQuiz(View view) {
        currentQuestionIndex = 0;
        updateCurrentQuestion();
        updateViews();
    }


    //method called when next button is clicked to increment the current index and then populate the next question on the screen
    public void nextQuestion(View view) {
        String submitted = "placeholder";
        if (currentQuestion.getQuestionStyle() != "text")
            numberOfCorrectAnswer += currentQuestion.checkAnswer(submitted, currentQuestion.getCorrectAnswerTextOne(), currentQuestion.getCorrectAnswerTextTwo(),
                    currentQuestion.getCorrectAnswerTextThree());
        else if (currentQuestion.getQuestionStyle() == "text") {
            numberOfCorrectAnswer += currentQuestion.checkAnswer(submitted, currentQuestion.getCorrectAnswerTextOne());
        } else
            Toast.makeText(this, "There is a problem with the execution of this program", Toast.LENGTH_SHORT).show();
        currentQuestionIndex++;
        if (currentQuestionIndex == 9) {
            String toastText = "You got " + numberOfCorrectAnswer +"/" + totalNumberOfQuestions + "correct. That's " + numberOfCorrectAnswer/totalNumberOfQuestions + "%.";
                    Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
        }
        updateViews();
    }

    // method to pull the right question object from the list of questions
    public void updateCurrentQuestion() {
        Question question = null;
        if (currentQuestionIndex == 0) {
            question = question1;
        }
        if (currentQuestionIndex == 1) {
            question = question2;
        }
        if (currentQuestionIndex == 2) {
            question = question3;
        }
        if (currentQuestionIndex == 3) {
            question = question4;
        }
        if (currentQuestionIndex == 4) {
            question = question5;
        }
        if (currentQuestionIndex == 5) {
            question = question6;
        }
        if (currentQuestionIndex == 6) {
            question = question7;
        }
        if (currentQuestionIndex == 7) {
            question = question8;
        }
        if (currentQuestionIndex == 8) {
            question = question9;
        }
        if (currentQuestionIndex == 9) {
            question = question10;
        }
        currentQuestion = question;
    }

    // method to update all of the UI elements and text for the current question
    public void updateViews() {

        String type = currentQuestion.getQuestionStyle();

        // switch to add the view needed for the current question type and remove the UI elements that are not needed for that type of question
        switch (type) {
            case "radio": {
                View smallImage = findViewById(R.id.small_image_for_question);
                smallImage.setVisibility(View.VISIBLE);
                View largeImage = findViewById(R.id.large_image_for_question);
                largeImage.setVisibility(View.GONE);
                View clickableAnswers = findViewById(R.id.clickable_answers_container);
                clickableAnswers.setVisibility(View.VISIBLE);
                View radioButtons = findViewById(R.id.radio_buttons);
                radioButtons.setVisibility(View.VISIBLE);
                View checkBoxes = findViewById(R.id.check_boxes);
                checkBoxes.setVisibility(View.GONE);
                View textAnswer = findViewById(R.id.typed_in_answer);
                textAnswer.setVisibility(View.GONE);
                break;
            }

            case "multiple": {
                View smallImage = findViewById(R.id.small_image_for_question);
                smallImage.setVisibility(View.VISIBLE);
                View largeImage = findViewById(R.id.large_image_for_question);
                largeImage.setVisibility(View.GONE);
                View clickableAnswers = findViewById(R.id.clickable_answers_container);
                clickableAnswers.setVisibility(View.VISIBLE);
                View radioButtons = findViewById(R.id.radio_buttons);
                radioButtons.setVisibility(View.GONE);
                View checkBoxes = findViewById(R.id.check_boxes);
                checkBoxes.setVisibility(View.VISIBLE);
                View textAnswer = findViewById(R.id.typed_in_answer);
                textAnswer.setVisibility(View.GONE);
                break;
            }

            case "text": {
                View smallImage = findViewById(R.id.small_image_for_question);
                smallImage.setVisibility(View.GONE);
                View largeImage = findViewById(R.id.large_image_for_question);
                largeImage.setVisibility(View.VISIBLE);
                View clickableAnswers = findViewById(R.id.clickable_answers_container);
                clickableAnswers.setVisibility(View.GONE);
                View radioButtons = findViewById(R.id.radio_buttons);
                radioButtons.setVisibility(View.GONE);
                View checkBoxes = findViewById(R.id.check_boxes);
                checkBoxes.setVisibility(View.GONE);
                View textAnswer = findViewById(R.id.typed_in_answer);
                textAnswer.setVisibility(View.VISIBLE);
                break;
            }

        }
        if (type != "text") {
            // after the switch changes which views are visible the text boxes are populated with the answer options
            changeAnswerOne(currentQuestion.getAnswer1());
            changeAnswerTwo(currentQuestion.getAnswer2());
            changeAnswerThree(currentQuestion.getAnswer3());
            changeAnswerFour(currentQuestion.getAnswer4());
            changeAnswerFive(currentQuestion.getAnswer5());
            changeAnswerSix(currentQuestion.getAnswer6());
        } else {
            changeAnswerOne(null);
            changeAnswerTwo(null);
            changeAnswerThree(null);
            changeAnswerFour(null);
            changeAnswerFive(null);
            changeAnswerSix(null);
        }

    }

    public void changeAnswerOne(String message) {
        TextView answerTextView = findViewById(R.id.answer_one);
        answerTextView.setText(message);
    }

    public void changeAnswerTwo(String message) {
        TextView answerTextView = findViewById(R.id.answer_two);
        answerTextView.setText(message);
    }

    public void changeAnswerThree(String message) {
        TextView answerTextView = findViewById(R.id.answer_three);
        answerTextView.setText(message);
    }

    public void changeAnswerFour(String message) {
        TextView answerTextView = findViewById(R.id.answer_four);
        answerTextView.setText(message);
    }

    public void changeAnswerFive(String message) {
        TextView answerTextView = findViewById(R.id.answer_five);
        answerTextView.setText(message);
    }

    public void changeAnswerSix(String message) {
        TextView answerTextView = findViewById(R.id.answer_six);
        answerTextView.setText(message);
    }

    public void checkQuestionAnswers() {

    }

    private boolean isRadioOneSelected() {
        boolean clicked;
        RadioButton button = findViewById(R.id.radio_1);
        clicked = button.isChecked();
        return clicked;
    }

    private boolean isRadioTwoSelected() {
        boolean clicked;
        RadioButton button = findViewById(R.id.radio_2);
        clicked = button.isChecked();
        return clicked;
    }

    private boolean isRadioThreeSelected() {
        boolean clicked;
        RadioButton button = findViewById(R.id.radio_3);
        clicked = button.isChecked();
        return clicked;
    }

    private boolean isRadioFourSelected() {
        boolean clicked;
        RadioButton button = findViewById(R.id.radio_4);
        clicked = button.isChecked();
        return clicked;
    }

    private boolean isRadioFiveSelected() {
        boolean clicked;
        RadioButton button = findViewById(R.id.radio_5);
        clicked = button.isChecked();
        return clicked;
    }

    private boolean isRadioSixSelected() {
        boolean clicked;
        RadioButton button = findViewById(R.id.radio_6);
        clicked = button.isChecked();
        return clicked;
    }


}
