package com.neet.MapViewer;

import java.io.File;
import java.util.Scanner;

public class BoatReadFile {
    private Scanner read;
    private int X,Y;



    public void openBoatFile(){
        try{
            read = new Scanner(new File("BoatCoordinates.txt"));
        }
        catch(Exception e){
            System.out.println("Could not find file BoatCoordinates.txt");
        }
    }

    public void readBoatFile(){
        while(read.hasNext()){
            int x = read.nextInt();
            int y = read.nextInt();
            setX(x);
            setY(y);
        }
    }

    public void closeFile(){
        read.close();
    }

    public void setX(int X){
        this.X = X;
    }

    public int getX(){
        return X;
    }
    public void setY(int Y){
        this.Y= Y;
    }

    public int getY(){
        return Y;
    }

}