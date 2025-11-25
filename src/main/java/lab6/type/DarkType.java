package lab6.type;

public class DarkType extends PokemonType{
    public DarkType(){
        super("DARK");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.PSYCHIC);
        superEffective.add(TypeRegistry.GHOST);

        notVeryEffective.add(TypeRegistry.FIGHTING);
        notVeryEffective.add(TypeRegistry.DARK);
        notVeryEffective.add(TypeRegistry.FAIRY);
    }
}
