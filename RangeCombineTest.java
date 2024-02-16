// package org.jfree.data.test;

// import static org.junit.Assert.*;

// import org.jfree.data.Range;
// import org.junit.*;

// /* DESCRIPTION

// Creates a new range by combining two existing ranges.
// Note that:

// either range can be null, in which case the other range is returned;
// if both ranges are null the return value is null.

// Parameters:
// rangeA - the first range (null permitted).
// rangeB - the second range (null permitted).

// Returns:
// A new range subsuming both input ranges (possibly null).

// */

// public class RangeCombineTest {
// @BeforeClass
// public static void setUpBeforeClass() throws Exception {
// }

// @Before
// public void setUp() throws Exception {
// }

// // Objective: Test if one valid range and a null range can be combined.
// // Type: ECP
// @Test
// public void combineValidrangeAndNullRange() {
// Range rangeA = new Range(0, 1);

// try {
// Range res = Range.combine(rangeA, null);
// assertEquals(
// "If first argument is null, and the second is a valid range, the second range
// should be returned.",
// rangeA, res);
// } catch (Exception e) {
// fail("Combining these values should not throw an error.");
// }
// }

// // Objective: Test if one null range and a valid range can be combined.
// // Type: ECP
// @Test
// public void combineNullrangeAndValidRange() {
// Range rangeB = new Range(0, 1);

// try {
// Range res = Range.combine(rangeB, null);
// assertEquals(
// "If first argument is a valid range, and the second is null, the second range
// should be returned.",
// rangeB, res);
// } catch (Exception e) {
// fail("Combining these values should not throw an error.");
// }
// }

// // Objective: Test if two null ranges can be combined.
// // Type: ECP
// @Test
// public void combineNullRanges() {

// try {
// Range res = Range.combine(null, null);
// assertEquals("Combining two null ranges returns null.", null, res);
// } catch (Exception e) {
// fail("Combining these values should not throw an error.");
// }

// }

// // Objective: Test if an empty range and valid range can be combined.
// // Type: BVT
// @Test
// public void combineEmptyRangeAndValidRange() {
// Range rangeA = new Range(0, 0);
// Range rangeB = new Range(0, 1);

// assertEquals("New range must subsume empty and valid ranges.", rangeB,
// Range.combine(rangeA, rangeB));
// }

// // Objective: Test if a valid range and empty range can be combined.
// // Type: BVT
// @Test
// public void combineValidRangeAndEmptyRange() {
// Range rangeA = new Range(0, 1);
// Range rangeB = new Range(0, 0);

// assertEquals("New range must subsume valid and empty ranges.", rangeA,
// Range.combine(rangeA, rangeB));
// }

// // Objective: Test if two empty ranges can be combined.
// // Type: BVT
// @Test
// public void combineEmptyRanges() {
// Range rangeA = new Range(0, 0);
// Range rangeB = new Range(0, 0);

// Range emptyRange = new Range(0, 0);

// assertEquals("New range must return empty range.", emptyRange,
// Range.combine(rangeA, rangeB));
// }

// // Objective: Test if two non-identical ranges (both empty) can be combined.
// // Type: BVT
// @Test
// public void combineNonIdenticalEmptyRanges() {
// Range rangeA = new Range(10, 10);
// Range rangeB = new Range(5, 5);

// Range emptyRange = new Range(0, 0);

// assertEquals("New range must return arange that subsumes both empty ranges.",
// emptyRange,
// Range.combine(rangeA, rangeB));
// }

// // Objective: Test if superset and subset ranges can be combined.
// // Type: ECP
// @Test
// public void combineValidRangeAndSubsetRange() {
// Range rangeA = new Range(0, 5);
// Range rangeB = new Range(-10, 10);
// Range expected = new Range(-10, 10);
// assertEquals("Combining two valid ranges where one is a subset should return
// the superset.", expected,
// Range.combine(rangeA, rangeB));
// }

// // Objective: Test if superset and subset ranges can be combined.
// // Type: ECP
// @Test
// public void combineSubsetRangeAndValidRange() {
// Range rangeA = new Range(-10, 10);
// Range rangeB = new Range(0, 5);
// Range expected = new Range(-10, 10);

// try {
// Range res = Range.combine(rangeA, rangeB);
// assertEquals("Combining two valid ranges where one is a subset should return
// the superset.", expected, res);
// } catch (Exception e) {
// fail("Combining these values should not throw an error.");
// }

// }

// // Objective: Test if touching ranges can be combined.
// // Type: ECP
// @Test
// public void combineTouchingValidRanges() {
// Range rangeA = new Range(0, 5);
// Range rangeB = new Range(5, 15);
// Range expected = new Range(0, 15);

// try {
// Range res = Range.combine(rangeA, rangeB);
// assertEquals("Combining two touching valid ranges should result in an
// expected superset range", expected,
// res);

// } catch (Exception e) {
// fail("Combining these values should not throw an error.");
// }
// }

// // Objective: Test if overlapping ranges can be combined.
// // Type: ECP
// @Test
// public void combineOverlappingValidRanges() {
// Range rangeA = new Range(0, 5);
// Range rangeB = new Range(1, 15);
// Range expected = new Range(0, 15);

// try {
// Range res = Range.combine(rangeA, rangeB);
// assertEquals("Combining two overlapping valid ranges should result in an
// expected superset range", expected,
// res);

// } catch (Exception e) {
// fail("Combining these values should not throw an error.");
// }
// }

// // Objective: Test if identical ranges can be combined.
// // Type: BVT
// @Test
// public void combineIdenticalValidRanges() {
// Range rangeA = new Range(1, 5);
// Range rangeB = new Range(1, 5);
// Range expected = new Range(1, 5);
// assertEquals("Combining two identical valid ranges should result in a third
// identical range", expected,
// Range.combine(rangeA, rangeB));
// }

// @After
// public void tearDown() throws Exception {
// }

// @AfterClass
// public static void tearDownAfterClass() throws Exception {
// }
// }