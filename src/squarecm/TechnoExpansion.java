package squarecm;

import arc.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import squarecm.content.ModBlock;
import squarecm.content.ModItem;
import squarecm.content.ModTechTree;

public class TechnoExpansion extends Mod{
    @Override
    public void loadContent(){
        ModItem.load();
        ModBlock.load();
        ModTechTree.Load();
    }
}
