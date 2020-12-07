import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MonteCarlo {
    private double pi = 0;
    private double squareBucket = 1;
    private double circleBucket = 1;
    private final int[] CIRCLE_CENTER = new int[]{500, 200};
    private final int CIRCLE_RADIO = 200;
    private final int[] SQUARE_CORNER = new int[]{200, 200};

    public void simulatePi(long iterations) {
        pi = 0;

        try {
            File file = new File("pi.cvs");
            FileWriter fr = new FileWriter(file, true);
            fr.write("iteration,pi\n");

            for (long i = 0; i < iterations; i++) {
                double[] coordinate = new double[]{(Math.random() * 800), (Math.random() * 500)};

                if (insideSquare(coordinate)) {
                    squareBucket++;
                }

                if (insideCircle(coordinate)) {
                    circleBucket++;
                }

                pi = circleBucket / squareBucket;
                fr.write(i + "," + pi + "\n");
            }

            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("Generated after MAX_INTEGER " + iterations + " iterations " + pi);
    }

    public boolean insideSquare(double[] coordinate) {
        if (coordinate[0] <= SQUARE_CORNER[0] && coordinate[1] <= SQUARE_CORNER[1]) {
            return true;
        }
        return false;
    }

    public boolean insideCircle(double[] coordinate) {
        double radio = Math.pow(CIRCLE_RADIO, 2);
        double val = Math.pow(coordinate[0] - CIRCLE_CENTER[0], 2) + Math.pow(coordinate[1] - CIRCLE_CENTER[1], 2);
        return radio >= val;
    }

    public String getPi() {
        return String.valueOf(this.pi);
    }
}
