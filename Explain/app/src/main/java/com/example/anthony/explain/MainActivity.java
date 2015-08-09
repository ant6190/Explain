package com.example.anthony.explain;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button mainButton;
    User temp;
    User temp2;
    User temp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp = new User("ant","12345");
        temp2 = new User("ali","55555");
        temp3 = new User("eug","98765");

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View view) {
        EditText tempUserEdit = (EditText) findViewById(R.id.userName);
        String tempUser = tempUserEdit.getText().toString();
        EditText tempPassEdit = (EditText) findViewById(R.id.pass);
        String tempPass = tempPassEdit.getText().toString();
        if(temp.getPassword().compareTo(tempPass) == 0 && temp.getUserName().compareTo(tempUser) == 0){
            Intent intent = new Intent(this, MainMenuActivity.class);
            intent.putExtra("user", temp.getUserName());
            startActivity(intent);
            }
        else if(temp2.getPassword().compareTo(tempPass) == 0 && temp2.getUserName().compareTo(tempUser) == 0){
            Intent intent = new Intent(this, MainMenuActivity.class);
            intent.putExtra("user", temp2.getUserName());
            startActivity(intent);
        }
        else if(temp3.getPassword().compareTo(tempPass) == 0 && temp3.getUserName().compareTo(tempUser) == 0){
            Intent intent = new Intent(this, MainMenuActivity.class);
            intent.putExtra("user", temp3.getUserName());
            startActivity(intent);
        }

        else{
            TextView errorText = (TextView) findViewById(R.id.error_text);
            errorText.setText("Wrong Username and/or password");
            errorText.setTextColor(Color.RED);
            }
        }
}
