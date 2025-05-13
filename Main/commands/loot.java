package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class loot extends ListenerAdapter {
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("loot")) {
            Random rand = new Random();

            OptionMapping cr = event.getOption("cr");
            OptionMapping typedisc = event.getOption("type"); //String type = "Hoard";
            String type = typedisc.getAsString();

            int max=100,min=1;
            int d6 = 6;
            int randomNum = rand.nextInt(max - min + 1) + min;
            int tableran = rand.nextInt(max - min + 1) + min;
            int secReward = rand.nextInt(d6 - min + 1) + min;
            int thirdReward = rand.nextInt(d6 - min + 1) + min;
            int forthReward = rand.nextInt(d6 - min + 1) + min;
            event.deferReply(true).queue();

            switch (type){
                case "Individual":
                    if(0 <= cr.getAsInt() && cr.getAsInt() <= 4){
                        System.out.println("Cr was: " + cr.getAsInt());
                        if(0 <= randomNum && randomNum <= 30){
                            event.getHook().sendMessage("You rolled a: " + randomNum).setEphemeral(true).complete();;
                            int reward = dice(5,6);
                            System.out.println("The reward is 5d6(17)cp. You rolled a: " + reward );

                            event.getHook().sendMessage("The reward is 5d6(17)cp. You rolled a: " + reward + "cp ").setEphemeral(true).complete();
                            break;
                        }
                        if(31 <= randomNum && randomNum <= 60){
                            System.out.println("You rolled a: " + randomNum);
                            int reward = dice(4,6);

                            event.getHook().sendMessage("You rolled a: " + randomNum).setEphemeral(true).complete();;
                            event.getHook().sendMessage("The reward is 4d6(14)sp. You rolled a: " + reward + "sp").setEphemeral(true).complete();;
                            break;
                        }
                        if(61 <= randomNum && randomNum <= 70){
                            event.getHook().sendMessage("You rolled a: " + randomNum).setEphemeral(true).complete();;
                            int reward = dice(3,6);

                            event.getHook().sendMessage("The reward is 3d6(10)ep. You rolled a: " + reward + "ep").setEphemeral(true).complete();;
                            break;
                        }
                        if(71 <= randomNum && randomNum <= 95){
                            event.getHook().sendMessage("You rolled a: " + randomNum).setEphemeral(true).complete();;
                            int reward = dice(5,6);

                            event.getHook().sendMessage("The reward is 3d6(10)gp. You rolled a: " + reward + "gp").setEphemeral(true).complete();;
                            break;
                        }
                        if(96 <= randomNum && randomNum <= 100){
                            event.getHook().sendMessage("You rolled a: " + randomNum).setEphemeral(true).complete();;
                            int reward = dice(5,6);

                            event.getHook().sendMessage("The reward is 1d6(3)pp. You rolled a: " + reward + "pp").setEphemeral(true).complete();;
                            break;
                        }
                        ///////////////////////////////
                    } else if (5 <= cr.getAsInt() && cr.getAsInt() <= 10) {
                        if(0 <= randomNum && randomNum <= 30){
                            int reward = (dice(4,6) * 100);
                            secReward = (dice(3,6) *10);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 4d6 x 100 (1,400)cp, 1d6 x 10 (35)ep. You rolled a: " + reward + "cp " + secReward + "ep").setEphemeral(true).complete();;

                            break;
                        }
                        if(31 <= randomNum && randomNum <= 60){
                            int reward = (dice(6,6) *10);
                            secReward = (dice(2,6) *10);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 6d6 x 10 (210)sp, 2d6 x 10 (70)gp. You rolled a: " + (reward) + "gp " + (secReward)+ "sp").setEphemeral(true).complete();;
                            break;
                        }
                        if(61 <= randomNum && randomNum <= 70){
                            int reward = (dice(3,6) * 10);
                            secReward = (dice(2,6) * 10);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 1d6 x 100(350)ep, 2d6(70)gp. You rolled a: " + (reward) + "ep " + (secReward) + "gp").setEphemeral(true).complete();;
                            break;
                        }
                        if(71 <= randomNum && randomNum <= 95){
                            int reward = (dice(4,6) * 10);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 4d6 x 10(140)gp. You rolled a: " + (reward)+ "gp" ).setEphemeral(true).complete();;
                            break;
                        }
                        if(96 <= randomNum && randomNum <= 100){

                            int reward = (dice(2,6) * 10);
                            secReward = (dice(3,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 2d6 x 10 (70)gp, 3d6 (10)pp. You rolled a: " + reward + "gp " + secReward + "pp" ).setEphemeral(true).complete();;
                            break;
                        }
                        //////////////////////
                    } else if (11 <= cr.getAsInt() && cr.getAsInt() <= 16) {
                        System.out.println("Cr was: " + cr);
                        if(0 <= randomNum && randomNum <= 20){
                            int reward = (dice(4,6) * 100);
                            secReward = (dice(1,6) *100);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 4d6 x 100 (1,400)sp, 1d6 x 100 (350)gp. You rolled a: " + reward + "sp " + secReward + "gp").setEphemeral(true).complete();;
                            break;
                        }
                        if(21 <= randomNum && randomNum <= 35){
                            int reward = (dice(1,6) * 100);
                            secReward = (dice(1,6) * 100);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 1d6 x 100 (350)ep, 1d6 x 100 (350)gp. You rolled a: " + reward + "gp " + secReward+ "sp").setEphemeral(true).complete();;
                            break;
                        }
                        if(36 <= randomNum && randomNum <= 75){
                            int reward = (dice(2,6) * 100);
                            secReward = (dice(1,6)*10);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 2d6 x 100(700)gp, 1d6 x 10 (35)pp. You rolled a: " + reward  + "ep " + secReward + "gp" ).setEphemeral(true).complete();;
                            break;
                        }
                        if(76 <= randomNum && randomNum <= 100){
                            int reward = (dice(2,6) * 100);
                            secReward = (dice(2,6) * 10);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 2d6 x 100(700)gp, 2d6 x 10 (70)pp. You rolled a: " + reward+ "gp " + secReward + "pp").setEphemeral(true).complete();;
                            break;
                        }
                    } else if (cr.getAsInt() >= 17) {
                        if (0 <= randomNum && randomNum <= 15) {
                            int reward = (dice(2,6) * 1000);
                            secReward = (dice(8,6) * 100);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 2d6 x 1000 (7000)ep, 8d6 x 100 (2800)gp. You rolled a: " + reward + "ep " + (secReward) + "gp").setEphemeral(true).complete();;
                            break;
                        }
                        if (16 <= randomNum && randomNum <= 55) {
                            int reward = (dice(1,6) * 1000);
                            secReward = (dice(1,6) * 100);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 1d6 x 1000 (3500)gp, 1d6 x 100 (350)pp. You rolled a: " + reward + "gp " + secReward + "pp").setEphemeral(true).complete();;
                            break;
                        }
                        if (56 <= randomNum && randomNum <= 100) {
                            int reward = (dice(1,6) * 1000);
                            secReward = (dice(2,6) * 100);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + randomNum + " for your table\n" +
                                    "The reward is 1d6 x 1000(3500)gp, 2d6 x 100 (700)pp. You rolled a: " + secReward + "gp " + reward + "pp").setEphemeral(true).complete();;
                            break;
                        }

                    }
                    /////////////////////////////////////////////////////
                case "Hoard":
                    if(0 <= cr.getAsInt() && cr.getAsInt() <= 4){
                        if(0 <= tableran && tableran <= 6){
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100 (2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward + "gp. ").setEphemeral(true).complete();;
                            break;
                        } else if (7 <= tableran && tableran <= 16) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)s, 2d6 x 10 (70)gp, and 2d6(7) 10gp gems. You rolled a: "
                                    + reward +"cp " + secReward + "sp " + thirdReward + "gp\n" + smallgem(forthReward) + "(gems worth 10 gold each).").setEphemeral(true).complete();;
                            break;
                        } else if (17 <= tableran && tableran <= 26) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,4));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)s, 2d6 x 10 (70)gp, and 2d4(5) 25gp art objects. You rolled a: "
                                    + reward +"cp " + secReward + "sp " + thirdReward + "gp\n" + smallart(forthReward) + " (art worth 25gp each)").setEphemeral(true).complete();;
                            break;
                        } else if (27 <= tableran && tableran <= 36) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)s, 2d6 x 10 (70)gp, and 2d6(7) 50gp gems. You rolled a: "
                                    + reward +"cp " + secReward + "sp " + thirdReward + "gp\n" + medgem(forthReward) + " (gems worth 50gp each)").setEphemeral(true).complete();;
                            break;

                        } else if (37 <= tableran && tableran <= 44) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d6(7) 10gp gems, and 1d6 items from Magic Table A. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward + "gp\n" + smallgem(forthReward) + " (gems worth 10gp each), "
                                    + TableA(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }else if (45 <= tableran && tableran <= 52){
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,4));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d4(5) 25gp art objects, and 1d6 items from Magic Table A. You rolled a: "
                                    + (reward * 100) + "cp " + (secReward * 100) + "sp\n" + (thirdReward * 10) + "gp " + smallart(forthReward) + " (art objects worth 25gp each), "
                                    + TableA(dice(1,6))).setEphemeral(true).complete();;
                            break;

                        } else if (53 <= tableran && tableran <= 60) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d6(7) 50gp gems, and 1d6 items from Magic Table A. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward + "gp\n" + medgem(forthReward) + " (gems worth 50gp each), "
                                    + TableA(dice(1,6))).setEphemeral(true).complete();;
                            break;

                        } else if (61 <= tableran && tableran <= 65) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d6(7) 10gp gems, and 1d4 items from Magic Table B. You rolled a: "
                                    + reward+ "cp " + secReward + "sp " + thirdReward + "gp\n" + smallgem(forthReward) + " (gems worth 10gp each), "
                                    + TableB(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (66 <= tableran && tableran <= 70) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,4));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d4(5) 25gp art objects, and 1d4 items from Magic Table B. You rolled a: "
                                    + reward + "cp " + secReward+ "sp " + thirdReward + "gp\n" + smallart(forthReward) + " (art objects 25gp each), "
                                    + TableB(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (71 <= tableran && tableran <= 75) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d6(7) 50gp gems, and 1d4 items from Magic Table B. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward + "gp\n" + medgem(forthReward) + " (gems worth 50gp each), "
                                    + TableB(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (76 <= tableran && tableran <= 78) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d6(7) 10gp gems, and 1d4 items from Magic Table C. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward+ "gp\n" + smallgem(forthReward) + " (gems worth 10gp each), "
                                    + TableC(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (79 <= tableran && tableran <= 80) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,4));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d4(7) 25gp art objects, and 1d4 items from Magic Table C. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward + "gp\n" + smallart(forthReward) + " (art objects worth 25gp each), "
                                    + TableC(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (81 <= tableran && tableran <= 85) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d6(7) 50gp gems, and 1d4 items from Magic Table C. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward + "gp\n" + medgem(forthReward) + " (gems worth 50gp each), "
                                    + TableC(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        } else if (86 <= tableran && tableran <= 92) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,4));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d4(5) 25gp art objects, and 1d4 items from Magic Table F. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward + "gp\n" + smallart(forthReward) + " (art objects worth 25gp each), "
                                    + TableF(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        }else if (93 <= tableran && tableran <= 97){
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d6(7) 50gp gems, and 1d4 items from Magic Table F. You rolled a: "
                                    + reward+ "cp " + secReward + "sp " + thirdReward + "gp\n" + medgem(forthReward) + " (gems worth 50gp each), "
                                    + TableF(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        } else if (98 <= tableran && tableran <= 99) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,4));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d4(5) 25gp art objects, and 1 item from Magic Table G. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward + "gp\n" + smallart(forthReward) + " (art objects worth 25gp each), "
                                    + TableG(1)).setEphemeral(true).complete();;
                            break;

                        } else if (tableran == 100) {
                            int reward = (dice(6,6) * 100);
                            secReward = (dice(3,6) * 100);
                            thirdReward = (dice(2,6) * 10);
                            forthReward = (dice(2,6));

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 6d6 x 100(2100)cp, 3d6 x 100 (1050)sp, 2d6 x 10 (70)gp, 2d6(7) 50gp gems, and 1 item from Magic Table G. You rolled a: "
                                    + reward + "cp " + secReward + "sp " + thirdReward + "gp\n" + medgem(forthReward) + " (gems worth 50gp each). "
                                    + TableG(1)).setEphemeral(true).complete();;
                            break;

                        }
