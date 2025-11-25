package lab6.type;

public class TypeRegistry {
    public static final NormalType NORMAL = new NormalType();
    public static final FireType FIRE = new FireType();
    public static final WaterType WATER = new WaterType();
    public static final ElectricType ELECTRIC = new ElectricType();
    public static final GrassType GRASS = new GrassType();
    public static final IceType ICE = new IceType();
    public static final FightingType FIGHTING = new FightingType();
    public static final PoisonType POISON = new PoisonType();
    public static final GroundType GROUND = new GroundType();
    public static final FlyingType FLYING =new FlyingType();
    public static final PsychicType PSYCHIC = new PsychicType();
    public static final BugType BUG = new BugType();
    public static final RockType ROCK = new RockType();
    public static final GhostType GHOST = new GhostType();
    public static final DragonType DRAGON = new DragonType();
    public static final DarkType DARK = new DarkType();
    public static final SteelType STEEL = new SteelType();
    public static final FairyType FAIRY = new FairyType();

    static {
        NORMAL.loadRelations();
        FIRE.loadRelations();
        WATER.loadRelations();
        ELECTRIC.loadRelations();
        GRASS.loadRelations();
        ICE.loadRelations();
        FIGHTING.loadRelations();
        POISON.loadRelations();
        GROUND.loadRelations();
        FLYING.loadRelations();
        PSYCHIC.loadRelations();
        BUG.loadRelations();
        ROCK.loadRelations();
        GHOST.loadRelations();
        DRAGON.loadRelations();
        DARK.loadRelations();
        STEEL.loadRelations();
        FAIRY.loadRelations();
    }

}
