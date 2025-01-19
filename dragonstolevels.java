package commands;

import java.util.HashMap;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class dragonstolevels extends ListenerAdapter {
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if(event.getName().equals("dragonstolevels")) {
            HashMap<Integer, Integer> levelxp = new HashMap<>();
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);

            final OptionMapping currenetlevel = event.getOption("currenetlevel");
            final OptionMapping desiredlevel = event.getOption("desiredlevel");
            final OptionMapping currentxpmap = event.getOption("currentxp");
            String messageBlock = "";
            int xpneeded = 0;
            //final int leveldifference = desiredlevel.getAsInt() - currenetlevel.getAsInt();

            //level, xp
            levelxp.put(1,0      );
            levelxp.put(2,300    );
            levelxp.put(3,900    );
            levelxp.put(4,2700   );
            levelxp.put(5,6500   );
            levelxp.put(6,14000  );
            levelxp.put(7,23000  );
            levelxp.put(8,34000  );
            levelxp.put(9,48000  );
            levelxp.put(10,64000 );
            levelxp.put(11,85000 );
            levelxp.put(12,100000);
            levelxp.put(13,120000);
            levelxp.put(14,140000);
            levelxp.put(15,165000);
            levelxp.put(16,195000);
            levelxp.put(17,225000);
            levelxp.put(18,265000);
            levelxp.put(19,305000);
            levelxp.put(20,355000);


            boolean nullchekerd = levelxp.containsKey(desiredlevel.getAsInt());
            boolean nullchekerc = levelxp.containsKey(currenetlevel.getAsInt());

            if(nullchekerd == true && nullchekerc == true && (currenetlevel.getAsInt() < desiredlevel.getAsInt())) {
                Integer dkey = desiredlevel.getAsInt();
                Integer ckey = currenetlevel.getAsInt();

                final int currentxp = currentxpmap == null ? 0 : levelxp.get(ckey);;
                xpneeded =  levelxp.get(dkey) - levelxp.get(ckey);
                //xpneeded = xpneeded - currentxp;
            }


            if((nullchekerd == true) && (nullchekerc == true) && (desiredlevel.getAsInt() != currenetlevel.getAsInt()) && (currenetlevel.getAsInt() < desiredlevel.getAsInt())) {
                if(wyrmlingWhiteDragon(xpneeded) <= 1){
                    messageBlock = "Maybe you should wait before fighting a young dragon\n";
                } else {
                    messageBlock = df.format(wyrmlingRedDragon(xpneeded)) + " - " + df.format(wyrmlingWhiteDragon(xpneeded)) + " Wyrmlings Dragons\n";
                }
                if(youngWhiteDragon(xpneeded)  <= 1){
                    messageBlock = messageBlock + "Maybe you should wait before fighting a young dragon\n";
                } else {
                    messageBlock = messageBlock + df.format(youngRedDragon(xpneeded)) + " - " +  df.format(youngWhiteDragon(xpneeded)) + " Young Dragons\n";
                }
                if(adultWhiteDragon(xpneeded)  <= 1){
                    messageBlock = messageBlock +"Maybe you should wait before fighting a Adult dragon\n";
                } else {
                    messageBlock = messageBlock + df.format(adultRedDragon(xpneeded)) + " - " + df.format(adultWhiteDragon(xpneeded)) + " Adult Dragons\n";
                }
                if(ancientWhiteDragon(xpneeded)  <= 1){
                    messageBlock = messageBlock + "Maybe you should wait before fighting a Ancient dragon\n";
                } else {
                    messageBlock = messageBlock + df.format(ancientRedDragon(xpneeded)) + " - " + df.format(ancientWhiteDragon(xpneeded)) + " Ancient Dragons";
                }
                event.reply(messageBlock).queue();
            } else {
                event.reply("Nice try bud!").queue();
            }



        }

    }
    private static double wyrmlingWhiteDragon(int xpneeded){

        double numberOfwyrmlingWhites = xpneeded/ (double)450;
        return numberOfwyrmlingWhites;
    }
    private static double wyrmlingRedDragon(int xpneeded){

        double numberOfwyrmlingRed = xpneeded/ (double)1100;
        return numberOfwyrmlingRed;
    }
    private static double youngWhiteDragon(int xpneeded){

        double numberOfYoungWhites = xpneeded/ (double)2300;
        return numberOfYoungWhites;
    }
    private static double youngRedDragon(int xpneeded){

        double numberOfYoungRed = xpneeded/ (double)5900;
        return numberOfYoungRed;
    }
    private static double adultWhiteDragon(int xpneeded){

        double numberOfadultWhites = xpneeded/ (double)10000;
        return numberOfadultWhites;
    }
    private static double adultRedDragon(int xpneeded){

        double numberOfadultRed = xpneeded/ (double)18000;
        return numberOfadultRed;
    }
    private static double ancientWhiteDragon(int xpneeded){

        double numberOfancientWhites = xpneeded/ (double)25000;
        return numberOfancientWhites;
    }
    private static double ancientRedDragon(int xpneeded){

        double numberOfancientRed = xpneeded/ (double)62000;
        return numberOfancientRed;
    }
}
