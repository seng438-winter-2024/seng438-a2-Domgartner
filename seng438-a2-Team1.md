**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**


| Group Number: 1      |
|-----------------|
| Alexander Mclean                |   
| Dominic Gartner              |   
| Hamd Khan               |   
| Noel Thomas                |   

# 1 Introduction

In this assignment, we created a JUnit testing suite for two classes in JFree. The objective of this assignment was to become familiarized with the  fundamentals of automated unit testing, emphasizing testing based on unit requirements. The test development process for the two classes in JFree (Range and DataUtilities) was done through a process of four steps:
  1. Familiarization of the software and methods, with underatanding of the javadocs documentation
  2. Design of unit tests based off the javadocs documentation
  3. Development of Java unit test code for the two JFree classes
  4. Peer review of the developed unit tests

In this lab report, we will provide a detailed overview of the strategies employed in developing our JUnit test suite. We will focus on the methods tested within the Range and DataUtilities classes. Additionally, we will conclude the report with a reflection on our team's development process, workflow, and any challenges faced during the assignment.

# 2 Detailed description of unit test strategy

## Our Unit Test Strategy

Our unit test strategy aimed to thoroughly validate the functionality of each function. When writing the unit test (especially in Range test) we choose to adopt a systematic approach to designing and executing unit tests, which ensured full coverage of the function being tested. We decided to test these 10 test below, 5 from the Range class and 5 from the DataUtilities class.
![Alt text](/media/Range.png)
![Alt text](/media/DataU.png)

When developing the tests we used the information given above to create test that follow these strategy points below:
- **Isolation:** Each unit is tested in isolation to ensure that its behavior is accurately assessed without interference from external dependencies. We utilize mocking frameworks or stubs to isolate the unit under test.
- **Coverage:** We strive for high code coverage, aiming to exercise as many code paths within each unit as possible. This includes testing various execution paths, error handling scenarios, and boundary conditions.
- **Edge Cases:** We identify and test edge cases that may not fit neatly into equivalence classes but are nonetheless critical for ensuring correctness and robustness. Edge cases include scenarios such as empty inputs, maximum-length inputs, or unexpected combinations of inputs.

## **Our Test Case Design Approach**

### **Boundary Value Analysis (BVA):**

- **Boundary Value Analysis (BVA):** Within each equivalence class, we apply boundary value analysis to identify boundary conditions that are likely to reveal errors. Test cases are designed to include inputs at the boundaries of equivalence classes, ensuring thorough testing near critical points.

### **Equivalence Classes (ECP)**

- **Equivalence Classes (ECP):** Based on input partitioning, we identify equivalence classes representing sets of inputs that should produce the same output or behavior from the unit. This allows us to design test cases that represent each equivalence class, minimizing redundancy while maximizing coverage.

## **Benefits and Drawbacks of Mocking:**

### **Benefits:**

- **Isolation:** Mocking allows us to isolate the unit under test from its dependencies, enabling focused testing and easier identification of defects.
- **Speed**: Mock testing can be faster than traditional testing methods because it eliminates the need for complex setup and teardown procedures and reduces the time required to run tests.

### **Drawbacks:**

- **Complexity:** Mocking can introduce complexity, especially when dealing with complex dependencies or interactions between multiple components. We all noticed this when actually writing the tests

# 3 Test cases developed

* Note: All test descriptions are written by the group, but some are augmented by ChatGPT.

### createFromArrayWithZeros

Objective: Tests the function with an array containing only zero values, checking if it can handle the boundary condition of minimal non-negative values.

Expected: A number array where each element is zero in the same shape as the input data.

Type: BVT

### createFromArrayWithNegativeValues

Objective: Verifies the function's ability to process arrays containing negative values.

Expected: An array of values in the same shape as the data and containing the same data in order.

Type: ECP

### createFromMixedValues

Objective: Tests the function with an array containing a mix of positive, negative, zero, and special floating-point values (NaN, Infinity) to ensure it can handle a wide variety of numerical inputs without data loss or corruption.

Expected: An array mirroring the input data's structure, including all special values (NaN, Infinity) as they are.

Type: ECP

### createFromSingleElementArray

