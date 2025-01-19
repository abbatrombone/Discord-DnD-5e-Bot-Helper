package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

public class GoldSplit extends ListenerAdapter {
@Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("goldsplitter")) {
            OptionMapping party = event.getOption("partycount");
            OptionMapping pp = event.getOption("pp");
            OptionMapping gp = event.getOption("gp");
            OptionMapping sp = event.getOption("sp");
            OptionMapping cp = event.getOption("cp");
            OptionMapping ep = event.getOption("ep");

            double ppresult = 0;
            double gpresult = 0;
            double spresult = 0;
            double cpresult = 0;
            double epresult = 0;

            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);

            if (party == null) {
                event.reply("Hey i cant divide by null. Do you want me to explode?").queue();
            }
            if(!Objects.isNull(pp)){
                ppresult = pp.getAsDouble()/party.getAsDouble();
            }
            if(!Objects.isNull(gp)){
                gpresult = gp.getAsDouble()/party.getAsDouble();
            }
            if(!Objects.isNull(sp)){
                spresult = sp.getAsDouble()/party.getAsDouble();
            }
            if(!Objects.isNull(cp)){
                cpresult = cp.getAsDouble()/party.getAsDouble();
            }
            if(!Objects.isNull(ep)){
                epresult = ep.getAsDouble()/party.getAsDouble();
            }
            event.reply("It is a " + df.format(party.getAsInt()) + " way split. Each person gets:\n" + df.format(ppresult) +"pp\n" + df.format(gpresult) + "gp\n" + df.format(spresult) + "sp\n" + df.format(cpresult) + "cp\n" + df.format(epresult) +"ep\n" + "Don't spend it all at once!").queue();

        }
    }
}


