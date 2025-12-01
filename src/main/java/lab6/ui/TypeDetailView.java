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

public class TypeDetailView extends VBox {

    private final AppController controller;
    private final PokemonType type;

    public TypeDetailView(AppController controller, PokemonType type) {
        this.controller = controller;
        this.type = type;
        this.setPadding(new Insets(20));
        this.setSpacing(25);
        this.setAlignment(Pos.TOP_CENTER);

        String panelColor = type.getThemeColor() + "AA"; // 'AA' adds transparency


        // Transparent background color (according to the type)
        String color = type.getThemeColor() + "AA";
        this.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-background-radius: 20;" +
                        "-fx-padding: 20;"
        );

        buildUI();
    }

    private void buildUI() {
        // ----- Back button (aligned left) -----
        HBox backBox = new HBox();
        backBox.setAlignment(Pos.TOP_LEFT);

        Button back = new Button("Back");
        back.setOnAction(e -> controller.showTypeSelector());
        backBox.getChildren().add(back);

        this.getChildren().add(backBox);

        // ----- Icon + Name -----
        Image img = new Image(getClass().getResourceAsStream(type.getImagePath()));
        ImageView iv = new ImageView(img);
        iv.setFitWidth(100);
        iv.setFitHeight(100);
        iv.setPreserveRatio(true);

        Label nameLabel = new Label(type.getName());
        nameLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold;" +
                "-fx-font-family: 'Courier New';");

        this.getChildren().addAll(iv, nameLabel);

        // ----- Effectiveness Sections -----
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

    private VBox buildEffectSection(String titleText, List<PokemonType> list) {

        Label title = new Label(titleText);
        title.setStyle("-fx-font-family: 'Courier New';-fx-font-size: 20px; -fx-font-weight: bold;");

        FlowPane flow = new FlowPane();
        flow.setHgap(10);
        flow.setVgap(10);
        flow.setAlignment(Pos.CENTER);

        for (PokemonType t : list) {

            // Create button
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
            b.setOnAction(e -> controller.showTypeDetail(t));
            b.setOnMouseEntered(ev -> b.setOpacity(0.8));
            b.setOnMouseExited(ev -> b.setOpacity(1.0));

            // Load icon
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

