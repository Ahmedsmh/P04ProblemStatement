package sg.edu.rp.c346.id19008424.p04problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ThirdActivity extends AppCompatActivity {
    EditText etID,etTitle, etSinger, etYear;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup RgStars;
    RadioButton RadioButtonStar, radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        etID = findViewById(R.id.etID);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etSongYear);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        final Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");


        etID.setText("" + data.getId());
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText("" +data.getYear());
        //if else to check what is the stars on the song then set the active radio button
        if (data.getStars() == 1){
            radioButton1.setChecked(true);
        }
        else if (data.getStars() == 2){
            radioButton2.setChecked(true);
        }
        else if (data.getStars() == 3){
            radioButton3.setChecked(true);
        }
        else if (data.getStars() == 4){
            radioButton4.setChecked(true);
        }
        else if (data.getStars() == 5){
            radioButton5.setChecked(true);
        }



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                data.setTitle(etTitle.getText().toString());
                data.setSingers(etSinger.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                int selectedId = RgStars.getCheckedRadioButtonId();
                if(selectedId != -1){
                    data.setStars(selectedId);
                }
                dbh.updateNote(data);
                dbh.close();
                setResult(RESULT_OK, i);
                finish();

            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                dbh.deleteNote(data.getId());
                dbh.close();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
