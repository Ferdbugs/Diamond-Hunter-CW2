package com.neet.MapViewer;


import com.neet.DiamondHunter.Main.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;

/**
 * This is the controller class. It is used to interact with the MapView.fxml file to generate UI to the Map Viewer. It is used
 * to control what the buttons of the UI does, how the user interacts with the app and how the state of the app changes based on
 * the user interaction.
 */

public class MapViewController {

    private MapModel mapModel;

    @FXML
    private Canvas MapCanvas;
    private GraphicsContext Graphics;


    @FXML
    private ImageView Image_ViewMap;
    private Image MapImage;

    @FXML
    private RadioButton TopLeft,TopRight,BottomLeft,BottomRight;

    @FXML
    private Button ZoomIn,ZoomOut,SetAxe,SetBoat;

    @FXML
    private TextField PlacementAxe,PlacementBoat;

    //x and y are used as co-ordinates for placing the axe,a and b are used as co-ordinates for placing the boat
    private int x,y,a,b;

    private Boolean Zoom;                               //Zoom is used to test if user is zoomed in the map or not
    private String Area;                                //Area is used to store the part of the map user has zoomed into

    /**
     * Constructor for initializing the mapModel object and other variables.
     */
    public MapViewController(){
        mapModel = new MapModel();                      //Initialize a new MapModel object in the constructor
        Zoom = false;                                   //Zoom is initialized to false
        Area= "";
        y=26;                                           //Axe co-ordinates are set to default
        x=37;
        b=12;                                           //Boat co-ordinates are set to default
        a=4;
    }

    /**
     * Function used to draw item.
     */
    public void drawItem(){
        Image Axe = mapModel.getAxe();                  //Image of the axe is stored in variable
        Image Boat = mapModel.getBoat();                //Image of the boat is stored in variable
        Graphics.drawImage(Axe,x*16,y*16);        //Image of axe is drawn
        Graphics.drawImage(Boat,a*16,b*16);       //Image of boat is drawn
    }

    /**
     * Function used to update the map image with changing axe and boat positions.
     */
    public void UpdateMap(){
        mapModel.drawmap(Graphics);
        drawItem();
        MapImage = MapCanvas.snapshot(new SnapshotParameters(),new WritableImage(640,640));
        Image_ViewMap.setImage(MapImage);
    }

    /**
     * Function is used to initialize the graphics object and draw the initial map onto the canvas
     */
    public void initialize(){
        Graphics = MapCanvas.getGraphicsContext2D();
        mapModel.drawmap(Graphics);                                                                //Draws the map onto the Image Viewer by calling UpdateMap().
        UpdateMap();
        Rectangle2D viewportRect = new Rectangle2D(0, 0, 640, 640);
        Image_ViewMap.setViewport(viewportRect);
    }

    /**
     * Function used to zoom into specific parts of the map checking which radio button is selected.
     * @param event
     */
    public void radioSelect(ActionEvent event){
        if(TopLeft.isSelected()){                                                                      //Checks if radio button is selected and zoom-in button is pressed.
            if(event.getSource()==ZoomIn) {
                Rectangle2D viewportRect = new Rectangle2D(0, 0, 320, 320);   //Set viewport as top left part of map
                Image_ViewMap.setViewport(viewportRect);                                              //Sets the image as viewport image
                Zoom = true;
                Area = "topleft";
            }
        }
        if(TopRight.isSelected()){
            if(event.getSource()==ZoomIn) {                                                            //Checks if radio button is selected and zoom-in button is pressed.
                Rectangle2D viewportRect = new Rectangle2D(320, 0, 320, 320);  //Set viewport as top right part of map
                Image_ViewMap.setViewport(viewportRect);
                Zoom = true;
                Area = "topright";
            }
        }
        if(BottomLeft.isSelected()){
            if(event.getSource()==ZoomIn) {                                                             //Checks if radio button is selected and zoom-in button is pressed.
                Rectangle2D viewportRect = new Rectangle2D(0, 320, 320, 320);   //Set viewport as bottom left part of map
                Image_ViewMap.setViewport(viewportRect);
                Zoom = true;
                Area = "bottomleft";
            }
        }
        if(BottomRight.isSelected()){
            if(event.getSource()==ZoomIn) {                                                             //Checks if radio button is selected and zoom-in button is pressed.
                Rectangle2D viewportRect = new Rectangle2D(320, 320, 320, 320);//Set viewport as bottom right part of map
                Image_ViewMap.setViewport(viewportRect);
                Zoom = true;
                Area = "bottomright";
            }
        }
        if(event.getSource()==ZoomOut){                                                                 //Checks if zoom-out button is pressed
            Rectangle2D viewportRect = new Rectangle2D(0, 0, 640, 640);         //Sets viewport to the whole map
            Image_ViewMap.setViewport(viewportRect);
            Zoom = false;
        }
    }

