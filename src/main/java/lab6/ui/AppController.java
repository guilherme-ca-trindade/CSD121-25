package lab6.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import lab6.type.PokemonType;

/**
 * Controls navigation between views in the Pokémon type analyzer.
 * Manages the main stage and switches between selector and detail views.
 */
public class AppController {
    private final Stage stage;
    private final StackPane root;
    private TypeSelectorView selectorView;
    
    // The detail view changes, according to the Pokémon type clicked
    private TypeDetailView detailView;

    public AppController(Stage stage){
        this.stage = stage;
        this.root = new StackPane();
        selectorView = new TypeSelectorView(this);
        StackPane.setAlignment(selectorView, Pos.CENTER);

        // Load and set the battleground background image
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
            // Continue without the background if the image fails to load
            System.err.println("Warning: Could not load background image: " + e.getMessage());
        }

        // Set up scene and display stage
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
        showTypeSelector();
    }

    /**
     * Shows the type selector view with all Pokémon types.
     */
    public void showTypeSelector(){
        selectorView = new TypeSelectorView(this);
        StackPane.setAlignment(selectorView, Pos.CENTER);
        root.getChildren().setAll(selectorView);
    }

    /**
     * Shows the detail view for a specific Pokémon type.
     * @param type The Pokémon type to display details for
     */
    public void showTypeDetail(PokemonType type){
        detailView = new TypeDetailView(this, type);
        StackPane.setAlignment(detailView, Pos.CENTER);

        // Set size and transparency for the detail panel
        detailView.setMaxWidth(500);
        detailView.setOpacity(0.95);
        root.getChildren().setAll(detailView);
    }
}
