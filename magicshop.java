package commands;

import java.util.*;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class magicshop extends ListenerAdapter{
    private static final EnumSet<Items> enumSet = EnumSet.allOf(Items.class);

    enum Items {

        BagofHolding("Bag of Holding", 101, 500,true),
        BootsofFalseTracks("Boots of False Tracks", 50,100,false),
        BottleofBoundlessCoffee("Bottle of Boundless Coffee", 50,100,false),
        BreathingBubble("Breathing Bubble", 50,100,false),
        ChestofPreserving("Chest of Preserving", 50,100,false),
        CloakofBillowing("Cloak of Billowing", 50,100,false),
        ClockworkAmulet("Clockwork Amulet", 50,100,false),
        ClothesofMendin("Clothes of Mending", 50,100,false),
        CuddlyStrixhavenMascot("Cuddly Strixhaven Mascot", 50,100,false),
        EarHornofHearing("Ear Horn of Hearing", 50,100,false),
        EnduringSpellbook("Enduring Spellbook", 50,100,false),
        EverbrightLantern( "Everbright Lantern", 50,100,false),
        Glamerweavecommon("Glamerweave", 50,100,false),
        Glamerweaveuncommon("Glamerweave", 101,500,false),
        HatofWizardry( "Hat of Wizardry", 300,301,true),
        HewardsHandySpicePouch("Heward's Handy Spice Pouch", 20,70,false),
        InstrumentofIllusions("Instrument of Illusions", 20,70,true),
        InstrumentofScribing("Instrument of Scribing", 20,70,true),
        Keycharm("Keycharm", 50,100,true),
        LanternofTracking("Lantern of Tracking", 50,100,false),
        CloakofManyFashions("Cloak of Many Fashions", 50,100,false),
        MindCrystalCareful("Mind Crystal (Careful)",101,500,false),
        MindCrystalDistant("Mind Crystal (Distant)",101,500,false),
        MindCrystalEmpowered("Mind Crystal (Empowered)",101,500,false),
        MindCrystalExtended("Mind Crystal (Extended)",101,500,false),
        MindCrystalHeightened("Mind Crystal (Heightened)",501,5000,false),
        MindCrystalQuickened("Mind Crystal (Quickened)",501,5000,false),
        MindCrystalSubtle("Mind Crystal (Subtle)",50,100,false),
        MedalofWit("Medal of Wit",50,100,false),
        MoonTouchedSword("Moon Touched Sword",20,70,false),
        MysteryKey("Mystery Key",50,100,false),
        AmuletofProofAgainstDetectionandLocation("Amulet of Proof Against Detection and Location",101,500,true),
        ArcaneGrimoire1("Arcane Grimoire +1",101,500, true),
        ArcaneGrimoire2("Arcane Grimoire +2",501,5000,true),
        ArcaneGrimoire3("Arcane Grimoire +3",5001,50000,true),
        BagofTricksgray("Bag of Tricks (Gray)",101,500,false),
        BagofTricksrust("Bag of Tricks (Rust)",101,500,false),
        BagofTrickstan("Bag of Tricks (Tan)",101,500,false),
        BalanceofHarmony("Balance of Harmony",101,500,false),
        BalloonPack("Balloon Pack",101,500,false),
        BarrierTattoouncommon("Barrier Tattoo (uncommon)",101,500,true),
        BarrierTattoorare("Barrier Tattoo (rare)",12000,15000,true),
        BarrierTattooveryrare("Barrier Tattoo (very rare)",24000,30000,true),
        BlastedGoggles("Blasted Goggles",101,500,true),
        BloodwellVial1("BloodwellVial +1",101,500,true),
        BloodwellVial2("BloodwellVial +2",501,5000,true),
        BloodwellVial3("BloodwellVial +3",5001,50000,true),
        BootsofElvenkind("Boots of Elvenkind",101,500,false),
        BootsofStridingandSpringing("Boots of Striding and Springing",101,500,true),
        BootsoftheWinterlands("Boots of the Winterlands",101,500,true),
        BracersofArchery("Bracers of Archery",101,500,true),
        BroochofLivingEssence("Brooch of Living Essence",101,500,true),
        BroochofShielding("Brooch of Shielding",101,500,true),
        BroomofFlying("Broom of Flying",101,500,false),
        CapofWaterBreathing("Cap of Water Breathing",500,5000,false),
        CircletofBlasting("Circlet of Blasting",101,500,false),
        CloakofElvenkind("Cloak of Elvenkind",101,500,true),
        CloakofProtection("Cloak of Protection",101,500,true),
        CloakoftheMantaRay("Cloak of the MantaRay",101,500,false),
        CoilingGraspTattoo("Coiling Grasp Tattoo",101,500,true),
        DecanterofEndlessWater("Decanter of Endless Water",101,500,false),
        DeckofIllusions("Deck of Illusions",101,500, false),
        DeckOfWonder("Deck Of Wonder",201,500,false),
        DragonVesseluncommon("Dragon Vessel (Slumbering)",101,500,true),
        DragonVesselrare("Dragon Vessel (Stirring)",501,5000,true),
        DragonVesselveryrare("Dragon Vessel (Wakened)",5001,50000,true),
        DragonVesselLegendary("Dragon Vessel (Ascendant)",50001,100000,true),
        DragonhideBelt1("DragonhideBelt +1",101,500,false),
        DragonhideBelt2("DragonhideBelt +2",501,5000,false),
        DragonhideBelt3("DragonhideBelt +3",5001,50000,false),
        DragonsWrathWeaponuncommon("Dragons Wrath Weapon (Slumbering)",101,500,true),
        DragonsWrathWeaponrare("Dragons Wrath Weapon (Stirring)",501,5000,true),
        DragonsWrathWeaponveryrare("Dragons Wrath Weapon (Wakened)",5001,50000,true),
        DragonsWrathWeaponlegendary("Dragons Wrath Weapon (Ascendant)",50001,100000,true),
        DragonTouchedFocuscommon("Dragon Touched Focus (Slumbering)",101,500,true),
        DragonTouchedFocusrare("Dragon Touched Focus (Stirring)",501,5000,true),
        DragonTouchedFocusveryrare("Dragon Touched Focus (Wakened)",5001,50000,true),
        DragonTouchedFocuslegendary("Dragon Touched Focus (Ascendant)",50001,100000,true),
        Driftglobe("Driftglobe",101,500, false),
        DustofDisappearance("Dust of Disappearance",101,500,false),
        DustofDryness("Dust of Dryness",101,500,false),
        DustofSneezingandChoking("Dust of Sneezing and Choking",101,500,false),
        EldritchClawTattoo("Eldritch Claw Tattoo",101,500,true),
        ElementalGem("Elemental Gem",101,500,false),
        EversmokingBottle("Eversmoking Bottle",101,500,false),
        EyesofCharming("Eyes of Charming",101,500,true),
        EyesofMinuteSeeing("Eyes of Minute Seeing",101,500,false),
        EyesoftheEagle("Eyes of the Eagle",101,500,true),
        FeywildShard("Feywild Shard",101,500,true),
        FigurineofWondrousPowergriffon("Figurine of Wondrous Power (Bronze Griffon)",501,5000,false),
        FigurineofWondrousPowerfly("Figurine of Wondrous Power (Ebony Fly)",501,5000,false),
        FigurineofWondrousPowerlions("Figurine of Wondrous Power (Golden Lions)",501,5000,false),
        FigurineofWondrousPowergoats("Figurine of Wondrous Power (Ivory Goats)",501,5000,false),
        FigurineofWondrousPowerelephant("Figurine of Wondrous Power (Marble Elephants)",501,5000,false),
        FigurineofWondrousPowersteed("Figurine of Wondrous Power (Obsidian Steed)",5001,50000,false),
        FigurineofWondrousPowerdog("Figurine of Wondrous Power (Onyx Dog)",501,5000,false),
        FigurineofWondrousPowerowl("Figurine of Wondrous Power (Serpentine Owl)",501,5000,false),
        FigurineofWondrousPowerraven("Figurine of Wondrous Power (Silver Raven)",101,500,false),
        GauntletsofOgrePower("Gauntlets of Ogre Power",101,500,true),
        GemofBrightness("Gem of Brightness",101,500,false),
        GlovesofMissileSnaring("Gloves of Missile Snaring",101,500,true),
        GlovesofSwimmingandClimbing("Gloves of Swimming and Climbing",101,500,true),
        GlovesofThievery("Gloves of Thievery",101,500,false),
        GogglesofNight("Goggles of Night",101,500,false),
        GuardianEmblem("Guardian Emblem",101,500,true),
        HatofDisguise("Hat of Disguise",101,500,true),
        HeadbandofIntellect("Headband of Intellect",101,500,true),
        HelmofComprehendingLanguages("Helm of Comprehending Languages",101,500,false),
        HelmofTelepathy("Helm of Telepathy",101,500,true),
        HelmofBrilliance("Helm of Brilliance",5001,50000,true),
        ImmovableRod("Immovable Rod",101,500,false),
        InstrumentoftheBardsanstruthharp("Instrument of the Bards (Anstruth Harp)",5001,50000,true),
        InstrumentoftheBardsmandolin("Instrument of the Bards (Canaith Mandolin)",501,5000,true),
        InstrumentoftheBardslyre("Instrument of the Bards (Cil Lyre)",501,5000,true),
        InstrumentoftheBardslute("Instrument of the Bards (Doss Lute)",101,500,true),
        InstrumentoftheBardsbandore("Instrument of the Bards(Fochlucan Bandore)",101,500,true),
        InstrumentoftheBardsollamhharp("Instrument of the Bards (Ollamh Harp)",50000,100000,true),
        JavelinofLightning("Javelin of Lightning",101,500,false),
        Restorativeointment("Restorative Ointment",101,500,false),
        LanternofRevealing("Lantern of Revealing",101,500,false),
        MarinersArmor("Mariner's Armor",101,500,false),
        MedallionofThoughts("Medallion of Thoughts",101,500,true),
        MoonSickle1("Moon Sickle +1",101,500,true),
        MoonSickle2("Moon Sickle +2",501,5000,true),
        MoonSickle3("Moon Sickle +3",5001,50000,true),
        NaturesMantle("Nature's Mantle",101,500,true),
        NecklaceofAdaptation("Necklace of Adaptation",101,500,true),
        OilofSlipperiness("Oil of Slipperiness",101,500,false),
        PearlofPower("Pearl of Power",101,500,true),
        PeriaptofHealth("Periapt of Health ",101,500,true),
        PeriaptofWoundClosure("Periapt of Wound Closure",101,500,true),
        PipesofHaunting("Pipes of Haunting",101,500,false),
        PipesoftheSewers("Pipes of the Sewers",101,500,true),
        PotionofAcidResistance("Potion of Acid Resistance",101,500,false),
        PotionofAnimalFriendship("Potion of Animal Friendship",101,500,false),
        PotionofClairvouance("Potion of Clairvouance",501,5000,false),
        PotionofClimbing("Potion of Climbing",50,100,false),
        PotionofCloudGiantStrength("Potion of Cloud Giant Strength",5001,50000,false),
        PotionofColdResistance("Potion of Cold Resistance",101,500,false),
        PotionofDiminution("Potion of Diminution",501,5000,false),
        PotionofFireResistance("Potion of Fire Resistance",101,500,false),
        PotionofFireBreath("Potion of FireBreath",101,500,false),
        PotionofFlying("Potion of Flying",5001,50000,false),
        PotionofFireGiantStrength("Potion of Fire Giant Strength",501,5000,false),
        PotionofForceResistance("Potion of Force Resistance",101,500,false),
        PotionofFrostGiantStrength("Potion of Frost Giant Strength",501,5000,false),
        PotionofGaseousForm("Potion of Gaseous Form",501,5000,false),
        PotionofGrowth("Potion of Growth",101,500,false),
        PotionofHealing("Potion of Healing",51,100,false),
        PotionofGreaterHealing("Potion of Greater Healing",101,500,false),
        PotionofSuperiorHealing("Potion of Superior Healing",501,5000,false),
        PotionofSupremeHealing("Potion of Supreme Healing",5001,50000,false),
        PotionofHeroism("Potion of Heroism",501,5000,false),
        PotionofHillGiantStrength("Potion of Hill Giant Strength",101,500,false),
        PotionofInvisibility("Potion of Invisibility",5001,50000,false),
        PotionofLightningResistance("Potion of Lightning Resistance",101,500,false),
        PotionofMindReading("Potion of Mind Reading",501,5000,false),
        PotionofNecroticResistance("Potion of Necrotic Resistance",101,500,false),
        PotionofPoison("Potion of Poison",101,500,false),
        PotionofPoisonResistance("Potion of Poison Resistance",101,500,false),
        PotionofPsychicResistance("Potion of Psychic Resistance",101,500,false),
        PotionofRadiantResistance("Potion of Radiant Resistance",101,500,false),
        PotionofWaterBreathing("Potion of Water Breathing",101,500,false),
        PotionofSpeed("Potion of Speed",5001,50000,false),
        PotionofStoneGiantStrength("Potion of Stone Giant Strength",501,5000,false),
        PotionofStormGiantStrength("Potion of Storm Giant Strength",50001,100000,false),
        PotionofThunderResistance("Potion of Thunder Resistance",101,500,false),
        QuiverofEhlonna("Quiver of Ehlonna",101,500,false),
        EfficientQuiver("Efficient Quiver",101,500,false),
        RingofJumping("Ring of Jumping",101,500,true),
        RingofMindShielding("Ring of Mind Shielding",101,500,true),
        RingofSwimming("Ring of Swimming",101,500,false),
        RingofWarmth("Ring of Warmth",101,500,true),
        RingofWaterWalking("Ring of Water Walking",101,500,false),
        RingofAcidResistance("Ring of Acid Resistance",501,5000,true),
        RingofAirElementalCommand("Ring of Air Elemental Command",50001,100000,true),
        RingofAnimalInfluence("Ring of Animal Influence",501,5000,false),
        RingofColdResistance("Ring of Cold Resistance",501,5000,true),
        RingofDjinniSummoning("Ring of Djinni Summoning",50001,100000,true),
        RingofEarthElementalCommand("Ring of Earth Elemental Command",50001,100000,true),
        RingofEvasion("Ring of Evasion",501,5000,true),
        RingofFeatherFalling("Ring of Feather Falling",501,5000,true),
        RingofFireElementalCommand("Ring of Fire Elemental Command",50001,100000,true),
        RingofFireResistrance("Ring of Fire Resistrance",501,5000,true),
        RingofForceResistrance("Ring of Force Resistrance",501,5000,true),
        RingofFreaction("Ring of Free action",501,5000,true),
        RingofInvisibility("Ring of Invisibility",50001,100000,true),
        RingofLightningResistance("Ring of Lightning Resistance",501,5000,true),
        RingofNecroticResistance("Ring of Necrotic Resistance",501,5000,true),
        RingofPoisonResistance("Ring of Poison Resistance",501,5000,true),
        RingofProtection("Ring of Protection",501,5000,true),
        RingofPsychicResistance("Ring of Psychic Resistance",501,5000,true),
        RingofRadiantResistance("Ring of Radiant Resistance",501,5000,true),
        RingofRegeneration("Ring of Regeneration",5001,50000,true),
        RingofShootingStars("Ring of Shooting Stars",5001,50000,false),
        RingofSpellStoring("Ring of Spell Storing",501,5000,true),
        RingofSpellTurning("Ring of Spell Turning",50001,100000,true),
        RingofTelekinesis("Ring of Telekinesis",5001,50000,true),
        RingoftheRam("Ring of the Ram",501,5000,true),
        RingofThreeWishes("Ring of Three Wishes",50001,100000,false),
        RingofThunderResistance("Ring of Thunder Resistance",501,5000,true),
        RingofWaterElementalCommand("Ring of Water Elemental Command ",50001,100000,true),
        RingofXrayVision("Ring of X-ray Vision",501,5000,true),
        RobeofUsefulItems("Robe of Useful Items",101,500,false),
        RobeofScintillatingColors("Robe of Scintillating Colors",501,5000,true),
        RobeofStars("Robe of Stars",5001,50000,true),
        RodofthePactKeeper1("Rod of the Pact Keeper +1",101,500,true),
        RodofthePactKeeper2("Rod of the Pact Keeper +2",501,5000,true),
        RodofthePactKeeper3("Rod of the Pact Keeper +3",5001,50000,true),
        RopeofClimbing("Rope of Climbing",101,500,false),
        RopeofEntanglement("Rope of Entanglement",501,5000,false),
        SaddleoftheCavalier("Saddle of the Cavalier",101,500,false),
        SendingStones("Sending Stones",101,500,false),
        SentinelShield("Sentinel Shield",101,500,false),
        AnimatedShield("Animate Shield",5001,50000,true),
        ArrowCatchingShield("Arrow-Catching Shield",501,5000,true),
        ShieldofMissileAttraction("Shield of Missile Attraction",501,5000,true),
        Shield1("Shield +1",101,500,false),
        Sheild2("Shield +2",501,5000,false),
        Sheild3("Shield +3",5001,50000,false),
        SpellguardShield("Spellguard Shield",5001,50000,true),
        SlippersofSpiderClimbing("Slippers of Spider Climbing",101,500,true),
        SpellScroll0("SpellScroll Cantrip",10,50,false),
        SpellScroll1("SpellScroll level 1",10,50,false),
        SpellScroll2("SpellScroll level 2",51,100,false),
        SpellScroll3("SpellScroll level 3",51,100,false),
        SpellScroll4("SpellScroll level 4",101,5000,false),
        SpellScroll5("SpellScroll level 5",101,5000,false),
        SpellScroll6("SpellScroll level 6",5001,50000,false),
        SpellScroll7("SpellScroll level 7",5001,50000,false),
        SpellScroll8("SpellScroll level 8",5001,50000,false),
        SpellScroll9("SpellScroll level 9",50000,100000,false),
        StaffoftheAdder("Staff of the Adder",101,500,true),
        StaffofthePython("Staff of the Python",101,500,true),
        StaffofCharming("Staff of Charming",501,5000,false),
        StaffofFire("Staff of Fire",5001,50000,true),
        StaffofFrost("Staff of Frost",5001,50000,true),
        StaffofHealing("Staff of Healing",5001,50000,true),
        StaffofPower("Staff of Power",5001,50000,true),
        StaffofStriking("Staff of Striking",5001,50000,true),
        StaffofSwarmingInsects("Staff of Swarming Insects",501,5000,true),
        StaffofMagi("Staff of Magi",50001,100000,true),
        StaffofWoodlands("Staff of Woodlands",501,5000,true),
        StaffofThunderandLightning("Staff of Thunder and Lightning",5001,50000,true),
        StaffofWithering("Staff of Withering",501,5000,true),
        StoneofGoodLuck("Stone of GoodLuck",101,500,true),
        StoneofControllingEarthElementals("Stone of Controlling Earth Elementals",501,5000,true),
        SwordofVengeance("Sword of Vengeance",101,500,true),
        TridentofFishCommand("Trident of Fish Command",101,500,true),
        WandofMagicDetection("Wand of Magic Detection",101,500,false),
        WandofMagicMissiles("Wand of Magic Missiles",101,500,false),
        WandofSecrets("Wand of Secrets",101,500,false),
        WandoftheWarMage1("Wand of the War Mage +1",101,500,true),
        WandoftheWarMage2("Wand of the War Mage +2",501,5000,true),
        WandoftheWarMage3("Wand of the War Mage +3",5001,50000,true),
        WandofBinding("Wand of Binding",501,5000,true),
        WandofEnemyDetection("Wand of Enemy Detection",501,5000,true),
        WandofFear("Wand of Fear",501,5000,true),
        WandofFireballs("Wand of Fireballs",501,5000,true),
        WandofLightningBolts("Wand of Lightning Bolts",501,5000,true),
        WandofParalysis("Wand of Paralysis",501,5000,true),
        WandofPolymorph("Wand of Polymorph",5001,50000,true),
        WandofWeb("Wand of Web",101,500,true),
        WandofWonder("Wand of Wonder",501,5000,true),
        Weapon1("Any Weapon+ 1",101,500,false),
        Weapon2("Any Weapon+ 2",501,5000,false),
        Weapon3("Any Weapon+ 3",5001,50000,false),
        WeaponofWarning("Weapon of Warning",101,500,true),
        WindFan("Wind Fan",101,500,false),
        WingedBoots("Winged Boots",101,500,true),
        AlchemicalCompendium("Alchemical Compendium",501,5000,true),
        AllPurposeTool1("All Purpose Tool +1",101,500,true),
        AllPurposeTool2("All Purpose Tool +2",501,5000,true),
        AllPurposeTool3("All Purpose Tool +3",5001,50000,true),
        Ammunition1("Ammunition +1",101,500,false),
        Ammunition2("Ammunition +2",501,5000,false),
        Ammunition3("Ammunition +3",5001,50000,false),
        AmuletofHealth("Amulet of Health",501,5000,true),
        AmuletoftheDevout1("Amulet of the Devout +1",101,500,true),
        AmuletoftheDevout("Amulet of the Devout +2",501,5000,true),
        AmuletoftheDevout3("Amulet of the Devout +3",5001,50000,true),
        ArmorofResistance("Armor of Resistance (type)",501,5000,true),
        ArmorofVulnerability("Armor of Vulnerability",501,5000,true),
        AstralShard("Astral Shard",501,5000,true),
        AstromancyArchive("Astromancy Archive",501,5000,true),
        AtlasofEndlessHorizons("Atlas of Endless Horizons",501,5000,true),
        BagofBeans("Bag of Beans",101,500,false),
        BeadofForce("Bead of Force",501,5000,false),
        BellBranch("Bell Branch",501,5000,true),
        BeltofDwarvenkind("Belt of Dwarvenkind",501,5000,true),
        BeltofCloudGiantStrength("Belt of Cloud Giant Strength",50001,100000,true),
        BeltofFireGiantStrength("Belt of Fire Giant Strength",5001,50000,true),
        BeltofFrostGiantStrength("Belt of Frost Giant Strength",5001,50000,true),
        BeltofHillGiantStrength("Belt of Hill Giant Strength",501,5000,true),
        BeltofStoneGiantStrength("Belt of Stone Giant Strength",5001,50000,true),
        BeltofStormGiantStrength("Belt of Storm Giant Strength",50001,100000,true),
        BerserkerAxe("Berserker Axe",501,5000,true),
        BootsofLevitation("Boots of Levitation",501,5000,true),
        BootsofSpeed("Boots of Speed",501,5000,true),
        BowlofCommandingWaterElementals("Bowl of Commanding Water Elementals",501,5000,false),
        BracersofDefense("Bracers of Defense",501,5000, true),
        BrazierofCommandingFireElementals("Brazier of Commanding Fire Elementals",501,5000,false),
        CapeoftheMountebank("Cape of the Mountebank",501,5000, false),
        CenserofControllingAirElementals("Censer of Controlling Air Elementals ",501,5000,false),
        ChimeofOpening("Chime of Opening",501,5000,false),
        CloakofDisplacement("Cloak of Displacement",501,5000,true),
        CloakoftheBat("Cloak of the Bat",501,5000,true),
        CubeofForce("Cube of Force",501,5000,true),
        DaernsInstantFortress("Daern's Instant Fortress",501,5000,false),
        DaggerofVenom("Dagger of Venom",501,5000,false),
        DevoteesCenser("Devotee Censer",501,5000,true),
        DimensionalShackles("Dimensional Shackles",501,5000,false),
        DragonSlayerWeapon("Any Dragon Slayer Weapon",501,5000,false),
        ElixirofHealth("Elixir of Health",501,5000,false),
        ElvenChain("Elven Chain",501,5000,false),
        FarRealmShard("Far Realm Shard",501,5000,true),
        FlameTongue("Flame Tongue",501,5000,true),
        FoldingBoat("Folding Boat",501,5000,true),
        GemofSeeing("Gem of Seeing",501,5000,true),
        GiantSlayer("Any Giant Slayer Weapon",501,5000,true),
        GlamouredStuddedLeather("Glamoured Studded Leather",501,5000,false),
        HelmofTeleportation("Helm of Teleportation",501,5000,true),
        HewardsHandyHaversack("Heward's Handy Haversack",501,5000,false),
        HornofBlasting("Horn of Blasting",501,5000,false),
        HornofValhallabrass("Horn of Valhalla (Brass)",501,5000,false),
        HornofValhallabronze("Horn of Valhalla (Bronze)",5001,50000,false),
        HornofValhallairon("Horn of Valhalla (Iron)",50001,100000,false),
        HornofValhallasilver("Horn of Valhalla (Silver)",501,5000,false),
        HorseshoesofSpeed("Horseshoes of Speed",501,5000,false),
        IounStoneabsorbtion("Ioun Stone, Absorption",5001,50000,true),
        IounStoneagility("Ioun Stone, Agility",5001,50000,true),
        IounStoneawareness("Ioun Stone, Awareness",501,5000,true),
        IounStonefortitude("Ioun Stone, Fortitude",5001,50000,true),
        IounStonegreaterabsorption("Ioun Stone, Greater Absorption",50001,100000,true),
        IounStoneinsight("Ioun Stone, Insight",5001,50000,true),
        IounStoneintellect("Ioun Stone, Intellect",5001,50000,true),
        IounStoneleadership("Ioun Stone, Leadership",5001,50000,true),
        IounStonemastery("Ioun Stone, Mastery",50001,100000,true),
        IounStoneprotection("Ioun Stone, Protection",501,5000,true),
        IounStoneregeneration("Ioun Stone, Regeneration",50001,100000,true),
        IounStonereserve("Ioun Stone, Reserve",501,5000,true),
        IounStonestrength("Ioun Stone, Strength",5001,50000,true),
        IounStonesustenance("Ioun Stone, Sustenance",501,5000,true),
        IronBandsofBilarro("Iron Bands of Bilarro",501,5000,false),
        LyreofBuilding("Lyre of Building",501,5000,true),
        MaceofDisruption("Mace of Distruption",501,5000,true),
        MaceofSmiting("Mace of Smiting",501,5000,false),
        MaceofTerror("Mace of Terror",501,5000,false),
        MantleofSpellResistance("Mantle of Spell Resistance",501,5000,true),
        NecklaceofFireballs("Necklace of Fireballs",501,5000,false),
        NecklaceofPrayerBeads("Necklace of Prayer Beads",501,5000,true),
        OilofEtherealness("Oil of Etherealness",501,5000,false),
        OuterEssenceShard("Outer Essence Shard",501,5000,true),
        PeriaptofProofagainstPoison("Periapt of Proof against Poison",501,5000,false),
        PlanecallersCodex("Planecallers Codex",501,5000,true),
        PortableHole("Portable Hole",501,5000,false),
        PotionofClairvoyance ("Potion of Clairvoyance",501,5000,false),
        PotionofInvulnerability("Potion of Invulnerability",501,5000,false),
        ProtectiveVerses("Protective Verses",501,5000,true),
        QuaalsFeatherToken("Quaal's Feather Token",50,100,false),
        QuaalsFeatherTokenAnchor("Quaal's Feather Token, Anchor",501,5000,false),
        QuaalsFeatherTokenBird("Quaal's Feather Token, Bird",501,5000,false),
        QuaalsFeatherTokenFan("Quaal's Feather Token, Fan",501,5000,false),
        QuaalsFeatherTokenTree("Quaal's Feather Token, Tree",501,5000,false),
        QuaalsFeatherTokenWhip("Quaal's Feather Token, WHip",501,5000,false),
        QuaalsFeatherTokenSwanBoat("Quaal's Feather Token, Swan Boat",501,5000,false),
        RevelersConcertina("Reveler's Concertina",501,5000,true),
        RingofFreeAction("Ring of Free Action",501,5000,true),
        RobeofEyes("Robe of Eyes",501,5000,true),
        RodofRulership("Rod of Rulership",501,5000,true),
        ShadowfellBrandTattoo("Shadowfell Brand Tatto",501,5000,true),
        ShadowfellShard("Shadowfell Shard",501,5000,true),
        SpellwroughtTattoo0("Spellwrought Tatto Cantrip",50,100,false),
        SpellwroughtTattoo1("Spellwrought Tatto 1st Level",50,100,false),
        SpellwroughtTattoo2("Spellwrought Tatto 2nd Level",101,500,false),
        SpellwroughtTattoo3("Spellwrought Tatto 3rd Level",101,500,false),
        SpellwroughtTattoo4("Spellwrought Tatto 4th Level",501,5000,false),
        SpellwroughtTattoo5("Spellwrought Tatto 5th Level",501,5000,false),
        StaffoftheWoodlands("Staff of the Woodlands",501,5000,true),
        SunBlade("Sun Blade",501,5000,true),
        SwordofLifeStealing("Sword of Life Stealing",501,5000,true),
        SwordofWounding("Sword of Wounding",501,5000,true),
        TentacleRod("Tentacle Rod",501,5000,true),
        ViciousWeapon("Any Vicious Weapon",501,5000,false),
        WandofViscidGlobs("Wand of Viscid Globs",501,5000,true),
        WandofWinter("Wand of Winter",501,5000,true),
        WingsofFlying("Wings of Flying",501,5000,true),
        AbsorbingTattoo("Absorbing Tatto",5001,50000,true),
        AmuletofthePlanes("Amulet of the Planes",5001,50000,true),
        ArrowofSlaying("Arrow of Slaying",5001,50000,false),
        BagofDevouring("Bag of Devouring",5001,50000,false),
        CandleofInvocation("Candle of Invocation",5001,50000,true),
        CarpetofFlying3x5("Carpet of Flying 3' X5'",5001,50000,false),
        CarpetofFlying4x6("Carpet of Flying 4' x 6'",5001,50000,false),
        CarpetofFlying5x7("Carpet of Flying 5' 7'",5001,50000,false),
        CarpetofFlying6x9("Carpet of Flying 6' 9'",5001,50000,false),
        CauldronofRebirth("Cauldron of Rebirth",5001,50000,true),
        CloakofArachnida("Cloak of Arachnida",5001,50000,true),
        CrystalBall("Crystal Ball",5001,50000,true),
        CrystallineChronicle("Crystalline Chronicle",5001,50000,true),
        DemonArmor("Demon Armor",5001,50000,true),
        DragonScaleMail("Dragon Scale Mail (each type)",5001,50000,true),
        DwarvenPlate("Dwarven Plate",5001,50000,false),
        DwarvenThrower("Dwarven Thrower",5001,50000,true),
        EfreetiBottle("Efreeti Bottle",5001,50000,false),
        FrostBrand("Frost Brand",5001,50000,true),
        HorseshoesofaZephyr("Horseshoes of a Zephyr",5001,50000,false),
        LifewellTattoo("Lifewell Tatto",5001,50000,true),
        ManualofBodilyHealth("Manual of bodily Health",5001,50000,false),
        ManualofGainfulExercise ("Manual of Gainful Exercise",5001,50000,false),
        ManualofGolemsClay("Manual of Golems (Clay)",5001,50000,false),
        ManualofGolemsFlesh("Manual of Golems (Flesh)",5001,50000,false),
        ManualofGolemsIron("Manual of Golems (Iron)",5001,50000,false),
        ManualofGolemsStone("Manual of Golems (Stone)",5001,50000,false),
        ManualofQuicknessofAction("Manual of Quickness of Action",5001,50000,false),
        MirrorofLifeTrapping("Mirror of Life Trapping",5001,50000,false),
        NineLivesStealer("Nine Lives Stealer",5001,50000,true),
        NolzursMarvelousPigments("NolzursMarelous Pigments",5001,50000,false),
        Oathbow("Oathbow",5001,50000,true),
        OilofSharpness("Oil of Sharpness",5001,50000,false),
        PotionofLongevity("Potion of Longevity",5001,50000,false),
        PotionofVitality("Potion of Vitality",5001,50000,false),
        RhythmMakersDrum1("Rhythm Makers Drum +1",101,500,true),
        RhythmMakersDrum2("Rhythm Makers Drum +2",501,5000,true),
        RhythmMakersDrum3("Rhythm Makers Drum +3",5001,50000,true),
        RodofAbsorption("Rod of Absorption",5001,50000,true),
        RodofAlertness("Rod of Alertness",5001,50000,true),
        RodofSecurity("Rod of Security",5001,50000,false),
        ScimitarofSpeed("Scimitar of Speed",5001,50000,true),
        SwordofSharpness("Sword of Sharpness",5001,50000,false),
        TomeofClearThought("Tome of Clear Thought",5001,50000,false),
        TomeofLeadershipandInfluence("Tome of Leadership and Influence",5001,50000,false),
        TomeofUnderstanding("Tome of Understanding",5001,50000,false),
        ;

        final String name;
        final int min, max;
        final boolean attunement;

        Items(String name, int min, int max, boolean attument) {
            this.name = name;
            this.min = min;
            this.max = max;
            this.attunement = attument;
        }

    }
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(event.getName().equals("magicshop")) {
            final OptionMapping mingoldMapping = event.getOption("mingold");
            final int mingoldinput = mingoldMapping == null ? 0 : mingoldMapping.getAsInt();
            final OptionMapping attuneMapping = event.getOption("requiresattunement");
            final String attuneinput = attuneMapping == null ? "False" : attuneMapping.getAsString();
            final boolean attunementvaule;
            int maxgold = event.getOption("maxgold").getAsInt();
            final int MAX_CONTENT_LENGTH = 2000;

            //probably need a hashmap for boolean result

            List<String> messages = new ArrayList<>();
            ArrayList<String> Itemarray = new ArrayList<>();
            StringBuilder builder = new StringBuilder();

           if(attuneinput.equals("True")){
               attunementvaule = true;
           } else if (attuneinput.equals("False")) {
               attunementvaule = false;
           }else {attunementvaule = false;}

            System.out.println("started magic shop command");
            event.deferReply(true).queue();

            if(mingoldinput > maxgold){
               event.getHook().sendMessage("ID.10T ERROR: Minimum gold (" + maxgold + ")" + " spent can't be higher than max gold(" + mingoldinput + ")" + " you want to spend. You truly are an adventurer...").setEphemeral(true).queue();
           }else{

                EnumSet<Items> validItems = EnumSet.noneOf(Items.class);
                enumSet.forEach(item -> {
                    if(!attunementvaule) {
                        if (item.min <= maxgold && mingoldinput < item.max) {
                            if(!item.attunement){ Itemarray.add(item.name + " " + item.min + "-" + item.max + "gp");}else{
                                Itemarray.add(item.name + " " + item.min + "-" + item.max + "gp. " + "(Requires Attunement)");
                            }

                        }
                    } else if (attunementvaule) {
                        if (item.min <= maxgold && item.attunement && mingoldinput < item.max) {
                            if(!item.attunement){ Itemarray.add(item.name + " " + item.min + "-" + item.max + "gp");}else{
                                Itemarray.add(item.name + " " + item.min + "-" + item.max + "gp. " + "(Requires Attunement)");
                            }
                        }
                    }
                });
            }

            if(Itemarray.isEmpty() && (maxgold > mingoldinput)){
                event.getHook().sendMessage("Not enought gold... cheapscape").setEphemeral(true).queue();
            }else {
                Collections.sort(Itemarray); //should sort arraylist (this is not an array)

                for (String item : Itemarray) {
                    if (builder.length() + item.length() + 1 > MAX_CONTENT_LENGTH && (maxgold > mingoldinput))  { // +1 for the new line
                        messages.add(builder.toString()); // Store new message since length is going to exceed
                        builder.setLength(0); // Clear builder
                    }
                    builder.append(item).append('\n');
                }
                messages.add(builder.toString()); // Add last message, as it was being built
                for (String message : messages) {
                    if(maxgold > mingoldinput) {
                        event.getHook().sendMessage(message).setEphemeral(true).complete();
                    }
                }
            }
                //printedText = printedText.substring(0, printedText.length() - 1);
                //printedText.join(", ", Itemarray); removes comma at the end

               // System.out.println(messages);

            //System.out.println("Ended magic shop command");
        }

    }

}

