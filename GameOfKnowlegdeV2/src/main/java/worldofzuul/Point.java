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

    public double calcScore(double credScore) {
        score = credScore * point;
        return score;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public double getScore() {
        return score;
    }
}
