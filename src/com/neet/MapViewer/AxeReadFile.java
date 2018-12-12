package com.neet.MapViewer;

import java.io.File;
import java.util.Scanner;


/**
 * This class reads the Axe coordinates from the AxeCoordinates.txt file
 */
public class AxeReadFile {
    private Scanner read;
    private int X,Y;


    /**
     * This method opens the AxeCoordinates.txt file
     */
    public void openAxeFile(){
        try{
            read = new Scanner(new File("AxeCoordinates.txt"));     //open BoatCoordinates.txt file
        }
        catch(Exception e){
            System.out.println("Could not find file AxeCoordinates.txt");      //prints if file not found
        }
    }

    /**
     * This method reads the AxeCoordinates.txt file
     * and sets the coordinates through the X and Y setter methods
     */
    public void readAxeFile(){
        while(read.hasNext()){          //true while there is readable data in file
            int x = read.nextInt();        //sets x as first read integer
            int y = read.nextInt();         //sets y as next read integer
            setX(x);            //sets x globally
            setY(y);            //sets y globally
        }
    }

    /**
     * This method closes the AxeCoordinates.txt file
     */
    public void closeFile(){
        read.close();
    }           //closes file

    /**
     * This method sets the X value
     * @param X This represents the x-coordinates of the Axe
     */
    public void setX(int X){
        this.X = X;
    }           //sets x value

    /**
     * This method returns the X value
     * @return Returns the X-coordinate value
     */
    public int getX(){
        return X;
    }           //returns x value

    /**
     * This method sets the Y value
     * @param Y This represents the y-coordinates of the Axe
     */
    public void setY(int Y){
        this.Y= Y;
    }       //sets y value

    /**
     * This method returns the Y value
     * @return Returns the Y-coordinate value
     */
    public int getY(){
        return Y;
    }           //returns y value

}