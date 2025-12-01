package lab6.type;

public class ElectricType extends PokemonType {
    public ElectricType(){
        super("ELECTRIC","/lab6/electric.png","#F7D02C");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.WATER);
        superEffective.add(TypeRegistry.FLYING);

        notVeryEffective.add(TypeRegistry.ELECTRIC);
        notVeryEffective.add(TypeRegistry.GRASS);
        notVeryEffective.add(TypeRegistry.DRAGON);

        noEffect.add(TypeRegistry.GROUND);
    }
}
