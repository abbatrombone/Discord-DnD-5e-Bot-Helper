package Audio;

import com.sedmelluq.discord.lavaplayer.player.*;
//import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.source.local.LocalAudioSourceManager;
import dev.lavalink.youtube.YoutubeAudioSourceManager;

public class LavaPlayerManager {
    private static final AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
    static {
        playerManager.registerSourceManager(new LocalAudioSourceManager());
        YoutubeAudioSourceManager ytSourceManager = new dev.lavalink.youtube.YoutubeAudioSourceManager();
        playerManager.registerSourceManager(ytSourceManager);
//        AudioSourceManagers.registerRemoteSources(playerManager,
//                com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeAudioSourceManager.class);
        playerManager.getConfiguration().setFilterHotSwapEnabled(true);

    }
    public static AudioPlayerManager getPlayerManager() {
        return playerManager;
    }
}
