package com.example.ndpproblemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class showSong extends AppCompatActivity {
    Button show5;
    ListView lv;
    ArrayAdapter aa;
    Song dataSong;
    ArrayList<Song> newSongs;
    ArrayList<Song> newSongList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        lv = (ListView) this.findViewById(R.id.lvSongs);
        show5 = (Button) this.findViewById(R.id.buttonShow5);

        Intent i = getIntent();

        DBHelper dbh = new DBHelper(showSong.this);

        newSongs = new ArrayList<Song>();
        newSongs.clear();
        newSongs.addAll(dbh.getAllSongs());
        newSongList = new ArrayList<Song>();

        dbh.close();

        aa = new SongAdapter(showSong.this,R.layout.songrows,newSongs);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long identity) {
                Song target = newSongs.get(position);
                Intent i = new Intent(showSong.this,ModifySong.class);
                i.putExtra("data",target);
                startActivityForResult(i,9);
            }
        });

        show5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int d = 0;d<newSongs.size();d++){
                    if(newSongs.get(d).getStars() == 5) {
                        newSongList.add(newSongs.get(d));
                    }
                }
                aa = new SongAdapter(showSong.this,R.layout.songrows,newSongList);
                lv.setAdapter(aa);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            DBHelper dbh = new DBHelper(showSong.this);
            newSongs.clear();
            newSongs.addAll(dbh.getAllSongs());
            dbh.close();

            aa.notifyDataSetChanged();
        }
    }
    
}