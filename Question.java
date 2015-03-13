package com.androiddev.hectorperez.myapplication;

/**
 * Created by saviouraccount on 2015-03-06.
 *
 * this will represent an element from any process.
 */


public class Question {

    public String category;
    //0 - Input
    //1 - Output
    //2 - Techniques
    //3 - NONE

    public String elementName;

    public Question(){

    }

    public Question(String category, String elementName){
        this.category = category;
        this.elementName = elementName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName){this.elementName= elementName;}

    public String toString(){
        String result = "";
        result += "elName:" + elementName;
        result  += "/";
        result += "cat: " + category;
        return result;
    }
}
