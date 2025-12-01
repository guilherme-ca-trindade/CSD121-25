package lab6.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import lab6.type.PokemonType;

public class AppController {
    private final Stage stage;
    //Root with the background image (Pokémon battleground)
    private final StackPane root;
    private TypeSelectorView selectorView;
    //The detail view changes, according to the Pokémon type clicked
    private TypeDetailView detailView;

    public AppController(Stage stage){
        this.stage = stage;
        this.root = new StackPane();
        selectorView = new TypeSelectorView(this);
        StackPane.setAlignment(selectorView, Pos.CENTER);


        // Load battleground background
        try {
            Image bgImage = new Image(
                    getClass().getResourceAsStream("/lab6/Battleground.png")
            );

            BackgroundImage bg = new BackgroundImage(
                    bgImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(
                            BackgroundSize.AUTO,
                            BackgroundSize.AUTO,
                            false,
                            false,
                            true,
                            true
                    )
            );

            root.setBackground(new Background(bg));

        } catch (Exception e) {
            // If the image fails to load, continue without the background
            System.err.println("Warning: Could not load background image: " + e.getMessage());
        }


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
        showTypeSelector();
    }

    public void showTypeSelector(){
        selectorView = new TypeSelectorView(this);
        StackPane.setAlignment(selectorView, Pos.CENTER);
        root.getChildren().setAll(selectorView);
    }

    public void showTypeDetail(PokemonType type){
        detailView = new TypeDetailView(this, type);
        StackPane.setAlignment(detailView, Pos.CENTER);

        detailView.setMaxWidth(500);
        detailView.setOpacity(0.95);
        root.getChildren().setAll(detailView);
    }
}
