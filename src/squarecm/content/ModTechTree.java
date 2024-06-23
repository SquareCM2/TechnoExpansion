package squarecm.content;

import arc.struct.*;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.content.Items;
import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import mindustry.content.TechTree.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import squarecm.content.ModItem;
import squarecm.content.ModBlock;

public class ModTechTree
{
    public static TechTree.TechNode context = null;

    public static void Load()
    {
        addToNode(graphitePress, () -> node(ModBlock.ironSmelter));
        addToNode(coreShard, () -> node(ModItem.rawIron));
        addToNode(Items.copper, () -> node(ModItem.iron));
    }

    public static void addToNode(UnlockableContent p, Runnable c) {
        context = TechTree.all.find(t -> t.content == p);
        c.run();
    }
    public static void node(UnlockableContent content, Runnable children){
        node(content, content.researchRequirements(), children);
    }

    public static void node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        node(content, requirements, null, children);
    }

    public static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objective> objectives, Runnable children){
        TechNode node = new TechNode(context, content, requirements);
        if(objectives != null){
            node.objectives.addAll(objectives);
        }

        TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }

    public static void node(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives, children);
    }

    public static void node(UnlockableContent block){
        node(block, () -> {});
    }

    public static void nodeProduce(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives.add(new Produce(content)), children);
    }

    public static void nodeProduce(UnlockableContent content, Runnable children){
        nodeProduce(content, new Seq<>(), children);
    }
}
