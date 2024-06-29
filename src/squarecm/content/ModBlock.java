package squarecm.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.*;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.*;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class ModBlock
{
    public static GenericCrafter ironSmelter, SteelForger;
    public static CoreBlock coreBasic;
    public static Drill rotatyArmDrill;
    public static void load()
    {
        ironSmelter = new GenericCrafter("iron-smelter")
        {{
            requirements(Category.crafting, with(Items.copper, 50, Items.graphite, 50));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(ModItem.iron, 1);
            craftTime = 45f;
            size = 2;
            hasItems = true;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffbbaa")));
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(Items.coal, 1, ModItem.rawIron, 2));
        }};
        SteelForger = new GenericCrafter("steel-forger")
        {{
            requirements(Category.crafting, with(Items.graphite, 50, Items.copper, 80, Items.silicon, 30, ModItem.iron, 40));
            outputItem = new ItemStack(ModItem.steel, 2);
            this.craftEffect = Fx.formsmoke;
            this.drawer = new DrawMulti(new DrawBlock[]{new DrawDefault(), new DrawGlowRegion(){{suffix = "-top"; color = Color.valueOf("f86208");}}});
            craftTime = 60f;
            size = 3;
            hasItems = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            hasPower = true;
            consumeItems(with(Items.graphite, 2, ModItem.iron, 3));
            consumePower(0.5f);
        }};
        coreBasic = new CoreBlock("core-basic")
        {{
            this.requirements(Category.effect, ItemStack.with(new Object[]{Items.copper, 1000, Items.silicon, 800}));
            this.alwaysUnlocked = true;
            this.isFirstTier = true;
            this.unitType = ModUnitTypes.plankton;
            this.health = 1100;
            this.itemCapacity = 4000;
            this.size = 3;
            this.unitCapModifier = 8;
        }};
        rotatyArmDrill = new Drill("rotary-arm-drill")
        {
            DrawBlock drawer;
            {
            requirements(Category.production, with(ModItem.aluminium, 15));
            tier = 2;
            drillTime = 500;
            size = 2;
            rotateSpeed = 10.0F;
            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 0.6f * 9f){{
                blurThresh = 0.01f;
            }});
            researchCost = with(ModItem.aluminium, 10);

            consumeLiquid(Liquids.water, 0.1f).boost();
        }};
    }
}
