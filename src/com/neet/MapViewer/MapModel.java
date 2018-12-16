package com.neet.MapViewer;

import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.TileMap.Tile;
import com.neet.DiamondHunter.TileMap.TileMap;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This is the Model class. It interacts with Diamond Hunter code to fetch necessary resources for the Map Viewer to function.
 * Additionally this class contains the functions to draw the Map for the Map Viewer, which is called in the controller class. This
 * class will work as the intermediate between the controller class and the classes in Diamond Hunter.
 */

public class MapModel {

    private Image[][] tiles;
    private int[][] map;
    private int tilesize;
    private TileMap tileMap = new TileMap(16);
    private Image AxeImage;
    private Image BoatImage;
    private Image Diamond;
    private int[][] diamondloc;

    /**
     * Constructor used to initialize some functions and variables.
     */
    public MapModel(){
        loadmaptiles();                                                     //Calls loadmaptiles() to initialize the function, making it ready for use.
        AxeImage = SwingFXUtils.toFXImage(Content.ITEMS[1][1],null);  //Image of the axe is loaded from Content class in Diamond Hunter.
        BoatImage = SwingFXUtils.toFXImage(Content.ITEMS[1][0],null); //Image of the boat is loaded from Content class in Diamond Hunter.
        Diamond =  SwingFXUtils.toFXImage(Content.DIAMOND[0][0],null);
        diamondloc = new int[][] {{20,20},{12,36},{28,4},{4, 34},{28, 19},{35, 26},{38,36},{27, 28},{20, 30},{14, 25},{4, 21},{9, 14},{4, 3},{20, 14},{13, 20}};
    }

    /**
     * This function loads the map onto a multi-dimensional tile array.
     */
    private void loadmaptiles(){
            tileMap.loadTiles("/Tilesets/testtileset.gif");             //Calls loadTiles function in TileMap and loads in map tiles as argument.
            tileMap.loadMap("/Maps/testmap.map");                       //Calls loadMap function in TileMap and loads in testmap as argument.
            Tile[][] tilearray= tileMap.getTiles();                        //Passes the buffered images of the tiles into a multi-dimensional array.
            tilesize = tileMap.getTileSize();
            map = tileMap.getmap();
            tiles = new Image[tilearray.length][tilearray[0].length];
            for(int i=0;i<tilearray.length;i++){                            //Cycles through each buffered image in the array and converts it to JavaFX image.
                for(int j=0;j<tilearray[i].length;j++){
                    tiles[i][j] = SwingFXUtils.toFXImage(tilearray[i][j].getImage(), null);
                }

            }
    }

    /**
     * Getter function to TileMap.
     * @return tilemap
     */
    public TileMap getTileMap(){
        return tileMap;
    }

    /**
     * Function used to draw image from multi-dimensional array of images.
     * @param g
     */
    public void drawmap(GraphicsContext g){
        for(int i=0;i<map.length;i++){                                      //Cycle through the map array.
            for(int j=0;j<map[i].length;j++){
                int tile = map[i][j];
                int row=tile/20;                                            //Divide the respective tile by 20 to get row number.
                int col=tile%20;                                            //Modulus the respective tile by 20 to get column number.
                g.drawImage(tiles[row][col],j*tilesize,i*tilesize);   //Draws specific images from the tiles array according to the test map rows and columns.
            }
        }
    }

    /**
     * Getter function for Axe Image
     * @return AxeImage
     */
    public Image getAxe(){
        return AxeImage;
    }

    /**
     * Getter function for Boat Image
     * @return  BoatImage
     */
    public Image getBoat(){
        return BoatImage;
    }

    /**
     * Draw Diamond Function
     * @param g GraphicsContext Object
     */
    public void drawDiamond(GraphicsContext g)
    {
        for(int[] diamond : diamondloc){                                      //Cycle through the diamond co-ordinates array.
                g.drawImage(Diamond,diamond[1]*tilesize,diamond[0]*tilesize);   //Draws diamond images on specific co-ordinates.
            }

    }




}
