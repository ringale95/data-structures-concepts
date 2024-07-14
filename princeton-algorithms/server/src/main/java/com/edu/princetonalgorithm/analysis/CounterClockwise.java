package com.edu.princetonalgorithm.analysis;

public class CounterClockwise {
    private final double x;
    private final double y;

    public CounterClockwise(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static int ccw(CounterClockwise a, CounterClockwise b, CounterClockwise c) {
        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area2 < 0)
            return -1; // clockwise
        else if (area2 > 0)
            return 1; // anti-clockwise
        else
            return 0; // collinear
    }

    public static void main(String[] args) {
        CounterClockwise a = new CounterClockwise(0, 0);
        CounterClockwise b = new CounterClockwise(1, 1);
        CounterClockwise c = new CounterClockwise(2, 2);

        System.out.println(CounterClockwise.ccw(a, b, c)); // Output should be 0 as the points are collinear
    }
}
