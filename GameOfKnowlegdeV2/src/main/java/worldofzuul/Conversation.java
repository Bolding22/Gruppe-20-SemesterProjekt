package worldofzuul;

/**
 *
 * @author wbold
 */
public class Conversation {

    private String[] say;
    private String[] answer;

    public Conversation(int i, int j) {
        say = new String[i];
        answer = new String[j];
    }

    public String[] getSay() {
        return say;
    }

    public void setSay(String say, int i) {
        this.say[i] = say;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String answer, int i) {
        this.answer[i] = answer;
    }

}
