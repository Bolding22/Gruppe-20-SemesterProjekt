package worldofzuul;

public class Npc {

    private final String name;
    private Conversation dialog;
    private String description;

    public Npc(String name, String description, int i, int j) {
        this.name = name;
        this.description = description;
        dialog = new Conversation(i, j);
    }

    public String getName() {
        return name;
    }

    public String getDialogSay(int i) {
        return dialog.getSay()[i];
    }

    public String getDialogAns(int i) {
        return dialog.getAnswer()[i];
    }

    public void setDialogSay(String say, int i) {
        this.dialog.setSay(say, i);
    }

    public void setDialogAnswer(String ans, int i) {
        this.dialog.setAnswer(ans, i);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
