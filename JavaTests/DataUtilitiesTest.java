package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.Random;

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
    private double[] posArray;
    private double[] emptyArray;
    private double[] negArray;
    private double[] mixedArray;
    private double[] boundaryArray;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        data = mockingContext.mock(KeyedValues.class);
        posArray = new double[] { 1.8, 3, 2 };
        emptyArray = new double[] {};
        negArray = new double[] { -6.0, -4.0, -8.0, -21.0, -41.0 };
        mixedArray = new double[] { -1.0, 2.0, -3.0, 4.0, -5.0 };
        boundaryArray = new double[] { Double.MIN_VALUE, Double.MAX_VALUE };

    }

    // -------- Method tested: createNumberArray2D() -----------

    // Objective: Tests the function with an array containing only zero values,
    // checking if it can handle the boundary condition of minimal non-negative
    // values.
    // Type: BVT
    @Test
    public void createFromArrayWithZeros() {

        double[][] data = {
                { 0.0, 0.0 },
                { 0.0, 0.0 }
        };

        Number[][] expected = {
                { 0.0, 0.0 },
                { 0.0, 0.0 }
        };

        assertArrayEquals("creating an arrow with zeros did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Verifies the function's ability to process arrays containing
    // negative values.
    // Type: ECP
    @Test
    public void createFromArrayWithNegativeValues() {

        double[][] data = {
                { -1.0, -10.0 },
                { -100.0, -1000.0 }
        };

        Number[][] expected = {
                { -1.0, -10.0 },
                { -100.0, -1000.0 }
        };

        assertArrayEquals("creating an arrow with negatives did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Tests the function with an array that includes a mix of positive,
    // negative, zero, and special floating-point values (NaN, Infinity).
    // Type: ECP
    @Test
    public void createFromArrayWithMixedValues() {

        double[][] data = {
                { 1.0, -1.0, 0.0 },
                { Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }
        };

        Number[][] expected = {
                { 1.0, -1.0, 0.0 },
                { Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }
        };

        assertArrayEquals("creating an arrow with mixed values did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Checks the function's handling of a minimal array size (single
    // element), testing the boundary condition of the smallest non-empty array.
    // Type: BVT
    @Test
    public void createFromSingleElementArray() {

        double[][] data = {
                { 42.0 }
        };

        Number[][] expected = {
                { 42.0 }
        };

        assertArrayEquals("creating a single element array did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Validates the function with a simple 2x2 array of positive
    // numbers, representing a basic case of a square array with uniform positive
    // values.
    // Type: ECP
    @Test
    public void create2x2Array() {

        double[][] data = {
                { 1.0, 10.0 },
                { 1.0, 10.0 }
        };

        java.lang.Number[][] expected = {
                { 1.0, 10.0 },
                { 1.0, 10.0 }
        };

        assertArrayEquals("creating a 2x2 array did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Assesses the function's performance with a 3x3 array, testing its
    // capability to handle a slightly larger square array of positive values.
    // Type: ECP
    @Test
    public void create3x3Array() {

        double[][] data = {
                { 1.0, 10.0, 20.0 },
                { 1.0, 10.0, 30.0 },
                { 1.0, 10.0, 40.0 }
        };

        java.lang.Number[][] expected = {
                { 1.0, 10.0, 20.0 },
                { 1.0, 10.0, 30.0 },
                { 1.0, 10.0, 40.0 }
        };

        assertArrayEquals("creating a 3x3 array did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Examines the function's ability to process a rectangular
    // (non-square) array, ensuring it can handle arrays with differing row lengths.
    // Type: ECP
    @Test
    public void createNonSquareArray() {

        double[][] data = {
                { 1.0, 10.0, 20.0 },
                { 1.0, 10.0, 30.0 },
        };

        java.lang.Number[][] expected = {
                { 1.0, 10.0, 20.0 },
                { 1.0, 10.0, 30.0 },
        };

        assertArrayEquals("creating a non square array did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Tests the function with arrays having rows of unequal lengths,
    // checking its robustness in handling boundary conditions related to array
    // shapes.
    // Type: BVT
    @Test
    public void createFromNonUniformDataShapes() {

        double[][] data = {
                { 1.0, 10.0, 20.0 },
                { 1.0, 10.0 },
        };

        java.lang.Number[][] expected = {
                { 1.0, 10.0, 20.0 },
                { 1.0, 10.0 },
        };

        assertArrayEquals("creating a non uniform shape array did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Validates the function's capability to handle a large 100x100
    // array, testing performance and scalability.
    // Type: BVT
    @Test
    public void createLargeArray() {
        int SIZE = 100;
        Random rng = new Random();

        double[][] data = new double[SIZE][SIZE];
        Number[][] expected = new Number[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                double value = rng.nextDouble();
                data[i][j] = value;
                expected[i][j] = value;
            }
        }

        Number[][] actual = DataUtilities.createNumberArray2D(data);
        assertArrayEquals("The generated Number[][] array should match the expected array with random values.",
                expected, actual);
    }

    // Objective: Ensures the function correctly handles an empty array, testing the
    // boundary condition of no data.
    // Type: BVT
    @Test
    public void emptyArguments() {

        double[][] data = {};

        java.lang.Number[][] expected = {};

        assertArrayEquals("creating an array of empty arguments did not give the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Checks the function's error handling when given invalid data (NaN
    // values), expecting an exception.
    // Type: BVT
    @Test
    public void createFromInvalidData() {
        double[][] data = { { Double.NaN }, { Double.NaN } };

        try {
            DataUtilities.createNumberArray2D(data);
            fail("Expected an InvalidParameterException to be thrown");
        } catch (InvalidParameterException e) {
        }
    }

    // Objective: Verifies the function's behavior with null input, expecting an
    // exception to ensure robust error handling.
    // Type: BVT
    @Test
    public void createFromNullData() {
        double[][] data = null;

        try {
            DataUtilities.createNumberArray2D(data);
            fail("Expected an InvalidParameterException to be thrown");
        } catch (InvalidParameterException e) {
        } catch (Exception e) {
            fail("Expected an InvalidParameterException, but caught a different exception");
        }
    }

    // Objective: Tests the function with the maximum double value, assessing its
    // handling of extreme boundary values.
    // Type: BVT
    @Test
    public void createFromMaxValues() {
        double[][] data = { { Double.MAX_VALUE, Double.MAX_VALUE } };
        java.lang.Number[][] expected = { { Double.MAX_VALUE, Double.MAX_VALUE } };

        assertArrayEquals("Creating an array with max values did not give the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Examines the function's response to positive infinity values,
    // representing a special value class.
    // Type: ECP
    @Test
    public void createFromPosInfs() {
        double[][] data = { { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY } };
        java.lang.Number[][] expected = { { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY } };

        assertArrayEquals("Creating an array of positive infinity values did not give the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Evaluates the function with the smallest positive double value,
    // checking its processing at the lower boundary.
    // Type: BVT
    @Test
    public void createFromMinValues() {
        double[][] data = { { Double.MIN_VALUE, Double.MIN_VALUE } };
        java.lang.Number[][] expected = { { Double.MIN_VALUE, Double.MIN_VALUE } };

        assertArrayEquals("Creating an array with min values did not give the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Tests the function with negative infinity values to see how it
    // handles this special class of inputs.
    // Type: ECP
    @Test
    public void createFromNegInfs() {
        double[][] data = { { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY } };
        java.lang.Number[][] expected = { { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY } };

        assertArrayEquals("Creating an array of positive infinity values did not give the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Challenges the function with values just below the maximum double
    // value, probing near-boundary conditions.
    // Type: BVT
    @Test
    public void createFromNearlyMaxValues() {

        double[][] data = {
                { Double.MAX_VALUE - 1, Double.MAX_VALUE - 1 }
        };

        Number[][] expected = {
                { Double.MAX_VALUE - 1, Double.MAX_VALUE - 1 }
        };

        assertArrayEquals("Creating an array with nearly max values did not give the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Assesses the function's precision and range with extremely large
    // and small exponent values, testing boundary handling.
    // Type: BVT
    @Test
    public void createFromVeryLargeAndSmallExponents() {

        double[][] data = {
                { 1e307, 1e-307 },
                { -1e307, -1e-307 }
        };

        Number[][] expected = {
                { 1e307, 1e-307 },
                { -1e307, -1e-307 }
        };

        assertArrayEquals("creating an array with large and small exponenets did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // Objective: Verifies the function's precision with values that exceed the
    // typical double precision, exploring its numerical accuracy.
    // Type: ECP
    @Test
    public void createFromHighPrecisionValues() {

        double[][] data = {
                { 1.1234567890123456, 1.1234567890123457 }, // Beyond double's precision
                { -1.1234567890123456, -1.1234567890123457 }
        };

        Number[][] expected = {
                { 1.1234567890123456, 1.1234567890123457 },
                { -1.1234567890123456, -1.1234567890123457 }
        };

        assertArrayEquals("creating an array with high precision values did not return the expected array", expected, DataUtilities.createNumberArray2D(data));
    }

    // -------- Method tested: createNumberArray() -----------

    // Test the creation of number array with valid input. Checks the arrays length
    // type: ECP
    @Test
    public void testCreateNumberArrayLength() {
        java.lang.Number[] result = DataUtilities.createNumberArray(posArray);
        assertEquals("Array length mismatch", posArray.length, result.length);
    }

    // Test the creation of number array with valid input. Checks the values of the
    // elements
    // type: ECP
    @Test
    public void testCreateNumberArrayElementsValue() {
        java.lang.Number[] result = DataUtilities.createNumberArray(posArray);
        for (int i = 0; i < posArray.length - 1; i++) {
            assertEquals("Element at index " + i + " has incorrect value", posArray[i], result[i].doubleValue(),
                    0.000001d);
        }
    }

    // Test the creation of number array with an empty input array
    // type: BVT
    @Test
    public void testCreateNumberArrayWithEmptyArray() {
        java.lang.Number[] result = DataUtilities.createNumberArray(emptyArray);
        assertNotNull(result);
        assertEquals("array length was not 0 for input of empty array", 0, result.length);
    }

    // Test the creation of number array with negative values. Checks the arrays
    // length
    // type: ECP
    @Test
    public void testCreateNumberArrayWithNegativeValuesArrayLength() {
        java.lang.Number[] result = DataUtilities.createNumberArray(negArray);
        assertNotNull(result);
        assertEquals("array length did not match original array input length", negArray.length, result.length);
    }

    // Test the creation of number array with negative values. Checks the values of
    // the elements
    // type: ECP
    @Test
    public void testCreateNumberArrayWithNegativeValuesArrayElements() {
        java.lang.Number[] result = DataUtilities.createNumberArray(negArray);
        for (int i = 0; i < negArray.length - 1; i++) {
            assertEquals("Element at index \" + i + \" has incorrect value", negArray[i], result[i].doubleValue(), 0.000001);
        }
    }

    // Test the creation of number array with mixed values. Checks the arrays length
    // type: ECP
    @Test
    public void testCreateNumberArrayWithMixedValuesArrayLength() {
        java.lang.Number[] result = DataUtilities.createNumberArray(mixedArray);
        assertNotNull("returned array was null", result);
        assertEquals("array length did not match original array input length", mixedArray.length, result.length);
    }

    // Test the creation of number array with mixed values. Checks the values of the
    // elements
    // type: ECP
    @Test
    public void testCreateNumberArrayWithMixedValuesArrayElements() {
        java.lang.Number[] result = DataUtilities.createNumberArray(mixedArray);
        for (int i = 0; i < mixedArray.length - 1; i++) {
            assertEquals("Element at index \" + i + \" has incorrect value", mixedArray[i], result[i].doubleValue(), 0.000001);
        }
    }

    // Test the creation of number array with null input data, expecting an
    // IllegalArgumentException
    // type: BVT
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArrayNull() {
        DataUtilities.createNumberArray(null);
    }

    // Test the creation of number array with invalid data, expecting an
    // InvalidParameterException
    // type: ECP
    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArrayInvalidData() {
        double[] invalidData = { Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY };
        DataUtilities.createNumberArray(invalidData);
    }

    // Test the creation of number array with boundary values (min and max values of
    // double type)
    // type: BVT
    @Test
    public void testCreateNumberArrayBoundary() {
        java.lang.Number[] expected = { Double.MIN_VALUE, Double.MAX_VALUE };
        assertArrayEquals("created array from createNumberArray did not match expected Number array", expected, DataUtilities.createNumberArray(boundaryArray));
    }

    // -------- Method tested: getCumulativePercentages() -----------

    // Test case 1: Testing with a simple scenario from the example on the javadoc
    // page:
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
    // type: ECP
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

        // Verify that the cumulative percentage for the first value is 0.3125
        assertEquals("cumulative percentage for first value did not match expected value", 0.3125, result.getValue(0));
        // Verify that the cumulative percentage for the second value is 0.875
        assertEquals("cumulative percentage for second value did not match expected value", 0.875, result.getValue(1));
        // Verify that the cumulative percentage for the third value is 1.0
        assertEquals("cumulative percentage for third value did not match expected value", 1.0, result.getValue(2));
    }

    // Test strategy: This set of tests verifies the behavior of
    // getCumulativePercentages
    // with different input values, including negative numbers.
    // Test case 2: Testing with a simple scenario I made up:
    // (Key Value) Input values
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
    // type: ECP
    @Test
    public void testGetCumulativePercentagesForTwoValuesWithNegativeNumber() {
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
        assertEquals("cumulative percentage for first value did not match expected value", 0.7, result.getValue(0));
        // Verify that the cumulative percentage for the second value is 0.5
        assertEquals("cumulative percentage for second value did not match expected value", 0.5, result.getValue(1));
        // Verify that the cumulative percentage for the third value is 1.0
        assertEquals("cumulative percentage for third value did not match expected value", 1.0, result.getValue(2));
    }

    // ---------- Tests for calculateColumnTotal ----------

    /**
     * Test strategy:
     * This set of tests verifies the behavior of calculateColumnTotal
     * with different input values, including negative numbers, null values, and
     * edge cases.
     * 
     * returns:
     * The sum of a row in a particular column
     **/

    // This test verifies the calculation of the column total for a dataset with two
    // values.
    // type: ECP
    @Test
    public void calculateColumnTotalForTwoValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals("result from calculating the column total did not match the expected output", result, 10.0, .000000001d);
    }

    // Test To check columnTotal for 5 negative values in a column
    // type: ECP
    @Test
    public void calculateColumnTotalFor5NegativeValues() {
        // Setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(5));
                one(values).getValue(0, 0);
                will(returnValue(-7.5));
                one(values).getValue(1, 0);
                will(returnValue(-2.5));
                one(values).getValue(2, 0);
                will(returnValue(-3.5));
                one(values).getValue(3, 0);
                will(returnValue(-4.5));
                one(values).getValue(4, 0);
                will(returnValue(-5.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("Sum of 5 negative values was unexpected.", -23.5, result, .000000001d);
    }

    // Test To check sum of mixed negative and positive values in a column
    // type: ECP
    @Test
    public void calculateColumnTotalForMixedPositiveAndNegativeValues() {
        // Setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(4));
                one(values).getValue(0, 0);
                will(returnValue(-7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(3.5));
                one(values).getValue(3, 0);
                will(returnValue(-4.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("Sum of mixed positive and negative values was unexpected.", -6.0, result, .000000001d);
    }

    // Test to check if an empty matrix of rows and columns can be handled
    // type: BVT
    @Test
    public void calculateColumnTotalForEmptyData() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(0));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("Sum was unexpected when handling an empty matrix.", 0, result, .000000001d);
    }

    // Test to check if a large number of rows can be handled
    // type: BVT
    @Test
    public void calculateColumnTotalForLargeNumberOfRows() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(100));
                for (int i = 0; i < 100; i++) {
                    one(values).getValue(i, 0);
                    will(returnValue(2));
                }
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("Sum of Large Number of Rows was unexpected.", 200, result, .000000001d);
    }

    // test to check if the sum is 0 when a column contains a null value
    // type: ECP
    @Test
    public void calculateColumnTotalThatContainsANullValue() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(4));
                one(values).getValue(0, 0);
                will(returnValue(null));
                one(values).getValue(1, 0);
                will(returnValue(5));
                one(values).getValue(2, 0);
                will(returnValue(7.5));
                one(values).getValue(3, 0);
                will(returnValue(8.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("Sum was unexpected when handling null value in column.", 0, result, .000000001d);
    }

    // test to check if value when a column contains is an invalid index
    // type: BVT
    @Test
    public void calculateColumnTotalThatContainsInvalidColumnIndex() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	one(values).getColumnCount();
                will(returnValue(2));
                allowing(values).getRowCount();
                will(returnValue(2)); // Ensure that the getColumnCount() method returns an appropriate value
                allowing(values).getValue(with(any(int.class)), with(any(int.class)));
                will(returnValue(0.0));
            }
        });
        try {
            double result = DataUtilities.calculateColumnTotal(values, -4);
            assertEquals("Sum was unexpected when handling invalud index in column.", 0, result, .000000001d);
        } catch (Exception e) {
            // Handle the exception here
            assertTrue("Raised an exception" + e + ". Should have return 0 as per documentation.", false);
        }
    }

    // Test To check sum of a large indexed column
    // type: BVT
    @Test
    public void calculateColumnTotalForLargeColumnIndex() {
        // Setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(4));
                one(values).getValue(0, 100);
                will(returnValue(7.5));
                one(values).getValue(1, 100);
                will(returnValue(2.5));
                one(values).getValue(2, 100);
                will(returnValue(3.5));
                one(values).getValue(3, 100);
                will(returnValue(4.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 100);
        assertEquals("Sum of Large Column Index was unexpected.", 18.0, result, .000000001d);
    }

    // --------- tests for calculateRowTotal() method ------------

    /**
     * Test strategy:
     * This set of tests verifies the behavior of calculateRowTotal
     * with different input values, including negative numbers, null values, and
     * edge cases.
     * 
     * returns:
     * The sum of a Column in a particular row
     **/

    // Test to calculate the total for a row with two values
    // type: ECP
    @Test
    public void calculateRowTotalForTwoValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("result from calculating the row total did not match the expected output", result, 10.0, .000000001d);
    }

    // Test To check rowTotal for 5 negative values in a row
    // type: ECP
    @Test
    public void calculateRowTotalFor5NegativeValues() {
        // Setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(5));
                one(values).getValue(0, 0);
                will(returnValue(-7.5));
                one(values).getValue(0, 1);
                will(returnValue(-2.5));
                one(values).getValue(0, 2);
                will(returnValue(-3.5));
                one(values).getValue(0, 3);
                will(returnValue(-4.5));
                one(values).getValue(0, 4);
                will(returnValue(-5.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("Sum of 5 negative values was unexpected.", -23.5, result, .000000001d);
    }

    // Test To check sum of mixed negative and positive values in a row
    // type: ECP
    @Test
    public void calculateRowTotalForMixedPositiveAndNegativeValues() {
        // Setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(4));
                one(values).getValue(0, 0);
                will(returnValue(-7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
                one(values).getValue(0, 2);
                will(returnValue(3.5));
                one(values).getValue(0, 3);
                will(returnValue(-4.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("Sum of mixed positive and negative values was unexpected.", -6.0, result, .000000001d);
    }

    // Test to check if an empty matrix of rows and columns can be handled
    // type: BVT
    @Test
    public void calculateRowTotalForEmptyData() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(0));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("Sum was unexpected when handling an empty matrix.", 0, result, .000000001d);
    }

    // Test to check if a large number of rows can be handled
    // type: BVT
    @Test
    public void calculateRowTotalForLargeNumberOfColumns() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(100));
                for (int i = 0; i < 100; i++) {
                    one(values).getValue(0, i);
                    will(returnValue(2));
                }
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("Sum of Large Number of Rows was unexpected.", 200, result, .000000001d);
    }

    // test to check if the sum is 0 when a column contains a null value
    // type: ECP
    @Test
    public void calculateRowTotalThatContainsANullValue() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(4));
                one(values).getValue(0, 0);
                will(returnValue(null));
                one(values).getValue(0, 1);
                will(returnValue(5));
                one(values).getValue(0, 2);
                will(returnValue(7.5));
                one(values).getValue(0, 3);
                will(returnValue(8.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("Sum was unexpected when handling null value in Row.", 0, result, .000000001d);
    }

    // test to check if value when a column contains is an invalid index
    // type: BVT
    @Test
    public void calculateRowTotalThatContainsInvalidRowIndex() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	one(values).getRowCount();
                will(returnValue(2));
                allowing(values).getColumnCount();
                will(returnValue(2)); // Ensure that the getColumnCount() method returns an appropriate value
                allowing(values).getValue(with(any(int.class)), with(any(int.class)));
                will(returnValue(0.0));
            }
        });
        try {
            double result = DataUtilities.calculateRowTotal(values, -4);
            assertEquals("Sum was unexpected when handling invalid index in row.", 0, result, .000000001d);
        } catch (InvalidParameterException e) {
            // Handle the exception here
            fail("Raised an exception" + e + ". Should have return 0 as per documentation.");
        }
    }

    // Test To check sum of a large indexed column
    // type: BVT
    @Test
    public void calculateRowTotalForLargeRowIndex() {
        // Setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(4));
                one(values).getValue(100, 0);
                will(returnValue(7.5));
                one(values).getValue(100, 1);
                will(returnValue(2.5));
                one(values).getValue(100, 2);
                will(returnValue(3.5));
                one(values).getValue(100, 3);
                will(returnValue(4.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 100);
        assertEquals("Sum of Large Row Index was unexpected.", 18.0, result, .000000001d);
    }

}
