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

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
