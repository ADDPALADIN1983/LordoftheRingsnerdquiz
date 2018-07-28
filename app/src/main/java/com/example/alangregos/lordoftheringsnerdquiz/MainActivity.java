package com.example.alangregos.lordoftheringsnerdquiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;
    private Question question6;
    private Question question7;
    private Question question8;
    private Question question9;
    private Question question10;
    private Question currentQuestion;
    // TODO: 7/26/2018 at some point convert the questions into an array of question objects
    // question answers need to be 40 chars or less
    private int currentQuestionIndex = 0;
    private int numberOfCorrectAnswer = 0;
    private final int totalNumberOfQuestions = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setQuestionAndAnswerTexts(currentQuestion.getQuestionStyle());
    }

    @Override
    protected void onStart() {
        super.onStart();
        question1 = new Question(0, "radio", getString(R.string.name_of_this_weapon_question), getString(R.string.anduril_text),
                getString(R.string.glamdring_text), getString(R.string.orcrist_text), getString(R.string.sting_text), getString(R.string.anduril_text),
                getString(R.string.morgul_blade_text), getString(R.string.herugrim_text), R.drawable.anduril);

        question2 = new Question(1, "radio", getString(R.string.name_of_this_weapon_question), getString(R.string.glamdring_text),
                getString(R.string.glamdring_text), getString(R.string.orcrist_text), getString(R.string.sting_text), getString(R.string.anduril_text), getString(R.string.morgul_blade_text),
                getString(R.string.herugrim_text), R.drawable.glamdring);

        question3 = new Question(2, "radio", getString(R.string.name_of_this_weapon_question), getString(R.string.sting_text),
                getString(R.string.glamdring_text), getString(R.string.orcrist_text), getString(R.string.sting_text), getString(R.string.anduril_text), getString(R.string.morgul_blade_text),
                getString(R.string.herugrim_text), R.drawable.lotr_sting);

        question4 = new Question(3, "radio", getString(R.string.name_of_this_weapon_question), getString(R.string.morgul_blade_text),
                getString(R.string.glamdring_text), getString(R.string.orcrist_text), getString(R.string.sting_text), getString(R.string.anduril_text), getString(R.string.morgul_blade_text),
                getString(R.string.herugrim_text), R.drawable.morgul_blade);

        question5 = new Question(4, "radio", getString(R.string.name_of_this_weapon_question), getString(R.string.orcrist_text),
                getString(R.string.glamdring_text), getString(R.string.orcrist_text), getString(R.string.sting_text), getString(R.string.anduril_text), getString(R.string.morgul_blade_text),
                getString(R.string.herugrim_text), R.drawable.orcrist);

        question6 = new Question(5, "multiple", getString(R.string.who_fought_wielding_question), getString(R.string.bilbo_text), true,
                getString(R.string.aragorn_text), false, getString(R.string.gandalf_text), false, getString(R.string.legolas_text), false,
                getString(R.string.thranduil_text), false, getString(R.string.frodo_text), false, R.drawable.the_hobbit_sting);

        question7 = new Question(6, "multiple", getString(R.string.who_fought_wielding_question), getString(R.string.bilbo_text), false,
                getString(R.string.aragorn_text), false, getString(R.string.gandalf_text), false, getString(R.string.legolas_text), true,
                getString(R.string.thranduil_text), false, getString(R.string.thorin_text), true, R.drawable.orcrist);

        question8 = new Question(7, "multiple", getString(R.string.decended_from_kings_question), getString(R.string.bilbo_text), false,
                getString(R.string.aragorn_text), true, getString(R.string.gandalf_text), false, getString(R.string.legolas_text), true,
                getString(R.string.thranduil_text), true, getString(R.string.faramir_text), false, R.drawable.throne);

        question9 = new Question(8, "text", getString(R.string.name_of_battering_ram_lotr_question), getString(R.string.grond_text), R.drawable.grond);
        question10 = new Question(9, "text", getString(R.string.gandalfs_horse_question), getString(R.string.shadowfax_text), R.drawable.shadowfax);

        currentQuestion = question1;
        setQuestionAndAnswerTexts(currentQuestion.getQuestionStyle());
    }

    //method called when reset button is called to reset the quiz questiong to the first one in the index.
    public void resetQuiz(View view) {
        currentQuestionIndex = 0;
        numberOfCorrectAnswer = 0;
        updateCurrentQuestion();
        updateViews();
    }


    //method called when next button is clicked to increment the current index and then populate the next question on the screen
    public void nextQuestion(View view) {

        if (currentQuestion.getQuestionStyle() == "radio") {
            radioButtonQuestionValidation();

        }
        if (currentQuestion.getQuestionStyle() == "multiple") {
            checkBoxQuestionValidation();

        }
        if (currentQuestion.getQuestionStyle() == "text") {
            textQuestionValidation();

        }

        if (currentQuestionIndex == 9) {
            double percent = ((double) numberOfCorrectAnswer / (double) totalNumberOfQuestions) * 100;
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            String toastText = getString(R.string.scored) + " " + numberOfCorrectAnswer + "/" + totalNumberOfQuestions + getString(R.string.scored_part_two)
                    + " " + decimalFormat.format(percent) + getString(R.string.percent_symbol_period);
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
        } else {
            currentQuestionIndex++;
        }
        updateCurrentQuestion();
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
                setQuestionAndAnswerTexts(type);
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
                setQuestionAndAnswerTexts(type);
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
                setQuestionAndAnswerTexts(type);
                EditText text = findViewById(R.id.typed_in_answer);
                text.setText(null);
                break;
            }

        }
        resetClickableListners();
    }

    // set's the answer options for the current question in the UI textViews
    public void setQuestionAndAnswerTexts(String type) {

        changeQuestionText(currentQuestion.getQuestionText());

        if (type != "text") {

            changeAnswerOne(currentQuestion.getAnswer1());
            changeAnswerTwo(currentQuestion.getAnswer2());
            changeAnswerThree(currentQuestion.getAnswer3());
            changeAnswerFour(currentQuestion.getAnswer4());
            changeAnswerFive(currentQuestion.getAnswer5());
            changeAnswerSix(currentQuestion.getAnswer6());
            setSmallImage(currentQuestion.getImage());
        } else {
            changeAnswerOne(null);
            changeAnswerTwo(null);
            changeAnswerThree(null);
            changeAnswerFour(null);
            changeAnswerFive(null);
            changeAnswerSix(null);
            setLargeImage(currentQuestion.getImage());
        }
    }

    public void changeQuestionText(String message) {
        TextView questionTextView = findViewById(R.id.question);
        questionTextView.setText(message);
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

    public void checkBoxQuestionValidation() {

        numberOfCorrectAnswer += currentQuestion.checkAnswer(isCheckBoxOneSelected(), isCheckBoxTwoSelected(), isCheckBoxThreeSelected(), isCheckBoxFourSelected(),
                isCheckBoxFiveSelected(), isCheckBoxSixSelected());

    }

    public void radioButtonQuestionValidation() {
        if (isRadioOneSelected()) {
            numberOfCorrectAnswer += currentQuestion.checkAnswer(currentQuestion.getAnswer1());
        }
        if (isRadioTwoSelected()) {
            numberOfCorrectAnswer += currentQuestion.checkAnswer(currentQuestion.getAnswer2());
        }

        if (isRadioThreeSelected()) {
            numberOfCorrectAnswer += currentQuestion.checkAnswer(currentQuestion.getAnswer3());
        }
        if (isRadioFourSelected()) {
            numberOfCorrectAnswer += currentQuestion.checkAnswer(currentQuestion.getAnswer4());
        }
        if (isRadioFiveSelected()) {
            numberOfCorrectAnswer += currentQuestion.checkAnswer(currentQuestion.getAnswer5());
        }
        if (isRadioSixSelected()) {
            numberOfCorrectAnswer += currentQuestion.checkAnswer(currentQuestion.getAnswer6());
        }
    }

    public void textQuestionValidation() {
        EditText text = findViewById(R.id.typed_in_answer);
        String answer = String.valueOf(text.getText());
        numberOfCorrectAnswer += currentQuestion.checkAnswer(answer);

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

    private boolean isCheckBoxOneSelected() {
        boolean clicked;
        CheckBox box = findViewById(R.id.check_box_1);
        clicked = box.isChecked();
        return clicked;
    }

    private boolean isCheckBoxTwoSelected() {
        boolean clicked;
        CheckBox box = findViewById(R.id.check_box_2);
        clicked = box.isChecked();
        return clicked;
    }

    private boolean isCheckBoxThreeSelected() {
        boolean clicked;
        CheckBox box = findViewById(R.id.check_box_3);
        clicked = box.isChecked();
        return clicked;
    }

    private boolean isCheckBoxFourSelected() {
        boolean clicked;
        CheckBox box = findViewById(R.id.check_box_4);
        clicked = box.isChecked();
        return clicked;
    }

    private boolean isCheckBoxFiveSelected() {
        boolean clicked;
        CheckBox box = findViewById(R.id.check_box_5);
        clicked = box.isChecked();
        return clicked;
    }

    private boolean isCheckBoxSixSelected() {
        boolean clicked;
        CheckBox box = findViewById(R.id.check_box_6);
        clicked = box.isChecked();
        return clicked;
    }

    public void setSmallImage(int image) {
        ImageView imageView = findViewById(R.id.small_image_for_question);
        imageView.setImageResource(image);
    }

    public void setLargeImage(int image) {
        ImageView imageView = findViewById(R.id.large_image_for_question);
        imageView.setImageResource(image);
    }

    public void resetClickableListners() {
        RadioGroup group = findViewById(R.id.radio_buttons);
        group.clearCheck();
        CheckBox boxOne = findViewById(R.id.check_box_1);
        boxOne.setChecked(false);
        CheckBox boxTwo = findViewById(R.id.check_box_2);
        boxTwo.setChecked(false);
        CheckBox boxThree = findViewById(R.id.check_box_3);
        boxThree.setChecked(false);
        CheckBox boxFour = findViewById(R.id.check_box_4);
        boxFour.setChecked(false);
        CheckBox boxFive = findViewById(R.id.check_box_5);
        boxFive.setChecked(false);
        CheckBox boxSix = findViewById(R.id.check_box_6);
        boxSix.setChecked(false);
    }
}
