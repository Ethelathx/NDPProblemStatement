package com.example.ndpproblemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ModifySong extends AppCompatActivity {

    TextView tvId;
    EditText etSinger, etTitle, etYear;
    RadioGroup rg;
    RadioButton rb;
    ArrayList<Song> al;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        tvId = (TextView) this.findViewById(R.id.tvDisplaySongID);
        etSinger = (EditText) this.findViewById(R.id.etUpdateSinger);
        etTitle = (EditText) this.findViewById(R.id.etUpdateName);
        etYear = (EditText) this.findViewById(R.id.etUpdateYear);
        rg = (RadioGroup) this.findViewById(R.id.rgUpdate);
        btnUpdate = (Button) this.findViewById(R.id.buttonUpdate);
        btnDelete = (Button) this.findViewById(R.id.buttonDelete);
        btnCancel = (Button) this.findViewById(R.id.buttonCancel);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        tvId.setText("ID:" + data.get_id());
        etSinger.setText(data.getSingers());
        etTitle.setText(data.getTitle());
        etYear.setText(String.valueOf(data.getYear()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                rb = findViewById(rg.getCheckedRadioButtonId());

                dbh.updateSong(new Song(data.get_id(), etTitle.getText().toString(), etSinger.getText().toString(), Integer.valueOf(etYear.getText().toString()), Integer.valueOf(rb.getText().toString())));
                dbh.close();

                Intent intent = new Intent(ModifySong.this, showSong.class);
                setResult(RESULT_OK, intent);
                finish();

            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                dbh.deleteSong(data.get_id());
                dbh.close();
                Intent intent = new Intent(ModifySong.this, showSong.class);

                setResult(RESULT_OK, intent);
                finish();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifySong.this, showSong.class);

                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }

}