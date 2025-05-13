package Audio;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AddSongToQueue extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("addsong")) return;
        //String path = event.getOption("path").getAsString(); // get path from user input

        Guild guild = event.getGuild();
        if (guild == null) return;

        //VoiceChannel channel = event.getMember().getVoiceState().getChannel().asVoiceChannel();
        try{
            VoiceChannel channel = event.getMember().getVoiceState().getChannel().asVoiceChannel();
        }catch (NullPointerException e){
            event.reply("Please join a voice channel first.").setEphemeral(true).queue();
            return;
        }
        event.reply("🎵 What kind of song?")
                .addActionRow(
                        Button.primary("category_battle", "Battle Music"),
                        Button.primary("category_menu", "Menu Music"),
                        Button.primary("category_victory", "Victory Music"),
                        Button.primary("Youtube", "YouTube")
                ).setEphemeral(true).queue();
    }
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        String id = event.getComponentId();

        if (id.startsWith("category_")) {
            String category = id.substring("category_".length());

            List<SelectOption> options = getSongsInCategory(category).stream()
                    .map(song -> SelectOption.of(song.getLabel(), song.getPath()))
                    .toList();

            event.editMessage("🎶 Choose a " + category + " song:")
                    .setComponents(ActionRow.of(
                            StringSelectMenu.create("selectsong_" + category).addOptions(options).build()
                    )).queue();
        } else if (id.equals("Youtube")) {
            Modal modal = Modal.create("Youtube_link_modal","YouTube Link").addActionRow(TextInput.create("link_input", "Song Link", TextInputStyle.SHORT)
                            .setPlaceholder("Paste YouTube or Spotify link here")
                            .setRequired(true)
                            .build())
                    .build();
            event.replyModal(modal).queue();
        }
    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        if (!event.getComponentId().startsWith("selectsong_")) return;

        String songPath = event.getValues().get(0); // file:/path/to/song.wav

        Guild guild = event.getGuild();
        VoiceChannel channel = event.getMember().getVoiceState().getChannel().asVoiceChannel();

        GuildMusicManager musicManager = Music.getGuildMusicManager(guild);
        AudioPlayerManager playerManager = LavaPlayerManager.getPlayerManager();

        playerManager.loadItem(songPath, new AudioLoadResultHandler() {

            public void trackLoaded(AudioTrack track) {
                musicManager.queue(track);
                event.reply("🎵 Queued: " + track.getInfo().title).setEphemeral(true).queue();
            }

            public void playlistLoaded(AudioPlaylist playlist) {}
            public void noMatches() {
                System.out.println(songPath);
                event.reply("❌ No match found.").setEphemeral(true).queue();
            }

            public void loadFailed(FriendlyException e) {
                event.reply("⚠️ Load failed: " + e.getMessage()).setEphemeral(true).queue();
            }
        });
    }
    @Override
    public void onModalInteraction(ModalInteractionEvent event){
        if (!event.getModalId().equals("Youtube_link_modal")) return;

        String link = event.getValue("link_input").getAsString();

        AudioPlayerManager playerManager = LavaPlayerManager.getPlayerManager();
        GuildMusicManager musicManager = Music.getGuildMusicManager(event.getGuild());

        playerManager.loadItem(link, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {
                musicManager.queue(track);
                event.reply("🎵 Queued: " + track.getInfo().title).setEphemeral(true).queue();
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                AudioTrack first = playlist.getSelectedTrack() != null
                        ? playlist.getSelectedTrack()
                        : playlist.getTracks().get(0);
                musicManager.queue(first);
                event.reply("📃 Queued playlist: " + first.getInfo().title).setEphemeral(true).queue();
            }

            @Override
            public void noMatches() {
                event.reply("❌ No matches found for the link.").setEphemeral(true).queue();
            }

            @Override
            public void loadFailed(FriendlyException e) {
                event.reply("⚠️ Failed to load: " + e.getMessage()).setEphemeral(true).queue();
            }
        });
    }

    private List<Song> getSongsInCategory(String category) {
        String basePath = "/home/trazodone/Music/";
        File folder = new File(basePath + category);

        if (!folder.exists() || !folder.isDirectory()) return List.of();
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".mp3") || name.endsWith(".wav") || name.endsWith(".ogg"));
        if (files == null || files.length == 0) return List.of();

        Arrays.sort(files, Comparator.comparing(File::getName));
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < Math.min(25, files.length); i++) {
            File file = files[i];
            songs.add(new Song(file.getName(), file.getAbsolutePath()));
        }
        return songs;
    }

    record Song(String label, String path) {
        public String getLabel() { return label; }
        public String getPath() { return path; }
    }
    //trying to make it a subcommand for different folders
        /*
        guild.getAudioManager().openAudioConnection(channel);

        GuildMusicManager musicManager = Music.getGuildMusicManager(guild);
        AudioPlayerManager playerManager = LavaPlayerManager.getPlayerManager();

        // Connect if not already
        if (!guild.getAudioManager().isConnected()) {
            guild.getAudioManager().openAudioConnection(channel);
        }
        playerManager.loadItem(path, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {
                musicManager.queue(track);
                event.reply("Enjoy the tunes").setEphemeral(true).queue();
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                System.out.println("Loaded file" + playlist.getTracks());
            }

            @Override
            public void noMatches() {event.reply("Could not find anything at " + path).setEphemeral(true).queue();
            }

            @Override
            public void loadFailed(FriendlyException e) {
                System.out.println(e);
                //Should be replyed to on a failure anyways
                //event.reply("Failed to load: " + e.getMessage()).setEphemeral(true).queue();
            }
        });
         */
}
