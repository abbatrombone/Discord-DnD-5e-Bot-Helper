package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class HalfDMG extends ListenerAdapter{

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){

        if(event.getName().equals("halfdamage")){
            OptionMapping x = event.getOption("damage");
            double dmgresult;

            DecimalFormat df = new DecimalFormat("#");
            df.setRoundingMode(RoundingMode.FLOOR);

            if(x == null){event.reply("hey you for got to type a number.").queue();
                return;
            }else{dmgresult = x.getAsDouble()/2;}

            event.reply("The total DMG is: " + df.format(dmgresult)).queue();
        }

    }
}
