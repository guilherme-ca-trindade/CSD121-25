package lab6.type;

public class PoisonType extends PokemonType{
    public PoisonType(){
        super("POISON","/lab6/poison.png","#A33EA1");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.GRASS);
        superEffective.add(TypeRegistry.FAIRY);

        notVeryEffective.add(TypeRegistry.POISON);
        notVeryEffective.add(TypeRegistry.GROUND);
        notVeryEffective.add(TypeRegistry.ROCK);
        notVeryEffective.add(TypeRegistry.GHOST);

        noEffect.add(TypeRegistry.STEEL);
    }
}
