package lab6.type;

public class RockType extends PokemonType{
    public RockType() {
        super("ROCK");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.FIRE);
        superEffective.add(TypeRegistry.ICE);
        superEffective.add(TypeRegistry.FLYING);
        superEffective.add(TypeRegistry.BUG);

        notVeryEffective.add(TypeRegistry.FIGHTING);
        notVeryEffective.add(TypeRegistry.GROUND);
        notVeryEffective.add(TypeRegistry.STEEL);
    }
}
