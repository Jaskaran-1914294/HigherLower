package com.example.higherorlower;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.higherorlower.R.id.up;

public class MainActivity extends AppCompatActivity {

    int number=-1;
    int max=10;
    int min=0;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //No Title bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //Setting up our number
        ImageView img1=(ImageView)findViewById((R.id.imageView));
        img=img1;
        number = (int) Math.floor(Math.random()*(max-min+1)+min);
    }
    public void goHigher(){
        img.setImageResource(R.drawable.up);
        img.setVisibility(View.VISIBLE);

        Toast.makeText(this,"Go Higer",Toast.LENGTH_SHORT).show();
    }
    public void goLower(){
        img.setImageResource(R.drawable.down);
        img.setVisibility(View.VISIBLE);
        Toast.makeText(this,"Go Lower",Toast.LENGTH_SHORT).show();
    }
    public void congratulate(){
        img.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Congratulations", Toast.LENGTH_LONG).show();
    }
    public void wrongInput(){
        Toast.makeText(this,"Please Enter an input Between 0-10",Toast.LENGTH_SHORT).show();
    }
    public void submitPressed(View view) {
        int numberEntered=1;
        EditText editNumber=(EditText)findViewById(R.id.editNum);
        String s=editNumber.getEditableText().toString();
        if(s==""){
            wrongInput();
        }
        numberEntered=Integer.parseInt(s);
        editNumber.setText("");
        if(numberEntered>number){
            goLower();
        }
        else if(numberEntered<number){
            goHigher();
        }
        else{
            congratulate();
        }
    }

    public void checkPressed(View view) {
        Toast.makeText(this, "The answer is "+Integer.toString(number), Toast.LENGTH_SHORT).show();
    }

    public void resetPressed(View view) {
        img.setVisibility(View.INVISIBLE);
        number = (int) Math.floor(Math.random()*(max-min+1)+min);
    }
}