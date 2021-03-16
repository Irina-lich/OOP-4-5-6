package Lab6;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {

    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        int iter = 0;
        double zreal = 0;
        double zimag = 0;

        while (iter < MAX_ITERATIONS && zreal * zreal + zimag * zimag < 4) {
            double zrealUpdated = zreal * zreal - zimag * zimag + x;
            double zimagUpdated = 2 * zreal * zimag + y;
            zreal = zrealUpdated;
            zimag = zimagUpdated;
            iter += 1;
        }

        if (iter == MAX_ITERATIONS) {
            return -1;
        }

        return iter;
    }

    public String toString() {
        return "Mandelbrot";
    }
}