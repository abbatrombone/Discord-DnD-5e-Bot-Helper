package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class recommendfeats extends ListenerAdapter {

    public static final EnumSet<Feats> enumSet = EnumSet.allOf(Feats.class);

    enum Feats{
        Actor("Actor","Utility","",true,"","Charisma"),
        Alert("Alert","Combat","",false,"",""),
        ArtificerInitiate("Artificer Initiate","Magic","",false,"",""),
        Athlete("Athlete","Movement","",true,"","Strength/Dexterity"),
        BountifulLuck("Bountiful Luck","Utility","Halfling",false,"",""),
        Cartomancer("Cartomancer","Utility","",false,"Spellcasting, Level 4",""),
        Charger("Charger","Combat","",false,"Strength/Dexterity 13+",""),
        Chef("Chef","Utility","",true,"","Constitution/Wisdom"),
        CrossbowExpert("Crossbow Expert","Combat","",false,"Dexterity 13+",""),
        Crusher("Crusher","Combat","",true,"","Strength/Constituion"),
        DefensiveDuelist("Defensive Duelist","Defensive","",false,"Dexterity 13+",""),
        DragonFear("Dragon Fear","Utility","Dragonborn",true,"","Strength/Constituion/Charisma"),
        DragonHide("Dragon Hide","Defensive","Dragonborn",true,"","Strength/Constituion/Charisma"),
        DrowHighMagic("Drow High Magic","Magic","Drow",false,"",""),
        DualWielder("Dual Wielder","Defensive","",false,"",""),
        DungeonDelver("Dungeon Delver","Utility","",false,"",""),
        Durable("Durable","Tank","",true,"","Consition"),
        DwarfFortitude("Dwarf Fortitude","Tank","Dwarf",false,"","Constitution"),
        EldritchAdept("Eldritch Adept","Magic","",false,"Spellcasting/Pact Magic",""),
        ElementalAdept("Elemental Adept","Magic/Combat","",false,"Can cast one Spell",""),
        ElvenAccuracy("Elven Accuracy","Combat","Elf/Half-Elf",true,"","Dexterity/Intelligence/Wisdom/Charisma"),
        EmberoftheFireGiant("Ember of the Fire Giant","Combat/Resistance","",true,"Level 4+, strike of the giants (fire strike)","Strength/Constitution/Wisdom"),
        Fadeaway("Fade Away","Defensive","Gnome",true,"","Dexterity/Intelligence"),
        FeyTeleportation("Fey Teleportation","Magic/Movement","High Elf",true,"","Intelligence/Charisma"),
        FeyTouched("Fey Touched","Magic/Movement","",true,"","Intelligence/Wisdom/Charisma"),
        FightingInitiate("Fighting Initiate","Combat/Defensive/Utility","",false,"Proficiency with a martial weapon",""),
        FlamesofPhlegethos("Flames of Phlegethos","Magic/Fire","Tiefling",true,"","Intelligence/Charisma"),
        FuryoftheFrostGiant("Fury of the Frost Giant","Combat/Resistance/Defensive","",false,"Level 4+, strike of the giants (frost strike)",""),
        GiftoftheChromaticDragon("Gift of the Chromatic Dragon","Combat/Defensive","",false,"",""),
        GiftoftheGemDragon("Gift of the Gem Dragon","Defensive","",true,"","Intelligence/Wisdom/Charisma"),
        GiftoftheMetallicDragon("Gift of the Metallic Dragon","Magic/Healing","",false,"",""),
        Grappler("Grappler","Combat","",false,"Strength 13+",""),
        GreatWeaponMaster("Great Weapon Master","Combat","",false,"",""),
        GuileoftheCloudGiant("Guile of the Cloud Giant","Defensive/Movement","",true,"Level 4+, strike of the giants (cloud strike)","Strength/Consitution/Charisma"),
        Gunner("Gunner","Combat","",true,"","Dexterity"),
        Healer("Healer","Healing","",false,"",""),
        HeavilyArmored("Heavily Armored","Defensive","",true,"Medium Armor Training","Strength"),
        HeavyArmorMaster("Heavy Armor Master","Defensive","",true,"Heavy Armor Training","Strength"),
        InfernalConstitution("Infernal Constitution","Defensive/Resistance","Tiefling",true,"","Constitution"),
        InspiringLeader("Inspiring Leader","Defensive","",false,"Charisma 13+",""),
        KeenMind("Keen Mind","Utility","",true,"","Intelligence"),
        KeennessoftheStoneGiant("Keenness of the Stone Giant","Combat","",true,"Prerequisites: Level 4+, strike of the giants (stone strike)","Strength/Constitution/Wisdom"),
        LightlyArmored("Lightly Armored","Defensive","",true,"","Strength/Dexerity"),
        Linguist("Linguist","Utility","",true,"","Intelligence"),
        Lucky("Lucky","Utility","",false,"",""),
        MageSlayer("Mage Slayer","Combat/Defensive","",false,"",""),
        MagicInitiate("Magic Initiate","Magic","",false,"",""),
        MartialAdept("Martial Adept","Combat/Utility","",false,"",""),
        MediumArmorMaster("Medium Armor Master","Defensive","",false,"Medium Armor Training",""),
        MetamagicAdept("Meta magic Adept","Magic","",false,"Spellcasting or Pact Magic Feature",""),
        Mobile("Mobile","Movement","",false,"",""),
        ModeratelyArmored("Moderately Armored","Defensive","",true,"Light Armor Training","Strength/Dexterity"),
        MountedCombatant("Mounted Combatant","Combat/Defensive","",false,"",""),
        Observant("Observant","Utility","",true,"","Intelligence/Wisdom"),
        OrcishFury("Orcish Fury","Combat","Half-Orc",true,"","Strength/Constitution"),
        Piercer("Piercer","Combat","",true,"","Strength/Dexterity"),
        Poisoner("Poisoner","Combat","",false,"",""),
        PolearmMaster("Polearm Master","Combat","",false,"",""),
        Prodigy("Prodigy","Utility","Half-Elf, Half-orc, or Human",false,"",""),
        Resilient("Resilient","Defensive","",true,"","Strength/Dexterity/Constitution/Intelligence/Wisdom/Charisma"),
        RitualCaster("RitualCaster","Utility","",false,"Intelligence or Wisdom 13+",""),
        RuneShaper("Rune Shaper","Magic/Utility/Healing","",false,"Spellcasting Feature or Rune Carver",""),
        SavageAttacker("Savage Attacker","Combat","",false,"",""),
        SecondChance("Second Chance","Utility","Halfling",true,"","Dexterity/Constitution/Charisma"),
        Sentinel("Sentinel","Defensive","",false,"",""),
        ShadowTouched("Shadow Touched","Magic","",true,"","Intelligence/Wisdom/Charisma"),
        Sharpshooter("Sharpshooter","Combat","",false,"",""),
        ShieldMaster("ShieldMaster","Defensive","",false,"",""),
        SkillExpert("Skill Expert","Utility","",true,"","Strength/Dexterity/Constitution/Intelligence/Wisdom/Charisma"),
        Skilled("Skilled","Utility","",false,"",""),
        Skulker("Skulker","Utility/Stealth","",false,"Dexterity 13+",""),
        Slasher("Slasher","Combat/Utility","",true,"","Strength/Dexterity"),
        SouloftheStormGiant("Soul of the Storm Giant","Defensive/Resistance","",true,"Level 4+, strike of the giants (storm strike)","Strength/Wisdom/Charisma"),
        SpellSniper("Spell Sniper","Combat/Magic","",false,"The ability to cast at least one spell",""),
        SquatNimbleness("Squat Nimbleness","Movement/Defensive","Dwarf or a Small race",true,"","Strength/Dexterity"),
        StrikeoftheGiants("Strike of the Giants","Combat","",false,"Martial Proficiency or Giant Foundling",""),
        TavernBrawler("Tavern Brawler","Combat","",true,"","Strength/Constitution"),
        Telekinetic("Telekinetic","Magic/Utility","",true,"","Intelligence/Wisdom/Charisma"),
        Telepathic("Telepathic","Magic/Utility","",true,"","Intelligence/Wisdom/Charisma"),
        Tough("Tough","Defensive","",false,"",""),
        VigoroftheHillGiant("Vigor of the Hill Giant","Defensive/Healing","",true,"Level 4+, strike of the giants (hill strike)","Strength/Constitution/Wisdom"),
        WarCaster("War Caster","Combat","",false,"he ability to cast at least one spell",""),
        WeaponMaster("Weapon Master","Combat","",true,"","Strength/Dexterity"),
        WoodElfMagic("Wood Elf Magic","Magic/Utility","Elf (wood)",false,"",""),
        ;

        final String feat;
        final String type;
        final String race;
        final boolean halffeat;
        final String requirements;
        final String statboost;

        Feats(String feat, String type, String race, boolean halffeat, String requirements,String statboost) {
            this.feat = feat;
            this.type = type;
            this.race = race;
            this.halffeat = halffeat;
            this.requirements = requirements;
            this.statboost = statboost;
        }
    }
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("recommendedfeats")){
            ArrayList<String> featArray = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            List<String> messages = new ArrayList<>();

            OptionMapping typemapping = event.getOption("type");
            OptionMapping racemap = event.getOption("race");
            OptionMapping halffeatStringMap = event.getOption("halffeat");
            OptionMapping statboostmap = event.getOption("stat");

            final String type = typemapping == null ? "" : typemapping.getAsString();
            final String race = racemap == null ? "" : racemap.getAsString();
            final String statboost = statboostmap == null ? "" : statboostmap.getAsString();
            final String halffeatmap = halffeatStringMap == null ? "False" : halffeatStringMap.getAsString();
            Boolean halffeat;
            if(halffeatmap.equals("True")){halffeat = true;}else{halffeat = false;}

            final int MAX_CONTENT_LENGTH = 2000;

            event.deferReply(true).queue();
            EnumSet<Feats> Feats = EnumSet.noneOf(Feats.class);
            enumSet.forEach( feats -> {

                if(!type.isEmpty() && race.isEmpty() && statboost.isEmpty() && !halffeat){
                    if(feats.type.contains(type)){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                }else if (!type.isEmpty() && race.isEmpty() && statboost.isEmpty() && halffeat){
                    if(feats.type.contains(type) && feats.halffeat){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                }else if (!type.isEmpty() && race.isEmpty() && !statboost.isEmpty() && !halffeat) {
                    if(feats.type.contains(type) && feats.statboost.contains(statboost)){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                }else if (!type.isEmpty() && race.isEmpty() && !statboost.isEmpty() && halffeat) {
                    if(feats.type.contains(type) && feats.statboost.contains(statboost) && feats.halffeat){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                }else if (!type.isEmpty() && !race.isEmpty() && statboost.isEmpty() && !halffeat) {
                    if(feats.type.contains(type) && feats.race.contains(race)){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                }else if(!type.isEmpty() && !race.isEmpty() && statboost.isEmpty() && halffeat){
                    if(feats.type.contains(type) && feats.race.contains(race) && feats.halffeat){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                }else if(type.isEmpty() && !race.isEmpty() && statboost.isEmpty() && !halffeat){
                    if(feats.race.contains(race)){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                }else if(type.isEmpty() && !race.isEmpty() && statboost.isEmpty() && halffeat) {
                    if(feats.race.contains(race) && feats.halffeat){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                }else if(type.isEmpty() && !race.isEmpty() && !statboost.isEmpty() && !halffeat) {
                    if(feats.race.contains(race) && feats.statboost.contains(statboost)){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                }else if (type.isEmpty() && !race.isEmpty() && !statboost.isEmpty() && halffeat) {
                    if(feats.race.contains(race) && feats.statboost.contains(statboost) && halffeat){
                        featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");
                    }
                } else if (type.isEmpty() && race.isEmpty() && !statboost.isEmpty() && halffeat) {
                    featArray.add("Feat Name: " + feats.feat + "\nPrerequisite: " + feats.requirements + "\nType: " + feats.type + "\nRace: " + feats.race + "\nStat Boost: " + feats.statboost + "\n");

                } else if (type.isEmpty() && race.isEmpty() && !statboost.isEmpty() && !halffeat) {
                    featArray.add("A half feat gives you +1 to a stat, and a feat abiltiy. So this isnt a possiable combo");
                }else{featArray.add("You got to the end of the logic, something wasnt covered please send a bug report with \"\\reportbug\" and what you entered into the command. Thanks!");}

            });
            List<String> uniqueFeatsList = featArray.stream().distinct().collect(Collectors.toList());

            if(uniqueFeatsList.isEmpty()){
                event.getHook().sendMessage("No results found :(").setEphemeral(true).queue();
            }else {
                for (String feat : uniqueFeatsList) {
                    if (builder.length() + feat.length() + 1 > MAX_CONTENT_LENGTH)  { // +1 for the new line
                        messages.add(builder.toString()); // Store new message since length is going to exceed
                        builder.setLength(0); // Clear builder
                    }
                    builder.append(feat).append('\n');
                }
                messages.add(builder.toString()); // Add last message, as it was being built
                for (String message : messages) {
                        event.getHook().sendMessage(message).setEphemeral(true).complete();
                }
            }
        }
    }
}
