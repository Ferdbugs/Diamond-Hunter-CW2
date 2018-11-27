package com.neet.MapViewer;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class MapViewController {

    private MapModel mapModel;

    @FXML
    private Canvas MapCanvas;
    private GraphicsContext Graphics;

    @FXML
    private ImageView Image_ViewMap;
    private Image MapImage;

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



}
