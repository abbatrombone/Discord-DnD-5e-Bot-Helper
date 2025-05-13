package Audio;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Music extends ListenerAdapter {

    private static final Map<Long, GuildMusicManager> musicManagers = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(Music.class);

    private GuildMusicManager getGuildAudioPlayer(Guild guild) {
        long guildId = guild.getIdLong();
        return musicManagers.computeIfAbsent(guildId, id -> {
            GuildMusicManager manager = new GuildMusicManager(LavaPlayerManager.getPlayerManager());
            guild.getAudioManager().setSendingHandler(manager.getSendHandler());
            return manager;
        });
    }
    List<String> filePaths = List.of(
           // "/home/trazodone/Music/Correct.wav",
           //"/home/trazodone/Music/WRONG.wav",
            "https://www.youtube.com/watch?v=aGm_X6viE0A"
           //"/home/trazodone/Music/A Night Alone - TrackTribe.mp3",
            //"/home/trazodone/Music/Walk Through the Park - TrackTribe.mp3"
    );

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("vc")) return;

        Guild guild = event.getGuild();
        if (guild == null) return;

        List<VoiceChannel> list = guild.getVoiceChannels();
        VoiceChannel defaultChannel = list.getFirst();
        for (VoiceChannel voiceChannel : list) {
            if(voiceChannel.getName().equals("General")){
                defaultChannel =  guild.getVoiceChannelById(voiceChannel.getId());
            }
        }

        AudioChannelUnion audioChannel = Objects.requireNonNull(event.getMember()).getVoiceState().getChannel();
        VoiceChannel channel = (audioChannel == null) ? defaultChannel : audioChannel.asVoiceChannel();
        //VoiceChannel channel = (event.getMember().getVoiceState().getChannel().asVoiceChannel() == null) ? defaultChannel : event.getMember().getVoiceState().getChannel().asVoiceChannel();

        if (channel == null) {
            event.reply("Please join a voice channel first.").setEphemeral(true).queue();
            return;
        }
        event.reply("Enjoy the tunes").setEphemeral(true).queue();

        guild.getAudioManager().openAudioConnection(channel);

        GuildMusicManager musicManager = getGuildAudioPlayer(guild);
        AudioPlayerManager playerManager = LavaPlayerManager.getPlayerManager();

        for (String path : filePaths) {
            playerManager.loadItem(path, new AudioLoadResultHandler() {
                @Override
                public void trackLoaded(AudioTrack track) {
                    musicManager.queue(track);
                    System.out.println("Queued: " + track.getInfo().title);
                }

                @Override
                public void playlistLoaded(com.sedmelluq.discord.lavaplayer.track.AudioPlaylist playlist) {}

                @Override
                public void noMatches() {
                    event.getHook().sendMessage("Could not find " + path).setEphemeral(true).queue();
                }

                @Override
                public void loadFailed(FriendlyException e) {
                    log.error("e: ", e);
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    event.getHook().sendMessage("Failed to load " + path).setEphemeral(true).queue();
                }
            });
        }

        musicManager.player.addListener(new AudioEventAdapter() {
            @Override
            public void onTrackStart(AudioPlayer player, AudioTrack track) {
                System.out.println("Track started: " + track.getInfo().title);
            }

            @Override
            public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
                System.out.println("Track ended.");
            }
        });


//        playerManager.loadItem("/home/trazodone/Music/A Night Alone - TrackTribe.mp3", new AudioLoadResultHandler() {
//            @Override
//            public void trackLoaded(AudioTrack track) {
//                System.out.println("Track loaded: " + track.getInfo().title);
//                musicManager.player.playTrack(track);
//                event.reply("Playing Correct.wav!").setEphemeral(true).queue();
//            }
//
//            @Override
//            public void playlistLoaded(com.sedmelluq.discord.lavaplayer.track.AudioPlaylist playlist) {}
//
//            @Override
//            public void noMatches() {
//                event.reply("File not found.").setEphemeral(true).queue();
//            }
//
//            @Override
//            public void loadFailed(FriendlyException e) {
//                event.reply("Failed to load file.").setEphemeral(true).queue();
//            }
//        });
    }

//    @Override
//    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
//        if(event.getName().equals("vc")){
//            if (!event.isFromGuild()) return;
//            Guild guild = event.getGuild();
//            VoiceChannel channel = guild.getVoiceChannelsByName("team 2", true).get(0);
//            AudioManager manager = guild.getAudioManager();
//            manager.openAudioConnection(channel);
//
//
//           InputStream is = getClass().getClassLoader().getResourceAsStream("Correct.wav");
//           assert is != null;
//           InputStream bufferedIn = new BufferedInputStream(is);
//           AudioInputStream inputStream = null;
//           try {
//               if(inputStream != null){System.out.println("Not null boss!");}
//               inputStream = AudioSystem.getAudioInputStream(bufferedIn);
//               System.out.println("Original format: " + inputStream.getFormat());
//               if(inputStream == null){ System.out.println("Null boss");}
//           } catch (UnsupportedAudioFileException e) {
//               System.out.println("Unsported file?");
//               throw new RuntimeException(e);
//           } catch (IOException e) {
//               System.out.println("IO issue, Make sure you have the file in the resources bucket");
//               throw new RuntimeException(e);
//           }
//
//            manager.setSendingHandler(new MySendHandler(inputStream)); //needStream in here
//            //manager.openAudioConnection(channel);
//        }
//    }
    public Map<Long, GuildMusicManager> getMusicManagers(){
        return musicManagers;
    }
    public static GuildMusicManager getGuildMusicManager(Guild guild){
        long guildId = guild.getIdLong();
        return musicManagers.computeIfAbsent(guildId, id -> {
            GuildMusicManager manager = new GuildMusicManager(LavaPlayerManager.getPlayerManager());
            guild.getAudioManager().setSendingHandler(manager.getSendHandler());
            return manager;
        });
    }
}
