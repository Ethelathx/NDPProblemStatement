package com.example.ndpproblemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    RadioGroup rbGStar;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------Init UI---------------
        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);

        rbGStar = findViewById(R.id.rbGStar);

        btnInsert = findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnShow);
        //------------Init UI---------------



    }
}