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
public class Point {

    private double score;
    private int point;

    public Point() {
        point = 0;
        score = 0;
    }

    public int getPoint() {
        return point;
    }

    public double calcScore(double i) {
        score = i * point;
        return score;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public double getScore() {
        return score;
    }
}