//////////////////////////////////////////////////
                    } else if (5 <= cr.getAsInt() && cr.getAsInt() <= 10) {
                        if(1 <= tableran && tableran <= 4) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp" + forthreward + "pp").setEphemeral(true).complete();;
                            break;
                        } else if (5 <= tableran && tableran <= 10) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, and 2d4(5) art objects (worth 25gp each). You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + smallart(fifthreward) + "(art objects worth 25gp each).").setEphemeral(true).complete();;
                            break;
                        } else if (11 <= tableran && tableran <= 16) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, and 3d6(10) gems (worth 50gp each). You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medgem(fifthreward) + "(gems worth 50gp each).").setEphemeral(true).complete();;
                            break;
                        } else if (17 <= tableran && tableran <= 22) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, and 3d6(10) gems (worth 100gp each). You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp" + forthreward + "pp\n" + lggem(fifthreward) + "(gems worth 100gp each).").setEphemeral(true).complete();;
                            break;
                        } else if (23 <= tableran && tableran <= 28) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, and 2d4(5) art objects (worth 250gp each). You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medArt(fifthreward) + "(art objects worth 250gp each).").setEphemeral(true).complete();;
                            break;
                        } else if (29 <= tableran && tableran <= 32) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, and 2d4(5) art objects (worth 25gp each). You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + smallart(fifthreward) + "(art objects worth 25gp each).").setEphemeral(true).complete();;
                            break;
                        } else if (33 <= tableran && tableran <= 36) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 25gp each), and 1d6 on Magic Table A. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medgem(fifthreward) + "(gems worth 50gp each)."
                                    + TableA(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        } else if (37 <= tableran && tableran <= 40){
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 100gp each), and 1d6 on Magic Table A. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + lggem(fifthreward) + "(gems worth 100gp each)."
                                    + TableA(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        } else if (41 <= tableran && tableran <= 44) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 250gp each), and 1d6 on Magic Table A. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medArt(fifthreward) + "(art objects 250gp each)."
                                    + TableA(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        } else if (45 <= tableran && tableran <= 49) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 25gp each), and 1d4 on Magic Table B. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + smallart(fifthreward) + "(art objects worth 25gp each)."
                                    + TableB(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (50 <= tableran && tableran <= 54) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 50gp each), and 1d4 on Magic Table B. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + smallart(fifthreward) + "(gems worth 50gp each)."
                                    + TableB(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (55 <= tableran && tableran <= 59) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 100gp each), and 1d4 on Magic Table B. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + smallart(fifthreward) + "(gems worth 100gp each)."
                                    + TableB(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (60 <= tableran && tableran <= 63) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objectss (worth 250gp each), and 1d4 on Magic Table B. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medArt(fifthreward) + "(art objects worth 250gp each)."
                                    + TableB(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (64 <= tableran && tableran <= 66) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 25gp each), and 1d4 on Magic Table C. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + smallart(fifthreward) + "(art objects worth 25gp each)."
                                    + TableC(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (67 <= tableran && tableran <= 69) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 50gp each), and 1d4 on Magic Table C. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medgem(fifthreward) + "(art objects worth 50gp each)."
                                    + TableC(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (70 <= tableran && tableran <= 72) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 100gp each), and 1d4 on Magic Table C. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + lggem(fifthreward) + "(gems worth 100gp each)."
                                    + TableC(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (73 <= tableran && tableran <= 74) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 250gp each), and 1d4 on Magic Table C. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medArt(fifthreward) + "(art objects worth 250gp each)."
                                    + TableC(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        } else if (75 <= tableran && tableran <= 76) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 25gp each), and once on Magic Table D. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + smallart(fifthreward) + "(art objects worth 25gp each)."
                                    + TableD(1)).setEphemeral(true).complete();;
                            break;

                        } else if (77 <= tableran && tableran <= 78) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 50gp each), and once on Magic Table D. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "\n" + medgem(fifthreward) + "(gems worth 50gp each)."
                                    + TableD(1)).setEphemeral(true).complete();;
                            break;

                        } else if (tableran == 79) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 100gp each), and once on Magic Table D. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + lggem(fifthreward) + "(gems worth 100gp each)."
                                    + TableD(1)).setEphemeral(true).complete();;
                            break;

                        } else if (tableran == 80){
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 250gp each), and once on Magic Table D. You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medArt(fifthreward) + "(art objects worth 250gp each)."
                                    + TableD(1)).setEphemeral(true).complete();;
                            break;

                        } else if (81 <= tableran && tableran <= 84) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 25gp each), and 1d4 times on Magic Table F . You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medArt(fifthreward) + "(art objects worth 25gp each)."
                                    + TableF(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (85 <= tableran && tableran <= 88) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 50gp each), and 1d4 times on Magic Table F . You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medgem(fifthreward) + "(gems worth 50gp each)."
                                    + TableF(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (89 <= tableran && tableran <= 91) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 100gp each), and 1d4 times on Magic Table F . You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + lggem(fifthreward) + "(gems worth 100gp each)."
                                    + TableF(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (92 <= tableran && tableran <= 94) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 250gp each), and 1d4 times on Magic Table F . You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medArt(fifthreward) + "(art objects worth 250gp each)."
                                    + TableF(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (95 <= tableran && tableran <= 96) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 3d6(10) gems (worth 100gp each), and 1d4 times on Magic Table G . You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + lggem(fifthreward) + "(gems worth 100gp each)."
                                    + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (97 <= tableran && tableran <= 98) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 250gp each), and 1d4 times on Magic Table G . You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medArt(fifthreward) + "(art objects worth 250gp each)."
                                    + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;

                        } else if (tableran == 99) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(3,6);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 100gp each), and 1d4 times on Magic Table G . You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + lggem(fifthreward) + "(art objects worth 100gp each)."
                                    + TableH(1)).setEphemeral(true).complete();;
                            break;

                        } else if (tableran == 100) {
                            int reward = dice(2, 6) * 100;
                            int secreward = dice(2, 6) * 1000;
                            int thirdreward = dice(6, 6) * 100;
                            int forthreward = dice(3, 6) * 10;
                            int fifthreward = dice(2,4);

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 2d6 x 100 (700)cp, 2d6 x 1000 (7000)sp, 6d6 x 100 (2100)gp, 3d6 x 10(105)pp, 2d4(5) art objects (worth 250gp each), and 1d4 times on Magic Table H . You rolled a: "
                                    + reward + "cp " + secreward + "sp " + thirdreward + "gp " + forthreward + "pp\n" + medArt(fifthreward) + "(art objects worth 250gp each)."
                                    + TableH(1)).setEphemeral(true).complete();;
                            break;

                        }
//////////////////////////////////////
                    } else if (11 <= cr.getAsInt() && cr.getAsInt() <= 16) {
                        if(1 <= tableran && tableran <= 3){
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp. You rolled a: "
                                    + reward + "gp " + secreward + "pp ").setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 4 <= tableran && tableran <= 6) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 250gp each). You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + medArt(thirdreward) + "art objects (worth 250gp each)").setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 7 <= tableran && tableran <= 9) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 750gp each). You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lgArt(thirdreward) + "art objects (worth 750gp each)").setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 11 <= tableran && tableran <= 12) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) art objects (worth 500gp each). You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lggem(thirdreward) + "gems (worth 500gp each)").setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 13 <= tableran && tableran <= 15) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) art objects (worth 1000gp each). You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + "gems (worth 1000gp each)").setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 16 <= tableran && tableran <= 19) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 250gp each), 1d4 on Magic Table A, and 1d6 times on Magic Table B You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + medArt(thirdreward) + "art objects (worth 250gp each)"
                                    + TableA(dice(1,4)) +TableB(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 20 <= tableran && tableran <= 23) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 750gp each), 1d4 on Magic Table A, and 1d6 times on Magic Table B. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lgArt(thirdreward) + "art objects (worth 750gp each)"
                                    +TableA(dice(1,4)) + TableB(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 24 <= tableran && tableran <= 26) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 500gp each), 1d4 on Magic Table A, and 1d6 times on Magic Table B. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lggem(thirdreward) + "gems (worth 500gp each)"
                                    +TableA(dice(1,4)) + TableB(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 27 <= tableran && tableran <= 29) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d5(10) gems (worth 1000gp each), 1d4 on Magic Table A, and 1d6 times on Magic Table B. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + "gems (worth 1000gp each)"
                                    +TableA(dice(1,4)) + TableB(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 30 <= tableran && tableran <= 35) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 250gp each), and 1d6 times on Magic Table C. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + medArt(thirdreward) + "art objects (worth 250gp each)"
                                    + TableC(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 36 <= tableran && tableran <= 40) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 750gp each), and 1d6 times on Magic Table C. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lgArt(thirdreward) + "art objects (worth 750gp each)"
                                    + TableC(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 41 <= tableran && tableran <= 45) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 500gp each), and 1d6 times on Magic Table C. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lggem(thirdreward) + "gems (worth 500gp each)"
                                    + TableC(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 46 <= tableran && tableran <= 50) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 1000gp each), and 1d6 times on Magic Table C. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + "art objects (worth 1000gp each)"
                                    + TableC(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 51 <= tableran && tableran <= 54) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 250gp each), and 1d4 times on Magic Table D. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + medArt(thirdreward) + "art objects (worth 350gp each)"
                                    + TableD(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 55 <= tableran && tableran <= 58) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 750gp each), and 1d4 times on Magic Table D. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + "art objetcs (worth 750gp each)"
                                    + TableD(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 59 <= tableran && tableran <= 62) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 500gp each), and 1d4 times on Magic Table D. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lggem(thirdreward) + " gems (worth 500gp each)"
                                    + TableD(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 63 <= tableran && tableran <= 66) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 1000gp each), and 1d4 times on Magic Table D. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableD(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 67 <= tableran && tableran <= 68) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 250gp each), and once on Magic Table E. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + medArt(thirdreward) + " art objects (worth 250gp each)"
                                    + TableE(1)).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 69 <= tableran && tableran <= 70) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 750gp each), and once on Magic Table E. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lgArt(thirdreward) + " art objects (worth 750gp each)"
                                    + TableE(1)).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 71 <= tableran && tableran <= 72) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 500gp each), and once on Magic Table E. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lggem(thirdreward) + " gems (worth 500gp each)"
                                    + TableE(1)).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 73 <= tableran && tableran <= 74) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 1000gp each), and once on Magic Table E. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableE(1)).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 75 <= tableran && tableran <= 76) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 250gp each), once on Magic Table F, and 1d4 times on Magic Table G. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + medArt(thirdreward) + " art objects (worth 250gp each)"
                                    + TableF(1) + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 77 <= tableran && tableran <= 78) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 750gp each), once on Magic Table F, and 1d4 times on Magic Table G. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lgArt(thirdreward) + " art objects (worth 750gp each)"
                                    + TableF(1) + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 79 <= tableran && tableran <= 80) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 500gp each), once on Magic Table F, and 1d4 times on Magic Table G. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lggem(thirdreward) + " gems (worth 500gp each)"
                                    + TableF(1) + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 81 <= tableran && tableran <= 82) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 1000gp each), once on Magic Table F, and 1d4 times on Magic Table G. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableF(1) + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 83 <= tableran && tableran <= 85) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 250gp each), and 1d4 times on Magic Table H. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + medArt(thirdreward) + " art objects (worth 250gp each)"
                                    + TableH(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 86 <= tableran && tableran <= 88) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 750gp each), and 1d4 times on Magic Table H. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lgArt(thirdreward) + " art objects (worth 750gp each)"
                                    + TableH(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 89 <= tableran && tableran <= 90) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 500gp each), and 1d4 times on Magic Table H. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lggem(thirdreward) + " gems (worth 500gp each)"
                                    + TableH(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 91 <= tableran && tableran <= 92) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 1000gp each), and 1d4 times on Magic Table H. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableH(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 93 <= tableran && tableran <= 94) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 250gp each), and once on Magic Table I. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + medArt(thirdreward) + " art objects (worth 250gp each)"
                                    + TableH(1)).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 95 <= tableran && tableran <= 96) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(2, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 2d4(5) art objects (worth 750gp each), and once on Magic Table I. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lgArt(thirdreward) + " art objects (worth 750gp each)"
                                    + TableH(1)).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 97 <= tableran && tableran <= 98) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 500gp each), and once on Magic Table I. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + lggem(thirdreward) + " gems (worth 500gp each)"
                                    + TableH(1)).setEphemeral(true).complete();;
                            break;
                        }
                        else if ( 99 <= tableran && tableran <= 100) {
                            int reward = dice(4, 6) * 1000;
                            int secreward = dice(5, 6) * 100;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 4d6 x 1000 (14000)gp, 5d6 x 100 (1750)pp, and 3d6(10) gems (worth 500gp each), and once on Magic Table I. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 500gp each)"
                                    + TableH(1)).setEphemeral(true).complete();;
                            break;
                        }