Objective: Evaluates the function's handling of the smallest non-empty array possible (a single element) to test its behavior at this boundary condition.

Expected: An array consisting of the single input value, preserving the data type and value.

Type: BVT

### create2x2Array

Objective: Validates the function's behavior with a basic 2x2 square array of uniform positive values, testing a simple but common case of array input.

Expected: A 2x2 array of numbers matching the input values, ensuring the function can handle basic square arrays without issues.

Type: ECP

### create3x3Array

Objective: Assesses the function's performance with a slightly larger 3x3 square array of positive values, checking its capability to scale up from the simpler 2x2 case.

Expected: A 3x3 number array that accurately reflects the input data, demonstrating the function's ability to handle larger square arrays.

Type: ECP

### createNonSquareArray

Objective: Examines the function's ability to process a rectangular (non-square) array, ensuring it can handle arrays with differing row lengths.

Expected: A non-square array that in the same shape as the data input, with matching values.

Type: ECP

### createFromNonUniformDataShapes

Objective: This test evaluates the function's robustness in handling arrays with rows of unequal lengths, testing the function's ability to manage non-uniform array shapes, a boundary condition related to array dimensions and structure.

Expected: The expected result is an array where each row reflects the corresponding row in the input array, preserving the varying lengths and the values within each row. This outcome ensures the function can handle arrays with non-uniform row lengths without data loss or errors.

Type: BVT

### createLargeArray

Objective: The objective is to validate the function's performance and scalability by testing it with a large 100x100 array, assessing its ability to process and manage large datasets efficiently.

Expected: The function should return a 100x100 array where each element matches the randomly generated double value in the corresponding position of the input array, demonstrating the function's capability to handle large arrays without performance degradation or errors.

Type: BVT

### emptyArguments

Objective: This test ensures the function can correctly handle an empty array, addressing the boundary condition where there's no data to process.

Expected: The function is expected to return an empty array, indicating that it can gracefully handle cases with no input data without errors or exceptions.

Type: BVT

### createFromInvalidData

Objective: The test checks the function's error handling capabilities when provided with invalid data, specifically NaN values, expecting the function to throw an exception.

Expected: The test anticipates that the function will throw an `InvalidParameterException` when encountering NaN values, indicating robust error handling for invalid inputs.

Type: BVT

### createFromNullData

Objective: This test verifies the function's robustness in handling null inputs, expecting the function to throw an exception to ensure proper error handling.

Expected: Upon receiving a null input, the function is expected to throw an `InvalidParameterException`, demonstrating its ability to handle null inputs gracefully by signaling an error.

Type: BVT

### createFromMaxValues

Objective: The test assesses the function's handling of extreme boundary values by using the maximum double value, checking for any issues in processing or representing these large numbers.

Expected: The expected result is an array containing the maximum double values, mirroring the input array, ensuring that the function can accurately handle and represent extremely large numerical values.

Type: BVT

### createFromPosInfs

Objective: The objective is to examine the function's response to special value classes, specifically positive infinity values, assessing its ability to process and retain these special floating-point values.

Expected: The function is expected to return an array that includes the positive infinity values in their respective positions, indicating that the function can handle special floating-point values like positive infinity without issues.

Type: ECP

### createFromMinValues

Objective: This test evaluates the function's ability to process the smallest positive double value, focusing on its handling of extremely low boundary values.

Expected: The function is expected to return an array containing the smallest positive double values, accurately reflecting the input data. This ensures that the function can handle and correctly represent the lowest positive numbers in the double range.

Type: BVT

### createFromNegInfs

Objective: The objective is to test the function with negative infinity values, assessing its capability to handle this special class of inputs without errors or data loss.

Expected: The expected result is an array that contains the negative infinity values in their respective positions, confirming that the function can process and retain special floating-point values such as negative infinity.

Type: ECP

### createFromNearlyMaxValues

Objective: The test probes the function's handling of values just below the maximum double value, challenging the function's precision and accuracy near the upper boundary of the double value range.

Expected: The function should return an array with elements that are just below the maximum double value, mirroring the input data. This outcome indicates the function's ability to accurately process and represent numbers close to the maximum double value without rounding or precision errors.

Type: BVT

### createFromVeryLargeAndSmallExponents

