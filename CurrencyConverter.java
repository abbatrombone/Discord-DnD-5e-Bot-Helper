package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CurrencyConverter extends ListenerAdapter {

    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(event.getName().equals("currencyconverter")){
            OptionMapping amount = event.getOption("amount");
            OptionMapping currency = event.getOption("currentmoney");
            OptionMapping convertedCurrency = event.getOption("convertedmoney");

            DecimalFormat df = new DecimalFormat("#.####");
            df.setRoundingMode(RoundingMode.CEILING);

            double total = 0;
            String sillymessage = null;

            if(currency.getAsString().equalsIgnoreCase("cp")){
                if(convertedCurrency.getAsString().equalsIgnoreCase("pp")){
                  total = amount.getAsDouble()/1000;
                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("gp")) {
                  total = amount.getAsDouble()/100;
                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("sp")) {
                  total = amount.getAsDouble()/10;
                } else
                if (convertedCurrency.getAsString().equalsIgnoreCase("cp")) {
                  total = amount.getAsInt();
                  sillymessage = "what did you expect?";
                }
                if (convertedCurrency.getAsString().equalsIgnoreCase("ep")) {
                    total = amount.getAsDouble()/50;
                }
            } else
            if (currency.getAsString().equalsIgnoreCase("sp")) {
                if(convertedCurrency.getAsString().equalsIgnoreCase("pp")){
                    total = amount.getAsDouble()/100;
                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("gp")) {
                    total = amount.getAsDouble()/10;
                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("sp")) {
                    total = amount.getAsInt();
                    sillymessage = "what did you expect?";
                } else
                if (convertedCurrency.getAsString().equalsIgnoreCase("cp")) {
                    total = amount.getAsInt()*10;
                }
                if (convertedCurrency.getAsString().equals("ep")) {
                    total = amount.getAsDouble()/5;
                }
            } else
            if(currency.getAsString().equals("gp")){
                if(convertedCurrency.getAsString().equalsIgnoreCase("pp")){
                    total = amount.getAsDouble()/10;
                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("gp")) {
                    total = amount.getAsInt();
                    sillymessage = "what did you expect?";
                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("sp")) {
                    total = amount.getAsInt()*10;

                } else
                if (convertedCurrency.getAsString().equalsIgnoreCase("cp")) {
                    total = amount.getAsInt()*100;
                }
                if (convertedCurrency.getAsString().equalsIgnoreCase("ep")) {
                    total = amount.getAsDouble()/2;
                }
            } else
            if(currency.getAsString().equalsIgnoreCase("pp")){
                if(convertedCurrency.getAsString().equalsIgnoreCase("pp")){
                    total = amount.getAsInt();
                    sillymessage = "what did you expect?";
                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("gp")) {
                    total = amount.getAsInt()*10;

                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("sp")) {
                    total = amount.getAsInt()*100;

                } else
                if (convertedCurrency.getAsString().equalsIgnoreCase("cp")) {
                    total = amount.getAsInt()*1000;
                }
                if (convertedCurrency.getAsString().equalsIgnoreCase("ep")) {
                    total = amount.getAsDouble()/20;
                }
            } else
            if(currency.getAsString().equalsIgnoreCase("ep")){
                if(convertedCurrency.getAsString().equalsIgnoreCase("pp")){
                    total = amount.getAsDouble()/20;
                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("gp")) {
                    total = amount.getAsDouble()/2;

                } else
                if(convertedCurrency.getAsString().equalsIgnoreCase("sp")) {
                    total = amount.getAsInt()*5;

                } else
                if (convertedCurrency.getAsString().equalsIgnoreCase("cp")) {
                    total = amount.getAsInt()*50;
                }
                if (convertedCurrency.getAsString().equalsIgnoreCase("ep")) {
                    total = amount.getAsInt();
                    sillymessage = "what did you expect?";
                }
            }

            if(sillymessage != null){
                event.reply(sillymessage + " " + amount.getAsInt() + "" + currency.getAsString() + " is equal to itself.").queue();
            }else{
                event.reply(df.format(amount.getAsInt()) + "" + currency.getAsString() + " is " + df.format(total) + "" + convertedCurrency.getAsString()).queue();
            }
        }

    }
}
