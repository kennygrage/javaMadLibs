package com.example.guest.madlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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
    private TextView storyTextArea;
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
        storyTextArea = (TextView) findViewById(R.id.storyText);

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
                    String story = "There are many <u>" + userInput.get(0) + "</u> ways to choose a(n) <u>" + userInput.get(1) + "</u> to read. First, you could ask for recommendations from your friends and <u>" + userInput.get(2) + "</u>. Just don't ask Aunt <u>" + userInput.get(3) + "</u>. She only reads <u>" + userInput.get(4) + "</u> books with <u>" + userInput.get(5) + "</u>-ripping goddesses on the cover. If your friends and family are no help, try checking out the <u>" + userInput.get(6) + "</u> Review in <i>The <u>" + userInput.get(7) + "</u> Times</i>. If the <u>" + userInput.get(8) + "</u> featured there are too <u>" + userInput.get(9) + "</u> for your taste, try something a little more low-<u>" + userInput.get(10) + "</u>, like <u>" + userInput.get(11) + "</u>: <i>The <u>" + userInput.get(12) + "</u> Magazine</i>, or <i><u>" + userInput.get(13) + "</u> Magazine</i>. You could also choose a book the <u>" + userInput.get(14) + "</u>-fashioned way. Head to your local library or <u>" + userInput.get(15) + "</u> and browse the shelves until something catches your <u>" + userInput.get(16) + "</u>. Or you could save yourself a whole lot of <u>" + userInput.get(17) + "</u> trouble and log on to www.bookish.com, the <u>" + userInput.get(18) + "</u> new website to <u>" + userInput.get(19) + "</u> for books! With all the time you'll save not having to search for <u>" + userInput.get(20) + "</u>, you can read <u>" + userInput.get(21) + "</u> more books!";


                    storyTextArea.setText(Html.fromHtml(story));
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
