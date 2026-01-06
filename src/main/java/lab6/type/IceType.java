package lab6.type;

public class IceType extends PokemonType{
    public IceType() {
        super("ICE","/lab6/ice.png","#96D9D6");
    }

    @Override
    public void loadRelations() {
        superEffective.add(TypeRegistry.GRASS);
        superEffective.add(TypeRegistry.GROUND);
        superEffective.add(TypeRegistry.FLYING);
        superEffective.add(TypeRegistry.DRAGON);

        notVeryEffective.add(TypeRegistry.FIRE);
        notVeryEffective.add(TypeRegistry.WATER);
        notVeryEffective.add(TypeRegistry.ICE);
        notVeryEffective.add(TypeRegistry.STEEL);
    }
}
