package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range postiveToNegativeRange;
    private Range evenNumElemRange;
    private Range oddNumElemRange;
    private Range negativeRange;
    private Range PosNumRange;
    private Range smallRange;
    private Range largeRange;
    private Range doubleRange;
    private Range posToNegRange;
    private Range invalidRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        postiveToNegativeRange = new Range(-1, 1);
        evenNumElemRange = new Range(1, 6);
        oddNumElemRange = new Range(1, 5);
        negativeRange = new Range(-100, -1);
        PosNumRange = new Range(1, 100);
        smallRange = new Range(0, 0);
        largeRange = new Range(-Integer.MIN_VALUE, Integer.MAX_VALUE);
        doubleRange = new Range(1.1, 6.6);
        doubleRange = new Range(1.1, 6.6);
    	posToNegRange = new Range(-1, 1);

    }

    // Tests for getLowerBound method

    @Test
    public void postiveToNegativeRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range from positive to negative values
        assertEquals("Lower bound should be -1",
                -1.0, postiveToNegativeRange.getLowerBound(), .000000001d);
    }

    @Test
    public void negativeRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range of negative values
        assertEquals("Lower bound should be -100",
                -100, negativeRange.getLowerBound(), .000000001d);
    }

    @Test
    public void PosNumRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range of positive values
        assertEquals("Lower bound should be 1",
                1, PosNumRange.getLowerBound(), .000000001d);
    }

    @Test
    public void smallRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a small range
        assertEquals("Lower bound should be 0",
                0, smallRange.getLowerBound(), .000000001d);
    }

    @Test
    public void largeRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a large range
        assertEquals("Lower bound should be -2^32",
                Integer.MIN_VALUE, largeRange.getLowerBound(), .000000001d);
    }

    @Test
    public void doubleRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range of double values
        assertEquals("Lower bound should be 1.1",
                1.1, doubleRange.getLowerBound(), .000000001d);
    }

     /**
    * Tests the getCentralValue method correctly gets the central value for a 
    * range with an odd number of elements
    */
    @Test
    public void testgetCentralValueWithOddNumberofElements() {
    	assertEquals("Incorrect central value for odd number of elements in range", 3, oddNumElemRange.getCentralValue(), 0);
    }
    
    /**
    * Tests the getCentralValue method correctly gets the central value for a 
    * range with an even number of elements
    */
    @Test
    public void testgetCentralValueWithEvenNumberofElements() {
    	assertEquals("Incorrect central value for even number of elements in range", 3.5, evenNumElemRange.getCentralValue(), 0);
    }
    
    /**
    * Tests the getCentralValue method correctly gets the central value for a 
    * range with negative values
    */
    @Test
    public void testgetCentralValueNegativeRange() {
    	assertEquals("Incorrect central value for range of negative values", -50.5, negativeRange.getCentralValue(), 0);
    }
    
    /**
     * Tests the getCentralValue method correctly gets the central value for a 
     * range of only 1 element (smallest range possible)
     */
     @Test
     public void testgetCentralWithSmallRange() {
     	assertEquals("Incorrect central value for small range of 1 element", 0, smallRange.getCentralValue(), 0);
     }
    
     /**
      * Tests the getCentralValue method correctly gets the central value for 
      * the largest range possible
      */
      @Test
      public void testgetCentralWithLargeRange() {
      	assertEquals("Incorrect central value for largest range possible", -0.5, largeRange.getCentralValue(), 0);
      }
    
      /**
       * Tests the getCentralValue method correctly gets the central value for 
       * a range of double values
       */
       @Test
       public void testgetCentralWithDoubleValues() {
       	assertEquals("Incorrect central value for range of double data type ", 3.85, doubleRange.getCentralValue(), 0.00000001d);
       }
       
       /**
        * Tests the getCentralValue method correctly gets the central value for 
        * a range of negative to positive values
        */
        @Test
        public void testgetCentralWithPositiveToNegativeRange() {
        	assertEquals("Incorrect central value for range from positive to negative ", 0, posToNegRange.getCentralValue(), 0);
        }
        
        /**
         * Tests the getCentralValue method on an invalid range
         */
        @Test
        public void testgetCentralWithInvalidRange() {
            try {
                invalidRange = new Range(6, 2);
                invalidRange.getCentralValue();
                fail("Expected an exception to be thrown");
            } catch (Exception e) {
                assertEquals("Invalid range: end value must be greater than or equal to start value", e.getMessage());
            }
        }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
