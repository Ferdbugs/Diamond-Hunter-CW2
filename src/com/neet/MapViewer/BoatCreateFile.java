package com.neet.MapViewer;


import java.io.*;
import java.lang.*;
import java.util.*;

public class BoatCreateFile {
    private int x, y ;
    private Formatter file;

    public void openFile() {

        try {
            file = new Formatter("BoatCoordinates.txt");
        } catch (Exception e) {
            System.out.println("Error Creating File For Boat!");
        }
    }
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}

    public void addRecords(){
        file.format("%d \n %d ",x, y);
    }

    public void resetRecords(){
        x=0;
        y=0;
        file.format("%d \n %d ",x, y);
    }

    public void closeFile() {
        file.close();

    }



}
