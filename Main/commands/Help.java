package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;

import java.util.Comparator;

public class Help extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("help")) return;
        StringBuilder sb = new StringBuilder("📜 **Available Commands:**\n\n");
        event.getJDA().retrieveCommands().queue(commands -> {
            commands.sort(Comparator.comparing(Command::getName, String.CASE_INSENSITIVE_ORDER)); //sorts commands
            for (Command command : commands) {
                sb.append("`/")
                        .append(command.getName())
                        .append("` - ")
                        .append(command.getDescription())
                        .append("\n");
            }
            event.reply(sb.toString()).setEphemeral(true).queue();
        });

    }
}
