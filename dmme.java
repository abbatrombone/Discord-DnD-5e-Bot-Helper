package commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import org.jetbrains.annotations.NotNull;

public class dmme extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(event.getName().equals("dmme")) {
            JDA bot = event.getJDA();

            final User userid = bot.getUserById(event.getUser().getIdLong());

            PrivateChannel channel = event.getUser().openPrivateChannel().complete();
            PrivateChannel dmme = bot.openPrivateChannelById(String.valueOf(userid.getIdLong())).complete();

            event.deferReply(true).queue();
            event.getHook().sendMessage("Message Sent").queue();
            dmme.sendMessage("I see you slid into my DMs.Hello how can I help you?").queue();

            bot.retrieveUserById(String.valueOf(userid.getIdLong())).flatMap(user -> user.openPrivateChannel());
        }
    }
}
