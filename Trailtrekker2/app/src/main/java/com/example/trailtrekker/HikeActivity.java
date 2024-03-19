package com.example.trailtrekker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HikeActivity extends AppCompatActivity {

    private TextView questionTextView;
    private EditText answerEditText;
    private int currentQuestionIndex = 0;
    private String activityType;

    MyHelper dbHelper;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hike);

        questionTextView = findViewById(R.id.questionTextView);
        answerEditText = findViewById(R.id.answerEditText);

        dbHelper = new MyHelper(this);
        db = new MyDatabase(this);

        // Get the activity type from intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("activityType")) {
            activityType = intent.getStringExtra("activityType");
        } else {
            // Default to "Hike" if activity type is not provided
            activityType = "Hike";
        }

        // Display the first question
        showNextQuestion();
    }

    public void onPreviousQuestionClick(View view) {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            showNextQuestion();
        }
    }

    public void onNextQuestionClick(View view) {
//        saveAnswer(currentQuestionIndex);
        showNextQuestion();


//        db.deleteAllData();
    }

    private void showNextQuestion() {
        String[] questions = null;
        switch (activityType) {
            case "Hike":
                questions = Constants.HIKING_QUESTIONS;
                break;
            case "Walk":
                questions = Constants.WALK_QUESTIONS;
                break;
            case "Run":
                questions = Constants.RUN_QUESTIONS;
                break;
            case "Bike":
                questions = Constants.BIKE_QUESTIONS;
                break;
        }

        if (questions != null && currentQuestionIndex < questions.length) {
            String question = questions[currentQuestionIndex];
            saveAnswer(currentQuestionIndex);

            questionTextView.setText(question);
            answerEditText.setText(""); // Clear previous answer
            currentQuestionIndex++;
        }
        if (currentQuestionIndex == questions.length) {
            // Last question is displayed, start new activity
            startActivity(new Intent(this, HikeExerciseActivity.class));
        }
    }

    private void saveAnswer(Integer index) {

        if (index == 1) {
            String answer = answerEditText.getText().toString().trim();
            Toast.makeText(HikeActivity.this, "title saved" + answer, Toast.LENGTH_SHORT).show();
//            ContentValues contentValues = new ContentValues();
//            contentValues.put(Constants.NAME, answer);

            db.insertData(1, Constants.NAME, answer);
        }
        else if (index == 2) {
            Toast.makeText(HikeActivity.this, "calories saved", Toast.LENGTH_SHORT).show();
            String answer = answerEditText.getText().toString().trim();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.CALORIES, answer);

            db.updateRow(1, contentValues);
        }
        else if (index == 3) {
            Toast.makeText(HikeActivity.this, "distance saved", Toast.LENGTH_SHORT).show();
            String answer = answerEditText.getText().toString().trim();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.DISTANCE, answer);

            db.updateRow(1, contentValues);
        }

        else if (index == 4) {
            Toast.makeText(HikeActivity.this, "step saved", Toast.LENGTH_SHORT).show();
            String answer = answerEditText.getText().toString().trim();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.STEP_COUNT, answer);

            db.updateRow(1, contentValues);
        }
        else if (index == 5) {
            Toast.makeText(HikeActivity.this, "weight saved", Toast.LENGTH_SHORT).show();
            String answer = answerEditText.getText().toString().trim();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.WEIGHT, answer);

            db.updateRow(1, contentValues);
        }
        else if (index == 6) {
            Toast.makeText(HikeActivity.this, "height saved", Toast.LENGTH_SHORT).show();
            String answer = answerEditText.getText().toString().trim();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.HEIGHT, answer);

            db.updateRow(1, contentValues);
        }
    }
}