Objective: This test assesses the function's precision and range by using extremely large and small exponent values, focusing on its ability to handle numbers with significant magnitude differences.

Expected: The expected result is an array that accurately represents both the large positive and negative exponent values as well as the small exponent values, demonstrating the function's capability to manage a wide range of magnitudes without precision loss.

Type: BVT

### createFromHighPrecisionValues

Objective: The objective is to verify the function's precision with values that challenge the limits of double precision, testing its numerical accuracy with highly precise values.

Expected: The function is expected to return an array that matches the input data, including the high-precision values, indicating the function's ability to handle and accurately represent values that are at the edge of or beyond typical double precision.

Type: ECP

### testCreateNumberArrayLength

Objective: The test checks the creation of a number array from valid input, specifically verifying that the length of the resulting array matches the length of the input array.

Expected: The expected outcome is that the length of the resulting number array exactly matches the length of the input array, ensuring that no elements are lost or added during the array creation process.

Type: ECP

### testCreateNumberArrayElementsValue

Objective: This test evaluates the creation of a number array from valid input, focusing on the accuracy of the values of the elements in the resulting array compared to the input array.

Expected: Each element in the resulting array is expected to have a value that matches the corresponding element in the input array within a specified tolerance, ensuring the function accurately represents the input values.

Type: ECP

### testCreateNumberArrayWithEmptyArray

Objective: The test aims to verify the function's handling of an empty input array, ensuring it can gracefully manage the absence of data.

Expected: The function is expected to return a non-null, empty number array, indicating it correctly interprets an empty input array as resulting in an empty output array without errors.

Type: BVT

### testCreateNumberArrayWithNegativeValuesArrayLength

Objective: This test evaluates the function's ability to create a number array from an input array containing negative values, specifically checking that the length of the resulting array matches the length of the input array.

Expected: The function is expected to return a non-null array whose length matches that of the input array, ensuring that all negative values in the input are accounted for in the resulting array without any loss of elements.

Type: ECP

### testCreateNumberArrayWithNegativeValuesArrayElements

Objective: This test further examines the function's handling of an input array with negative values by verifying that the elements of the resulting array accurately reflect the negative values from the input array.

Expected: Each element in the resulting array is expected to match the corresponding negative value in the input array, within a specified tolerance, ensuring accurate representation of negative values.

Type: ECP

### testCreateNumberArrayWithMixedValuesArrayLength

Objective: This test checks the function's ability to create a number array from an input array with mixed values (including positive, negative, and zero), specifically assessing whether the length of the resulting array matches the input array's length.

Expected: The function should produce a non-null array whose length is identical to that of the input array, ensuring that all mixed values are included in the resulting array without any loss.

Type: ECP

### testCreateNumberArrayWithMixedValuesArrayElements

Objective: The test aims to verify the accuracy of the elements in the resulting number array when the input array contains mixed values, ensuring each element in the output accurately reflects the corresponding input value.

Expected: Each element in the resulting array should match the corresponding value in the mixed input array within a specified tolerance, demonstrating the function's ability to accurately represent a variety of numerical values.

Type: ECP

### testCreateNumberArrayNull

Objective: This test assesses the function's error handling when provided with null input data, expecting the function to throw an `IllegalArgumentException` to indicate improper input.

Expected: The function is expected to throw an `IllegalArgumentException` when passed a null input, signaling robust error handling for null data scenarios.

Type: BVT

### testCreateNumberArrayInvalidData

Objective: The test evaluates the function's error handling capabilities when given invalid data, such as `Double.POSITIVE_INFINITY`, `Double.NaN`, and `Double.NEGATIVE_INFINITY`, expecting the function to throw an `InvalidParameterException`.

Expected: The function is anticipated to throw an `InvalidParameterException` when encountering invalid data inputs, demonstrating its ability to handle special floating-point values and NaN through error signaling.

Type: ECP

### testCreateNumberArrayBoundary

Objective: This test verifies the function's ability to create a number array from boundary values, specifically the minimum and maximum values of the double type, assessing its handling of extreme numerical ranges.

Expected: The expected outcome is an array containing the minimum and maximum double values, accurately reflecting the input array and demonstrating the function's capability to handle extreme boundary values without precision loss or errors.

