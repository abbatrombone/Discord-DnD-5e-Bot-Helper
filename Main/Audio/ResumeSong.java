package Audio;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ResumeSong extends ListenerAdapter {
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!event.getName().equals("resume")) return;

        Guild guild = event.getGuild();
        if (guild == null) {
            event.reply("This command can only be used in a server.").setEphemeral(true).queue();
            return;
        }

        GuildMusicManager musicManager = Music.getGuildMusicManager(guild);

        if (musicManager.player.getPlayingTrack() == null) {
            event.reply("No song is currently playing.").setEphemeral(true).queue();
        }if(!musicManager.player.isPaused()){
            event.reply("Song was not paused and is currently playing.").setEphemeral(true).queue();
        }
        else {
            musicManager.player.setPaused(false);
            event.reply("▶️ Resumed playback.").setEphemeral(true).queue();
        }
    }
}
