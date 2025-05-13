package events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.function.Supplier;

public class Reminder extends ListenerAdapter{
  
    @Override
    public void onReady(ReadyEvent event){

        JDA bot = event.getJDA(); // <- JDA ...
        final long ChannelID = 12341234123412341234L; //Your ChannelId goes here
        //final int period = 1000 * 60 * 60 * 24 * 7;

        TextChannel textChannel = event.getJDA().getTextChannelById(realChannelID);
        TextChannel textChannel2 = event.getJDA().getTextChannelById(testChannelID);
        Timer time = new Timer(); //this calls the static class we wrote and send the message at the specified time
        time.scheduleNotifications(bot,realChannelID,textmessage());

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    }
    public int randomint(){
        Random rand = new Random();
        int max=3,min=1;
        int randomNum = rand.nextInt(max - min + 1) + min;
        return randomNum;
    }
    public String textmessage(){
        String text = "";
        switch (randomint()) {
           case 1 -> text = "Tiamat is Titillated...  Who is on board for putting an end to that?";
           case 2 -> text = "It is Wednesday and the War rages... Who will join the fight?";
           case 3 -> text = "Head count for tommorrow everyone?";
           default -> text = "Head count for tommorrow everyone??";
        }
        return text;
    }
    public class Timer{

        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

        public void scheduleNotifications(JDA api, long id, String message) {
            JDA bot = api;
            long testChannelID = id;
            SendMessage messager = new SendMessage(bot,testChannelID,"@here" + "\n" +textmessage());

            scheduleRepeatedly(() -> messager.sendingmessage(), () -> nextNotification());
        }

        void scheduleRepeatedly(Runnable action, Supplier<LocalDateTime> timeSupplier) {
            var delay = Duration.between(LocalDateTime.now(), timeSupplier.get());
            exec.schedule(() -> {
                action.run();
                scheduleRepeatedly(action, timeSupplier);
            }, delay.toMillis(), TimeUnit.MILLISECONDS);
        }

        LocalDateTime nextNotification() {
            var next = LocalDate.now().with(ChronoField.DAY_OF_WEEK, 3).atTime(9, 0);
            if (next.isBefore(LocalDateTime.now())) {
                next = next.plusWeeks(1);
            }
            return next;
        }
    }
    class SendMessage {
        private final JDA api;
        private final long channelId;
        private final String content;

        public SendMessage(JDA api, long channelId, String content) {
            this.api = api;
            this.channelId = channelId;
            this.content = content;
        }
        public void sendingmessage() {
            String content = textmessage();
            TextChannel channel = api.getTextChannelById(this.channelId);
            if (channel != null) {
                channel.sendMessage(this.content).queue(
                        message -> {
                            message.addReaction(Emoji.fromFormatted("✔")).queue();
                            message.addReaction(Emoji.fromFormatted("❌")).queue();
                        });
            }
        }
    }
}

/*
//old code I used that was buggy

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;
import java.util.concurrent.TimeUnit;

        final ZoneId zone = ZoneId.systemDefault();
        final ZoneId realzone = ZoneId.of(zone.getId());
        final ZonedDateTime zdt = ZonedDateTime.now(realzone);
        String day = String.valueOf(zdt.getDayOfWeek());
        String targetday = String.valueOf(DayOfWeek.WEDNESDAY);
        ZonedDateTime targettime = zdt.withHour(8).withMinute(0);
        ZonedDateTime currenttime = ZonedDateTime.now();
        long InitialDelay = currenttime.until(targettime, ChronoUnit.MILLIS);


        if(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)).isBefore(LocalDate.now())){
            InitialDelay = currenttime.until(targettime, ChronoUnit.MILLIS);
        }

        //ChronoUnit.MILLIS.between(currenttime, targettime);
        final Set<ZonedDateTime> targetTimes = Set.of(targettime);

Runnable WeeklyMessageTask = () ->  {

            System.out.println("starting task");

            // for (ZonedDateTime time : targetTimes) {
            if (day.equals(targetday)) {
                System.out.println("Sending weekly message...");
                switch (randomint()) {
                    case 1 -> textChannel2.sendMessage("Tiamat is Titillated...  Who is on board for putting an end to that?").queue();
                    case 2 -> textChannel2.sendMessage("It is Wednesday and the War rages... Who will join the fight?").queue();
                    case 3 -> textChannel2.sendMessage("Head count for tommorrow everyone?").queue();
                }
            }
            if (!day.equals(targetday))
                System.out.println("NOT Sending weekly message...");
            System.out.println("ending task");
        };
        scheduler.scheduleAtFixedRate(WeeklyMessageTask, InitialDelay, period, TimeUnit.MILLISECONDS);
 */
