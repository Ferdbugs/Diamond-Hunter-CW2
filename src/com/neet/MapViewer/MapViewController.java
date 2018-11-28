package com.neet.MapViewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.swing.*;

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
    private Button ZoomIn,ZoomOut;

    public MapViewController(){
        mapModel = new MapModel();
    }

    public void initialize(){
        Graphics = MapCanvas.getGraphicsContext2D();
        mapModel.drawmap(Graphics);
        MapImage = MapCanvas.snapshot(new SnapshotParameters(),new WritableImage(640,640));
        Image_ViewMap.setImage(MapImage);
        Rectangle2D viewportRect = new Rectangle2D(0, 0, 640, 640);
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


}
