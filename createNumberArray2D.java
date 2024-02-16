// package org.jfree.data.test;

// import static org.junit.Assert.*;

// import java.security.InvalidParameterException;

// import org.jfree.data.DataUtilities;

// import org.junit.Test;
// import java.util.Random;

// /*
// * DESCRIPTION

// Constructs an array of arrays of Number objects from a corresponding
// structure containing double primitives.

// Parameters:
// data - An array of double primitives (null not permitted).

// Returns:
// An array of Number objects.

// Throws:
// InvalidParameterException - if invalid data object is passed in.

// */

// public class createNumberArray2D extends DataUtilities {

// // Objective: Tests the function with an array containing only zero values,
// // checking if it can handle the boundary condition of minimal non-negative
// // values.
// // Type: BVT
// @Test
// public void createFromArrayWithZeros() {

// double[][] data = {
// { 0.0, 0.0 },
// { 0.0, 0.0 }
// };

// Number[][] expected = {
// { 0.0, 0.0 },
// { 0.0, 0.0 }
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Verifies the function's ability to process arrays containing
// // negative values.
// // Type: ECP
// @Test
// public void createFromArrayWithNegativeValues() {

// double[][] data = {
// { -1.0, -10.0 },
// { -100.0, -1000.0 }
// };

// Number[][] expected = {
// { -1.0, -10.0 },
// { -100.0, -1000.0 }
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Tests the function with an array that includes a mix of
// positive,
// // negative, zero, and special floating-point values (NaN, Infinity).
// // Type: ECP
// @Test
// public void createFromArrayWithMixedValues() {

// double[][] data = {
// { 1.0, -1.0, 0.0 },
// { Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }
// };

// Number[][] expected = {
// { 1.0, -1.0, 0.0 },
// { Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Checks the function's handling of a minimal array size (single
// // element), testing the boundary condition of the smallest non-empty array.
// // Type: BVT
// @Test
// public void createFromSingleElementArray() {

// double[][] data = {
// { 42.0 }
// };

// Number[][] expected = {
// { 42.0 }
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Validates the function with a simple 2x2 array of positive
// // numbers, representing a basic case of a square array with uniform positive
// // values.
// // Type: ECP
// @Test
// public void create2x2Array() {

// double[][] data = {
// { 1.0, 10.0 },
// { 1.0, 10.0 }
// };

// java.lang.Number[][] expected = {
// { 1.0, 10.0 },
// { 1.0, 10.0 }
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Assesses the function's performance with a 3x3 array, testing
// its
// // capability to handle a slightly larger square array of positive values.
// // Type: ECP
// @Test
// public void create3x3Array() {

// double[][] data = {
// { 1.0, 10.0, 20.0 },
// { 1.0, 10.0, 30.0 },
// { 1.0, 10.0, 40.0 }
// };

// java.lang.Number[][] expected = {
// { 1.0, 10.0, 20.0 },
// { 1.0, 10.0, 30.0 },
// { 1.0, 10.0, 40.0 }
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Examines the function's ability to process a rectangular
// // (non-square) array, ensuring it can handle arrays with differing row
// lengths.
// // Type: ECP
// @Test
// public void createNonSquareArray() {

// double[][] data = {
// { 1.0, 10.0, 20.0 },
// { 1.0, 10.0, 30.0 },
// };

// java.lang.Number[][] expected = {
// { 1.0, 10.0, 20.0 },
// { 1.0, 10.0, 30.0 },
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Tests the function with arrays having rows of unequal lengths,
// // checking its robustness in handling boundary conditions related to array
// // shapes.
// // Type: BVT
// @Test
// public void createFromNonUniformDataShapes() {

// double[][] data = {
// { 1.0, 10.0, 20.0 },
// { 1.0, 10.0 },
// };

// java.lang.Number[][] expected = {
// { 1.0, 10.0, 20.0 },
// { 1.0, 10.0 },
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Validates the function's capability to handle a large 100x100
// // array, testing performance and scalability.
// // Type: BVT
// @Test
// public void createLargeArray() {
// int SIZE = 100;
// Random rng = new Random();

// double[][] data = new double[SIZE][SIZE];
// Number[][] expected = new Number[SIZE][SIZE];

