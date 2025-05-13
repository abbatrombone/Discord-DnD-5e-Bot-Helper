package Audio;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class MusicQueue extends ListenerAdapter {
    final int MAX_CONTENT_LENGTH = 2000;
    private static final int PAGE_SIZE = 10;


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("queuelist")) return;

        Guild guild = event.getGuild();
        if (guild == null) {
            event.reply("This command can only be used in a server.").setEphemeral(true).queue();
            return;
        }
        //event.deferReply(true).queue();

        GuildMusicManager musicManager = Music.getGuildMusicManager(guild);
        BlockingQueue<AudioTrack> queue = musicManager.getQueue();
        List<AudioTrack> trackList = queue.stream().toList();

        if (queue.isEmpty()) {
            event.reply("📭 The queue is currently empty.").setEphemeral(true).queue();
        }else{
            int totalPages = (int) Math.ceil(trackList.size() / (double) PAGE_SIZE);
            int page = 0;
            event.reply(buildPage(trackList, page))
                    .addActionRow(
                            Button.primary("queue_prev", "⬅ Prev").asDisabled(),
                            Button.secondary("queue_page_0", "Page 1"),
                            Button.primary("queue_next", "Next ➡").withDisabled(totalPages <= 1)
                    ).setEphemeral(true)
                    .queue();
//            List<AudioTrack> trackList = queue.stream().toList();
//            List<String> messages = new ArrayList<>();
//            StringBuilder sb = new StringBuilder("🎶 **Upcoming Tracks:**\n");
//            int index = 1;
//
//            for (AudioTrack track : trackList) {
//                String fallbackTitle = new File(track.getInfo().uri).getName();
//                String title = track.getInfo().title.equals("Unknown title")
//                        ? fallbackTitle
//                        : track.getInfo().title;
//                String author = track.getInfo().author;
//                //String url = track.getInfo().uri;
//
//                String entry = String.format("%d. `%s` by %s%n", index++, title, author);
//                if (sb.length() + entry.length() > MAX_CONTENT_LENGTH) {
//                    messages.add(sb.toString());
//                    sb.setLength(0); // clear StringBuilder
//                }
//                if (sb.isEmpty() && !messages.isEmpty()) {
//                    sb.append("🎶 **Upcoming Tracks (continued):**\n");
//                }
//                sb.append(entry);
//            }
//            // Add any remaining content
//            if (!sb.isEmpty()) {
//                messages.add(sb.toString());
//            }
//            // Send messages
//            for (String message : messages) {
//                event.getHook().sendMessage(message).setEphemeral(true).queue();
//            }
        }
    }
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (!event.getComponentId().startsWith("queue_")) return;

        Guild guild = event.getGuild();
        GuildMusicManager musicManager = Music.getGuildMusicManager(guild);
        List<AudioTrack> trackList = new ArrayList<>(musicManager.getQueue());

        int totalPages = (int) Math.ceil(trackList.size() / (double) PAGE_SIZE);

        // Extract page number
        int currentPage = Integer.parseInt(event.getMessage().getButtons().get(1).getId().split("_")[2]);

        int newPage = switch (event.getComponentId()) {
            case "queue_prev" -> Math.max(currentPage - 1, 0);
            case "queue_next" -> Math.min(currentPage + 1, totalPages - 1);
            default -> currentPage;
        };

        // Update buttons and content
        boolean disablePrev = newPage == 0;
        boolean disableNext = newPage >= totalPages - 1;

        event.editMessage(buildPage(trackList, newPage))
                .setActionRow(
                        Button.primary("queue_prev", "⬅ Prev").withDisabled(disablePrev),
                        Button.secondary("queue_page_" + newPage, "Page " + (newPage + 1)),
                        Button.primary("queue_next", "Next").withDisabled(disableNext)
                )
                .queue();
    }

    private String buildPage(List<AudioTrack> tracks, int page) {
        int start = page * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, tracks.size());

        StringBuilder sb = new StringBuilder("🎶 **Music Queue (Page " + (page + 1) + ")**\n\n");
        for (int i = start; i < end; i++) {
            AudioTrack track = tracks.get(i);
            String fallbackTitle = new File(track.getInfo().uri).getName();
                String title = track.getInfo().title.equals("Unknown title")
                        ? fallbackTitle
                        : track.getInfo().title;
                String author = track.getInfo().author;
               //String url = track.getInfo().uri;
            sb.append(i + 1)
                    .append(". `")
                    .append(title)
                    .append("` by ")
                    .append(author)
                    .append("\n");
        }

        return sb.toString();
    }

}
