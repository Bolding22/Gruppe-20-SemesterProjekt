package worldofzuul;

import java.util.ArrayList;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Credibility credScore;
    private Point score;

    private static Game game;

    private Game() {
        credScore = new Credibility();
        createRooms();
        parser = new Parser();
        score = new Point();
    }

    public static Game Instance() {
        if (game == null) {
            game = new Game();
        }

        return game;
    }

    // Rooms
    private void createRooms() {
        Room home, expo, expoOut, scienceRoom, quizRoom, unRoom, meetingRoom, endRoom;

        home = new Room("You're Home, preparing for the Expo", "home");
        expo = new Room("You've arrived at the Expo! Wow! There's so many cool"
                + " posters.\nDo you wanna know some more? "
                + "Search and you will find.\n", "expo");
        expoOut = new Room("You're outside the expo", "expoOut");
        scienceRoom = new Room("in the Science Area", "scienceRoom");
        quizRoom = new Room("in the Quiz Area", "quizRoom");
        unRoom = new Room("in the UN Area", "unRoom");
        meetingRoom = new Room("Welcome to the Energy Meeting 2020. "
                + "Look around and talk to the representatives from the different nations. "
                + "Maybe you can teach them a thing or to.", "meetingRoom");
        endRoom = new Room("You've completed the game!", "endRoom");

        currentRoom = home;

        home.setExit("out", expoOut);

        expoOut.setExit("back", home);
        expoOut.setExit("inside", expo);

        expo.setExit("area1", unRoom);
        expo.setExit("area2", scienceRoom);
        expo.setExit("area3", quizRoom);
        expo.setExit("back", expoOut);

        unRoom.setExit("back", expo);

        scienceRoom.setExit("back", expo);

        quizRoom.setExit("back", expo);
        quizRoom.setExit("next", meetingRoom);

        meetingRoom.setExit("back", expo);
        meetingRoom.setExit("next", endRoom);

        // Create and add Items to rooms.
        expo.setItem(new Item("SolarPoster"));
        expo.setItem(new Item("UN-Poster"));
        expo.setItem(new Item("QuizPoster"));

        scienceRoom.setItem(new Item("Solarpanel"));

        home.setItem(new Item("Switch"));

        quizRoom.setItem(new Item("Invitation"));

        // Create and add NPC's to rooms.
        // NPC Jeff
        Npc jeff = new Npc("Jeff", ", an Export on Greenhouse gasses", 1, 2);

        jeff.setDialogSay(
                "Hi! I'm Jeff and I'd like to teach you about the dangers of using\n"
                + "fossil fuels. I'll put it simple. When fossil fuels are burned they\n"
                + "emmit Greenhouse gasses into the atmosphere. Those create\n"
                + "a shell around the earth increasing the temperature on earth.\n"
                + "Which for instance can lead to more and worse natural disasters.\n"
                + "So choose your energy sources wisely.", 0);
        scienceRoom.addNpc(jeff);

        // NPC Rick
        Npc rick = new Npc("Rick", ", an Expert on Solar Power", 3, 2);

        rick.setDialogSay(
                "Hi! My name is Rick and I have some fascinating stuff to\n"
                + "tell you about. Solar Power! Which is one of many renewable\n"
                + "energy sources. What it does is take rays of sunlight and\n"
                + "transforms it into electricity. To do this we use solar panels.\n"
                + "Today I will show you 2 different kinds. The 1st one is the\n"
                + "photovoltaic solar panel. These panels are small, thin, light-\n"
                + "weight AND work in low light. These are great for small\n"
                + "devices and slow charging. The 2nd one is a silicon panel,\n"
                + "those are huge and are great for cities or even countries!\n"
                + "Sadly they are expensive and not so flexible.", 0);
        rick.setDialogSay("If you want to hear about that, you should talk Jeff", 1);

        rick.setDialogAnswer("Wow. Thanks for the enlightenment!", 0);
        rick.setDialogAnswer("...", 1);

        scienceRoom.addNpc(rick);

        // NPC Villy
        Npc villy = new Npc("Villy", ", a representive of the United Nations", 1, 2);

        villy.setDialogSay(
                "Hello! My name is Villy and I’m here to represent The UN. I'd\n"
                + "like to tell you a bit about our global goals for sustainable\n"
                + "development. There are 17 global goals which covers everything\n"
                + "from ending poverty to making sure everyone has sustainable\n"
                + "energy. You might be surprised to hear this, but all 193\n"
                + "members of The UN has agreed to work towards making these\n"
                + "goals before 2030. Today I will tell you about goal no. 7\n"
                + "Goal no. 7 is about clean energy and giving everyone acces to it.\n"
                + "The goal is to get rid of the energy produced by fossil fuels\n"
                + "and replace them with renewable energy sources. If you go to\n"
                + "the Science Room, Rick and Jeff well tell you everything about\n"
                + "Solar energy and the consequences of fossil fuels.", 0);

        villy.setDialogAnswer("Sure sounds exciting. Hope I can help!", 0);
        villy.setDialogAnswer("...", 1);

        unRoom.addNpc(villy);

        //NPC Quizmaster
        Npc quizMaster = new Npc("Quizmaster", ", who will be testing your knowlegde", 4, 2);

        quizMaster.setDialogSay("Question #1\n Solar Energy is both cheaper and faster to deploy, than fossil fuels.", 0);
        quizMaster.setDialogSay("Question #2\n Greenhouse gasses helps the world keep a stable temperature.", 1);
        quizMaster.setDialogSay("Question #3\n The U.S. are by far the biggest user of Solar Energy in the world.", 2);
        quizMaster.setDialogSay("Question #4\n Photovoltiac panels are even able to work in a low light setting.", 3);

        quizMaster.setDialogAnswer("True.", 0);
        quizMaster.setDialogAnswer("False.", 1);
        quizRoom.addNpc(quizMaster);

        //NPC Representatives at the meeting.
        Npc nr1 = new Npc("NR1", ", representative of ...", 1, 3);

        nr1.setDialogSay("Economy", 0);
        nr1.setDialogAnswer("Economy Argument", 0);
        nr1.setDialogAnswer("Employment Argument", 1);
        nr1.setDialogAnswer("Bless them with your knowledge", 2);
        meetingRoom.addNpc(nr1);

        Npc nr2 = new Npc("NR2", ", representative of ...", 1, 3);
        meetingRoom.addNpc(nr2);

        nr2.setDialogSay("Employment", 0);
        nr2.setDialogAnswer("Economy Argument", 0);
        nr2.setDialogAnswer("Employment Argument", 1);
        nr2.setDialogAnswer("Bless them with your knowledge", 2);

        Npc nr3 = new Npc("NR3", ", representative of ...", 1, 3);

        nr3.setDialogSay("Knowledge", 0);
        nr3.setDialogAnswer("Economy Argument", 0);
        nr3.setDialogAnswer("Employment Argument", 1);
        nr3.setDialogAnswer("Bless them with your knowledge", 2);
        meetingRoom.addNpc(nr3);

    }

    public void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    // Basic features
    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Goodbye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Game of Knowledge!\n");
        System.out.println("You are now playing Game of Knowledge!\n"
                + "This game while guide you through the great aspects of reusable energy, "
                + "\nhereby in particular energy provided by the sun."
                + "\nYou will come along a lot of different features in this game, "
                + "\nlearning how to use reusable energy, talking to different science people, "
                + "\nmaybe even talk to the leader of a big gathering of the nations worldwide? 😉 "
                + "\nWho knows.. Only YOU will set the boundaries - PLAY now and see how far you can come, "
                + "\nor maybe even complete the game?"
                + "\n"
                + "\nGOOD LUCK!");
        System.out.println();
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("Type '" + CommandWord.GO + "' + route, to move to a new location.");
        System.out.println("Type '" + CommandWord.TALK + "' + Name, to talk to people.");
        System.out.println("Type '" + CommandWord.GET + "' + Itemname, to pick up and read/show items.");
        System.out.println("Type '" + CommandWord.CREDIBILITY + "' to view your Credibility Score.");
        System.out.println("Type '" + CommandWord.INVENTORY + "' to view your inventory.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();

        } else if (commandWord == CommandWord.GO) {
            goRoom(command);

        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);

        } else if (commandWord == CommandWord.INVENTORY) {
            printInventory();

        } else if (commandWord == CommandWord.GET) {
            pickUpItem(command);

        } else if (commandWord == CommandWord.TALK) {
            talkNpc(command);

        } else if (commandWord == CommandWord.CREDIBILITY) {
            showCred(command);
        }

        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    protected boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    // Credibility Score
    protected void showCred(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println(credScore.getCredScore());
        }
        
    }
    
    public Credibility getCredScore() {
        return credScore;
    }

    // NPC's
    public String talkNpc(Command command) {
        String output = null;
        if (!command.hasSecondWord()) {
            System.out.println("Talk to who?");
        } else if (command.hasSecondWord()) {

            // NPC's says their dialog, if secondWord matches with NPC name in the room.
            for (int i = 0; i < currentRoom.getNpcs().size(); i++) {
                if (currentRoom.getNpcs().get(i).getName().equals(command.getSecondWord())) {

                    output = currentRoom.getNpcs().get(i).getDialogSay(0);
                } else if (command.getSecondWord().equals(currentRoom.getNpcs().get(i).getName() + "1")) {
                    output = currentRoom.getNpcs().get(i).getDialogSay(1);
                } else if (command.getSecondWord().equals(currentRoom.getNpcs().get(i).getName() + "2")) {
                    output = currentRoom.getNpcs().get(i).getDialogSay(2);
                } else if (command.getSecondWord().equals(currentRoom.getNpcs().get(i).getName() + "3")) {
                    output = currentRoom.getNpcs().get(i).getDialogSay(3);
                }
            }
        }
        return output;
    }

    public String answerNPC(String answer) {
        String output = null;
        for (int i = 0; i < currentRoom.getNpcs().size(); i++) {
            switch (answer) {
                case "A":
                    output = currentRoom.getNpcs().get(i).getDialogAns(0);
                    break;
                case "B":
                    output = currentRoom.getNpcs().get(i).getDialogAns(1);
                    break;
                case "C":
                    output = currentRoom.getNpcs().get(i).getDialogAns(2);
                    break;
                default:
                    break;
            }
        }
        return output;
    }
    // Items
    public void pickUpItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Get what?");
            return;
        }

        String item = command.getSecondWord();

        Item newItem = currentRoom.getItem(item);

        if (newItem == null) {
            System.out.println("There is no such item!");
        } else {
            inventory.add(newItem);
            currentRoom.removeItem(item);
            System.out.println("You picked up: " + item);
        }
        if (null != command.getSecondWord()) {
            switch (command.getSecondWord()) {
                case "Solarpanel":
                    credScore.giveFiveCred();
                    break;
                case "SolarPoster":
                    credScore.giveFiveCred();
                    System.out.println("\nInterrested in Solarpower?\n"
                            + "Here are some facts about it!\n"
                            + "#1: ...\n"
                            + "#2: ...\n"
                            + "If you want to learn more, look for Rick in the Science Area!");
                    break;
                case "UN-Poster":
                    credScore.giveFiveCred();
                    break;
                case "QuizPoster":
                    credScore.giveFiveCred();
                    break;
                default:
                    break;
            }
        }
    }

    // Inventory
    public String printInventory() {
        String output = "";
        for (int i = 0; i < inventory.size(); i++) {
            output += inventory.get(i).getName() + " | ";
        }
        return "Inventory contains: \n" + "| " + output;

    }
// Score
    public Point getScore() {
        return score;
    }
}
