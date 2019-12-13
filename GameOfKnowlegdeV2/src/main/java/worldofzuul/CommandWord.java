package worldofzuul;

public enum CommandWord {
    GO("go"), QUIT("quit"), UNKNOWN("?"), INVENTORY("inventory"), GET("get"), TALK("talk"), CREDIBILITY("cred");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
