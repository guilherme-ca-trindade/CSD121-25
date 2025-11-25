package lab6.type;

import java.util.ArrayList;
import java.util.List;

public abstract class PokemonType {
    private final String name;

    //Protected lists for the subclasses
    protected List<PokemonType> superEffective = new ArrayList<>();
    protected List<PokemonType> notVeryEffective = new ArrayList<>();
    protected List<PokemonType> noEffect = new ArrayList<>();

    public PokemonType(String name) {
        this.name = name;
    }

    //Lists for JavaFX
    public List<PokemonType> getSuperEffective() {
        return List.of();
    }
    public List<PokemonType> getNotVeryEffective() {
        return List.of();
    }
    public List<PokemonType> getNoEffect() {
        return List.of();
    }

    public double effectivenessAgainst (PokemonType opponent) {
        if  (superEffective.contains(opponent)) return 2.0;
        else if (notVeryEffective.contains(opponent)) return 0.5;
        else if (noEffect.contains(opponent)) return 0.0;
        else return 1.0;
    }

    //Void class method so each subclass fills its lists
    public abstract void loadRelations();
}

