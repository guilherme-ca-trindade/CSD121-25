package lab6.type;

public class FairyType extends PokemonType{
    public FairyType(){
        super("FAIRY","/lab6/fairy.png","#D685AD");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.FIGHTING);
        superEffective.add(TypeRegistry.DRAGON);
        superEffective.add(TypeRegistry.DARK);

        notVeryEffective.add(TypeRegistry.FIRE);
        notVeryEffective.add(TypeRegistry.POISON);
        notVeryEffective.add(TypeRegistry.STEEL);

    }
}
