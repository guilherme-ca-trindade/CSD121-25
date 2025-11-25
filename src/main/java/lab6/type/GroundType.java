package lab6.type;

public class GroundType extends PokemonType{
    public GroundType(){
        super("GROUND");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.FIRE);
        superEffective.add(TypeRegistry.ELECTRIC);
        superEffective.add(TypeRegistry.POISON);
        superEffective.add(TypeRegistry.ROCK);
        superEffective.add(TypeRegistry.STEEL);

        notVeryEffective.add(TypeRegistry.GRASS);
        notVeryEffective.add(TypeRegistry.BUG);

        noEffect.add(TypeRegistry.FLYING);
    }
}
