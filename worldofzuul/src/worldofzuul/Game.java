package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Energikilder currentEnergy;
        

    public Game() 
    {
        createRooms();
        parser = new Parser();
        
    }


    private void createRooms()
    {
        Room home, expo, scienceRoom, quizRoom, unRoom, meetingRoom, endRoom;
      
        home = new Room("You're Home, preparing for the Expo");
        expo = new Room("You've arrived at the Expo, go explore!");
        scienceRoom = new Room("in the Science Area");
        quizRoom = new Room("in the Quiz Area");
        unRoom = new Room("in the UN Area");
        meetingRoom = new Room("You've arrived at the EM");
        endRoom = new Room("You've completed the game!");
        
        home.setExit("out", expo);
        
        expo.setExit("area1", unRoom);
        expo.setExit("area2", scienceRoom);
        expo.setExit("area3", quizRoom);
        expo.setExit("next", meetingRoom);

        unRoom.setExit("back", expo);
      
        currentRoom = home;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Goodbye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("Type '" + CommandWord.SEARCH + "' to look for items.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.USE){
            pickEnergy(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    public void pickEnergy(Command command){
        Energikilder newEnergy = new Energikilder();
        
        String s = command.getSecondWord();
        
       if ("solar".equals(s)){
       newEnergy.setSolar(true);
       newEnergy.setTraditionalBiomass(false);
        System.out.println("You are now using Solar Power!");
       } 
       else if ("biomass".equals(s)){
       newEnergy.setSolar(false);
       newEnergy.setTraditionalBiomass(true);
       System.out.println("You are now using Traditional Biomass");
       }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
