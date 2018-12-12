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
            read = new Scanner(new File("BoatCoordinates.txt"));
        }
        catch(Exception e){
            System.out.println("Could not find file BoatCoordinates.txt");
        }
    }

    /**
     * This method reads the BoatCoordinates.txt file
     * and sets the coordinates through the X and Y setter methods
     */
    public void readBoatFile(){
        while(read.hasNext()){
            int x = read.nextInt();
            int y = read.nextInt();
            setX(x);
            setY(y);
        }
    }

    /**
     * This method closes the BoatCoordinates.txt file
     */
    public void closeFile(){
        read.close();
    }

    /**
     * This method sets the X value
     * @param X This represents the x-coordinates of the Boat
     */
    public void setX(int X){
        this.X = X;
    }

    /**
     * This method returns the X value
     * @return Returns the X-coordinate value
     */
    public int getX(){
        return X;
    }

    /**
     * This method sets the Y value
     * @param Y This represents the y-coordinates of the Boat
     */
    public void setY(int Y){
        this.Y= Y;
    }

    /**
     * This method returns the Y value
     * @return Returns the Y-coordinate value
     */
    public int getY(){
        return Y;
    }

}