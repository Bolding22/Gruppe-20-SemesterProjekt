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

    private void createRooms() {
        Room home, expo, scienceRoom, quizRoom, unRoom, meetingRoom, endRoom;

        home = new Room("You're Home, preparing for the Expo");
        expo = new Room("You've arrived at the Expo! Wow! There's so many cool"
                + " posters.\nDo you wanna know some more? "
                + "Search and you will find.\n");
        scienceRoom = new Room("in the Science Area");
        quizRoom = new Room("in the Quiz Area");
        unRoom = new Room("in the UN Area");
        meetingRoom = new Room("Welcome to the Energy Meeting 2020."
                + "Look around and talk to the representatives from the different nations."
                + "Maybe you can teach them a thing or to.");
        endRoom = new Room("You've completed the game!");
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
        scienceRoom.addNpc(new Npc("Jeff", "My name is jeff", ", an Intern working with Rick"));
        scienceRoom.addNpc(new Npc("Rick", "Solar...", ", is an Expert on Solar Energi" ));

        unRoom.addNpc(new Npc("Villy", "Hello there!\n"
                + "My name is Villy and I’m here to represent The UN and tell you a bit about our global goals for sustainable development.\n"
                + "There are 17 global goals which covers everything from ending poverty to making sure everyone has sustainable energy.\n"
                + "And you might be surprised to hear this.\n"
                + "But all 193 members of The UN has agreed to work towards making these goals before 2030.\n"
                + "Today I would like to give you some extra knowledge on the 7th goal.\n"
                + "Goal number 7 is all about affordable and clean energy and making sure that everyone has ascess to it.\n"
                + "The overall goal is to get rid of the energy produced by fossil fuels and replace them with renewable energy like solar power!\n"
                + "I even heard that there is a guy here today that can tell you everything about solar energy! You should go see him!\n"
                + "Have a nice day!"
        , ", is a representive of the United Nations"));

        quizRoom.addNpc(new Npc("Quizmaster", "...", ", who will be testing your knowlegde"));

    }

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
        System.out.println("Type '" + CommandWord.GO + "' + a route, to move to a new location.");
        System.out.println("Type '" + CommandWord.SEARCH + "' to look for items.");
        System.out.println("Type '" + CommandWord.LOOK + "' to look for NPC's.");
        System.out.println("Type '" + CommandWord.GET + "' to pick up items.");
        System.out.println("Type '" + CommandWord.DROP + "' to drop items.");
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

    private void showCred(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println(credScore.getCredScore());
        }

    }

    private void talkNpc(Command command) {

        if (!command.hasSecondWord()) {
            System.out.println("Talk to who?");
        } else if (command.hasSecondWord()) {

            // NPC's says their dialog, if secondWord matches with NPC name in the room.
            for (int i = 0; i < currentRoom.getNpcs().size(); i++) {
                if (currentRoom.getNpcs().get(i).getName().equals(command.getSecondWord())) {

                    System.out.println(currentRoom.getNpcs().get(i).getDialog());

                    //Gives credibility, when NPC's are talked to.
                    if ("Rick".equals(command.getSecondWord())) {
                        credScore.giveFifteenCred();
                        currentRoom.removeNpc("Rick");
                        System.out.println("\nRick has left.");

                    } else if ("Villy".equals(command.getSecondWord())) {
                        credScore.giveTenCred();
                        currentRoom.removeNpc("Villy");
                        System.out.println("\nVilly has left.");

                    } else if ("Quizmaster".equals(command.getSecondWord())) {
                        credScore.giveTwentyCred();
                        currentRoom.removeNpc("Quizmaster");
                        System.out.println("\nQuizmaster has left.");
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

    private void printInventory() {
        String output = "";
        for (int i = 0; i < inventory.size(); i++) {
            output += inventory.get(i).getName() + " ";
        }
        System.out.println("Your inventory contains: " + output);

    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
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

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
