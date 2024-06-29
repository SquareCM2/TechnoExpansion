package squarecm;

import mindustry.mod.*;
import squarecm.content.ModBlock;
import squarecm.content.ModItem;
import squarecm.content.ModTechTree;
import squarecm.content.ModUnitTypes;

public class TechnoExpansion extends Mod{
    public static final String MOD_NAME = "technoexpansion";
    public static String name(String name){
        return MOD_NAME + "-" + name;
    }
    @Override
    public void loadContent(){
        ModUnitTypes.Load();
        ModItem.load();
        ModBlock.load();
        ModTechTree.Load();
    }
}
