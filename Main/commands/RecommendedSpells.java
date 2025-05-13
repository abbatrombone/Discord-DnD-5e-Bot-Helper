package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import org.jetbrains.annotations.NotNull;


public class RecommendedSpells extends ListenerAdapter {
@Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){

    //add menu for classes when you can
    if(event.getName().equals("spellrec")){
        OptionMapping charaterclass = event.getOption("class");
        OptionMapping level = event.getOption("level");

        if(charaterclass.getAsString().equals("artificer") | charaterclass.getAsString().equals("Artificer")){
            if(level.getAsInt() <= -1){
                event.reply("Smartass").queue();
            }else
            if(level.getAsInt() == 0){
              event.reply("Fire Bolt\n" +
                      "Frostbite\n" +
                      "Guidance\n" +
                      "Light\n" +
                      "Mage Hand\n" +
                      "Message\n" +
                      "Thorn Whip").queue();
            }else
            if(level.getAsInt() == 1){
                event.reply("Absorb Elements\n" +
                        "Catapult\n" +
                        "Cure Wounds\n" +
                        "Detect Magic\n" +
                        "Faerie Fire\n" +
                        "Feather Fall\n" +
                        "Grease\n" +
                        "Identify\n" +
                        "Sanctuary\n" +
                        "Sheild of Faith\n" +
                        "Tasha’s Caustic Brew" ).queue();
            }else
            if(level.getAsInt() == 2){
                event.reply("Aid\n" +
                        "Heat Metal\n" +
                        "Invisibilty\n" +
                        "Lesser Restoration\n" +
                        "Spider Climb\n" +
                        "Rope Trick\n" +
                        "Web" ).queue();
            }else
            if(level.getAsInt() == 3){
                event.reply("Dispell Magic\n" +
                        "Fly\n" +
                        "Intellect Fortress\n" +
                        "Protecction from Energy\n" +
                        "Revivify"
                        ).queue();
            }else
            if(level.getAsInt() == 4){
                event.reply("Arcane Eye\n" +
                        "Fabricate\n" +
                        "Freedom of Movement\n" +
                        "Stone Shape\n" +
                        "Otiluke's Resilient Sphere"
                        ).queue();
            }else
            if(level.getAsInt() == 5){
                event.reply("Animate Objects\n" +
                        "Bigby's Hand\n" +
                        "Greater Restoration").queue();
            }else
            if(level.getAsInt() >= 6){event.reply("Spell level was to high. Please try again (or play wizard).").queue();
            }
        }else
        if(charaterclass.getAsString().equals("bard")  | charaterclass.getAsString().equals("Bard")){
            if(level.getAsInt() <= -1){
                event.reply("Smartass").queue();
            }else
        if(level.getAsInt() == 1){
            event.reply("Light\n" +
                    "Mage Hand\n" +
                    "Mending\n" +
                    "Message\n" +
                    "Minor illusion\n" +
                    "Prestidigitation\n" +
                    "Vicious Mockery\n").queue();
        }else
        if(level.getAsInt() == 1){
            event.reply("Charm Person\n" +
                    "Command\n" +
                    "Cure Wounds\n" +
                    "Detect Magic\n" +
                    "Disguise Self\n" +
                    "Dissonant Whispers\n" +
                    "Faerie Fire\n" +
                    "Feather Fall\n" +
                    "Healing Word\n"+
                    "Heroism\n"+
                    "Identify\n" +
                    "Silent Image" +
                    "Silvery Barbs (when not banned)\n" +
                    "Tasha's Hideous Laughter\n").queue();
        }else
        if(level.getAsInt() == 2){
            event.reply("Aid\n" +
                    "Blindness/Deafness\n" +
                    "Calm Emotions\n" +
                    "Detect Thoughts\n" +
                    "Enhance Ability\n" +
                    "Heat Metal\n" + "\n" +
                    "Hold Person\n" +
                    "Invisibility\n" +
                    "Kinetic Jaunt\n" +
                    "Knock\n" +
                    "Lesser Restoration\n" +
                    "Mirror Image\n" +
                    "Phantasmal Force\n" +
                    "See Invisibilty\n" +
                    "Silence\n" +
                    "Suggestion\n" +
                    "Warding Wind").queue();
        }else
        if(level.getAsInt() == 3){
            event.reply("Bestow Curse\n"+
                    "Clairvoyance\n" +
                    "Dispell Magic\n" +
                    "Enemies Abound\n" +
                    "Fear\n" +
                    "Hypnotic Patter\n" +
                    "Intellect Fortress\n" +
                    "Leomund's Tiny Hut\n" +
                    "Major Image\n" +
                    "Nondetection\n" +
                    "Sending\n" +
                    "Tongues").queue();
        }else
        if(level.getAsInt() == 4){
            event.reply("Charm Monster\n" +
                    "Dimension Door\n" +
                    "Greater Invisibility\n" +
                    "Phantasmal Killer\n" +
                    "Polymorph\n" +
                    "Raulothim's Psychic Lance").queue();
        }else
        if(level.getAsInt() == 5){
            event.reply("Animate Objects\n" +
                    "Dominate Person\n" +
                    "Greater Restoration\n" +
                    "Hold Monster\n" +
                    "Modify Memory\n" +
                    "Rary's Telephatic bond\n" +
                    "SKill Empowerment\n" +
                    "Synaaptic Static\n" +
                    "Teleportaion Circle").queue();
        }else
        if(level.getAsInt() == 6){
            event.reply("Eyebite\n" +
                    "Mass Suggestion\n" +
                    "Otto's Irresistble Dance\n" +
                    "True Seeing").queue();
        }else
        if(level.getAsInt() == 7){
            event.reply("Drean if the Blue Veil (If DM asks)\n" +
                    "Etherealness\n" +
                    "Forcecage\n" +
                    "Mirage Arcane\n" +
                    "Teleport\n" +
                    "Resurrection").queue();
        }else
        if(level.getAsInt() == 8){
            event.reply("Dominate Monster\n" +
                    "Glibness\n" +
                    "Power Word Stun").queue();
        }else
        if(level.getAsInt() == 9){
            event.reply("Foresight\n" +
                    "Power word heal/kill\n" +
                    "Psychic Scream\n" +
                    "True Polymorph").queue();
        }else
        if(level.getAsInt() >= 10){event.reply("Spell level was to high. Please try again").queue();
        }
        }else
        if(charaterclass.getAsString().equals("cleric") | charaterclass.getAsString().equals("Cleric")){
            if(level.getAsInt() <= -1){
                event.reply("Smartass").queue();
            }else
            if(level.getAsInt() == 0){
                event.reply("Fuck you, you know every spell").queue();
            }else
            if(level.getAsInt() == 1){
                event.reply("Fuck you, you know every spell").queue();
            }else
            if(level.getAsInt() == 2){
                event.reply("Fuck you, you know every spell").queue();
            }else
            if(level.getAsInt() == 3){
                event.reply("Fuck you, you know every spell").queue();
            }else
            if(level.getAsInt() == 4){
                event.reply("Fuck you, you know every spell").queue();
            }else
            if(level.getAsInt() == 5){
                event.reply("Fuck you, you know every spell").queue();
            }else
            if(level.getAsInt() == 6){
                event.reply("Fuck you, you know every spell").queue();
            }else
            if(level.getAsInt() == 7){
                event.reply("Fuck you, you know every spell").queue();
            }else
            if(level.getAsInt() == 8){
                event.reply("Fuck you, you know every spell").queue();
            }else
            if(level.getAsInt() == 9){
                event.reply("Fuck you, you know every spell").queue();
            }if(level.getAsInt() >= 10){event.reply("Spell level was to high. Please try again(or calling on your God).").queue();
            }
        }else
        if(charaterclass.getAsString().equals("druid") | charaterclass.getAsString().equals("Druid")){
            if(level.getAsInt() <= -1){
                event.reply("Smartass").queue();
            }else
            if(level.getAsInt() == 0){
                event.reply("Druidcraft\n" +
                        "Frostbite\n" +
                        "Guidance\n" +
                        "Mold Earth\n" +
                        "Shape Water\n" +
                        "Thorn Whip").queue();
            }else
            if(level.getAsInt() == 1){
                event.reply("Absord Elements\n" +
                        "Charm Person\n" +
                        "Cure Wounds\n" +
                        "Entange\n" +
                        "Faerie Fire\n" +
                        "Goodberry (if you a bitch)\n" +
                        "Healing Word\n" +
                        "Ice Knife\n" +
                        "Protection from evil and good").queue();
            }else
            if(level.getAsInt() == 2){
                event.reply("Augury\n"+
                        "Enhance Ability\n" +
                        "Earthbind\n" +
                        "Flaming Sphere\n" +
                        "Healing Spirit\n" +
                        "Heat Metal\n" +
                        "Hold Person\n" +
                        "Lesser Resoration\n" +
                        "Moonbeam\n" +
                        "Pass without trace\n" +
                        "Spike growth\n" +
                        "Summon Beast").queue();
            }else
            if(level.getAsInt() == 3){
                event.reply("Aura of Viality\n" +
                        "Call lihjtning\n" +
                        "Conjure ANimals\n" +
                        "Dispell Magic\n" +
                        "Erupting Earth\n" +
                        "Protection from Energy\n" +
                        "Revivify").queue();
            }else
            if(level.getAsInt() == 4){
                event.reply("Charm Monster\n" +
                        "Divination\n" +
                        "Dominate Bear\n" +
                        "Fire Shield\n" +
                        "Giant Insect\n" +
                        "Stone Shape\n" +
                        "Wall of Fire").queue();
            }else
            if(level.getAsInt() == 5){
                event.reply("Antilife Shell\n" +
                        "Commune with Nature\n" +
                        "Cone of Cold\n" +
                        "Conjure Elemental\n" +
                        "Contagion\n" +
                        "Greator Restoration\n" +
                        "Insect Plague\n" +
                        "Maelstrom\n" +
                        "Mass Cure Wounds\n" +
                        "Reincarnate\n" +
                        "Scrying\n" +
                        "Summon Draconic Spirit\n" +
                        "Wall of Stone").queue();
            }else
            if(level.getAsInt() == 6){
                event.reply("Heal\n" +
                        "Hero's Feast\n" +
                        "Investiture of Stone\n" +
                        "Invesiture of Wind\n" +
                        "Sunbeam\n" +
                        "Transport via Plants\n" +
                        "Wall of Throns\n" +
                        "Wind Walk").queue();
            }else
            if(level.getAsInt() == 7){
                event.reply("Draconic Transformation\n" +
                        "Mirage Arcane\n" +
                        "Plane Shift\n" +
                        "Reverse Gravity\n" +
                        "Whirlwind").queue();
            }else
            if(level.getAsInt() == 8){
                event.reply("Feeblemind\n" +
                        "Incendiary Cloud\n" +
                        "Sunburst\n" +
                        "Tsunami").queue();
            }else
            if(level.getAsInt() == 9){
                event.reply("Foresight\n" +
                        "Shapechange\n" +
                        "True Resurrection").queue();
            }if(level.getAsInt() >= 10){event.reply("Spell level was to high. Please try again(or some weed).").queue();
            }
        }else
        if(charaterclass.getAsString().equals("paladin") | charaterclass.getAsString().equals("Paladin")){
            if(level.getAsInt() <= -1){
                event.reply("Smartass").queue();
            }else
            if(level.getAsInt() == 0){
                event.reply("Guidance\n" +
                        "Sacred Flame\n" +
                        "Toll of the Dead\n" +
                        "Word of Radiance").queue();
            }else
            if(level.getAsInt() == 1){
                event.reply("Bless\n" +
                        "Compell Duel\n" +
                        "Protection from Evil and Good\n" +
                        "Searing Smite\n" +
                        "Sheild of Faith\n" +
                        "Thunderous Smite\n" +
                        "Wrathful Smite").queue();
            }else
            if(level.getAsInt() == 2){
                event.reply("Aid\n" +
                        "Find Steed\n" +
                        "Lesser Restoration\n" +
                        "Warding Bond").queue();
            }else
            if(level.getAsInt() == 3){
                event.reply("Aura of Vitality\n" +
                        "Blinding Smite\n" +
                        "Crusader's Mantle\n" +
                        "Spirit Shroud\n" +
                        "Revivify").queue();
            }else
            if(level.getAsInt() == 4){
                event.reply("Death Ward\n" +
                        "Find Greator Steed\n" +
                        "Staggering Smite").queue();
            }else
            if(level.getAsInt() == 5){
                event.reply("Banishing Smite\n" +
                        "Destructive Smite\n" +
                        "Destructive Wave\n" +
                        "Holy Weapon").queue();
            }if(level.getAsInt() >= 6){event.reply("Spell level was to high. Please try again (or play wizard/contact your God).").queue();
            }
        }else
        if(charaterclass.getAsString().equals("ranger") | charaterclass.getAsString().equals("Ranger")){
            if(level.getAsInt() <= -1){
                event.reply("Smartass").queue();
            }else
            if(level.getAsInt() == 0){
                event.reply("No cantrips for you. HA HA HA!").queue();
            }else
            if(level.getAsInt() == 1){
                event.reply("Absorb Elements\n" +
                        "Hunter's Mark\n" +
                        "Goodberrry (if you are a bitch)\n" +
                        "Zephyr Strike" ).queue();
            }else
            if(level.getAsInt() == 2){
                event.reply("Healing Spirit\n" +
                        "Pass Without Trace\n" +
                        "Silence\n" +
                        "Spike Growth\n" +
                        "Summon Beast").queue();
            }else
            if(level.getAsInt() == 3){
                event.reply("Conjure animals\n" +
                        "Nondetection\n" +
                        "Water Walk\n" +
                        "Wind Wall\n").queue();
            }else
            if(level.getAsInt() == 4){
                event.reply("Dominate Beast\n" +
                        "Freedom of movement\n" +
                        "Summon Elemental").queue();
            }else
            if(level.getAsInt() == 5){
                event.reply("Steel Wind Strike\n" +
                        "Swift Quiver\n" +
                        "Tree Stride\n" +
                        "Weath of Nature").queue();
            }if(level.getAsInt() >= 10){event.reply("Spell level was to high. Please try again(I'm so sorry).").queue();
            }
        }else
        if(charaterclass.getAsString().equals("sorcerer") | charaterclass.getAsString().equals("Sorcerer")){
            if(level.getAsInt() <= -1){
                event.reply("Smartass").queue();
            }else
            if(level.getAsInt() == 0){
                event.reply("Chill Touch\n" +
                        "Fire bolt\n" +
                        "Frostbite\n" +
                        "Light\n" +
                        "Mage Hand\n" +
                        "Mind Sliver\n" +
                        "Minor Illusion\n" +
                        "Mold Earth\n" +
                        "Prestidigitaion\n" +
                        "Shape Water").queue();
            }else
            if(level.getAsInt() == 1){
                event.reply("Absorb Elements\n" +
                        "Burning Hands\n" +
                        "Catapult\n" +
                        "Charm Person\n" +
                        "Chromatic Orb\n" +
                        "Detect Magic\n" +
                        "Feather Fall\n" +
                        "Mage Armor\n" +
                        "Magic Missel\n" +
                        "Shield\n" +
                        "Silent Image\n" +
                        "Silvery Barbs (if not banned)").queue();
            }else
            if(level.getAsInt() == 2){
                event.reply("Alter Self\n" +
                        "Blindness/Deafness\n" +
                        "Detect Thoughts\n" +
                        "Earthbind\n" +
                        "Enhance Abilty\n" +
                        "Flaming Sphere\n" +
                        "Hold Person\n" +
                        "Invisabilty\n" +
                        "Levitate\n" +
                        "Maximilian’s Earthen Grasp\n" +
                        "Misty Step\n" +
                        "Suggestion\n" +
                        "Tasha's Mind Whip\n" +
                        "Vortex Warp\n" +
                        "Web").queue();
            }else
            if(level.getAsInt() == 3){
                event.reply("Clairvoyance\n" +
                        "Counterspell\n" +
                        "Dispell Magic\n" +
                        "Enemies Abound\n" +
                        "Fireball\n" +
                        "Fly\n" +
                        "Hypnotic Pattern\n" +
                        "Intellect Fortress\n" +
                        "Major Image\n" +
                        "Tounges").queue();
            }else
            if(level.getAsInt() == 4){
                event.reply("Banishment\n" +
                        "Charm Monster\n" +
                        "Dimension Door\n" +
                        "Greater Invisibilty\n" +
                        "Ice Storm\n" +
                        "Polymorph\n" +
                        "Raulothim’s Psychic Lance\n" +
                        "Sickening Radiance\n" +
                        "Summon Aberration\n" +
                        "Wall of Fire").queue();
            }else
            if(level.getAsInt() == 5){
                event.reply("Animate Objects\n" +
                        "Bigby's Hand\n" +
                        "Cone of Cold\n" +
                        "Dominate Person\n" +
                        "Hold Monster\n" +
                        "Insect Plague\n" +
                        "Summon Draconic Spirit\n" +
                        "Synaptic Static\n" +
                        "Telekinesis\n" +
                        "Teleporation CIrcle").queue();
            }else
            if(level.getAsInt() == 6){
                event.reply("Chain Lightning\n" +
                        "Disintergrate\n" +
                        "Eyebite\n" +
                        "Globe of Invunerabilty\n" +
                        "Mental Prision\n" +
                        "Scatter\n" +
                        "True Seeing").queue();
            }else
            if(level.getAsInt() == 7){
                event.reply("Delayed Blast Fireball\n" +
                        "Draconic Transformation\n" +
                        "Dream of the Blue Viel (if DM asks you to)\n" +
                        "Etheralness\n" +
                        "Plane Shift\n" +
                        "Reverse Gravity\n" +
                        "Teleport").queue();
            }else
            if(level.getAsInt() == 8){
                event.reply("Dominate Monster\n" +
                        "Incendiary Cloud\n" +
                        "Power Word Stun\n" +
                        "Sunburst").queue();
            }else
            if(level.getAsInt() == 9){
                event.reply("Meteor Swarm\n" +
                        "Psyhic Scream\n" +
                        "Time Stop\n" +
                        "Wish").queue();
            }if(level.getAsInt() >= 10){event.reply("Spell level was to high. Please try again (Maybe try injecting some of Gods Blood)").queue();
            }
        }else
        if(charaterclass.getAsString().equals("warlock") | charaterclass.getAsString().equals("Warlock")){
            if(level.getAsInt() <= -1){
                event.reply("Smartass").queue();
            }else
            if(level.getAsInt() == 0){
                event.reply("Chill Touch\n" +
                        "Eldritch Blast\n" +
                        "Frostbite\n" +
                        "Mage Hand\n" +
                        "Mind Silver\n" +
                        "Minor Illusion\n" +
                        "Prestidigitation\n" +
                        "Toll of the Dead\n").queue();
            }else
            if(level.getAsInt() == 1){
                event.reply("Armor of Agathys\n" +
                        "Arms of Hadar\n" +
                        "Cause Fear\n" +
                        "Charm Person\n" +
                        "Hex\n" +
                        "Protection from Evil and Good").queue();
            }else
            if(level.getAsInt() == 2){
                event.reply("Hold Person\n" +
                        "Invisibilty\n" +
                        "Misty Step\n" +
                        "Shatter\n" +
                        "Suggestion").queue();
            }else
            if(level.getAsInt() == 3){
                event.reply("Counterspell\n" +
                        "Dispell Magic\n" +
                        "Enemies Abound\n" +
                        "Hunger of Hadar\n" +
                        "Hypnotic Patter\n" +
                        "Intellect Fortress\n" +
                        "Major Image\n" +
                        "Summon Undead\n" +
                        "Thunder Step\n" +
                        "Tongues\n" +
                        "Vampiric Touch").queue();
            }else
            if(level.getAsInt() == 4){
                event.reply("Banishment\n" +
                        "Charm Monster\n" +
                        "Shadow of Moil\n" +
                        "Sickening Radiance\n" +
                        "Summon Aberration").queue();
            }else
            if(level.getAsInt() == 5){
                event.reply("Hold Monster\n" +
                        "Scrying\n" +
                        "Synaptic Staic\n" +
                        "wall of Light").queue();
            }else
            if(level.getAsInt() == 6){
                event.reply("Eyebite\n" +
                        "Investiure of Ice\n" +
                        "Mass Suggestion\n" +
                        "Mental Prison\n" +
                        "Soul Cage").queue();
            }else
            if(level.getAsInt() == 7){
                event.reply("Finger of Death\n" +
                        "Forcecage\n" +
                        "Plane Shift").queue();
            }else
            if(level.getAsInt() == 8){
                event.reply("Dominate Monster\n" +
                        "Feeblemind\n" +
                        "Glibness\n" +
                        "Maddening Darkness").queue();
            }else
            if(level.getAsInt() == 9){
                event.reply("Foresight\n" +
                        "Psychic Scream\n" +
                        "True Polymorph").queue();
            }if(level.getAsInt() >= 10){event.reply("Spell level was to high. Please try again(or complain enough to your patreon)").queue();
            }
        }else
        if(charaterclass.getAsString().equals("wizard")| charaterclass.getAsString().equals("Wizard")){
            if(level.getAsInt() <= -1){
                event.reply("Smartass").queue();
            }else
            if(level.getAsInt() == 0){
                event.reply("Chill Touch\n" +
                        "Fire Bolt\n" +
                        "Frostbite\n" +
                        "Light\n" +
                        "Mage Hand\n" +
                        "Mind Sliver\n" +
                        "Minor Illusion\n" +
                        "Prestidigitation\n").queue();
            }else
            if(level.getAsInt() == 1){
                event.reply("Absorb Elements\n" +
                        "Alarm\n" +
                        "Catapult\n" +
                        "Cause Fear\n" +
                        "Charm Person\n" +
                        "Chromatic Orb\n" +
                        "Comprehend Languages\n" +
                        "Detect Magic\n" +
                        "Feather Fall\n" +
                        "Find Familiar\n" +
                        "Grease\n" +
                        "Magic Missel\n" +
                        "Silvery Barbs (if not banned)").queue();
            }else
            if(level.getAsInt() == 2){
                event.reply("Augury\n" +
                        "Blindness/Deafness\n" +
                        "Earthbind\n" +
                        "Enhance Abiltiy\n" +
                        "Invisibility\n" +
                        "Knock\n" +
                        "Misty Step\n" +
                        "Suggestion\n" +
                        "Tasha's Mind Whip\n" +
                        "Vortex Warp\n" +
                        "Web").queue();
            }else
            if(level.getAsInt() == 3){
                event.reply("Clairvoyance\n" +
                        "Counterspell\n" +
                        "Dispell Magic\n" +
                        "Enemies Abound\n" +
                        "Fireball\n" +
                        "Fly\n" +
                        "Hypontic Patter\n" +
                        "Intellect Fortess\n" +
                        "Leomund's Tiny Hut\n" +
                        "Major Image\n" +
                        "Nondection\n"  +
                        "Protetion from Energy\n"  +
                        "Sending\n"  +
                        "Summon Undead\n"  +
                        "Tongues").queue();
            }else
            if(level.getAsInt() == 4){
                event.reply("Arcane Eye\n" +
                        "Charm Monster\n" +
                        "Divination\n" +
                        "Evard's Black Tentacles\n"  +
                        "Greater Invisibility\n"  +
                        "Otiluke’s Resilient Sphere\n"  +
                        "Phantasmal Killer\n"  +
                        "Polymorph\n"   +
                        "Sickening Radiance\n"   +
                        "Summon Aberration\n"   +
                        "Wall of Fire").queue();
            }else
            if(level.getAsInt() == 5){
                event.reply("Animate Objects\n" +
                        "Bigby's Hand\n"   +
                        "Conjure Elemental\n" +
                        "Cone of Cold\n"  +
                        "Dominate Person\n" +
                        "Hold Monster\n" +
                        "Modify Memory\n"  +
                        "Rary's Telpathic Bond\n" +
                        "Scrying\n" +
                        "Telekinesis\n" +
                        "Wall of Force").queue();
            }else
            if(level.getAsInt() == 6){
                event.reply("Chain Lightning\n" +
                        "Contingency\n"  +
                        "Create Homunculus\n"  +
                        "Disintegrate\n"  +
                        "Eyebite\n" +
                        "Globe of Invulnerability\n"  +
                        "Mental Prison\n" +
                        "Ott's Irresistible Dance").queue();
            }else
            if(level.getAsInt() == 7){
                event.reply("Draconic Transformation\n" +
                        "Etheralness\n"  +
                        "Forcecage\n"  +
                        "Mirage Arcane\n" +
                        "Planeshift\n" +
                        "Reverse Gravity\n" +
                        "Simulacrum\n"  +
                        "Teleport").queue();
            }else
            if(level.getAsInt() == 8){
                event.reply("Antimagic Field\n" +
                        "Antipathy/Sympathy\n" +
                        "Clone\n" +
                        "Dominate Monster\n" +
                        "Maze").queue();
            }else
            if(level.getAsInt() == 9){
                event.reply("Meter Swarm\n" +
                        "Shapechange\n" +
                        "Time Stop\n"  +
                        "True Polymorph\n"  +
                        "Wish").queue();
            }if(level.getAsInt() >= 10){event.reply("Spell level was to high. Please try again (You are not a God)").queue();
            }
        }else
            if(!charaterclass.getAsString().equals("artificers") | !charaterclass.getAsString().equals("bard") | !charaterclass.getAsString().equals("cleric") | !charaterclass.getAsString().equals("druid") | !charaterclass.getAsString().equals("paladin") | !charaterclass.getAsString().equals("ranger") | !charaterclass.getAsString().equals("sorcerer") | !charaterclass.getAsString().equals("warlock") | !charaterclass.getAsString().equals("wizard"))
            {event.reply("This is not a class: " + "'" + charaterclass.getAsString() + "'" +". If it is im sorry. Ill take it up with programmer.").queue();}

    }


    }
}
