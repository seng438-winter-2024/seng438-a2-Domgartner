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
    double[] posArray;
    double[] emptyArray;
    double[] negArray;
    double[] mixedArray;
    double[] boundaryArray;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        data = mockingContext.mock(KeyedValues.class);
        posArray = new double[]{1.8, 3, 2};
        emptyArray = new double[]{};
        negArray = new double[]{-6.0, -4.0, -8.0, -21.0, -41.0};
        mixedArray = new double[]{-1.0, 2.0, -3.0, 4.0, -5.0};
        boundaryArray = new double[]{Double.MIN_VALUE, Double.MAX_VALUE};

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


    // Test the creation of number array with valid input. Checks the arrays length
    @Test
    public void testCreateNumberArrayLength() {
        java.lang.Number[] result = DataUtilities.createNumberArray(posArray);
        assertEquals("Array length mismatch", posArray.length, result.length);
    }

    // Test the creation of number array with valid input. Checks the values of the elements
    @Test
    public void testCreateNumberArrayElementsValue() {
        java.lang.Number[] result = DataUtilities.createNumberArray(posArray);
        for (int i = 0; i < posArray.length - 1; i++) {
            assertEquals("Element at index " + i + " has incorrect value", posArray[i], result[i].doubleValue(), 0.000001d);
        }
    }

    // Test the creation of number array with an empty input array
    @Test
    public void testCreateNumberArrayWithEmptyArray() {
        java.lang.Number[] result = DataUtilities.createNumberArray(emptyArray);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    // Test the creation of number array with negative values. Checks the arrays length
    @Test
    public void testCreateNumberArrayWithNegativeValuesArrayLength() {
        java.lang.Number[] result = DataUtilities.createNumberArray(negArray);
        assertNotNull(result);
        assertEquals(negArray.length, result.length);
    }

    // Test the creation of number array with negative values. Checks the values of the elements
    @Test
    public void testCreateNumberArrayWithNegativeValuesArrayElements() {
        java.lang.Number[] result = DataUtilities.createNumberArray(negArray);
        for (int i = 0; i < negArray.length - 1; i++) {
            assertEquals(negArray[i], result[i].doubleValue(), 0.000001);
        }
    }

    // Test the creation of number array with mixed values. Checks the arrays length
    @Test
    public void testCreateNumberArrayWithMixedValuesArrayLength() {
        java.lang.Number[] result = DataUtilities.createNumberArray(mixedArray);
        assertNotNull(result);
        assertEquals(mixedArray.length, result.length);
    }

    // Test the creation of number array with mixed values. Checks the values of the elements
    @Test
    public void testCreateNumberArrayWithMixedValuesArrayElements() {
        java.lang.Number[] result = DataUtilities.createNumberArray(mixedArray);
        for (int i = 0; i < mixedArray.length - 1; i++) {
            assertEquals(mixedArray[i], result[i].doubleValue(), 0.000001);
        }
    }

    // Test the creation of number array with null input data, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArrayNull() {
        DataUtilities.createNumberArray(null);
    }

    // Test the creation of number array with invalid data, expecting an InvalidParameterException
    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArrayInvalidData() {
        double[] invalidData = {Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY};
        DataUtilities.createNumberArray(invalidData);
    }

    // Test the creation of number array with boundary values (min and max values of double type)
    @Test
    public void testCreateNumberArrayBoundary() {
        java.lang.Number[] expected = {Double.MIN_VALUE, Double.MAX_VALUE};
        assertArrayEquals(expected, DataUtilities.createNumberArray(boundaryArray));
    }


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
