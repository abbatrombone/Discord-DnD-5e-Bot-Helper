package commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;
public class Add extends ListenerAdapter {

@Override
public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
    if(event.getName().equals("add")){
        OptionMapping x = event.getOption("numbuh1");
        OptionMapping y = event.getOption("number2");

        if( x == null || y == null) {event.reply("hey you for got to type a number.").queue();
            return;
        }

       double sum = x.getAsDouble() + y.getAsDouble();
       event.reply("The sum of " + x.getAsDouble() + " + " + y.getAsDouble() + " = " + sum).queue();

    }

     }
}
