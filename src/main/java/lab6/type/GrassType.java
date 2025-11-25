package lab6.type;

public class GrassType extends PokemonType{
    public GrassType(){
        super("GRASS");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.WATER);
        superEffective.add(TypeRegistry.GROUND);
        superEffective.add(TypeRegistry.ROCK);

        notVeryEffective.add(TypeRegistry.FIRE);
        notVeryEffective.add(TypeRegistry.GRASS);
        notVeryEffective.add(TypeRegistry.POISON);
        notVeryEffective.add(TypeRegistry.FLYING);
        notVeryEffective.add(TypeRegistry.BUG);
        notVeryEffective.add(TypeRegistry.DRAGON);
        notVeryEffective.add(TypeRegistry.STEEL);

    }
}
