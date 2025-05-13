package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class drinkingrules extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){

        if(event.getName().equals("drinkingrules")) {
                event.reply("""
                        # Drinking rules
                        
                        ## Spellcasting
                        To cast a spell, make a DC 10 Constitution saving throw or the spell fails and the spell is wasted. A short rest removes one level of inebriation; a long rest removes all effects of inebriation.
                        
                        ## Drinking 
                        When enough alcohol is consumed make a DC 10 (+ 1 per drink) Constitution saving throw or advance one level of inebriation. Stronger drinks can make the DC harder (GM digression) Effects of inebriation are cumulative.
                        The number of failures to get Inebriated is equal to your con modifier. Each failure afterward increases the level by 1. (Con bonus of +2 means 3 fails to get the Inebriated condition)
                        
                        ### Levels of Inebriation
                        * 1 (Inebriated condition): Disadvantage on Persuasion and Deception checks; Advantage against being Frightened 
                        * 2 (Drunk condition): Disadvantage on Saving Throws (double the vision double the dice)
                        * 3 (Wasted condition): Disadvantage on Ability Checks Cannot dash or move more than 10′ in the same direction 
                        * 4 Become Unconscious
                       
                        ## Wasted creatures
                        * Must make a Constitution saving throw once an hour while awake or spend one minute vomiting. While vomiting, you cannot perform any other actions and automatically fail all saving throws.
                        * Must make a Constitution saving throw to gain any benefit from a long rest; if failed, you do not gain any benefits. (dry heaving is not a long rest activity).
                        """).queue();
            //Drinking rules
            //Spellcasting: To cast a spell, make a DC 10 Constitution saving throw or the spell fails. The spell is not wasted. A short rest removes one level of inebriation; a long rest removes all effects of inebriation.
            //When enough liquid courage is imbibed make a DC 10 (+ 1 per drink) Constitution saving throw or advance one level of inebriation. Stronger drinks can make the DC harder (GM digression) Effects of inebriation are cumulative.
            //The number of failures to get imbibed is equal to your con modifier. Each failure afterward increases the level by 1.
            //Level	Effect
            //1	Disadvantage on Persuasion and Deception; Advantage against Frightened (Inebriated condition)
            //2	Disadvantage on Saving Throws (Drunk condition)
            //3	Disadvantage on Ability Checks Cannot dash or move more than 10′ in the same direction (Wasted condition)
            //4	Become Unconscious
            //Wasted creatures
            //Must make a Constitution saving throw at once an hour while awake or spend one minute vomiting. While vomiting, you cannot perform any other actions and automatically fail all saving throws.
            //Must make a Constitution saving throw to gain any benefit from a long rest; if failed, you do not gain any benefits.

        }
    }
}
