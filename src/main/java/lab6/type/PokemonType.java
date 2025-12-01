package lab6.type;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    //Return the effectiveness against the opponent Pokémon type
    public double effectivenessAgainst (PokemonType opponent) {
        if  (superEffective.contains(opponent)) return 2.0;
        else if (notVeryEffective.contains(opponent)) return 0.5;
        else if (noEffect.contains(opponent)) return 0.0;
        else return 1.0;
    }

    //Void class method so each subclass fills its lists
    public abstract void loadRelations();
}

