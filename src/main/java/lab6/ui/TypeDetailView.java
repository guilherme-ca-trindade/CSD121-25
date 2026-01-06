package lab6.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import lab6.type.PokemonType;

import java.util.List;

/**
 * Detail view showing effectiveness information for a selected Pokémon type.
 * Displays super effective, not very effective, and no effect matchups.
 */
public class TypeDetailView extends VBox {

    private final AppController controller;
    private final PokemonType type;

    public TypeDetailView(AppController controller, PokemonType type) {
        this.controller = controller;
        this.type = type;
        this.setPadding(new Insets(20));
        this.setSpacing(25);
        this.setAlignment(Pos.TOP_CENTER);

        // Apply semi-transparent background using the type's theme color
        String color = type.getThemeColor() + "AA"; // 'AA' adds transparency
        this.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-background-radius: 20;" +
                        "-fx-padding: 20;"
        );

        buildUI();
    }

    /**
     * Builds the complete UI with back button, type icon, and effectiveness sections.
     */
    private void buildUI() {
        // Create the back button in the top-left corner
        HBox backBox = new HBox();
        backBox.setAlignment(Pos.TOP_LEFT);

        Button back = new Button("Back");
        back.setOnAction(e -> controller.showTypeSelector());
        backBox.getChildren().add(back);

        this.getChildren().add(backBox);

        // Display type icon and name
        Image img = new Image(getClass().getResourceAsStream(type.getImagePath()));
        ImageView iv = new ImageView(img);
        iv.setFitWidth(100);
        iv.setFitHeight(100);
        iv.setPreserveRatio(true);

        Label nameLabel = new Label(type.getName());
        nameLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold;" +
                "-fx-font-family: 'Courier New';");

        this.getChildren().addAll(iv, nameLabel);

        // Add effectiveness sections
        this.getChildren().add(buildEffectSection(
                "Super effective (2x):",
                type.getSuperEffective()
        ));

        this.getChildren().add(buildEffectSection(
                "Not very effective (0.5x):",
                type.getNotVeryEffective()
        ));

        this.getChildren().add(buildEffectSection(
                "No effect (0x):",
                type.getNoEffect()
        ));
    }

    /**
     * Creates a section showing types with a specific effectiveness multiplier.
     * @param titleText The section title (e.g., "Super effective (2x):")
     * @param list List of Pokémon types to display
     * @return VBox containing the title and type buttons
     */
    private VBox buildEffectSection(String titleText, List<PokemonType> list) {

        // Create the section title
        Label title = new Label(titleText);
        title.setStyle("-fx-font-family: 'Courier New';-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create the flow pane for type buttons
        FlowPane flow = new FlowPane();
        flow.setHgap(10);
        flow.setVgap(10);
        flow.setAlignment(Pos.CENTER);

        // Create a button for each type in the list
        for (PokemonType t : list) {

            Button b = new Button(t.getName());
            b.setStyle(
                    "-fx-background-color: " + t.getThemeColor() + ";" +
                            "-fx-background-radius: 10;" +
                            "-fx-border-color: rgba(255,255,255,0.4);" +
                            "-fx-border-radius: 10;" +
                            "-fx-border-width: 1;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-family: 'Courier New';"
            );
            // Navigate to the clicked type's detail view
            b.setOnAction(e -> controller.showTypeDetail(t));
            // Add hover effects
            b.setOnMouseEntered(ev -> b.setOpacity(0.8));
            b.setOnMouseExited(ev -> b.setOpacity(1.0));

            // Load and add type icon
            Image iconImage = new Image(getClass().getResourceAsStream(t.getImagePath()));
            ImageView iconView = new ImageView(iconImage);
            iconView.setFitWidth(20);
            iconView.setFitHeight(20);
            iconView.setPreserveRatio(true);

            b.setGraphic(iconView);
            b.setContentDisplay(ContentDisplay.LEFT);
            b.setPrefWidth(120);

            flow.getChildren().add(b);
        }

        VBox box = new VBox(5, title, flow);
        box.setAlignment(Pos.CENTER);

        return box;
    }
}

