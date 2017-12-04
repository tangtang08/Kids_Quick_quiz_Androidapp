package com.cre8tivedevs.quizit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import static com.cre8tivedevs.quizit.R.id.dragon;
import static com.cre8tivedevs.quizit.R.id.unicornCheckbox;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // this is linked to the ORDER button on the xml activity
    public void submitOrder(View view) {


        CheckBox uni = (CheckBox) findViewById(unicornCheckbox);
        boolean uniChecked = uni.isChecked();

        CheckBox drag = (CheckBox) findViewById(dragon);
        boolean dragChecked = drag.isChecked();

        CheckBox mermd = (CheckBox) findViewById(R.id.mermaid);
        boolean mermdChecked = mermd.isChecked();

        CheckBox mermn = (CheckBox) findViewById(R.id.merman);
        boolean mermnChecked = mermn.isChecked();

        RadioButton mixedColors = (RadioButton) findViewById(R.id.mix);
        boolean allColorschecked = mixedColors.isChecked();

        CheckBox fallSeason = (CheckBox) findViewById(R.id.fall);
        boolean fallChecked = fallSeason.isChecked();

        EditText nameOffood = (EditText) findViewById(R.id.favFood);
        String theFavfood = nameOffood.getText().toString();

        int totalScore = calculateScores(uniChecked, dragChecked, mermdChecked, mermnChecked, allColorschecked, fallChecked);
        String message = createScore(totalScore, uniChecked, dragChecked);
        displayScore(message);
        {
            if (mixedColors.isChecked()) {
                Toast.makeText(getApplicationContext(), "Mixed is the correct answer", Toast.LENGTH_LONG).show();
            }
        }
    }
    private int calculateScores(boolean unis, boolean drags, boolean mermd, boolean mermn, boolean mx, boolean fallCkd) {

        int quizpoints = 0;

        if (unis) {
            quizpoints = quizpoints + 1;
        }
        if (drags) {
            quizpoints = quizpoints + 1;
        }
        if (mermd) {
            quizpoints = quizpoints + 1;
        }
        if (mermn) {
            quizpoints = quizpoints + 1;
        }
        if (mx) {
            quizpoints = quizpoints + 8;
        }
        if(fallCkd){
            quizpoints = quizpoints + 13;
        }
            return quizpoints;
        }
    private String createScore(int total, boolean uniChecked, boolean dragonChecked) {

        EditText names = (EditText) findViewById(R.id.name);
        String finalmessage = "Name :" + names.getText().toString();
        finalmessage += "\n Unicorn"+ uniChecked;
        finalmessage += "\n Dragon" + dragonChecked;
        finalmessage += "\n Quiz Score:" + total;
        return finalmessage;
    }
    private void displayScore(String message) {
        TextView theScore = (TextView) findViewById(R.id.submitScore);
        theScore.setText(message);
    }
}
