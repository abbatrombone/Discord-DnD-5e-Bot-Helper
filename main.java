import commands.*;
import events.AutoComplete;
import events.Reminder;
import events.textEvent;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //This creates an ArrayList of the commands
        List<CommandData> commands = new ArrayList<>();
        commands.add(Commands.slash("rangecalc","To use this command, Type(without brackets): /Range [horizontal distance] [veritcal distance], y|n"));
        commands.add(Commands.slash("italian","Joke Command"));
        commands.add(Commands.slash("add","adds two numbers together"));
        commands.add(Commands.slash("subtract","subtracts two numbers"));
        commands.add(Commands.slash("spellrec", "recommends spell for a given spell level"));
        commands.add(Commands.slash("goldsplitter","does math to split gold for party"));
        commands.add(Commands.slash("currencyconverter","Converts on money to another money"));
        commands.add(Commands.slash("conditions","Gives status conditions affects"));
        commands.add(Commands.slash("magicshop","Helps you spend your earned... pillaged gold!"));
        commands.add(Commands.slash("reportbug","report bug, message needs to be less than 2000 charaters!"));
        commands.add(Commands.slash("loot","Generates loot for encounters"));
        commands.add(Commands.slash("dragonstolevels","Calculates how many dragons you need to kill for a level(s)"));
        commands.add(Commands.slash("weather","Generates weather for the GM"));
        commands.add(Commands.slash("randombuilding","generates a random or chosen building"));
        commands.add(Commands.slash("dmme", "bot messages you"));
        commands.add(Commands.slash("drinkingrules","Gives homebrewed rules for drinking"));
        commands.add(Commands.slash("npc","makes the basics for an npc"));
        commands.add(Commands.slash("randomname","makes a random name"));
        commands.add(Commands.slash("recommendedfeats","recommends feats"));
        commands.add(Commands.slash("halfdamage","Calcs half damage"));

        //This is the array for the AutoComplete, i don't think its needed
        List<Command.Choice> options = new ArrayList<>();
        options.add(new Command.Choice("spellrec","class"));
        options.add(new Command.Choice("rangecalc","yesorno"));
        options.add(new Command.Choice("conditions","status"));
        options.add(new Command.Choice("magicshop","requiresattunement"));
        options.add(new Command.Choice("loot","type"));
        options.add(new Command.Choice("weather","climate"));
        options.add(new Command.Choice("weather","season"));
        options.add(new Command.Choice("weather","elevation"));
        options.add(new Command.Choice("randombuilding","building"));
        options.add(new Command.Choice("npc","namestyle"));
        options.add(new Command.Choice("randomname","namestyle"));
        

        //This builds the bot with your token, enables gateways for the API, and adds event listeners for Classes
        //you can use arguments from the main method itself to pass in the token from outside of the file
        //This is what we call a program argument - in IDEs it can be added in the run configuration, and in an executable it'd go right after the file name
        //In the file you could access it by say using arguments[0] or however you have it named
        //This keeps your private token from being hardcoded in the file
        JDA bot = JDABuilder.createDefault("") //put API token here
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .setActivity(Activity.playing("Fantasy Grounds"))
                .addEventListeners(new Listeners(commands))
                .addEventListeners(new AutoComplete(options))
                .addEventListeners(new textEvent())
                .addEventListeners(new RangeCalc())
                .addEventListeners(new Speghetti())
                .addEventListeners(new Add())
                .addEventListeners(new Subtract())
                .addEventListeners(new RecommendedSpells())
                .addEventListeners(new GoldSplit())
                .addEventListeners(new CurrencyConverter())
                .addEventListeners(new Conditions())
                .addEventListeners(new magicshop())
                .addEventListeners(new reportbug())
                .addEventListeners(new loot())
                .addEventListeners(new dragonstolevels())
                .addEventListeners(new weather())
                .addEventListeners(new randombuilding())
                .addEventListeners(new dmme())
                .addEventListeners(new drinkingrules())
                .addEventListeners(new npc())
                .addEventListeners(new randomname())
                .addEventListeners(new recommendfeats())
                .addEventListeners(new HalfDMG())
                .build();


    }

}
