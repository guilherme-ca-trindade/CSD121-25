package lab6.type;

public class NormalType extends PokemonType{
    public NormalType(){
        super("NORMAL","/lab6/normal.png","#A8A77A");
    }

    @Override
    public void loadRelations(){
        notVeryEffective.add(TypeRegistry.ROCK);
        notVeryEffective.add(TypeRegistry.STEEL);

        noEffect.add(TypeRegistry.GHOST);
    }
}
