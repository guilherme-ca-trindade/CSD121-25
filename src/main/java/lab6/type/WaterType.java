package lab6.type;

public class WaterType extends PokemonType{
    public WaterType() {
        super("WATER");
    }

    @Override
    public void loadRelations() {
        superEffective.add(TypeRegistry.FIRE);
        superEffective.add(TypeRegistry.GROUND);
        superEffective.add(TypeRegistry.ROCK);

        notVeryEffective.add(TypeRegistry.WATER);
        notVeryEffective.add(TypeRegistry.GRASS);
        notVeryEffective.add(TypeRegistry.DRAGON);
    }
}