    /**
     * Function used to set position of the axe and the boat on the map.
     * @param event
     */
    public void setPosition(ActionEvent event){

            if(event.getSource()==SetAxe){
            Image_ViewMap.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                        x = (int)event.getX()/16; //set x coordinates for axe
                        y = (int)event.getY()/16; // set y coordinates for boat
                        
                        if(Zoom==true)
                        {
                            if (Area=="topleft") {
                                x = x / 2;
                                y = y / 2;
                            }
                            if (Area=="topright") {
                                x = x / 2;
                                x += 20;
                                y = y / 2;
                            }
                            if (Area=="bottomleft") {
                                x = x / 2;
                                y = y / 2;
                                y +=20;
                            }
                            if (Area=="bottomright") {
                                x = x / 2;
                                x +=20;
                                y = y / 2;
                                y += 20;
                            }
                        }

                        if (mapModel.getTileMap().getType(y,x)==0){

                           // System.out.println("THE COORDINATES SET FOR AXE ARE");
                           // System.out.println("X-coordinates = "+x+" Y-Coordinates = " +y);

                            AxeCreateFile axe = new AxeCreateFile();
                            axe.openFile();
                            axe.setX(x);
                            axe.setY(y);
                            axe.addRecords();
                            axe.closeFile();
                            PlacementAxe.setText("  Axe is Placed! " +"("+x +","+ y+")");
                            UpdateMap();
                        }
                        else{
                            PlacementAxe.setText(" Invalid Axe Placement");
                        }

                }//end handle override
            });//end setOnMouseCLicked
        }//end if statement


            if(event.getSource()==SetBoat){
                Image_ViewMap.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        a = (int)event.getX()/16; //set x coordinates for boat
                        b = (int)event.getY()/16; //set  y coordinates for boat

                        if(Zoom==true)
                        {
                            if (Area=="topleft") {
                                a = a / 2;
                                b = b / 2;
                            }
                            if (Area=="topright") {
                                a = a / 2;
                                a += 20;
                                b = b / 2;
                            }
                            if (Area=="bottomleft") {
                                a = a / 2;
                                b = b / 2;
                                b +=20;
                            }
                            if (Area=="bottomright") {
                                a = a / 2;
                                a +=20;
                                b = b / 2;
                                b += 20;
                            }
                        }

                        if (mapModel.getTileMap().getType(b,a)==0){
                           // System.out.println("COORDINATES SET FOR BOAT ARE:");
                           // System.out.println("X-coordinates = "+a+" Y-Coordinates = " +b);

                            BoatCreateFile boat = new BoatCreateFile();
                            boat.openFile();
                            boat.setX(a);
                            boat.setY(b);
                            boat.addRecords();
                            boat.closeFile();
                            PlacementBoat.setText("  Boat is Placed! " +"("+a +","+ b+")");
                            UpdateMap();
                        }
                        else{
                            PlacementBoat.setText(" Invalid Boat Placement");
                        }
                    }//end handle override
                });
        }//end if statement
    }

    /**
     * The function is used to initiate the Diamond Hunter game from the Map Viewer Itself
     * @param event
     */
    @FXML public void StartGame(ActionEvent event){
        Main.PrimaryStage.hide();
        Game.main(null);
    }






}
