package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.utils.SplitUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class weather extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(event.getName().equals("weather")) {

            //figure out a plan for deserts and extraplaner later
            //need to add deserts as well

            final OptionMapping climate = event.getOption("climate"); //Cold, Temperate, Tropical
            final OptionMapping season = event.getOption("season"); //Winter, Spring, Summer, Fall
            final OptionMapping elevationMapping = event.getOption("elevation"); //Sea level, Lowland, Highland

            final String elevation = elevationMapping == null ? "Lowland" : elevationMapping.getAsString();
            Random rand = new Random();
            List<String> weatherreport = new ArrayList<>();

            int d100 = rand.nextInt(100 - 1 + 1) + 1;
            int temp = 0;

            String preipitationFrequency = "";
            boolean amIRaining = false;
            String preipitaitonFrequency = "";
            String preipitaitonIntensity = "";
            String clouds = "";
            String percipitationForm = "";
            String wind = "";
            String extreamweather = "";

            event.deferReply(true).queue();
            event.getHook().sendMessage("""
                    # Disclaimer
                    5e rules on page 109 of the DMG are very vague and not very dynamic. I have used pathfinders general rules for this.
                    Altering the DCs/damage should be considered.
                    """).setEphemeral(true).complete();

            switch (climate.getAsString()){
                case "Cold"      :
                     preipitationFrequency = preipitaitonFrequency(season.getAsString(),climate.getAsString(),elevation);
                     amIRaining = amIRaining(preipitationFrequency);
                     preipitaitonFrequency = preipitaitonFrequency(season.getAsString(),climate.getAsString(),elevation);
                     preipitaitonIntensity = preipitaitonIntensity(elevation,climate.getAsString(),preipitaitonFrequency);
                     clouds = clouds(amIRaining);
                    if(amIRaining == false && clouds.equals("Overcast. Overcast conditions grant concealment for creatures flying at high altitudes.")){temp = 10;}
                    temp = coldSeasonBaseTemp(season.getAsString()) + coldSeasonVariationTemp(d100) + elevationTemperature(elevation);
                    percipitationForm = percipitationForm(amIRaining,preipitaitonIntensity,temp);
                    wind = wind(percipitationForm);
                    extreamweather = extreamWeatherEvent(temp,amIRaining);

                    weatherreport.add(" ## Todays Weather Report:\nFor the: " + climate.getAsString() + " climate\n" +
                            "In the " + season.getAsString() + " season.\n" +
                            "At the " + elevation + "\n" +
                            "The temperature is: " + temp + " for " + coldSeasonVariationDuration(d100) + " days.");
                    weatherreport.add(percipitationForm);
                    weatherreport.add(clouds);
                    weatherreport.add(wind);
                    weatherreport.add(weatherrWarning(temp,elevation));
                    weatherreport.add(extreamweather);
                    break;
                case "Temperate" :
                    preipitationFrequency = preipitaitonFrequency(season.getAsString(),climate.getAsString(),elevation);
                    amIRaining = amIRaining(preipitationFrequency);
                    preipitaitonFrequency = preipitaitonFrequency(season.getAsString(),climate.getAsString(),elevation);
                    preipitaitonIntensity = preipitaitonIntensity(elevation,climate.getAsString(),preipitaitonFrequency);
                    clouds = clouds(amIRaining);
                    if(amIRaining == false && clouds.equals("Overcast. Overcast conditions grant concealment for creatures flying at high altitudes.")){temp = 10;}
                    temp = temperateSeasonBaseTemp(season.getAsString()) + temperateSeasonVariationTemp(d100) + elevationTemperature(elevation);
                    percipitationForm = percipitationForm(amIRaining,preipitaitonIntensity,temp);
                    wind = wind(percipitationForm);
                    extreamweather = extreamWeatherEvent(temp,amIRaining);

                    weatherreport.add(" ## Todays Weather Report:\nFor the: " + climate.getAsString() + " climate\n" +
                            "In the " + season.getAsString() + " season.\n" +
                            "At the " + elevation + "\n" +
                            "The temperature is: " + temp + " for " + temperateSeasonVariationDuration(d100) + " days.");
                    weatherreport.add(percipitationForm);
                    weatherreport.add(clouds);
                    weatherreport.add(wind);
                    weatherreport.add(weatherrWarning(temp,elevation));
                    weatherreport.add(extreamweather);
                    break;
                case "Tropical"  :
                    preipitationFrequency = preipitaitonFrequency(season.getAsString(),climate.getAsString(),elevation);
                    amIRaining = amIRaining(preipitationFrequency);
                    preipitaitonFrequency = preipitaitonFrequency(season.getAsString(),climate.getAsString(),elevation);
                    preipitaitonIntensity = preipitaitonIntensity(elevation,climate.getAsString(),preipitaitonFrequency);
                    clouds = clouds(amIRaining);
                    if(amIRaining == false && clouds.equals("Overcast. Overcast conditions grant concealment for creatures flying at high altitudes.")){temp = 10;}
                    temp = tropicalSeasonBaseTemp(season.getAsString()) + tropicalSeasonVariationTemp(d100) + elevationTemperature(elevation);
                    percipitationForm = percipitationForm(amIRaining,preipitaitonIntensity,temp);
                    wind = wind(percipitationForm);
                    extreamweather = extreamWeatherEvent(temp,amIRaining);

                    weatherreport.add(" ## Todays Weather Report:\nFor the: " + climate.getAsString() + " climate \n" +
                            "In the " + season.getAsString() + " season.\n" +
                            "At the " + elevation + "\n" +
                            "The temperature is: " + temp + " for " + tropicalSeasonVariationDuration(d100) + " days.");
                    weatherreport.add(percipitationForm);
                    weatherreport.add(clouds);
                    weatherreport.add(wind);
                    weatherreport.add(weatherrWarning(temp,elevation));
                    weatherreport.add(extreamweather);
                    break;
            }
            event.getHook().sendMessage(MessageBuilder(weatherreport)).setEphemeral(true).complete();
        }
    }
    private static String MessageBuilder(List<String> text){
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
    private static int coldSeasonBaseTemp(String season){
        int basetemp = 0;
        switch (season){
            case "Winter" -> basetemp = 20;
            case "Spring" -> basetemp = 30;
            case "Summer" -> basetemp = 40;
            case "Fall" ->   basetemp = 30;
            default -> basetemp = 30;
        }
        return basetemp;
    }
    private static int temperateSeasonBaseTemp(String season){
        int basetemp = 0;
        switch (season){
            case "Winter" -> basetemp = 30;
            case "Spring" -> basetemp = 60;
            case "Summer" -> basetemp = 80;
            case "Fall" ->   basetemp = 60;
            default -> basetemp = 30;
        }
        return basetemp;
    }
    private static int tropicalSeasonBaseTemp(String season){
        int basetemp = 0;
        switch (season){
            case "Winter" -> basetemp = 50;
            case "Spring" -> basetemp = 75;
            case "Summer" -> basetemp = 95;
            case "Fall" ->   basetemp = 75;
            default -> basetemp = 30;
        }
        return basetemp;
    }
    private static int elevationTemperature(String elevation){
        int tempadjustment = 0;
        switch (elevation){
            case "Sea level" -> tempadjustment = 10;
            case "Lowland"   -> tempadjustment = 0;
            case "Highland"  -> tempadjustment = -10;
            default          -> tempadjustment = 0;
        }
        return tempadjustment;
    }
    private static int coldSeasonVariationTemp(int d100){
        int variationtemp = 0;
        int duration = 0;

        if(1 <= d100 && d100 <= 20)        {variationtemp = ( -1 *dice(3,10));}
        else if (21 <= d100 && d100 <= 40) {variationtemp = ( -1 *dice(2,10));}
        else if (41 <= d100 && d100 <= 60) {variationtemp = ( -1 *dice(1,10));}
        else if (61 <= d100 && d100 <= 80) {variationtemp = 0;}
        else if (81 <= d100 && d100 <= 95) {variationtemp = ( 1 *dice(1,10));}
        else if (96 <= d100 && d100 <= 99) {variationtemp = ( 1 *dice(2,10));}
        else if (d100 == 100)              {variationtemp = ( 1 *dice(3,10));}

        return variationtemp;
    }
    private static int coldSeasonVariationDuration(int d100){
        int duration = 0;

        if(1 <= d100 && d100 <= 20)        {duration = dice(1,4);}
        else if (21 <= d100 && d100 <= 40) {duration = (dice(1,6) +1);}
        else if (41 <= d100 && d100 <= 60) {duration = (dice(1,6) +2);}
        else if (61 <= d100 && d100 <= 80) {duration = (dice(1,6) +2);}
        else if (81 <= d100 && d100 <= 95) {duration = (dice(1,6) +1);}
        else if (96 <= d100 && d100 <= 99) {duration = dice(1,4);}
        else if (d100 == 100)              {duration = dice(1,2);}

        return duration;
    }
    private static int temperateSeasonVariationTemp(int d100){
        int variationtemp = 0;

        if(1 <= d100 && d100 <= 5)         {variationtemp = (-1 * dice(3,10));}
        else if (6 <= d100 && d100 <= 15)  {variationtemp = (-1 * dice(2,10));}
        else if (16 <= d100 && d100 <= 35) {variationtemp = (-1 * dice(1,10));}
        else if (36 <= d100 && d100 <= 65) {variationtemp = 0;}
        else if (66 <= d100 && d100 <= 85) {variationtemp = dice(1,10);}
        else if (86 <= d100 && d100 <= 95) {variationtemp = dice(2,10);}
        else if (96 <= d100 && d100 <= 100){variationtemp = dice(3,10);}

        return variationtemp;
    }
    private static int temperateSeasonVariationDuration(int d100){
        int duration = 0;

        if(1 <= d100 && d100 <= 5)         {duration = dice(1,2);}
        else if (6 <= d100 && d100 <= 15)  {duration = dice(1,4);}
        else if (16 <= d100 && d100 <= 35) {duration = (dice(1,4) + 1);}
        else if (36 <= d100 && d100 <= 65) {duration = (dice(1,6) + 1);}
        else if (66 <= d100 && d100 <= 85) {duration = (dice(1,4) + 1);}
        else if (86 <= d100 && d100 <= 95) {duration = dice(1,4);}
        else if (96 <= d100 && d100 <= 100){duration = dice(1,2);}

        return duration;
    }
    private static int tropicalSeasonVariationTemp(int d100){
        int variationtemp = 0;

        if(1 <= d100 && d100 <= 10)        {variationtemp = (-1 * dice(2,10));}
        else if (11 <= d100 && d100 <= 25) {variationtemp = (-1 * dice(1,10));}
        else if (26 <= d100 && d100 <= 55) {variationtemp = 0;}
        else if (56 <= d100 && d100 <= 85) {variationtemp = dice(1,10);}
        else if (86 <= d100 && d100 <= 100){variationtemp = dice(2,10);}

        return variationtemp;
    }
    private static int tropicalSeasonVariationDuration(int d100){
        int duration = 0;

        if(1 <= d100 && d100 <= 10)        {duration = dice(1,2);}
        else if (11 <= d100 && d100 <= 25) {duration = dice(1,2);}
        else if (26 <= d100 && d100 <= 55) {duration = dice(1,4);}
        else if (56 <= d100 && d100 <= 85) {duration = dice(1,4);}
        else if (86 <= d100 && d100 <= 100){duration = dice(1,2);}

        return duration;
    }
    private static String preipitaitonFrequency(String season, String climate, String elevation){
        int rarity = 0;
        String frequency = "";

        if(climate.equals("Cold") || climate.equals("Temperate")){
            switch (season){
                case "Spring" -> rarity = 2;
                case "Summer" -> rarity = 3;
                case "Fall"   -> rarity = 2;
                case "Winter" -> rarity = 1;
            }
        } else if (climate.equals("Tropical")) {
            switch (season){
                case "Spring" -> rarity = 3;
                case "Summer" -> rarity = 2;
                case "Fall"   -> rarity = 3;
                case "Winter" -> rarity = 1;
            }
        }

        if(elevation.equals("Highland")){rarity = rarity -1;}

        if(climate.equals("Tropical")){rarity = rarity +1;}
        else if (climate.equals("Cold")) {rarity = rarity -1;}

        if(rarity < 0){rarity = 0;}
        if(rarity > 4){rarity = 4;}

        switch (rarity){
            case 0 -> frequency = "Drought";
            case 1 -> frequency = "Rare";
            case 2 -> frequency = "Intermittent";
            case 3 -> frequency = "Common";
            case 4 -> frequency = "Constant";
        }
        return frequency;
    }
    private static String preipitaitonIntensity(String elevation, String climate, String frequency){
        int intensitylevel = 0;
        String intensity = "";

        switch(elevation){
            case "Sea level" ->  intensitylevel = 3;
            case "Lowland"   ->  intensitylevel = 2;
            case "Highland"  ->  intensitylevel = 2;
            default          ->  intensitylevel = 2;
        }
        switch(climate){
            case "Cold"      ->  intensitylevel = intensitylevel -1 ;
            case "temperate" ->  System.out.println("No adjustment"); //noadjustment
            case "Tropical"  ->  intensitylevel = intensitylevel +1 ;
            default          ->  intensitylevel = intensitylevel;
        }

        if(frequency.equals("Drought")){intensitylevel = intensitylevel -2;}
        if(intensitylevel < 0){intensitylevel = 0;}
        if(intensitylevel > 3){intensitylevel = 3;}

        switch (intensitylevel){
            case 0 -> intensity = "Light";
            case 1 -> intensity = "Medium";
            case 2 -> intensity = "Heavy";
            case 3 -> intensity = "Torrential";
        }
        return intensity;
    }
    private static boolean amIRaining(String frequency){
        boolean raining = false;
        Random rainRand = new Random();
        int d100rain = rainRand.nextInt(100 - 1 + 1) + 1;

        switch (frequency){
            case "Drought"      :
                if(d100rain <= 5){raining = true;}
                else {raining = false;}
                break;
            case "Rare"         :
                if(d100rain <= 15){raining = true;}
                else {raining = false;}
                break;
            case "Intermittent" :
                if(d100rain <= 30){raining = true;}
                else {raining = false;}
                break;
            case "Common"       :
                if(d100rain <= 60){raining = true;}
                else {raining = false;}
                break;
            case "Constant"     :
                if(d100rain <= 95){raining = true;}
                else {raining = false;}
                break;
        }
        return raining;
    }
    private static String percipitationForm(boolean raining, String intensity, int temp){
        String precipitaion = "";
        Random timeRand = new Random();
        int d100when = timeRand.nextInt(24 - 1 + 1) + 1;
        int duration = 0;
        String rainMessage = "";

        if(raining){
            Random rainRand = new Random();
            int d100precipitation = rainRand.nextInt(100 - 1 + 1) + 1;


            switch (intensity){
                case "Light"      :
                    if(temp >= 33){
                        if(1 <= d100precipitation && d100precipitation <= 20){
                            precipitaion = "Light fog";
                            duration = dice(1,8);
                            rainMessage = "Light fog reduces visibility to three-quarters of the normal ranges, resulting in a –2 penalty on Perception checks and a –2 penalty on ranged attacks. Light fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Light fog occurs only when there is no or light wind.\n";

                        } else if (21 <= d100precipitation && d100precipitation <= 40) {
                            precipitaion = "Medium fog";
                            duration = dice(1,6);
                            rainMessage = "Medium fog reduces visibility ranges by half, resulting in a –4 penalty on Perception checks and a –4 penalty on ranged attacks. Medium fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Medium fog occurs only when there is no or light wind.\n";

                        } else if (41 <= d100precipitation && d100precipitation <= 50) {
                            precipitaion = "Drizzle";
                            duration = dice(1,4);
                            rainMessage = "Drizzle reduces visibility to three-quarters of the normal range, imposing a –2 penalty on Perception checks. It automatically extinguishes tiny unprotected flames (candles and the like, but not torches).\n";

                        } else if (51 <= d100precipitation && d100precipitation <= 75) {
                            precipitaion = "Drizzle";
                            duration = dice(2,12);
                            rainMessage = "Drizzle reduces visibility to three-quarters of the normal range, imposing a –2 penalty on Perception checks. It automatically extinguishes tiny unprotected flames (candles and the like, but not torches).\n";

                        } else if (76 <= d100precipitation && d100precipitation <= 90) {
                            precipitaion = "Light rain";
                            duration = dice(1,4);
                            rainMessage = "Light rain reduces visibility ranges by three-quarters, resulting in a –2 penalty on Perception checks. Light rain automatically extinguishes unprotected flames (candles, torches, and the like) and imposes a –2 penalty on ranged attacks.\n";

                        } else if (91 <= d100precipitation && d100precipitation <= 100) {
                            if(temp < 40){
                                precipitaion = "Sleet";
                                duration = 1;
                                rainMessage = "Sleet reduces visibility to three-quarters of the normal range, resulting in a –2 penalty on Perception checks. Sleet has a 75% chance each hour of extinguishing unprotected flames and imposes a –2 penalty on ranged attacks. Sleet does not impedes movement unless it continues for 2 or more hours, at which point moving into a square of such sleet requires 1 extra 5-foot square of movement (this stacks with difficult terrain).\n";
                            }else{
                                precipitaion = "Light rain";
                                duration = 1;
                                rainMessage = "Light rain reduces visibility ranges by three-quarters, resulting in a –2 penalty on Perception checks. Light rain automatically extinguishes unprotected flames (candles, torches, and the like) and imposes a –2 penalty on ranged attacks.\n";
                            }
                        }
                    } else if (temp <= 32) {
                        if(1 <= d100precipitation && d100precipitation <= 20){
                            precipitaion = "Light fog";
                            duration = dice(1,6);
                            rainMessage = "Light fog reduces visibility to three-quarters of the normal ranges, resulting in a –2 penalty on Perception checks and a –2 penalty on ranged attacks. Light fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Light fog occurs only when there is no or light wind.\n";
                        } else if (21 <= d100precipitation && d100precipitation <= 40) {
                            precipitaion = "Lightfog";
                            duration = dice(1,8);
                            rainMessage = "Light fog reduces visibility to three-quarters of the normal ranges, resulting in a –2 penalty on Perception checks and a –2 penalty on ranged attacks. Light fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Light fog occurs only when there is no or light wind.\n";

                        } else if (41 <= d100precipitation && d100precipitation <= 50) {
                            precipitaion = "Medium fog";
                            duration = dice(1,4);
                            rainMessage = "Medium fog reduces visibility ranges by half, resulting in a –4 penalty on Perception checks and a –4 penalty on ranged attacks. Medium fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Medium fog occurs only when there is no or light wind.\n";
                        } else if (51 <= d100precipitation && d100precipitation <= 60) {
                            precipitaion = "Light snow";
                            duration = 1;
                            rainMessage = "Light snow reduces visibility to three-quarters of the normal range, resulting in a –2 penalty on Perception checks. Light snow has a 75% chance each hour of extinguishing unprotected flames and imposes a –2 penalty on ranged attacks. Light snow does not impede movement unless it continues for 2 or more hours, at which point moving into a square of such snow requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every 2 hours of light snow leaves 1 inch of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, entering a snow-filled square instead requires 2 extra squares of movement.\n";
                        } else if (61 <= d100precipitation && d100precipitation <= 75) {
                            precipitaion = "Light snow";
                            duration = dice(1,4);
                            rainMessage = "Light snow reduces visibility to three-quarters of the normal range, resulting in a –2 penalty on Perception checks. Light snow has a 75% chance each hour of extinguishing unprotected flames and imposes a –2 penalty on ranged attacks. Light snow does not impede movement unless it continues for 2 or more hours, at which point moving into a square of such snow requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every 2 hours of light snow leaves 1 inch of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, entering a snow-filled square instead requires 2 extra squares of movement.\n";
                        } else if (76 <= d100precipitation && d100precipitation <= 100) {
                            precipitaion = "Light snow";
                            duration = dice(2,12);
                            rainMessage = "Light snow reduces visibility to three-quarters of the normal range, resulting in a –2 penalty on Perception checks. Light snow has a 75% chance each hour of extinguishing unprotected flames and imposes a –2 penalty on ranged attacks. Light snow does not impede movement unless it continues for 2 or more hours, at which point moving into a square of such snow requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every 2 hours of light snow leaves 1 inch of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, entering a snow-filled square instead requires 2 extra squares of movement.\n";
                        }
                    }
                    break;
                case "Medium"     :
                    if(temp >= 33){
                        if(1 <= d100precipitation && d100precipitation <= 10){
                            precipitaion = "Medium fog";
                            duration = dice(1,8);
                            rainMessage = "Medium fog reduces visibility ranges by half, resulting in a –4 penalty on Perception checks and a –4 penalty on ranged attacks. Medium fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Medium fog occurs only when there is no or light wind.\n";

                        } else if (11 <= d100precipitation && d100precipitation <= 20) {
                            precipitaion = "Medium fog";
                            duration = dice(1,12);
                            rainMessage = "Medium fog reduces visibility ranges by half, resulting in a –4 penalty on Perception checks and a –4 penalty on ranged attacks. Medium fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Medium fog occurs only when there is no or light wind.\n";

                        } else if (21 <= d100precipitation && d100precipitation <= 30) {
                            precipitaion = "Heavy fog";
                            duration = dice(1,4);
                            rainMessage = "Heavy fog obscures all vision beyond 5 feet, including darkvision. Creatures 5 feet away have concealment. Heavy fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Heavy fog occurs only when there is no or light wind.";

                        } else if (31 <= d100precipitation && d100precipitation <= 35) {
                            precipitaion = "Rain";
                            duration = dice(1,4);
                            rainMessage = "Rain reduces visibility ranges by half, resulting in a –4 penalty on Perception checks. Rain automatically extinguishes unprotected flames (candles, torches, and the like) and imposes a –4 penalty on ranged attacks.\n";

                        } else if (36 <= d100precipitation && d100precipitation <= 70) {
                            precipitaion = "Rain";
                            duration = dice(1,8);
                            rainMessage = "Rain reduces visibility ranges by half, resulting in a –4 penalty on Perception checks. Rain automatically extinguishes unprotected flames (candles, torches, and the like) and imposes a –4 penalty on ranged attacks.\n";

                        } else if (71 <= d100precipitation && d100precipitation <= 90) {
                            precipitaion = "Rain";
                            duration = dice(2,12);
                            rainMessage = "Rain reduces visibility ranges by half, resulting in a –4 penalty on Perception checks. Rain automatically extinguishes unprotected flames (candles, torches, and the like) and imposes a –4 penalty on ranged attacks.\n";
                           
                        } else if (91 <= d100precipitation && d100precipitation <= 100) {
                            if(temp < 40){
                                precipitaion = "Sleet";
                                duration = dice(1,4);
                                rainMessage = "Sleet reduces visibility to three-quarters of the normal range, resulting in a –4 penalty on Perception checks. Sleet has a 75% chance each hour of extinguishing unprotected flames and imposes a –4 penalty on ranged attacks. Sleet does not impedes movement unless it continues for 2 or more hours, at which point moving into a square of such sleet requires 1 extra 5-foot square of movement (this stacks with difficult terrain).\n";
                            }else{
                                precipitaion = "Rain";
                                duration = dice(1,4);
                                rainMessage = "Rain reduces visibility ranges by half, resulting in a –4 penalty on Perception checks. Rain automatically extinguishes unprotected flames (candles, torches, and the like) and imposes a –4 penalty on ranged attacks.\n";
                            }
                        }
                    } else if (temp <= 32) {
                        if(1 <= d100precipitation && d100precipitation <= 10){
                            precipitaion = "Medium fog";
                            duration = dice(1,6);
                            rainMessage = "Medium fog reduces visibility ranges by half, resulting in a –4 penalty on Perception checks and a –4 penalty on ranged attacks. Medium fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Medium fog occurs only when there is no or light wind.\n";
                        } else if (11 <= d100precipitation && d100precipitation <= 20) {
                            precipitaion = "Medium fog";
                            duration = dice(1,8);
                            rainMessage = "Medium fog reduces visibility ranges by half, resulting in a –4 penalty on Perception checks and a –4 penalty on ranged attacks. Medium fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Medium fog occurs only when there is no or light wind.\n";
                        } else if (21 <= d100precipitation && d100precipitation <= 30) {
                            precipitaion = "Heavy fog";
                            duration = dice(1,4);
                            rainMessage = "Heavy fog obscures all vision beyond 5 feet, including darkvision. Creatures 5 feet away have concealment. Heavy fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Heavy fog occurs only when there is no or light wind.\n";
                        } else if (31 <= d100precipitation && d100precipitation <= 50) {
                            precipitaion = "Medium snow";
                            duration = dice(1,4);
                            rainMessage = "Medium snow reduces visibility ranges by half, resulting in a –4 penalty on Perception checks. Medium snow extinguishes unprotected flames and imposes a –4 penalty on ranged attacks. Medium snow does not impede movement unless it continues for 1 hour, at which point moving into a square of such snow requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every hour of medium snow leaves 1 inch of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, entering a snow-filled square instead requires 2 extra squares of movement.\n";
                        } else if (51 <= d100precipitation && d100precipitation <= 90) {
                            precipitaion = "Medium snow";
                            duration = dice(1,8);
                            rainMessage = "Medium snow reduces visibility ranges by half, resulting in a –4 penalty on Perception checks. Medium snow extinguishes unprotected flames and imposes a –4 penalty on ranged attacks. Medium snow does not impede movement unless it continues for 1 hour, at which point moving into a square of such snow requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every hour of medium snow leaves 1 inch of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, entering a snow-filled square instead requires 2 extra squares of movement.\n";
                        } else if (91 <= d100precipitation && d100precipitation <= 100) {
                            precipitaion = "Medium snow";
                            duration = dice(2,12);
                            rainMessage = "Medium snow reduces visibility ranges by half, resulting in a –4 penalty on Perception checks. Medium snow extinguishes unprotected flames and imposes a –4 penalty on ranged attacks. Medium snow does not impede movement unless it continues for 1 hour, at which point moving into a square of such snow requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every hour of medium snow leaves 1 inch of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, entering a snow-filled square instead requires 2 extra squares of movement.\n";
                        }
                    }
                    break;
                case "Heavy"      :
                    if(temp >= 33){

                        if(1 <= d100precipitation && d100precipitation <= 10){
                            precipitaion = "Heavy fog";
                            duration = dice(1,8);
                            rainMessage = "Heavy fog obscures all vision beyond 5 feet, including darkvision. Creatures 5 feet away have concealment. Heavy fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Heavy fog occurs only when there is no or light wind.\n";

                        } else if (11 <= d100precipitation && d100precipitation <= 20) {
                            precipitaion = "Heavy fog";
                            duration = dice(2,6);
                            rainMessage = "Heavy fog obscures all vision beyond 5 feet, including darkvision. Creatures 5 feet away have concealment. Heavy fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Heavy fog occurs only when there is no or light wind.\n";

                        } else if (21 <= d100precipitation && d100precipitation <= 50) {
                            precipitaion = "Heavy rain";
                            duration = dice(1,12);
                            rainMessage = "Heavy rain reduces visibility to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. Heavy rain automatically extinguishes unprotected flames and imposes a –6 penalty on ranged attacks.\n";

                        } else if (51 <= d100precipitation && d100precipitation <= 70) {
                            precipitaion = "Heavy rain";
                            duration = dice(2,12);
                            rainMessage = "Heavy rain reduces visibility to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. Heavy rain automatically extinguishes unprotected flames and imposes a –6 penalty on ranged attacks.\n";

                        } else if (71 <= d100precipitation && d100precipitation <= 85) {
                            if(temp < 40){
                                precipitaion = "Heavy Sleet";
                                duration = dice(1,8);
                                rainMessage = "Heavy sleet reduces visibility to three-quarters of the normal range, resulting in a –6 penalty on Perception checks. Heavy sleet has a 75% chance each hour of extinguishing unprotected flames and imposes a –6 penalty on ranged attacks. Heavy sleet does not impede movement unless it continues for 2 or more hours, at which point moving into a square of such sleet requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every 2 hours of Heavy sleet leaves 1 inch of sleet on the ground. As long as at least 2 inches of sleet remain on the ground, the requirement of an extra square of movement to enter a square of sleet persists. If at least 1 foot of sleet remains on the ground, entering a sleet-filled square instead requires 2 extra squares of movement.\n";
                            }else{
                                precipitaion = "Heavy rain";
                                duration = dice(1,8);
                                rainMessage = "Heavy rain reduces visibility to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. Heavy rain automatically extinguishes unprotected flames and imposes a –6 penalty on ranged attacks.\n";
                            }

                        } else if (86 <= d100precipitation && d100precipitation <= 90) {
                            precipitaion = "Thunderstorm";
                            duration = 1;
                            rainMessage = thunderstormWinds(temp);
                            
                        } else if (91 <= d100precipitation && d100precipitation <= 100) {
                            precipitaion = "Thunderstorm";
                            duration = dice(1,3);
                            rainMessage = thunderstormWinds(temp);

                        }

                    } else if (temp <= 32) {
                        if(1 <= d100precipitation && d100precipitation <= 10){
                            precipitaion = "Medium fog";
                            duration = dice(1,8);
                            rainMessage = "Medium fog reduces visibility ranges by half, resulting in a –4 penalty on Perception checks and a –4 penalty on ranged attacks. Medium fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Medium fog occurs only when there is no or light wind.\n";

                        } else if (11 <= d100precipitation && d100precipitation <= 20) {
                            precipitaion = "Heavy fog";
                            duration = dice(2,6);
                            rainMessage = "Heavy fog obscures all vision beyond 5 feet, including darkvision. Creatures 5 feet away have concealment. Heavy fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Heavy fog occurs only when there is no or light wind.\n";

                        } else if (21 <= d100precipitation && d100precipitation <= 60) {
                            precipitaion = "Light snow";
                            duration = dice(2,12);
                            rainMessage = "Light snow reduces visibility to three-quarters of the normal range, resulting in a –2 penalty on Perception checks. Light snow has a 75% chance each hour of extinguishing unprotected flames and imposes a –2 penalty on ranged attacks. Light snow does not impede movement unless it continues for 2 or more hours, at which point moving into a square of such snow requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every 2 hours of light snow leaves 1 inch of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, entering a snow-filled square instead requires 2 extra squares of movement.\n";

                        } else if (61 <= d100precipitation && d100precipitation <= 90) {
                            precipitaion = "Medium snow";
                            duration = dice(1,8);
                            rainMessage = "Medium snow reduces visibility ranges by half, resulting in a –4 penalty on Perception checks. Medium snow extinguishes unprotected flames and imposes a –4 penalty on ranged attacks. Medium snow does not impede movement unless it continues for 1 hour, at which point moving into a square of such snow requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every hour of medium snow leaves 1 inch of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, entering a snow-filled square instead requires 2 extra squares of movement.\n";

                        } else if (91 <= d100precipitation && d100precipitation <= 100) {
                            precipitaion = "Heavy snow";
                            duration = dice(1,6);
                            rainMessage = "Heavy snow reduces visibility ranges to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. It extinguishes unprotected flames and imposes a –6 penalty on ranged attacks. Heavy snow impedes movement even before it begins to stick. Moving into a square during a heavy snowstorm requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every hour of heavy snow leaves 1d4 inches of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, 2 extra squares of movement are required to enter a snow-filled square instead. A heavy snowstorm has a 10% chance of generating thundersnow and has a 40% chance of becoming a blizzard if the wind speed is severe or stronger.\n";

                        }

                    }
                    break;
                case "Torrential" :
                    if(temp >= 33){
                        if(1 <= d100precipitation && d100precipitation <= 5){
                            precipitaion = "Heavy fog";
                            duration = dice(1,8);
                            rainMessage = "Heavy fog obscures all vision beyond 5 feet, including darkvision. Creatures 5 feet away have concealment. Heavy fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Heavy fog occurs only when there is no or light wind.\n";

                        } else if (6 <= d100precipitation && d100precipitation <= 10) {
                            precipitaion = "Heavy fog";
                            duration = dice(2,6);
                            rainMessage ="Heavy fog obscures all vision beyond 5 feet, including darkvision. Creatures 5 feet away have concealment. Heavy fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Heavy fog occurs only when there is no or light wind.\n";
                            
                        } else if (11 <= d100precipitation && d100precipitation <= 30) {
                            precipitaion = "Heavy rain";
                            duration = dice(2,6);
                            rainMessage = "Heavy rain reduces visibility to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. Heavy rain automatically extinguishes unprotected flames and imposes a –6 penalty on ranged attacks.\n";
                            
                        } else if (31 <= d100precipitation && d100precipitation <= 60) {
                            precipitaion = "Heavy rain";
                            duration = dice(2,12);
                            rainMessage = "Heavy rain reduces visibility to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. Heavy rain automatically extinguishes unprotected flames and imposes a –6 penalty on ranged attacks.\n";
                            
                        } else if (61 <= d100precipitation && d100precipitation <= 80) {
                            if(temp < 40){
                                precipitaion = "Heavy sleet";
                                duration = dice(2,6);
                                rainMessage = "Heavy sleet reduces visibility to three-quarters of the normal range, resulting in a –6 penalty on Perception checks. Heavy sleet has a 75% chance each hour of extinguishing unprotected flames and imposes a –6 penalty on ranged attacks. Heavy sleet does not impede movement unless it continues for 2 or more hours, at which point moving into a square of such sleet requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every 2 hours of Heavy sleet leaves 1 inch of sleet on the ground. As long as at least 2 inches of sleet remain on the ground, the requirement of an extra square of movement to enter a square of sleet persists. If at least 1 foot of sleet remains on the ground, entering a sleet-filled square instead requires 2 extra squares of movement.\n";
                            }else{
                                precipitaion = "Heavy Rain";
                                duration = dice(2,6);
                                rainMessage = "Heavy rain reduces visibility to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. Heavy rain automatically extinguishes unprotected flames and imposes a –6 penalty on ranged attacks.";
                            }
                            
                        } else if (81 <= d100precipitation && d100precipitation <= 95) {
                            precipitaion = "Thunderstorm";
                            duration = dice(1,3);
                            rainMessage = thunderstormWinds(temp);
                            
                        } else if (96 <= d100precipitation && d100precipitation <= 100) {
                            precipitaion = "Thunderstorm";
                            duration = dice(1,6);
                            rainMessage = thunderstormWinds(temp);
                            
                        }
                    } else if (temp <= 32) {
                        if(1 <= d100precipitation && d100precipitation <= 5){
                            precipitaion = "Heavy fog";
                            duration = dice(1,8);
                            rainMessage = "Heavy fog obscures all vision beyond 5 feet, including darkvision. Creatures 5 feet away have concealment. Heavy fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Heavy fog occurs only when there is no or light wind.\n";

                        } else if (6 <= d100precipitation && d100precipitation <= 10) {
                            precipitaion = "Heavy fog";
                            duration = dice(2,6);
                            rainMessage = "Heavy fog obscures all vision beyond 5 feet, including darkvision. Creatures 5 feet away have concealment. Heavy fog typically occurs early in the day, late in the day, or sometimes at night, but the heat of the midday usually burns it away. Heavy fog occurs only when there is no or light wind.\n";

                        } else if (11 <= d100precipitation && d100precipitation <= 50) {
                            precipitaion = "Heavy snow";
                            duration = dice(1,4);
                            rainMessage = "Heavy snow reduces visibility ranges to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. It extinguishes unprotected flames and imposes a –6 penalty on ranged attacks. Heavy snow impedes movement even before it begins to stick. Moving into a square during a heavy snowstorm requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every hour of heavy snow leaves 1d4 inches of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, 2 extra squares of movement are required to enter a snow-filled square instead. A heavy snowstorm has a 10% chance of generating thundersnow and has a 40% chance of becoming a blizzard if the wind speed is severe or stronger.\n";

                        } else if (51 <= d100precipitation && d100precipitation <= 90) {
                            precipitaion = "Heavy snow";
                            duration = dice(1,8);
                            rainMessage = "Heavy snow reduces visibility ranges to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. It extinguishes unprotected flames and imposes a –6 penalty on ranged attacks. Heavy snow impedes movement even before it begins to stick. Moving into a square during a heavy snowstorm requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every hour of heavy snow leaves 1d4 inches of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, 2 extra squares of movement are required to enter a snow-filled square instead. A heavy snowstorm has a 10% chance of generating thundersnow and has a 40% chance of becoming a blizzard if the wind speed is severe or stronger.\n";

                        } else if (91 <= d100precipitation && d100precipitation <= 100) {
                            precipitaion = "Heavy snow";
                            duration = dice(2,12);
                            rainMessage = "Heavy snow reduces visibility ranges to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. It extinguishes unprotected flames and imposes a –6 penalty on ranged attacks. Heavy snow impedes movement even before it begins to stick. Moving into a square during a heavy snowstorm requires 1 extra 5-foot square of movement (this stacks with difficult terrain). Every hour of heavy snow leaves 1d4 inches of snow on the ground. As long as at least 2 inches of snow remain on the ground, the requirement of an extra square of movement to enter a square of snow persists. If at least 1 foot of snow remains on the ground, 2 extra squares of movement are required to enter a snow-filled square instead. A heavy snowstorm has a 10% chance of generating thundersnow and has a 40% chance of becoming a blizzard if the wind speed is severe or stronger.\n";
                        }
                    }
                    break;
            }
        } else {return "";}

        return "\nAt " + d100when + ":00, expect " + precipitaion + " for " + duration + " hours. " + rainMessage;
    }
    private static String thunderstormWinds(int temp){
        Random thunderRand = new Random();
        int d100wind = thunderRand.nextInt(100 - 1 + 1) + 1;
        int d100hail = thunderRand.nextInt(100 - 1 + 1) + 1;
        int d100tornado = thunderRand.nextInt(100 - 1 + 1) + 1;
        int d100before = thunderRand.nextInt(100 - 1 + 1) + 1;
        String winds = "An even greater danger presented by a thunderstorm is the lightning that occurs during the storm. These electrical discharges, generated by the roiling clouds, can pose a hazard to creatures that do not have proper shelters, especially creatures clad in metal armor. Every 10 minutes during a thunderstorm, a bolt of lightning strikes an unsheltered creature at random (though this can strike wildlife as easily as PCs). A creature struck by this lightning must succeed a DC 18 Reflex saving throw or take 10d8 points of electricity damage (a successful saving throw halves the damage). Creatures in metal armor take a –4 penalty on the Reflex saving throw.";

        if(1 <= d100wind && d100wind <= 50)        {winds = winds + "Strong winds";}
        else if (51 <= d100wind && d100wind <= 90) {winds = winds + "Severe winds";}
        else if (91 <= d100wind && d100wind <= 100){winds = winds + "Windstorm";}

        if(1 <= d100hail && d100hail <= 40){
            if(d100before >= 50){winds = winds + "Hail for 1 hour during the storm.";}
                            else{winds = winds + "Hail for 1 hour before the storm.";}
        }
        if(1 <= d100tornado && d100tornado <= 10){winds = winds + "With winds with speeds of 174–300 miles per hour, tornados are deadly terrors. The smallest tornados occupy a 20-foot-radius burst, with winds of windstorm strength swirling up to 100 feet beyond that burst. The largest tornados can be 100-foot-radius bursts, with a windstorm whose radius extends 500 feet beyond that burst. Ranged attacks, including normal, siege, and even those produced by evocation spells, are impossible in the core burst of a tornado. Huge or smaller creatures must succeed a DC 20 Strength check or be sucked up by the funnel of the tornado; this deals 8d8 points of bludgeoning, piercing, and slashing lethal damage to the creatures. This damage ignores all but DR/epic, DR/—, and hardness. Once it deals this damage, the tornado flings the creature it has sucked up 1d20×10 feet up and away from the tornado, dealing 1d6 points of falling damage per 10 feet that the creature is flung. Gargantuan and larger creatures take the 8d8 points of damage but are not moved by the tornado. A tornado moves at a speed of 40 feet, though the direction it moves is entirely unpredictable—you can determine the direction randomly each round. Tornados typically last for 3d6 minutes, but some can swirl for up to an hour. While most tornados are created by thunderstorms, some smaller tornados (typically with a 5- to 10-foot-burst radius, with no outer radius) can be created in areas of wildfire (firenados), snow (snownados), or sand (dust devils). They deal a similar amount of damage, but firenados deal fire damage, snownados deal cold damage, and dust devils deal bludgeoning damage only, and these types of tornados do not fling their targets.";}
        else if ((11 <= d100tornado && d100tornado <= 30) && temp >= 85) {winds = winds + "Hurricanes are incredibly massive storms featuring heavy rain and a wind strength greater than that of the most powerful windstorm. With winds of 75–174 miles per hour, a hurricane renders ranged attacks impossible, and siege weapons take a –8 penalty on attack rolls. Large or smaller creatures must succeed at a DC 15 Strength check or they are unable to move forward against the strength of the wind. Medium or smaller creatures on the ground must succeed at a DC 15 Strength check or they are knocked prone and roll 1d6x10 feet, taking 1d6 points of nonlethal damage per 10 feet. Flying creatures must succeed at a DC 25 Fly check or they are blown back 2d8×10 feet and take 4d6 points of nonlethal damage due to battering and buffeting. Hurricanes also usually cause flooding. It’s nearly impossible to journey out into a hurricane unscathed.";}

        return winds;
    }
    private static String wind(String winds){
        Random windRand = new Random();
        int d100winds    = windRand.nextInt(100 - 1 + 1) + 1;

        int lightwind    = windRand.nextInt(10 - 1 + 1) + 1;
        int moderatewind = windRand.nextInt(10 - 1 + 1) + 1;
        int strongwind   = windRand.nextInt(10 - 1 + 1) + 1;
        int severewind   = windRand.nextInt(20 - 1 + 1) + 1;
        int windstorm    = windRand.nextInt(100 - 1 + 1) + 1;

        String windstrength = "";
        int windspeed = 0;
        String windPenalty = "";
        String checkSize = "";
        String blownAwaySize = "";
        int skillPenalty = 0;
        String windstats = "";

        if(!winds.contains("Strong winds") || !winds.contains("Severe winds") ||!winds.contains("Windstorm") ){
            if(1 <= d100winds && d100winds <= 50)        {windstrength = "light"; windspeed = lightwind;}
            else if (51 <= d100winds && d100winds <= 80) {windstrength = "Moderate"; windspeed = moderatewind + 10;}
            else if (81 <= d100winds && d100winds <= 90) {windstrength = "Strong"; windspeed = strongwind + 20; windPenalty = "-2 (range)/-- (Siege)"; checkSize = "tiny"; skillPenalty = -2;}
            else if (91 <= d100winds && d100winds <= 95) {windstrength = "Sever"; windspeed = severewind +30; windPenalty = "-4 (range)/-- (Siege)"; checkSize = "small"; blownAwaySize = "tiny";
                skillPenalty = -4;}
            else if (96 <= d100winds && d100winds <= 100) {
                windstrength = "strom";
                windspeed = windstorm +50;
                windPenalty = "Impossible (range)/–4 (Siege)";
                checkSize = "medium";
                blownAwaySize = "small";
                skillPenalty = -8;
            }
            windstats = "There are: " + windstrength + "winds. These winds are going " + windspeed + "mph.  Wind speed typically fluctuates between these values through the period of the day, and for moderate or higher wind strength, there are periods in the day when the wind speed dips. ";
            if(!windPenalty.equals("")){
                windstats = windstats + "There is a " + windPenalty + " penalty for charaters when they fire ranged weapons.";
                if(windPenalty.equals("Impossible (range)/–4 (Siege)")){
                    windstats = windstats + "In windstorm-strength wind, normal ranged weapon attacks (either projectile or thrown) are impossible. This includes ranged attacks made via spells of the conjuration school, but it does not include evocation ranged attacks. Siege weapons include all weapons of that type and boulders thrown by giants and other creatures with the rock throwing special attack.";
                }
                windstats = windstats + "Creatures that are " + checkSize + "or smaller are unable to move forward against the force of the wind unless they succeed at a DC 10 Strength check (on the ground) or a DC 20 Fly check if airborne.";
                windstats = windstats + " a " + skillPenalty + " penality is applied for skill checks that can be affected by the wind. These penalties always apply on Fly checks and sound-based Perception checks, but GMs may also wish to apply them on Acrobatics checks, Climb checks, and any other ability or skill checks that could be adversely affected by winds.";
            }
            if(!blownAwaySize.equals("")){
                windstats = windstats + "Creates that are " + blownAwaySize + " or smaller are ground are knocked prone, roll 1d4×10 feet, and take 2d6 points of nonlethal damage, unless they succeed on a DC 15 Strength check. Flying creatures of the listed size are blown back 2d6×10 feet and take 2d6 points of nonlethal damage due to battering and buffeting, unless they succeed at a DC 25 Fly check.";
            }else {
                if(winds.contains("Strong winds"))
                {windstrength = "Strong"; windspeed = strongwind; windPenalty = "-2 (range)/-- (Siege)"; checkSize = "tiny"; skillPenalty = -2;
                    windstats = "There are: " + windstrength + "winds. These winds are going " + windspeed + "mph.  Wind speed typically fluctuates between these values through the period of the day, and for moderate or higher wind strength, there are periods in the day when the wind speed dips. " + checkSize + "or smaller are unable to move forward against the force of the wind unless they succeed at a DC 10 Strength check (on the ground) or a DC 20 Fly check if airborne.";
                    windstats = windstats + " a " + skillPenalty + " penality is applied for skill checks that can be affected by the wind. These penalties always apply on Fly checks and sound-based Perception checks, but GMs may also wish to apply them on Acrobatics checks, Climb checks, and any other ability or skill checks that could be adversely affected by winds.";
                    windstats = windstats + " The penalty for attacks are: " + windPenalty;
                }
                else if (winds.contains("Severe winds")) {windstrength = "Sever"; windspeed = severewind; windPenalty = "-4 (range)/-- (Siege)"; checkSize = "small"; blownAwaySize = "tiny";
                    skillPenalty = -4;
                    windstats = "There are: " + windstrength + "winds. These winds are going " + windspeed + "mph.  Wind speed typically fluctuates between these values through the period of the day, and for moderate or higher wind strength, there are periods in the day when the wind speed dips. " + checkSize + "or smaller are unable to move forward against the force of the wind unless they succeed at a DC 10 Strength check (on the ground) or a DC 20 Fly check if airborne.";
                    windstats = windstats + " a " + skillPenalty + " penality is applied for skill checks that can be affected by the wind. These penalties always apply on Fly checks and sound-based Perception checks, but GMs may also wish to apply them on Acrobatics checks, Climb checks, and any other ability or skill checks that could be adversely affected by winds.";
                    windstats = windstats + " The penalty for attacks are: " + windPenalty;
                    windstats = windstats + "Creatures that are " + blownAwaySize + " or smaller and on the ground are knocked prone, roll 1d4×10 feet, and take 2d6 points of nonlethal damage, unless they succeed on a DC 15 Strength check. Flying creatures of the listed size are blown back 2d6×10 feet and take 2d6 points of nonlethal damage due to battering and buffeting, unless they succeed at a DC 25 Fly check.";
                }
                else if (winds.contains("Windstorm")) {
                    windstrength = "strom";
                    windspeed = windstorm;
                    windPenalty = "Impossible/–4";
                    checkSize = "medium";
                    blownAwaySize = "small";
                    skillPenalty = -8;
                    windstats = "There are: " + windstrength + "winds. These winds are going " + windspeed + "mph.  Wind speed typically fluctuates between these values through the period of the day, and for moderate or higher wind strength, there are periods in the day when the wind speed dips. " + checkSize + "or smaller are unable to move forward against the force of the wind unless they succeed at a DC 10 Strength check (on the ground) or a DC 20 Fly check if airborne.";
                    windstats = windstats + " a " + skillPenalty + " penality is applied for skill checks that can be affected by the wind. These penalties always apply on Fly checks and sound-based Perception checks, but GMs may also wish to apply them on Acrobatics checks, Climb checks, and any other ability or skill checks that could be adversely affected by winds.";
                    windstats = windstats + " The penalty for attacks are: " + windPenalty;
                    windstats = windstats + "Creatures that are " + blownAwaySize + " or smaller and on the ground are knocked prone, roll 1d4×10 feet, and take 2d6 points of nonlethal damage, unless they succeed on a DC 15 Strength check. Flying creatures of the listed size are blown back 2d6×10 feet and take 2d6 points of nonlethal damage due to battering and buffeting, unless they succeed at a DC 25 Fly check.";
                }
            }

        }
        return windstats;
    }
    private static String clouds(boolean precipitation){
        Random cloudRand = new Random();
        int d100cloud    = cloudRand.nextInt(100 - 1 + 1) + 1;
        String clouds = "";
        //Overcast conditions without precipitation increase the temperature in fall and winter by 10° F
        // and decrease the temperature in spring and summer by the same amount. If precipitation occurs, the cloud cover functions as overcast.
        if(precipitation == false){
            if(1 <= d100cloud && d100cloud <= 50)         {clouds = "No cloud cover";}
            else if (51 <= d100cloud && d100cloud <= 70)  {clouds = "Light clouds";}
            else if (71 <= d100cloud && d100cloud <= 85)  {clouds = "Medium clouds";}
            else if (86 <= d100cloud && d100cloud <= 100) {clouds = "Overcast. Overcast conditions grant concealment for creatures flying at high altitudes.";}
        }

        return clouds;
    }
    private static String weatherrWarning(int temp, String elevation){
        String warningmessage = "";
        if(temp <= 0){
            warningmessage = "Whenever the temperature is at or below 0 degrees Fahrenheit, a creature exposed to the cold must succeed on a DC 10 Constitution saving throw at the end of each hour or gain one level of exhaustion. Creatures with resistance or immunity to cold damage automatically succeed on the saving thrown as do creatures wearing cold weather gear (thick coats, gloves, and the like) and creatures naturally adapted to cold climates.";
        } else if (temp >= 100) {
            warningmessage = "When the temperature is at or above 100 degrees Fahrenheit, a creature exposed to the heat and without access to drinkable water must succeed on a Constitution saving throw at the end of each hour or gain one level of exhaustion. The DC is 5 for the first hour and increases by 1 for each additional hour. Creatures wearing medium or heavy armor, or who are clad in heavy clothing, have disadvantage on the saving throw. Creatures with resistance or immunity to fire damage automatically succeed on the saving throw, as do creatures naturally adapted to hot climates.";
        }
        //wind and precipitation are already handled
        if(elevation.equals("Highland")){
            warningmessage = warningmessage + "Traveling at altitudes of 10,000 feet or higher above sea level is taxing for a creature that needs to breathe, because of the reduced amount of oxygen in the air. Each hour such a creature spends traveling at high altitude counts as 2 hours for the purpose of determining how long that creature can travel.\n" +
                    "\n" +
                    "Breathing creatures can become acclimated to a high altitude by spending 30 days or more at this elevation. Breathing creatures can’t become acclimated to elevations above 20,000 feet unless they are native to such environments.";
        }
        return "\n" + warningmessage;
    }
    private static String extreamWeatherEvent(int temp, boolean rain){
        Random badweatherRand = new Random();
        int d200bad = badweatherRand.nextInt(200 - 1 + 1) + 1;
        String badevent = "";

        if(d200bad == 200){
            if(temp <= 32){
                if(rain == true){
                    int d3bad = badweatherRand.nextInt(3 - 1 + 1) + 1;
                    switch (d3bad){
                        case 1: badevent = "## Blizzard\n";
                            badevent = badevent + "Heavy snow that is " + dice(1,3) + " feet deep. reduces visibility ranges to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. It extinguishes unprotected flames and imposes a –6 penalty on ranged attacks. Heavy snow impedes movement even before it begins to stick. Moving requires 2 extra 5-foot square of movement (this stacks with difficult terrain). A creature exposed to the blizzard must succeed on a DC 10 Constitution saving throw at the end of each hour or gain one level of exhaustion. Creatures with resistance or immunity to cold damage automatically succeed on the saving thrown as do creatures naturally adapted to cold climates as well. ";
                            break;
                        case 2: badevent = "## Red Snow\n";
                        badevent = badevent + "Red snow is a rare phenomenon where appears red due to high levels of iron oxide or other minerals, potentially causing environmental and health concerns. Every 1 mintues a creature must make a DC 15 (+ 1 for every additional 10 mintues) or take 1d6 posion damage. Creatures with immunity always succeed. ";
                            break;
                        case 3: badevent = "## Snowdrift\n";
                        badevent = badevent + "Windy conditions during heavy snow result in snowdrifts " + (dice(1,4) * 5) + " feet deep, usually around objects large enough to deflect the wind.";
                            break;
                    }
                }else {
                    int d3bad2 = badweatherRand.nextInt(2 - 1 + 1) + 1;
                    switch (d3bad2){
                        case 1 : badevent = "## Snowdrift\n";
                            badevent = badevent + "Windy conditions during heavy snow result in snowdrifts " + (dice(1,4) * 5) + " feet deep, usually around objects large enough to deflect the wind.";
                            break;
                        case 2 : badevent = "## Coldsnap\n";
                        if(temp >= 0){
                            badevent = badevent + "The temperature is reduce to 0";
                            break;
                        }else{
                            badevent = badevent + "The temperature is reduce to -" + (dice(3,10)) + " degrees.";
                            badevent = badevent + "Whenever the temperature is at or below 0 degrees Fahrenheit, a creature exposed to the cold must succeed on a DC 10 Constitution saving throw at the end of each hour or gain one level of exhaustion. Creatures with resistance or immunity to cold damage automatically succeed on the saving thrown as do creatures wearing cold weather gear (thick coats, gloves, and the like) and creatures naturally adapted to cold climates.";
                            break;
                        }
                    }
          }
            } else if (temp >= 33) {
                if(rain == true){
                    int d3bad3 = badweatherRand.nextInt(2 - 1 + 1) + 1;
                    switch (d3bad3){
                        case 1 : badevent = "## Flooding\n";
                            badevent = badevent + "Heavy rainfall has caused flooding with water that is" + dice(2,6) + " feet deep. reduces visibility ranges to one-quarter of the normal range, resulting in a –6 penalty on Perception checks. It extinguishes unprotected flames and imposes a –6 penalty on ranged attacks. Heavy rainfall impedes movement even before it begins to stick. Moving requires 2 extra 5-foot square of movement (this stacks with difficult terrain). In some cases may require swimming rather than typical walking movement. The GM can also rule the water is `frigid`. If so A creature can be immersed in frigid water for a number of minutes equal to its Constitution score before suffering any ill effects, Each additional minute spent in frigid water requires the creature to succeed on a DC 10 Constitution saving throw or gain one level of exhaustion. Creatures with resistance or immunity to cold damage automatically succeed on the saving throw as do creatures that are naturally adapted to living in ice-cold w^ater.";
                            break;
                        case 2 :
                            if(temp >= 41){
                                badevent = "## Red rain\n";
                                badevent = badevent + "Red rain is a rare phenomenon where appears red due to high levels of iron oxide or other minerals, potentially causing environmental and health concerns. Every 1 mintues a creature must make a DC 15 (+ 1 for every additional 10 mintues) or take 1d6 posion damage. Creatures with immunity always succeed. Every hour of being in clothing wet from this make make this save every hour, even if the strom has passed. ";
                                break;
                            }else{
                                badevent = "## Red sleet\n";
                                badevent = badevent + "Red sleet is a rare phenomenon where appears red due to high levels of iron oxide or other minerals, potentially causing environmental and health concerns. Every 1 mintues a creature must make a DC 15 (+ 1 for every additional 10 mintues) or take 1d6 posion damage. Creatures with immunity always succeed. Every hour of being in clothing wet from this make make this save every hour, even if the strom has passed. reduces visibility to three-quarters of the normal range, resulting in a –2 penalty on Perception checks. Light snow has a 75% chance each hour of extinguishing unprotected flames and imposes a –2 penalty on ranged attacks. It does not impede movement unless it continues for 2 or more hours, at which point moving into a square of such requires 1 extra 5-foot square of movement (this stacks with difficult terrain). After 2 hours this is increased to 2 extra squares of movement.";
                                break;
                            }
                    }
                }else {
                    int d3bad4 = badweatherRand.nextInt(2 - 1 + 1) + 1;
                    switch (d3bad4){
                        case 1 : badevent = "## Black Blizzard\n";
                            badevent = badevent + "Emberstorms, known also as “black blizzards,” are powerful duststorms composed of ash and embers left behind by large brushfires. An emberstorm typically takes hours to pass. This one takes" + dice(2,4)  +" hours to pass. It occurs at " + dice(1,24) + " O'clock. These violent duststorms typically occur during summer months, when wildfires are more common. Winter emberstorms are seen as particularly bad omens but those that occur during the summer have become little more than an accepted way of life. The natural lay of the land shapes and funnels the path of an emberstorm to a certain extent, and knowledgeable tribes seek out lowlying areas like these out of habit. The edge of the storm assaults those it envelopes with strong winds of 30 mph. If the wind speed for the day is slower than 30 mph, it increases to 30 mph, but will not decrease to 30 mph if the wind is faster. Anyone within the storm’s edge suffers a –10 penalty on Perception checks as well as ranged attacks beyond ten feet. In addition, targets in the storm’s outer rim benefit and are considered heavily obscured ";
                            break;
                        case 2 : badevent = "## Wildfire\n";
                            badevent = badevent + """
                                    A wildfire can be spotted from as far away as 2d6 × 100 feet by a character who makes a Perception check, treating the fire as a Colossal creature (reducing the DC by 5). If all characters fail their Perception checks, the fire moves closer to them. They automatically see it when it closes to half the original distance. With proper elevation, the smoke from a wildfire can be spotted as far as 10 miles away. for simplitity forest and wildfires are treated the same.
                                    
                                    Characters who are blinded or otherwise unable to make Perception checks can feel the heat of the fire (and thus automatically “spot” it) when it is 100 feet away.
                                    
                                    The leading edge of a fire (the downwind side) can advance faster than a human can run (assume 120 feet per round for winds of moderate strength). Once a particular portion of the wildis ablaze, it remains so for 2d4 × 10 minutes before dying to a smoking wasteland. Characters overtaken by a wildfire might find the leading edge of the fire advancing away from them faster than they can keep up, trapping them deeper and deeper within its grasp.
                                    
                                    Within the bounds of a wildfire, a character faces three dangers: heat damage, catching on fire, and smoke inhalation.
                                    
                                    Heat Damage Getting caught within a wildfire is even worse than being exposed to extreme heat (see Heat Dangers). Breathing the air causes a character to take 1d6 points of fire damage per round (no save). In addition, a character must make a con save every 5 rounds (DC 15, +1 per previous check) or take 1d4 points of nonlethal damage. A character who holds his breath can avoid the lethal damage, but not the nonlethal damage. Those wearing heavy clothing or any sort of armor take a –4 penalty on their saving throws. Those wearing metal armor or who come into contact with very hot metal are affected as if by a heat metal spell.
                                    
                                    Catching on Fire Characters engulfed in a wildfire are at risk of catching on fire when the leading edge of the fire overtakes them, and continue to be at risk once per minute thereafter.
                                    
                                    Smoke Inhalation wildfires naturally produce a great deal of smoke. A character who breathes heavy smoke must make a Fortitude save each round (DC 15, +1 per previous check) or spend that round choking and coughing. A character who chokes for 2 consecutive rounds takes 1d6 points of nonlethal damage. Smoke also provides concealment to characters within it.
                                    
                                    ### Heat Danger
                                    Heat deals nonlethal damage that cannot be recovered from until the character gets cooled off (reaches shade, survives until nightfall, gets doused in water, is targeted by endure elements, and so forth). Once a character has taken an amount of nonlethal damage equal to her total hit points, any further damage from a hot environment is lethal damage.
                                    
                                    A character who takes any nonlethal damage from heat exposure now suffers from heatstroke and is fatigued. These penalties end when the character recovers from the nonlethal damage she took from the heat.
                                    
                                    Boiling water deals 1d6 points of scalding damage, unless the character is fully immersed, in which case it deals 10d6 points of damage per round of exposure.
                                    
                                    """;

                        break;

                    }
                }
            }
        }
        return badevent;
    }
}
