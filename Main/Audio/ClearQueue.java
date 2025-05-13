package Audio;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ClearQueue extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if(!event.getName().equals("clearqueue")) return;

        Guild guild = event.getGuild();
        if(guild == null){
            event.reply("This command can only be used in a server").setEphemeral(true).queue();
        }
        GuildMusicManager manager = Music.getGuildMusicManager(guild);
        manager.getQueue().clear();
        event.reply("🧹 Cleared the music queue!").setEphemeral(true).queue();
    }
}
