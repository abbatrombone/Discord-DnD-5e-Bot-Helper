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

public class npc extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(event.getName().equals("npc")) {
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
            String ideal = Ideal(Randomizer(90, 1));
            String bond = Bond(Randomizer(122, 1));
            String flaw = Flaw(Randomizer(135, 1));
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
                        messageText = "First Name: " + FullfirstName + ", " + title() + "\n" + "Last Name: " + FulllastName + "\n" + "Sex: " + sex + "\nAlignment: " + LawAlignment(ideal) + "," + goodAlignment(Randomizer(3, 1)) + "\nJob: " + vocation() + "\nPersonailty: " + Personailty(Randomizer(120, 1)) + "\nIdeal: " + ideal + "\nBond: " + bond + "\nFlaw: " + flaw;
                    } else {
                        messageText = "First Name: " + FullfirstName + "\n" + "Last Name: " + FulllastName + "\n" + "Sex: " + sex + "\nAlignment: " + LawAlignment(ideal) + "," + goodAlignment(Randomizer(3, 1)) + "\nJob: " + vocation() + "\nPersonailty: " + Personailty(Randomizer(120, 1)) + "\nIdeal: " + ideal + "\nBond: " + bond + "\nFlaw: " + flaw;
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
                        messageText = "First Name:\n" + FullfirstName + ", " + title() + "\n" + "Last Name:\n" + FulllastName + "\n" + "Sex: " + sex + "\nAlignment: " + LawAlignment(ideal) + "," + goodAlignment(Randomizer(3, 1)) + "\nJob: " + vocation() + "\nPersonailty: " + Personailty(Randomizer(120, 1)) + "\nIdeal: " + ideal + "\nBond: " + bond + "\nFlaw: " + flaw;
                    } else {
                        messageText = "First Name:\n" + FullfirstName + "\n" + "Last Name:\n" + FulllastName + "\n" + "Sex: " + sex + "\nAlignment: " + LawAlignment(ideal) + "," + goodAlignment(Randomizer(3, 1)) + "\nJob: " + vocation() + "\nPersonailty: " + Personailty(Randomizer(120, 1)) + "\nIdeal: " + ideal + "\nBond: " + bond + "\nFlaw: " + flaw;
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
    public static String westernFirstName(){
        Random randomNumberWesternFirstName = new Random();
        ArrayList<String> randomSyllablesForFirstName = new ArrayList<>();

        int firstNameTimes = randomNumberWesternFirstName.nextInt(2 -1 +1) + 1;
        String mainotherSyllable = "";
        String firstName = firstNameSyllable();
        String namesplit = firstName;

        for (int i = 0; i < firstNameTimes; i++) {
            mainotherSyllable = randomSyllableForFirstName();

            if(!randomSyllablesForFirstName.contains(mainotherSyllable)){ //!mainotherSyllable.equals(randomSyllableForFirstName())
                firstName = firstName + mainotherSyllable;
                namesplit = namesplit + " - " + mainotherSyllable;
                randomSyllablesForFirstName.add(mainotherSyllable);
            }else{
                i = i -1;
            }

        }

        return firstName + " (" + namesplit + ")";
    }
    public static String westernLastName(){
        Random randomNumberWesternLastName = new Random();
        ArrayList<String> randomSyllablesForLastName = new ArrayList<>();

        int lastNameTimes = randomNumberWesternLastName.nextInt(3 -1 +1) + 1;
        String mainotherSyllable = "";
        String lastName = lastNameFirstSyllable();
        String namesplitlast = lastName;

        for (int l = 0; l < lastNameTimes; l++) {
            mainotherSyllable = randomSyllableForLastName();

            if(!randomSyllablesForLastName.contains(mainotherSyllable)){ //!mainotherSyllable.equals(randomSyllableForFirstName())
                lastName = lastName + mainotherSyllable;
                namesplitlast = namesplitlast + " - " + mainotherSyllable;
                randomSyllablesForLastName.add(mainotherSyllable);
            }else{
                l = l -1;
            }

        }
        return lastName + " (" + namesplitlast + ")";
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
    public static String vocation(){
        Random randomnumbervocation = new Random();
        ArrayList<String> vocationArray = new ArrayList<>();
        vocationArray.add("Logothete");
        vocationArray.add("Peacemaker");
        vocationArray.add("Seneschal");
        vocationArray.add("Majordomo");
        vocationArray.add("Caraveeners");
        vocationArray.add("Guildsmen");
        vocationArray.add("Practitioner");
        vocationArray.add("Blacksmith");
        vocationArray.add("Chef");
        vocationArray.add("Enchanter");
        vocationArray.add("Beekeeper");
        vocationArray.add("Low Diplomat");
        vocationArray.add("Curse Breaker");
        vocationArray.add("Papermaker");
        vocationArray.add("Historian of magic");
        vocationArray.add("Wandmaker");
        vocationArray.add("Plague Doctor");
        vocationArray.add("Botanist");
        vocationArray.add("Falconer");
        vocationArray.add("Potion Sommelier");
        vocationArray.add("Poison Taster");
        vocationArray.add("Apothecary");
        vocationArray.add("Jester");
        vocationArray.add("Astrologer");
        vocationArray.add("Charm Maker");
        vocationArray.add("Silversmith");
        vocationArray.add("Crystal Miner");
        vocationArray.add("Magic Clockmaker");
        vocationArray.add("Horticulturist");
        vocationArray.add("Cryptographer");
        vocationArray.add("Star Catcher");
        vocationArray.add("Trapper");
        vocationArray.add("Mermaid Fisher");
        vocationArray.add("Jailer");
        vocationArray.add("Scrivener");
        vocationArray.add("Selkie Seamstress");
        vocationArray.add("Gravedigger");
        vocationArray.add("Demonologist");
        vocationArray.add("Butler to Faeries");
        vocationArray.add("Glassblower");
        vocationArray.add("Alchemy Professor");
        vocationArray.add("Royal Enchanter");
        vocationArray.add("Almoner");
        vocationArray.add("Debt Collector");
        vocationArray.add("Arrow Maker");
        vocationArray.add("Gallowglass");
        vocationArray.add("Bone Carver");
        vocationArray.add("Inquisitor");
        vocationArray.add("Serpent Charmer");
        vocationArray.add("Butcher");
        vocationArray.add("Breaker");
        vocationArray.add("Stone Mason");
        vocationArray.add("Weaver");
        vocationArray.add("Fisherman");
        vocationArray.add("Farmer");
        vocationArray.add("Cobbler");
        vocationArray.add("Wheelwright");
        vocationArray.add("Locksmith");
        vocationArray.add("Tanner");
        vocationArray.add("Merchant");
        vocationArray.add("Servant");
        vocationArray.add("Goldsmith");
        vocationArray.add("Dyer");
        vocationArray.add("Tailor");
        vocationArray.add("Soldier");
        vocationArray.add("Tinsmith");
        vocationArray.add("Coachman");
        vocationArray.add("Woodcutter");
        vocationArray.add("Painter");
        vocationArray.add("Miller");
        vocationArray.add("Acolyte");
        vocationArray.add("Anthropologist");
        vocationArray.add("Archaeologist");
        vocationArray.add("Athlete");
        vocationArray.add("Charlatan");
        vocationArray.add("City Watch");
        vocationArray.add("Clan Crafter");
        vocationArray.add("Cloistered Scholar");
        vocationArray.add("Courtier");
        vocationArray.add("Entertainer");
        vocationArray.add("Gladiator");
        vocationArray.add("Guild Artisan");
        vocationArray.add("Guild Merchant");
        vocationArray.add("Investigator");
        vocationArray.add("Knight");
        vocationArray.add("Marine");
        vocationArray.add("Mercenary Veteran");
        vocationArray.add("Noble");
        vocationArray.add("Outlander");
        vocationArray.add("Pirate");
        vocationArray.add("Rune Carver");
        vocationArray.add("Sage");
        vocationArray.add("Sailor");
        vocationArray.add("Shipwright");
        vocationArray.add("Smuggler");
        vocationArray.add("Spy");
        vocationArray.add("Urban Bounty Hunter");
        vocationArray.add("Bounty Hunter");

        return vocationArray.get(randomnumbervocation.nextInt(vocationArray.size()));
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
    public static String Personailty(int randomnumber){
        String personailty = "";
        switch (randomnumber){
            case 1 -> personailty = "I idolize a particular hero of my faith, and constantly refer to that person's deeds and example.";
            case 2 -> personailty = "I can find common ground between the fiercest enemies, empathizing with them and always working toward peace.";
            case 3 -> personailty = "I see omens in every event and action. The gods try to speak to us, we just need to listen.";
            case 4 -> personailty = "Nothing can shake my optimistic attitude.";
            case 5 -> personailty = "I quote (or misquote) sacred texts and proverbs in almost every situation.";
            case 6 -> personailty = "I am tolerant (or intolerant) of other faiths and respect (or condemn) the worship of other gods.";
            case 7 -> personailty = "I've enjoyed fine food, drink, and high society among my temple's elite. Rough living grates on me.";
            case 8 -> personailty = "I've spent so long in the temple that I have little practical experience dealing with people in the outside world.";
            case 9 -> personailty = "I prefer the company of those who aren't like me, including people of other races.";
            case 10 -> personailty = "I'm a stickler when it comes to observing proper etiquette and local customs.";
            case 11 -> personailty = "I would rather observe than meddle.";
            case 12 -> personailty = "By living among violent people, I have become desensitized to violence.";
            case 23 -> personailty = "I would risk life and limb to discover a new culture or unravel the secrets of a dead one.";
            case 24 -> personailty = "When I arrive at a new settlement for the first time, I must learn all its customs.";
            case 25 -> personailty = "I love a good puzzle or mystery.";
            case 26 -> personailty = "I'm a pack rat who never throws anything away.";
            case 27 -> personailty = "Fame is more important to me than money.";
            case 28 -> personailty = "I have no qualms about stealing from the dead.";
            case 29 -> personailty = "I'm happier in a dusty old tomb than I am in the centers of civilization.";
            case 30 -> personailty = "Traps don't make me nervous. Idiots who trigger traps make me nervous.";
            case 31 -> personailty = "I might fail, but I will never give up.";
            case 32 -> personailty = "You might think I'm a scholar, but I love a good brawl. These fists were made for punching.";
            case 33 -> personailty = "I feel most at peace during physical exertion, whether exercise or battle.";
            case 34 -> personailty = "I don't like to sit idle.";
            case 35 -> personailty = "I have a daily exercise routine I refuse to break.";
            case 36 -> personailty = "Obstacles exist to be overcome.";
            case 37 -> personailty = "When I see others struggling, I offer to help.";
            case 38 -> personailty = "I love to trade banter and gibes.";
            case 39 -> personailty = "Anything worth doing is worth doing best.";
            case 40 -> personailty = "I get irritated if people praise someone else and not me.";
            case 41 -> personailty = "I fall in and out of love easily, and am always pursuing someone.";
            case 42 -> personailty = "I have a joke for every occasion, especially occasions where humor is inappropriate.";
            case 43 -> personailty = "Flattery is my preferred trick for getting what I want.";
            case 44 -> personailty = "I'm a born gambler who can't resist taking a risk for a potential payoff.";
            case 45 -> personailty = "I lie about almost everything, even when there's no good reason to.";
            case 46 -> personailty = "Sarcasm and insults are my weapons of choice.";
            case 47 -> personailty = "I keep multiple holy symbols on me and invoke whatever deity might come in useful at any given moment.";
            case 48 -> personailty = "I pocket anything I see that might have some value.";
            case 49 -> personailty = "I always have a plan for what to do when things go wrong.";
            case 50 -> personailty = "I am always calm, no matter what the situation. I never raise my voice or let my emotions control me.";
            case 51 -> personailty = "The first thing I do in a new place is note the locations of everything valuable – or where such things could be hidden.";
            case 52 -> personailty = "I would rather make a new friend than a new enemy.";
            case 53 -> personailty = "I am incredibly slow to trust. Those who seem the fairest often have the most to hide.";
            case 54 -> personailty = "I don't pay attention to the risks in a situation. Never tell me the odds.";
            case 55 -> personailty = "The best way to get me to do something is to tell me I can't do it.";
            case 56 -> personailty = "I blow up at the slightest insult.";
            case 57 -> personailty = "I know a story relevant to almost every situation.";
            case 58 -> personailty = "Whenever I come to a new place, I collect local rumors and spread gossip.";
            case 59 -> personailty = "I'm a hopeless romantic, always searching for that \"special someone.\"";
            case 60 -> personailty = "Nobody stays angry at me or around me for long, since I can defuse any amount of tension.";
            case 61 -> personailty = "I love a good insult, even one directed at me.";
            case 62 -> personailty = "I get bitter if I'm not the center of attention.";
            case 63 -> personailty = "I'll settle for nothing less than perfection.";
            case 64 -> personailty = "I change my mood or my mind as quickly as I change key in a song.";
            case 65 -> personailty = "I'm haunted by fey laughter that only I can hear, though I know it's just my mind playing tricks on me.";
            case 66 -> personailty = "Like a nomad, I can't settle down in one place for very long.";
            case 67 -> personailty = "Good music makes me weep like a baby.";
            case 68 -> personailty = "Wherever I go, I try to bring a little of the warmth and tranquility of home with me.";
            case 69 -> personailty = "I have never lost my childlike sense of wonder.";
            case 70 -> personailty = "When I have a new idea, I get wildly excited about it until I come up with another, better idea.";
            case 71 -> personailty = "I live by my own set of weird and wonderful rules.";
            case 72 -> personailty = "I can't bring myself to trust most adults.";
            case 73 -> personailty = "I've been isolated for so long that I rarely speak, preferring gestures and the occasional grunt.";
            case 74 -> personailty = "I am utterly serene, even in the face of disaster.";
            case 75 -> personailty = "The leader of my community had something wise to say on every topic, and I am eager to share that wisdom.";
            case 76 -> personailty = "I feel tremendous empathy for all who suffer.";
            case 77 -> personailty = "I'm oblivious to etiquette and social expectations.";
            case 78 -> personailty = "I connect everything that happens to me to a grand, cosmic plan.";
            case 79 -> personailty = "I often get lost in my own thoughts and contemplation, becoming oblivious to my surroundings.";
            case 80 -> personailty = "I am working on a grand philosophical theory and love sharing my ideas.";
            case 81 -> personailty = "My eloquent flattery makes everyone I talk to feel like the most wonderful and important person in the world.";
            case 82 -> personailty = "The common folk love me for my kindness and generosity.";
            case 83 -> personailty = "No one could doubt by looking at my regal bearing that I am a cut above the unwashed masses.";
            case 84 -> personailty = "I take great pains to always look my best and follow the latest fashions.";
            case 85 -> personailty = "I don't like to get my hands dirty, and I won't be caught dead in unsuitable accommodations.";
            case 86 -> personailty = "Despite my noble birth, I do not place myself above other folk. We all have the same blood.";
            case 87 -> personailty = "My favor, once lost, is lost forever.";
            case 88 -> personailty = "If you do me an injury, I will crush you, ruin your name, and salt your fields.";
            case 89 -> personailty = "My eloquent flattery makes everyone I talk to feel like the most wonderful and important person in the world.";
            case 90 -> personailty = "The common folk love me for my kindness and generosity.";
            case 91 -> personailty = "No one could doubt by looking at my regal bearing that I am a cut above the unwashed masses.";
            case 92 -> personailty = "I take great pains to always look my best and follow the latest fashions.";
            case 93 -> personailty = "I don't like to get my hands dirty, and I won't be caught dead in unsuitable accommodations.";
            case 94 -> personailty = "Despite my noble birth, I do not place myself above other folk. We all have the same blood.";
            case 95 -> personailty = "My favor, once lost, is lost forever.";
            case 96 -> personailty = "If you do me an injury, I will crush you, ruin your name, and salt your fields.";
            case 97 -> personailty = "I use polysyllabic words that convey the impression of great erudition.";
            case 98 -> personailty = "I've read every book in the world's greatest libraries – or I like to boast that I have.";
            case 99 -> personailty = "I'm used to helping out those who aren't as smart as I am, and I patiently explain anything and everything to others.";
            case 100 -> personailty = "There's nothing I like more than a good mystery.";
            case 101 -> personailty = "I'm willing to listen to every side of an argument before I make my own judgment.";
            case 102 -> personailty = "I… speak… slowly… when talking… to idiots,… which… almost… everyone… is… compared… to me.";
            case 103 -> personailty = "I am horribly, horribly awkward in social situations.";
            case 104 -> personailty = "I'm convinced that people are always trying to steal my secrets.";
            case 105 -> personailty = "I speak rarely but mean every word I say.";
            case 106 -> personailty = "I laugh loudly and see the humor in stressful situations.";
            case 107 -> personailty = "I prefer to solve problems without violence, but I finish fights decisively.";
            case 108 -> personailty = "I enjoy being out in nature; poor weather never sours my mood.";
            case 109 -> personailty = "I am dependable.";
            case 110 -> personailty = "I am always working on some project or other.";
            case 111 -> personailty = "I become cantankerous and quiet in the rain.";
            case 112 -> personailty = "When the sea is within my sight, my mood is jovial and optimistic.";
            case 113 -> personailty = "I love being on the water but hate fishing.";
            case 114 -> personailty = "I think of everything in terms of monetary value.";
            case 115 -> personailty = "I never stop smiling.";
            case 116 -> personailty = "Nothing rattles me; I have a lie for every occasion.";
            case 117 -> personailty = "I love gold but won't cheat a friend.";
            case 118 -> personailty = "I enjoy doing things others believe to be impossible.";
            case 119 -> personailty = "I become wistful when I see the sun rise over the ocean.";
            case 120 -> personailty = "I am no common criminal; I am a mastermind.";
        }

        return personailty;
    }
    public static String Ideal(int idealrandomnumber){
        String ideal = "";

        switch(idealrandomnumber){
            case 1  -> ideal =	"Tradition. The ancient traditions of worship and sacrifice must be preserved and upheld.";
            case 2  -> ideal =	"Charity. I always try to help those in need, no matter what the personal cost.";
            case 3  -> ideal =	"Change. We must help bring about the changes the gods are constantly working in the world.";
            case 4  -> ideal =	"Power. I hope to one day rise to the top of my faith's religious hierarchy.";
            case 5  -> ideal =	"Faith. I trust that my deity will guide my actions. I have faith that if I work hard, things will go well.";
            case 6  -> ideal =	"Aspiration. I seek to prove myself worthy of my god's favor by matching my actions against their teachings.";
            case 7  -> ideal =	"Discovery. I want to be the first person to discover a lost culture.";
            case 8  -> ideal =	"Distance. One must not interfere with the affairs of another culture – even one in need of aid.";
            case 9  -> ideal =	"Knowledge. By understanding other races and cultures, we learn to understand ourselves.";
            case 10 -> ideal =	"Power. Common people crave strong leadership, and I do my utmost to provide it.";
            case 11 -> ideal =	"Protection. I must do everything possible to save a society facing extinction.";
            case 12 -> ideal =	"Indifferent. Life is cruel. What's the point in saving people if they're going to die anyway?";
            case 13 -> ideal =	"Preservation. That artifact belongs in a museum.";
            case 14 -> ideal =	"Greed. I won't risk my life for nothing. I expect some kind of payment.";
            case 15 -> ideal =	"Death Wish. Nothing is more exhilarating than a narrow escape from the jaws of death.";
            case 16 -> ideal =	"Dignity. The dead and their belongings deserve to be treated with respect.";
            case 17 -> ideal =	"Immortality. All my exploring is part of a plan to find the secret of everlasting life.";
            case 18 -> ideal =	"Danger. With every great discovery comes grave danger. The two walk hand in hand.";
            case 19 -> ideal =	"Competition. I strive to test myself in all things.";
            case 20 -> ideal =	"Triumph. The best part of winning is seeing my rivals brought low.";
            case 21 -> ideal =	"Camaraderie. The strongest bonds are forged through struggle.";
            case 22 -> ideal =	"People. I strive to inspire my spectators.";
            case 23 -> ideal =	"Tradition. Every game has rules, and the playing field must be level.";
            case 24 -> ideal =	"Growth. Lessons hide in victory and defeat.";
            case 25 -> ideal =	"Independence. I am a free spirit – no one tells me what to do.";
            case 26 -> ideal =	"Fairness. I never target people who can't afford to lose a few coins.";
            case 27 -> ideal =	"Charity. I distribute the money I acquire to the people who really need it.";
            case 28 -> ideal =	"Creativity. I never run the same con twice.";
            case 29 -> ideal =	"Friendship. Material goods come and go. Bonds of friendship last forever.";
            case 30 -> ideal =	"Aspiration. I'm determined to make something of myself.";
            case 31 -> ideal =	"Honor. I don't steal from others in the trade.";
            case 32 -> ideal =	"Freedom. Chains are meant to be broken, as are those who would forge them.";
            case 33 -> ideal =	"Charity. I steal from the wealthy so that I can help people in need.";
            case 34 -> ideal =	"Greed. I will do whatever it takes to become wealthy.";
            case 35 -> ideal =	"People. I'm loyal to my friends, not to any ideals, and everyone else can take a trip down the Styx for all I care.";
            case 36 -> ideal =	"Redemption. There's a spark of good in everyone.";
            case 37 -> ideal =	"Beauty. When I perform, I make the world better than it was.";
            case 38 -> ideal =	"Tradition. The stories, legends, and songs of the past must never be forgotten, for they teach us who we are.";
            case 39 -> ideal =	"Creativity. The world is in need of new ideas and bold action.";
            case 40 -> ideal =	"Greed. I'm only in it for the money and fame.";
            case 41 -> ideal =	"People. I like seeing the smiles on people's faces when I perform. That's all that matters.";
            case 42 -> ideal =	"Honesty. Art should reflect the soul; it should come from within and reveal who we really are.";
            case 43 -> ideal =	"Open. I have much to learn from the kindly folk I meet along my way.";
            case 44 -> ideal =	"Reserved. As someone new to these strange lands, I am cautious and respectful in my dealings.";
            case 45 -> ideal =	"Adventure. I'm far from home, and everything is strange and wonderful!";
            case 46 -> ideal =	"Cunning. Though I may not know their ways, neither do they know mine, which can be to my advantage.";
            case 47 -> ideal =	"Inquisitive. Everything is new, but I have a thirst to learn.";
            case 48 -> ideal =	"Suspicious. I must be careful, for I have no way of telling friend from foe here.)";
            case 49 -> ideal =	"Respect. People deserve to be treated with dignity and respect.";
            case 50 -> ideal =	"Fairness. No one should get preferential treatment before the law, and no one is above the law.";
            case 51 -> ideal =	"Freedom. Tyrants must not be allowed to oppress the people.";
            case 52 -> ideal =	"Might. If I become strong, I can take what I want – what I deserve.";
            case 53 -> ideal =	"Sincerity. There's no good in pretending to be something I'm not.";
            case 54 -> ideal =	"Destiny. Nothing and no one can steer me away from my higher calling.";
            case 55 -> ideal =	"Beauty. When I perform, I make the world better than it was.";
            case 56 -> ideal =	"Tradition. The stories, legends, and songs of the past must never be forgotten, for they teach us who we are.";
            case 57 -> ideal =	"Creativity. The world is in need of new ideas and bold action.";
            case 58 -> ideal =	"Greed. I'm only in it for the money and fame.";
            case 59 -> ideal =	"People. I like seeing the smiles on people's faces when I perform. That's all that matters.";
            case 60 -> ideal =	"Honesty. Art should reflect the soul; it should come from within and reveal who we really are.";
            case 61 -> ideal =	"Community. It is the duty of all civilized people to strengthen the bonds of community and the security of civilization.";
            case 62 -> ideal =	"Generosity. My talents were given to me so that I could use them to benefit the world.";
            case 63 -> ideal =	"Freedom. Everyone should be free to pursue his or her own livelihood. (Chaotic)";
            case 64 -> ideal =	"Greed. I'm only in it for the money.";
            case 65 -> ideal =	"People. I'm committed to the people I care about, not to ideals.";
            case 66 -> ideal =	"Aspiration. I work hard to be the best there is at my craft.";
            case 67 -> ideal =	"Greater Good. My gifts are meant to be shared with all, not used for my own benefit.";
            case 68 -> ideal =	"Logic. Emotions must not cloud our sense of what is right and true, or our logical thinking.";
            case 69 -> ideal =	"Free Thinking. Inquiry and curiosity are the pillars of progress.";
            case 70 -> ideal =	"Power. Solitude and contemplation are paths toward mystical or magical power.";
            case 71 -> ideal =	"Live and Let Live. Meddling in the affairs of others only causes trouble.";
            case 72 -> ideal =	"Self-Knowledge. If you know yourself, there's nothing left to know.";
            case 73 -> ideal =	"Respect. Respect is due to me because of my position, but all people regardless of station deserve to be treated with dignity.";
            case 74 -> ideal =	"Responsibility. It is my duty to respect the authority of those above me, just as those below me must respect mine.";
            case 75 -> ideal =	"Independence. I must prove that I can handle myself without the coddling of my family.";
            case 76 -> ideal =	"Power. If I can attain more power, no one will tell me what to do.";
            case 77 -> ideal =	"Family. Blood runs thicker than water.";
            case 78 -> ideal =	"Noble Obligation. It is my duty to protect and care for the people beneath me.";
            case 79 -> ideal =	"Respect. Respect is due to me because of my position, but all people regardless of station deserve to be treated with dignity.";
            case 80 -> ideal =	"Responsibility. It is my duty to respect the authority of those above me, just as those below me must respect mine.";
            case 81 -> ideal =	"Independence. I must prove that I can handle myself without the coddling of my family.";
            case 82 -> ideal =	"Power. If I can attain more power, no one will tell me what to do.";
            case 83 -> ideal =	"Family. Blood runs thicker than water.";
            case 84 -> ideal =	"Noble Obligation. It is my duty to protect and care for the people beneath me.";
            case 85 -> ideal =	"Knowledge. The path to power and self-improvement is through knowledge.";
            case 86 -> ideal =	"Beauty. What is beautiful points us beyond itself toward what is true.";
            case 87 -> ideal =	"Logic. Emotions must not cloud our logical thinking.";
            case 88 -> ideal =	"No Limits. Nothing should fetter the infinite possibility inherent in all existence. ";
            case 89 -> ideal =	"Power. Knowledge is the path to power and domination.";
            case 90 -> ideal =	"Self-Improvement. The goal of a life of study is the betterment of oneself.";
        }

        return ideal;
    }
    public static String Bond(int bondrandomnumber){
        String bond = "";

        switch(bondrandomnumber){
            case 1 ->	bond = "I would die to recover an ancient relic of my faith that was lost long ago.";
            case 2 ->	bond = "I will someday get revenge on the corrupt temple hierarchy who branded me a heretic.";
            case 3 ->	bond = "I owe my life to the priest who took me in when my parents died.";
            case 4 ->	bond = "Everything I do is for the common people.";
            case 5 ->	bond = "I will do anything to protect the temple where I served.";
            case 6 ->	bond = "I seek to preserve a sacred text that my enemies consider heretical and seek to destroy.";
            case 7 ->	bond = "My mentor gave me a journal filled with lore and wisdom. Losing it would devastate me.";
            case 8 ->	bond = "Having lived among the people of a primeval tribe or clan, I long to return and see how they are faring.";
            case 9 ->	bond = "Years ago, tragedy struck the members of an isolated society I befriended, and I will honor them.";
            case 10 ->	bond = "I want to learn more about a particular humanoid culture that fascinates me.";
            case 11 ->	bond = "I seek to avenge a clan, tribe, kingdom, or empire that was wiped out.";
            case 12 ->	bond = "I have a trinket that I believe is the key to finding a long-lost society.";
            case 13 ->	bond = "Ever since I was a child, I've heard stories about a lost city. I aim to find it, learn its secrets, and earn my place in the history books.";
            case 14 ->	bond = "I want to find my mentor, who disappeared on an expedition some time ago.";
            case 15 ->	bond = "I have a friendly rival. Only one of us can be the best, and I aim to prove it's me.";
            case 16 ->	bond = "I won't sell an art object or other treasure that has historical significance or is one of a kind.";
            case 17 ->	bond = "I'm secretly in love with the wealthy patron who sponsors my archaeological exploits.";
            case 18 ->	bond = "I hope to bring prestige to a library, a museum, or a university.";
            case 19 ->	bond = "My teammates are my family.";
            case 20 ->	bond = "I will overcome a rival and prove myself their better.";
            case 21 ->	bond = "My mistake got someone hurt. Ill never make that mistake again.";
            case 22 ->	bond = "I will be the best for the honor and glory of my home.";
            case 23 ->	bond = "The person who trained me is the most important person in my world.";
            case 24 ->	bond = "I strive to live up to a specific hero's example.";
            case 25 ->	bond = "My teammates are my family.";
            case 26 ->	bond = "I will overcome a rival and prove myself their better.";
            case 27 ->	bond = "My mistake got someone hurt. Ill never make that mistake again.";
            case 28 ->	bond = "I will be the best for the honor and glory of my home.";
            case 29 ->	bond = "The person who trained me is the most important person in my world.";
            case 30 ->	bond = "I strive to live up to a specific hero's example.";
            case 31 ->	bond = "I fleeced the wrong person and must work to ensure that this individual never crosses paths with me or those I care about.";
            case 32 ->	bond = "I owe everything to my mentor – a horrible person who's probably rotting in jail somewhere.";
            case 33 ->	bond = "Somewhere out there, I have a child who doesn't know me. I'm making the world better for him or her.";
            case 34 ->	bond = "I come from a noble family, and one day I'll reclaim my lands and title from those who stole them from me.";
            case 35 ->	bond = "A powerful person killed someone I love. Some day soon, I'll have my revenge.";
            case 36 ->	bond = "I swindled and ruined a person who didn't deserve it. I seek to atone for my misdeeds but might never be able to forgive myself.";
            case 37 ->	bond = "I'm trying to pay off an old debt I owe to a generous benefactor.";
            case 38 ->	bond = "My ill-gotten gains go to support my family.";
            case 39 ->	bond = "Something important was taken from me, and I aim to steal it back.";
            case 40 ->	bond = "I will become the greatest thief that ever lived.";
            case 41 ->	bond = "I'm guilty of a terrible crime. I hope I can redeem myself for it.";
            case 42 ->	bond = "Someone I loved died because of I mistake I made. That will never happen again.";
            case 43 ->	bond = "My instrument is my most treasured possession, and it reminds me of someone I love.";
            case 44 ->	bond = "Someone stole my precious instrument, and someday I'll get it back.";
            case 45 ->	bond = "I want to be famous, whatever it takes.";
            case 46 ->	bond = "I idolize a hero of the old tales and measure my deeds against that person's.";
            case 47 ->	bond = "I will do anything to prove myself superior to my hated rival.";
            case 48 ->	bond = "I would do anything for the other members of my old troupe.";
            case 49 ->	bond = "I would never break my word.";
            case 50 ->	bond = "I find magic in all its forms to be compelling. The more magical a place, the more I am drawn to it.";
            case 51 ->	bond = "I do what I can to protect the natural world.";
            case 52 ->	bond = "A trusted friend is the most important thing in the multiverse to me.";
            case 53 ->	bond = "I can't bring myself to harm a Fey creature, either because I consider myself one or because I fear the repercussions.";
            case 54 ->	bond = "The Witchlight Carnival feels like home to me.";
            case 55 ->	bond = "I'm drawn to the Feywild and long to return there, if only for a short while.";
            case 56 ->	bond = "I feel indebted to Mister Witch and Mister Light for giving me a home and a purpose.";
            case 57 ->	bond = "I have a family, but I have no idea where they are. One day, I hope to see them again.";
            case 58 ->	bond = "I worked the land, I love the land, and I will protect the land.";
            case 59 ->	bond = "A proud noble once gave me a horrible beating, and I will take my revenge on any bully I encounter.";
            case 60 ->	bond = "My tools are symbols of my past life, and I carry them so that I will never forget my roots.";
            case 61 ->	bond = "I protect those who cannot protect themselves.";
            case 62 ->	bond = "I wish my childhood sweetheart had come with me to pursue my destiny.";
            case 63 ->	bond = "Nothing is more important than the other members of my hermitage, order, or association.";
            case 64 ->	bond = "I entered seclusion to hide from the ones who might still be hunting me. I must someday confront them.";
            case 65 ->	bond = "I'm still seeking the enlightenment I pursued in my seclusion, and it still eludes me.";
            case 66 ->	bond = "I entered seclusion because I loved someone I could not have.";
            case 67 ->	bond = "Should my discovery come to light, it could bring ruin to the world.";
            case 68 ->	bond = "My isolation gave me great insight into a great evil that only I can destroy.";
            case 69 ->	bond = "I will face any challenge to win the approval of my family.";
            case 70 ->	bond = "My house's alliance with another noble family must be sustained at all costs.";
            case 71 ->	bond = "Nothing is more important than the other members of my family.";
            case 72 ->	bond = "I am in love with the heir of a family that my family despises.";
            case 73 ->	bond = "My loyalty to my sovereign is unwavering.";
            case 74 ->	bond = "The common folk must see me as a hero of the people.";
            case 75 ->	bond = "I face danger and evil to offset an unredeemable act in my past.";
            case 76 ->	bond = "I. Will. Finish. The. Job.";
            case 77 ->	bond = "I must set an example of hope for those who have given up.";
            case 78 ->	bond = "I'm searching for a fellow marine captured by an elusive enemy.";
            case 79 ->	bond = "Fear leads to tyranny, and both must be eradicated.";
            case 80 ->	bond = "My commander betrayed my unit, and I will have revenge.";
            case 81 ->	bond = "I will face any challenge to win the approval of my family.";
            case 82 ->	bond = "My house's alliance with another noble family must be sustained at all costs.";
            case 83 ->	bond = "Nothing is more important than the other members of my family.";
            case 84 ->	bond = "I am in love with the heir of a family that my family despises.";
            case 85 ->	bond = "My loyalty to my sovereign is unwavering.";
            case 86 ->	bond = "The common folk must see me as a hero of the people.";
            case 87 ->	bond = "I'm loyal to my captain first, everything else second.";
            case 88 ->	bond = "The ship is most important – crewmates and captains come and go.";
            case 89 ->	bond = "I'll always remember my first ship.";
            case 90 ->	bond = "In a harbor town, I have a paramour whose eyes nearly stole me from the sea.";
            case 91 ->	bond = "I was cheated out of my fair share of the profits, and I want to get my due.";
            case 92 ->	bond = "Ruthless pirates murdered my captain and crewmates, plundered our ship, and left me to die. Vengeance will be mine.";
            case 93 ->	bond = "It is my duty to protect my students.";
            case 94 ->	bond = "I have an ancient text that holds terrible secrets that must not fall into the wrong hands.";
            case 95 ->	bond = "I work to preserve a library, university, scriptorium, or monastery.";
            case 96 ->	bond = "My life's work is a series of tomes related to a specific field of lore.";
            case 97 ->	bond = "I've been searching my whole life for the answer to a certain question.";
            case 98 ->	bond = "I sold my soul for knowledge. I hope to do great deeds and win it back.";
            case 99 ->	bond = "I'm loyal to my captain first, everything else second.";
            case 100 ->	bond = "The ship is most important – crewmates and captains come and go.";
            case 101 ->	bond = "I'll always remember my first ship.";
            case 102 ->	bond = "In a harbor town, I have a paramour whose eyes nearly stole me from the sea.";
            case 103 ->	bond = "I was cheated out of my fair share of the profits, and I want to get my due.";
            case 104 ->	bond = "Ruthless pirates murdered my captain and crewmates, plundered our ship, and left me to die. Vengeance will be mine.";
            case 105 ->	bond = "My vessel was stolen from me, and I burn with the desire to recover it.";
            case 106 ->	bond = "I intend to become the leader of the network of smugglers that I belong to.";
            case 107 ->	bond = "I owe a debt that cannot be repaid in gold.";
            case 108 ->	bond = "After one last job, I will retire from the business.";
            case 109 ->	bond = "I was tricked by a fellow smuggler who stole something precious from me. I will find that thief.";
            case 110 ->	bond = "I give most of my profits to a charitable cause, and I don't like to brag about it.";
            case 111 ->	bond = "I would still lay down my life for the people I served with.";
            case 112 ->	bond = "Someone saved my life on the battlefield. To this day, I will never leave a friend behind.";
            case 113 ->	bond = "My honor is my life.";
            case 114 ->	bond = "I'll never forget the crushing defeat my company suffered or the enemies who dealt it.";
            case 115 ->	bond = "Those who fight beside me are those worth dying for.";
            case 116 ->	bond = "I fight for those who cannot fight for themselves.";
            case 117 ->	bond = "I'm trying to pay off an old debt I owe to a generous benefactor.";
            case 118 ->	bond = "My ill-gotten gains go to support my family.";
            case 119 ->	bond = "Something important was taken from me, and I aim to steal it back.";
            case 120 ->	bond = "I will become the greatest thief that ever lived.";
            case 121 ->	bond = "I'm guilty of a terrible crime. I hope I can redeem myself for it.";
            case 122 ->	bond = "Someone I loved died because of I mistake I made. That will never happen again.case";
        }

        return bond;
    }
    public static String Flaw(int flawrandomnumber){
        String flaw = "";
        switch (flawrandomnumber){
            case 1 -> flaw = "I judge others harshly, and myself even more severely.";
            case 2 -> flaw = "I put too much trust in those who wield power within my temple's hierarchy.";
            case 3 -> flaw = "My piety sometimes leads me to blindly trust those that profess faith in my god.";
            case 4 -> flaw = "I am inflexible in my thinking.";
            case 5 -> flaw = "I am suspicious of strangers and expect the worst of them.";
            case 6 -> flaw = "Once I pick a goal, I become obsessed with it to the detriment of everything else in my life.";
            case 7 -> flaw = "Boats make me seasick.";
            case 8 -> flaw = "I talk to myself, and I don't make friends easily.";
            case 9 -> flaw = "I believe that I'm intellectually superior to people from other cultures and have much to teach them.";
            case 11 -> flaw = "I've picked up some unpleasant habits living among races such as goblins, lizardfolk, or orcs.";
            case 12 -> flaw = "I complain about everything.";
            case 13 -> flaw = "I wear a tribal mask and never take it off.";
            case 14 -> flaw = "I have a secret fear of some common wild animal – and in my work, I see them everywhere.";
            case 15 -> flaw = "I can't leave a room without searching it for secret doors.";
            case 16 -> flaw = "When I'm not exploring dungeons or ruins, I get jittery and impatient.";
            case 17 -> flaw = "I have no time for friends or family. I spend every waking moment thinking about and preparing for my next expedition.";
            case 18 -> flaw = "When given the choice of going left or right, I always go left.";
            case 19 -> flaw = "I can't sleep except in total darkness.";
            case 20 -> flaw = "I indulge in a habit that threatens my reputation or health.";
            case 21 -> flaw = "I'll do absolutely anything to win.";
            case 22 -> flaw = "I ignore anyone who doesn't compete and anyone who loses to me.";
            case 23 -> flaw = "I have lingering pain of old injuries.";
            case 24 -> flaw = "Any defeat or failure on my part is because my opponents cheated.";
            case 25 -> flaw = "I must be the captain of any group I join.";
            case 26 -> flaw = "I can't resist a pretty face.";
            case 27 -> flaw = "I'm always in debt. I spend my ill-gotten gains on decadent luxuries faster than I bring them in.";
            case 28 -> flaw = "I'm convinced that no one could ever fool me the way I fool others.";
            case 29 -> flaw = "I'm too greedy for my own good. I can't resist taking a risk if there's money involved.";
            case 30 -> flaw = "I can't resist swindling people who are more powerful than me.";
            case 31 -> flaw = "I hate to admit it and will hate myself for it, but I'll run and preserve my own hide if the going gets tough.";
            case 32 -> flaw = "When I see something valuable, I can't think about anything but how to steal it.";
            case 33 -> flaw = "When faced with a choice between money and my friends, I usually choose the money.";
            case 34 -> flaw = "If there's a plan, I'll forget it. If I don't forget it, I'll ignore it.";
            case 35 -> flaw = "I have a \"tell\" that reveals when I'm lying.";
            case 36 -> flaw = "I turn tail and run when things look bad.";
            case 37 -> flaw = "An innocent person is in prison for a crime that I committed. I'm okay with that.";
            case 38 -> flaw = "I'll do anything to win fame and renown.";
            case 39 -> flaw = "I'm a sucker for a pretty face.";
            case 40 -> flaw = "A scandal prevents me from ever going home again. That kind of trouble seems to follow me around.";
            case 41 -> flaw = "I once satirized a noble who still wants my head. It was a mistake that I will likely repeat.";
            case 42 -> flaw = "I have trouble keeping my true feelings hidden. My sharp tongue lands me in trouble.";
            case 43 -> flaw = "Despite my best efforts, I am unreliable to my friends.";
            case 44 -> flaw = "I am secretly (or not so secretly) convinced of the superiority of my own culture over that of this foreign land.";
            case 45 -> flaw = "I pretend not to understand the local language in order to avoid interactions I would rather not have.";
            case 46 -> flaw = "I have a weakness for the new intoxicants and other pleasures of this land.";
            case 47 -> flaw = "I don't take kindly to some of the actions and motivations of the people of this land, because these folk are different from me.";
            case 48 -> flaw = "I consider the adherents of other gods to be deluded innocents at best, or ignorant fools at worst.";
            case 49 -> flaw = "I have a weakness for the exotic beauty of the people of these lands.";
            case 50 -> flaw = "I easily lose track of time. My poor sense of time means I'm always late.";
            case 51 -> flaw = "I think the whole multiverse is out to get me.";
            case 52 -> flaw = "I'm always operating under a tight timeline, and I'm obsessed with keeping everything on schedule.";
            case 53 -> flaw = "I'm a kleptomaniac who covets shiny, sparkling treasure.";
            case 54 -> flaw = "I'm forgetful. Sometimes I can't remember even the simplest things.";
            case 55 -> flaw = "I never give away anything for free and always expect something in return.";
            case 56 -> flaw = "I have many vices and tend to indulge them.";
            case 57 -> flaw = "I'm always changing my mind-well, almost always.";
            case 58 -> flaw = "I am judgmental, especially of those I deem homebodies or otherwise lazy.";
            case 59 -> flaw = "I become depressed and anxious if I'm away from the sea too long.";
            case 60 -> flaw = "I have lived a hard life and find it difficult to empathize with others.";
            case 61 -> flaw = "I am inclined to tell long-winded stories at inopportune times.";
            case 62 -> flaw = "I work hard, but I play harder.";
            case 63 -> flaw = "I am obsessed with catching an elusive aquatic beast, often to the detriment of other pursuits.";
            case 64 -> flaw = "The tyrant who rules my land will stop at nothing to see me killed.";
            case 65 -> flaw = "I'm convinced of the significance of my destiny, and blind to my shortcomings and the risk of failure.";
            case 66 -> flaw = "The people who knew me when I was young know my shameful secret, so I can never go home again.";
            case 67 -> flaw = "I have a weakness for the vices of the city, especially hard drink.";
            case 68 -> flaw = "Secretly, I believe that things would be better if I were a tyrant lording over the land.";
            case 69 -> flaw = "I have trouble trusting in my allies.";
            case 70 -> flaw = "Now that I've returned to the world, I enjoy its delights a little too much.";
            case 71 -> flaw = "I harbor dark, bloodthirsty thoughts that my isolation and meditation failed to quell.";
            case 72 -> flaw = "I am dogmatic in my thoughts and philosophy.";
            case 73 -> flaw = "I let my need to win arguments overshadow friendships and harmony.";
            case 74 -> flaw = "I'd risk too much to uncover a lost bit of knowledge.";
            case 75 -> flaw = "I like keeping secrets and won't share them with anyone.";
            case 76 -> flaw = "I secretly believe that everyone is beneath me.";
            case 77 -> flaw = "I hide a truly scandalous secret that could ruin my family forever.";
            case 78 -> flaw = "I too often hear veiled insults and threats in every word addressed to me, and I'm quick to anger.";
            case 79 -> flaw = "I have an insatiable desire for carnal pleasures.";
            case 80 -> flaw = "In fact, the world does revolve around me.";
            case 81 -> flaw = "By my words and actions, I often bring shame to my family.";
            case 82 -> flaw = "I grow combative and unpredictable when I drink.";
            case 83 -> flaw = "I find civilian life difficult and struggle to say the right thing in social situations.";
            case 84 -> flaw = "My intensity can drive others away.";
            case 85 -> flaw = "I hold grudges and have difficulty forgiving others.";
            case 86 -> flaw = "I become irrational when innocent people are hurt.";
            case 87 -> flaw = "I sometimes stay up all night listening to the ghosts of my fallen enemies.";
            case 88 -> flaw = "I secretly believe that everyone is beneath me.";
            case 89 -> flaw = "I hide a truly scandalous secret that could ruin my family forever.";
            case 90 -> flaw = "I too often hear veiled insults and threats in every word addressed to me, and I'm quick to anger.";
            case 91 -> flaw = "I have an insatiable desire for carnal pleasures.";
            case 92 -> flaw = "In fact, the world does revolve around me.";
            case 93 -> flaw = "By my words and actions, I often bring shame to my family.";
            case 94 -> flaw = "I am too enamored of ale, wine, and other intoxicants.";
            case 95 -> flaw = "There's no room for caution in a life lived to the fullest.";
            case 96 -> flaw = "I remember every insult I've received and nurse a silent resentment toward anyone who's ever wronged me.";
            case 97 -> flaw = "I am slow to trust members of other races, tribes, and societies.";
            case 98 -> flaw = "Violence is my answer to almost any challenge.";
            case 99 -> flaw = "Don't expect me to save those who can't save themselves. It is nature's way that the strong thrive and the weak perish.";
            case 100 -> flaw = "I follow orders, even if I think they're wrong.";
            case 101 -> flaw = "I'll say anything to avoid having to do extra work.";
            case 102->  flaw = "Once someone questions my courage, I never back down no matter how dangerous the situation.";
            case 103 -> flaw = "Once I start drinking, it's hard for me to stop.";
            case 104 -> flaw = "I can't help but pocket loose coins and other trinkets I come across.";
            case 105 -> flaw = "My pride will probably lead to my destruction.";
            case 106 -> flaw = "I am easily distracted by the promise of information.";
            case 107 -> flaw = "Most people scream and run when they see a demon. I stop and take notes on its anatomy.";
            case 108 -> flaw = "Unlocking an ancient mystery is worth the price of a civilization.";
            case 109 -> flaw = "I overlook obvious solutions in favor of complicated ones.";
            case 110 -> flaw = "I speak without really thinking through my words, invariably insulting others.";
            case 111 -> flaw = "I can't keep a secret to save my life, or anyone else's.";
            case 112 -> flaw = "I follow orders, even if I think they're wrong.";
            case 113 -> flaw = "I'll say anything to avoid having to do extra work.";
            case 114 -> flaw = "Once someone questions my courage, I never back down no matter how dangerous the situation.";
            case 115 -> flaw = "Once I start drinking, it's hard for me to stop.";
            case 116 -> flaw = "I can't help but pocket loose coins and other trinkets I come across.";
            case 117 -> flaw = "My pride will probably lead to my destruction.";
            case 118 -> flaw = "Lying is reflexive, and I sometimes engage in it without realizing.";
            case 119 -> flaw = "I tend to assess my relationships in terms of profit and loss.";
            case 120 -> flaw = "I believe everyone has a price and am cynical toward those who present themselves as virtuous.";
            case 121 -> flaw = "I struggle to trust the words of others.";
            case 122 -> flaw = "Few people know the real me.";
            case 123 -> flaw = "Though I act charming, I feel nothing for others and don't know what friendship is.";
            case 124 -> flaw = "The monstrous enemy we faced in battle still leaves me quivering with fear.";
            case 125 -> flaw = "I have little respect for anyone who is not a proven warrior.";
            case 126 -> flaw = "I made a terrible mistake in battle that cost many lives – and I would do anything to keep that mistake secret.";
            case 127 -> flaw = "My hatred of my enemies is blind and unreasoning.";
            case 128 -> flaw = "I obey the law, even if the law causes misery.";
            case 129 -> flaw = "I'd rather eat my armor than admit when I'm wrong.";
            case 130 -> flaw = "When I see something valuable, I can't think about anything but how to steal it.";
            case 131 -> flaw = "When faced with a choice between money and my friends, I usually choose the money.";
            case 132 -> flaw = "If there's a plan, I'll forget it. If I don't forget it, I'll ignore it.";
            case 133 -> flaw = "I have a \"tell\" that reveals when I'm lying.";
            case 134 -> flaw = "I turn tail and run when things look bad.";
            case 135 -> flaw = "An innocent person is in prison for a crime that I committed. I'm okay with that.";
        }
        return flaw;
    }
    public static String LawAlignment(String ideal){
        String Lawalignment = "";
        String keyword = ideal.substring(0, ideal.indexOf('.'));

        switch (keyword){
            case "Tradition"         -> Lawalignment = "Lawful";
            case "Charity"           -> Lawalignment = "Lawful";//""Good";
            case "Change"            -> Lawalignment = "Chaotic";
            case "Power"             -> Lawalignment = "Chaotic";//"Evil";
            case "Faith"             -> Lawalignment = "Lawful";
            case "Aspiration"        -> Lawalignment = anyHandler(Randomizer(3,1));
            case "Discovery"         -> Lawalignment = anyHandler(Randomizer(3,1));
            case "Distance"          -> Lawalignment = "Lawful";
            case "Knowledge"         -> Lawalignment = "Neutral";
            case "Protection"        -> Lawalignment = "Lawful";//"Good";
            case "Indifferent"       -> Lawalignment = "Chaotic";
            case "Preservation"      -> Lawalignment = "Lawful";
            case "Greed"             -> Lawalignment = "Chaotic";//"Evil";
            case "Death Wish"        -> Lawalignment = "Chaotic";
            case "Dignity"           -> Lawalignment = "Lawful";
            case "Immortality"       -> Lawalignment = "Chaotic";//"Evil";
            case "Danger"            -> Lawalignment = "Chaotic";
            case "Competition"       -> Lawalignment = "Chaotic";
            case "Triumph"           -> Lawalignment = "Lawful";//"Evil";
            case "Camaraderie"       -> Lawalignment = "Lawful";//"Good";
            case "People"            -> Lawalignment = "Neutral";
            case "Growth"            -> Lawalignment = "Good";
            case "Independence"      -> Lawalignment = "Chaotic";
            case "Fairness"          -> Lawalignment = "Lawful";
            case "Creativity"        -> Lawalignment = "Chaotic";
            case "Friendship"        -> Lawalignment = "Chaotic";//"Good";
            case "Honor"             -> Lawalignment = "Chaotic";//"Good";
            case "Freedom"           -> Lawalignment = "Chaotic";//"Good";
            case "Redemption"        -> Lawalignment = "Chaotic";//"Good";
            case "Beauty"            -> Lawalignment = "Chaotic";//"Good";
            case "Honesty"           -> Lawalignment = "Lawful";
            case "Open"              -> Lawalignment = "Chaotic";//"Good";
            case "Reserved"          -> Lawalignment = "Lawful";
            case "Adventure"         -> Lawalignment = "Chaotic";
            case "Cunning"           -> Lawalignment = "Chaotic";//"Evil";
            case "Inquisitive"       -> Lawalignment = "Neutral";
            case "Suspicious"        -> Lawalignment = "Neutral";
            case "Respect"           -> Lawalignment = "Lawful";//"Good";
            case "Might"             -> Lawalignment = "Chaotic";//"Evil";
            case "Sincerity"         -> Lawalignment = "Neutral";
            case "Destiny"           -> Lawalignment = anyHandler(Randomizer(3,1));
            case "Community"         -> Lawalignment = "Lawful";
            case "Generosity"        -> Lawalignment = "Lawful";//"Good";
            case "Greater Good"      -> Lawalignment = "Lawful";//"Good";
            case "Logic"             -> Lawalignment = "Lawful";
            case "Free Thinking"     -> Lawalignment = "Chaotic";
            case "Live and Let Live" -> Lawalignment = "Neutral";
            case "Self-Knowledge"    -> Lawalignment = anyHandler(Randomizer(3,1));
            case "Responsibility"    -> Lawalignment = "Lawful";
            case "Family"            -> Lawalignment = anyHandler(Randomizer(3,1));
            case "Noble Obligation"  -> Lawalignment = "Lawful";//"Good";
            case "No Limits"         -> Lawalignment = "Chaotic";
            case "Self-Improvement"  -> Lawalignment = "Neutral";
        }

        return Lawalignment;
    }
    public static String goodAlignment(int goodrandomnumber){
        String goodAlignment = "";

        switch (goodrandomnumber){
            case 1 -> goodAlignment = "Good";
            case 2 -> goodAlignment = "Neutral";
            case 3 -> goodAlignment = "Evil";
        }

        return goodAlignment;
    }
    public static String anyHandler(int lawrandomnumber){
        String lawAlignment = "";

        switch (lawrandomnumber){
            case 1 -> lawAlignment = "Lawful";
            case 2 -> lawAlignment = "Neutral";
            case 3 -> lawAlignment = "Chaotic";
        }

        return lawAlignment;
    }
}