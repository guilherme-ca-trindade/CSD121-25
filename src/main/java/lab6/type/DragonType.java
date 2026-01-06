package lab6.type;

public class DragonType extends PokemonType{
    public DragonType(){
        super("DRAGON","/lab6/dragon.png","#6F35FC");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.DRAGON);

        notVeryEffective.add(TypeRegistry.STEEL);

        noEffect.add(TypeRegistry.FAIRY);
    }
}
