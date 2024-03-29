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
        unRoom.setItem(new Item("CoffeeMugEmpty"));
        unRoom.setItem(new Item("CoffeeMugFilled"));

        scienceRoom.setItem(new Item("Solarpanel"));

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
        quizMaster.setDialogSay("Question #2\n An increasing amount of Greenhouse Gasses have\n"
                + "a positive impact on earth.", 1);
        quizMaster.setDialogSay("Question #3\n The U.S. are by far the biggest user of Solar Energy in the world.", 2);
        quizMaster.setDialogSay("Question #4\n Photovoltiac panels are even able to work in a low light setting.", 3);

        quizMaster.setDialogAnswer("True.", 0);
        quizMaster.setDialogAnswer("False.", 1);
        quizRoom.addNpc(quizMaster);

        //NPC Representatives at the meeting.
        Npc nr1 = new Npc("NR1", ", representative of ...", 1, 3);

        nr1.setDialogSay("In the sub-Saharan Africa we’re extremely exposed to\n"
                + "poverty, in average making less than a dollar a day. Therefore,\n"
                + "we cannot see any way for us, that it is possible to use modern\n"
                + "energy. We can simply not afford to have it. In the village I\n"
                + "am from, we want to use modern energy. How do you think you\n"
                + "will be able to help us?", 0);
        nr1.setDialogAnswer("Talk about the economic benefits of smaller\n"
                + "solar panels.", 0);
        nr1.setDialogAnswer("Talk about the job opportunities a solar panel\n"
                + "farm can create.", 1);
        nr1.setDialogAnswer("Share your knowledge about Solar Power\n"
                + "and fossil fuels", 2);
        meetingRoom.addNpc(nr1);

        Npc nr2 = new Npc("NR2", ", representative of ...", 1, 3);
        meetingRoom.addNpc(nr2);

        nr2.setDialogSay(
                "Where I am from, we have big problem with the young people when\n"
                + "they either finish or drop out of school. Many of them are\n"
                + "unemployed and have nothing to do. They are not helping in\n"
                + "our society, but we also struggle to find work for them. At the\n"
                + "same time, we have problems getting reliable energy to the whole\n"
                + "city. Is there someway you can help us with this?", 0);
        nr2.setDialogAnswer("Talk about the economic benefits of smaller\n"
                + "solar panels.", 0);
        nr2.setDialogAnswer("Talk about the job opportunities a solar panel\n"
                + "farm can create.", 1);
        nr2.setDialogAnswer("Share your knowledge about Solar Power\n"
                + "and fossil fuels", 2);

        Npc nr3 = new Npc("NR3", ", representative of ...", 1, 3);

        nr3.setDialogSay(
                "What is this “green energy” you are speaking of? In my village\n"
                + "we use kerosene, to light up our houses, as well as for cooking,\n"
                + "when the weather is problematic. I’d like to know more of this,\n"
                + "but I will not implement something, that I do not know about.\n"
                + "Also why is it better than the fossil energy, that all the rich\n"
                + " people have?", 0);
        nr3.setDialogAnswer("Talk about the economic benefits of smaller\n"
                + "solar panels.", 0);
        nr3.setDialogAnswer("Talk about the job opportunities a solar panel\n"
                + "farm can create.", 1);
        nr3.setDialogAnswer("Share your knowledge about Solar Power\n"
                + "and fossil fuels", 2);
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

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Goodbye.");
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.GO) {
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

    public boolean quit(Command command) {
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

    }

    // Inventory
    public String printInventory() {
        String output = "";
        for (int i = 0; i < inventory.size(); i++) {
            output += inventory.get(i).getName() + " | ";
        }
        return "Inventory contains: \n" + "| " + output;

    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

// Score
    public Point getScore() {
        return score;
    }
}
