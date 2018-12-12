package com.neet.MapViewer;

import java.io.File;
import java.util.Scanner;

/**
 * This class reads the Boat coordinates from the BoatCoordinates.txt file
 */
public class BoatReadFile {
    private Scanner read;
    private int X,Y;


    /**
     * This method opens the BoatCoordinates.txt file
     */
    public void openBoatFile(){
        try{
            read = new Scanner(new File("BoatCoordinates.txt"));        //open BoatCoordinates.txt file
        }
        catch(Exception e){
            System.out.println("Could not find file BoatCoordinates.txt");        //prints if file not found
        }
    }

    /**
     * This method reads the BoatCoordinates.txt file
     * and sets the coordinates through the X and Y setter methods
     */
    public void readBoatFile(){                                         //reads boat file
        while(read.hasNext()){                  //true if there are integer values
            int x = read.nextInt();             //set x as first read integer
            int y = read.nextInt();             //set y as next read integer
            setX(x);                //set x value globally
            setY(y);                //set y value globally
        }
    }

    /**
     * This method closes the BoatCoordinates.txt file
     */
    public void closeFile(){
        read.close();
    }       //closes file

    /**
     * This method sets the X value
     * @param X This represents the x-coordinates of the Boat
     */
    public void setX(int X){
        this.X = X;
    }       //set x value

    /**
     * This method returns the X value
     * @return Returns the X-coordinate value
     */
    public int getX(){
        return X;
    }               //returns x value

    /**
     * This method sets the Y value
     * @param Y This represents the y-coordinates of the Boat
     */
    public void setY(int Y){
        this.Y= Y;
    }         //set y value

    /**
     * This method returns the Y value
     * @return Returns the Y-coordinate value
     */
    public int getY(){
        return Y;
    }                   //returns y value

}