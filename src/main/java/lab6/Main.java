package lab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage){

        var label = new Label("Hello World");
        var scene = new Scene(label,600,400);

        stage.setScene(scene);
        stage.setTitle("My JavaFX App!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
