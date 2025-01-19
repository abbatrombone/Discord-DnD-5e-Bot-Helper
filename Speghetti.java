package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Speghetti extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){

        if(event.getName().equals("italian")){
            event.reply("Despite what you think this does not run off of Spaghetti Code. I will have you know my code is caffeine based.").queue();
        }
    }
}
