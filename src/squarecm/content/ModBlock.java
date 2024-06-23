package squarecm.content;

import arc.Core;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.mod.Mod;
import mindustry.type.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class ModBlock
{
    public static GenericCrafter ironSmelter;
    public static GenericCrafter SteelForger;
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
    }
}
