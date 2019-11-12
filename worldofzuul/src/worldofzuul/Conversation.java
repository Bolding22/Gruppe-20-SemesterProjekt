/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
