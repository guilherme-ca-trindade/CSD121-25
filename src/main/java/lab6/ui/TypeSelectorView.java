package lab6.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import lab6.type.PokemonType;
import lab6.type.TypeRegistry;

/**
 * Main view for selecting Pokémon types.
 * Displays a welcome message and a grid of type buttons.
 */
public class TypeSelectorView extends VBox implements EventHandler<ActionEvent> {

    private final AppController controller;
    private GridPane buttonGrid;

    public TypeSelectorView(AppController controller) {
        this.controller = controller;

        // Set up the main layout
        this.setStyle("-fx-background-color: transparent;");
        this.setSpacing(20);
        this.setPadding(new Insets(20));

        // Build header and button grid
        HBox header = createHeader();
        buttonGrid = createButtonGrid();

        this.getChildren().addAll(header, buttonGrid);
    }

    /**
     * Creates the header section with trainer image and welcome text.
     */
    private HBox createHeader() {
        HBox header = new HBox();
        header.setSpacing(20);
        header.setAlignment(Pos.CENTER);

        try {
            // Load and display the trainer image
            Image trainerImage = new Image(getClass().getResourceAsStream("/lab6/N.png"));
            ImageView trainerView = new ImageView(trainerImage);
            trainerView.setFitWidth(150);
            trainerView.setFitHeight(150);
            trainerView.setPreserveRatio(true);

            VBox descriptionBox = createDescriptionBox();

            header.getChildren().addAll(trainerView, descriptionBox);

        } catch (Exception e) {
            System.err.println("Warning: Could not load trainer image: " + e.getMessage());
            // Show description only if the image fails to load
            header.getChildren().add(createDescriptionBox());
        }

        return header;
    }

    /**
     * Creates the welcome text box with the styled background.
     */
    private VBox createDescriptionBox() {
        VBox descriptionBox = new VBox();
        descriptionBox.setSpacing(10);
        descriptionBox.setPadding(new Insets(15));
        descriptionBox.setMaxWidth(400);

        // Apply dark background with rounded corners
        descriptionBox.setStyle(
                "-fx-background-color: rgba(0, 0, 0, 0.7); " +
                        "-fx-background-radius: 10; " +
                        "-fx-border-color: black; " +
                        "-fx-border-width: 2; " +
                        "-fx-border-radius: 10;"
        );

        // Create title label
        Label title = new Label("HELLO THERE!");
        title.setStyle(
                "-fx-font-family: 'Courier New'; " +
                        "-fx-font-weight: bold; " +
                        "-fx-font-size: 20px; " +
                        "-fx-text-fill: white; " +
                        "-fx-effect: dropshadow(one-pass-box, rgba(0,0,0,0.8), 2, 0, 1, 1);"
        );
        title.setTextAlignment(TextAlignment.CENTER);

        // Create description text
        Text description = new Text(
                "Welcome to the Pokémon type analyst\n\n" +
                        "Select a Pokémon type to see its strengths,\n" +
                        "weaknesses, and effectiveness against other types."
        );
        description.setStyle(
                "-fx-font-family: 'Courier New'; " +
                        "-fx-font-size: 14px; " +
                        "-fx-fill: white; " +
                        "-fx-line-spacing: 5px;"
        );
        description.setTextAlignment(TextAlignment.CENTER);

        title.setAlignment(Pos.CENTER);
        description.setTextAlignment(TextAlignment.CENTER);

        descriptionBox.getChildren().addAll(title, description);
        descriptionBox.setAlignment(Pos.CENTER_LEFT);

        return descriptionBox;
    }

    /**
     * Creates a grid of buttons for all Pokémon types.
     * Each button displays the type name, icon, and color.
     */
    private GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: transparent;");
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.setAlignment(Pos.CENTER);

        // All 18 Pokémon types
        PokemonType[] allTypes = {
                TypeRegistry.NORMAL,
                TypeRegistry.FIRE,
                TypeRegistry.WATER,
                TypeRegistry.GRASS,
                TypeRegistry.ELECTRIC,
                TypeRegistry.ICE,
                TypeRegistry.FIGHTING,
                TypeRegistry.POISON,
                TypeRegistry.GROUND,
                TypeRegistry.FLYING,
                TypeRegistry.PSYCHIC,
                TypeRegistry.BUG,
                TypeRegistry.ROCK,
                TypeRegistry.GHOST,
                TypeRegistry.DRAGON,
                TypeRegistry.DARK,
                TypeRegistry.STEEL,
                TypeRegistry.FAIRY
        };

        int row = 0;
        int col = 0;
        int columns = 6;

        // Create a button for each type
        for (PokemonType type : allTypes) {
            Button btn = new Button(type.getName());

            // Try to load type icon
            try {
                Image img = new Image(getClass().getResourceAsStream(type.getImagePath()));
                ImageView iv = new ImageView(img);
                iv.setFitWidth(40);
                iv.setFitHeight(40);
                iv.setPreserveRatio(true);
                btn.setGraphic(iv);
            } catch (Exception e) {
                System.err.println("Warning: Could not load image for " + type.getName() + ": " + e.getMessage());
            }

            // Style button with type's theme color
            btn.setStyle(
                    "-fx-background-color: " + type.getThemeColor() + "; " +
                            "-fx-font-family: 'Courier New';" +
                            "-fx-text-fill: white; " +
                            "-fx-font-weight: bold; " +
                            "-fx-font-size: 14px; " +
                            "-fx-padding: 10px; " +
                            "-fx-background-radius: 5; " +
                            "-fx-border-color: black; " +
                            "-fx-border-width: 1; " +
                            "-fx-border-radius: 5;"
            );

            btn.setUserData(type);
            btn.setOnAction(this);

            // Add button to grid and move to next position
            grid.add(btn, col, row);
            col++;
            if (col == columns) {
                col = 0;
                row++;
            }
        }

        return grid;
    }

    /**
     * Handles button clicks and shows the detail view for selected type.
     */
    @Override
    public void handle(ActionEvent event) {
        Button clicked = (Button) event.getSource();
        PokemonType selectedType = (PokemonType) clicked.getUserData();
        controller.showTypeDetail(selectedType);
    }
}