Type: BVT

### testGetCumulativePercentagesForTwoValues

Objective: This test examines the function `getCumulativePercentages` using a simple scenario provided in the Javadoc example. It aims to validate the computation of cumulative percentages for a series of values.

Expected: The function is expected to return keyed values with cumulative percentages calculated as follows: 0.3125 for the first key (5/16), 0.875 for the second key ((5+9)/16), and 1.0 for the third key ((5+9+2)/16), accurately reflecting the proportional contributions of each value to the total sum.

Type: ECP

### testGetCumulativePercentagesForTwoValuesWithNegativeNumber

Objective: This test challenges the `getCumulativePercentages` function with input values that include a negative number, assessing its capability to correctly compute cumulative percentages in scenarios that involve negative contributions.

Expected: The expected results are cumulative percentages adjusted for the presence of a negative value: 0.7 for the first key (7/10), 0.5 for the second key ((7-2)/10), and 1.0 for the third key ((7-2+5)/10), demonstrating the function's ability to handle negative numbers within its calculations.

Type: ECP

### calculateColumnTotalForTwoValues

Objective: This test verifies the `calculateColumnTotal` function's ability to sum values within a single column of a dataset, using a straightforward scenario with two values.

Expected: The function should correctly sum the two values (7.5 and 2.5) to produce a total of 10.0, confirming its accuracy in calculating column totals for basic datasets.

Type: ECP

### calculateColumnTotalFor5NegativeValues

Objective: This test evaluates the `calculateColumnTotal` function's performance when the column contains five negative values, testing its ability to accurately sum negative numbers.

Expected: The expected result is a total of -23.5, accurately reflecting the sum of the five negative values, thereby confirming the function's capability to handle datasets composed entirely of negative numbers.

Type: ECP

### calculateColumnTotalForMixedPositiveAndNegativeValues

Objective: The objective is to assess the `calculateColumnTotal` function's ability to compute the sum of a column that includes both positive and negative values, ensuring correct handling of mixed datasets.

Expected: The function should return a total of -6.0, correctly accounting for the sum of the mixed positive and negative values, demonstrating its robustness in handling datasets with varied numerical characteristics.

Type: ECP

### calculateColumnTotalForEmptyData

Objective: This test checks the `calculateColumnTotal` function's response to an empty dataset, aiming to confirm its ability to gracefully handle the absence of data.

Expected: The function is expected to return a total of 0, indicating that it correctly interprets an empty dataset as having no contribution to the column total, thus avoiding errors or unintended results.

Type: BVT

### calculateColumnTotalForLargeNumberOfRows

Objective: This test examines the `calculateColumnTotal` function's scalability by applying it to a dataset with a large number of rows, assessing its performance and accuracy under such conditions.

Expected: The expected total is 200, which should be the sum of 100 rows each containing the value 2, testing the function's ability to handle large datasets without degradation in performance or accuracy.

Type: BVT

### calculateColumnTotalThatContainsANullValue

Objective: The test aims to evaluate the `calculateColumnTotal` function's robustness when encountering null values within a column, verifying its error handling and computational correctness in such cases.

Expected: The function is expected to return a total of 0 when encountering a null value, assuming that the implementation treats null as an absence of value, thereby ensuring that the presence of null does not lead to incorrect sums.

Type: ECP

### calculateColumnTotalThatContainsInvalidColumnIndex

Objective: This test examines the `calculateColumnTotal` function's behavior when provided with an invalid column index, aiming to verify its error handling and default response in such scenarios.

Expected: The function is expected to return a total of 0, demonstrating its ability to handle invalid column indices gracefully, without throwing unexpected exceptions or errors.

Type: BVT

### calculateColumnTotalForLargeColumnIndex

Objective: The objective is to assess the `calculateColumnTotal` function's capability to process a column with a large index, testing its ability to handle datasets with a high number of columns.

Expected: The expected result is a total of 18.0, calculated from the values at the large column index, indicating that the function can accurately compute totals for columns with large indices without issue.

Type: BVT

### calculateRowTotalForTwoValues

Objective: This test verifies the `calculateRowTotal` function's ability to compute the total for a row containing two values, assessing its basic operational correctness.

