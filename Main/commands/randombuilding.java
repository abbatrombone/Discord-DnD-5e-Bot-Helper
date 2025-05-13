package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.utils.SplitUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class randombuilding extends ListenerAdapter{
    private static final EnumSet<Drinks> enumSet = EnumSet.allOf(Drinks.class);
    private static final EnumSet<Foods> enumSet2 = EnumSet.allOf(Foods.class);

    enum Foods {
        venisonstew("Venison Stew","One of the local hunters hauled in a big buck recently and is seasoned with local herbs","3 Gold"),
        Darkmantlesouffle("Darkmantle soufflé","Darkmantle soufflé, with hollandaise sauce and a fried egg on top.","5 Gold"),
        Griffinshanks("Griffin shanks","Griffin shanks served with our secret BBQ sauce","6 Gold"),
        Pseudodragononastick("Pseudodragon on a stick","3 sticks of Pseudodragon, theres nothing fake about this meat","2 Gold"),
        Rackofowlbearrib("Rack of owlbear ribs","Who doesnt like a nice tender rack of ribs.","10 Gold"),
        Caramelfritterswithhealingpotionbakedin("Caramel fritters, with healing potion baked in.","Your mother was wrong, there are sweet and healthy deserts","200 Gold"),
        BobosJoJos("Bobo's JoJos","Bobo's half-orc half man, but 100% delicious special, served with Jojo's seasoned potatoe wedges","5 Gold"),
        SurfandTurf("Surf and Turf","Stag steak and dire lobster with our garlic butter sauce and a side of mashed potatoes","15 Gold"),
        IllithidLarvainSquidInk("Illithid Larva in Squid Ink","Eat this dish before it eats you, and your mind, served in squid int to make it feel at home","45 Gold"),
        Catchyaownfishandchips("Catch ya own fish and chips.","You bring it we cook it, just make sure it still isn't alive. We cant loose another cook Lipven.","8 Silver"),
        Breadpuddingwithextrasharpdiregoatcheese("Bread pudding with extra sharp dire goat cheese","Comes with a side of grilled onions and carrots.","11 Silver"),
        Almirajstew("Almiraj stew","Similar to rabbit stew, but with a rarer meat, that just cant be beat","15 Gold"),
        MyconidStew("Myconid Stew","A drow deliciously that will make you tingle with joy","10 Gold"),
        Rothe("Rothé burger","One bite of this and you'll never be able to go back to basic burgers","2 Gold"),
        spaghettiwithsauteedVegepygmymushrooms("Vegepygmy spaghetti ","spaghetti with sautéed Vegepygmy mushrooms and Elk metballs"," 8 Silver"),
        AnkhegClaws("Ankheg Claws","Some call these bugs, we call them land crabs, as it tastes just like crab, but with more meat per claw","4 Gold"),
        CockatriceSandwitch("Cockatrice sandwitch","Served with our snake sauce and a side of wings","2 Gold"),
        Grickcalamari("Grick calamari","Calamari made from Grick served in split beak as a dish","3 Gold"),
        Mimicpadtai("Mimic pad tai*","Rice noodles with our signature noodle sauce, chicken mimic (tofu), onions and beansprouts.\n * contains nuts!","5 Gold"),
        AwakenedSalad("Awakened Salad","Salad made form Awakened Shrubs served with your choice of dressing"," 5 Silver"),
        meatstick("Meat Stick","Its meat on a stick, what more could an adventurer ask for","3 Copper"),
        RoastedLocusts("Roasted Locusts","If it doesnt bug you it doesnt bug us","3 Copper"),
        CheeseOmelet("Cheese Omelet","It has the two most important things cheese and eggs","5 Copper"),
        Bloodhawkeggs("Bloodhawk Eggs","For those feeling particularly peckish Bloodhawk eggs will met your needs.","4 Silver"),
        BaconStuffedBread("Bacon Stuffed Bread","Bacon and Bread what more could you ask for","5 Silver"),
        AdventurersSteak("\"Adventurer's\" Steak","A steak for the bravest and boldest adventurers with a side of baked potatoes","4 Copper"),
        MincedPork("Minced Pork","For the less adventurous amongst us Minced pork remains a classic dish","5 Copper"),
        BoarTenderloin("Boar Tenderloin","A fine cut of boar with a side of green beans","5 Silver"),
        BakedGooseBreast("Baked Goose Breast","Goose breast with a side of our breast vegetables","5 Silver"),
        RackofLamb("Rack of Lamb","A nice rack... of lamb with our best spices and seasonings","2 Gold"),
        DragonTurtleSoup("Dragon Turtle Pho","A flavorful noodle soup made with a rich dragon turtle broth and meet","10 Gold"),
        PigeonPotPie("Pigeon Pot Pie","Cooked pigeons, their offal, aromatics, and mushrooms, simmered in a rich stock.","5 Copper"),
        TashasHideousStew("Tasha’s Hideous Stew","A mixture of today's over prepped food, fixed with the chef's blend of spices","5 Copper"),
        HuntersPie("Hunter's Pie","Hearty meal with ground venison, potatoes, carrots, peas and onions","4 Silver"),
        BloodhawkBreast("Bloodhawk Breast","Marinated overnight in our secret seasonings grilled with a hint of lime","5 Silver"),
        CrocodileSteak("Crocodile Steak","Tastes like chicken and fills you up like beef","5 Silver"),
        RoastedBullywugLegs("Roasted Bullywug Legs","More meat than your average frog, pairs well with our selection of beers and ales","6 Silver"),
        SahuaginCaviar("Sahuagin Caviar","A tastier twist on typical caviar","3 Gold"),


        ;
        final String name;
        final String description;
        final String cost;

        Foods(String name, String description, String cost) {
            this.name = name;
            this.description = description;
            this.cost = cost;
        }
        private static final List<randombuilding.Foods> Foods = Collections.unmodifiableList(Arrays.asList(randombuilding.Foods.values()));
        private static final int foodsize = Foods.size();
    }

    enum Drinks {

        GoblinGrog("Goblin Grog","Putrid Green","The cheapest rot gut ale in the land. This is the stuff that can be brewed with all types of ingredients sometimes including goblin. Taste is terrible but gets the job done","Any adventurer who drinks this will not regain HP on a Long Rest. They will be too busy vomiting and feeling awful all night. Effect wears off after 1 day.","1 Silver"),
        GriffinNest("Griffin Nest","Medium Brown","A shot of Dwarven Brandy with a raw egg in it.","DC 10 CON save or vomiting ensues.","5 Copper"),
        SkullbusterXXX("Skullbuster XXX","Pink with brown lumps","A potent orcish ale where the vintage is measured by how many lumps in it, the more the better. Normally only given as a rare gift by people who have done the orcish people a great service","For non-orcs they must make a DC15 con save or pass-out for 1D6 hours, half-orcs make the save at DC7","5 Silver"),
        SilversAle("Silver's Ale","Clear with a silvery shimmer","The pride and joy of the Silvermane Clan, Silver's Ale is a powerful Dwarven concoction of 296% ABV, for Dwarves it is only 74% ABV. The drink can also double as a splash weapon in a bar fight!","DC 15 CON save for 2d4 poison damage for non-Dwarves. If used as improvised poison, 1d13 posion damage to anyone except Dwarves, Con save for half and is not poisoned.","3 Silver per Pint"),
        Glowglass("Glowglass","green phosphorescent","A gnomish concoction made from glowing mushrooms. Most non gnomes refuse to drink this sweet liquor, most gnomes laugh at this.","Drinker sheds a soft glow like a candle for 1d4 hours.","2 Silver a Shot"),
        OldStinky("Old Stinky","Brown with floating debris","A strong fungus ale, brewed by Eblo Harglet after he developed a taste for fungus ales in the Underdark.","In the next 24 hours, a patch of mushrooms will grow from a random location on the player's body. Harmless. This patch will continue to grow mushrooms for 1d4 days or can be cured by magical healing.","1 Copper"),
        RoaringEagleAle("Roaring Eagle Ale","Blood red with various fine chopped cloves","A strong hearty Ale with a strong burning finish. No one knows why it is blood red in color. Possibly because of a reaction of the water they use in the brewing process, or because they barrels they use are made with Blood Root trees. Which grow special in the region where The Roaring Eagle is.","Every fifth word is replaced with an eagles scream for 3d20 minutes","2 Silver"),
        Slog("Slog","Usually Dark brown","This drink is taken from the waste barrel. All the leftover, half drunk, or not made correctly alcohol is thrown into the barrel to be reused very cheap. the taste changes daily based off the most unused alcohol that night.","DC 8 con save to keep the random contents down.","3 Copper"),
        Bilgewater("Bilgewater","Blue-ish Brown or Jet Black","Made by soaking the inner organs of various sea creatures soaking in a fermented brine, the concoction is the run through a sieve to remove the bones and viscera","The lingering taste of rotten, brackish seafood remains on the palette for a few hours","5 Copper or One Tall Tale"),
        Deepminer("Deepminer","shiny golden liquid with black foam","Taken from a keg with floating lumps of coal, initial strong charcoal taste followed by delicious warm honey golden taste","Upon your next Long Rest, your character makes a bowel movement. You must roll d100 if you roll under the number of drinks consumed your feces contains a small gold nugget worth d10 gold, if not is a painful coal filled movement","10 Silver per Pint"),
        Sildarsitch("Sildars itch","clear with white shimmer","Clear shot, strong apple and clove taste (drink came from a distiller that had itchy back but nobody to scratch it)","upon drinking hands get very warm and fingernails grow d4 cm","2 Silver"),
        DragonfireBrandy("Dragonfire Brandy","Deep candy apple red w, swirling orange mist","Aged brandy with a hint of Apple Cider / Red hots. Smooth","DC 13 Con sv. Fail = Disadvantage on persuasion and seduction resistance tests, but you're happy about whatever you did... until tomorrow. Maybe. I mean you DID have fun. And the Tiefling twins were seriously alluring and sexy.","1 Gold per Snifter."),
        TheCrankyClergyman("The Cranky Clergyman","Deep Opaque Black with Stark White Head","Adapted from a well aged potion of cure wounds, this bitter drink feels and tastes like poison before entering stomach. A brief moment later, warm feelings emanate from the drinker's gut as some small wounds seal up. A tavern favorite for after-brawl drinks.","DC 11 Con Save, 1d4 poison damage upon fail. One round later (approx. five seconds) later, heals 2d4 hit points","7 Copper"),
        MilligunsDeepStout("Milligun's Deep Stout","Deep chocolate to black with a white frothy head","A brew hailing from one of the most revered halfing breweries, Milligun's is their signature brew. It is rare to find in human establishments. A complex, deep, hearty flavor lingering of coffee and burnt grain with a bold body and a hint of plum.","Advantage on saving throws vs. Fear for the next 1 hr, followed by vomiting after 1 hour","1 Gold"),
        RadosDeathPunch("Rado's Death Punch","Blood red with a blue top layer","The best blend of magic and rum in the world. Dark rum mixed with a cherry cordial in a silver strainer imbued with magic, it tastes like a perfect wine and rum mix. To add the blue topper, simply stir with a golden spoon and the magic reacts to the gold, giving a random flavor each time it's poured.","DC 14 Con Save, 1d10 poison on a fail and become drunk for 1d4 hours. On a success, half damage and must succeed on a DC 16 Wisdom save to ask for another which caused the consumer to have disadvantage on the next Con save.","2 Silver per Shot. If already consumed one shot, price doubles."),
        JellyDrink("Jelly Drink","A greenish drink that wobbles when moved","It's as it sounds like. The drink is comprised of a green minty liquid filled with gelatinous cubes that can either be chewed or swallowed whole. The drink itself is a little sour but with the sweetness of the cubes in contrast, it makes it a rather unique and flavoursome experience.","Allows sour food to taste sweet and visa versa. Effect lasts for only 30 mins per drink.","10 Copper"),
        Orksbloodbrew("Ork's blood brew","Blood red with crimson froth","This salty bitter brew is made from the fermented blood of an orc chief's rivals. after the first few gulps the drink feels thick and coppery. Brewed by orcish shaman.","con save 11 + 1 for every additional mug to become nauseous. if you consume another tankard after becoming nauseous, you vomit. Common for cheap drinking contests","8 Copper"),
        PoormansWine("Poorman's Wine","Watered down milk lacking in consistency","A drink made from potatoes, milk and some other kind of ingredients that you don't really want to think about. Raw and lacking in finesse and taste, it does the job it's supposed to - getting you blazing drunk... and maybe forgetting about your old ball and chain of a wife.","Allows the consumer to forget one painful recent memory(in the last two weeks) for 1d6 in hours.","1 Copper"),
        TheHairyWizard("The Hairy Wizard","Various shades of brown","Strong to the taste but can leave an itchy sensation in the throat","Roll 1d6 for every cup you drink. On a 5 or 6 your throat starts to become itchy. Sensation wears off after a few minutues. If you drink more while your throat is itchy do a DC 15 Con save and on a fail vomit out a hairballs like a cat.","3 Silver"),
        WarlocksWastedPatron("Warlock's Wasted Patron","Blue with dark swirls","Burns all the way down, but has an amazing aftertaste.","Those who drink this drink can use Mage Hand (cantrip) at will for the next few minutes","1 Gold"),
        KossuthsKiss("Kossuths' Kiss","Red with swirls of orange","Cinnamon Schnapps with a special proprietary ingredient the bartender lights on fire before serving","Cinnamon Schnapps with a special proprietary ingredient the bartender lights on fire before serving","5 Silver"),
        Firewine("Firewine","Pale red","This ruby rich delight is packed with mouth-watering sumptuousness with hints of bramble, blackberry, boysenberry, Don Cherry and Frankenberry flourishes. A treat to eat with beef testicles or lamb spleen escabeche. Also an ideal companion for manic-depression. Shows promise to last longer than your belief in an afterlife.","Disadvantage on Charisma checks for 1d6 hours.","50 Silver"),
        SquidInk("Squid Ink","Black","Goes down slowly and coats your mouth and throat. Usually followed by a chaser.","Impresses or disgusts anyone who sees you drinking this aiding or reducing your social interactions","3 Gold"),
        Twisty("Twisty","White yogurt on top, purplish liquid underneath","Topped in a thick layer of savory yogurt, it is both a drink and meal in one. The drink itself contains the flavours of blueberries mixed in with a helping of spirits.","Heals you for 1Hp, its still alcohol so drink responsibly","30 Copper"),
        TreantTea("Treant Tea","Dark brown with green swirls","Served in a tall earthenware mug, this dark tea still has some ground Treant leaves floating around in it to steep. It is advised to drink slowly as not to swallow the leaves, as they leave a bitter aftertaste. The tea itself is quite sweet, but can be further sweetened to taste by putting a few twigs of sweetwood into the mug. It leaves a nutty aftertaste and an uncanny feeling of connectedness with everything made of wood in your general vicinity.","While slowly sipping the hot tea, you sprout small twigs and leaves from your orifices. As you continue drinking the twigs spread and your skin takes on a barklike appearance. For an ten minutes after finishing the drink, your skin is solid wood, acting like the Barkskin spell, and you have disadvantage on saving throws against fire.","25 Silver"),
        DemonsBlood("Demon's Blood","Black with red spots inside it","A drink preferred by fiends and devils. Made from Cinnamon Bark and of course demon's blood.","If any other creature other than a fiend, a Tiefling, and a devil drinks this they take 1d10 Necrotic Damage. They also must make a DC 10 Con save or be poisoned taking 1d4 poison damage every hour. If poisoned roll a 1d6 to determine how many hours the creature is affected by the poison. The creature cannot heal while poisoned by the drink.If the creature falls unconscious the poison stops until the creature is awake. The creature can still be stabilized.","5 Silver"),
        DragonsAle("Dragons Ale","A chromatic color or metallic color (see description)","A dragons breath was used to help produce the drink. This makes the color of the drink and the sensation. Some versions use an alchemical indicator to make it clear so you never know what you get","You get a draconic accent for the next hour. Additioanlly, based on the breath you either feel, warm (red), freezing (white), gassy (green), sporadically jittery (blue), or incredibly hungry (black) ","10 Gold"),
        GlassMilk("Glass Milk","Clearish-white","An expensive drink popular among desert dwellers. However, it is not for the faint of heart","Make a charisma DC 15 saving throw, succeeding gives you advantage on persusation checks, failing results you being cursed with some form of madness for an hour or until you pass out","20 Gold"),
        HangmansNoose("Hangman's Noose","Yellowish brown","This drink got its name from the collective regrets of drinking this, but remains popular do to its commonality and price. Some saying i would have rather woken up in the hangman's noose around me, than have this hangover","The next morning you have the worst migrane you have ever had, and ever will have, and the worst hangover you have ever had and ever can have. You cannot concentrate on spells if you can cast spells, and have light sensitivity for the day.","2 Copper per pint"),
        Wyvernwine("Wyvern wine","Green with purple swirls","This drink, like absinthe, has mild hallucinogenic properties. Its sweet and tangy with a slight burning aftertaste as the neurotoxin from the wyvern poison comes into contact the the soft tissue in the mouth.","Non-dragons/dragon-like creatures must make a DC 14 con saving throw. Failure means they suffer from mild hallucinations, they are distracting and give them a -2 on all skill checks and attack rolls for the next 2 hours.","8 Gold"),
        DryHeave("Dry Heave","White","Sour at first, then burns with a vengeance. After taste leaves a lingering effect.","If in a drinking contest this make an intimidation check, if you win, the opposion takes a -2 on their next con saving throw.","3 Copper"),
        Giftmouth("Giftmouth","Red wine with a dash of purple","It's short and sweet and leaves you light on your feet. Makes you feel smart and attentive. You begin to notice things that you hadn't been able to comprehend before. A popular drink among aristocrats and nobles.","You are under the affects of the comprehend language spell for the next 20 minutes. Afterwards, you momentarily forget some words in your native tongue, and lots of words in the other languages you speak. An affect known as bye-lingual","10 Gold"),
        BardsBlessing("Bard's Blessing","A soft palette of subtle reds, pinks and yellows.","You feel like you can express yourself in ways you never thought you could. Dancing, Singing, or any other muse that appeals to your charater.","To you, you feel like the best singer, dancer, etc... not so much to everyone else","20 Silver"),
        BlindBeholder("Blind Beholder","Dark red with large white bubbles","A drink made from material found only in the Underdark. Tastes somewhat musty, but has an incredible kick; doesn't take much to make the world start spinning.","Anyone attempting to cast a spell while still tipsy or drunk from this drink risks a 50% chance of the spell backfiring","5 Silver"),
        TraverasTincture("Travera's Tincture","Phases between a deep orange and bright yellow. Clear but with silver dust visible when the liquid is disturbed.","A drink made by a dwarven wife who was dying of a terminal illness but wished to take care of her husband even in death.","Upon drinking any vessel filled with this liquid the drinker will awake warm dry clean and hunger free the following day at noon, with no recollection of any events( because there were none) of the previous evening. Sleeping this night will never be easier","5 Gold"),
        BananaMilkshake("Banana Milkshake","A slightly yellow frothing milk drink with chunks of banana scattered throughout","It's thick. It's creamy and oh so bananary. Add chunks of ice to make it a refreshing drink throughout the hot summer months. Child-friendly."," ","3 Copper"),
        NerosNectar("Neros Nectar","Clear with pearl/opalescence swirls and feint random tiny glowing pink lights","A delicious alchemical / alcoholic concoction. Made with Tiefling Fire vodka and a dash of a pixie sugar dust, a teaspoon of honey, and two spells, one of which is Faerie fire. The other spell is not named but its process easily followed even by the most novice spell caster. Its an ancient spell of warlock / fey origin. This drink designed for the patrons in the tavern, usually female, who tire of the endless rude adventuring lot, making advance after rude advance on them. The ladies often buy this drink for the truly offending adventurer and enjoy the effects caused on the unsuspecting offender.","This drink tastes amazing. It's almost EXACTLY what the drinker was wishing for. Nice buzz. No hangover. DC 17 con to notice as you enjoy your time in the tavern you are treated as Dazed for the 1st minute. After that minute is over, and your head is not so fuzzy, you enjoy the rest of the night, in the form of the opposite gender. Right down to the clothes your wearing as well. Now that the shoe is on the other foot, enjoy your fellow adventurer's attention.","2 Gold for the bartender to cast it as a ritual from that dusty drink recipe tome."),
        KenkusClaw("Kenku's Claw","Black with a streak of grey","Served in a curved glass in that of a claw. The drink's warmth can be felt spreading throughout the body. Then what feels like a cut across your chest.","Roll a 3d6 a 3 causes you to cough up a feather. DC 16 Cons check or randomly shout out expletives for the next 1d4 minutes. ","2 Silver"),
        EyeoftheBeholder("Eye of the Beholder","Milky white","An alcoholic drink made by nomadic groups in which a hard-boiled egg with a big dot is added to fermented goats milk."," ","3 Copper for normal livestock egg, but price can increase depending on the source of the egg"),
        ParrotyParrotyParrotyParrot("Parroty Parroty Parroty Parrot","A clear liquid crossed with red, green and yellow stripes.","The drink tastes fluffy in your mouth, and nutty. It's smooth yet, light and bubbly enough to have you wanting more. Little do you realize however is that this fluffy feeling in your chest will soon extend to your entire body. You believe you have wings now, and oh? Is that a crest? You are now a parrot, or so you believe.","The consumer thinks they become a parrot. They don't actually turn into one, they just think they are. They lose the ability to formulate proper eloquent speech as well as the will to act like a sane individual. They act like a parrot for 3 minutes before their mind is restored.","30 Silver"),
        PanDimensionalGargleBlaster("Pan-Dimensional Gargle Blaster","A teal blue with a foamy with froth at the top. Served in a glass of an odd shape.","A group of wizards long ago traveled to the different planes to find the ebst drink, this is what they found, and their recreation of it.","It feels like you have been transported to another plane, but you remain in place. It tastes better than what you can imagine, but you will not slowly sober up tonight it will be all at once, as if the alcohol was teleported out of you. It is an odd and unsettling feeling","10 gold"),
        Blerry("Blerry","Ranging from clear lavender to deep red, depending on the berries","Of halfling origin, this is a fermented juice of berries, honey and spices. There are regional and seasonal variations, each with family variations. Lightly alcoholic, Berry is usually drunk to refresh rather than to intoxicate (though in quantity, this the latter can be accomplished). Some varieties are dry, but most versions are at least slightly sweet, and almost all ideally have a light carbonation. A few variations made for sale to humans are sweeter and heavier, and are used as a kind of dessert wine, but most native drinkers turn up their nose at these.","The consumer is refreshed, energized and, usually, somewhat cheered. It intoxicates like a standard lager, and takes at least a pint to get the average halfling buzzed -- a good few pints for a typical human, and a dwarf or half-orc would need more. The varieties made for humans are stronger-- like a light wine.","1 Silver"),
        WildMagicBrew("Wild Magic Brew","Golden, fizzing, and sometimes sparkling","Very bubbly, tastes a little sweet, and can often cause the drinker to see random sparks around them. Sometimes the sparks are even real. It is sometimes call Sorcerer's Brew","After drinking, any time you try to cast a spell in the next hour, roll 1d20. On a 1, treat it as a Wild Magic Surge, as though you were a Sorcerer with the Wild Magic Sorcerous Origin. If you are a Sorcerer, you get a Wild Magic Surge on a roll of 1 or 2.","4 Silver"),
        GoatsMilk("Goat's Milk","White","Fresh goat's milk. What more could you want (except an actual drink)? Somewhere along the line of your order, the bartender confused your order with that of a travelling monk, a strict teetotaller.","Your bones feel enriched from the calcium in the drink. Your mother is proud of you for making the right choice. The bartender happily collects your money"," 5 copper"),
        ZozoJuice("Zozo Juice","Fiery red drink with thick orange bubbles that almost make it appear molten in nature.","A drink that's more like cogulated blood than an ale considering how thick it is. Bubbles crawl slowly to the surface through its sanguine blood-like depths. It is an extremely spicy drink that makes it almost unbearable to consume. Only an idiot would think its a good idea to try drink this. Is also extremely flammable to the point that water and suffocation won't be able to put it out. The only way to disperse the fire is by dispelling it. Drink and use with caution. There is a reason it is used to end drinking contests that have gone on for to long","To drink it successfully requires a Constitution Save DC of 18. Failure to meet this immediately puts the consumer into a state of complete agony. Both unsuccessful and successful drinkers also end up with a burned tongue and won't be able to taste anything for 1d4 days. Anyone who fails becomes stunned for the next 1d6 mintues","5 Gold"),
        DrunkenUncle("Drunken Uncle","Thick, dark brown stout, approximately the thickness of eggnog","Tasty, mouth-coating, drink that tends to remind the consumer of fond family gatherings.","Anyone who consumes this must make a constitution check of DC 13: on a failure, the PC must reveal one of their deepest, darkest secrets, or must tell an extremely inappropriate/embarrassing story. If the PC continues to drink the drink, increase DC by one for each pint consumed.","3 Silver"),
        FlavouredWater("Flavoured Water","Clear","This water refreshes people quicker than normal water (according to the glass), and tastes like a magically amplified version of the flavor they are thinking of"," ","2 Gold"),
        JailhouseWine("Jailhouse Wine","A violent orange colour mixed with streaks of deep red","Made by a former convict, has a strong sugary and fruity flavour that borders on the sensation of fermentation that hits you hard and hits you fast."," DC 5 con save, failure results in confessing to any small crimes they have knowingly commited.","1 Copper"),
        DwarvenDrought("Dwarven Drought","Nut Brown","Served in a deep heavy tankard, the musty oak-ish odor is inviting to few but those with the affinity to damp basements. Meant to fill the void of the deep dark caverns, brewed with only the finest dwarven barley this is a strong beer for the strong willed.","If drunk while negotiating with dwarves gives you a plus one to rolls for the negotiation checks.","5 Copper"),
        MeatyMead("Meaty Mead","Mustard Yellow","Sweeter than the desert this mead is thick enough to hold up the spoon that harvested the honey that made it. Good luck to anyone who drinks many of these devilish treats."," ","2 Copper"),
        HeartoftheHalls("Heart of the Halls","Clear","Distilled from only the most select yellow mould, this sharp-tongued spirit brings vigor and life to any looking for a good fight.","Gives you 1 luck point if you do not have one, which can be used to reroll an attack in a tavern brawl within the next 10 minutues.","1 Gold"),
        Bluenose("Bluenose","Blue","This ethereal drink glows softly and emits a light mist. Light, clear and almost flavorless the drink itself is merely a means to delight in the wonderful vapors from the mist.","Your nose turns blue, if it was already blue it glows blue. It also eliminates overpowering smells from being distracting for the next 15 minutes.","5 Silver"),
        LoversKiss("Lover's Kiss","Light pink with tiny shards of white throughout","A highly addictive drink as it makes the consumer believe they are kissing their lover with each sip. Can work on those who are single too. Be careful when consuming though as it encourages drinkers to forget their surroundings and to indulge in intimate acts. Has resulted in many being caught publicly masturbating and making a fool of themselves, only to wind up in jail somewhere."," The consumer makes a Constitution or Wisdom DC 10 roll. If they fail, they partake in ludicrous acts of self love, or if in the company of someone they desire, proceed to try and indulge them in their fantasies. If they succeed, they feel the desire to do these urges but retain their control and will, leaving it up to the player to decide if they give into them.","25 Silver"),
        CrazyAlsGnomishKnockOutLager("Crazy Al's Gnomish Knock-Out Lager","A transparent, greenish liquid that constantly bubbles.","An infamous Gnomish brew known for requiring a waiver to be signed, absolving the tavern and brewer of any damage and/or loss of life before it can be served. It comes in a black bottle, with multiple warning signs written in Common, Gnomish, and Dwarvish. Tastes absolutely foul, was said to be an old sleep aid.","Upon consumption, the drinker must immediately make a DC 15 Constitution save.  If the drinker fails the save, the imbiber is knocked unconscious for 2d6 hours. Upon regaining consciousness, the character has Disadvantage on all ability score checks, skill rolls, and saves until two long rests have been spent. Should the drinker roll","10 Gold"),
        AngryTomsFuriousAle("Angry Tom's Furious Ale","A dark amber / brown butter with a thick, creamy taupe coloured head.","A traditionally brewed, thick, dark ale in which black peppercorns are added to the mash and brewed to 4.2% abv. It is rich, peppery, and not at all infuriating.","Temporarily puts you under the affects of a barbarians rage, which ends before you can take an action","5 Copper"),
        StrawberrySurprise("Strawberry Surprise","A light pink","Surprise! There ain't no strawberries in this drink, Strawberry Surprise, even though rosy in color, is actually mead made with the liquid from very hot peppers. It is made by brewers and sold to people who want to play tricks on their friends, or teach someone a lesson.","Roll an unmodified d20, if a 10 or lower was rolled they immediately grab a drink or drinks to stop heat","25 Gold per bottle, or 5 Gold per glass"),
        ThePepperbox("The Pepperbox","Light smoke-gray","This drink is made in summer from Aurochs milk mixed with 6 different kinds of peppers, which is then left to ferment until winter. It has a strong, unsavory taste and his explosively hot for the throat even if you drink it cold.","More than just making people piss drunk, it also helps to fight symptoms of cold and flu. PCs who keep a flask of this can drink it to have Advantage on its next saving throw against cold environmental effects.","3 Copper"),
        GoatsPiss("Goat's Piss","Yellow","The barkeep is tried of complaints about how the drinks taste. This has been added as a challenge for anyone who complains.","You must roll a constitution save of DC 15 to not get sick from the drink. If you fail you're nauseous, what were you thinking. Pass or fail there is no winning you drank piss... literla piss","Free"),
        TheMindsEye("The Mind's Eye","A purplish blue liquid that sparkles and swirls like a galaxy","Staring at it is almost hypnotising. Its flavour is distinctly something magical but you can't quite put your finger on what it might possibly be. The flavour changes and dances across your tongue as your mind begins to peel open, revealing what was once lost to you. One of the few alcoholic drinks to actually make you feel and be smarter upon consumption. This drink is banned during trivia nights","You begin shooting off random facts for the next 1d6 minutes.","20 Silver"),
        PixiePiss("Pixie Piss","A swirling myriad of rainbows","Rainbows! Rainbows everywhere! This colourful drink is as much a pleasure to indulge as it is to look at.","Makes you feel funny. The consumer finds it very easy to laugh. Great to use around people who can't tell good jokes. Also, if you drink enough of it, you'll find yourself levitating slightly. It's not enough to quell fall damage but it brings that feeling of walking on air while hovering off the ground a few inches."," 1 Gold"),
        Morgsmagnificentmeed("Morg's magnificent meed","A thick gold","A magically imbued Mead, created by the bards guild. Often brewed for Royalty and Nobility, who embrace magic.","When drunk you are under the affects of the heroism spell, unless you are immune to charms, or poison","50 Gold per bottle (contains 4 drinks) Limited circulation"),
        Elvenbattlespirit("Elven battle spirit","Clear","Believed to contain the spirits of ancient warriors, consumed to gain those warrior's courage","While negotiating with elves, if this is drunk you gain +1 on rolls for the negotiation","5 Gold"),
        Gregorysgroovygrog("Gregory's groovy grog","Mostly clear with a light brown hue","Made with a mix of Dwarven Whisky, even Brandy, and fresh lemons. Captain Gregory created this tasty drink, to serve to his crew. This drink will keep for months, making it perfect for a long voyage. Often part of a sailor's rations."," ","5 Gold"),
        TheRedheadedHarlot("The Redheaded Harlot","Deep amber red and thick like blood","A shot of named after the taverns best lady of the evening. It is made from fermented berries, Tree Ent Root. The rim of the flagon or glass is also coated in honey and dipped in a red sweet powder that is to be licked before pounding down the drink.","All who drink this get Advantage on Charisma skill checks/saves toward the potential partners while in the tavern.","5 Gold"),
        RedRibbonRunsRed("Red Ribbon Runs Red","A light red that turns darker the deeper into the glass it goes","A mixture of something between rosewater and wine. The more you drink, the heavier the taste becomes.","Turns the consumer's hair and clothes different shades of red for up to 1d6 hours.","5 Silver"),
        TheDwarvenHammer("The Dwarven Hammer","Black at the bottom, but gold at the top","A mixture of strong, bitter ales, dark rum, and coffee. Most people put raw sugar on top of the foam to get a \"spark\" effect","Male consumers will find their beard grows an inch for each mug taken in, while female consumers will feel their hair getting thicker and longer. Effect wears off after an hour.","10 Copper"),
        HarpysScream("Harpy's Scream","light gray"," It tastes a little bit bitter at first, but once you swallow it, it becomes sweet... and then spicy. Very spicy.","Once the drink turns \"spicy\", the PC must roll an 11 or higher on an unmodified d20 in order to keep themselves from screaming. If you are successful you cannot speak for the next 1d4 mintues, or you will scream ","15 Copper"),
        GreenFey("Green Fey","Lime Green","Made from the wormwood root but not sweetened like liquors. Its an acquired taste","You start to turn ever so slightly green. If you are fey in anyway you skin starts to appear bark-like as well while drinking it.","1 Silver"),
        TheBeveridgeBrew("The Beveridge Brew","Dark brown","Made by the finest brewers in all the land, the Beveridge Brew has the initial taste of joy and happiness, but an aftertaste that reflects the texture and taste of dirt.","Sends the drinking into a dream( unknown to the player ) were something really great happens to the character. After the effect wear off the character notices that it was just a dream, and most likely throws up from the taste of dirt.","5 Gold"),
        FuzzyNight("Fuzzy Night","Opaque Purple","A thick liquid that has a sweet taste, but has a slightly bitter aftertaste. Many patrons enjoy it with a spoonful of honey mixed in to cut the aftertaste.","After drinking a single mug, the events of the evening will be forgotten the next time the character takes a long rest, unless they succeed at a DC 8 Constitution saving throw. For each additional mug after the first, increase the DC by 2.","15 Copper"),
        Gutbuster("Gutbuster","Dark brown","A thick dwarven brew, very rarely shared with non-dwarves.","After drinking this brew, if you are not a dwarf you are poisoned for the next 1d4 hours","5 Gold"),
        BrimstoneBrew("Brimstone Brew","Swirl of Orange and Red, glowing","This odd liquid is a constantly swirling mass of orange and red, and has a faint glow to it. The brew carries a slight odor of sulphur, and is warm on the tongue.","After drinking the brew, the character must make a DC 8 Constitution saving throw or hear an unintelligible whispering plague them. However, Warlocks however hear their masters.","5 Gold"),
        AngelTea("Angel Tea","A healthy amber with leaves of mint stirred throughout","A pleasant herbal tea constructed from various plants and resources. Mint, lavender, honey, chamomile, sugar - plus other ingredients that make your whole body feel silky and smooth."," ","3 Gold"),
        TheGhillainSpecial("The Ghillain Special","A dark beer served with a skewer of bacon and pickles","A tall glass broth served with a kebab of pickles and bacon staked through it. The combination of beer served with the sides makes it a flavour combination to behold, mixing sour, sweet and savory all into one.","","7 Silver"),
        GutShaker("Gut Shaker","Yellow-brown, lots of body","Made from fermented goat's milk and a proprietary blend of psychoactive deep mushrooms, this dwarven brew preferred by Battleragers is not for the faint of heart or stomach. It tastes like a mixture of hangover bile and someone punching you in the face repeatedly with a spiked gauntlet.","Its said to cure the worst hangovers imaginable, even those produced by the Hangmans Noose drink according to those selling it.","3 Silver"),
        HopSkipNaked("Hop, Skip, & Go Naked","Light green","A strong Mead that has a very high alcohol content. Brewed from the best barley, hops, and herbs in the land. Is known to get the local townsfolk to do things they normally might not do with just one goblet. Hence the name.","This often leads to a night of Carousing and shenanigans. Which is up to the GM, a Carousing table is recommended.","20 Silver"),
        SeaShanty("Sea Shanty","Aqua blue, almost azure","The drink swirls constantly in the glass, tugged downward like a whirlpool. This constant animation makes it a little annoying to consume as it is prone to spill.","You can breathe underwater for approximately 1 minute. The lower you constitution the longer the affect.","1 Gold"),
        BloodyMedusa("Bloody Medusa","Thick and red as blood but with green-ish swirls. Served with a green snake's head on the rim.","For some this is a great pick me up drink and for others, down right offensive.","Makes the drinker feel stiff, and their feet feel stone like while drinking this","2 Gold"),
        MerchantsLuckyDay("Merchant's Lucky Day","A simmering brown with tiny golden flecks swirling throughout its depths","The drink tastes almost like copper, like you'd been licking coins or pipes all day long. The metallic aftertaste however slowly begins to whittle down the more you drink of it, and eventually becomes something enjoyable.","This drink helps the consumer think of a new start up business.","10 Gold"),
        Butterbeer("Butterbeer","A buttery brown drink with a creamy foaming top","Foaming, smooth to taste with enough kick to keep itself interesting. A popular purchase among novice drinkers.","The consumer feels a little more alert and sociable.","5 Copper"),
        Cthulhubrew("Cthulhubrew","A slimy green color and thick like syrup.","No one knows where this concoction comes from or what exactly it is made from. Strange monks in hooded robes deliver the drink by nightfall and give it at a highly discounted rate. Some say that drinking enough of it not only does the desired effects of alcohol but also enlightens their brain chemistry to a high state. The taste of it is like Licorice or Absynth","The consumer beleives they have telekinesis but has only gained the ability to hear their own thoughts","20 Copper"),
        FireBall("Fire Ball","Fiery Red","Have you ever wondered what hell fire would taste like? Then fireball is for you! Tastes like bacon...","After consuming what seems like fire in liquid form, you can heat anything spicy without issue for the next 2 hours.","9 Silver per Shot"),
        HellfireWhisky("Hellfire Whisky","Deep Dark Red","It is said that Hades himself came up with this drink as a way to get himself drunk. Primarily Tastes of Strong Whisky and Lots of Cinnamon.","You immediately feel bad for anything considered a sin, which is released by smoke coming out of you (your ears if you are lucky), and then small burp hellfire.","5 gold per Shot"),
        TamaranianTanquerayZorkaberryTonic("Tamaranian Tanqueray & Zorkaberry Tonic","Cherry red with Purple swirls and glowing green fruit","An extremely rare drink, obtained by a group of Spelljamming adventurers. Fruity taste.","You can temporarily feel magic in and out of you","10 Gold"),
        OneBeertoRuleThemAll("One Beer to Rule Them All","A clear liquid but when held to heat, elven writing appears as fiery wisps throughout the drink","A common drink for adventures after a long journey. A beer that goes down smooth even when the adventure might not of.","This drink makes the recent passing of others feel easier","8 Silver a Pint"),
        TheMindflayer("The Mindflayer","Blueish Purple","Brewed with the sole intent of forgetting whatever trouble you may cause under it's influence.","Helps the user forget something they do not wish to rememeber due to regret.","1 Gold per shot"),
        Absinthe("Absinthe ","highly alcoholic green","Anise-flavored beverage derived from wormwood and other botanical. At one point, this drink was favored by artists and writers as a chemical in absinthe was said to have caused hallucinations."," ","1 Gold for a pint."),
        Cider("Cider","dark amber","An alcoholic beverage made from fermenting apples. Sometimes cider can be bought spiced, usually in the winter.","","1 Silver per Glass"),
        CiderGoldenOrchard("Cider, Golden Orchard ","dark amber","Golden Orchard cider is a famous spiced cider popular with halflings."," ","1 Gold per drink"),
        DragonSwirl("Dragon Swirl","This iridescent drink swirls with a mixture of gold, silver and red hues.","A strong drink known for its hoppy taste","Whether you take a small sip or a large gulp, you must make a DC 15 Constitution saving throw. On a failed save, you pass out drunk. On a successful save, the DC increases by 2 for every subsequent drink until you fail your save. You remain passed out for a number of hours equal to the number of drinks you took + the difference between the save DC and your failed roll.","1 Gold per mug."),
        DwarvishAle("Dwarvish Ale","Golden","A traditional Dwarvish drink after a hard day's work in the mines, this ale is both refreshing and sustaining. While it is not reliably found in taverns that are not Dwarf-owned of at least Dwarf-themed, it is nonetheless a must-have for a strong Dwarf."," ","5 Silver per Mug"),
        FireDrink("Fire Drink","Orange","Orange slightly alcoholic drink set on fire that bubbles. You can drink the fire too if you are tough. The fire hurts. Some use this for testing each other's toughness. It really is not good tasting. Dwarves and orcs like it.","When you drink this, you have to make DC 10 constitution saving throw. if fails, you take 1 fire damage.","9 Silver per glass"),
        FireberryAle("Fireberry Ale","Amber","A fiery drink, made in the far north, in the frozen wastes"," ","1 Silver per mug"),
        GinNorthIsle("Gin, North Isle ","","North Isle Gin is a special type of gin infused with North Isle Mint and other botanical.","","2 Gold per Glass"),
        Kefir("Kefir","Golden","A slightly alcoholic drink, kefir is milk fermented with grains. It has the consistency of thin yogurt and a sour taste.","","1 Silver per cup"),
        Mead("Mead ","purple","Elderberries, blueberries, hibiscus flowers, and beetroot can all produce a purple color used to make the mead make for a purplish, but delicious mead."," ","5 silver per mug."),
        MeadSpiced("Mead, Spiced ","Orange","This mead has several warming spices infused with it: popular during the winter.","","1 Silver per Shot"),
        TheFlamingDragon("The Flaming Dragon","redish orange","A rather spicy beer","Causes the drinker to breathe fire when they burp.","1 Gold per mug"),
        TheBansheesBreath("The Banshee's Breath","white","swirling liquor made from a special translucent wild berry. Tastes sweet, has an effect similar to mint gum in that it always feels cold.","","1 Gold per mug"),
        TheMountainsBounty("The Mountain's Bounty","","A fine liquor made using water from a glacial stream. Always refreshing, and always makes you feel cold no mater the weather.","You feel cold no mater the weather, and shiver for the next 1d4 minutes.",""),
        Mawxie("Mawxie","black","A drink all the locals cite as a local treasure. Tastes disgusting."," ","1 copper per shot"),
        BogGrog("Bog Grog","light orange","A mix of Rum, Orange Juice and fermented herbs"," ","5 Silver per mug"),
        FrostMead("Frost Mead","","Honey and the tear of an Ice Giant make this shot. ","You have crackling blue sparkle and icy breath","2 Gold per shot"),
        WeatherbeesWhirler("Weatherbee’s Whirler","dark brown","Invented by the perhaps too inventive Filbus Weatherbee, this drink is testimony as to why it is a bad idea to point a gnome’s sharp mind towards the creation of a new brew. After spending many years living among the dwarves, Weatherbee made his way home with a drink even the stout folk couldn’t handle. This monstrosity is laced with latent magic designed to lessen the chance of drinkers dying from its ungodly alcohol content, and reportedly tastes like “A kick in the face from a horse.” After one shot of this drink, the drinker is shunted into a chaotic haze of blurry awareness, bolstered confidence, and overpowering drunkenness. In addition, the latent magic in the brew causes minor, uncontrolled magical effects to occur around the drinker at random times during the haze. The nature of these effects is up to either the DM or the player, so long as the effects are sufficiently insignificant.","After 1d4 hours, the haze drops away and the drinker immediately and almost violently falls into a deep sleep so that they may recover.","3 Gold per mug"),
        TheQuieker("The Quieker","Clear","A classic silver rum, that is also called the helium of drinks amongst alchemists","nasty rum that gives a high pitched voice for 1d4 hours."," 5 Silver per mug"),
        FaerieFireball("Faerie Fireball","rich caramel-like color","a delicious cinnamon whiskey made with a touch of Fey magic.","Causes uncontrollable hiccups for 1d4 hours. With each hiccup a small cloud of shimmering breath is released.","8 Silver per mug"),
        LilyinaWell("Lily in a Well","clear","a tall mug of ale, half full with an edible flower garnish.","","3 Gold per mug"),
        HammerBeer("Hammer Beer","same color as to that of a blonde ale","One glass will make you feel like you just hit yourself with a hammer. Typically drank between carpenters to see who can \"out man one another\" ","lose one hp","2 Silver per mug"),
        TheSunsGlory("The Sun's Glory","bright orange","A citrusy cider that makes your eyes glow like an Aasimar.","Your eyes begin to glow like an Aasimar for 1d4 minutes. If you are an Aasimar this amplifies the affect and lastes for 1d6 minutes","8 Silver per mug"),
        BlackMidnight("Black Midnight","deep dark brown","A bitter brew created by those who practice dark magic. It is beleived it helps connect oneself to the darker magics of the world."," ","4 Gold per mug"),
        ThePhoenix("The Phoenix","bright orange"," A peppery drink that burns on the way down, and then again on the way out. It is often used as a prank on drunk companions, who have a nasty surprise waiting for them the next time they go to relieve themselves.","Takes 2d6 minutes longer to get ready after a long rest.","5 Silver"),
        HairoftheBloodhound("Hair of the Bloodhound","A creamy tan","A nice refreshing drink that goes down easy","Once you have become intoxicated on this brew, you gain the usual drawbacks of drunkenness but change the typical disadvantage on survival checks to advantage.","4 Gold per mug"),
        SeersSolution("Seer's Solution","greenish yellow","A slimy shot that does nothing the first two times you take it.","After your third shot of this brew you are guaranteed to be drunk but have truesight for 1 minute, The fourth and subsequent shots give the drinker horrible audio/visual hallucinations for 1d4+2 hours and cannot sober up until the number of shots taken is 0 (zero). Counter resets at dawn.","5 gold per shot"),
        SpidersBite("Spider's Bite","dark green","Some species do not feel the affect of alcohol, so to join in on the fun drink this.","DC 12 con saving throw take 1d8 poison damage","5 gold per shot"),
        TheFortnight("The Fortnight","Clear","Very strong alcohol. If you actually drink enough to get drunk, you stay hammered for days.","For every drink you have had roll a d8. The total is number of hours you are drunk","2 gold per mug"),
        TwoCouplesinaSharedHousehold("2 Couples in a Shared Household","dark carmel","Two different types of hot tea, 2 of each, into one mug.","","1 Gold"),
        SuckerPunchingaRabbit("Sucker Punching a Rabbit","creamy yellow","Whiskey sour served in a small animal skin,"," ","15 Silver"),
        BuriedTreasure("Buried Treasure","light tan","A single, very sweet, rather expensive hard candy is stuck to the bottom of a mug of very hard liqour. Once you've drunk it all, you get a spoon to pull it off with.","","5 gold"),
        Ouch("Ouch","light yellow","Two full shots worth of lemon juice put into a glass of very high proof alcohol.","","5 Silver"),
        WhatwasISaying("What was I Saying?","light red","An unassuming shot of very strong alcohol, with a cherry in it, usually taken in the middle of a conversation, which is promptly ended.","","5 Silver"),
        ActualTorture("Actual Torture","light orange","2 Teaspoons of salt which are to be eaten all at once. Then washed down with a citrus based liquor. If anyone else offers any drinks, their hands are free game for attack.","","3 Sliver"),
        TheGreenKobold("The Green Kobold","clear","The first drink to ever be served in a piece of ham, with the skin. 1 shot of herbal liquor wrapped in ham. To be eater all at once. Probably fixed in place with at least 1 pin, make sure you pick it out before you eat it."," ","3 Silver"),
        EndoftheLine("End of the Line","light brown","Very high quality, rather expensive alcohol made for a drinking game. Flip a coin loser has to take the drink, repeat until someone pass out.","","3 Gold"),
        TrafficStop("Traffic Stop","green yellow and red","Invented by a Diviner. Whenever a fight seems to be brewing, everyone orders a traffic stop. It's a mug of 3 separate liquors that stay separated in their mug, all very strong.The goal is to drink it all before the local police forces arrive.","","1 Gold"),
        DragonMilk("Dragon Milk","white","not really milk, or related to dragons. It's an expensive white drink, resembling milk that removes any alcohol in your body. As a result you exhale fire in the form of a single burp, resembling a dragon. Usually asked to be finished outside.","Reducuce the number of failed drink saves by 1","1 Gold"),
        TheNecromancer("The Necromancer","green glowing liquid","A drink for those who fall unconscious from alcohol. Also known as the 'Corpse Reviver'. when poured into the unconscious persons mouth he/she gets up and walks in a way similar to a zombie. Helps making the tavern cleaner easier","Zombie like state causing drinker to walk around if the drinker was not conscious","5 Silver (or lose change adding to ~5 Silver)"),
        Beholder("Beholder","white","A sweet liquor decorated with an eye or multiple smaller ones.","Feels like normal alcohol but gives the person a (false of course) feeling he/she has multiple eyes after drinking enough of it","5 Silver"),
        Elysium("Elysium","black and bubbly","A nonalcoholic drink that smells and looks as bad as it tastes. Some compared it to trash, vomit or even excrement but only because they couldn't find the adequate foul words. Most refuse to look at it, let alone allow it to come close to their nose. Only those with the strongest will manage to gulp it down. ","Once drunk, the person experiences true bliss, which seems to last for hours. In reality it's a few seconds.","5 Copper"),
        NineSteps("Nine Steps","dark red","commonly known as 'The Niner' or by it's full name 'Nine Steps to Hell'. It is a liquid that when left to settle separates into 9 parts, the bottom one being pure black and the top a beautiful red with a gradient in between.","After drinking it the person seems frozen for a few seconds, but to the person who gulpes it down it feels like days, weeks, maybe even months of 9 different experiences, all basically a form of torture. Often used as a torture method but sometimes drunk to prove ones mental strength, as those that can't endure it go insane. The niner is a rare drink because it's extremely hard to make.","7 gold"),
        HoneyPineDew("Honey Pine Dew","amber","An imported halfling mead, served in small cups. Very pleasant taste, cheap in halfling towns, but expensive elsewhere.","","5 Silver - 3 Gold"),
        CubedSpirit("Cubed Spirit","clear","This drink is served as a hollow ice cube with liquid spirit within. As the ice melts in your mouth the drink will come out. How exactly this novelty drink is produced, is a well kept secret."," ","1 Gold"),
        MilkyWayWhisky("Milky Way Whisky","light blue","tastes like very watered down, sweetened milk with a lot of alcohol. Besides giving a quick buzz.","It also gives bone, and thus teeth, a blue fluorescent glow for 1d4 hours.","8 Silver"),
        TrueDwarvenStout("True Dwarven Stout","dark brown","A strong drink, not recommended if you cannot handle your alcohol. Traditionally served on the rocks, literally. There are pieces of stone lying on the bottom of your drink. Said to give the true mining flavor. This drink will make any dwarve feel very nostalgic.","","1 Gold per (dwarf sized) mug"),
        PetraliasWine("Petralias Wine","light yellow","A very expensive wine that is served as a single droplet. It does nothing for thirst or getting drunk, bit the flavor is said to be very concentrated and the lack of drink quantity should make the experience richer. Typically ordered by very pretentious people.","","2 Gold per drop"),
        GoldenGoat("Golden Goat","white","Fermented goat milk and honey."," "," 3 Silver"),
        StarLiquid("Star Liquid","a magically strong black","A really black drink resembling the night sky.","If you drink it you experience a wonderful journey trough the stars for 1 min."," 8 Silver"),
        PolymorphicBrew ("Polymorphic Brew","swirls of multiple colors","The drink of magic drinking games","Commonly used in drinking games, this brew will turn the user into an animal when they burp. They turn back about a minute later.",""),
        InsomsAle("Insom's Ale","carmel color","Was used a sleep aid, until it was discovered you could get pretty drunk off it, and then made a lot money at bars.","To wake up before a long rest ends it is a DC 15 charisma check","5 Silver"),
        LilphinasLustyLoverLiquidLiquor("Lilphina’s Lusty Lover Liquid Liquor","The bottle comes in two parts, with each part having a different hue of color depending on the flavor.","the drink that will let you walk a mile in someone else's shoes","When two people within 10 feet of each other consume the drink within 5 minutes of one another, their minds are swapped for 1 hour. This does swap mental stats (int wis, chr)","100 Gold per bottle"),
        PinaColossus("Piña Colossus","light cream color","a rare colossal pineapple hollowed out and filled with rum, coconut cream, and pineapple juice. Usually a shared drink. The pineapple shrinks in size when the liquid is drank or spilled. It will also continue to expand and grow to colossal proportions the more liquid that is added."," "," 4 Gold"),
        Belchingrum("Belching rum","dark carmel","A nice spiced rum loved by pirates, and hated by bar keeps","After drinking this make a DC 12 con save. On a failed save the effect takes place immediately. On a success you choose when to have the effect take place (After ten minutes the effect takes place no matter what.) Effect: You belch thunderously. Everyone in a 100 foot radius is deafened for one round.","6 Gold"),
        TheTitansbrew("The Titans brew","rich yellow","A regular tasting ale served in an enormous cup","After drinking this you are 1d4 inches taller for the next 1d6 minutes.","2 Gold"),
        PaladinsBane("Paladin’s Bane","bright yellow","sweet enough to tempt the righteous and you hardly taste the alcohol"," ","6 Silver"),
        GoodberryGin("Goodberry Gin","light purple","if you drink enough of it, it works as a mild healing potion which may or may not compensate for the damage done to your liver or you falling down the stairs while drunk","Drink is less strong than a typical Gin, reducing its DC easier","1 Gold"),
        WillotheWhiskey("Will-o-the-Whiskey","light brown","A whiskey that is there to brighten up your day.","whisky with minor hallucinatory effects, starts with a tiny tingling light in the corner of your eyes, ends with a shining orb of light dancing a few yards away from you, moving away as you try to catch it.","4 Silver"),
        MandrakeMocha("Mandrake Mocha","creamy tan","","a hot creamy beverage with a narcotic effect. Dulls the pain, leads you into a deep slumber.","1 Gold"),
        OchreStout("Ochre Stout","varies","a cheap drink so thick you can taste chunks in it. Best to swallow and not be curious."," ","3 copper"),
        TheDrunkenDwarf("The Drunken Dwarf","dark Brown","a pint of dwarven stout with a teabag in it."," ","2 Gold"),
        ForlocaldeitysSake("For the Gods Sake","dark yellow","a local sake or rice wine for the area's god/goddess, popular with priests.","Drinking this while around people of that religion treat you more friendly","2 Silver"),
        Ciderella("Ciderella","dark carmel","a sweet apple cider, considered “a girls drink”. Even the toughest bloke will begin giggling like a little girl after a few drinks.","DC 18 con save, failure results in sporadic giggles for the next 2d6 minutes.","5 Silver"),
        Jalapalinka("Jalapálinka","redish yellow","A fruit brandy spiced with hot peppers. Burns the throat, downing a pitcher leads to steam escaping ears and nostrils.","DC 14 con save, failure results in steam escaping your ears and nostrils","4 Silver"),
        GingerAle("Ginger Ale","warm red","Nothing like a nice ginger ale that would make Odin proud","this doesn’t taste like ginger at all... An ale that turns your hair ginger, effect lasts for 1d6 days.","2 Gold"),
        TheMaidensAss("The Maiden’s Ass","dark brown","a quadrupel beer, served in a bottle with a donkey and a pretty girl on the label. Sweet but strong."," ","1 Gold"),
        BockBear("Bock Bear","dark brown","A thick and strong drink for only the toughest of the tough!","a bock beer that gives you +1 Str and extra body hair for 2d6 minutes.","5 Gold"),
        Polypilsener("Polypilsener","a rich blue","","turns you into a canary for 1d4 minutes. Drinking half a mug will turn you halfway into a canary.","3 Gold"),
        OurThoughtsandPrayers("Our Thoughts and Prayers","dark carmel","a nice brandy to have amongst friends, that makes you feel nice and comfortable.","a brandy that works as a reverse Detect Thoughts spell; surrounding people learn your surface thoughts, although you’re unaware of it. Range increases with 2ft each glass, though your thoughts don’t exactly get more coherent.","2 Gold"),
        Smirgnome("Smirgnome","clear","a vodka that fills your brain with the weirdest ideas, although the morning after you’ll likely have no memory of inventing a sunlight-storing clockwork pigeon to hunt vampires with.","When you wake up you are down 1d10 gold and have some design or made invention you though up by you","2 Gold"),
        AbbathorsGold("Abbathor’s Gold","a clear golden mead","A mead so good you keep coming back for 8ths","does nothing to quench your thirst - instead, you crave more of it. Roll a Charisma saving throw DC 1) after each glass; if you fail, you keep drinking. After 8 glasses you pass out for 1d10 hours.","5 Silver"),
        Coala("Coala","black","A Dwarven invention, this black bubbly drink tastes like gridded coal with sugar, but also makes you feel reinvigorated and less tired.","make a DC 18 constitution saving throw if you are a dwarf, as they are the only ones who can properly digest this. Succeeding means you lose one level of exhaustion, failing means your gonna make a nice mess of the barkeep to clean up","2 Gold"),
        TheUmberHulk("The Umber Hulk","light brown","a pint of whisky, brandy and tequila in equal measures. Good luck.","This drink is 3 times more powerful than a typical drink and counts as 3 drinks","4 Gold"),
        Bottomlesspint("Bottomless pint","dark brown","the bartender pours beer into a ceramic mug. When the patron pulls the glass up to their mouths, they realize that the mug really doesn’t have a bottom. The mug is empty, and the beer has been pour through the mug into a hole in the bar with a pitcher underneath."," ","1 Gold"),
        Brazenbrew("Brazenbrew","clear","Served in a special mug laced with bronze, the drinker is more apt to make outrageous claims of ability, but also gains the relevant luck to succeed while still under the influence.","every failed con save from drinking today gives them bonus equal to that number. Keep in mind you still are not sober.","3 Gold"),
        WitchwoodAbsinthe("Witchwood Absinthe","gray","A potent spirit the color of a moss-covered tombstone. It has mild hallucinogenic properties, and local folklore holds you can hear the voices of those you've lost if you drink enough. Not too much, though. You might join them.","DC 12 wisdom saving thow. Failure means you start to hear the voices.","1 Gold"),
        SaltyDogAle("Salty Dog Ale","clear","A dark, rich brew that reminds you of the sea. Plopping in the shell of a sea snail for good luck is customary, and adds a fitting salinity to the drink."," ","8 Silver"),
        HymvarensLuck("Hymvaren's Luck","golden","A bright, golden-colored beer named after a local drunk who woke up on the beach after a night of carousing with a chest full of pirate's treasure. He claims to have no memory of that night.","drink description was a lie, its just an over priced beer","8 Gold"),
        BourbonofDwarfkind("Bourbon of Dwarfkind","dark brown","A drink that both you and your beard will remember","If you have a beard it grows larger, if you do not but have one it starts to grow, and if you cannot grow one you still get some hairs on your chin","2 Gold"),
        WineofElvenkind("Wine of Elvenkind","light yellow","A nice bubblely wine that goes down sweet and smooth","If you are an elf your elven traits become more apparent, if you are not your ears start to look more like an elf's.","2 Gold"),
        OchreJellyAle("Ochre Jelly Ale","lime green","Ale with safe-to-drink ochre jelly mixed in it."," ","1 Gold"),
        MimicDrink("Mimic Drink","clear","Usually sold by tricksters to play pranks on people. Looks like a regular glass of water, but a tiny water elemental/water weird is disguised as normal water.","This drink fits back the drink rolls a d20 11 and higher means it deals 1 damage, otherwise misses. Initiative is rolled water has +0 and 1 hp, with an ac of 8.",""),
        LiquidNitrogen("Liquid Nitrogen","clear","Drank by frost giants and other beings that can tolerate extreme cold."," ","2 Gold"),
        Meadofinvulnerability("Mead of invulnerability","yellow","A sweet mead that tastes of honey.","Once drunk user makes a DC 15 Wisdom check. On a fail believes they are immune to all damage and if damage is dealt to them believe they did not take the damage. Effects for ten minutes. User still take all damage as normal.","5 Silver"),
        Invertedrum("Inverted rum","clear","This magic rum makes people drunk like no other rum ever.","when you drink it, every one around you in a 15 foot cube makes their drunk saving throws. This dose not include yourself.","10 Gold"),
        GoblinSpit("Goblin Spit","green","Goblin Spit - whiskey and gin mixed with the barkeep's home-made mints. It tastes surprisingly good despite its name.","As is tavern tradition, a long-distance spitting competition occurs after every round.","3 Silver"),
        TheHookLineandSlider("The Hook, line and Slider","yellow","a cooked (goat) intestine tied and filled with a heavy beer. After finishing the beer chow on the intensive. Its a meal and drink all in one"," ","3 Gold"),
        LuckyLeprechaun("Lucky Leprechaun","sickly green","A drink that makes you feel like you got the pot of gold on the other side of the rainbow"," ","1 Gold"),
        TheTiamat("The Tiamat","multicolored"," 5 different shots, one for each color of the different heads. One is black and syrupy, one blue and gives tingly feeling, one is on fire, one is green and tastes a bit minty, the last is white and frosts the closest things. They are mixed together and separate in the cup making a very nice presentation.","5 times the shots means its 5 times as strong."," 3 Gold"),
        TheSweetRoll("The Sweet Roll","carmel","flavors of cinnamon and sugar blend with the strong scent of rum."," ","8 Silver"),
        TheSailorsSpirit("The Sailor's Spirit","Silver","There once was a cap' and a crew, Who made the most wonderful brew, From rations of lime, They would in their spare time, Make fine drinks no man could outdo."," ","5 Silver"),
        GoodHearthsBrew("Good Hearth's Brew","","A hot spiced rum which is popular during long winter nights for the immediate feeling of warmth and calm that follows."," ","5 Silver"),
        Tarnation("Tarnation","dark yellow","A strong spiced cider served warm and traditionally drank as quickly as possible after a boisterous cheer or a lewd drinking song.","you belch a small flame right after ingesting."," 2 Gold"),
        EtherealAle("Ethereal Ale","clear","A drink that will make you feel out of this relm","The more intoxicated you get, the more you fade into the ethereal plane. First you become slightly transparent, than objects start to phase through you from time to time","10 Gold"),
        ;

        final String name;
        final String color;
        final String description;
        final String effect;
        final String cost;

        Drinks(String name, String color, String description, String effect, String cost) {
            this.name = name;
            this.color = color;
            this.description = description;
            this.effect = effect;
            this.cost = cost;
        }
        private static final List<randombuilding.Drinks> Drinks = Collections.unmodifiableList(Arrays.asList(randombuilding.Drinks.values()));
        private static final int drinksize = Drinks.size();

    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        if(event.getName().equals("randombuilding")){
            //Drinking rules
            //Spellcasting
            //To cast a spell, make a DC 10 Constitution saving throw or the spell fails. The spell is not wasted. A short rest removes one level of inebriation; a long rest removes all effects of inebriation.
            //When enough liquid courage is imbibed make a DC 10 (+ 1 per drink) Constitution saving throw or advance one level of inebriation. Stronger drinks can make the DC harder (GM digression) Effects of inebriation are cumulative.
            // The number of failures to get imbibed is equal to your con modifier. Each failure afterward increases the level by 1.
            //Level	Effect
            //1	Disadvantage on Persuasion and Deception; Advantage against Frightened (Inebriated condition)
            //2	Disadvantage on Saving Throws (Drunk condition)
            //3	Disadvantage on Ability Checks Cannot dash or move more than 10′ in the same direction (Wasted condition)
            //4	Become Unconscious
            //Wasted creatures
            //Must make a Constitution saving throw at once an hour while awake or spend one minute vomiting. While vomiting, you cannot perform any other actions and automatically fail all saving throws.
            //Must make a Constitution saving throw to gain any benefit from a long rest; if failed, you do not gain any benefits.

            OptionMapping numberofbuildingsMapping = event.getOption("number");
            OptionMapping buildingtypeMapping = event.getOption("building");

            int numberofbuildings = numberofbuildingsMapping == null ? 1 : numberofbuildingsMapping.getAsInt();
            final String buildingtype = buildingtypeMapping == null ? randomBuilding() : buildingtypeMapping.getAsString();

            if(numberofbuildings <= 0){numberofbuildings = 1;}

            event.deferReply(true).queue();

            for (int i = 0; i < numberofbuildings; i++) {
                switch (buildingtype){
                    case "Residence" : event.getHook().sendMessage(residence()).setEphemeral(true).complete();
                        break;
                    case "Religous"  : event.getHook().sendMessage(religious()).setEphemeral(true).complete();
                        break;
                    case "Tavern"    :
                        Random randomvalue = new Random();
                        StringBuilder builder = new StringBuilder();
                        StringBuilder buildertwo = new StringBuilder();
                        List<String> foodmessages = new ArrayList<>();
                        List<String> drinkmessages = new ArrayList<>();
                        List<String> drinks = new ArrayList<>();
                        List<String> food = new ArrayList<>();

                        int numberofdrinks = randomvalue.nextInt(12 - 1 + 1) + 1;
                        int numberoffood = 12 - numberofdrinks;

                        event.getHook().sendMessage(tavern() + "\n").setEphemeral(true).complete();
                        event.getHook().sendMessage("# Services:\n" + tavernservices().toString().replace("[","").replace("]","") + "\n").setEphemeral(true).complete();
                        event.getHook().sendMessage("# Food Menu:\n" + food.toString().replace("[","").replace("]","") + "\n").setEphemeral(true).complete();
                        for (int f = 0; f < numberoffood; f++) {
                            String fooditem = tavernfood();
                            if(!food.contains("## " + fooditem)){
                                food.add("## " + fooditem);
                            }else{
                                f = f-1; //this is for when it is in the list so it loops through correcltly
                            }
                        }
                        if(food.isEmpty()){
                            event.getHook().sendMessage("Drinks only Tavern").setEphemeral(true).queue();
                        }else {
                            Collections.sort(food); //should sort arraylist (this is not an array)
                            for (String foods : food) {
                                if (builder.length() + foods.length() + 1 > 2000)  { // +1 for the new line
                                    foodmessages.add(builder.toString()); // Store new message since length is going to exceed
                                    builder.setLength(0); // Clear builder
                                }
                                builder.append(foods).append('\n');
                            }
                            foodmessages.add(builder.toString()); // Add last message, as it was being built
                            for (String foodmessage : foodmessages) {
                                event.getHook().sendMessage(foodmessage).setEphemeral(true).complete();
                            }
                        }
                        event.getHook().sendMessage("# Drink Menu\n" + drinks.toString().replace("[","").replace("]","")).setEphemeral(true).complete();
                        for (int d = 0; d < numberofdrinks; d++) {
                            String drinkitem = tavernbeverages();
                            if(!drinks.contains("## " + drinkitem)){
                                drinks.add("## " + tavernbeverages());
                            } else {
                                d = d-1;
                            }
                        }
                        if(drinks.isEmpty()){
                            event.getHook().sendMessage("No drinks!").setEphemeral(true).queue();
                        }else {
                            Collections.sort(drinks); //should sort arraylist (this is not an array)
                            for (String drink : drinks){
                                if (buildertwo.length() + drink.length() + 1 > 2000)  { // +1 for the new line
                                    drinkmessages.add(buildertwo.toString()); // Store new message since length is going to exceed
                                    buildertwo.setLength(0); // Clear builder
                                }
                                buildertwo.append(drink).append('\n');
                            }
                            drinkmessages.add(buildertwo.toString()); // Add last message, as it was being built
                            for (String drinkmessage : drinkmessages) {
                                event.getHook().sendMessage(drinkmessage).setEphemeral(true).complete();
                            }
                        }
                        break;
                    case "Warehouse" : String warehouse = warehouse();
                        event.getHook().sendMessage( warehouse() + "\n" + warehouseGoods(warehouse)).setEphemeral(true).complete();
                        break;
                    case "Shop"      : event.getHook().sendMessage(shop()).setEphemeral(true).complete();
                        break;
                }

            }
        }
    }
    public List<String> messagesplitter(List<String> message)
    {
        // Split the role names into a list of strings each small enough to fit into a message codeblock
        // A message can be 2000 characters long, do the math (2000 - 7 = 1993 characters) but to be safe go a little lower
        List<String> blocks = SplitUtil.split(message.toString(), 1990, true, SplitUtil.Strategy.NEWLINE);
        // Then wrap each of these blocks into a codeblock for sending
        return blocks.stream()
                .map(block -> "```\n" + block + "```")
                .collect(Collectors.toList());
    }
    private static int d20(){
        Random randomnumber = new Random();
        int randomnum = randomnumber.nextInt(20 - 1 + 1) + 1;

        return randomnum;
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
            builder.append(item).append(", ");
        }
        builder.deleteCharAt(builder.length() -2); // was -2
        messages.add(builder.toString());
        for (String message : messages) {System.out.println(message);}
        return messages.toString().replace("[","").replace("]","");
    }
    private static String randomBuilding(){
        String buildingtype = "";
        int randomBuilding = d20();

        if(1 <= randomBuilding && randomBuilding <= 10){buildingtype = "Residence";}
        else if (11 <= randomBuilding && randomBuilding <= 12) {buildingtype ="Religous";}
        else if (13 <= randomBuilding && randomBuilding <= 15) {buildingtype = "Tavern";}
        else if (16 <= randomBuilding && randomBuilding <= 17) {buildingtype = "Warehouse";}
        else if (18 <= randomBuilding && randomBuilding <= 20){buildingtype = "Shop";}

        return buildingtype;
    }
    private static String residence(){
        String residence = "";

        int randomres = d20();

        switch (randomres){
            case 1,2            -> residence = "Abandoned squat";
            case 3,4,5,6,7,8    -> residence = "Middle-class home";
            case 9,10           -> residence = "Upper-class home";
            case 11,12,13,14,15 -> residence = "Crowded tenement";
            case 16,17          -> residence = "Orphanage";
            case 18             -> residence = "Hidden slavers' den";
            case 19             -> residence = "Front for a secret cult";
            case 20             -> residence = "Lavish, guarded mansion";
        }
        return residence;
    }
    private static String religious(){
        String religious = "";
        int randomrelig = d20();
        switch (randomrelig){
            case 1,2,3,4,5  -> religious = "Temple to a good deity: " + goodgod();
            case 6,7,8,9,10 -> religious = "Temple to a neutral deity: " + neutralgod();
            case 11,12      -> religious = "Temple to a false deity (run by charlatan priests)";
            case 13         -> religious = "Home of ascetics";
            case 14,15      -> religious = "Abandoned shrine";
            case 16,17      -> religious = "Library dedicated to religious study";
            case 18,19,20   -> religious = "Hidden shrine to a fiend or an evil deity: " + evilgod();
        }
        return religious;
    }
    private static String tavernnames(){
        String tavernname = "The ";
        int roll1 = d20();
        int roll2 = d20();

        switch (roll1){
            case 1  -> tavernname = tavernname + "Silver ";
            case 2  -> tavernname = tavernname + "Golden ";
            case 3  -> tavernname = tavernname + "Staggering ";
            case 4  -> tavernname = tavernname + "Laughting ";
            case 5  -> tavernname = tavernname + "Prancing ";
            case 6  -> tavernname = tavernname + "Gilded ";
            case 7  -> tavernname = tavernname + "Running ";
            case 8  -> tavernname = tavernname + "Howling ";
            case 9  -> tavernname = tavernname + "Slaughtered ";
            case 10 -> tavernname = tavernname + "Leering ";
            case 11 -> tavernname = tavernname + "Drunken ";
            case 12 -> tavernname = tavernname + "Leaping ";
            case 13 -> tavernname = tavernname + "Roaring ";
            case 14 -> tavernname = tavernname + "Frowning ";
            case 15 -> tavernname = tavernname + "Lonely ";
            case 16 -> tavernname = tavernname + "Wandering ";
            case 17 -> tavernname = tavernname + "Mysterious ";
            case 18 -> tavernname = tavernname + "Barking ";
            case 19 -> tavernname = tavernname + "Black ";
            case 20 -> tavernname = tavernname + "Gleaming ";
        }
        switch (roll2){
            case 1  -> tavernname = tavernname + "Eel";
            case 2  -> tavernname = tavernname + "Dolphin";
            case 3  -> tavernname = tavernname + "Dwarf";
            case 4  -> tavernname = tavernname + "Pegasus";
            case 5  -> tavernname = tavernname + "Pony";
            case 6  -> tavernname = tavernname + "Rose";
            case 7  -> tavernname = tavernname + "Stag";
            case 8  -> tavernname = tavernname + "Wolf";
            case 9  -> tavernname = tavernname + "Lamb";
            case 10 -> tavernname = tavernname + "Demon";
            case 11 -> tavernname = tavernname + "Goat";
            case 12 -> tavernname = tavernname + "Spirit";
            case 13 -> tavernname = tavernname + "Horde";
            case 14 -> tavernname = tavernname + "Jester";
            case 15 -> tavernname = tavernname + "Mountain";
            case 16 -> tavernname = tavernname + "Eagle";
            case 17 -> tavernname = tavernname + "Satyr";
            case 18 -> tavernname = tavernname + "Dog";
            case 19 -> tavernname = tavernname + "Spider";
            case 20 -> tavernname = tavernname + "Star";
        }

        return tavernname;
    }
    private static String tavern(){
        String tavern = "";
        int radomtavern = d20();
        switch (radomtavern){
            case 1,2,3,4,5 -> tavern = "Quiet, low-key bar called: ";
            case 6,7,8,9   -> tavern = "Raucous dive called: ";
            case 10        -> tavern = "Thieves' guild hangout called: ";
            case 11        -> tavern = "Gathering place for a secret society called: ";
            case 12,13     -> tavern = "Upper-class dining club called: ";
            case 14,15     -> tavern = "Gambling den called: ";
            case 16,17     -> tavern = "Caters to specific race or guild called: ";
            case 18        -> tavern = "Members-only dub called: ";
            case 19,20     -> tavern = "Brothel called: ";
        }
        tavern = tavern + tavernnames();

        return tavern;
    }
    public static List<String> tavernservices(){
        List<String> services = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Random randomnservice = new Random();
            int randoservice = randomnservice.nextInt(17 - 1 + 1) + 1;
            switch (randoservice){
                case 1  -> services.add("Bath");
                case 2  -> services.add("Book Rental");
                case 3  -> services.add("Dowry (Baron's Daughter)");
                case 4  -> services.add("Dowry (Esquire's Daughter)");
                case 5  -> services.add("Dowry (Peasant)");
                case 6  -> services.add("Fencing Instruction");
                case 7  -> services.add("Funeral");
                case 8  -> services.add("Instruction by a Weapon Master");
                case 9  -> services.add("Laundry");
                case 10 -> services.add("Lawyer");
                case 11 -> services.add("Luxurious Bath");
                case 12 -> services.add("News Delivery/Postal Service");
                case 13 -> services.add("Portrait");
                case 14 -> services.add("Prostitute");
                case 15 -> services.add("Weapon Training");
                case 16 -> services.add("Hirelings");
            }
        }

        return services;
    }
    public static String tavernbeverages(){
        List<String> menubeverages = new ArrayList<>();
        ArrayList <Drinks> list = new ArrayList <Drinks>();
        Random random = new Random();

        int index = random.nextInt(Drinks.Drinks.size());
        menubeverages.add(Drinks.Drinks.get(index).toString().replace("[","").replace("]",""));

        enumSet.forEach(drink -> {
            if(Objects.equals(drink.name(), menubeverages.toString().replace("[","").replace("]",""))){
                String fulldrink = "";

                menubeverages.remove(Drinks.Drinks.get(index).toString().replace("[","").replace("]",""));
                fulldrink = drink.name.toString() + " " + drink.cost + "\n" + "Drink color: " + drink.color + "\n" + drink.description + "\n\n" + drink.effect;
                menubeverages.add(fulldrink.toString().replace("[","").replace("]",""));
            }
        });

        return menubeverages.toString().replace("[","").replace("]","");
    }
    private static String tavernfood(){
        List<String> menufoods = new ArrayList<>();
        Random randomfoods = new Random();
        int randomfood = randomfoods.nextInt(38 - 1 + 1) + 1; //was 20

        int index = randomfoods.nextInt(Foods.Foods.size());
        menufoods.add(Foods.Foods.get(index).toString().replace("[","").replace("]",""));

        enumSet2.forEach(food -> {
            if(Objects.equals(food.name(), menufoods.toString().replace("[","").replace("]",""))){

                menufoods.remove(Foods.Foods.get(index).toString().replace("[","").replace("]",""));
                String fullfood = food.name.toString() + " " + food.cost + "\n" +  food.description;
                menufoods.add(fullfood.toString().replace("[","").replace("]",""));
            }
        });

        return menufoods.toString().replace("[","").replace("]","");
    }
    private static String warehouse(){
        String warehouse = "";
        int radomwarehouse = d20();
        switch (radomwarehouse){
            case 1,2,3,4     -> warehouse = "Empty or abandoned";
            case 5,6         -> warehouse = "Heavily guarded, expensive goods";
            case 7,8,9,10    -> warehouse = "Cheap goods";
            case 11,12,13,14 -> warehouse = "Bulk goods";
            case 15          -> warehouse = "Live animals";
            case 16,17       -> warehouse = "Weapons/armor";
            case 18,19       -> warehouse = "Goods from a distant land";
            case 20          -> warehouse = "Secret smuggler's den";
        }
        return warehouse;
    }
    private static List<String> warehouseGoods(String warehouse){
        List<String> goods = new ArrayList<>();

        switch (warehouse){
            case "Cheap goods" :
                goods.add("rice");
                goods.add("eggs");
                goods.add("dried fruit");
                goods.add("root vegetables");
                goods.add("cheese");
                goods.add("One salted herring");
                break;
            case "Heavily guarded, expensive goods" :
                goods.add("''maids''");
                goods.add("fine wine");
                goods.add("myrrh");
                goods.add("ginseng");
                goods.add("frankincense");
                goods.add("camphor");
                goods.add("nutmeg");
                goods.add("silk");
                goods.add("gold");
                goods.add("pottery");
                goods.add("flanders");
                goods.add("Exotic meats");
                goods.add("Marble or other luxury stone");
                break;
            case "Bulk goods":
                goods.add("coal");
                goods.add("zinc");
                goods.add("wool");
                goods.add("tallow");
                goods.add("lead");
                goods.add("fleece");
                goods.add("wax");
                goods.add("pewter");
                goods.add("cotton");
                goods.add("bronze");
                goods.add("brass");
                goods.add("root vegetables");
                goods.add("cheese");
                goods.add("tobacco");
                goods.add("sugar");
                goods.add("tea");
                goods.add("coffee");
                goods.add("mustard");
                goods.add("cheap wine");
                goods.add("Dyes");
                break;
            case "Goods from a distant land":
                goods.add("Ale's and other alcohols / drugs");
                goods.add("Animal companions or particularly bred pets");
                goods.add("Exotic meats");
                goods.add("Musical instruments");
                goods.add("Painted artwork");
                goods.add("Perfume");
                goods.add("Poisons");
                goods.add("mithral");
                goods.add("adamantine");
                goods.add("quicksilver");
                goods.add("densewood");
                goods.add("soarwood");
                break;
            case "Secret smuggler's den":
                goods.add("special tabaco");
                goods.add("drugs");
                goods.add("people");
                goods.add("illeagl animals like baby wyverns");
                goods.add("most illegal goods");
                goods.add("highly taxed goods");
                break;
        }
        return goods;
    }
    private static String goodgod(){
        String goodgod= "";
        Random randomgoodgod = new Random();
        int randomgoodgods = randomgoodgod.nextInt(55 - 1 + 1) + 1;
        switch (randomgoodgods){
            case 1  -> goodgod = "Chauntea";
            case 2  -> goodgod = "Deneir";
            case 3  -> goodgod = "Eldath";
            case 4  -> goodgod = "Ilmater";
            case 5  -> goodgod = "Lathander";
            case 6  -> goodgod = "Lliira";
            case 8  -> goodgod = "Mielikki";
            case 9  -> goodgod = "Mystra";
            case 10 -> goodgod = "Selûne";
            case 11 -> goodgod = "Sune";
            case 12 -> goodgod = "Torm";
            case 13 -> goodgod = "Tymora";
            case 14 -> goodgod = "Tyr";
            case 15 -> goodgod = "Ehlonna";
            case 16 -> goodgod = "Fharlanghn";
            case 17 -> goodgod = "Heironeous";
            case 18 -> goodgod = "Kord";
            case 19 -> goodgod = "Pelor";
            case 20 -> goodgod = "Pholtus";
            case 21 -> goodgod = "Rao";
            case 22 -> goodgod = "Trithereon";
            case 23 -> goodgod = "Ulaa";
            case 24 -> goodgod = "Paladine";
            case 25 -> goodgod = "Branchala";
            case 26 -> goodgod = "Habbakuk";
            case 27 -> goodgod = "Kiri-Jolith";
            case 28 -> goodgod = "Majere";
            case 29 -> goodgod = "Mishakal";
            case 30 -> goodgod = "Solinari";
            case 31 -> goodgod = "Arawai";
            case 32 -> goodgod = "Boldrei";
            case 33 -> goodgod = "Dol Arrah";
            case 34 -> goodgod = "Dol Dorn";
            case 35 -> goodgod = "Olladra";
            case 36 -> goodgod = "Onatar";
            case 37 -> goodgod = "The Silver Flame";
            case 38 -> goodgod = "The Undying Court";
            case 39 -> goodgod = "The Spirits of the Past";
            case 40 -> goodgod = "Bahamut";
            case 41 -> goodgod = "Corellon Larethian";
            case 42 -> goodgod = "Deep Sashelas";
            case 43 -> goodgod = "Eilistraee";
            case 44 -> goodgod = "Garl Glittergold";
            case 45 -> goodgod = "Moradin";
            case 46 -> goodgod = "Rillifane Rallathil";
            case 47 -> goodgod = "Sehanine Moonbow";
            case 48 -> goodgod = "Yondalla";
            case 49 -> goodgod = "Avandra - Chaotic good goddess of change and luck.";
            case 50 -> goodgod = "Bahamut - Lawful good god of justice and nobility.";
            case 51 -> goodgod = "Corellon";
            case 52 -> goodgod = "Moradin";
            case 53 -> goodgod = "Pelor";
            case 54 -> goodgod = "Raven Queen";
            case 55  -> goodgod = "Sehanine";
        }
        return goodgod;
    }
    private static String neutralgod(){
        String neutralgod= "";
        Random randomneutralgod = new Random();
        int randomevilgods = randomneutralgod.nextInt(42 - 1 + 1) + 1;
        switch (randomevilgods){
            case 1  -> neutralgod = "Gond";
            case 2  -> neutralgod = "Helm";
            case 3  -> neutralgod = "Kelemvor";
            case 4  -> neutralgod = "Leira";
            case 5  -> neutralgod = "Mask";
            case 6  -> neutralgod = "Oghma";
            case 8  -> neutralgod = "Savras";
            case 9  -> neutralgod = "Silvanus";
            case 10 -> neutralgod = "Tempus";
            case 11 -> neutralgod = "Waukeen";
            case 12 -> neutralgod = "Beory";
            case 13 -> neutralgod = "Istus";
            case 14 -> neutralgod = "Obad-Hai";
            case 15 -> neutralgod = "Olidammara";
            case 16 -> neutralgod = "Ralishaz";
            case 17 -> neutralgod = "Saint Cuthbert";
            case 18 -> neutralgod = "Wee Jas";
            case 19 -> neutralgod = "Gilean";
            case 20 -> neutralgod = "Chislev";
            case 21 -> neutralgod = "Reorx";
            case 22 -> neutralgod = "Shinare";
            case 23 -> neutralgod = "Sirrion";
            case 24 -> neutralgod = "Zivilyn";
            case 25 -> neutralgod = "Kol Korran";
            case 26 -> neutralgod = "The Traveler";
            case 27 -> neutralgod = "The Blood of Vol";
            case 28 -> neutralgod = "The Path of Light";
            case 29 -> neutralgod = "Eadro";
            case 30 -> neutralgod = "Semuanya";
            case 31 -> neutralgod = "Skerrit";
            case 32 -> neutralgod = "Skoraeus Stonebones";
            case 33 -> neutralgod = "Erathis";
            case 34 -> neutralgod = "Ioun";
            case 35 -> neutralgod = "Kord";
            case 36 -> neutralgod = "Melora";
            case 37 -> neutralgod = "Garagos";
            case 38 -> neutralgod = "Azuth";
            case 39 -> neutralgod = "Boccob";
            case 40 -> neutralgod = "Celestian";
            case 41 -> neutralgod = "Aureon";
            case 42 -> neutralgod = "Balinor";
        }
        return neutralgod;
    }
    private static String evilgod(){
        String evilgod= "";
        Random randomevilgod = new Random();
        int randomevilgods = randomevilgod.nextInt(53 - 1 + 1) + 1;
        switch (randomevilgods){
            case 1  -> evilgod = "Auril";
            case 2  -> evilgod = "Bane ";
            case 3  -> evilgod = "Beshaba";
            case 4  -> evilgod = "Bhaal";
            case 5  -> evilgod = "Cyric";
            case 6  -> evilgod = "Loviatar";
            case 8  -> evilgod = "Malar";
            case 9  -> evilgod = "Myrkul";
            case 10 -> evilgod = "Shar";
            case 11 -> evilgod = "Talona";
            case 12 -> evilgod = "Talos";
            case 13 -> evilgod = "Umberlee ";
            case 14 -> evilgod = "Erythnul";
            case 15 -> evilgod = "Hextor";
            case 16 -> evilgod = "Incabulos";
            case 17 -> evilgod = "Iuz";
            case 18 -> evilgod = "Nerull";
            case 19 -> evilgod = "Tharizdun";
            case 20 -> evilgod = "Vecna";
            case 21 -> evilgod = "Takhisis";
            case 22 -> evilgod = "Chemosh";
            case 23 -> evilgod = "Hiddukel";
            case 24 -> evilgod = "Morgion";
            case 25 -> evilgod = "Sargonnas";
            case 26 -> evilgod = "Zeboim";
            case 27 -> evilgod = "Nuitari";
            case 28 -> evilgod = "The Devourer";
            case 29 -> evilgod = "The Fury";
            case 30 -> evilgod = "The Keeper";
            case 31 -> evilgod = "The Mockery";
            case 32 -> evilgod = "The Shadow";
            case 33 -> evilgod = "Blibdoolpoolp";
            case 34 -> evilgod = "Grolantor";
            case 35 -> evilgod = "Gruumsh";
            case 36 -> evilgod = "Hruggek";
            case 37 -> evilgod = "Kurtulmak";
            case 38 -> evilgod = "Laogzed";
            case 39 -> evilgod = "Lolth";
            case 40 -> evilgod = "Maglubiyet";
            case 41 -> evilgod = "Sekolah";
            case 42 -> evilgod = "Surtr";
            case 43 -> evilgod = "Thrym";
            case 44 -> evilgod = "Tiamat";
            case 45 -> evilgod = "Asmodeus";
            case 46 -> evilgod = "Bane";
            case 47 -> evilgod = "Gruumsh";
            case 48 -> evilgod = "Lolth";
            case 49 -> evilgod = "Tharizdun";
            case 50 -> evilgod = "Tiamat";
            case 51 -> evilgod = "Torog";
            case 52 -> evilgod = "Vecna";
            case 53 -> evilgod = "Zehir";
        }
        return evilgod;
    }
    private static String shop(){
        String shoptype = "";
        int radomshop = d20();

        switch (radomshop){
            case 1 ->  shoptype = "Pawnshop";
            case 2 ->  shoptype = "Herbs/incense";
            case 3 ->  shoptype = "Fruits/vegetables";
            case 4 ->  shoptype = "Dried meats";
            case 5 ->  shoptype = "Pottery";
            case 6 ->  shoptype = "Undertaker";
            case 7 ->  shoptype = "Books";
            case 8 ->  shoptype = "Moneylender";
            case 9 ->  shoptype = "Weapons/armor";
            case 10 -> shoptype = "Chandler";
            case 11 -> shoptype = "Smithy";
            case 12 -> shoptype = "Carpenter";
            case 13 -> shoptype = "Weaver";
            case 14 -> shoptype = "Jewler";
            case 15 -> shoptype = "Baker";
            case 16 -> shoptype = "Mapmaker";
            case 17 -> shoptype = "Tailor";
            case 18 -> shoptype = "Ropemaker";
            case 19 -> shoptype = "Mason";
            case 20 -> shoptype = "Scribe";
        }
        return shoptype;
    }
}

