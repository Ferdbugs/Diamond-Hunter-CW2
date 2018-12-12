package com.neet.MapViewer;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * This class is used to create a text
 * file to store the coordinates of the Axe Coordinates.
 */
public class AxeCreateFile {


    private int x,y;

    private Formatter file;

    /**
     * This method opens a new text file AxeCoordinates.txt
     */
    public void openFile() {

        try {
            file = new Formatter("AxeCoordinates.txt");             //Creates new file
        } catch (Exception e) {
            System.out.println("Error Creating File For Axe!");
        }
    }

    /**
     * This method is the setter method to set x's value
     * @param x This is the X-Coordinate for the Axe
     */
    public void setX(int x){this.x=x;}                  //Sets X value

    /**
     * This method is the setter method to set y's value
     * @param y This is the Y-Coordinate for the Axe
     */
    public void setY(int y){this.y=y;}                  //Sets Y value

    /**
     * This method is used to write into the file the X and Y coordinates of the Axe
     */
    public void addRecords(){
        file.format("%d \n %d ",x, y);
    }   //Writes into file

    /**
     * This method closes the AxeCoordinates.txt file.
     */
    public void closeFile() {       //closes file
        file.close();

    }



}