// for (int i = 0; i < SIZE; i++) {
// for (int j = 0; j < SIZE; j++) {
// double value = rng.nextDouble();
// data[i][j] = value;
// expected[i][j] = value;
// }
// }

// Number[][] actual = DataUtilities.createNumberArray2D(data);
// assertArrayEquals("The generated Number[][] array should match the expected
// array with random values.",
// expected, actual);
// }

// // Objective: Ensures the function correctly handles an empty array, testing
// the
// // boundary condition of no data.
// // Type: BVT
// @Test
// public void emptyArguments() {

// double[][] data = {};

// java.lang.Number[][] expected = {};

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Checks the function's error handling when given invalid data
// (NaN
// // values), expecting an exception.
// // Type: BVT
// @Test
// public void createFromInvalidData() {
// double[][] data = { { Double.NaN }, { Double.NaN } };

// try {
// DataUtilities.createNumberArray2D(data);
// fail("Expected an InvalidParameterException to be thrown");
// } catch (InvalidParameterException e) {
// }
// }

// // Objective: Verifies the function's behavior with null input, expecting an
// // exception to ensure robust error handling.
// // Type: BVT
// @Test
// public void createFromNullData() {
// double[][] data = null;

// try {
// DataUtilities.createNumberArray2D(data);
// fail("Expected an InvalidParameterException to be thrown");
// } catch (InvalidParameterException e) {
// } catch (Exception e) {
// fail("Expected an InvalidParameterException, but caught a different
// exception");
// }
// }

// // Objective: Tests the function with the maximum double value, assessing its
// // handling of extreme boundary values.
// // Type: BVT
// @Test
// public void createFromMaxValues() {
// double[][] data = { { Double.MAX_VALUE, Double.MAX_VALUE } };
// java.lang.Number[][] expected = { { Double.MAX_VALUE, Double.MAX_VALUE } };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Examines the function's response to positive infinity values,
// // representing a special value class.
// // Type: ECP
// @Test
// public void createFromPosInfs() {
// double[][] data = { { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY } };
// java.lang.Number[][] expected = { { Double.POSITIVE_INFINITY,
// Double.POSITIVE_INFINITY } };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Evaluates the function with the smallest positive double value,
// // checking its processing at the lower boundary.
// // Type: BVT
// @Test
// public void createFromMinValues() {
// double[][] data = { { Double.MIN_VALUE, Double.MIN_VALUE } };
// java.lang.Number[][] expected = { { Double.MIN_VALUE, Double.MIN_VALUE } };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Tests the function with negative infinity values to see how it
// // handles this special class of inputs.
// // Type: ECP
// @Test
// public void createFromNegInfs() {
// double[][] data = { { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY } };
// java.lang.Number[][] expected = { { Double.NEGATIVE_INFINITY,
// Double.NEGATIVE_INFINITY } };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Challenges the function with values just below the maximum
// double
// // value, probing near-boundary conditions.
// // Type: BVT
// @Test
// public void createFromNearlyMaxValues() {

// double[][] data = {
// { Double.MAX_VALUE - 1, Double.MAX_VALUE - 1 }
// };

// Number[][] expected = {
// { Double.MAX_VALUE - 1, Double.MAX_VALUE - 1 }
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Assesses the function's precision and range with extremely
// large
// // and small exponent values, testing boundary handling.
// // Type: BVT
// @Test
// public void createFromVeryLargeAndSmallExponents() {

// double[][] data = {
// { 1e307, 1e-307 },
// { -1e307, -1e-307 }
// };

// Number[][] expected = {
// { 1e307, 1e-307 },
// { -1e307, -1e-307 }
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// // Objective: Verifies the function's precision with values that exceed the
// // typical double precision, exploring its numerical accuracy.
// // Type: ECP
// @Test
// public void createFromHighPrecisionValues() {

// double[][] data = {
// { 1.1234567890123456, 1.1234567890123457 }, // Beyond double's precision
// { -1.1234567890123456, -1.1234567890123457 }
// };

// Number[][] expected = {
// { 1.1234567890123456, 1.1234567890123457 },
// { -1.1234567890123456, -1.1234567890123457 }
// };

// assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
// }

// }