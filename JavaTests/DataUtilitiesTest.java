package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jfree.data.KeyedValues;
import org.jfree.data.DefaultKeyedValues;
import org.junit.*;

public class DataUtilitiesTest extends DataUtilities {
    private Mockery mockingContext;
    private Values2D values;
    private KeyedValues data;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        data = mockingContext.mock(KeyedValues.class);

    }

    // Test strategy: This set of tests verifies the behavior of
    // getCumulativePercentages
    // with different input values.
    // Math:
    // Key Value
    // 0 5
    // 1 9
    // 2 2
    //
    // Returns:
    //
    // Key Value
    // 0 0.3125 (5 / 16)
    // 1 0.875 ((5 + 9) / 16)
    // 2 1.0 ((5 + 9 + 2) / 16)

    // Test case 1: Testing with a simple scenario
    @Test
    public void testGetCumulativePercentagesForTwoValues1() {
        mockingContext.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(3));

                allowing(data).getKey(0);
                will(returnValue(0));
                allowing(data).getKey(1);
                will(returnValue(1));
                allowing(data).getKey(2);
                will(returnValue(2));

                allowing(data).getValue(0);
                will(returnValue(5));
                allowing(data).getValue(1);
                will(returnValue(9));
                allowing(data).getValue(2);
                will(returnValue(2));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // Verify that the cumulative percentage for the first value is 0.3125
        assertEquals(0.3125, result.getValue(0));
    }

    // Test case 2: Testing with a simple scenario
    @Test
    public void testGetCumulativePercentagesForTwoValues2() {
        mockingContext.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(3));

                allowing(data).getKey(0);
                will(returnValue(0));
                allowing(data).getKey(1);
                will(returnValue(1));
                allowing(data).getKey(2);
                will(returnValue(2));

                allowing(data).getValue(0);
                will(returnValue(5));
                allowing(data).getValue(1);
                will(returnValue(9));
                allowing(data).getValue(2);
                will(returnValue(2));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // Verify that the cumulative percentage for the second value is 0.875
        assertEquals(0.875, result.getValue(1));
    }

    // Test case 3: Testing with a simple scenario
    @Test
    public void testGetCumulativePercentagesForTwoValues() {
        mockingContext.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(3));

                allowing(data).getKey(0);
                will(returnValue(0));
                allowing(data).getKey(1);
                will(returnValue(1));
                allowing(data).getKey(2);
                will(returnValue(2));

                allowing(data).getValue(0);
                will(returnValue(5));
                allowing(data).getValue(1);
                will(returnValue(9));
                allowing(data).getValue(2);
                will(returnValue(2));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // Verify that the cumulative percentage for the third value is 1.0
        assertEquals(1.0, result.getValue(2));
    }

    // Test strategy: This set of tests verifies the behavior of
    // getCumulativePercentages
    // with different input values, including negative numbers.
    // MATH:
    // Key Value
    // 0 7
    // 1 -2
    // 2 5
    //
    // Returns:
    //
    // Key Value
    // 0 0.7 (7 / 10)
    // 1 0.5 ((7 + (-2)) / 10)
    // 2 1.0 ((7 + (-2) + 5) / 10)

    // Test case 1: Testing with negative numbers
    @Test
    public void testGetCumulativePercentagesForTwoValuesWithNegativeNumber1() {
        mockingContext.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(3));

                allowing(data).getKey(0);
                will(returnValue(0));
                allowing(data).getKey(1);
                will(returnValue(1));
                allowing(data).getKey(2);
                will(returnValue(2));

                allowing(data).getValue(0);
                will(returnValue(7));
                allowing(data).getValue(1);
                will(returnValue(-2)); // Negative number
                allowing(data).getValue(2);
                will(returnValue(5));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // Verify that the cumulative percentage for the first value is 0.7
        assertEquals(0.7, result.getValue(0));
    }

    // Test case 2: Testing with negative numbers
    @Test
    public void testGetCumulativePercentagesForTwoValuesWithNegativeNumber2() {
        mockingContext.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(3));

                allowing(data).getKey(0);
                will(returnValue(0));
                allowing(data).getKey(1);
                will(returnValue(1));
                allowing(data).getKey(2);
                will(returnValue(2));

                allowing(data).getValue(0);
                will(returnValue(7));
                allowing(data).getValue(1);
                will(returnValue(-2)); // Negative number
                allowing(data).getValue(2);
                will(returnValue(5));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // Verify that the cumulative percentage for the second value is 0.5
        assertEquals(0.5, result.getValue(1));
    }

    // Test case 3: Testing with negative numbers
    @Test
    public void testGetCumulativePercentagesForTwoValuesWithNegativeNumber3() {
        mockingContext.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(3));

                allowing(data).getKey(0);
                will(returnValue(0));
                allowing(data).getKey(1);
                will(returnValue(1));
                allowing(data).getKey(2);
                will(returnValue(2));

                allowing(data).getValue(0);
                will(returnValue(7));
                allowing(data).getValue(1);
                will(returnValue(-2)); // Negative number
                allowing(data).getValue(2);
                will(returnValue(5));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // Verify that the cumulative percentage for the third value is 0.5
        assertEquals(0.5, result.getValue(2));
    }

}
