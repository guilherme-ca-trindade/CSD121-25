package lab6.type;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Abstract base class representing a Pokémon type.
 * Each type has a name, icon, color, and effectiveness relationships with other types.
 * Subclasses must implement loadRelations() to define type matchups.
 */

public abstract class PokemonType {
    private final String name;
    private final String imagePath;
    private final String themeColor;

    //Protected lists for the subclasses
    protected List<PokemonType> superEffective = new ArrayList<>();
    protected List<PokemonType> notVeryEffective = new ArrayList<>();
    protected List<PokemonType> noEffect = new ArrayList<>();
    protected Image loadImage(String path) {
        InputStream stream = getClass().getResourceAsStream(path);
        if (stream == null) {
            throw new IllegalArgumentException("Image not found: " + path);
        }
        return new Image(stream);
    }


    public String getName(){
        return name;
    }
    public String getImagePath(){
        return imagePath;
    }
    public String getThemeColor(){
        return themeColor;
    }

    /**
     * Creates a new Pokémon type.
     * @param name Display the name of the type
     * @param imagePath Path to the type's icon image
     * @param themeColor Hex color code for the type's theme
     */

    public PokemonType(String name, String imagePath, String themeColor) {
        this.name = name;
        this.imagePath = imagePath;
        this.themeColor = themeColor;
    }


    //Lists for JavaFX
    public List<PokemonType> getSuperEffective() {
        return superEffective;
    }
    public List<PokemonType> getNotVeryEffective() {
        return notVeryEffective;
    }
    public List<PokemonType> getNoEffect() {
        return noEffect;
    }

    /**
     * Calculates the effectiveness multiplier of this type against an opponent type.
     * @param opponent The opposing Pokémon type
     * @return 2.0 for super effective, 0.5 for not very effective, 0.0 for no effect, 1.0 for neutral
     */
    public double effectivenessAgainst (PokemonType opponent) {
        if  (superEffective.contains(opponent)) return 2.0;
        else if (notVeryEffective.contains(opponent)) return 0.5;
        else if (noEffect.contains(opponent)) return 0.0;
        else return 1.0;
    }

    /**
     * Abstract method for subclasses to populate their effectiveness lists.
     * Each subclass must define which types it's strong/weak against.
     */
    public abstract void loadRelations();
}