Expected: The function should return a total of 10.0, accurately summing the two provided values, confirming its capability to calculate row totals for straightforward cases.

Type: ECP

### calculateRowTotalFor5NegativeValues

Objective: The test aims to evaluate the `calculateRowTotal` function's performance when a row contains five negative values, examining its accuracy in summing negative numbers.

Expected: The expected total is -23.5, the correct sum of the five negative values, demonstrating the function's ability to accurately handle rows composed entirely of negative numbers.

Type: ECP

### calculateRowTotalForMixedPositiveAndNegativeValues

Objective: The objective is to assess the `calculateRowTotal` function's ability to compute the total for a row that includes both positive and negative values, ensuring accurate handling of mixed datasets.

Expected: The function should return a total of -6.0, correctly accounting for the sum of mixed positive and negative values, showcasing its robustness in handling varied numerical data within a single row.

Type: ECP

### calculateRowTotalForEmptyData

Objective: This test checks the `calculateRowTotal` function's response to an empty dataset, aiming to confirm its ability to gracefully handle the absence of data within a row.

Expected: The function is expected to return a total of 0, indicating that it correctly interprets an empty row as contributing nothing to the total, thus avoiding errors or unintended results.

Type: BVT

### calculateRowTotalForLargeNumberOfColumns

Objective: This test examines the `calculateRowTotal` function's scalability by applying it to a row with a large number of columns, assessing its performance and accuracy under such conditions.

Expected: The expected total is 200, which should be the sum of 100 columns each containing the value 2, testing the function's ability to handle rows with a large number of columns without performance degradation or accuracy issues.

Type: BVT

### calculateRowTotalThatContainsANullValue

Objective: The test aims to evaluate the `calculateRowTotal` function's robustness when encountering null values within a row, verifying its error handling and computational correctness in such cases.

Expected: The function is expected to return a total of 0 when encountering a null value within a row, assuming that the implementation treats null as an absence of value, thereby ensuring that the presence of null does not lead to incorrect sums.

Type: ECP

### calculateRowTotalThatContainsInvalidRowIndex

Objective: This test aims to verify the `calculateRowTotal` function's behavior when given an invalid row index, specifically assessing its error handling and the default response in such situations.

Expected: The function is expected to return a total of 0, indicating its ability to gracefully handle invalid row indices without throwing unexpected exceptions or errors, thus ensuring robustness in its error handling.

Type: BVT

### calculateRowTotalForLargeRowIndex

Objective: The test assesses the `calculateRowTotal` function's capability to process a row with a large index, examining its ability to handle datasets with a high number of rows efficiently.

Expected: The expected result is a total of 18.0, computed from the values in the row at the large index, indicating that the function can accurately calculate totals for rows with large indices without issues, thus confirming its scalability and reliability in handling large datasets.

Type: BVT

# 4 How the team work/effort was divided and managed
- To begin the assignment, each group member worked through steps 1.1 to 2.1.4 individually. This allowed each group member to become familiarized with the software and the package structure of the eclipse IDE. When developing the unit tests, we decided to split thte tests by method. Each group member chose one method to test in the Range class and one in the DataUtilities class. Each member looked closely at the documentation provided for the method of their choosing and designed and wrote the tests accordingly. Two members tested one additional method each as we were required to test a total of 10 methods between the two classes. Once the test development was complete, we looked over the completed tests together as a group.

# 5 Difficulties encountered, challenges overcome, and lessons learned
- Througout this assignment, we did not face any major challenges as a group. However, we did face some challenges in communication of which group member is testing which method. As a result, some group members tested the same methods, overlapping on the tests. Despite this challenge, we were able to effectively manage these miscommunications as a group, where we collectively worked to test the missed methods. Other than some minor miscommunication, we didn't face any difficulties in this assignment as there was great documentation and notes from lectures!

# 6 Comments/feedback on the lab itself

- As a group we really enjoyed this lab, it was helpful getting us familiar with the testing process, and using some concepts we learned in class in a real time environment. Additionally, we all learned a lot about JUnit test, and how to write them correctly. We found the lab document itself great and very easy to understand. Furthermore, the lab structure allowed for effective learning of testing methodologies and signified the importance of testing in a variety of methods. 
