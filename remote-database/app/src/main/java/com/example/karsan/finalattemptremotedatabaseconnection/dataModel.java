package com.example.karsan.finalattemptremotedatabaseconnection;

/**
 * Created by karsan on 24/08/16.
 */
public class dataModel {
    private String name;
    private int studentNumber;

    public String getName() {
        return name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String setName(String givenname){
        name = givenname;
        return name;
    }

    public int setStudentNo(int StudentNumber){
        studentNumber = StudentNumber;
        return studentNumber;
    }
}
