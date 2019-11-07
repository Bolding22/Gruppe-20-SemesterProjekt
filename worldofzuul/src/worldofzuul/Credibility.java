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
public class Credibility {
    
    private int credScore;
    private final int max = 100;
    private final int min = 0;
    private boolean exist = false;
    
    public Credibility(){
        credScore = min;
    }
    
    public void giveFiveCred(){
        credScore += 5;
        if (credScore>95){
            credScore = max;
        }
    }
    public void giveTenCred(){
        credScore += 10;
        if (credScore>95){
            credScore = max;
        }
    }
    public void giveFifteenCred(){
        credScore += 15;
        if (credScore>95){
            credScore = max;
        }
    }
    public void giveTwentyCred(){
        credScore += 20;
        if (credScore>95){
            credScore = max;
        }
    }
    public void takeFiveCred(){
        credScore -= 5;
    }
    public int getCredScore() {
        return credScore;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    
}
