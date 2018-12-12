package com.neet.MapViewer;


import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * This class is used to create a text
 * file to store the coordinates of the Boat Coordinates.
 */
public class BoatCreateFile {
    private int x, y ;
    private Formatter file;

    /**
     * This method opens a new text file BoatCoordinates.txt
     */
    public void openFile() {

        try {
            file = new Formatter("BoatCoordinates.txt");        //Creates new file
        } catch (Exception e) {
            System.out.println("Error Creating File For Boat!");
        }
    }

    /**
     * This method is the setter method to set x's value
     * @param x This is the X-Coordinate for the Boat
     */
    public void setX(int x){this.x=x;}          //sets x value

    /**
     * This method is the setter method to set y's value
     * @param y This is the Y-Coordinate for the Boat
     */
    public void setY(int y){this.y=y;}          //sets y value

    /**
     * This method is used to write into the file the X and Y coordinates of the Boat
     */
    public void addRecords(){
        file.format("%d \n %d ",x, y);
    }   //Writes into file

    /**
     * This method closes the BoatCoordinates.txt file.
     */
    public void closeFile() {           //Closes file
        file.close();

    }



}
