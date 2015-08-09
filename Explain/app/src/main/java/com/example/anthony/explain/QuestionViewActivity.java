package com.example.anthony.explain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class QuestionViewActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        setContentView(R.layout.activity_question_view);
        TextView errorText = (TextView) findViewById(R.id.title);
        errorText.setText(intent.getStringExtra("qText"));
        errorText = (TextView) findViewById(R.id.desc);
        errorText.setText(intent.getStringExtra("qDesc"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_view, menu);
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

    public void submitAns(View view) {
        String qText = intent.getStringExtra("qText");
        String qDesc = intent.getStringExtra("qDesc");
        String qUser = intent.getStringExtra("qUser");
        String user = intent.getStringExtra("user");
        Intent newIntent = new Intent(this, SumbitAnswerActivity.class);
        newIntent.putExtra("qText", qText);
        newIntent.putExtra("qDesc", qDesc);
        newIntent.putExtra("qUser", qUser);
        newIntent.putExtra("user", user);
        startActivity(intent);
    }
}
