package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), SEARCH("search"), 
    USE("use"), INVENTORY("inventory"), GET("get"), DROP("drop"), LOOK("look"),
    HINT("hint"), TALK("talk");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
