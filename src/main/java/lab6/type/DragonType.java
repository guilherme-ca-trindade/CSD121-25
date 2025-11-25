package lab6.type;

public class DragonType extends PokemonType{
    public DragonType(){
        super("DRAGON");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.DRAGON);

        notVeryEffective.add(TypeRegistry.STEEL);

        noEffect.add(TypeRegistry.FAIRY);
    }
}
