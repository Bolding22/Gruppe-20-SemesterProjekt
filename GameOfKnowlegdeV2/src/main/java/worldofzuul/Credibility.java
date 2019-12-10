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

    private double credScore;
    private final double max = 1;
    private final double min = 0;
    private boolean exist = false;

    public Credibility() {
        credScore = min;
    }

    public void giveFiveCred() {
        credScore += 0.05;
        if (credScore > 0.95) {
            credScore = max;
        }
    }

    public void giveTenCred() {
        credScore += +0.10;
        if (credScore > 0.95) {
            credScore = max;
        }
    }

    public void giveFifteenCred() {
        credScore += 0.15;
        if (credScore > 0.95) {
            credScore = max;
        }
    }

    public double getCredScore() {
        return credScore;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

}
