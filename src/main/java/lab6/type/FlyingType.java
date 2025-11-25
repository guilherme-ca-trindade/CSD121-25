package lab6.type;

public class FlyingType extends PokemonType{
    public FlyingType() {
        super("FLYING");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.GRASS);
        superEffective.add(TypeRegistry.FIGHTING);
        superEffective.add(TypeRegistry.BUG);

        notVeryEffective.add(TypeRegistry.ELECTRIC);
        notVeryEffective.add(TypeRegistry.ROCK);
        notVeryEffective.add(TypeRegistry.STEEL);
    }
}
