package com.example.buttonclickapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText userInput;
    private Button button;
    private TextView textView;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "textcontents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
        userInput.setText("");


        textView.setMovementMethod(new ScrollingMovementMethod());

        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String result = userInput.getText().toString() + "\n";
                textView.append(result);
                userInput.setText("");

            }

        };
        button.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out");

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onCreate: in");
        super.onStart();
        Log.d(TAG, "onCreate: out");
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "OnCreate: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "OnCreate:out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate: in");
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString(TEXT_CONTENTS);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "OnCreate:out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onCreate: in");
        super.onDestroy();
        Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onCreate: in");
        super.onResume();
        Log.d(TAG, "onCreate: out");
    }


    @Override
    protected void onRestart() {
        Log.d(TAG, "onCreate: in");
        super.onRestart();
        Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onCreate: in");
        super.onPause();
        Log.d(TAG, "onCreate: out");
    }


    @Override
    protected void onStop() {
        Log.d(TAG, "onCreate: in");
        super.onStop();
        Log.d(TAG, "onCreate: out");
    }
}
