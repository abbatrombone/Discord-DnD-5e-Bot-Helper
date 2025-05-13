package Audio;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

public class CurrentSongInfo extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("nowplaying")) return;

        Guild guild = event.getGuild();
        if (guild == null) {
            event.reply("This command can only be used in a server.").setEphemeral(true).queue();
            return;
        }

        GuildMusicManager musicManager = Music.getGuildMusicManager(guild);
        AudioTrack track = musicManager.player.getPlayingTrack();

        if (track == null) {
            event.reply("❌ Nothing is currently playing.").setEphemeral(true).queue();
            return;
        }
        String fallbackTitle = new File(track.getInfo().uri).getName();
        String title = track.getInfo().title.equals("Unknown title")
                ? fallbackTitle
                : track.getInfo().title;
        String author = track.getInfo().author;
        String url = track.getInfo().uri;
        long position = track.getPosition();
        long duration = track.getDuration();
        String progress = formatTime(position) + " / " + formatTime(duration);
        String progressBar = formatProgressBar(position, duration, 20); // 20-char bar
        String time = formatTime(position) + " / " + formatTime(duration);

        event.reply("🎶 **Now Playing**: `" + title + "`\n" //(" + url + ")
                + "By: `" + author + "`\n"
                + progressBar + " `" + time + "`").setEphemeral(true).queue();

    }
    private String formatTime(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        seconds %= 60;
        return String.format("%d:%02d", minutes, seconds);
    }
    private String formatProgressBar(long position, long duration, int barLength) {
        double progress = (double) position / duration;
        int filled = (int) (barLength * progress);
        int empty = barLength - filled;

        StringBuilder bar = new StringBuilder();
        bar.append("`"); // wrap in backticks for monospaced Discord font
        bar.append("▇".repeat(filled));
        bar.append("▁".repeat(empty));
        bar.append("`");
        return bar.toString();
    }
}
