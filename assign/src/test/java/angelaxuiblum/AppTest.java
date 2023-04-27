package angelaxuiblum;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for junior assignment
 */
public class AppTest 
{
    /**
     * Test for each number :)
     */

    @Test
    public void multiplesOfThreeShouldEqualDevhaus()
    {
        App app = new App();
        assertEquals("Devhaus", app.printMultiples(3));
        assertTrue(app.printMultiples(6).equals("Devhaus"));
    }

    @Test
    public void multipleOfFiveShouldEqualLearning() 
    {
        App app = new App();
        assertEquals("Learning", app.printMultiples(5));
        assertTrue(app.printMultiples(10).equals("Learning"));
        assertEquals("Devhaus Learning", app.printMultiples(15));
    }

    @Test
    public void multipleOfSevenShouldEqualModel() 
    {
        App app = new App();
        assertEquals("Model", app.printMultiples(7));
        assertTrue(app.printMultiples(14).equals("Model"));
        assertEquals("Devhaus Model", app.printMultiples(21));
        assertEquals("Learning Model", app.printMultiples(35));
    }

    @Test
    public void multipleOfAllShouldEqualiBlum() 
    {
        App app = new App();
        assertEquals("iBlüm", app.printMultiples(105));
        assertTrue(app.printMultiples(210).equals("iBlüm"));
    }
}
