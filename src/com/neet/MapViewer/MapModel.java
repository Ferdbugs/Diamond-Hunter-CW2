package com.neet.MapViewer;

import com.neet.DiamondHunter.TileMap.Tile;
import com.neet.DiamondHunter.TileMap.TileMap;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class MapModel {

    private Image[][] tiles;
    private int[][] map;
    private int tilesize;
    private TileMap tileMap = new TileMap(16);
    public MapModel(){
        loadmaptiles();
    }
    //map loader function
    private void loadmaptiles(){
            tileMap.loadTiles("/Tilesets/testtileset.gif");
            tileMap.loadMap("/Maps/testmap.map");
            Tile[][] tilearray= tileMap.getTiles();
            tilesize = tileMap.getTileSize();
            map = tileMap.getmap();
            tiles = new Image[tilearray.length][tilearray[0].length];
            for(int i=0;i<tilearray.length;i++){
                for(int j=0;j<tilearray[i].length;j++){
                    tiles[i][j] = SwingFXUtils.toFXImage(tilearray[i][j].getImage(), null);
                }

            }

    }
    public TileMap getTileMap(){
        return tileMap;
    }
    public void drawmap(GraphicsContext g){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                int tile = map[i][j];
                int row=tile/20;
                int col=tile%20;
                g.drawImage(tiles[row][col],j*tilesize,i*tilesize);
            }
        }
    }



}
