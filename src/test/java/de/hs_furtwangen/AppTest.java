package de.hs_furtwangen;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Der Test fuer die Umwandlung in Grossbuchstaben.
     */
    public void testUpperCase()
    {
        assertEquals("MEIN TEST33!", App.uppercase("mein test33!"));
        
    }
    
    /**
     * Der Test fuer die Umwandlung in Grossbuchstaben.
     */
    public void konstruktorProbleme()
    {
        assertEquals(App.class, new App().getClass());
        
    }
}
