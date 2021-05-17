package sg.edu.rp.c346.id19008424.p04problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    Button btn5Stars;
    ListView lv;
    SongAdapter sa;
    ArrayList<Song> alSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        RadioGroup radioGroupStar = (RadioGroup) findViewById(R.id.starGroup);
        int selectedBtn = radioGroupStar.getCheckedRadioButtonId();
        RadioButton radioButtonStar = (RadioButton) findViewById(selectedBtn);
        String num = String.valueOf(radioButtonStar.getText());
        int number = Integer.valueOf(num);

        lv = findViewById(R.id.lvSongs);
        DBHelper dbSong = new DBHelper(SecondActivity.this);
        alSong = dbSong.getAllSongs(num);
        btn5Stars = findViewById(R.id.btn5StarsSong);

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if()

            }
        });
        lv.setAdapter(sa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song target = alSong.get(position);
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
//            btnRetrieve.performClick();
        }
    }

}
