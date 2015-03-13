package com.androiddev.hectorperez.myapplication;

/**
 * Created by saviouraccount on 2015-03-06.
 */
public class Process {

    //must have a name
    //must have a list of Questions/elements with their correct answer.

    String title;
    int numElements;
    Question[] processElements;


    Process(int numElements){
        this.numElements=numElements;
        processElements = new Question[numElements];
    }

    public void categorizeElements(Question[] processElements){ //should fill the processElements[] with questions.
                                        // the questions include their category inside them.
                                        // basically copy them from somewhere.
        for(int i=0; i< this.processElements.length; i++){
            this.processElements[i]= processElements[i];
        }

    }
    //manually input all the elements and their correct category?
    //can this be read from a file...? -> might save time. // how to include this file with the apk...


}
