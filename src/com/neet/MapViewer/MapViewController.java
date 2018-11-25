package com.neet.MapViewer;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class MapViewController {

    private MapModel mapModel;

    @FXML
    private Canvas MapCanvas;

    public MapViewController(){
        mapModel = new MapModel();
    }

    public void initialize(){

        mapModel.drawmap(MapCanvas.getGraphicsContext2D());

    }


}
