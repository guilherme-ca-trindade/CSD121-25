package lab6.type;

public class SteelType extends PokemonType{
    public SteelType(){
        super("STEEL","/lab6/steel.png","#B7B7CE");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.ICE);
        superEffective.add(TypeRegistry.ROCK);
        superEffective.add(TypeRegistry.FAIRY);

        notVeryEffective.add(TypeRegistry.FIRE);
        notVeryEffective.add(TypeRegistry.WATER);
        notVeryEffective.add(TypeRegistry.ELECTRIC);
        notVeryEffective.add(TypeRegistry.STEEL);
    }
}