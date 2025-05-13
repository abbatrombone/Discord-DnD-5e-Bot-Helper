package me.abbatrombone.traz;

import Audio.*;
import commands.*;
import events.AutoComplete;
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

        //This builds the bot with your token, enables gateways for the API, and adds event listeners for Classes
        //you can use arguments from the main method itself to pass in the token from outside of the file
        //This is what we call a program argument - in IDEs it can be added in the run configuration, and in an executable it'd go right after the file name
        //In the file you could access it by say using arguments[0] or however you have it named
        //This keeps your private token from being hardcoded in the file
        JDA bot = JDABuilder.createDefault("Your Token Goes Here ") //Best to not hard code if you can and use an enviroment varabile
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .setActivity(Activity.playing("Playing 5e"))
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
                //.addEventListeners(new Reminder()) //uncomment to use reminder
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
                .addEventListeners(new Help())
                .addEventListeners(new HelpMusic())
                .addEventListeners(new Music())
                .addEventListeners(new AddSongToQueue())
                .addEventListeners(new SkipSong())
                .addEventListeners(new PauseSong())
                .addEventListeners(new ResumeSong())
                .addEventListeners(new CurrentSongInfo())
                .addEventListeners(new MusicBotLeaveVC())
                .addEventListeners(new MusicQueue())
                .addEventListeners(new ClearQueue())
                .build();
    }

}
