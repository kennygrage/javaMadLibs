package com.example.guest.madlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MadLibs extends AppCompatActivity {
    //Member variables
    private TextView editTextArea;
    private String word_from_user_input = "";
    public List<String> userInput = new ArrayList<String>();
    public int counter = 0;                 //count how many times the next button was clicked
    protected String[] mWordTypes = {};
    protected String hint = "";

    //Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_libs);

        final RelativeLayout beginningLayout = (RelativeLayout) findViewById(R.id.beginningLayout);
        final RelativeLayout storyLayout = (RelativeLayout) findViewById(R.id.storyLayout);

        editTextArea = (TextView) findViewById(R.id.editText);

        mWordTypes = getResources().getStringArray(R.array.word_types);
        editTextArea.setHint(mWordTypes[0]);
        final Button nextButton = (Button) findViewById(R.id.button);
        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                word_from_user_input = editTextArea.getText().toString();
                editTextArea.setText("");
                userInput.add(word_from_user_input);
                Toast.makeText(getApplicationContext(), userInput.get(userInput.size() - 1), Toast.LENGTH_SHORT).show();

                if (counter >= mWordTypes.length) { //we went thru all of the words
                    String story = "There are many <u>times</u> to go there.";
                    beginningLayout.setVisibility(View.INVISIBLE);
                    storyLayout.setVisibility(View.VISIBLE);
                }
                else { //we still have at least one more word to go thru
                    editTextArea.setHint(mWordTypes[counter]);
                }


            }
        };
        nextButton.setOnClickListener(listener);

    }
}
