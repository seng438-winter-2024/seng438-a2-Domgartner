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

    // -------- Tests for getLowerBound() method -----------

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // range of values negative to positive
    // type: ECP
    @Test
    public void postiveToNegativeRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range from positive to negative values
        assertEquals("Lower bound should be -1",
                -1.0, postiveToNegativeRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // range of negative values
    // type: ECP
    @Test
    public void negativeRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range of negative values
        assertEquals("Lower bound should be -100",
                -100, negativeRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // range of positive values
    // type: ECP
    @Test
    public void PosNumRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range of positive values
        assertEquals("Lower bound should be 1",
                1, PosNumRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // small range of only 1 value
    // type: BVT
    @Test
    public void smallRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a small range
        assertEquals("Lower bound should be 0",
                0, smallRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // large range max value integers
    // type: BVT
    @Test
    public void largeRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a large range
        assertEquals("Lower bound should be -2^32",
                Integer.MIN_VALUE, largeRange.getLowerBound(), .000000001d);
    }

    // Tests if the getLowerBound() method correctly gets the lower bound for a
    // range using double values
    // type: ECP
    @Test
    public void doubleRangelowerBoundReturnsCorrectValue() {
        // Ensure lower bound is correct for a range of double values
        assertEquals("Lower bound should be 1.1",
                1.1, doubleRange.getLowerBound(), .000000001d);
    }

    // ------- tests for getCentralValue() method --------

    /**
     * Tests the getCentralValue method correctly gets the central value for a
     * range with an odd number of elements
     * type: ECP
     */
    @Test
    public void testgetCentralValueWithOddNumberofElements() {
        assertEquals("Incorrect central value for odd number of elements in range. Expected 3", 3,
                oddNumElemRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for a
     * range with an even number of elements
     * type: ECP
     */
    @Test
    public void testgetCentralValueWithEvenNumberofElements() {
        assertEquals("Incorrect central value for even number of elements in range. Expected 3.5", 3.5,
                evenNumElemRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for a
     * range with negative values
     * type: ECP
     */
    @Test
    public void testgetCentralValueNegativeRange() {
        assertEquals("Incorrect central value for range of negative values. Expected -50.5", -50.5, negativeRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for a
     * range of only 1 element (smallest range possible)
     * type: BVT
     */
    @Test
    public void testgetCentralWithSmallRange() {
        assertEquals("Incorrect central value for small range of 1 element. Expected 0", 0, smallRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for
     * the largest range possible
     * type: BVT
     */
    @Test
    public void testgetCentralWithLargeRange() {
        assertEquals("Incorrect central value for largest range possible. Expected -0.5", -0.5, largeRange.getCentralValue(), 0);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for
     * a range of double values
     * type: ECP
     */
    @Test
    public void testgetCentralWithDoubleValues() {
        assertEquals("Incorrect central value for range of double data type. Expected 3.85", 3.85, doubleRange.getCentralValue(),
                0.00000001d);
    }

    /**
     * Tests the getCentralValue method correctly gets the central value for
     * a range of negative to positive values
     * type: ECP
     */
    @Test
    public void testgetCentralWithPositiveToNegativeRange() {
        assertEquals("Incorrect central value for range from positive to negative. Expected 0", 0, posToNegRange.getCentralValue(),
                0);
    }

    /**
     * Tests the getCentralValue method on an invalid range
     * type: ECP
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

    // ------------ Testing constrain() Function ----------------

    // Test case to ensure the constrain method returns a positive value within the
    // specified range.
    // type: ECP
    @Test
    public void constrainShouldEqualAPositiveValue() {
        assertEquals("The constrain value of 30.3 in range 1 to 100 should be 30.3",
                30.3, posNumRange.constrain(30.3), .000000001d);
    }

    // Test case to ensure the constrain method returns a negative value within the
    // specified range.
    // type: ECP
    @Test
    public void constrainShouldEqualANegativeValue() {
        assertEquals("The constrain value of -30.3 in range -100 to -1 should be -30.3",
                -30.3, negativeRange.constrain(-30.3), .000000001d);
    }

    // Test case to ensure the constrain method returns zero within the specified
    // range.
    // type: ECP
    @Test
    public void constrainShouldEqualZero() {
        assertEquals("The constrain value of 0 in range -1 to 1 should be 0",
                0, negToPosRange.constrain(0), .000000001d);
    }

    // Test case to ensure the constrain method returns the upper boundary value
    // within the specified range.
    // type: BVT
    @Test
    public void constrainShouldBeHigherThanUpperBoundaryValue() {
        assertEquals("The constrain value of 10000 in range 1 to 100 should be 100",
                100, posNumRange.constrain(10000), .000000001d);
    }

    // Test case to ensure the constrain method returns the lower boundary value
    // within the specified range.
    // type: BVT
    @Test
    public void constrainShouldBeLowerThanLowerBoundaryValue() {
        assertEquals("The constrain value of -10000 in range -100 to 1 should be -100",
                -100, negativeRange.constrain(-10000), .000000001d);
    }

    // Test case to ensure the constrain method returns the lower boundary value
    // within the specified range.
    // type: BVT
    @Test
    public void constrainEqualsLowerBoundaryValue() {
        assertEquals("The constrain value of -100 in range -100 to 1 should be -100",
                -100, negativeRange.constrain(-100), .000000001d);
    }

    // Test case to ensure the constrain method returns the upper boundary value
    // within the specified range.
    // type: BVT
    @Test
    public void constrainEqualsUpperBoundaryValue() {
        assertEquals("The constrain value of 100 in range 1 to 100 should be 100",
                100, posNumRange.constrain(100), .000000001d);
    }

    // Test case to ensure a constrain close to upper boundary value returns the
    // constrain.
    // type: BVT
    @Test
    public void constrainCloseToUpperBoundaryValue() {
        assertEquals("The constrain value of 99.9 in range 1 to 100 should be 99.9",
                99.9, posNumRange.constrain(99.9), .000000001d);
    }

    // Test case to ensure a constrain close to lower boundary value returns the
    // constrain.
    // type: BVT
    @Test
    public void constrainCloseToLowerBoundaryValue() {
        assertEquals("The constrain value of 1.99 in range 1 to 100 should be 1.99",
                1.99, posNumRange.constrain(1.99), .000000001d);
    }

    // ----------- Testing intersects Function ---------------

    // Test two ranges where one completely overlaps the other
    // type: ECP
    @Test
    public void testCompletelyOverlappingRanges() {

        assertTrue("When one range completely overlaps the other, intersects() should return true.",
                evenNumElemRange.intersects(2, 3));
    }

    // Test two ranges where they partially overlap
    // type: ECP
    @Test
    public void testPartiallyOverlappingRanges() {
        assertTrue("When one range partially overlaps the other, intersects() should return true.",
                posNumRange.intersects(-10.3, 10.4));

    }

    // Tests the intersects() method of Range class with two different ranges that
    // share an upper endpoint.
    // type: BVT
    @Test
    public void testRangesWithSharedUpperBoundary() {
        assertTrue(
                "When two different ranges share an upper endpoint with one another, intersects() should return true.",
                posNumRange.intersects(-5, 100));
    }

    // Test two ranges with the same range
    // type: BVT
    @Test
    public void testRangesWithSameBoundaries() {
        assertTrue(
                "When two different ranges share an both endpoints with one another, intersects() should return true.",
                negToPosRange.intersects(-1, 1));
    }

    // Test two ranges where one range is completely before the other
    // type: ECP
    @Test
    public void testRangesCompletelyBefore() {

        assertFalse("When one range is completey before the other Range, intersects() should return False.",
                negToPosRange.intersects(-10.5, -5.6));
    }

    // Test two ranges where one range is completely after the other
    // type: ECP
    @Test
    public void testRangesCompletelyAfter() {

        assertFalse("When one range is completey after the other Range, intersects() should return False.",
                negToPosRange.intersects(10.4, 30.6));
    }

    // ----------- Testing combine Function ---------------

    // Objective: Test if one valid range and a null range can be combined.
    // Type: ECP
    @Test
    public void combineValidrangeAndNullRange() {
        Range rangeA = new Range(0, 1);

        try {
            Range res = Range.combine(rangeA, null);
            assertEquals(
                    "If first argument is null, and the second is a valid range, the second range should be returned.",
                    rangeA, res);
        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }
    }

    // Objective: Test if one null range and a valid range can be combined.
    // Type: ECP
    @Test
    public void combineNullrangeAndValidRange() {
        Range rangeB = new Range(0, 1);

        try {
            Range res = Range.combine(rangeB, null);
            assertEquals(
                    "If first argument is a valid range, and the second is null, the second range should be returned.",
                    rangeB, res);
        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }
    }

    // Objective: Test if two null ranges can be combined.
    // Type: ECP
    @Test
    public void combineNullRanges() {

        try {
            Range res = Range.combine(null, null);
            assertEquals("Combining two null ranges returns null.", null, res);
        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }

    }

    // Objective: Test if an empty range and valid range can be combined.
    // Type: BVT
    @Test
    public void combineEmptyRangeAndValidRange() {
        Range rangeA = new Range(0, 0);
        Range rangeB = new Range(0, 1);

        assertEquals("New range must subsume empty and valid ranges.", rangeB, Range.combine(rangeA, rangeB));
    }

    // Objective: Test if a valid range and empty range can be combined.
    // Type: BVT
    @Test
    public void combineValidRangeAndEmptyRange() {
        Range rangeA = new Range(0, 1);
        Range rangeB = new Range(0, 0);

        assertEquals("New range must subsume valid and empty ranges.", rangeA, Range.combine(rangeA, rangeB));
    }

    // Objective: Test if two empty ranges can be combined.
    // Type: BVT
    @Test
    public void combineEmptyRanges() {
        Range rangeA = new Range(0, 0);
        Range rangeB = new Range(0, 0);

        Range emptyRange = new Range(0, 0);

        assertEquals("New range must return empty range.", emptyRange, Range.combine(rangeA, rangeB));
    }

    // Objective: Test if two non-identical ranges (both empty) can be combined.
    // Type: BVT
    @Test
    public void combineNonIdenticalEmptyRanges() {
        Range rangeA = new Range(10, 10);
        Range rangeB = new Range(5, 5);

        Range emptyRange = new Range(0, 0);

        assertEquals("New range must return arange that subsumes both empty ranges.", emptyRange,
                Range.combine(rangeA, rangeB));
    }

    // Objective: Test if superset and subset ranges can be combined.
    // Type: ECP
    @Test
    public void combineValidRangeAndSubsetRange() {
        Range rangeA = new Range(0, 5);
        Range rangeB = new Range(-10, 10);
        Range expected = new Range(-10, 10);
        assertEquals("Combining two valid ranges where one is a subset should return the superset.", expected,
                Range.combine(rangeA, rangeB));
    }

    // Objective: Test if superset and subset ranges can be combined.
    // Type: ECP
    @Test
    public void combineSubsetRangeAndValidRange() {
        Range rangeA = new Range(-10, 10);
        Range rangeB = new Range(0, 5);
        Range expected = new Range(-10, 10);

        try {
            Range res = Range.combine(rangeA, rangeB);
            assertEquals("Combining two valid ranges where one is a subset should return the superset.", expected, res);
        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }

    }

    // Objective: Test if touching ranges can be combined.
    // Type: ECP
    @Test
    public void combineTouchingValidRanges() {
        Range rangeA = new Range(0, 5);
        Range rangeB = new Range(5, 15);
        Range expected = new Range(0, 15);

        try {
            Range res = Range.combine(rangeA, rangeB);
            assertEquals("Combining two touching valid ranges should result in an expected superset range", expected,
                    res);

        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }
    }

    // Objective: Test if overlapping ranges can be combined.
    // Type: ECP
    @Test
    public void combineOverlappingValidRanges() {
        Range rangeA = new Range(0, 5);
        Range rangeB = new Range(1, 15);
        Range expected = new Range(0, 15);

        try {
            Range res = Range.combine(rangeA, rangeB);
            assertEquals("Combining two overlapping valid ranges should result in an expected superset range", expected,
                    res);

        } catch (Exception e) {
            fail("Combining these values should not throw an error.");
        }
    }

    // Objective: Test if identical ranges can be combined.
    // Type: BVT
    @Test
    public void combineIdenticalValidRanges() {
        Range rangeA = new Range(1, 5);
        Range rangeB = new Range(1, 5);
        Range expected = new Range(1, 5);
        assertEquals("Combining two identical valid ranges should result in a third identical range", expected,
                Range.combine(rangeA, rangeB));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
