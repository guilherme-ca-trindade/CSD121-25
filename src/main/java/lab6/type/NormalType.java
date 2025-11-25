package lab6.type;

public class NormalType extends PokemonType{
    public NormalType(){
        super("NORMAL");
    }

    @Override
    public void loadRelations(){
        notVeryEffective.add(TypeRegistry.ROCK);
        notVeryEffective.add(TypeRegistry.STEEL);

        noEffect.add(TypeRegistry.GHOST);
    }
}
