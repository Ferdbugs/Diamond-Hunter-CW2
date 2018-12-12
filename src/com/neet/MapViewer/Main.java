package com.neet.MapViewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the Main class for the Map Viewer JavaFx application.
 */
public class Main extends Application {

    public static Stage PrimaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MapView.fxml"));      //The fxml file to be used as scene is specified.
        PrimaryStage=primaryStage;
        PrimaryStage.setTitle("Diamond Hunter MapViewer");                                //Setting title name.
        PrimaryStage.setScene(new Scene(root));                                           //Setting scene from the MapView.fxml
        PrimaryStage.show();
    }

}
