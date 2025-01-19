package commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class RangeCalc extends ListenerAdapter {
   // public RangeCalc() { //might be able to delete
   //}
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){

        if(event.getName().equals("rangecalc")){
          OptionMapping base = event.getOption("base");
          OptionMapping height = event.getOption("height");
          OptionMapping yesorno = event.getOption("yesorno");

          if(base == null || height == null) {event.reply("hey you for got to type a number.").queue();
          return;
          }

            if(yesorno == null) {
                double diagonal = Math.sqrt(Math.pow(base.getAsDouble(), 2) + Math.pow(height.getAsDouble(), 2));
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                event.reply("The distance is: " + df.format(diagonal)).queue();
            }else
          if(yesorno.getAsString().equalsIgnoreCase("n")) {
              DecimalFormat df = new DecimalFormat("#.##");
              df.setRoundingMode(RoundingMode.CEILING);
              double diagonal = Math.sqrt(Math.pow(base.getAsDouble(), 2) + Math.pow(height.getAsDouble(), 2));
              event.reply("The distance is: " + df.format(diagonal)).queue();
          }else
          if (yesorno.getAsString().equalsIgnoreCase("y")){

              ArrayList<String> arrlist = new ArrayList<String>();

              DecimalFormat df = new DecimalFormat("#.##");
              df.setRoundingMode(RoundingMode.CEILING);
              double diagonal = Math.sqrt(Math.pow(base.getAsDouble(), 2) + Math.pow(height.getAsDouble(), 2));


              if(180 >= diagonal){
                 arrlist.add("Chain lightning provided there is a target at 150 feet and the target from there is 30 feet away");
              }
              if(170 >= diagonal){
                  arrlist.add("Fireball at max AoE");
              }
              if(150 >= diagonal){
                  arrlist.add("Chain lightning");
                  arrlist.add("Fireball");
                  arrlist.add("Hunger of Hadar");
              }
              if(120 >= diagonal){
                  arrlist.add("Eldritch Blast");
                  arrlist.add("Dispell Magic");
                  arrlist.add("Magic Missel is in range if you can see them");
              }
              if(90 >= diagonal) {
                  arrlist.add("Mind Whip");
              }
              if(60 >= diagonal){
                  arrlist.add("Cloud of Daggers");
                  arrlist.add("Command");
                  arrlist.add("Counter Spell");
                  arrlist.add("Dectect thoughts");
                  arrlist.add("Dominate Person");
                  arrlist.add("Hold person");
                  arrlist.add("Telekinsis");
              }

              if(arrlist.contains("Chain lightning provided there is a target at 150 feet and the target from there is 30 feet away") &&
                 arrlist.contains("Chain lightning")){
                 arrlist.remove("Chain lightning provided there is a target at 150 feet and the target from there is 30 feet away");
              }
              if(arrlist.contains("Fireball at max AoE") &&
                      arrlist.contains("Fireball")){
                  arrlist.remove("Fireball at max AoE");
              }
              arrlist.sort(String::compareToIgnoreCase); //sorts the array
              event.reply("The Distance is: " + df.format(diagonal) + "\n" + "Spells in range:" + "\n" + String.join("\n",arrlist)).queue(); // the slash n makes the indent.
          }

        }
    }
}
