package com.example.alangregos.lordoftheringsnerdquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


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
    private Question question7 = new Question(6, "multiple", "Who fought wielding this weapon?", "", "", "", "Bilbo", "Aragorn",
            "Gandalf", "Legolas", "Thranduil", "Thorin", R.drawable.Orcrist);
    private Question question8 = new Question(7, "multiple", "Who are descended from kings?", "Aragorn", "Legolas", "Thranduil", "Bilbo", "Aragorn",
            "Gandalf", "Legolas", "Thranduil", "Faramir", R.drawable.throne);

    private Question question9 = new Question(8, "text", "What is the name of the battering ram from Return of the King?", "Grond", R.drawable.Grond);
    private Question question10 = new Question(9, "text", "What is the name of Gandalf's horse ", "Shadowfax", R.drawable.Shadowfax);
    private int currentQuestionIndex = 0;
    private int numberOfCorrectAnswer;
    private int totalNumberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // question answers need to be 40 chars or less


    // TODO: 7/23/2018 build controller for what views are visible and what ones are hidden
    // TODO: 7/23/2018 script radio buttons and link to questions and answers
    // TODO: 7/23/2018 script check boxes and link to questions and answers
    // TODO: 7/23/2018script edit text and link to questions and answers

    public void resetQuiz() {

    }

    public void changeQuestion() {

        Question question = question1;
        TextView questionTextView = findViewById(R.id.question);
        questionTextView.setText(question.questionText);
        String type = question.getQuestionStyle();
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
    }

    public void changeAnswerOne(String message) {
        TextView answerTextView = findViewById(R.id.answer_one);
        answerTextView.setText(message);
    }

}
