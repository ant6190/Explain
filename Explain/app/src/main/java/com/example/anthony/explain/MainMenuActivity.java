package com.example.anthony.explain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {

    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent intent = getIntent();
        String message = intent.getStringExtra("user");
        TextView errorText = (TextView) findViewById(R.id.welcome_text);
        errorText.setText("Welcome, " + message);
        user = message;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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

    public void goToQuestions(View view) {
        Intent intent = new Intent(this, QuestionListingActivity.class);
        startActivity(intent);
    }

    public void askAQuestion(View view) {
        Intent intent = new Intent(this, AskQuestionActivity.class);
        startActivity(intent);
    }

    public void getAnswers(View view) {
        Intent intent = new Intent(this, PendingAnswersActivity.class);
        startActivity(intent);
    }
}
