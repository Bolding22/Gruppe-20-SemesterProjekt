package worldofzuul;

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), SEARCH("search"),
    READ("read"), INVENTORY("inventory"), GET("get"), DROP("drop"), LOOK("look"),
    HINT("hint"), TALK("talk"), CREDIBILITY("cred");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
