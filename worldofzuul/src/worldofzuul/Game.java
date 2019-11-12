package worldofzuul;

import java.util.ArrayList;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private Credibility credScore;

    public Game() {
        credScore = new Credibility();
        createRooms();
        parser = new Parser();

    }

    // Rooms
    private void createRooms() {
        Room home, expo, scienceRoom, quizRoom, unRoom, meetingRoom, endRoom;

        home = new Room("You're Home, preparing for the Expo", "home");
        expo = new Room("You've arrived at the Expo! Wow! There's so many cool"
                + " posters.\nDo you wanna know some more? "
                + "Search and you will find.\n", "expo");
        scienceRoom = new Room("in the Science Area", "scienceRoom");
        quizRoom = new Room("in the Quiz Area", "quizRoom");
        unRoom = new Room("in the UN Area", "unRoom");
        meetingRoom = new Room("Welcome to the Energy Meeting 2020. "
                + "Look around and talk to the representatives from the different nations. "
                + "Maybe you can teach them a thing or to.", "meetingRoom");
        endRoom = new Room("You've completed the game!", "endRoom");
        currentRoom = home;

        home.setExit("out", expo);

        expo.setExit("area1", unRoom);
        expo.setExit("area2", scienceRoom);
        expo.setExit("area3", quizRoom);
        expo.setExit("next", meetingRoom);

        unRoom.setExit("back", expo);

        scienceRoom.setExit("back", expo);

        quizRoom.setExit("back", expo);

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
        Npc jeff = new Npc("Jeff", ", an Intern working with Rick", 1, 2);

        jeff.setDialogSay("Hi, my name is Jeff, and I'm an intern working with Rick. I don't really know much yet... Still learning!", 0);
        scienceRoom.addNpc(jeff);

        // NPC Rick
        Npc rick = new Npc("Rick", ", an Expert on Solar Power", 1, 2);

        rick.setDialogSay("Hi! My name is Rick\n"
                + "I have some amazing things to tell you about solar power!\n"
                + "First off all I would like to say that I believe that solar power is the future for all of us\n"
                + "BUT... That is why I am here today! To give you all the knowledge you need to understand the basics of solar power.\n"
                + "There are two types of solar panels that i want to tell you about today\n"
                + "The first one is photovoltaic solar panels or PV-panels for us nerds. These panels are small, thin and lightweight.\n"
                + "These cells turn light into electricity and even works in low light.\n"
                + "The downside to these panels is that they can only power smaller devices or be used for slower charging\n"
                + "Then there are the bigger and bulkier silicon solar panels that can power cities or even whole countries\n"
                + "But of course, these have a downside as well. They are way more expensive and they are very large and non-flexible\n"
                + "In the ideal world we would make the smaller PV-panels better and more powerful or make the silicon panels smaller and more flexible\n"
                + "I really hope you learned something and want to participate in the quiz! Have a great day!", 0);

        rick.setDialogAnswer("Wow. That sounds really cool! I will definately do the quiz!", 0);

        scienceRoom.addNpc(rick);

        // NPC Villy
        Npc villy = new Npc("Villy", ", a representive of the United Nations", 1, 2);

        villy.setDialogSay("Hello there!\n"
                + "My name is Villy and I’m here to represent The UN and tell you a bit about our global goals for sustainable development.\n"
                + "There are 17 global goals which covers everything from ending poverty to making sure everyone has sustainable energy.\n"
                + "And you might be surprised to hear this.\n"
                + "But all 193 members of The UN has agreed to work towards making these goals before 2030.\n"
                + "Today I would like to give you some extra knowledge on the 7th goal.\n"
                + "Goal number 7 is all about affordable and clean energy and making sure that everyone has ascess to it.\n"
                + "The overall goal is to get rid of the energy produced by fossil fuels and replace them with renewable energy like solar power!\n"
                + "I even heard that there is a guy here today that can tell you everything about solar energy! You should go see him!\n"
                + "Have a nice day!", 0);

        villy.setDialogAnswer("I'd love to help", 0);

        unRoom.addNpc(villy);

        //NPC Quizmaster
        Npc quizMaster = new Npc("Quizmaster", ", who will be testing your knowlegde", 4, 2);

        quizMaster.setDialogSay("Question #1\n What does...?", 0);
        quizMaster.setDialogSay("Question #2\n What does...?", 1);
        quizMaster.setDialogSay("Question #3\n What does...?", 2);
        quizMaster.setDialogSay("Thanks for participating. It's lovely to see such brilliant minds.", 3);

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

    private void goRoom(Command command) {
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
        System.out.println("Type '" + CommandWord.SEARCH + "' to look for items.");
        System.out.println("Type '" + CommandWord.LOOK + "' to look for people to talk to.");
        System.out.println("Type '" + CommandWord.TALK + "' + Name, to talk to people.");
        System.out.println("Type '" + CommandWord.GET + "' + Itemname, to pick up and read/show items.");
        System.out.println("Type '" + CommandWord.DROP + "' + Itemname, to drop items.");
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
            getItem(command);

        } else if (commandWord == CommandWord.DROP) {
            dropItem(command);

        } else if (commandWord == CommandWord.SEARCH) {
            searchItem(command);

        } else if (commandWord == CommandWord.LOOK) {
            lookNpc(command);

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

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    // Credibility Score
    private void showCred(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println(credScore.getCredScore());
        }

    }

    // NPC's
    private void talkNpc(Command command) {

        if (!command.hasSecondWord()) {
            System.out.println("Talk to who?");
        } else if (command.hasSecondWord()) {

            // NPC's says their dialog, if secondWord matches with NPC name in the room.
            for (int i = 0; i < currentRoom.getNpcs().size(); i++) {
                if (currentRoom.getNpcs().get(i).getName().equals(command.getSecondWord())) {

                    System.out.println(currentRoom.getNpcs().get(i).getName() + " says: " + currentRoom.getNpcs().get(i).getDialogSay(0));
                    System.out.print("\nAvailable answers:");
                    System.out.print(" [" + (1) + "] " + currentRoom.getNpcs().get(i).getDialogAns(0) + " [" + (2) + "] " + currentRoom.getNpcs().get(i).getDialogAns(1));
                    if (currentRoom.getName().equals("meetingRoom")) {
                        System.out.println(" [3] " + currentRoom.getNpcs().get(i).getDialogAns(2));
                    }

                    System.out.println("\nType the corresponding number for your answer to answer.");

                    while (true) {
                        switch (parser.getString()) {
                            case "1":
                                System.out.println("You say: " + currentRoom.getNpcs().get(i).getDialogAns(0));
                                credScore.giveFiveCred();
                                break;
                            case "2":
                                System.out.println("You say: " + currentRoom.getNpcs().get(i).getDialogAns(1));
                                break;
                            case "3":
                                System.out.println("You say: " + currentRoom.getNpcs().get(i).getDialogAns(2));
                                break;
                            default:
                                System.out.println("Wrong keypress.");
                                break;
                        }
                        break;
                    }

                    if (null != command.getSecondWord()) //Gives credibility, when NPC's are talked to.
                    {
                        switch (command.getSecondWord()) {
                            case "Rick":
                                credScore.giveFifteenCred();
                                currentRoom.removeNpc("Rick");
                                System.out.println("\nRick has left.");
                                break;

                            case "Villy":
                                credScore.giveTenCred();
                                currentRoom.removeNpc("Villy");
                                System.out.println("\nVilly has left.");
                                break;

                            case "Quizmaster":
                                // Question #2
                                System.out.println(currentRoom.getNpcs().get(i).getName() + " says: " + currentRoom.getNpcs().get(i).getDialogSay(1));
                                System.out.println(" [1] " + currentRoom.getNpcs().get(i).getDialogAns(0) + " [2] " + currentRoom.getNpcs().get(i).getDialogAns(1));
                                while (true) {
                                    switch (parser.getString()) {
                                        case "1":
                                            System.out.println("You say: " + currentRoom.getNpcs().get(i).getDialogAns(0));
                                            credScore.giveTwentyCred();
                                            break;
                                        case "2":
                                            System.out.println("You say: " + currentRoom.getNpcs().get(i).getDialogAns(1));
                                            break;
                                    }
                                    break;
                                }
                                // Question #3
                                System.out.println(currentRoom.getNpcs().get(i).getName() + " says: " + currentRoom.getNpcs().get(i).getDialogSay(2));
                                System.out.println(" [1] " + currentRoom.getNpcs().get(i).getDialogAns(0) + " [2] " + currentRoom.getNpcs().get(i).getDialogAns(1));
                                while (true) {
                                    switch (parser.getString()) {
                                        case "1":
                                            System.out.println("You say: " + currentRoom.getNpcs().get(i).getDialogAns(0));
                                            credScore.giveTwentyCred();
                                            break;
                                        case "2":
                                            System.out.println("You say: " + currentRoom.getNpcs().get(i).getDialogAns(1));
                                            break;
                                    }
                                    break;
                                }
                                // Saying goodbye.
                                System.out.println(currentRoom.getNpcs().get(i).getName() + " says: " + currentRoom.getNpcs().get(i).getDialogSay(3));
                                currentRoom.removeNpc("Quizmaster");
                                System.out.println("\nQuizmaster has left.");
                                break;
                            case "NR1":
                                System.out.println("I will consider your offer. Thank you.");
                                break;
                            case "NR2":
                                System.out.println("I will consider your offer. Thank you.");
                                break;
                            case "NR3":
                                System.out.println("I will consider your offer. Thank you.");
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    }

    private void lookNpc(Command command) {

        if (!command.hasSecondWord()) {
            currentRoom.getNpcsRoom();
        }
    }

    // Items
    private void searchItem(Command command) {

        if (!command.hasSecondWord()) {
            currentRoom.getItemsRoom();
        }
    }

    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        String item = command.getSecondWord();

        Item newItem = null;
        int index = 0;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(item)) {
                newItem = inventory.get(i);
                index = i;
            }
        }

        if (newItem == null) {
            System.out.println("That item is not in your inventory!");
        } else {
            inventory.remove(index);
            currentRoom.setItem(new Item(item));

            System.out.println("You dropped: " + item);
        }
    }

    private void getItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Get what?");
            return;
        }

        String item = command.getSecondWord();

        Item newItem = currentRoom.getItem(item);

        if (newItem == null) {
            System.out.println("There is no such item!");
            credScore.takeFiveCred();
        } else {
            inventory.add(newItem);
            currentRoom.removeItem(item);
            System.out.println("You picked up: " + item);
        }
        if ("Solarpanel".equals(command.getSecondWord())) {
            credScore.giveFiveCred();
        } else if ("SolarPoster".equals(command.getSecondWord())) {
            credScore.giveFiveCred();
            System.out.println("\nInterrested in Solarpower?\n"
                    + "Here are some facts about it!\n"
                    + "#1: ...\n"
                    + "#2: ...\n"
                    + "If you want to learn more, look for Rick in the Science Area!");
        } else if ("UN-Poster".equals(command.getSecondWord())) {
            credScore.giveFiveCred();
        } else if ("QuizPoster".equals(command.getSecondWord())) {
            credScore.giveFiveCred();
        }
    }

    // Inventory
    private void printInventory() {
        String output = "";
        for (int i = 0; i < inventory.size(); i++) {
            output += inventory.get(i).getName() + " ";
        }
        System.out.println("Your inventory contains: " + output);

    }

}
