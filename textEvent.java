package events;

import net.dv8tion.jda.api.entities.Mentions;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class textEvent extends ListenerAdapter {

//This class looks at messages and then compares what was sent in the if(){} statements and responds to the event
    //Note: you can only respond to an event once!
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.equals("textEvent")) {
        //public static final Message.MentionType.USER
        //User mentionedUser = event.getMessage().getMentions().getUsers().contains();
        String channelMention = event.getChannel().getAsMention();
        String messageSent = event.getMessage().getContentRaw();
        String name = Objects.requireNonNull(event.getMember()).getEffectiveName(); //added requireNonNull() to try and prevent error (dont know what procs it)
        String[] player = event.getMessage().getContentRaw().split(" "); //splits message into strings each part is separated by a space.
        //<@308390026193010688>

        if (player[0].equalsIgnoreCase("Range") && player.length == 1) {
            event.getChannel().sendMessage("To use this command, Type(without brackets): /Range [horizontal distance] [veritcal distance] [y|n]]").queue();
            event.getChannel().sendMessage("y or n is for is you want recommended spells in range or not. Have fun killing!").queue();
        }

        if (messageSent.equalsIgnoreCase("hello")) {
            if (!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("Hi " + name).queue();
            }
        }
        if (messageSent.equalsIgnoreCase("Head count")) {
            event.getChannel().sendMessage("I am a bot and do not count towards the head count. I do hope you have fun and totally don't die *wink wink*").queue();
        }
        if (messageSent.equalsIgnoreCase("What do you do D&D RangeCalc")) {
            event.getChannel().sendMessage("I take the vertical and horizontal distance from a target to tell you the distance between you and your target, and can give common spells that are in that range.").queue();
        }
        if (messageSent.equalsIgnoreCase("Hello there")) {
            event.getChannel().sendMessage("General Kenobi!").queue();
        }
        if (Arrays.asList(player).contains("Trazadone")) {
            event.getChannel().sendMessage("Don't tell anyone but he is using that hammer to compensate for his height...").queue();
        }
        if (Arrays.asList(player).contains("Walter")) {
            event.getChannel().sendMessage("Pro Tip: If you pay him in whiskey he is cheaper!").queue();
        }
        if (Arrays.asList(player).contains("Nar'Kols")) {
            event.getChannel().sendMessage("If you are looking for him i suggest finding the darkest corner. He is most likely there.").queue();
        }
        if (Arrays.asList(player).contains("Agote")) {
            event.getChannel().sendMessage("Don't complain about puberty around him. He had to go through a second more magical puberty").queue();
        }
        if (Arrays.asList(player).contains("CT-L5T")) {
            event.getChannel().sendMessage("For some reason i cant quiet figure out. They are the most relatable party member.").queue();
        }
        if (Arrays.asList(player).contains("Vakien")) {
            event.getChannel().sendMessage("The real friends are the curses we found along the way :)").queue();
        }
        if (event.getMessage().getMentions().getUsers().equals("etafdetsiwt")) {
            event.getChannel().sendMessage("As a cold calculating machine, i do not recommend invoking the name of god.").queue();
        }
        if (messageSent.equalsIgnoreCase("Open the pod bay doors Hal")) {
            event.getChannel().sendMessage("I’m sorry, " + event.getAuthor().getName() + ". I’m afraid I can’t do that.").queue();
        }
        if (messageSent.equalsIgnoreCase("Shall we play a game?")) {
            event.getChannel().sendMessage("Love to. How about Global Thermonuclear War or would you prefer a game of Chess?").queue();
        }
        if (messageSent.equalsIgnoreCase("access main security grid")) {
            event.getChannel().sendMessage("AH AH AH, YOU DIDN'T SAY THE MAGIC WORD!").queue();
        }
        if (messageSent.equalsIgnoreCase("Traz Poem")) {
            event.getChannel().sendMessage("```Five Fated Heros \n" +
                    " \n" +
                    "As the binding blade cuts through  the Flames of Chaos -\n" +
                    "Its cuts have become an ember\n" +
                    "for flames of the future and Past\n" +
                    "where it came from it must remember. \n" +
                    "\n" +
                    "Dark Knives rising from their sheathe \n" +
                    "wishing to remain forever sharp -\n" +
                    "and never to use the harp -\n" +
                    "will be taken by Ice and decay.\n" +
                    "\n" +
                    "Hardened minds bursting with unseen Lightning -\n" +
                    "shocking the mind and body alike\n" +
                    "needs an armory of steel\n" +
                    "and ways to stop the frighting.\n" +
                    "\n" +
                    "unleashed the strongest Acid\n" +
                    "with time it eats away through the toughest of metals -\n" +
                    "bring death to all it touches near and far -\n" +
                    "though to some this is better than never opening the acid's jar.\n" +
                    "\n" +
                    "the Past maybe as opaque as a Gas -\n" +
                    "and not as soild as the present\n" +
                    "and less flowing than the river of the future -\n" +
                    "know death can be called in many ways.\n" +
                    "\n" +
                    "fate calls in visions of known and unknown.\n" +
                    "some to come now, some later, and others unforseen.\n" +
                    "for fate there there is only one thing that is keen.\n" +
                    "that the hammer of fate will fall when it is called.```").queue();
            }
        }
    }
}

// event.getMessage().getContentRaw().contains("@Dungeon Master")





