package com.example.vd2_nguyennhatkhanh_22115053122222;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText firstNum = findViewById(R.id.etxtFirstNum);
        EditText secondNum = findViewById(R.id.etxtSecondNum);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnSub = findViewById(R.id.btnSubtraction);
        Button btnMul = findViewById(R.id.btnMultiplication);
        Button btnDiv = findViewById(R.id.btnDivison);
        TextView txtDisplay = findViewById(R.id.txtDisplay);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num_1 = Integer.parseInt(firstNum.getText().toString());
                int num_2 = Integer.parseInt(secondNum.getText().toString());
                int result = num_1 + num_2;
                txtDisplay.setText(String.valueOf(result));
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num_1 = Integer.parseInt(firstNum.getText().toString());
                int num_2 = Integer.parseInt(secondNum.getText().toString());
                int result = num_1 - num_2;
                txtDisplay.setText(String.valueOf(result));
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num_1 = Integer.parseInt(firstNum.getText().toString());
                int num_2 = Integer.parseInt(secondNum.getText().toString());
                int result = num_1 * num_2;
                txtDisplay.setText(String.valueOf(result));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num_1 = Integer.parseInt(firstNum.getText().toString());
                float num_2 = Integer.parseInt(secondNum.getText().toString());
                float result;
                if(num_2 == 0) {
                    txtDisplay.setText("can't divide by 0");
                }else{
                    result = num_1 / num_2;
                    txtDisplay.setText(String.valueOf(result));
                }
            }
        });

        EditText numberToCheck = findViewById(R.id.etxtNumberToCheck);
        Button btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num;
                try {
                    num = Integer.parseInt(numberToCheck.getText().toString());
                } catch (NumberFormatException e) {
                    numberToCheck.setText("Invalid input");
                    return;
                }

                if (isPrime(num)) {
                    numberToCheck.setText(num + " is a prime number");
                } else {
                    numberToCheck.setText(num + " is not a prime number");
                }
            }
        });


    }
}