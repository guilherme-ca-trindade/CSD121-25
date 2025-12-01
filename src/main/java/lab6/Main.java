package lab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lab6.ui.AppController;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        new AppController(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

