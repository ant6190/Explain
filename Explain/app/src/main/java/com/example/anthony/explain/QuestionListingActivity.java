package com.example.anthony.explain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionListingActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Question> questions;
    String user;
    ListView main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_listing);
        Intent intent = getIntent();
        user = intent.getStringExtra("user");
        questions = new ArrayList<Question>();
        User temp = new User("ant","");
        User temp2 = new User("ali","1");
        User temp3 = new User("eug", "22");
        Question q1 = new Question("What is 2+2",temp);
        Question q2 = new Question("What is 2+4",temp2,"help, I am bad at math");
        Question q3 = new Question("What is physics",temp3,"help, I am bad at science");
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        ListView mainListView;
        ArrayAdapter mArrayAdapter;
        ArrayList questionTitles = new ArrayList();
        for(int i = 0;i < questions.size(); i++){
            if(questions.get(i).getqUser().getUserName().compareTo(user) != 0) {
                questionTitles.add(questions.get(i).getqText());
            }
        }
        mainListView = (ListView) findViewById(R.id.questions);
        main = mainListView;
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, questionTitles);

        mainListView.setAdapter(mArrayAdapter);
        mainListView.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Log the item's position and contents
        // to the console in Debug
        Intent intent = new Intent(this, QuestionViewActivity.class);
        Question tempQ = questions.get(position);
        intent.putExtra("user", user);
        intent.putExtra("qText", tempQ.getqText());
        intent.putExtra("qDesc", tempQ.getqDesc());
        intent.putExtra("qUser", tempQ.getqUser().getUserName());
        startActivity(intent);
    }
}
