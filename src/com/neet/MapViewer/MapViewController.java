package com.neet.MapViewer;

import com.neet.DiamondHunter.GameState.PlayState;
import com.neet.DiamondHunter.TileMap.TileMap;
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

public class MapViewController {

    private MapModel mapModel;

    @FXML
    private Canvas MapCanvas;
    private GraphicsContext Graphics;


    @FXML
    private ImageView Image_ViewMap,Map;
    private Image MapImage;

    @FXML
    private RadioButton TopLeft,TopRight,BottomLeft,BottomRight;

    @FXML
    private Button ZoomIn,ZoomOut,SetAxe,SetBoat;

    @FXML
    private TextField PlacementAxe,PlacementBoat;

    private int x,y,a,b;

    private Boolean Zoom;
    private String Area;

    public MapViewController(){
        mapModel = new MapModel();
        Zoom = false;
        Area= "";
        y=26;
        x=37;
        b=12;
        a=4;
    }
    public void drawItem(){
        Image Axe = mapModel.getAxe();
        Image Boat = mapModel.getBoat();
        Graphics.drawImage(Axe,x*16,y*16);
        Graphics.drawImage(Boat,a*16,b*16);
    }
    public void UpdateMap(){
        mapModel.drawmap(Graphics);
        drawItem();
        MapImage = MapCanvas.snapshot(new SnapshotParameters(),new WritableImage(640,640));
        Image_ViewMap.setImage(MapImage);
    }

    public void initialize(){
        Graphics = MapCanvas.getGraphicsContext2D();
        mapModel.drawmap(Graphics);
        UpdateMap();
        Rectangle2D viewportRect = new Rectangle2D(0, 0, 640, 640);
        Image_ViewMap.setViewport(viewportRect);
    }


    public void radioSelect(ActionEvent event){
        if(TopLeft.isSelected()){
            if(event.getSource()==ZoomIn) {
                Rectangle2D viewportRect = new Rectangle2D(0, 0, 320, 320);
                Image_ViewMap.setViewport(viewportRect);
                Zoom = true;
                Area = "topleft";
            }
        }
        if(TopRight.isSelected()){
            if(event.getSource()==ZoomIn) {
                Rectangle2D viewportRect = new Rectangle2D(320, 0, 320, 320);
                Image_ViewMap.setViewport(viewportRect);
                Zoom = true;
                Area = "topright";
            }
        }
        if(BottomLeft.isSelected()){
            if(event.getSource()==ZoomIn) {
                Rectangle2D viewportRect = new Rectangle2D(0, 320, 320, 320);
                Image_ViewMap.setViewport(viewportRect);
                Zoom = true;
                Area = "bottomleft";
            }
        }
        if(BottomRight.isSelected()){
            if(event.getSource()==ZoomIn) {
                Rectangle2D viewportRect = new Rectangle2D(320, 320, 320, 320);
                Image_ViewMap.setViewport(viewportRect);
                Zoom = true;
                Area = "bottomright";
            }
        }
        if(event.getSource()==ZoomOut){
            Rectangle2D viewportRect = new Rectangle2D(0, 0, 640, 640);
            Image_ViewMap.setViewport(viewportRect);
            Zoom = false;
        }
    }

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

                            System.out.println("THE COORDINATES SET FOR AXE ARE");
                            System.out.println("X-coordinates = "+x+" Y-Coordinates = " +y);

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
                            System.out.println("COORDINATES SET FOR BOAT ARE:");
                            System.out.println("X-coordinates = "+a+" Y-Coordinates = " +b);

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






}
