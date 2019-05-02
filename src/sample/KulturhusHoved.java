package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class KulturhusHoved extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent rot;
        try {
            rot = FXMLLoader.load(getClass().getResource("Oppstart.fxml"));
            primaryStage.setTitle("Kulturhus");
            Scene scene = new Scene(rot, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}




