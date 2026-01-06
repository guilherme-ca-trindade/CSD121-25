package lab6.type;

public class BugType extends PokemonType{
    public BugType(){
        super("BUG","/lab6/bug.png","#A6B91A");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.GRASS);
        superEffective.add(TypeRegistry.PSYCHIC);
        superEffective.add(TypeRegistry.DARK);

        notVeryEffective.add(TypeRegistry.FIRE);
        notVeryEffective.add(TypeRegistry.FIGHTING);
        notVeryEffective.add(TypeRegistry.POISON);
        notVeryEffective.add(TypeRegistry.FLYING);
        notVeryEffective.add(TypeRegistry.GHOST);
        notVeryEffective.add(TypeRegistry.STEEL);
        notVeryEffective.add(TypeRegistry.FAIRY);
    }
}
