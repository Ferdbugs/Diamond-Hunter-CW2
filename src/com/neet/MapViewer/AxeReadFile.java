package com.neet.MapViewer;

import java.io.File;
import java.util.Scanner;

public class AxeReadFile {
    private Scanner read;
    private int X,Y;



    public void openAxeFile(){
        try{
            read = new Scanner(new File("AxeCoordinates.txt"));
        }
        catch(Exception e){
            System.out.println("Could not find file AxeCoordinates.txt");
        }
    }

    public void readAxeFile(){
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