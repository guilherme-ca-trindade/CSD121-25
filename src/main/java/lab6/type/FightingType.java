package lab6.type;

public class FightingType extends PokemonType{
    public FightingType(){
        super("FIGHTING","/lab6/fighting.png","#C22E28");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.NORMAL);
        superEffective.add(TypeRegistry.ICE);
        superEffective.add(TypeRegistry.ROCK);
        superEffective.add(TypeRegistry.DARK);
        superEffective.add(TypeRegistry.STEEL);

        notVeryEffective.add(TypeRegistry.POISON);
        notVeryEffective.add(TypeRegistry.FLYING);
        notVeryEffective.add(TypeRegistry.PSYCHIC);
        notVeryEffective.add(TypeRegistry.BUG);
        notVeryEffective.add(TypeRegistry.FAIRY);

        noEffect.add(TypeRegistry.GHOST);
    }
}
