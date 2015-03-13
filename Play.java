package com.androiddev.hectorperez.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Play extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        Log.d("PLAY", "SET LAYOUT");

        Button p4_2 = (Button)findViewById(R.id.p4_2);

        Button p4_4 = (Button)findViewById(R.id.p4_4); // huh???

        Log.d("PLAY","SET BUTTONS");

        View.OnClickListener play_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent myIntent;

                setContentView(R.layout.activity_question); //not sure if gusta

                String filename = "area4";

                Test testGenerated = null;

                InfoClass info = new InfoClass(Play.this.getApplicationContext());

                switch(v.getId()){
                    case R.id.p4_2:
                        Toast.makeText(Play.this, "4_2 BUTTON CLICKED", Toast.LENGTH_SHORT).show();

                        //GET ALL INFO.
                        testGenerated = new Test();

                        testGenerated = makeTest(info,filename,"4-2",15);

                        for(Question q : testGenerated.P.processElements){
                            Log.d("QUESTION"+testGenerated.getProcessTitle(),q.toString());
                        }

                        //myIntent = new Intent(Home.this, About.class ); // context, other class.
                        //startActivity(myIntent);
                        break;
                    case R.id.p4_4:
                        Toast.makeText(Play.this, "4_4 BUTTON CLICKED", Toast.LENGTH_LONG ).show();

                        testGenerated = new Test();

                        testGenerated = makeTest(info,filename,"4-4",15);

                        for(Question q : testGenerated.P.processElements){
                            Log.d("QUESTION"+testGenerated.getProcessTitle(),q.toString());
                        }
                        //GET ALL INFO

                        //myIntent = new Intent(Home.this, Play.class ); // context, other class.
                        //startActivity(myIntent);
                        break;

                }
            }
        };

        Log.d("PLAY","Created listener");


        p4_2.setOnClickListener(play_listener);
        p4_4.setOnClickListener(play_listener);


    }


    public static Test makeTest(InfoClass info,String filename, String process, int numQuestions){
       Test resultingTest = null;
        //read from file all questions/ and title into a process object.
        //initialize the test object with that process.
       Process process_used = info.readInfo(filename,process,numQuestions);

        resultingTest = new Test(process_used);

       return resultingTest;
    }

}
