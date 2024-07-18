package com.edu.princetonalgorithm.assignment;

public class Points2D implements Comparable<Points2D> {

    private double x;
    private double y;

    public Points2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Points2D that) {

        if (this.x == that.x && this.y == that.y)
            return 0;

        // Calculate distances squared from origin (0, 0)
        double distThis = this.x * this.x + this.y * this.y;
        double distThat = that.x * that.x + that.y * that.y;

        // Compare distances
        if (distThis < distThat) {
            return -1;
        } else
            return 1;

    }

    public static void main(String[] args) {
        Points2D point1 = new Points2D(1.0, 3.5);
        Points2D point2 = new Points2D(1.00, 3.0);

        Points2D point3 = new Points2D(1.0, 9);
        Points2D point4 = new Points2D(1.00, 3.0);
        Points2D[] points1 = { point1, point2 };
        Points2D[] points2 = { point3, point4 };

        int count = 0;

        for (Points2D p : points1)
            for (Points2D q : points2)
                if (p.compareTo(q) == 0)
                    count++;

        System.out.println("Number of same points: " + count); // Outputs 1 (point2 and point4 are the same)
    }
}
