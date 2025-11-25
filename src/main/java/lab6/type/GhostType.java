package lab6.type;

public class GhostType extends PokemonType{
    public GhostType() {
        super("GHOST");
    }

    @Override
    public void loadRelations(){
       superEffective.add(TypeRegistry.GHOST);
       superEffective.add(TypeRegistry.PSYCHIC);

       notVeryEffective.add(TypeRegistry.DARK);

       noEffect.add(TypeRegistry.NORMAL);
    }
}
