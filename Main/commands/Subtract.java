package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class Subtract extends ListenerAdapter{
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(event.getName().equals("subtract")){
            OptionMapping x = event.getOption("numbuh1");
            OptionMapping y = event.getOption("number2");


            if( x == null || y == null) {event.reply("hey you for got to type a number.").queue();
                return;
            }

            double total = x.getAsDouble() - y.getAsDouble();
                    event.reply(x.getAsDouble() + " - " + y.getAsDouble() + " = " + total).queue();
        }


    }
}
