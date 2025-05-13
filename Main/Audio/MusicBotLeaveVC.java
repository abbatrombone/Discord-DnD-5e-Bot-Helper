package Audio;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class MusicBotLeaveVC extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if (!event.getName().equals("leave")) return;

        Guild guild = event.getGuild();
        if (guild == null) return;

        if (!guild.getAudioManager().isConnected()) {
            event.reply("You want me to leave a voice channel I'm not in???").setEphemeral(true).queue();
            return;
        }

        GuildMusicManager manager = Music.getGuildMusicManager(guild);
        guild.getAudioManager().closeAudioConnection();
        manager.getQueue().clear();
        event.reply("Bye Bye now").setEphemeral(true).queue();

    }
}
