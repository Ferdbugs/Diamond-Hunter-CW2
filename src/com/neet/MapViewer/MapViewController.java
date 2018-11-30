package com.neet.MapViewer;

import com.neet.DiamondHunter.GameState.PlayState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
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

    public MapViewController(){
        mapModel = new MapModel();
    }

    public void initialize(){
        Graphics = MapCanvas.getGraphicsContext2D();
        mapModel.drawmap(Graphics);
        MapImage = MapCanvas.snapshot(new SnapshotParameters(),new WritableImage(640,640));
        Image_ViewMap.setImage(MapImage);
        Rectangle2D viewportRect = new Rectangle2D(0, 0, 300, 300);
        Image_ViewMap.setViewport(viewportRect);
    }


    public void radioSelect(ActionEvent event){
        if(TopLeft.isSelected()){
            if(event.getSource()==ZoomIn) {
                Rectangle2D viewportRect = new Rectangle2D(0, 0, 320, 320);
                Image_ViewMap.setViewport(viewportRect);
            }
        }
        if(TopRight.isSelected()){
            if(event.getSource()==ZoomIn) {
                Rectangle2D viewportRect = new Rectangle2D(320, 0, 320, 320);
                Image_ViewMap.setViewport(viewportRect);
            }
        }
        if(BottomLeft.isSelected()){
            if(event.getSource()==ZoomIn) {
                Rectangle2D viewportRect = new Rectangle2D(0, 320, 320, 320);
                Image_ViewMap.setViewport(viewportRect);
            }
        }
        if(BottomRight.isSelected()){
            if(event.getSource()==ZoomIn) {
                Rectangle2D viewportRect = new Rectangle2D(320, 320, 320, 320);
                Image_ViewMap.setViewport(viewportRect);
            }
        }
        if(event.getSource()==ZoomOut){
            Rectangle2D viewportRect = new Rectangle2D(0, 0, 640, 640);
            Image_ViewMap.setViewport(viewportRect);
        }
    }

    public void setPosition(ActionEvent event){

            if(event.getSource()==SetAxe){
            Image_ViewMap.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                        double x,y;
                        PlayState X = new PlayState();
                        PlayState Y = new PlayState();

                        x = event.getX();
                        y = event.getY();
                        x = Math.round(x);
                        y = Math.round(y);
                        X.setX((int) x);
                        Y.setY((int) y);

                        System.out.println("arguments passed for axe");
                        System.out.println("X-coordinates = "+x+" Y-Coordinates = " +y);

                }//end handle override
            });//end setOnMouseCLicked
        }//end if statement


            if(event.getSource()==SetBoat){
                Image_ViewMap.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        double a,b;

                        PlayState A = new PlayState();
                        PlayState B = new PlayState();

                        a = event.getX();
                        b = event.getY();
                        a = Math.round(a);
                        b = Math.round(b);
                        A.setX((int) a);
                        B.setY((int) b);

                        System.out.println("arguments passed for boat");
                        System.out.println("X-coordinates = "+a+" Y-Coordinates = " +b);

                    }//end handle override
                });
        }//end if statement
    }






}
