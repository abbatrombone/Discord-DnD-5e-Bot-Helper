package commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class Listeners extends ListenerAdapter{
    //This creates the List and hold CommandData as a data type.
    private final List<CommandData> commands;
    //I think this checks to see if a command was updated or not and starts as a default
    // of false
    private boolean updated = false;
    //This try's to hear if a command was done. "This." tells java this is an object.
    public Listeners(@NotNull List<CommandData> commands) {
        this.commands = commands;
    }
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        if (updated) return; // Return if already updated
        updated = true;
    //This adds and updates the commands as well as what parameters to look for.
        event.getJDA().updateCommands().addCommands(
                Commands.slash("rangecalc","[horizontal distance] [veritcal distance] [y|n] for recommended spells in range")
                        .addOption(OptionType.NUMBER, "base", "Horizontal distance", true)
                        .addOption(OptionType.NUMBER,"height","Vertical distance", true)
                        .addOption(OptionType.STRING,"yesorno","y|n",false,true),
                Commands.slash("italian","Joke Command"),
                Commands.slash("add","Adds two numbers together")
                        .addOption(OptionType.NUMBER, "numbuh1", "Nigel uno",true)
                        .addOption(OptionType.NUMBER, "number2", "Second number", true),
                Commands.slash("subtract","Subtracts two numbers")
                        .addOption(OptionType.NUMBER, "numbuh1", "Nigel Uno",true)
                        .addOption(OptionType.NUMBER, "number2", "Second number", true),
                Commands.slash("spellrec", "Recommends spell for a given spell level")
                        .addOption(OptionType.STRING,"class","Charater class",true,true)
                        .addOption(OptionType.INTEGER, "level", "Spell level, cantrips are level 0",true),
                Commands.slash("goldsplitter","Does math to split gold for party")
                        .addOption(OptionType.INTEGER,"partycount","How many people",true)
                        .addOption(OptionType.NUMBER,"pp","Number of platinum pieces",false)
                        .addOption(OptionType.NUMBER,"gp","Gold pieces",false)
                        .addOption(OptionType.NUMBER, "sp", "Silver pieces", false)
                        .addOption(OptionType.NUMBER, "cp","Copper pieces",false)
                        .addOption(OptionType.NUMBER,"ep", " Electrum Pieces", false),
                Commands.slash("currencyconverter","Converts on money to another money")
                        .addOption(OptionType.INTEGER,"amount","Amount of money you have that will be converted to another type",true,false)
                        .addOption(OptionType.STRING,"currentmoney","Money type that will be converted to other type",true,true)
                        .addOption(OptionType.STRING,"convertedmoney","Desired money to be converted into",true,true),
                Commands.slash("magicshop","Helps you spend your earned... pillaged gold!")
                        .addOption(OptionType.INTEGER,"maxgold","Finds items where its minimum cost is below this",true)
                        .addOption(OptionType.INTEGER,"mingold","Ignores items that's max cost is below desired amount",false)
                        .addOption(OptionType.STRING, "requiresattunement","filters for items if you want or do not want attunement",false,true),
                Commands.slash("conditions","Gives status condition affects")
                        .addOption(OptionType.STRING,"status","Status Condition",true,true),
                Commands.slash("reportbug","report bug, message needs to be less than 2000 charaters!")
                        .addOption(OptionType.STRING,"message","report bug, message needs to be less than 2000 charaters!",true,false),
                Commands.slash("loot","Generates loot for encounters")
                        .addOption(OptionType.INTEGER,"cr","Challenge Rating / Encounter Level",true)
                        .addOption(OptionType.STRING,"type","Individual or Hoard",true,true),
                Commands.slash("dragonstolevels", "Calculates how many dragons you need to kill for a level(s)")
                        .addOption(OptionType.INTEGER,"currenetlevel","What is your current Level?",true)
                        .addOption(OptionType.INTEGER,"desiredlevel","What level are you trying to get to?",true)
                        .addOption(OptionType.INTEGER,"currentxpmap","Current amount of xp?",false),
                Commands.slash("weather","Generates weather for the GM")
                        .addOption(OptionType.STRING,"climate","climate for the area (Cold,Temperate,Tropical)",true,true)
                        .addOption(OptionType.STRING,"season","season (Summer,Winter,Spring,Fall)",true,true)
                        .addOption(OptionType.STRING,"elevation","elevation, defaults to Lowland",false,true),
                Commands.slash("randombuilding","generates a random or chosen building")
                        .addOption(OptionType.INTEGER,"number","number of buildings",false,false)
                        .addOption(OptionType.STRING,"building","building type",false,true),
                Commands.slash("trazdream","No.")
                        .addOption(OptionType.INTEGER,"numbuh1","No.",true,false),
                Commands.slash("dmme","sends you a message"),
                Commands.slash("drinkingrules","Gives homebrewed rules for drinking"),
                Commands.slash("npc","makes the basics for an npc")
                        .addOption(OptionType.STRING,"namestyle","gives western or eastern style name",false,true),
                Commands.slash("randomname","makes a random name")
                        .addOption(OptionType.STRING,"namestyle","gives western or eastern style name",false,true),
                Commands.slash("recommendedfeats","recommends feats")
                        .addOption(OptionType.STRING,"type","type",false,true)
                        .addOption(OptionType.STRING,"race","race",false,true)
                        .addOption(OptionType.STRING,"halffeat","half",false,true)
                        .addOption(OptionType.STRING,"statboost","stat",false,true),
                Commands.slash("halfdamage","Calcs half damage")
                        .addOption(OptionType.INTEGER,"damage","orginbal damage delt",true)
                //Commands.slash("weaponbuilder","custom weapon builder, not offical material")
        ).queue();
    }

}
