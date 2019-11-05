package worldofzuul;

public enum CommandWord
{
    GO("Go"), QUIT("Quit"), HELP("Help"), UNKNOWN("?"), SEARCH("Search"), USE("Use"), INVENTORY("inventory"), GET("get"), DROP("drop");
    
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
