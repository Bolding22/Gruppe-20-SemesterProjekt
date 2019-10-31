package worldofzuul;

public enum CommandWord
{
    GO("Go"), QUIT("Quit"), HELP("Help"), UNKNOWN("?"), SEARCH("Search"), USE("Use");
    
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
