package sg.edu.rp.c346.id19008424.p04problemstatement;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etSong, etSinger,etYear;
    RadioGroup radioGroupStar;
    Button btnInsert, btnShow;
    ArrayList<Song> alSong;
    RadioButton radioButtonStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSong = (EditText) findViewById(R.id.etSong2);
        etSinger = (EditText) findViewById(R.id.etSinger);
        etYear = (EditText) findViewById(R.id.etSongYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShowList);

        alSong = new ArrayList<Song>();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String song = etSong.getText().toString().trim();
                String singer = etSinger.getText().toString().trim();
                String year = etYear.getText().toString().trim();
                radioGroupStar = (RadioGroup) findViewById(R.id.starGroup);
                int selectedBtn = radioGroupStar.getCheckedRadioButtonId();
                radioButtonStar = (RadioButton) findViewById(selectedBtn);
                String num = String.valueOf(radioButtonStar.getText());
                int number = Integer.valueOf(num);
                int numYear = Integer.parseInt(year);
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_song = dbh.insertNote(song,singer,numYear,number);
                dbh.close();


                dbh.close();

                if (inserted_song != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
