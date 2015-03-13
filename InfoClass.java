package com.androiddev.hectorperez.myapplication;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.*;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by saviouraccount on 2015-03-11.
 */
public class InfoClass {

    Context myContext = null;

    public InfoClass(Context context){
        //nothing.
        this.myContext = context;
    }
     /** * This example code shows you how to read file in Java * * IN MY CASE RAILWAY IS MY TEXT FILE WHICH I WANT TO DISPLAY YOU CHANGE WITH YOUR OWN */


     /*
     * read the file until a passed in process NO. matches what we read.
     * read until next int appears.
     *
     *processDesired obtained from selection of a process in menu.
     * DIF NUM QUESTIONS FOR DIFF PROCESSES ... hmmm !!!
     *
     * problem -> processDesired could be like 4.1 -> NOT an integer...
     *
     * */
     public Process readInfo(String filename, String processDesired, int numQuestions) { // read one Process.
         System.out.println("Reading File from Java code");

         Process resultingProcess = new Process(15);
         Question[] processElements = new Question[numQuestions];
         String title = null;

         for(int i =0; i<processElements.length; i++){
             processElements[i] = new Question();
             processElements[i].setCategory("default");
             processElements[i].setElementName("default");

         }

         int currQuestion = 0;

         int fileId = myContext.getResources().getIdentifier(filename, "raw", myContext.getPackageName());
         InputStream is = null;

         try {

             //Integer pD = (Integer) processDesired;

             is = myContext.getResources().openRawResource(fileId);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            // StringBuilder out = new StringBuilder();
             String line;
             while ((line = reader.readLine()) != null) {

                 if(processDesired.equals(line)) {
                     Log.d("INFOCLASS","process Desired equal to line");
                     title = reader.readLine();//kind of a cheat...
                     //loop until next line doesn't have two tokens???
                     while ((line = reader.readLine()) != null) {
                         //Log.d("INFOCLASS",line);
                         String[] tokens = line.split(",");

                         if(line.equals("")){ //empty line??
                             line = reader.readLine();
                             tokens = line.split(",");
                         }

                         if (tokens.length == 2) {

                              processElements[currQuestion].setElementName(tokens[0]);
                              Toast.makeText(myContext,processElements[currQuestion].getElementName(), Toast.LENGTH_SHORT).show();
                              processElements[currQuestion].setCategory(tokens[1]);
                              Toast.makeText(myContext,processElements[currQuestion].getCategory(), Toast.LENGTH_SHORT).show();
                              currQuestion++;
                              //put it into currQuestion...
                         }
                         else {
                             break;
                         }
                     }
                 }//end if

              }//end while

                 /*String[] tokens = line.split(",");

                 for(int i = 0; i<tokens.length; i++){

                 }*/
             //out.append(line);


         }
         catch(Exception e){
             System.out.println("Error while reading file line by line:" + e.getMessage());
         }
         finally {
             //close input
             if (is != null) {
                 try {
                     is.close();
                 }
                 catch(IOException ioex) {
                     //Very bad things just happened... handle it
                 }
             }

         }

         resultingProcess.processElements = processElements;
         resultingProcess.numElements = numQuestions;
         resultingProcess.title = title;

         return resultingProcess;

     }


}
