package com.tharsikan.resultshow.resultservice.service;

public class Calculations {
    private Float gpv;
    String gradeCalculation(Float marks){
         String result ="";
        if(marks>=85)
        {
            result = "A+";
            gpv = 4.0F;
        }
        else if(marks>=75 && marks<84)
        {
            result = "A";
            gpv = 4.0F;
        }
        else if(marks>=70 && marks<74)
        {
            result = "A-";
            gpv = 3.7F;
        }
        else if(marks>=65 && marks<69)
        {
            result = "B+";
            gpv = 3.3F;
        }
        else if(marks>=60 && marks<64)
        {
            result = "B";
            gpv = 3.0F;
        }
        else if(marks>=55 && marks<59)
        {
            result = "B-";
            gpv = 2.7F;
        }
        else if(marks>=50 && marks<54)
        {
            result = "C+";
            gpv = 2.3F;
        }
        else if(marks>=40 && marks<49)
        {
            result = "C";
            gpv = 2.0F;
        }
        else if(marks>=35 && marks<39)
        {
            result = "C-";
            gpv = 1.7F;
        }
        else if(marks>=31 && marks<35)
        {
            result = "D+";
            gpv = 1.3F;
        }
        else if(marks>=26 && marks<30)
        {
            result = "D";
            gpv = 1.0F;
        }
        else
        {
            result = "E";
            gpv = 0.0F;
        }
        return result;
    }
    Float earnedGpvCalculation(Float credits){
        return (credits*gpv);
    }
}
