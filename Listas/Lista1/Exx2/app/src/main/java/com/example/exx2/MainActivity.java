package com.example.exx2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private RadioGroup radioGroup;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        radioGroup = findViewById(R.id.radioGroup);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        double num1 = Double.parseDouble(editTextNumber1.getText().toString());
        double num2 = Double.parseDouble(editTextNumber2.getText().toString());
        double result = 0;

        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

        if (selectedRadioButton == null) {
            textViewResult.setText("Select an operation");
            return;
        }

        String operation = selectedRadioButton.getText().toString();

        if (operation.equals("Add")) {
            result = num1 + num2;
        } else if (operation.equals("Subtract")) {
            result = num1 - num2;
        } else if (operation.equals("Multiply")) {
            result = num1 * num2;
        } else if (operation.equals("Divide")) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                textViewResult.setText("Cannot divide by zero");
                return;
            }
        }

        textViewResult.setText("Result: " + result);
    }
}
