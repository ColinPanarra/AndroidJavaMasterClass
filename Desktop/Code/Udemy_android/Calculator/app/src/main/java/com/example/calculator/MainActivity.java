package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;
    private final String OPERAND_CONTENTS = "operands";
    private static final String STATE_OPERAND1 = "OPERAND1";

    // Variables hold operands and type of calculations

    private Double operand1 = null;

    private String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        newNumber = findViewById(R.id.newNumber);
        displayOperation = findViewById(R.id.operation);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDot = findViewById(R.id.buttonDot);

        Button buttonNeg = findViewById(R.id.buttonNeg);
        Button buttonClr = findViewById(R.id.buttonClr);

        Button buttonEquals = findViewById(R.id.buttonEqual);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonMultiply = findViewById(R.id.buttonMult);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonPlus = findViewById(R.id.buttonPlus);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                newNumber.append(b.getText().toString());

            }
        };
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);


        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = newNumber.getText().toString();


                try {
                    Double doubleValue = Double.valueOf(value);
                    performOperation(doubleValue, op);

                } catch (NumberFormatException e) {
                    newNumber.setText("");
                }
                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }


        };
        buttonEquals.setOnClickListener(opListener);
        buttonDivide.setOnClickListener(opListener);
        buttonMinus.setOnClickListener(opListener);
        buttonMultiply.setOnClickListener(opListener);
        buttonPlus.setOnClickListener(opListener);


        View.OnClickListener negListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                //String neg = b.getText().toString();
                if (newNumber.getText().toString().length() == 0) {
                    newNumber.setText("-");
                    return;
                }
                if (newNumber.getText().toString().charAt(0) != '-') {
                    newNumber.setText('-' + newNumber.getText().toString());
                } else {
                    newNumber.setText(newNumber.getText().toString().substring(1));
                }

            }
        };

        buttonNeg.setOnClickListener(negListener);


        View.OnClickListener clrListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
                operand1 = null;
            }
        };
        buttonClr.setOnClickListener(clrListener);

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(OPERAND_CONTENTS, displayOperation.getText().toString());
        if (operand1 != null) {
            outState.putDouble(STATE_OPERAND1, operand1);
        }
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pendingOperation = savedInstanceState.getString(OPERAND_CONTENTS);
        operand1 = savedInstanceState.getDouble(STATE_OPERAND1);
        displayOperation.setText(savedInstanceState.getString(OPERAND_CONTENTS));
    }

    private void performOperation(Double value, String operation) {
        if (null == operand1) {
            operand1 = value;
        } else {

            if (pendingOperation.equals("=")) {
                pendingOperation = operation;
            }
            switch (pendingOperation) {
                case "=":

                    operand1 = value;
                    break;
                case "/":
                    if (value == 0) {
                        operand1 = 0.0;
                    } else {
                        operand1 /= value;

                    }
                    break;
                case "-":
                    operand1 -= value;
                    break;
                case "+":
                    operand1 += value;
                    break;
                case "*":
                    operand1 *= value;
                    break;


            }
        }
        result.setText(operand1.toString());

        newNumber.setText("");
        displayOperation.setText(operation);
    }


}




