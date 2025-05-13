package Audio;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;

import java.util.Comparator;
import java.util.List;

public class HelpMusic extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("helpmusic")) return;

        event.getJDA().retrieveCommands().queue(commands -> {
            StringBuilder sb = new StringBuilder("🎵 **Music Commands:**\n\n");

            commands.stream()
                    .filter(cmd -> isMusicCommand(cmd.getName()))
                    .sorted(Comparator.comparing(Command::getName, String.CASE_INSENSITIVE_ORDER))
                    .forEach(command -> sb.append("`/")
                            .append(command.getName())
                            .append("` - ")
                            .append(command.getDescription())
                            .append("\n"));

            if (sb.toString().trim().equals("🎵 **Music Commands:**")) {
                sb.append("No music commands found.");
            }
            event.reply(sb.toString()).setEphemeral(true).queue();
        });
    }
    private boolean isMusicCommand(String commandName) {
        // You can adjust this pattern to your needs (prefix-based, exact names, etc.)
        return List.of("addsong","clearqueue","nowplaying","vc","leave","queuelist","pause","resume","skip") //manually needs updating
                .contains(commandName.toLowerCase());
    }
}
