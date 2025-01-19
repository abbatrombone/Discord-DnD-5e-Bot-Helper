package events;

import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutoComplete extends ListenerAdapter {

    private final List<Command.Choice> options;
    private String[] words = new String[]{"Artificer","Bard","Cleric","Druid","Paladin","Ranger","Sorcerer","Warlock","Wizard"};
    private String[] yesandno = new String[]{"y","n"};
    private String[] currency = new String[]{"pp","gp","sp","cp","ep"};
    private String[] status = new String[]{"Blinded","Charmed","Deafened","Exhaustion", "Frightened","Grappled","Incapacitated","Invisible","Paralyzed","Petrified","Poisoned","Prone","Restrained","Stunned","Unconscious"};
    private String[] truefalse = new String[]{"True","False"};
    private String[] loottype = new String[]{"Individual","Hoard"};
    private String[] climate = new String[]{"Cold","Temperate","Tropical"};
    private String[] season = new String[]{"Spring","Summer","Fall","Winter"};
    private String[] elevation = new String[]{"Sea level","Lowland","Highland"};
    private String[] buildings = new String[]{"Residence","Religous","Tavern","Warehouse","Shop"};
    private String[] styles = new String[]{"western","eastern"};
    private String[] feattypes = new String[]{"Combat","Defensive","Healing","Magic","Movement","Resistance","Tank","Stealth","Utility"};
    private String[] featraces = new String[]{"Dragonborn","Drow","Dwarf","Elf","Elf (wood)","Half-Elf","Halfling","Half-Orc","High Elf","Human","Tiefling","Small race"};
    private String[] featstatboots = new String[]{"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};
    public AutoComplete(List<Command.Choice> options) {this.options = options;}

    @Override
    public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event){
        if(event.getName().equals("spellrec") && event.getFocusedOption().getName().equals("class")){
        List<Command.Choice> options = Stream.of(words)
                .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                .map(word -> new Command.Choice(word, word)) // map the words to choices
                .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("rangecalc") && event.getFocusedOption().getName().equals("yesorno")){
            List<Command.Choice> options = Stream.of(yesandno)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("currencyconverter") && event.getFocusedOption().getName().equals("currentmoney")){
            List<Command.Choice> options = Stream.of(currency)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("currencyconverter") && event.getFocusedOption().getName().equals("convertedmoney")){
            List<Command.Choice> options = Stream.of(currency)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("conditions") && event.getFocusedOption().getName().equals("status")){
            List<Command.Choice> options = Stream.of(status)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("magicshop") && event.getFocusedOption().getName().equals("requiresattunement")){
            List<Command.Choice> options = Stream.of(truefalse)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("loot") && event.getFocusedOption().getName().equals("type")){
            List<Command.Choice> options = Stream.of(loottype)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("weather") && event.getFocusedOption().getName().equals("climate")){
            List<Command.Choice> options = Stream.of(climate)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("weather") && event.getFocusedOption().getName().equals("season")){
            List<Command.Choice> options = Stream.of(season)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("weather") && event.getFocusedOption().getName().equals("elevation")){
            List<Command.Choice> options = Stream.of(elevation)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("randombuilding") && event.getFocusedOption().getName().equals("building")){
            List<Command.Choice> options = Stream.of(buildings)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("npc") && event.getFocusedOption().getName().equals("namestyle")){
            List<Command.Choice> options = Stream.of(styles)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("randomname") && event.getFocusedOption().getName().equals("namestyle")){
            List<Command.Choice> options = Stream.of(styles)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("recommendedfeats") && event.getFocusedOption().getName().equals("type")){
            List<Command.Choice> options = Stream.of(feattypes)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("recommendedfeats") && event.getFocusedOption().getName().equals("race")){
            List<Command.Choice> options = Stream.of(featraces)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("recommendedfeats") && event.getFocusedOption().getName().equals("halffeat")){
            List<Command.Choice> options = Stream.of(truefalse)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
        if(event.getName().equals("recommendedfeats") && event.getFocusedOption().getName().equals("statboost")){
            List<Command.Choice> options = Stream.of(featstatboots)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }

    }

}
