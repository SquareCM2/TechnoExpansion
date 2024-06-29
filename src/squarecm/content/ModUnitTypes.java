package squarecm.content;

import arc.struct.*;
import arc.graphics.Color;
import mindustry.ai.types.*;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import squarecm.TechnoExpansion;

public class ModUnitTypes {
    public static UnitType plankton;

    public static void Load()
    {
        //EntityMapping.idMap[47] = squarecm.Entity.UnitEntityLegacyPlankton::new;
        EntityMapping.nameMap.put(TechnoExpansion.name("plankton"), EntityMapping.idMap[0]);
        plankton = new UnitType("plankton")
        {{
            this.aiController = BuilderAI::new;
            this.isEnemy = false;
            this.lowAltitude = true;
            this.flying = true;
            this.mineSpeed = 6.5F;
            this.mineTier = 2;
            this.buildSpeed = 0.5F;
            this.drag = 0.05F;
            this.speed = 5.0F;
            this.rotateSpeed = 15.0F;
            this.accel = 0.1F;
            this.fogRadius = 0.0F;
            this.itemCapacity = 40;
            this.health = 120.0F;
            this.engineOffset = 6.0F;
            this.hitSize = 8.0F;
            this.alwaysUnlocked = true;
            this.weapons.add(new Weapon(TechnoExpansion.name("small-basic-weapon-laser")) {
                {
                    {
                        this.reload = 10.0F;
                        this.x = 2.75F;
                        this.y = 0.5F;
                        this.top = false;
                        this.shootY = 2.0F;
                        this.alternate = false;
                        this.ejectEffect = Fx.none;
                        this.recoil = 2.0F;
                        this.shootSound = Sounds.lasershoot;
                        this.bullet = new LaserBoltBulletType(5.2F, 13.0F) {
                            {
                                this.lifetime = 30.0F;
                                this.healPercent = 5.0F;
                                this.collidesTeam = true;
                                this.backColor = Pal.heal;
                                this.frontColor = Color.white;
                            }
                        };
                    }
                }
            });
        }};
    }
}
