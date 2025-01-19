package commands;

import datahouse.japaneseFemaleNames;
import datahouse.japaneseLastName;
import datahouse.japaneseMaleNames;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class randomname extends ListenerAdapter {

    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(event.getName().equals("randomname")) {
            ArrayList<String> firstNameFirstSyllable = new ArrayList<>();
            ArrayList<String> randomSyllablesForLastName = new ArrayList<>();
            datahouse.japaneseMaleNames japaneseMaleNames = new japaneseMaleNames();
            datahouse.japaneseFemaleNames japaneseFemaleNames = new japaneseFemaleNames();
            datahouse.japaneseLastName japaneseLastName = new japaneseLastName();
            Random randomnumber = new Random();
            Random randomNumberWesternFirstName = new Random();
            ArrayList<String> randomSyllablesForFirstName = new ArrayList<>();
            Random randomNumberWesternLastName = new Random();

            int firstNameTimes = randomNumberWesternFirstName.nextInt(2 - 1 + 1) + 1;
            int lastNameTimes = randomNumberWesternLastName.nextInt(3 - 1 + 1) + 1;
            int suffixchance = randomnumber.nextInt(100 - 1 + 1) + 1;
            int titlechacne = randomnumber.nextInt(100 - 1 + 1) + 1;
            String FullfirstName = "";
            String FulllastName = "";
            String firstName = firstNameSyllable();
            String lastName = lastNameFirstSyllable();
            String mainotherSyllable = "";
            String suff = "";
            String namesplit = firstName;
            String namesplitlast = lastName;
            String messageText = "";
            String sex = "";

            final OptionMapping nameStyleMapping = event.getOption("namestyle");
            final String styleinput = nameStyleMapping == null ? nameStyles() : nameStyleMapping.getAsString();
            // if nameStyleMapping is null then ? is done, if it is false then the : is done.
            switch (styleinput) {
                case "western":

                    for (int i = 0; i < firstNameTimes; i++) {
                        mainotherSyllable = randomSyllableForFirstName();

                        if (!randomSyllablesForFirstName.contains(mainotherSyllable)) { //!mainotherSyllable.equals(randomSyllableForFirstName())
                            firstName = firstName + mainotherSyllable;
                            namesplit = namesplit + " - " + mainotherSyllable;
                            randomSyllablesForFirstName.add(mainotherSyllable);
                        } else {
                            i = i - 1;
                        }
                    }
                    FullfirstName = firstName + suff;

                    if (suffixchance >= 51) {
                        suff = nameSuffix(suffixchance, sex(firstName));
                        char first = suff.charAt(0);
                        FullfirstName = firstName + suff;

                        if (" II".equals(suff) || " III".equals(suff) || " IV".equals(suff) || " V".equals(suff) || " VI".equals(suff) || " VII".equals(suff) || " VIII".equals(suff) || " XI".equals(suff) || " X".equals(suff)) {
                            //written like this beacuse inverting it caused bugs
                        } else {
                            if (Character.toString(first).equals(" ")) {
                                namesplit = namesplit + " - " + removeSpaceIfFirstChar(suff);
                            }
                            if (!Character.toString(first).equals(" ")) {
                                namesplit = namesplit + " - " + suff;
                            }
                        }

                        FullfirstName = FullfirstName + " (" + namesplit + ")"; //set with suffix

                    } else {
                        FullfirstName = FullfirstName + " (" + namesplit + ")"; //in case of no suffix
                    }

                    for (int l = 0; l < lastNameTimes; l++) {
                        mainotherSyllable = randomSyllableForLastName();

                        if (!randomSyllablesForLastName.contains(mainotherSyllable)) { //!mainotherSyllable.equals(randomSyllableForFirstName())
                            lastName = lastName + mainotherSyllable;
                            namesplitlast = namesplitlast + " - " + mainotherSyllable;
                            randomSyllablesForLastName.add(mainotherSyllable);
                        } else {
                            l = l - 1;
                        }

                    }
                    FulllastName = lastName + " (" + namesplitlast + ")";
                    sex = sex(firstName);

                    if (suff.contains("ó")) {
                        FulllastName = "Like an exacterated \"Oh\" followed by a ch.";
                    }
                    if (suff.contains("ović")) {
                        FulllastName = "ć makes a ch sound Oh-vee-ch";
                    }
                    if (suff.contains("ić")) {
                        FulllastName = "ić sounds like \"each\" ";
                    }

                    if (titlechacne == 100) {
                        messageText = "First Name: " + FullfirstName + ", " + title() + "\n" + "Last Name: " + FulllastName;
                    } else {
                        messageText = "First Name: " + FullfirstName + "\n" + "Last Name: " + FulllastName + "\n";
                    }
                    event.reply(messageText).queue();

                    break;
                case "eastern":
                    sex = foreignSex();
                    if (sex.equals("Male")) {
                        FullfirstName = japaneseMaleNames.getRandomJapaneseMaleName();
                    } else {
                        FullfirstName = japaneseFemaleNames.getRandomJapaneseFemaleName();
                    }
                    FulllastName = japaneseLastName.getRandomJapaneseLastName();
                    //https://ttsmp3.com/text-to-speech/Japanese/
                    if (titlechacne == 100) {
                        messageText = "First Name:\n" + FullfirstName + ", " + title() + "\n" + "Last Name:\n" + FulllastName + "\n";
                    } else {
                        messageText = "First Name:\n" + FullfirstName + "\n" + "Last Name:\n" + FulllastName;
                    }
                    event.reply(messageText + "\nCan show you how to say the name: https://ttsmp3.com/text-to-speech/Japanese/").queue();

                    break;
            }
        }

    }
    public static int Randomizer(int max, int min){
        Random randomnum = new Random();
        int randomnumber = randomnum.nextInt((max -min) + 1) + min;

        return randomnumber;
    }
    public static String nameStyles(){
        String style = "";
        Random randomstyle = new Random();
        int randomstylenumber = randomstyle.nextInt(2 -1 +1) +1;
        switch (randomstylenumber){
            case 1 -> style = "western";
            case 2 -> style = "eastern";
            default -> style = "western";
        }
        return style;
    }
    public static String removeSpaceIfFirstChar(String spaceSuffix){

        int n = spaceSuffix.length();

        String removedSpaceSuffix = "";
        for (int j = 1; j < n; j++) {
            removedSpaceSuffix = removedSpaceSuffix + spaceSuffix.charAt(j);
        }
        return removedSpaceSuffix;
    }
    public static String firstNameSyllable(){

        Random randomnumber = new Random();
        ArrayList<String> firstNameSyllable = new ArrayList<>();
        firstNameSyllable.add("Ab");
        firstNameSyllable.add("Ad");
        firstNameSyllable.add("Aeron");
        firstNameSyllable.add("Ail");
        firstNameSyllable.add("Ais");
        firstNameSyllable.add("Ala");
        firstNameSyllable.add("Alb");
        firstNameSyllable.add("Am");
        firstNameSyllable.add("Ana");
        firstNameSyllable.add("Arian");
        firstNameSyllable.add("Ar");
        firstNameSyllable.add("Ast");
        firstNameSyllable.add("Az");
        firstNameSyllable.add("Ba");
        firstNameSyllable.add("Bel");
        firstNameSyllable.add("Bran");
        firstNameSyllable.add("Bri");
        firstNameSyllable.add("Cal");
        firstNameSyllable.add("Cam");
        firstNameSyllable.add("Cer");
        firstNameSyllable.add("Clari");
        firstNameSyllable.add("Cor");
        firstNameSyllable.add("Da");
        firstNameSyllable.add("Dari");
        firstNameSyllable.add("Der");
        firstNameSyllable.add("Dom");
        firstNameSyllable.add("Er");
        firstNameSyllable.add("El");
        firstNameSyllable.add("Eva");
        firstNameSyllable.add("Fere");
        firstNameSyllable.add("Fro");
        firstNameSyllable.add("Gala");
        firstNameSyllable.add("Guin");
        firstNameSyllable.add("Gwen");
        firstNameSyllable.add("Hec");
        firstNameSyllable.add("Hes");
        firstNameSyllable.add("Io");
        firstNameSyllable.add("Is");
        firstNameSyllable.add("Iz");
        firstNameSyllable.add("Jo");
        firstNameSyllable.add("Khio");
        firstNameSyllable.add("Lav");
        firstNameSyllable.add("Lio");
        firstNameSyllable.add("Lor");
        firstNameSyllable.add("Low");
        firstNameSyllable.add("Luc");
        firstNameSyllable.add("Mel");
        firstNameSyllable.add("Mer");
        firstNameSyllable.add("Miri");
        firstNameSyllable.add("Morg");
        firstNameSyllable.add("Ober");
        firstNameSyllable.add("Ol");
        firstNameSyllable.add("Or");
        firstNameSyllable.add("Per");
        firstNameSyllable.add("Rev");
        firstNameSyllable.add("Ro");
        firstNameSyllable.add("Sen");
        firstNameSyllable.add("Silv");
        firstNameSyllable.add("Sono");
        firstNameSyllable.add("Tari");
        firstNameSyllable.add("Vivi");
        firstNameSyllable.add("Zel");
        //                                        nextInt(max - min + 1) + min
        return firstNameSyllable.get(randomnumber.nextInt(firstNameSyllable.size())); // +1 is for exculsive on upper bound
    }
    public static String randomSyllableForFirstName(){
        String otherSyllable = "";
        Random otherrandomnumber = new Random();
        ArrayList<String> randomSyllableForFirstName = new ArrayList<>();
        randomSyllableForFirstName.add("mon");
        randomSyllableForFirstName.add("fay");
        randomSyllableForFirstName.add("shi");
        randomSyllableForFirstName.add("zag");
        randomSyllableForFirstName.add("rash");
        randomSyllableForFirstName.add("izen");
        randomSyllableForFirstName.add("axas");
        randomSyllableForFirstName.add("ara");
        randomSyllableForFirstName.add("anna");
        randomSyllableForFirstName.add("trion");
        randomSyllableForFirstName.add("tal");
        randomSyllableForFirstName.add("aris");
        randomSyllableForFirstName.add("reas");
        randomSyllableForFirstName.add("ella");
        randomSyllableForFirstName.add("anell");
        randomSyllableForFirstName.add("tem");
        randomSyllableForFirstName.add("cella");
        randomSyllableForFirstName.add("eria");
        randomSyllableForFirstName.add("oria");
        randomSyllableForFirstName.add("aia");
        randomSyllableForFirstName.add("eron");
        randomSyllableForFirstName.add("eera");
        randomSyllableForFirstName.add("ere");
        randomSyllableForFirstName.add("onna");
        randomSyllableForFirstName.add("fleur");
        randomSyllableForFirstName.add("ona");
        randomSyllableForFirstName.add("doc");
        randomSyllableForFirstName.add("mond");
        randomSyllableForFirstName.add("bin");
        randomSyllableForFirstName.add("eri");

        int max = randomSyllableForFirstName.size();

        otherSyllable =  randomSyllableForFirstName.get(otherrandomnumber.nextInt(max));

        return otherSyllable;
    }
    public static String sex(String firstName){
        String sex = "";
        switch(firstName.substring(firstName.length() - 3)){
            case "mon" -> sex = "Male";
            case "fay" -> sex = "Female";
            case "shi" -> sex = "Female";
            case "zag" -> sex = "Male";
            case "ash" -> sex = "Male";
            case "zen" -> sex = "Male";
            case "xas" -> sex = "Male";
            case "ara" -> sex = "Female";
            case "nna" -> sex = "Female";
            case "ion" -> sex = "Male";
            case "tal" -> sex = "Male";
            case "ris" -> sex = "Male";
            case "eas" -> sex = "Male";
            case "lla" -> sex = "Female";
            case "ell" -> sex = "Female";
            case "tem" -> sex = "Male";
            case "ria" -> sex = "Female";
            case "aia" -> sex = "Female";
            case "ron" -> sex = "Male";
            case "era" -> sex = "Female";
            case "ere" -> sex = "Male";
            case "eur" -> sex = "Male";
            case "ona" -> sex = "Female";
            case "doc" -> sex = "Male";
            case "ond" -> sex = "Female";
            case "bin" -> sex = "Male";
            case "eri" -> sex = "Female";
            default ->    sex = "Neutral";
        }

        return sex;
    }
    public static String nameSuffix(int suffixchance, String sex){
        String suffix = "";
        String sufsex = sex;
        int suf = 0;

        Random suffixran = new Random();
        if(sufsex.equals("Male")){suf = suffixran.nextInt(20 -1 +1) +1;}
        if(sufsex.equals("Female")){suf = suffixran.nextInt(13 -1 +1) +1;}

        switch(sufsex){
            case "Male":
                if(suffixchance >= 0){
                    switch(suf){
                        case 1  -> suffix = "son";
                        case 2  -> suffix = "li";
                        case 3  -> suffix = "ssen";
                        case 4  -> suffix = " Jr.";
                        case 5  -> suffix = " Sr.";
                        case 6  -> suffix = " II";
                        case 7  -> suffix = " III";
                        case 8  -> suffix = " IV";
                        case 9  -> suffix = " V";
                        case 10 -> suffix = " VI";
                        case 11 -> suffix = " VII";
                        case 12 -> suffix = " VIII";
                        case 13 -> suffix = " IX";
                        case 14 -> suffix = " X";
                        case 15 -> suffix = " père";
                        case 16 -> suffix = " fils";
                        case 17 -> suffix = " Le jeune";
                        case 18 -> suffix = "óg";  //Like an exacterated "Oh" followed by a ch.
                        case 19 -> suffix = "ović";  //makes a ch sound Oh-vee-ch
                        case 20 -> suffix = "ić";   // sounds like "each"
                    }
                }
                break;
            //I cant find that many female endings for a name
            case "Female":
                if(suffixchance >= 0){
                    switch(suf){
                        case 1  -> suffix = "kor";
                        case 2  -> suffix = " II";
                        case 3  -> suffix = " III";
                        case 4  -> suffix = " IV";
                        case 5  -> suffix = " V";
                        case 6  -> suffix = " VI";
                        case 7  -> suffix = " VII";
                        case 8 -> suffix = " VIII";
                        case 9 -> suffix = " IX";
                        case 10 -> suffix = " X";
                        case 11 -> suffix = " Le jeune";
                        case 12 -> suffix = "óg";  //Like an exacterated "Oh" followed by a ch.
                        case 13 -> suffix = "dottir";
                    }
                    break;
                }
            default: suffix = " óg ";
        }

        return suffix;
    }
    public static String lastNameFirstSyllable(){

        Random randomnumberlastname = new Random();
        ArrayList<String> lastNameSyllable = new ArrayList<>();
        lastNameSyllable.add("At");
        lastNameSyllable.add("Ag");
        lastNameSyllable.add("Ap");
        lastNameSyllable.add("Ak");
        lastNameSyllable.add("Av");
        lastNameSyllable.add("Arr");
        lastNameSyllable.add("Al");
        lastNameSyllable.add("Am");
        lastNameSyllable.add("An");
        lastNameSyllable.add("Ash");
        lastNameSyllable.add("Hum");
        lastNameSyllable.add("Arm");
        lastNameSyllable.add("Ao");
        lastNameSyllable.add("Ap");
        lastNameSyllable.add("De");
        lastNameSyllable.add("Da");
        lastNameSyllable.add("Dr");
        lastNameSyllable.add("Dan");
        lastNameSyllable.add("Des");
        lastNameSyllable.add("Dun");
        lastNameSyllable.add("Bot");
        lastNameSyllable.add("Ben");
        lastNameSyllable.add("Benn");
        lastNameSyllable.add("Bozz");
        lastNameSyllable.add("Ever");
        lastNameSyllable.add("East");
        lastNameSyllable.add("West");
        lastNameSyllable.add("North");
        lastNameSyllable.add("South");
        lastNameSyllable.add("Eno");
        lastNameSyllable.add("Oct");
        lastNameSyllable.add("Gr");
        lastNameSyllable.add("Ha");
        lastNameSyllable.add("Xan");
        lastNameSyllable.add("Cold");
        lastNameSyllable.add("Yan");
        lastNameSyllable.add("Yae");
        lastNameSyllable.add("Wo");
        lastNameSyllable.add("Sor");
        lastNameSyllable.add("Sax");
        lastNameSyllable.add("Mal");
        lastNameSyllable.add("Man");
        lastNameSyllable.add("Min");
        lastNameSyllable.add("Moro");
        //                                        nextInt(max - min + 1) + min // +1 is for exculsive on upper bound
        return lastNameSyllable.get(randomnumberlastname.nextInt(lastNameSyllable.size()));
    }
    public static String randomSyllableForLastName(){

        Random randomnumberlastname = new Random();
        ArrayList<String> randomSyllableForLastName = new ArrayList<>();
        randomSyllableForLastName.add("at");
        randomSyllableForLastName.add("ow");
        randomSyllableForLastName.add("ga");
        randomSyllableForLastName.add("wa");
        randomSyllableForLastName.add("scu");
        randomSyllableForLastName.add("mas");
        randomSyllableForLastName.add("ka");
        randomSyllableForLastName.add("drich");
        randomSyllableForLastName.add("sal");
        randomSyllableForLastName.add("pak");
        randomSyllableForLastName.add("man");
        randomSyllableForLastName.add("mann");
        randomSyllableForLastName.add("ber");
        randomSyllableForLastName.add("nel");
        randomSyllableForLastName.add("sa");
        randomSyllableForLastName.add("sol");
        randomSyllableForLastName.add("shaw");
        randomSyllableForLastName.add("ler");
        randomSyllableForLastName.add("bay");
        randomSyllableForLastName.add("er");
        randomSyllableForLastName.add("am");
        randomSyllableForLastName.add("in");
        randomSyllableForLastName.add("xen");
        randomSyllableForLastName.add("galt");
        randomSyllableForLastName.add("car");
        randomSyllableForLastName.add("anda");
        randomSyllableForLastName.add("ger");
        randomSyllableForLastName.add("dard");
        randomSyllableForLastName.add("ba");
        randomSyllableForLastName.add("ko");
        randomSyllableForLastName.add("intz");
        //                                        nextInt(max - min + 1) + min // +1 is for exculsive on upper bound
        return randomSyllableForLastName.get(randomnumberlastname.nextInt(randomSyllableForLastName.size()));
    }
    public static String title(){
        Random randomnumbertitle = new Random();
        ArrayList<String> titleArray = new ArrayList<>();
        titleArray.add("The light bringer");
        titleArray.add("Harbinger of darkness");
        titleArray.add("Sword Saint");
        titleArray.add("Witch of Envy");
        titleArray.add("Platinum Witch");
        titleArray.add("Sword Demon");
        titleArray.add("Guthunter");
        titleArray.add("Who Comes With the Dawn");
        titleArray.add("Prince of the Dawn");
        titleArray.add("True Defender of the Light");
        titleArray.add("Caesar of Unity");
        titleArray.add("Matriarch of Emissaries");
        titleArray.add("Protector of the Moon");
        titleArray.add("Admiral of Fools");
        titleArray.add("Mouthpiece of the gods");
        titleArray.add("Steward of Death");
        titleArray.add("Deserter");
        titleArray.add("The Defiled");
        titleArray.add("Keeper of secrets");
        titleArray.add("Bane of Monsters");
        titleArray.add("The Undertaker");
        titleArray.add("The Renegade");
        titleArray.add("The Liberator");
        titleArray.add("Beast Speaker");
        titleArray.add("The faithful");
        titleArray.add("Votaries");
        titleArray.add("Envoy of Ghosts");
        titleArray.add("Archmage");
        titleArray.add("The Cultivator");
        titleArray.add("Carrier of Justice");
        titleArray.add("The Cursed");
        titleArray.add("Helmsmasher");
        titleArray.add("Breaker of Chains");
        titleArray.add("The Fearless");
        titleArray.add("Master Sleuth");
        titleArray.add("The Dishonorable");
        titleArray.add("The Uniter");

        return titleArray.get(randomnumbertitle.nextInt(titleArray.size()));
    }
    //https://github.com/moznion/gimei-java
    //https://github.com/moznion/gimei-java/commit/4ab81b7e4e8b0bd285e5c0a9e1f59d715af0852b
    public static String foreignSex(){
        String sex = "";
        Random ransex = new Random();
        int sexodds = ransex.nextInt(2-1+1)+1;
        switch (sexodds){
            case 1 ->  sex = "Female";
            case 2 ->  sex = "Male";
            default -> sex = "Female";
        }
        //some languages don't really have neutral so its excluded
        return sex;
    }
}
