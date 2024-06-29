package squarecm.content;

import arc.graphics.Color;
import mindustry.type.*;

public class ModItem {
    public static Item iron, rawIron, germanium ,steel, aluminium;
    public static void load()
    {
        iron = new Item("iron", Color.valueOf("6e7080"))
        {{
            hardness = 2;
            cost = 2;
            alwaysUnlocked = true;
        }};

        rawIron = new Item("rawIron", Color.valueOf("caa17b"))
        {{
            hardness = 1;
            cost = 2;
            alwaysUnlocked = true;
        }};

        germanium = new Item("germanium", Color.valueOf("857f66"))
        {{
            hardness = 2;
            cost = 2;
        }};

        aluminium = new Item("aluminium", Color.valueOf("aluminium"))
        {{
           hardness = 2;
           cost = 2;
        }};

        steel = new Item("steel", Color.valueOf("95a0bc"))
        {{
           hardness = 2;
           cost = 2;
        }};
    }
}
