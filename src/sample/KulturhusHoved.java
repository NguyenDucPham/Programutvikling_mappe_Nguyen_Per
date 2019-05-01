package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class KulturhusHoved extends Application {
    
    ObservableList<String> list = FXCollections.observableArrayList("Csv","Jobj");
    ComboBox<String> combobox = new ComboBox();
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        combobox.setPromptText("Velg Csv eller Jobj");
        combobox.setPrefWidth(300);
        btn.setText("Bekreft");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Parent root;
                Window denne = btn.getScene().getWindow();
                if(combobox.getValue()=="Csv"){
                try {
                    root = FXMLLoader.load(getClass().getResource("Tab.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("My New Stage Title");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                    // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                }else if(combobox.getValue()=="Jobj"){


                }else Beskjed.visVarsel(Alert.AlertType.ERROR, denne, "Form Error!", "Fyll inn antall plasser");

            }
        });
        combobox.setItems(list);
        VBox root = new VBox();
        root.getChildren().addAll(combobox, btn);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400,400);

        primaryStage.setTitle("KulturhusHoved");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

/*
    //@Override
    public void newStage(Stage primaryStage) throws Exception{
        InnlastingThread myRunnable = new InnlastingThread();
        Thread t = new Thread(myRunnable);
        t.start();

        Parent root = FXMLLoader.load(getClass().getResource("Tab.fxml"));
        primaryStage.setTitle("Kulturhus");
       // GridPane gridPane = RegistreringLokale();
        Scene scene = new Scene(root, 900, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}




