package com.androiddev.hectorperez.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); //why did this change???

        Log.d("HOME","SET LAYOUT");

        Button aboutbutton = (Button)findViewById(R.id.aboutbutton);

        Button playbutton = (Button)findViewById(R.id.playbutton); // huh???

        Button historybutton = (Button)findViewById(R.id.historybutton); // huh???

        Button helpbutton = (Button)findViewById(R.id.helpbutton); // huh???

        Log.d("HOME","SET BUTTONS");


        OnClickListener a_listener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent;

                switch(v.getId()){
                    case R.id.aboutbutton:
                        Toast.makeText(Home.this, "ABOUT BUTTON CLICKED", Toast.LENGTH_LONG ).show();
                        myIntent = new Intent(Home.this, About.class ); // context, other class.
                        startActivity(myIntent);
                        break;
                    case R.id.playbutton:
                        Toast.makeText(Home.this, "PLAY BUTTON CLICKED", Toast.LENGTH_LONG ).show();
                        myIntent = new Intent(Home.this, Play.class ); // context, other class.
                        startActivity(myIntent);
                        break;

                    case R.id.historybutton:
                        Toast.makeText(Home.this, "HISTORY BUTTON CLICKED", Toast.LENGTH_LONG ).show();
                        myIntent = new Intent(Home.this, History.class ); // context, other class.
                        startActivity(myIntent);
                        break;

                    case R.id.helpbutton:
                        Toast.makeText(Home.this, "HELP BUTTON CLICKED", Toast.LENGTH_LONG ).show();
                        myIntent = new Intent(Home.this, Help.class ); // context, other class.
                        startActivity(myIntent);
                        break;


                }
            }
        };

        Log.d("HOME","Created listener");


        aboutbutton.setOnClickListener(a_listener);
        playbutton.setOnClickListener(a_listener);
        historybutton.setOnClickListener(a_listener);
        helpbutton.setOnClickListener(a_listener);


        Log.d("HOME","SET listener");

    }



}
