package com.neet.MapViewer;

import com.neet.DiamondHunter.TileMap.Tile;
import com.neet.DiamondHunter.TileMap.TileMap;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapModel {


    //if map has loaded
    private boolean loaded;
    private Image[][] tiles;

    public MapModel(){
        loaded=false;
        loadmaptiles();
    }
    //map loader function
    private void loadmaptiles(){
        if (!loaded){
            TileMap tileMap = new TileMap(16);
            tileMap.loadTiles("/Tilesets/testtileset.gif");
            tileMap.loadMap("/Maps/testmap.map");
            Tile[][] tilearray= tileMap.getTiles();
            tiles = new Image[tilearray.length][tilearray[0].length];
            for(int i=0;i<tilearray.length;i++){
                for(int j=0;j<tilearray[i].length;j++){
                    tiles[i][j] = SwingFXUtils.toFXImage(tilearray[i][j].getImage(), null);
                }
            }
        }
    }


}
