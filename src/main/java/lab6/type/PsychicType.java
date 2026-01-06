package lab6.type;

public class PsychicType extends PokemonType{
    public PsychicType() {
        super("PSYCHIC","/lab6/psychic.png","#F95587");
    }

    @Override
    public void loadRelations(){
        superEffective.add(TypeRegistry.FIGHTING);
        superEffective.add(TypeRegistry.POISON);

        notVeryEffective.add(TypeRegistry.PSYCHIC);
        notVeryEffective.add(TypeRegistry.STEEL);

        noEffect.add(TypeRegistry.DARK);
    }
}
