import org.junit.Assert;
import org.junit.Test;

public class MonteCarloTest {

    @Test
    public void generatePi(){
        MonteCarlo generator = new MonteCarlo();
        generator.simulatePi(new Long(1000000000));
        //generates 3 decimals of the number pi, using a by a simulation, 3.141...
        Assert.assertEquals(generator.getPi().substring(0,5), "3.141");
    }

    @Test
    public void testInsideSquare(){
        MonteCarlo generator = new MonteCarlo();
        Assert.assertEquals(generator.insideSquare(new double[]{0,  0}), true);
        Assert.assertEquals(generator.insideSquare(new double[]{0,  100}), true);
        Assert.assertEquals(generator.insideSquare(new double[]{10,  10}), true);
        Assert.assertEquals(generator.insideSquare(new double[]{200,  200}), true);
        Assert.assertEquals(generator.insideSquare(new double[]{200,  201}), false);
    }

    @Test
    public void testInsideCircle(){
        MonteCarlo generator = new MonteCarlo();
        Assert.assertEquals(generator.insideCircle(new double[]{500,  200}), true);
        Assert.assertEquals(generator.insideCircle(new double[]{700,  200}), true);
        Assert.assertEquals(generator.insideCircle(new double[]{600,  200}), true);
    }
}