package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class Conditions extends ListenerAdapter{

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(event.getName().equals("conditions")) {
            System.out.println("starting conditions command");
            //This is a ternary to help with null issues
            final OptionMapping statusMapping = event.getOption("status");
            final String input = statusMapping == null ? "" : statusMapping.getAsString();

            switch (input) {
                case "Blinded":
                    event.reply("# Blinded" + "\n" +
                            "* A blinded creature can’t see and automatically fails any ability check that requires sight.\n" +
                            "* Attack rolls against the creature have advantage, and the creature’s attack rolls have disadvantage.").queue();
                    break;
                case "Charmed":
                    event.reply("# Charmed" + "\n" +
                            "A charmed creature can’t attack the charmer or target the charmer with harmful abilities or magical effects.\n" +
                            "The charmer has advantage on any ability check to interact socially with the creature.").queue();
                    break;
                case "Deafened":
                    event.reply("# Deafend" + "\n" +
                            "* A deafened creature can’t hear and automatically fails any ability check that requires hearing.").queue();
                    break;
                case "Frightened":
                    event.reply("# Frightened" + "\n" +
                            "* A frightened creature has disadvantage on ability checks and attack rolls while the source of its fear is within line of sight.\n" +
                            "* The creature can’t willingly move closer to the source of its fear."
                    ).queue();
                    break;
                case "Grappled":
                    event.reply("# Grappled" + "\n" +
                            "* A grappled creature’s speed becomes 0, and it can’t benefit from any bonus to its speed.\n" +
                            "* The condition ends if the grappler is `incapacitated` (see the condition).\n" +
                            "* The condition also ends if an effect removes the grappled creature from the reach of the grappler or grappling effect, such as when a creature is hurled away by the thunderwave spell.\n\n" +
                            "### Incapacitated\n\n" +
                            "* An incapacitated creature can’t take actions or reactions.").queue();
                    break;
                case "Incapacitated":
                    event.reply("# Incapacitated" + "\n" +
                            "* An incapacitated creature can’t take actions or reactions.").queue();
                    break;
                case "Invisible":
                    event.reply("# Invisible" + "\n" +
                            "* An invisible creature is impossible to see without the aid of magic or a special sense. For the purpose of hiding, the creature is heavily obscured. The creature’s location can be detected by any noise it makes or any tracks it leaves.\n" +
                            "* Attack rolls against the creature have disadvantage, and the creature’s attack rolls have advantage."
                    ).queue();
                    break;
                case "Paralyzed":
                    event.reply("# Paralyzed" + "\n" +
                            "* A paralyzed creature is `incapacitated` (see the condition) and can’t move or speak.\n" +
                            "* The creature automatically fails Strength and Dexterity saving throws.\n" +
                            "* Attack rolls against the creature have advantage.\n" +
                            "* Any attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature." +
                            "### Incapacitated\n\n" +
                            "* An incapacitated creature can’t take actions or reactions.").queue();
                    break;
                case "Petrified":
                    event.reply("# Petrified" + "\n" +
                            "* A petrified creature is transformed, along with any nonmagical object it is wearing or carrying, into a solid inanimate substance (usually stone). Its weight increases by a factor of ten, and it ceases aging.\n" +
                            "* The creature is `incapacitated` (see the condition), can’t move or speak, and is unaware of its surroundings.\n" +
                            "* Attack rolls against the creature have advantage.\n" +
                            "* The creature automatically fails Strength and Dexterity saving throws.\n" +
                            "* The creature has resistance to all damage.\n" +
                            "* The creature is immune to poison and disease, although a poison or disease already in its system is suspended, not neutralized\n\n" +
                            "### Incapacitated\n\n" +
                            "* An incapacitated creature can’t take actions or reactions.").queue();
                    break;
                case "Poisoned":
                    event.reply("# Poisoned" + "\n" +
                            "* A poisoned creature has disadvantage on attack rolls and ability checks.").queue();
                    break;
                case "Prone":
                    event.reply("# Prone" + "\n" +
                            "* A prone creature’s only movement option is to crawl, unless it stands up and thereby ends the condition.\n" +
                            "* The creature has disadvantage on attack rolls.\n" +
                            "* An attack roll against the creature has advantage if the attacker is within 5 feet of the creature. Otherwise, the attack roll has disadvantage.").queue();
                    break;
                case "Restrained":
                    event.reply("# Restrained" + "\n" +
                            "* A restrained creature’s speed becomes 0, and it can’t benefit from any bonus to its speed.\n" +
                            "* Attack rolls against the creature have advantage, and the creature’s attack rolls have disadvantage.\n" +
                            "* The creature has disadvantage on Dexterity saving throws.").queue();
                    break;
                case "Stunned":
                    event.reply("# Stunned" + "\n" +
                            "* A stunned creature is `incapacitated`, can’t move, and can speak only falteringly.\n" +
                            "* The creature automatically fails Strength and Dexterity saving throws.\n" +
                            "* Attack rolls against the creature have advantage.\n\n" +
                            "### Incapacitated\n\n" +
                            "* An incapacitated creature can’t take actions or reactions.").queue();
                    break;
                case "Unconscious":
                    event.reply("# Unconscious" + "\n" +
                            "* An unconscious creature is `incapacitated`, can’t move or speak, and is unaware of its surroundings\n" +
                            "* The creature drops whatever it’s holding and falls `prone`.\n" +
                            "* The creature automatically fails Strength and Dexterity saving throws.\n" +
                            "* Attack rolls against the creature have advantage.\n" +
                            "* Any attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature.\n\n" +
                            "### Incapacitated\n\n" +
                            "* An incapacitated creature can’t take actions or reactions.\n\n" +
                            "### Prone" + "\n" +
                            "* A prone creature’s only movement option is to crawl, unless it stands up and thereby ends the condition.\n" +
                            "* The creature has disadvantage on attack rolls.\n" +
                            "* An attack roll against the creature has advantage if the attacker is within 5 feet of the creature. Otherwise, the attack roll has disadvantage.").queue();
                    break;
                case "Exhaustion":
                    event.reply("# Exhaustion" + "\n" +
                            "Some special abilities and environmental hazards, such as starvation and the long-\u00ADterm effects of freezing or scorching temperatures, can lead to a special condition called exhaustion. Exhaustion is measured in six levels. An effect can give a creature one or more levels of exhaustion, as specified in the effect’s description.\n" +
                            "### Exhaustion Effects Table\n" +
                            "* Level 1: Disadvantage on ability checks\n" +
                            "* Level 2: Speed halved\n" +
                            "* Level 3: Disadvantage on attack rolls and saving throws\n" +
                            "* Level 4: Hit point maximum halved\n" +
                            "* Level 5: Speed reduced to 0\n" +
                            "* Level 6: Death\n\n" +
                            "If an already exhausted creature suffers another effect that causes exhaustion, its current level of exhaustion increases by the amount specified in the effect’s description.\n\n" +
                            "A creature suffers the effect of its current level of exhaustion as well as all lower levels. For example, a creature suffering level 2 exhaustion has its speed halved and has disadvantage on ability checks.\n\n" +
                            "An effect that removes exhaustion reduces its level as specified in the effect’s description, with all exhaustion effects ending if a creature’s exhaustion level is reduced below 1.\n\n" +
                            "Finishing a long rest reduces a creature’s exhaustion level by 1, provided that the creature has also ingested some food and drink."
                    ).queue();
                    break;
                default:
                    event.reply("Condition request is not vaild. Please try again").queue();

            }
            System.out.println("ending conditions command");
        }


    }

}
