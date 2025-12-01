package lab6.type;

public class FireType extends PokemonType {
    public FireType() {
        super("FIRE","/lab6/fire.png","#EE8130");
    }

    @Override
    public void loadRelations() {
        superEffective.add(TypeRegistry.GRASS);
        superEffective.add(TypeRegistry.ICE);
        superEffective.add(TypeRegistry.BUG);
        superEffective.add(TypeRegistry.STEEL);

        notVeryEffective.add(TypeRegistry.FIRE);
        notVeryEffective.add(TypeRegistry.WATER);
        notVeryEffective.add(TypeRegistry.ROCK);
        notVeryEffective.add(TypeRegistry.DRAGON);
    }
}
