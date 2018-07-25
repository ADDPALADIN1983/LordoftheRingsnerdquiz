package com.example.alangregos.lordoftheringsnerdquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Question question1 = new Question("What is the name of the weapon shown in this picture?", "Anduril", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.Anduril);
    private Question question2 = new Question("What is the name of the weapon shown in this picture?", "Glamdring", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.Glamdring);
    private Question question3 = new Question("What is the name of the weapon shown in this picture?", "Sting", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.LOTR_Sting);
    private Question question4 = new Question("What is the name of the weapon shown in this picture?", "Morgul Blade", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.Morgul_Blade);
    private Question question5 = new Question("What is the name of the weapon shown in this picture", "Orcrist", "Glamdring", "Orcrist",
            "Sting", "Anduril", "Morgul Blade", "Herugrim", R.drawable.Orcrist);

    private Question question6 = new Question("Who fought wielding this weapon?", "Bilbo", "Bilbo", "Aaragorn",
            "Gandalf", "Leglas", "Thranduil", "Frodo", R.drawable.The_Hobbit_Sting);
    private Question question7 = new Question("Who fought wielding this weapon?", "", "", "", "Bilbo", "Aragorn",
            "Gandalf", "Legolas", "Thranduil", "Thorin", R.drawable.Orcrist);
    private Question question8 = new Question("Who are descended from kings?", "Aragorn", "Legolas", "Thranduil", "Bilbo", "Aragorn",
            "Gandalf", "Legolas", "Thranduil", "Faramir", R.drawable.throne);

    private Question question9 = new Question("What is the name of the battering ram from Return of the King?", "Grond", R.drawable.Grond);
    private Question question10 = new Question("What is the name of Gandalf's horse ", "Shadowfax", R.drawable.Shadowfax);
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

    public void changeQuestion(String message) {

        TextView questionTextView = findViewById(R.id.question);
        questionTextView.setText(message);
    }

    public void changeAnswerOne(String message) {
        TextView answerTextView = findViewById(R.id.answer_one);
        answerTextView.setText(message);
    }


}
