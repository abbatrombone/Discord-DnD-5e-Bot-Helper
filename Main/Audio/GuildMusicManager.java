package Audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import net.dv8tion.jda.api.audio.AudioSendHandler;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GuildMusicManager {
    public final AudioPlayer player;
    private final BlockingQueue<AudioTrack> queue;

    public GuildMusicManager(AudioPlayerManager manager) {
        this.player = manager.createPlayer();
        this.queue = new LinkedBlockingQueue<>();

        player.addListener(new AudioEventAdapter() {
            @Override
            public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
                if (endReason.mayStartNext) {
                    playNextTrack();
                }
            }
        });
    }
    public void queue(AudioTrack track) {
        if (!player.startTrack(track, true)) {
            queue.offer(track);
        }
    }

    public void playNextTrack() {
        AudioTrack nextTrack = queue.poll();
        if (nextTrack != null) {
            player.startTrack(nextTrack, false);
        }
    }

    public void skipTrack() {
        player.stopTrack();
        playNextTrack();
    }

    public AudioSendHandler getSendHandler() {
        return new LavaAudioPlayerSendHandler(player);
    }

    public BlockingQueue<AudioTrack> getQueue() {
        return queue;
    }
//    public AudioSendHandler getSendHandler() {
//        return new AudioSendHandler() {
//            @Override
//            public boolean canProvide() {
//                return player.provide() != null;
//            }
//
//            @Override
//            public ByteBuffer provide20MsAudio() {
//                AudioFrame frame = player.provide();
//                return ByteBuffer.wrap(frame != null ? frame.getData() : new byte[0]);
//            }
//
//            @Override
//            public boolean isOpus() {
//                return true;
//            }
//        };
//    }

}