////////////////////////////////////////////////
                    } else if ( cr.getAsInt() >= 17) {
                        if(1 <= tableran && tableran <= 2){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp. You rolled a: "
                                    + reward + "gp " + secreward + "pp").setEphemeral(true).complete();;
                            break;
                        }
                        else if(3 <= tableran && tableran <=   5){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 3d6(10) gems (worth 1000gp each), and 1d8 times on Magic Table C. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableC(dice(1,8))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(6 <= tableran && tableran <=   8){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 10) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d10(5) art objects (worth 2500gp each), and 1d8 times on Magic Table C. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGArtObject(thirdreward) + " art objects (worth 2500gp each)"
                                    + TableC(dice(1,8))).setEphemeral(true).complete();
                            break;
                        }
                        else if(9 <= tableran && tableran <=  11){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d4(2) art objects (worth 7500gp each), and 1d8 times on Magic Table C. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expArtObject(thirdreward) + " art objects (worth 7500gp each)"
                                    + TableC(dice(1,8))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(12 <= tableran && tableran <= 14){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 8) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d8(4) gems (worth 5000gp each), and 1d8 times on Magic Table C. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expgem(thirdreward) + " gems (worth 5000gp each)"
                                    + TableC(dice(1,8))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(15 <= tableran && tableran <= 22){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 3d6(10) gems (worth 1000gp each), and 1d6 times on Magic Table D. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableD(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(23 <= tableran && tableran <= 30){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 10) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d10(5) art objects (worth 2500gp each), and 1d6 times on Magic Table D. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGArtObject(thirdreward) + " art objects (worth 2500gp each)"
                                    + TableD(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(31 <= tableran && tableran <=  38){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d4(2) art objects (worth 7500gp each), and 1d6 times on Magic Table D. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expArtObject(thirdreward) + " art objects (worth 7500gp each)"
                                    + TableD(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(39 <= tableran && tableran <=  46){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 8) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d8(4) gems (worth 5000gp each), and 1d6 times on Magic Table D. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expgem(thirdreward) + " gems (worth 5000gp each)"
                                    + TableD(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(47 <= tableran && tableran <=  52){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 3d6(10) gems (worth 1000gp each), and 1d6 times on Magic Table E. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableE(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(53 <= tableran && tableran <=  58){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 10) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d10(5) art objects (worth 2500gp each), and 1d6 times on Magic Table E. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGArtObject(thirdreward) + " art objects (worth 2500gp each)"
                                    + TableE(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(59 <= tableran && tableran <=  63){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d4(2) art objects (worth 7500gp each), and 1d6 times on Magic Table E. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expArtObject(thirdreward) + " art objects (worth 7500gp each)"
                                    + TableE(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if(64 <= tableran && tableran <=  68){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 8) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d8(4) gems (worth 5000gp each), and 1d6 times on Magic Table E. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expgem(thirdreward) + " gems (worth 5000gp each)"
                                    + TableE(dice(1,6))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( tableran == 69){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "NICE! The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 3d6(10) gems (worth 1000gp each), and 1d4 times on Magic Table G. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( tableran == 70  ){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 10) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d10(5) art objects (worth 2500gp each), and 1d4 times on Magic Table G. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGArtObject(thirdreward) + " art objects (worth 2500gp each)"
                                    + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( tableran == 71  ){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d4(2) art objects (worth 7500gp each), and 1d4 times on Magic Table G. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expArtObject(thirdreward) + " art objects (worth 7500gp each)"
                                    + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( tableran == 72  ){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 8) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d8(4) gems (worth 5000gp each), and 1d4 times on Magic Table G. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expgem(thirdreward) + " gems (worth 5000gp each)"
                                    + TableG(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( 73 <= tableran && tableran <=  74){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 3d6(10) gems (worth 1000gp each), and 1d4 times on Magic Table H. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableH(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( 75 <= tableran && tableran <=  76){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 10) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d10(5) art objects (worth 2500gp each), and 1d4 times on Magic Table H. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGArtObject(thirdreward) + " art objects (worth 2500gp each)"
                                    + TableH(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( 77 <= tableran && tableran <=  78){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d4(2) art objects (worth 7500gp each), and 1d4 times on Magic Table H. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expArtObject(thirdreward) + " art objects (worth 7500gp each)"
                                    + TableH(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( 79 <= tableran && tableran <=  80){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 8) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d8(4) gems (worth 5000gp each), and 1d4 times on Magic Table H. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expgem(thirdreward) + " gems (worth 5000gp each)"
                                    + TableH(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( 81 <= tableran && tableran <=  85){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(3, 6) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 3d6(10) gems (worth 1000gp each), and 1d4 times on Magic Table I. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGgem(thirdreward) + " gems (worth 1000gp each)"
                                    + TableI(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( 86 <= tableran && tableran <=  90){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 10) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d10(10) art objects (worth 2500gp each), and 1d4 times on Magic Table I. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + veryLGArtObject(thirdreward) + " art objects (worth 2500gp each)"
                                    + TableI(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( 91 <= tableran && tableran <=  95){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 4) ;

                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d4(2) art objects (worth 7500gp each), and 1d4 times on Magic Table I. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expArtObject(thirdreward) + " art objects (worth 7500gp each)"
                                    + TableI(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }
                        else if( 96 <= tableran && tableran <=  100){
                            int reward = dice(12, 6) * 1000;
                            int secreward = dice(8, 6) * 1000;
                            int thirdreward = dice(1, 8) ;
                            event.getHook().sendMessage("Cr was: " + cr.getAsInt() + "\n" + "You rolled a: " + tableran + " for your table\n" +
                                    "The reward is 12d6 x 1000 (42000)gp, 8d6 x 1000 (28000)pp, 1d8(4) gems (worth 5000gp each), and 1d4 times on Magic Table I. You rolled a: "
                                    + reward + "gp " + secreward + "pp\n" + expgem(thirdreward) + " gems (worth 5000gp each)"
                                    + TableI(dice(1,4))).setEphemeral(true).complete();;
                            break;
                        }

                    }
                default:
                    event.getHook().sendMessage("You want to default do not pass go do not collect 200 dollars").setEphemeral(true).complete();
                    event.getHook().sendMessage("You rolled a: " + randomNum + " for your table").setEphemeral(true).complete();
            }

        }
    }
    // This is an attempt to reduce the same code over and over it however doesn't loop properly
    private static String MessageBuilder(List<String> text){
        StringBuilder builder = new StringBuilder();
        List<String> messages = new ArrayList<>();
        int MAX_CONTENT_LENGTH = 2000;
        for (String item : text) {
            if (builder.length() + item.length() + 1 > MAX_CONTENT_LENGTH){
                messages.add(builder.toString());
                builder.setLength(0);
            }
            builder.append(item).append(", ");
        }
        builder.deleteCharAt(builder.length() -2);
        messages.add(builder.toString());
        for (String message : messages) {System.out.println(message);}
        return messages.toString().replace("[","").replace("]","");
    }
    private static String MessageBuilderwithreturn(List<String> text){
        StringBuilder builder = new StringBuilder();
        List<String> messages = new ArrayList<>();
        int MAX_CONTENT_LENGTH = 2000;
        for (String item : text) {
            if (builder.length() + item.length() + 1 > MAX_CONTENT_LENGTH){
                messages.add(builder.toString());
                builder.setLength(0);
            }
            builder.append(item).append(" \n");
        }
        builder.deleteCharAt(builder.length() -2);
        messages.add(builder.toString());
        for (String message : messages) {System.out.println(message);}
        return messages.toString().replace("[","").replace("]","");
    }
    private static int dice(int timesrolled, int diceSize){
        Random diceRand = new Random();
        int diceresult = 0;
        for(int i = 0; i < timesrolled; i++) {
            diceresult = diceresult + diceRand.nextInt(diceSize - 1 + 1) + 1;
        }

        return diceresult;
    }
    private static List<String> Resistance(){
        Random resistanceRand = new Random();
        List<String> resistance = new ArrayList<>();
        int resistRand = resistanceRand.nextInt(10 - 1 + 1) +1;
        switch (resistRand){
            case 1 -> resistance.add("Acid");
            case 2 -> resistance.add("Cold");
            case 3 -> resistance.add("Fire");
            case 4 -> resistance.add("Force");
            case 5 -> resistance.add("Lightning");
            case 6 -> resistance.add("Necrotic");
            case 7 -> resistance.add("Poison");
            case 8 -> resistance.add("Psychic");
            case 9 -> resistance.add("Radiant");
            case 10 ->resistance.add("Thunder");
        }
        return resistance;
    }

    private static String spellScrollsCantrip(){
        Random cantripRand = new Random();
        List<String> cantrip = new ArrayList<>();
        int odds = cantripRand.nextInt(45 - 1 + 1) +1;
        switch (odds){
            case 1 -> cantrip.add("Acid Splash");
            case 2 -> cantrip.add("Blade Ward");
            case 3 -> cantrip.add("Booming Blade");
            case 4 -> cantrip.add("Chill Touch");
            case 5 -> cantrip.add("Control Flames");
            case 6 -> cantrip.add("Create Bonfire");
            case 7 -> cantrip.add("Dancing Lights");
            case 8 -> cantrip.add("Druidcraft");
            case 9 -> cantrip.add("Eldritch Blast");
            case 10 -> cantrip.add("Encode Thoughts");
            case 11 -> cantrip.add("Fire Bolt");
            case 12 -> cantrip.add("Friends");
            case 13 -> cantrip.add("Frostbite");
            case 14 -> cantrip.add("Green-Flame Blade");
            case 15 -> cantrip.add("Guidance");
            case 16 -> cantrip.add("Gust");
            case 17 -> cantrip.add("Infestation");
            case 18 -> cantrip.add("Light");
            case 19 -> cantrip.add("Lightning Lure");
            case 20 -> cantrip.add("Mage Hand");
            case 21 -> cantrip.add("Magic Stone");
            case 22 -> cantrip.add("Mending");
            case 23 -> cantrip.add("Message");
            case 24 -> cantrip.add("Mind Sliver");
            case 25 -> cantrip.add("Minor Illusion");
            case 26 -> cantrip.add("Mold Earth");
            case 27 -> cantrip.add("Poison Spray");
            case 28 -> cantrip.add("Prestidigitation");
            case 29 -> cantrip.add("Primal Savagery");
            case 30 -> cantrip.add("Produce Flame");
            case 31 -> cantrip.add("Ray of Frost");
            case 32 -> cantrip.add("Resistance");
            case 33 -> cantrip.add("Sacred Flame");
            case 34 -> cantrip.add("Shape Water");
            case 35 -> cantrip.add("Shillelagh");
            case 36 -> cantrip.add("Shocking Grasp");
            case 37 -> cantrip.add("Spare the Dying");
            case 38 -> cantrip.add("Sword Burst");
            case 39 -> cantrip.add("Thaumaturgy");
            case 40 -> cantrip.add("Thorn Whip");
            case 41 -> cantrip.add("Thunderclap");
            case 42 -> cantrip.add("Toll the Dead");
            case 43 -> cantrip.add("True Strike");
            case 44 -> cantrip.add("Vicious Mockery");
            case 45 -> cantrip.add("Word of Radiance");
        }
        return cantrip.toString();
    }
    private static String spellScrollsLvLOne(){
        Random LvLoneRand = new Random();
        List<String> spellone = new ArrayList<>();
        int odds = LvLoneRand.nextInt(46 - 1 + 1) +1;
        switch (odds){
            case 1-> spellone.add("Absorb Elements");
            case 2-> spellone.add("Alarm");
            case 3-> spellone.add("Animal Friendship");
            case 4-> spellone.add("Armor of Agathys");
            case 5-> spellone.add("Arms of Hadar");
            case 6-> spellone.add("Bane");
            case 7-> spellone.add("Beast Bond");
            case 8-> spellone.add("Bless");
            case 9-> spellone.add("Burning Hands");
            case 10-> spellone.add("Catapult");
            case 12-> spellone.add("Cause Fear");
            case 13-> spellone.add("Ceremony");
            case 14-> spellone.add("Chaos Bolt");
            case 15-> spellone.add("Charm Person");
            case 16-> spellone.add("Chromatic Orb");
            case 17-> spellone.add("Color Spray");
            case 18-> spellone.add("Command");
            case 19-> spellone.add("Compelled Duel");
            case 20-> spellone.add("Comprehend Languages");
            case 21-> spellone.add("Create or Destroy Water");
            case 22-> spellone.add("Cure Wounds");
            case 23-> spellone.add("Detect Evil and Good");
            case 24-> spellone.add("Detect Magic");
            case 25-> spellone.add("Detect Poison and Disease");
            case 26-> spellone.add("Disguise Self");
            case 27-> spellone.add("Dissonant Whispers");
            case 28-> spellone.add("Distort Value");
            case 29-> spellone.add("Divine Favor");
            case 30-> spellone.add("Earth Tremor");
            case 31-> spellone.add("Ensnaring Strike");
            case 32-> spellone.add("Entangle");
            case 33-> spellone.add("Expeditious Retreat");
            case 34-> spellone.add("Faerie Fire");
            case 35-> spellone.add("False Life");
            case 36-> spellone.add("Feather Fall");
            case 37-> spellone.add("Find Familiar");
            case 38-> spellone.add("Fog Cloud");
            case 39-> spellone.add("Frost Fingers");
            case 40-> spellone.add("Goodberry");
            case 41-> spellone.add("Grease");
            case 42-> spellone.add("Guiding Bolt");
            case 43-> spellone.add("Hail of Thorns");
            case 44-> spellone.add("Healing Word");
            case 45-> spellone.add("Hellish Rebuke");
            case 46-> spellone.add("Heroism");
        }
        return spellone.toString();
    }
    private static String spellScrollsLvLTwo(){
        Random LvLtwoRand = new Random();
        List<String> spelltwo = new ArrayList<>();
        int odds = LvLtwoRand.nextInt(84 - 1 + 1) +1;
        switch (odds){
            case 1-> spelltwo.add("Aganazzar's Scorcher");
            case 2-> spelltwo.add("Aid");
            case 3-> spelltwo.add("Air Bubble");
            case 4-> spelltwo.add("Alter Self");
            case 5-> spelltwo.add("Animal Messenger");
            case 6-> spelltwo.add("Arcane Lock");
            case 7-> spelltwo.add("Augury");
            case 8-> spelltwo.add("Barkskin");
            case 9-> spelltwo.add("Beast Sense");
            case 10-> spelltwo.add("Blindness/Deafness");
            case 11-> spelltwo.add("Blur");
            case 12-> spelltwo.add("Borrowed Knowledge");
            case 13-> spelltwo.add("Branding Smite");
            case 14-> spelltwo.add("Calm Emotions");
            case 15-> spelltwo.add("Cloud of Daggers");
            case 16-> spelltwo.add("Continual Flame");
            case 17-> spelltwo.add("Cordon of Arrows");
            case 18-> spelltwo.add("Crown of Madness");
            case 19-> spelltwo.add("Darkness");
            case 20-> spelltwo.add("Darkvision");
            case 21-> spelltwo.add("Detect Thoughts");
            case 22-> spelltwo.add("Dragon's Breath");
            case 23-> spelltwo.add("Dust Devil");
            case 24-> spelltwo.add("Earthbind");
            case 25-> spelltwo.add("Enhance Ability");
            case 26-> spelltwo.add("Enlarge/Reduce");
            case 27-> spelltwo.add("Enthrall");
            case 28-> spelltwo.add("Find Steed");
            case 29-> spelltwo.add("Find Traps");
            case 30-> spelltwo.add("Flame Blade");
            case 31-> spelltwo.add("Flaming Sphere");
            case 32-> spelltwo.add("Gentle Repose");
            case 33-> spelltwo.add("Gift of Gab");
            case 34-> spelltwo.add("Gust of Wind");
            case 35-> spelltwo.add("Healing Spirit");
            case 36-> spelltwo.add("Heat Metal");
            case 37-> spelltwo.add("Hold Person");
            case 38-> spelltwo.add("Invisibility");
            case 39-> spelltwo.add("Jim's Glowing Coin");
            case 40-> spelltwo.add("Kinetic Jaunt");
            case 41-> spelltwo.add("Knock");
            case 42-> spelltwo.add("Lesser Restoration");
            case 43-> spelltwo.add("Levitate");
            case 44-> spelltwo.add("Locate Animals or Plants");
            case 45-> spelltwo.add("Locate Object");
            case 46-> spelltwo.add("Magic Mouth");
            case 47-> spelltwo.add("Magic Weapon");
            case 48-> spelltwo.add("Maximilian's Earthen Grasp");
            case 49-> spelltwo.add("Melf's Acid Arrow");
            case 50-> spelltwo.add("Mind Spike");
            case 51-> spelltwo.add("Mirror Image");
            case 52-> spelltwo.add("Misty Step");
            case 53-> spelltwo.add("Moonbeam");
            case 54-> spelltwo.add("Nathair's Mischief");
            case 55-> spelltwo.add("Nystul's Magic Aura");
            case 56-> spelltwo.add("Pass without Trace");
            case 57-> spelltwo.add("Phantasmal Force");
            case 58-> spelltwo.add("Prayer of Healing");
            case 59-> spelltwo.add("Protection from Poison");
            case 60-> spelltwo.add("Pyrotechnics");
            case 61-> spelltwo.add("Ray of Enfeeblement");
            case 62-> spelltwo.add("Rime's Binding Ice");
            case 63-> spelltwo.add("Rope Trick");
            case 64-> spelltwo.add("Scorching Ray");
            case 65-> spelltwo.add("See Invisibility");
            case 66-> spelltwo.add("Shadow Blade");
            case 67-> spelltwo.add("Shatter");
            case 68-> spelltwo.add("Silence");
            case 69-> spelltwo.add("Skywrite");
            case 70-> spelltwo.add("Snilloc's Snowball Swarm");
            case 71-> spelltwo.add("Spider Climb");
            case 72-> spelltwo.add("Spike Growth");
            case 73-> spelltwo.add("Spiritual Weapon");
            case 74-> spelltwo.add("Spray of Cards ");
            case 75-> spelltwo.add("Suggestion");
            case 76-> spelltwo.add("Summon Beast");
            case 77-> spelltwo.add("Tasha's Mind Whip");
            case 78-> spelltwo.add("Vortex Warp");
            case 79-> spelltwo.add("Warding Bond");
            case 80-> spelltwo.add("Warding Wind");
            case 81-> spelltwo.add("Warp Sense");
            case 82-> spelltwo.add("Web");
            case 83-> spelltwo.add("Wither and Bloom");
            case 84-> spelltwo.add("Zone of Truth");
        }
        return spelltwo.toString();
    }
    private static String spellScrollsLvLThree(){
        Random LvLthreeRand = new Random();
        List<String> spellthree = new ArrayList<>();
        int odds = LvLthreeRand.nextInt(72 - 1 + 1) +1;
        switch (odds){
            case 1->  spellthree.add("Animate Dead");
            case 2->  spellthree.add("Antagonize");
            case 3->  spellthree.add("Ashardalon's Stride");
            case 4->  spellthree.add("Aura of Vitality");
            case 5->  spellthree.add("Beacon of Hope");
            case 6->  spellthree.add("Bestow Curse");
            case 7->  spellthree.add("Blinding Smite");
            case 8->  spellthree.add("Blink");
            case 9->  spellthree.add("Call Lightning");
            case 10-> spellthree.add("Catnap");
            case 11-> spellthree.add("Clairvoyance");
            case 12-> spellthree.add("Conjure Animals");
            case 13-> spellthree.add("Conjure Barrage");
            case 14-> spellthree.add("Counterspell");
            case 15-> spellthree.add("Create Food and Water");
            case 16-> spellthree.add("Crusader's Mantle");
            case 17-> spellthree.add("Daylight");
            case 18-> spellthree.add("Dispel Magic");
            case 19-> spellthree.add("Elemental Weapon");
            case 20-> spellthree.add("Enemies Abound");
            case 21-> spellthree.add("Erupting Earth");
            case 22-> spellthree.add("Fast Friends");
            case 23-> spellthree.add("Fear");
            case 24-> spellthree.add("Feign Death");
            case 25-> spellthree.add("Fireball");
            case 26-> spellthree.add("Flame Arrows");
            case 27-> spellthree.add("Fly");
            case 28-> spellthree.add("Gaseous Form");
            case 29-> spellthree.add("Glyph of Warding");
            case 30-> spellthree.add("Haste");
            case 31-> spellthree.add("Hunger of Hadar");
            case 32-> spellthree.add("Hypnotic Pattern");
            case 33-> spellthree.add("Incite Greed");
            case 34-> spellthree.add("Intellect Fortress");
            case 35-> spellthree.add("Leomund's Tiny Hut");
            case 36-> spellthree.add("Life Transference");
            case 37-> spellthree.add("Lightning Arrow");
            case 38-> spellthree.add("Lightning Bolt");
            case 39-> spellthree.add("Magic Circle");
            case 40-> spellthree.add("Major Image");
            case 41-> spellthree.add("Mass Healing Word");
            case 42-> spellthree.add("Meld into Stone");
            case 43-> spellthree.add("Melf's Minute Meteors");
            case 44-> spellthree.add("Motivational Speech");
            case 45-> spellthree.add("Nondetection");
            case 46-> spellthree.add("Phantom Steed");
            case 47-> spellthree.add("Plant Growth");
            case 48-> spellthree.add("Protection from Energy");
            case 49-> spellthree.add("Remove Curse");
            case 50-> spellthree.add("Revivify");
            case 51-> spellthree.add("Sending");
            case 52-> spellthree.add("Sleet Storm");
            case 53-> spellthree.add("Slow");
            case 54-> spellthree.add("Speak with Dead");
            case 55-> spellthree.add("Speak with Plants");
            case 56-> spellthree.add("Spirit Guardians");
            case 57-> spellthree.add("Spirit Shroud");
            case 58-> spellthree.add("Stinking Cloud");
            case 59-> spellthree.add("Summon Fey");
            case 60-> spellthree.add("Summon Lesser Demons");
            case 61-> spellthree.add("Summon Shadowspawn");
            case 62-> spellthree.add("Summon Undead");
            case 63-> spellthree.add("Thunder Step");
            case 64-> spellthree.add("Tidal Wave");
            case 65-> spellthree.add("Tiny Servant");
            case 66-> spellthree.add("Tongues");
            case 67-> spellthree.add("Vampiric Touch");
            case 68-> spellthree.add("Wall of Sand");
            case 69-> spellthree.add("Wall of Water");
            case 70-> spellthree.add("Water Breathing");
            case 71-> spellthree.add("Water Walk");
            case 72-> spellthree.add("Wind Wall");

        }
        return spellthree.toString();
    }
    private static String spellScrollsLvLFour(){
        Random LvLfourRand = new Random();
        List<String> spellfour = new ArrayList<>();
        int odds = LvLfourRand.nextInt(51 - 1 + 1) +1;
        switch (odds){
            case 1->  spellfour.add("Arcane Eye");
            case 2->  spellfour.add("Aura of Life");
            case 3->  spellfour.add("Aura of Purity");
            case 4->  spellfour.add("Banishment");
            case 5->  spellfour.add("Blight");
            case 6->  spellfour.add("Charm Monster");
            case 7->  spellfour.add("Compulsion");
            case 8->  spellfour.add("Confusion");
            case 9->  spellfour.add("Conjure Minor Elementals");
            case 10-> spellfour.add("Conjure Woodland Beings");
            case 11-> spellfour.add("Control Water");
            case 12-> spellfour.add("Death Ward");
            case 13-> spellfour.add("Dimension Door");
            case 14-> spellfour.add("Divination");
            case 15-> spellfour.add("Dominate Beast");
            case 16-> spellfour.add("Elemental Bane");
            case 17-> spellfour.add("Evard's Black Tentacles");
            case 18-> spellfour.add("Fabricate");
            case 19-> spellfour.add("Find Greater Steed");
            case 20-> spellfour.add("Fire Shield");
            case 21-> spellfour.add("Freedom of Movement");
            case 22-> spellfour.add("Gate Seal");
            case 23-> spellfour.add("Giant Insect");
            case 24-> spellfour.add("Grasping Vine");
            case 25-> spellfour.add("Greater Invisibility");
            case 26-> spellfour.add("Guardian of Faith");
            case 27-> spellfour.add("Guardian of Nature");
            case 28-> spellfour.add("Hallucinatory Terrain");
            case 29-> spellfour.add("Ice Storm");
            case 30-> spellfour.add("Leomund's Secret Chest");
            case 31-> spellfour.add("Locate Creature");
            case 32-> spellfour.add("Mordenkainen's Faithful Hound");
            case 33-> spellfour.add("Mordenkainen's Private Sanctum");
            case 34-> spellfour.add("Otiluke's Resilient Sphere");
            case 35-> spellfour.add("Phantasmal Killer");
            case 36-> spellfour.add("Polymorph");
            case 37-> spellfour.add("Raulothim's Psychic Lance");
            case 38-> spellfour.add("Shadow of Moil");
            case 39-> spellfour.add("Sickening Radiance");
            case 40-> spellfour.add("Spirit of Death");
            case 41-> spellfour.add("Staggering Smite");
            case 42-> spellfour.add("Stone Shape");
            case 43-> spellfour.add("Stoneskin");
            case 44-> spellfour.add("Storm Sphere");
            case 45-> spellfour.add("Summon Aberration");
            case 46-> spellfour.add("Summon Construct");
            case 47-> spellfour.add("Summon Elemental");
            case 48-> spellfour.add("Summon Greater Demon");
            case 49-> spellfour.add("Vitriolic Sphere");
            case 50-> spellfour.add("Wall of Fire");
            case 51-> spellfour.add("Watery Sphere");
        }
        return spellfour.toString();
    }
    private static String spellScrollsLvLFive(){
        Random LvLfiveRand = new Random();
        List<String> spellfive = new ArrayList<>();
        int odds = LvLfiveRand.nextInt(61 - 1 + 1) +1;
        switch (odds){
            case 1->  spellfive.add("Animate Objects");
            case 2->  spellfive.add("Antilife Shell");
            case 3->  spellfive.add("Awaken");
            case 4->  spellfive.add("Banishing Smite");
            case 5->  spellfive.add("Bigby's Hand");
            case 6->  spellfive.add("Circle of Power");
            case 7->  spellfive.add("Cloudkill");
            case 8->  spellfive.add("Commune");
            case 9->  spellfive.add("Commune with Nature");
            case 10-> spellfive.add("Cone of Cold");
            case 11-> spellfive.add("Conjure Elemental");
            case 12-> spellfive.add("Conjure Volley");
            case 13-> spellfive.add("Contact Other Plane");
            case 14-> spellfive.add("Contagion");
            case 15-> spellfive.add("Control Winds");
            case 16-> spellfive.add("Create Spelljamming Helm");
            case 17-> spellfive.add("Creation");
            case 18-> spellfive.add("Danse Macabre");
            case 19-> spellfive.add("Dawn");
            case 20-> spellfive.add("Destructive Wave");
            case 21-> spellfive.add("Dispel Evil and Good");
            case 22-> spellfive.add("Dominate Person");
            case 23-> spellfive.add("Dream");
            case 24-> spellfive.add("Enervation");
            case 25-> spellfive.add("Far Step");
            case 26-> spellfive.add("Flame Strike");
            case 27-> spellfive.add("Geas");
            case 28-> spellfive.add("Greater Restoration");
            case 29-> spellfive.add("Hallow");
            case 30-> spellfive.add("Hold Monster");
            case 31-> spellfive.add("Holy Weapon");
            case 32-> spellfive.add("Immolation");
            case 33-> spellfive.add("Infernal Calling");
            case 34-> spellfive.add("Insect Plague");
            case 35-> spellfive.add("Legend Lore");
            case 36-> spellfive.add("Maelstrom");
            case 37-> spellfive.add("Mass Cure Wounds");
            case 38-> spellfive.add("Mislead");
            case 39-> spellfive.add("Modify Memory");
            case 40-> spellfive.add("Negative Energy Flood");
            case 41-> spellfive.add("Passwall");
            case 42-> spellfive.add("Planar Binding");
            case 43-> spellfive.add("Raise Dead");
            case 44-> spellfive.add("Rary's Telepathic Bond");
            case 45-> spellfive.add("Reincarnate");
            case 46-> spellfive.add("Scrying");
            case 47-> spellfive.add("Seeming");
            case 48-> spellfive.add("Skill Empowerment");
            case 49-> spellfive.add("Steel Wind Strike");
            case 50-> spellfive.add("Summon Celestial");
            case 51-> spellfive.add("Summon Draconic Spirit");
            case 52-> spellfive.add("Swift Quiver");
            case 53-> spellfive.add("Synaptic Static");
            case 54-> spellfive.add("Telekinesis");
            case 55-> spellfive.add("Teleportation Circle");
            case 56-> spellfive.add("Transmute Rock");
            case 57-> spellfive.add("Tree Stride");
            case 58-> spellfive.add("Wall of Force");
            case 59-> spellfive.add("Wall of Light");
            case 60-> spellfive.add("Wall of Stone");
            case 61-> spellfive.add("Wrath of Nature");
        }
        return spellfive.toString();
    }
    private static String spellScrollsLvLSix(){
        Random LvLsixRand = new Random();
        List<String> spellsix = new ArrayList<>();
        int odds = LvLsixRand.nextInt(47 - 1 + 1) +1;
        switch (odds){
            case 1->  spellsix.add("Arcane Gate");
            case 2->  spellsix.add("Blade Barrier");
            case 3->  spellsix.add("Bones of the Earth");
            case 4->  spellsix.add("Chain Lightning");
            case 5->  spellsix.add("Circle of Death");
            case 6->  spellsix.add("Conjure Fey");
            case 7->  spellsix.add("Contingency");
            case 8->  spellsix.add("Create Homunculus");
            case 9->  spellsix.add("Create Undead");
            case 10-> spellsix.add("Disintegrate");
            case 11-> spellsix.add("Drawmij's Instant Summons");
            case 12-> spellsix.add("Druid Grove");
            case 13-> spellsix.add("Eyebite");
            case 14-> spellsix.add("Find the Path");
            case 15-> spellsix.add("Fizban's Platinum Shield");
            case 16-> spellsix.add("Flesh to Stone");
            case 17-> spellsix.add("Forbiddance");
            case 18-> spellsix.add("Globe of Invulnerability");
            case 19-> spellsix.add("Guards and Wards");
            case 20-> spellsix.add("Harm");
            case 21-> spellsix.add("Heal");
            case 22-> spellsix.add("Heroes' Feast");
            case 23-> spellsix.add("Investiture of Flame");
            case 24-> spellsix.add("Investiture of Ice");
            case 25-> spellsix.add("Investiture of Stone");
            case 26-> spellsix.add("Investiture of Wind");
            case 27-> spellsix.add("Magic Jar");
            case 28-> spellsix.add("Mass Suggestion");
            case 29-> spellsix.add("Mental Prison");
            case 30-> spellsix.add("Move Earth");
            case 31-> spellsix.add("Otiluke's Freezing Sphere");
            case 32-> spellsix.add("Otto's Irresistible Dance");
            case 33-> spellsix.add("Planar Ally");
            case 34-> spellsix.add("Primordial Ward");
            case 35-> spellsix.add("Programmed Illusion");
            case 36-> spellsix.add("Scatter");
            case 37-> spellsix.add("Soul Cage");
            case 38-> spellsix.add("Summon Fiend");
            case 39-> spellsix.add("Sunbeam");
            case 40-> spellsix.add("Tasha's Otherworldly Guise");
            case 41-> spellsix.add("Tenser's Transformation");
            case 42-> spellsix.add("Transport via Plants");
            case 43-> spellsix.add("True Seeing");
            case 44-> spellsix.add("Wall of Ice");
            case 45-> spellsix.add("Wall of Thorns");
            case 46-> spellsix.add("Wind Walk");
            case 47-> spellsix.add("Word of Recall");
        }
        return spellsix.toString();
    }
    private static String spellScrollsLvLSeven(){
        Random LvLsevenRand = new Random();
        List<String> spellseven = new ArrayList<>();
        int odds = LvLsevenRand.nextInt(27 - 1 + 1) +1;
        switch (odds){
            case 1->  spellseven.add("Conjure Celestial");
            case 2->  spellseven.add("Create Magen");
            case 3->  spellseven.add("Crown of Stars");
            case 4->  spellseven.add("Delayed Blast Fireball");
            case 5->  spellseven.add("Divine Word");
            case 6->  spellseven.add("Draconic Transformation");
            case 7->  spellseven.add("Dream of the Blue Veil");
            case 8->  spellseven.add("Etherealness");
            case 9->  spellseven.add("Finger of Death");
            case 10-> spellseven.add("Fire Storm");
            case 11-> spellseven.add("Forcecage");
            case 12-> spellseven.add("Mirage Arcane");
            case 13-> spellseven.add("Mordenkainen's Magnificent Mansion");
            case 14-> spellseven.add("Mordenkainen's Sword");
            case 15-> spellseven.add("Plane Shift");
            case 16-> spellseven.add("Power Word Pain");
            case 17-> spellseven.add("Prismatic Spray");
            case 18-> spellseven.add("Project Image");
            case 19-> spellseven.add("Regenerate");
            case 20-> spellseven.add("Resurrection");
            case 21-> spellseven.add("Reverse Gravity");
            case 22-> spellseven.add("Sequester");
            case 23-> spellseven.add("Simulacrum");
            case 24-> spellseven.add("Symbol");
            case 25-> spellseven.add("Teleport");
            case 26-> spellseven.add("Temple of the Gods");
            case 27-> spellseven.add("Whirlwind");
        }
        return spellseven.toString();
    }
    private static String spellScrollsLvLEight(){
        Random LvLeightRand = new Random();
        List<String> spelleight = new ArrayList<>();
        int odds = LvLeightRand.nextInt(22 - 1 + 1) +1;
        switch (odds){
            case 1->  spelleight.add("Abi-Dalzim's Horrid Wilting");
            case 2->  spelleight.add("Animal Shapes");
            case 3->  spelleight.add("Antimagic Field");
            case 4->  spelleight.add("Antipathy/Sympathy");
            case 5->  spelleight.add("Clone");
            case 6->  spelleight.add("Control Weather");
            case 7->  spelleight.add("Demiplane");
            case 8->  spelleight.add("Dominate Monster");
            case 9->  spelleight.add("Earthquake");
            case 10-> spelleight.add("Feeblemind");
            case 11-> spelleight.add("Glibness");
            case 12-> spelleight.add("Holy Aura");
            case 13-> spelleight.add("Illusory Dragon");
            case 14-> spelleight.add("Incendiary Cloud");
            case 15-> spelleight.add("Maddening Darkness");
            case 16-> spelleight.add("Maze");
            case 17-> spelleight.add("Mighty Fortress");
            case 18-> spelleight.add("Mind Blank");
            case 19-> spelleight.add("Power Word Stun");
            case 20-> spelleight.add("Sunburst");
            case 21-> spelleight.add("Telepathy");
            case 22-> spelleight.add("Tsunami");
        }
        return spelleight.toString();
    }
    private static String spellScrollsLvLNine(){
        Random LvLnineRand = new Random();
        List<String> spellnine = new ArrayList<>();
        int odds = LvLnineRand.nextInt(20 - 1 + 1) +1;
        switch (odds){
            case 1->  spellnine.add("Astral Projection");
            case 2->  spellnine.add("Blade of Disaster");
            case 3->  spellnine.add("Foresight");
            case 4->  spellnine.add("Gate");
            case 5->  spellnine.add("Imprisonment");
            case 6->  spellnine.add("Invulnerability");
            case 7->  spellnine.add("Mass Heal");
            case 8->  spellnine.add("Mass Polymorph");
            case 9->  spellnine.add("Meteor Swarm");
            case 10-> spellnine.add("Power Word Heal");
            case 11-> spellnine.add("Power Word Kill");
            case 12-> spellnine.add("Prismatic Wall");
            case 13-> spellnine.add("Psychic Scream");
            case 14-> spellnine.add("Shapechange");
            case 15-> spellnine.add("Storm of Vengeance");
            case 16-> spellnine.add("Time Stop");
            case 17-> spellnine.add("True Polymorph");
            case 18-> spellnine.add("True Resurrection");
            case 19-> spellnine.add("Weird");
            case 20-> spellnine.add("Wish");
        }
        return spellnine.toString();
    }
    private static String smallart(int rollTotal) {
        Random artRand = new Random();
        List<String> smallArtObject = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++) {
            int odds = artRand.nextInt(10 - 1 + 1) +1;
            switch (odds) {
                case 1 -> smallArtObject.add("Silver ewer");
                case 2 -> smallArtObject.add("Carved bone statuette");
                case 3 -> smallArtObject.add("Small gold bracelet");
                case 4 -> smallArtObject.add("Cloth-of-gold vestments");
                case 5 -> smallArtObject.add("Black velvet mask stitched with silver thread");
                case 6 -> smallArtObject.add("Copper chalice with silver filigree");
                case 7 -> smallArtObject.add("Pair of engraved bone dice");
                case 8 -> smallArtObject.add("Small mirror set in a painted wooden frame");
                case 9 -> smallArtObject.add("Embroidered silk handkerchief");
                case 10 -> smallArtObject.add("Gold locket with a painted portrait inside");
            }
        }
        return MessageBuilder(smallArtObject).toString().replace("[","").replace("]","");
    }
    private static String medArt(int rollTotal) {
        Random martRand = new Random();
        List<String> medArtObject = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++) {
            int odds = martRand.nextInt(10 - 1 + 1) +1;
            switch (odds) {
                case 1 -> medArtObject.add("Gold ring set with bloodstones");
                case 2 -> medArtObject.add("Carved ivory statuette");
                case 3 -> medArtObject.add("Large gold bracelet");
                case 4 -> medArtObject.add("Silver necklace with a gemstone pendant");
                case 5 -> medArtObject.add("Bronze crown");
                case 6 -> medArtObject.add("Silk robe with gold embroidery");
                case 7 -> medArtObject.add("Large well-made tapestry");
                case 8 -> medArtObject.add("Brass mug with jade inlay");
                case 9 -> medArtObject.add("Box of turquoise animal figurines");
                case 10 -> medArtObject.add("Gold bird cage with electrum filigree");
            }
        }
        return MessageBuilder(medArtObject).toString().replace("[","").replace("]","");
    }
    private static String lgArt(int rollTotal) {
        Random lartRand = new Random();

        List<String> lgArtObject = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++) {
            int odds = lartRand.nextInt(10 - 1 + 1) +1;
            switch (odds) {
                case 1 -> lgArtObject.add("Silver chalice set with moonstones");
                case 2 -> lgArtObject.add("Silver-plated steellongsword with jet set in hilt");
                case 3 -> lgArtObject.add("Carved harp of exotic wood with ivory inlay and zircon gems");
                case 4 -> lgArtObject.add("Small gold idol");
                case 5 -> lgArtObject.add("Gold dragon comb set with red garnets as eyes");
                case 6 -> lgArtObject.add("Bottle stopper cork embossed with gold leaf and set with amethysts");
                case 7 -> lgArtObject.add("Ceremonial electrum dagger with a black pearl in the pommel");
                case 8 -> lgArtObject.add("Silver and gold brooch");
                case 9 -> lgArtObject.add("Obsidian statuette with gold fittings and inlay");
                case 10 -> lgArtObject.add("Painted gold war mask");
            }
        }
        return MessageBuilder(lgArtObject).toString().replace("[","").replace("]","");
    }
    private static String veryLGArtObject(int rollTotal) {
        Random vlartRand = new Random();

        List<String> veryLGArtObject = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++) {
            int odds = vlartRand.nextInt(10 - 1 + 1) +1;
            switch (odds) {
                case 1 -> veryLGArtObject.add("Fine gold chain set with a fire opal");
                case 2 -> veryLGArtObject.add("Old masterpiece painting");
                case 3 -> veryLGArtObject.add("Embroidered silk and velvet mantle set with numerous moonstones");
                case 4 -> veryLGArtObject.add("Platinum bracelet set with a sapphire");
                case 5 -> veryLGArtObject.add("Embroidered glove set with jewel chips");
                case 6 -> veryLGArtObject.add("Jeweled anklet");
                case 7 -> veryLGArtObject.add("Gold music box");
                case 8 -> veryLGArtObject.add("Gold circlet set with four aquamarines");
                case 9 -> veryLGArtObject.add("Eye patch with a mock eye set in blue sapphire andmoonstone");
                case 10 -> veryLGArtObject.add("A necklace string of small pink pearls");
            }
        }

        return MessageBuilder(veryLGArtObject).toString().replace("[","").replace("]","");
    }
    private static String expArtObject(int rollTotal) {
        Random eartRand = new Random();
        List<String> expArtObject = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++) {
            int odds = eartRand.nextInt(8 - 1 + 1) +1;
            switch (odds) {
                case 1 -> expArtObject.add("Jeweled gold crown");
                case 2 -> expArtObject.add("Jeweled platinum ring");
                case 3 -> expArtObject.add("Small gold statuette set with rubies");
                case 4 -> expArtObject.add("Gold cup set with emeralds");
                case 5 -> expArtObject.add("Gold jewelry box with platinum filigree");
                case 6 -> expArtObject.add("Painted gold child's sarcophagus");
                case 7 -> expArtObject.add("Jade game board with solid gold playing pieces");
                case 8 -> expArtObject.add("Bejeweled ivory drinking horn with gold filigree");
            }
        }

        return MessageBuilder(expArtObject).toString().replace("[","").replace("]","");
    }
    private static String smallgem(int rollTotal) {
        Random gemRand = new Random();

        List<String> smallgem = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = gemRand.nextInt(12 - 1 + 1) +1;
            switch (odds){
                case 1->  smallgem.add("Azurite (opaque mottled deep blue)");
                case 2->  smallgem.add("Banded agate (translucent striped brown, blue, white, or red)");
                case 3->  smallgem.add("Blue quartz (transparent pale blue)");
                case 4->  smallgem.add("Eye agate (translucent circles of gray, white, brown, blue, or green)");
                case 5->  smallgem.add("Hematite (opaque gray-black)");
                case 6->  smallgem.add("Lapis lazuli (opaque light and dark blue with yellow flecks)");
                case 7->  smallgem.add("Malachite (opaque striated light and dark green)");
                case 8->  smallgem.add("Moss agate (translucent pink or yellow-white with mossy gray or green markings)");
                case 9->  smallgem.add("Obsidian (opaque black)");
                case 10-> smallgem.add("Rhodochrosite (opaque light pink)");
                case 11-> smallgem.add("Tiger eye (translucent brown with golden center)");
                case 12-> smallgem.add("Turquoise (opaque light blue-green)");
            }
        }

        return MessageBuilder(smallgem).toString().replace("[","").replace("]","");
    }
    private static String medgem(int rollTotal) {
        Random mgemRand = new Random();

        List<String> medgem = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++) {
            int odds = mgemRand.nextInt(12 - 1 + 1) + 1;
            switch (odds) {
                case 1 -> medgem.add("Bloodstone (opaque dark gray with red flecks)");
                case 2 -> medgem.add("Carnelian (opaque orange to red-brown)");
                case 3 -> medgem.add("Chalcedony (opaque white)");
                case 4 -> medgem.add("Chrysoprase (translucent green)");
                case 5 -> medgem.add("Citrine (transparent pale yellow-brown)");
                case 6 -> medgem.add("Jasper (opaque blue, black, or brown)");
                case 7 -> medgem.add("Moonstone (translucent white with pale blue glow)");
                case 8 -> medgem.add("Onyx (opaque bands of black and white, or pure black or white)");
                case 9 -> medgem.add("Quartz (transparent white, smoky gray, or yellow)");
                case 10 -> medgem.add("Sardonyx (opaque bands of red and white)");
                case 11 -> medgem.add("Star rose quartz (translucent rosy stone with white star-shaped center)");
                case 12 -> medgem.add("Zircon (transparent pale blue-green)");
            }
        }

        return MessageBuilder(medgem).toString().replace("[","").replace("]","");
    }
    private static String lggem(int rollTotal) {
        Random lggemRand = new Random();

        List<String> lggem = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++) {
            int odds = lggemRand.nextInt(6 - 1 + 1) + 1;
            switch (odds) {
                case 1 -> lggem.add("Alexandrite (transparent dark green)");
                case 2 -> lggem.add("Aquamarine (transparent pale blue-green)");
                case 3 -> lggem.add("Black pearl (opaque pure black)");
                case 4 -> lggem.add("Blue spinel (transparent deep blue)");
                case 5 -> lggem.add("Peridot (transparent rich olive green)");
                case 6 -> lggem.add("Topaz (transparent golden yellow)");
            }
        }

        return MessageBuilder(lggem).toString().replace("[","").replace("]","");
    }
    private static String veryLGgem(int rollTotal) {
        Random veryLGgemRand = new Random();

        List<String> veryLGgem = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++) {
            int odds = veryLGgemRand.nextInt(8 - 1 + 1) + 1;
            switch (odds) {
                case 1 -> veryLGgem.add("Black opal (translucent dark green with black mottling and golden flecks)");
                case 2 -> veryLGgem.add("Blue sapphire (transparent blue-white to medium blue)");
                case 3 -> veryLGgem.add("Emerald (transparent deep bright green)");
                case 4 -> veryLGgem.add("Fire opal (translucent fiery red)");
                case 5 -> veryLGgem.add("Opal (translucent pale blue with green and golden mottling)");
                case 6 -> veryLGgem.add("Star ruby (translucent ruby with white star-shaped center)");
                case 7 -> veryLGgem.add("Star sapphire (translucent blue sapphire with white star-shaped center)");
                case 8 -> veryLGgem.add("Yellow sapphire (transparent fiery yellow or yellow green)");
            }
        }

        return MessageBuilder(veryLGgem).toString().replace("[","").replace("]","");
    }
    private static String expgem(int rollTotal) {
        Random expgemRand = new Random();

        List<String> expgem = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++) {
            int odds = expgemRand.nextInt(8 - 1 + 1) + 1;
            switch (odds) {
                case 1 -> expgem.add("Black sapphire (translucent lustrous black with glowing highlights)");
                case 2 -> expgem.add("Diamond (transparent blue-white, canary, pink, brown, or blue)");
                case 3 -> expgem.add("Jacinth (transparent fiery orange)");
                case 4 -> expgem.add("Ruby (transparent clear red to deep crimson)");
            }
        }

        return MessageBuilder(expgem).toString().replace("[","").replace("]","");
    }
    private static String TableA(int  rollTotal) {
        Random TableARand = new Random();
        List<String> magicitemA = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = TableARand.nextInt(100 - 1 + 1) + 1;

            if(1 <= odds && odds <= 50){magicitemA.add("Potion of Healing");}
            else if (51 <= odds && odds <= 60) {magicitemA.add("Spell scroll cantrip: " + spellScrollsCantrip());}
            else if (61 <= odds && odds <= 70) {magicitemA.add("Potion of climbing");}
            else if (71 <= odds && odds <= 90) {magicitemA.add("Spell scroll 1st level: " + spellScrollsLvLOne());}
            else if (91 <= odds && odds <= 94) {magicitemA.add("Spell scroll 2nd level: " + spellScrollsLvLTwo());}
            else if (95 <= odds && odds <= 98) {magicitemA.add("Potion of Greater Healing");}
            else if (odds == 99) {magicitemA.add("Bag of Holding");}
            else if (odds == 100) {magicitemA.add("Driftglobe");}
        }

        return "\n" + MessageBuilderwithreturn(magicitemA).toString().replace("[","").replace("]","");
    }
    private static String TableB(int rollTotal) {
        Random TableBRand = new Random();

        List<String> magicitemB = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = TableBRand.nextInt(100 - 1 + 1) + 1;

            if(1 <= odds && odds <= 15){magicitemB.add("Potion of greater healing");}
            else if (16 <= odds && odds <= 22) {magicitemB.add("Potion of fire breath");}
            else if (23 <= odds && odds <= 29) {magicitemB.add("Potion of resistance" + "(" + Resistance() + ")");}
            else if (30 <= odds && odds <= 34) {magicitemB.add("Ammunition, +1");}
            else if (35 <= odds && odds <= 39) {magicitemB.add("Potion of animal friendship");}
            else if (40 <= odds && odds <= 44) {magicitemB.add("Potion of hill giant strength");}
            else if (45 <= odds && odds <= 49) {magicitemB.add("Potion of growth");}
            else if (50 <= odds && odds <= 54) {magicitemB.add("Potion of water breathing");}
            else if (55 <= odds && odds <= 59) {magicitemB.add("Spell scroll (2nd level): " + spellScrollsLvLTwo());}
            else if (60 <= odds && odds <= 64) {magicitemB.add("Spell scroll (3rd level): " + spellScrollsLvLThree());}
            else if (65 <= odds && odds <= 67) {magicitemB.add("Bag of holding");}
            else if (68 <= odds && odds <= 70) {magicitemB.add("Keoghtom's ointment");}
            else if (71 <= odds && odds <= 73) {magicitemB.add("Oil of slipperiness");}
            else if (74 <= odds && odds <= 75) {magicitemB.add("Dust of disappearance");}
            else if (76 <= odds && odds <= 77) {magicitemB.add("Dust of dryness");}
            else if (78 <= odds && odds <= 79) {magicitemB.add("Dust of sneezing and choking");}
            else if (80 <= odds && odds <= 81) {magicitemB.add("Elemental gem");}
            else if (82 <= odds && odds <= 83) {magicitemB.add("Philter of love");}
            else if (odds == 84) {magicitemB.add("Alchemy jug");}
            else if (odds == 85) {magicitemB.add("Cap of water breathing");}
            else if (odds == 86) {magicitemB.add("Cloak of the manta ray");}
            else if (odds == 87) {magicitemB.add("Driftglobe");}
            else if (odds == 88) {magicitemB.add("Goggles of night");}
            else if (odds == 89) {magicitemB.add("Helm of comprehending languages");}
            else if (odds == 90) {magicitemB.add("Immovable rod");}
            else if (odds == 91) {magicitemB.add("Lantern of revealing");}
            else if (odds == 92) {magicitemB.add("Mariner's armor");}
            else if (odds == 93) {magicitemB.add("Mithral armor");}
            else if (odds == 94) {magicitemB.add("Potion of poison");}
            else if (odds == 95) {magicitemB.add("Ring of swimming");}
            else if (odds == 96) {magicitemB.add("Robe of useful items");}
            else if (odds == 97) {magicitemB.add("Rope of climbing");}
            else if (odds == 98) {magicitemB.add("Saddle of the cavalier");}
            else if (odds == 99) {magicitemB.add("Wand of magic detection");}
            else if (odds == 100){magicitemB.add("Wand of secrets");}
        }
        return "\n" + MessageBuilderwithreturn(magicitemB).toString().replace("[","").replace("]","");
    }
    private static String TableC(int rollTotal) {
        Random TableCRand = new Random();

        List<String> magicitemC = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = TableCRand.nextInt(100 - 1 + 1) + 1;

            if(1 <= odds && odds <= 15){magicitemC.add("Potion of superior healing");}
            else if (16 <= odds && odds <= 22) {magicitemC.add("Spell scroll (4th level): " + spellScrollsLvLFour());}
            else if (23 <= odds && odds <= 27) {magicitemC.add("Ammunition, +2");}
            else if (28 <= odds && odds <= 32) {magicitemC.add("Potion of clairvoyance");}
            else if (33 <= odds && odds <= 37) {magicitemC.add("Potion of diminution");}
            else if (38 <= odds && odds <= 42) {magicitemC.add("Potion of gaseous form");}
            else if (43 <= odds && odds <= 47) {magicitemC.add("Potion of frost giant strength");}
            else if (48 <= odds && odds <= 52) {magicitemC.add("Potion of stone giant strength");}
            else if (53 <= odds && odds <= 57) {magicitemC.add("Potion of heroism");}
            else if (58 <= odds && odds <= 62) {magicitemC.add("Potion of invulnerability");}
            else if (63 <= odds && odds <= 67) {magicitemC.add("Potion of mind reading");}
            else if (68 <= odds && odds <= 72) {magicitemC.add("Spell scroll (5th level): " + spellScrollsLvLFive());}
            else if (73 <= odds && odds <= 75) {magicitemC.add("Elixir of health");}
            else if (76 <= odds && odds <= 78) {magicitemC.add("Oil of etherealness");}
            else if (79 <= odds && odds <= 81) {magicitemC.add("Potion of fire giant strength");}
            else if (82 <= odds && odds <= 84) {magicitemC.add("Quaal's feather token");}
            else if (85 <= odds && odds <= 87) {magicitemC.add("Scroll of protection");}
            else if (88 <= odds && odds <= 89) {magicitemC.add("Bag of beans");}
            else if (90 <= odds && odds <= 91) {magicitemC.add("Bead of force");}
            else if (odds == 92) {magicitemC.add("Chime of opening");}
            else if (odds == 93) {magicitemC.add("Decanter of endless water");}
            else if (odds == 94) {magicitemC.add("Eyes of minute seeing");}
            else if (odds == 95) {magicitemC.add("Folding boat");}
            else if (odds == 96) {magicitemC.add("Heward's handy haversack");}
            else if (odds == 97) {magicitemC.add("Horseshoes of speed");}
            else if (odds == 98) {magicitemC.add("Necklace of fireballs");}
            else if (odds == 99) {magicitemC.add("Periapt of health");}
            else if (odds == 100){magicitemC.add("Sending Stones");}
        }
        return "\n" + MessageBuilderwithreturn(magicitemC).toString().replace("[","").replace("]","");
    }
    private static String TableD(int rollTotal) {
        Random TableDRand = new Random();

        List<String> magicitemD = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = TableDRand.nextInt(100 - 1 + 1) + 1;

            if(1 <= odds && odds <= 20){magicitemD.add("Potion of supreme healing");}
            else if (21 <= odds && odds <= 30) {magicitemD.add("Potion of invisibility");}
            else if (31 <= odds && odds <= 40) {magicitemD.add("Potion of speed");}
            else if (41 <= odds && odds <= 50) {magicitemD.add("Spell scroll (6thlevel): " + spellScrollsLvLSix());}
            else if (51 <= odds && odds <= 57) {magicitemD.add("Spell scroll (7thlevel): " + spellScrollsLvLSeven());}
            else if (58 <= odds && odds <= 62) {magicitemD.add("Ammunition, +3");}
            else if (63 <= odds && odds <= 67) {magicitemD.add("Oil of sharpness");}
            else if (68 <= odds && odds <= 72) {magicitemD.add("Potion of flying");}
            else if (73 <= odds && odds <= 77) {magicitemD.add("Potion of cloud giant strength");}
            else if (78 <= odds && odds <= 82) {magicitemD.add("Potion of longevity");}
            else if (83 <= odds && odds <= 87) {magicitemD.add("Potion of vitality");}
            else if (88 <= odds && odds <= 92) {magicitemD.add("Spell scroll (8thlevel): " +spellScrollsLvLEight());}
            else if (93 <= odds && odds <= 95) {magicitemD.add("Horseshoes of a zephyr");}
            else if (96 <= odds && odds <= 98) {magicitemD.add("Nolzur's marvelous pigments");}
            else if (odds == 99) {magicitemD.add("Bag of devouring");}
            else if (odds == 100){magicitemD.add("Portable hole");}
        }

        return "\n" + MessageBuilderwithreturn(magicitemD).toString().replace("[","").replace("]","");
    }
    private static String TableE(int rollTotal) {
        Random TableERand = new Random();

        List<String> magicitemE = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = TableERand.nextInt(100 - 1 + 1) + 1;

            if(1 <= odds && odds <= 30){magicitemE.add("Spell scroll (8thlevel): " +spellScrollsLvLEight());}
            else if (31 <= odds && odds <= 55) {magicitemE.add("Potion of storm giant strength");}
            else if (56 <= odds && odds <= 70) {magicitemE.add("Potion of supreme healing");}
            else if (71 <= odds && odds <= 85) {magicitemE.add("Spell scroll (9st level): " + spellScrollsLvLNine());}
            else if (86 <= odds && odds <= 93) {magicitemE.add("Universal solvent");}
            else if (94 <= odds && odds <= 98) {magicitemE.add("Arrow of slaying");}
            else if (99 <= odds && odds <= 100) {magicitemE.add("Sovereign glue");}

        }

        return "\n" + MessageBuilderwithreturn(magicitemE).toString().replace("[","").replace("]","");
    }
    private static String TableF(int rollTotal) {
        Random TableFRand = new Random();

        List<String> magicitemF = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = TableFRand.nextInt(100 - 1 + 1) + 1;

            if       (1 <= odds && odds <= 15) {magicitemF.add("Weapon, +1");}
            else if (16 <= odds && odds <= 18) {magicitemF.add("Shield,+ 1");}
            else if (19 <= odds && odds <= 21) {magicitemF.add("Sentinel shield");}
            else if (22 <= odds && odds <= 23) {magicitemF.add("Amulet of proof against detection and location");}
            else if (24 <= odds && odds <= 25) {magicitemF.add("Boots of elvenkind");}
            else if (26 <= odds && odds <= 27) {magicitemF.add("Boots of striding and springing");}
            else if (28 <= odds && odds <= 29) {magicitemF.add("Bracers of archery");}
            else if (30 <= odds && odds <= 31) {magicitemF.add("Brooch of shielding");}
            else if (32 <= odds && odds <= 33) {magicitemF.add("Broom of flying");}
            else if (34 <= odds && odds <= 35) {magicitemF.add("Cloak of elvenkind");}
            else if (36 <= odds && odds <= 37) {magicitemF.add("Cloak of protection");}
            else if (38 <= odds && odds <= 39) {magicitemF.add("Gauntlets of ogre power");}
            else if (40 <= odds && odds <= 41) {magicitemF.add("Hat of disguise");}
            else if (42 <= odds && odds <= 43) {magicitemF.add("Javelin of lightning");}
            else if (44 <= odds && odds <= 45) {magicitemF.add("Pearl of power");}
            else if (46 <= odds && odds <= 47) {magicitemF.add("Rod of the pact keeper, + 1");}
            else if (48 <= odds && odds <= 49) {magicitemF.add("Slippers of spider climbing");}
            else if (50 <= odds && odds <= 51) {magicitemF.add("Staff of the adder");}
            else if (52 <= odds && odds <= 53) {magicitemF.add("Staff of the python");}
            else if (54 <= odds && odds <= 55) {magicitemF.add("Sword of vengeance");}
            else if (56 <= odds && odds <= 57) {magicitemF.add("Trident of fish command");}
            else if (58 <= odds && odds <= 59) {magicitemF.add("Wand of magic missiles");}
            else if (60 <= odds && odds <= 61) {magicitemF.add("Wand of the war mage, + 1");}
            else if (62 <= odds && odds <= 63) {magicitemF.add("Wand of web");}
            else if (64 <= odds && odds <= 65) {magicitemF.add("Weapon of warning");}
            else if (odds == 66) {magicitemF.add("Adamantine armor (chain mail)");}
            else if (odds == 67){magicitemF.add("Adamantine armor (chain shirt)");}
            else if (odds == 68) {magicitemF.add("Adamantine armor (scale mail)");}
            else if (odds == 69){magicitemF.add("Bag of tricks (gray)");}
            else if (odds == 70) {magicitemF.add("Bag of tricks (rust)");}
            else if (odds == 71){magicitemF.add("Bag of tricks (tan)");}
            else if (odds == 72) {magicitemF.add("Boots of the Winterlands");}
            else if (odds == 73){magicitemF.add("Circlet of blasting");}
            else if (odds == 74) {magicitemF.add("Deck of illusions");}
            else if (odds == 75){magicitemF.add("Eversmoking bottle");}
            else if (odds == 76) {magicitemF.add("Eyes of charming");}
            else if (odds == 77){magicitemF.add("Eyes of the eagle");}
            else if (odds == 78) {magicitemF.add("Figurine of wondrous power (silver raven)");}
            else if (odds == 79){magicitemF.add("Gem of brightness");}
            else if (odds == 80) {magicitemF.add("Gloves of missile snaring");}
            else if (odds == 81){magicitemF.add("Gloves of swimming and climbing");}
            else if (odds == 82) {magicitemF.add("Gloves of thievery");}
            else if (odds == 83){magicitemF.add("Headband of intellect");}
            else if (odds == 84) {magicitemF.add("Helm of telepathy");}
            else if (odds == 85){magicitemF.add("Instrument of the bards (Doss lute)");}
            else if (odds == 86) {magicitemF.add("Instrument of the bards (Fochlucan bandore)");}
            else if (odds == 87){magicitemF.add("Instrument of the bards (Mac-Fuimidh cittern)");}
            else if (odds == 88){magicitemF.add("Medallion of thoughts");}
            else if (odds == 89) {magicitemF.add("Necklace of adaptation");}
            else if (odds == 90){magicitemF.add("Periapt of wound closure");}
            else if (odds == 91) {magicitemF.add("Pipes of haunting");}
            else if (odds == 92){magicitemF.add("Pipes of the sewers");}
            else if (odds == 93) {magicitemF.add("Ring of jumping");}
            else if (odds == 94){magicitemF.add("Ring of mind shielding");}
            else if (odds == 95) {magicitemF.add("Ring of warmth");}
            else if (odds == 96){magicitemF.add("Ring of water walking");}
            else if (odds == 97) {magicitemF.add("Quiver of Ehlonna");}
            else if (odds == 98) {magicitemF.add("Stone of good luck");}
            else if (odds == 99) {magicitemF.add("Wind fan");}
            else if (odds == 100){magicitemF.add("Winged boots");}

        }

        return "\n" + MessageBuilderwithreturn(magicitemF).toString().replace("[","").replace("]","");
    }
    private static String TableG(int rollTotal) {
        Random TableGRand = new Random();

        List<String> magicitemG = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = TableGRand.nextInt(100 - 1 + 1) + 1;

            if(1 <= odds && odds <= 11){magicitemG.add("Weapon, +2");}
            else if (12 <= odds && odds <= 14) {
                int figureOdds = TableGRand.nextInt(8 - 1 + 1) + 1;
                switch (figureOdds){
                    case 1 -> magicitemG.add("Black opal (translucent dark green with black mottling and golden flecks)");
                    case 2 -> magicitemG.add("Blue sapphire (transparent blue-white to medium blue)");
                    case 3 -> magicitemG.add("Emerald (transparent deep bright green)");
                    case 4 -> magicitemG.add("Fire opal (translucent fiery red)");
                    case 5 -> magicitemG.add("Opal (translucent pale blue with green and golden mottling)");
                    case 6 -> magicitemG.add("Star ruby (translucent ruby with white star-shaped center)");
                    case 7 -> magicitemG.add("Star sapphire (translucent blue sapphire with white star-shaped center)");
                    case 8 -> magicitemG.add("Yellow sapphire (transparent fiery yellow or yellow green)");
                }
            }
            else if (odds == 15) {magicitemG.add("Adamantine armor (breastplate)");}
            else if (odds == 16) {magicitemG.add("Adamantine armor (splint)");}
            else if (odds == 17) {magicitemG.add("Amulet of health");}
            else if (odds == 18) {magicitemG.add("Armor of vulnerability");}
            else if (odds == 19) {magicitemG.add("Arrow-catching shield");}
            else if (odds == 20) {magicitemG.add("Belt of dwarvenkind");}
            else if (odds == 21) {magicitemG.add("Belt of hill giant strength");}
            else if (odds == 22) {magicitemG.add("Berserker axe");}
            else if (odds == 23) {magicitemG.add("Boots of levitation");}
            else if (odds == 24) {magicitemG.add("Boots of speed");}
            else if (odds == 25) {magicitemG.add("Bowl of commanding water elementals");}
            else if (odds == 26) {magicitemG.add("Bracers of defense");}
            else if (odds == 27) {magicitemG.add("Brazier of commanding fire elementals");}
            else if (odds == 28) {magicitemG.add("Cape of the mountebank");}
            else if (odds == 29) {magicitemG.add("Censer of controlling air elementals");}
            else if (odds == 30) {magicitemG.add("Armor, +1 chain mail");}
            else if (odds == 31) {magicitemG.add("Armor of resistance (chain mail)" + "(" + Resistance() + ")");}
            else if (odds == 32) {magicitemG.add("Armor of resistance (chain shirt)" + "(" + Resistance() + ")");}
            else if (odds == 33) {magicitemG.add("Armor,+ 1 chain shirt");}
            else if (odds == 34) {magicitemG.add("Cloak of displacement");}
            else if (odds == 35) {magicitemG.add("Cloak of the bat");}
            else if (odds == 36) {magicitemG.add("Cube of force");}
            else if (odds == 37) {magicitemG.add("Daern's instant fortress");}
            else if (odds == 38) {magicitemG.add("Dagger of venom");}
            else if (odds == 39) {magicitemG.add("Dimensional shackles");}
            else if (odds == 40) {magicitemG.add("Dragon slayer");}
            else if (odds == 41) {magicitemG.add("Elven chain");}
            else if (odds == 42) {magicitemG.add("Flame tongue");}
            else if (odds == 43) {magicitemG.add("Gem of seeing");}
            else if (odds == 44) {magicitemG.add("Giant slayer");}
            else if (odds == 45) {magicitemG.add("Clamoured studded leather");}
            else if (odds == 46) {magicitemG.add("Helm of teleportation");}
            else if (odds == 47) {magicitemG.add("Horn of blasting");}
            else if (odds == 48) {magicitemG.add("Horn of Valhalla (silver or brass)");}
            else if (odds == 49) {magicitemG.add("Instrument of the bards (Canaithmandolin)");}
            else if (odds == 50) {magicitemG.add("Instrument ofthe bards (Cii lyre)");}
            else if (odds == 51) {magicitemG.add("loun stone (awareness)");}
            else if (odds == 52) {magicitemG.add("loun stone (protection)");}
            else if (odds == 53) {magicitemG.add("loun stone (reserve)");}
            else if (odds == 54) {magicitemG.add("loun stone (sustenance)");}
            else if (odds == 55) {magicitemG.add("Iron bands of Bilarro");}
            else if (odds == 56) {magicitemG.add("Armor, + 1 leather");}
            else if (odds == 57) {magicitemG.add("Armor of resistance (leather)" + "(" + Resistance() + ")");}
            else if (odds == 58) {magicitemG.add("Mace of disruption");}
            else if (odds == 59) {magicitemG.add("Mace of smiting");}
            else if (odds == 60) {magicitemG.add("Mace of terror");}
            else if (odds == 61) {magicitemG.add("Mantle of spell resistance");}
            else if (odds == 62) {magicitemG.add("Necklace of prayer beads");}
            else if (odds == 63) {magicitemG.add("Periapt of proof against poison");}
            else if (odds == 64) {magicitemG.add("Ring of animal influence");}
            else if (odds == 65) {magicitemG.add("Ring of evasion");}
            else if (odds == 66) {magicitemG.add("Ring of feather falling");}
            else if (odds == 67) {magicitemG.add("Ring of free action");}
            else if (odds == 68) {magicitemG.add("Ring of protection");}
            else if (odds == 69) {magicitemG.add("Ring of resistance" + "(" + Resistance() + ")");}
            else if (odds == 70) {magicitemG.add("Ring of spell storing");}
            else if (odds == 71) {magicitemG.add("Ring of the ram");}
            else if (odds == 72) {magicitemG.add("Ring of X-ray vision");}
            else if (odds == 73) {magicitemG.add("Robe of eyes");}
            else if (odds == 74) {magicitemG.add("Rod of rulership");}
            else if (odds == 75) {magicitemG.add("Rod of the pact keeper, +2");}
            else if (odds == 76) {magicitemG.add("Rope of entanglement");}
            else if (odds == 77) {magicitemG.add("Armor, +1 scale mail");}
            else if (odds == 78) {magicitemG.add("Armor of resistance (scale mail)" + "(" + Resistance() + ")");}
            else if (odds == 79) {magicitemG.add("Shield, +2");}
            else if (odds == 80) {magicitemG.add("Shield of missile attraction");}
            else if (odds == 81) {magicitemG.add("Staff of charming");}
            else if (odds == 82) {magicitemG.add("Staff of healing");}
            else if (odds == 83) {magicitemG.add("Staff of swarming insects");}
            else if (odds == 84) {magicitemG.add("Staff of the woodlands");}
            else if (odds == 85) {magicitemG.add("Staff of withering");}
            else if (odds == 86) {magicitemG.add("Stone of controlling earthelementals");}
            else if (odds == 87) {magicitemG.add("Sun blade");}
            else if (odds == 88) {magicitemG.add("Sword of life stealing");}
            else if (odds == 89) {magicitemG.add("Sword of wounding");}
            else if (odds == 90) {magicitemG.add("Tentacle rod");}
            else if (odds == 91) {magicitemG.add("Vicious weapon");}
            else if (odds == 92) {magicitemG.add("Wand of binding");}
            else if (odds == 93) {magicitemG.add("Wand of enemy detection");}
            else if (odds == 94) {magicitemG.add("Wand of fear");}
            else if (odds == 95) {magicitemG.add("Wand of fireballs");}
            else if (odds == 96) {magicitemG.add("Wand of lightning bolts");}
            else if (odds == 97) {magicitemG.add("Wand of paralysis");}
            else if (odds == 98) {magicitemG.add("Wand of the war mage, +2");}
            else if (odds == 99) {magicitemG.add("Wand of wonder");}
            else if (odds == 100){magicitemG.add("Wings of flying");}
        }

        return "\n" + MessageBuilderwithreturn(magicitemG).toString().replace("[","").replace("]","");
    }
    private static String TableH(int rollTotal) {
        Random TableHRand = new Random();

        List<String> magicitemH = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = TableHRand.nextInt(100 - 1 + 1) + 1;

            if(1 <= odds && odds <= 10){magicitemH.add("Weapon, +3");}
            else if (11 <= odds && odds <= 12) {magicitemH.add("Amulet of the planes");}
            else if (13 <= odds && odds <= 14) {magicitemH.add("Carpet of flying");}
            else if (15 <= odds && odds <= 16) {magicitemH.add("Crystal ball (very rare version)");}
            else if (17 <= odds && odds <= 18) {magicitemH.add("Ring of regeneration");}
            else if (19 <= odds && odds <= 20) {magicitemH.add("Ring of shooting stars");}
            else if (21 <= odds && odds <= 22) {magicitemH.add("Ring of telekinesis");}
            else if (23 <= odds && odds <= 24) {magicitemH.add("Robe of scintillating colors");}
            else if (25 <= odds && odds <= 26) {magicitemH.add("Robe of stars");}
            else if (27 <= odds && odds <= 28) {magicitemH.add("Rod of absorption");}
            else if (29 <= odds && odds <= 30) {magicitemH.add("Rod of alertness");}
            else if (31 <= odds && odds <= 32) {magicitemH.add("Rod of security");}
            else if (33 <= odds && odds <= 34) {magicitemH.add("Rod of the pact keeper, +3");}
            else if (35 <= odds && odds <= 36) {magicitemH.add("Scimitar of speed");}
            else if (37 <= odds && odds <= 38) {magicitemH.add("Shield, +3");}
            else if (39 <= odds && odds <= 40) {magicitemH.add("Staff of fire");}
            else if (41 <= odds && odds <= 42) {magicitemH.add("Staff of frost");}
            else if (43 <= odds && odds <= 44) {magicitemH.add("Staff of power");}
            else if (45 <= odds && odds <= 46) {magicitemH.add("Staff of striking");}
            else if (47 <= odds && odds <= 48) {magicitemH.add("Staff of thunder and lightning");}
            else if (49 <= odds && odds <= 50) {magicitemH.add("Sword of sharpnes");}
            else if (51 <= odds && odds <= 52) {magicitemH.add("Wand of polymorph");}
            else if (53 <= odds && odds <= 54) {magicitemH.add("Wand of the war mage, + 3");}
            else if (odds == 55) {magicitemH.add("Adamantine armor (half plate)");}
            else if (odds == 56) {magicitemH.add("Adamantine armor (plate)");}
            else if (odds == 57) {magicitemH.add("Animated shield");}
            else if (odds == 58) {magicitemH.add("Belt of fire giant strength");}
            else if (odds == 59) {magicitemH.add("Belt of frost (or stone) giant strength");}
            else if (odds == 60) {magicitemH.add("Armor, + 1 breastplate");}
            else if (odds == 61) {magicitemH.add("Armor of resistance (breastplate)" + "(" + Resistance() + ")");}
            else if (odds == 62) {magicitemH.add("Candle of invocation");}
            else if (odds == 63) {magicitemH.add("Armor, +2 chain mail");}
            else if (odds == 64) {magicitemH.add("Armor, +2 chain shirt");}
            else if (odds == 65) {magicitemH.add("Cloak of arachnida");}
            else if (odds == 66) {magicitemH.add("Dancing sword");}
            else if (odds == 67) {magicitemH.add("Demon armor");}
            else if (odds == 68) {magicitemH.add("Dragon scale mail");}
            else if (odds == 69) {magicitemH.add("Dwarven plate");}
            else if (odds == 70) {magicitemH.add("Dwarven thrower");}
            else if (odds == 71) {magicitemH.add("Efreeti bottle");}
            else if (odds == 72) {magicitemH.add("Figurine of wondrous power (obsidian steed)");}
            else if (odds == 73) {magicitemH.add("Frost brand");}
            else if (odds == 74) {magicitemH.add("Helm of brilliance");}
            else if (odds == 75) {magicitemH.add("Horn ofValhalla (bronze)");}
            else if (odds == 76) {magicitemH.add("Instrument of the bards (Anstruthharp)");}
            else if (odds == 77) {magicitemH.add("loun stone (absorption)");}
            else if (odds == 78) {magicitemH.add("loun stone (agility)");}
            else if (odds == 79) {magicitemH.add("loun stone (fortitude)");}
            else if (odds == 80) {magicitemH.add("loun stone (insight)");}
            else if (odds == 81) {magicitemH.add("loun stone (intellect)");}
            else if (odds == 82) {magicitemH.add("loun stone (leadership)");}
            else if (odds == 83) {magicitemH.add("loun stone (strength)");}
            else if (odds == 84) {magicitemH.add("Armor, +2 leather");}
            else if (odds == 85) {magicitemH.add("Manual of bodily health");}
            else if (odds == 86) {magicitemH.add("Manual of gainful exercise");}
            else if (odds == 87) {magicitemH.add("Manual of golems");}
            else if (odds == 88) {magicitemH.add("Manual of quickness of action");}
            else if (odds == 89) {magicitemH.add("Mirror of life trapping");}
            else if (odds == 90) {magicitemH.add("Nine lives stealer");}
            else if (odds == 91) {magicitemH.add("Oathbow");}
            else if (odds == 92) {magicitemH.add("Armor, +2 scale mail");}
            else if (odds == 93) {magicitemH.add("Spellguard shield");}
            else if (odds == 94) {magicitemH.add("Armor, + 1 splint");}
            else if (odds == 95) {magicitemH.add("Armor of resistance (splint)" + "(" + Resistance() + ")");}
            else if (odds == 96) {magicitemH.add("Armor, + 1 studded leather");}
            else if (odds == 97) {magicitemH.add("Armor of resistance (studded leather)" + "(" + Resistance() + ")");}
            else if (odds == 98) {magicitemH.add("Tome of clear thought");}
            else if (odds == 99) {magicitemH.add("Tome of leadership and influence");}
            else if (odds == 100){magicitemH.add("Tome of understanding");}
        }

        return "\n" + MessageBuilderwithreturn(magicitemH).toString().replace("[","").replace("]","");
    }
    private static String TableI(int rollTotal) {
        Random TableIRand = new Random();

        List<String> magicitemI = new ArrayList<>();

        for(int i = 0; i < rollTotal; i++){
            int odds = TableIRand.nextInt(100 - 1 + 1) + 1;

            if(1 <= odds && odds <= 5){magicitemI.add("Defender");}
            else if (6 <= odds && odds <= 10) {magicitemI.add("Hammer of thunderbolts");}
            else if (11 <= odds && odds <= 15) {magicitemI.add("Luck Blade");}
            else if (15 <= odds && odds <= 20) {magicitemI.add("Sword of answering");}
            else if (21 <= odds && odds <= 23) {magicitemI.add("Holy avenger");}
            else if (24 <= odds && odds <= 26) {magicitemI.add("Ring of djinni summoning");}
            else if (27 <= odds && odds <= 29) {magicitemI.add("Ring of invisibility");}
            else if (30 <= odds && odds <= 32) {magicitemI.add("Ring of spell turning");}
            else if (33 <= odds && odds <= 35) {magicitemI.add("Rod of lordly might");}
            else if (36 <= odds && odds <= 38) {magicitemI.add("Staff of the magi");}
            else if (39 <= odds && odds <= 41) {magicitemI.add("Vorpal Sword");}
            else if (42 <= odds && odds <= 43) {magicitemI.add("Belt of cloud giant strength");}
            else if (44 <= odds && odds <= 45) {magicitemI.add("Armor, +2 breastplate");}
            else if (46 <= odds && odds <= 47) {magicitemI.add("Armor, +3 chain mail");}
            else if (48 <= odds && odds <= 49) {magicitemI.add("Armor, +3 chain shirt");}
            else if (50 <= odds && odds <= 51) {magicitemI.add("Cloak of invisibility");}
            else if (52 <= odds && odds <= 53) {magicitemI.add("Crystal ball (legendary version)");}
            else if (54 <= odds && odds <= 55) {magicitemI.add("Armor, + 1 half plate");}
            else if (56 <= odds && odds <= 57) {magicitemI.add("Iron flask");}
            else if (58 <= odds && odds <= 59) {magicitemI.add("Armor, +3 leather");}
            else if (60 <= odds && odds <= 61) {magicitemI.add("Armor, +1 plate");}
            else if (62 <= odds && odds <= 63) {magicitemI.add("Robe of the Archmagi");}
            else if (64 <= odds && odds <= 65) {magicitemI.add("Rod of resurrection");}
            else if (66 <= odds && odds <= 67) {magicitemI.add("Armor, +1 scale mail");}
            else if (68 <= odds && odds <= 69) {magicitemI.add("Scarab of protection");}
            else if (70 <= odds && odds <= 71) {magicitemI.add("Armor, +2 splint");}
            else if (72 <= odds && odds <= 73) {magicitemI.add("Armor, +2 studded leather");}
            else if (74 <= odds && odds <= 75) {magicitemI.add("Well of many worlds");}
            else if (odds == 76) {
                int magicArmorOdds = TableIRand.nextInt(12 - 1 + 1) + 1;
                switch (magicArmorOdds){
                    case 1, 2 -> magicitemI.add("Armor, +2 half plate");
                    case 3, 4 -> magicitemI.add("Armor, +2 plate");
                    case 5, 6 -> magicitemI.add("Armor, +3 studded leather");
                    case 7, 8 -> magicitemI.add("Armor, +3 breastplate");
                    case 9, 10 -> magicitemI.add("Armor +3 splint");
                    case 11-> magicitemI.add("Armor, +3 half plate");
                    case 12-> magicitemI.add("Armor, +3 plate");
                }
            }
            else if (odds == 77) {magicitemI.add("Apparatus of Kwalish");}
            else if (odds == 78) {magicitemI.add("Armor of invulnerability");}
            else if (odds == 79) {magicitemI.add("Belt of storm giant strength");}
            else if (odds == 80) {magicitemI.add("Cubic gate");}
            else if (odds == 81) {magicitemI.add("Deck of many things");}
            else if (odds == 82) {magicitemI.add("Efreeti chain");}
            else if (odds == 83) {magicitemI.add("Armor of resistance (half plate)" + "(" + Resistance() + ")");}
            else if (odds == 84) {magicitemI.add("Horn of Valhalla (iron)");}
            else if (odds == 85) {magicitemI.add("Instument of the bards (Ollamh harp)");}
            else if (odds == 86) {magicitemI.add("Ioun stone (greater absorption)");}
            else if (odds == 87) {magicitemI.add("Ioun stone (mastery)");}
            else if (odds == 88) {magicitemI.add("Ioun stone (regeneration)");}
            else if (odds == 89) {magicitemI.add("Plate armor of etherealness");}
            else if (odds == 90) {magicitemI.add("Plate armor of resistance" + "(" + Resistance() + ")");}
            else if (odds == 91) {magicitemI.add("Ring of air elemental command");}
            else if (odds == 92) {magicitemI.add("Ring of earth elemental command");}
            else if (odds == 93) {magicitemI.add("Ring of fire elemental command");}
            else if (odds == 94) {magicitemI.add("Ring of three wishes");}
            else if (odds == 95) {magicitemI.add("Ring of water elemental command");}
            else if (odds == 96) {magicitemI.add("Sphere of annihilation");}
            else if (odds == 97) {magicitemI.add("Talisman of pure good");}
            else if (odds == 98) {magicitemI.add("Talisman of the sphere");}
            else if (odds == 99) {magicitemI.add("Talisman of ultimate evil");}
            else if (odds == 100){magicitemI.add("Tome of the stilled tongue");}
        }

        return "\n" + MessageBuilderwithreturn(magicitemI).toString().replace("[","").replace("]","");
    }
}
