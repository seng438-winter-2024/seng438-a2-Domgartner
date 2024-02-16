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

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed
- To begin the assignment, each group member worked through steps 1.1 to 2.1.4 individually. This allowed each group member to become familiarized with the software and the package structure of the eclipse IDE. When developing the unit tests, we decided to split thte tests by method. Each group member chose one method to test in the Range class and one in the DataUtilities class. Each member looked closely at the documentation provided for the method of their choosing and designed and wrote the tests accordingly. Two members tested one additional method each as we were required to test a total of 10 methods between the two classes. Once the test development was complete, we looked over the completed tests together as a group.

# 5 Difficulties encountered, challenges overcome, and lessons learned
- Througout this assignment, we did not face any major challenges as a group. However, we did face some challenges in communication of which group member is testing which method. As a result, some group members tested the same methods, overlapping on the tests. Despite this challenge, we were able to effectively manage these miscommunications as a group, where we collectively worked to test the missed methods. Other than some minor miscommunication, we didn't face any difficulties in this assignment as there was great documentation and notes from lectures!

# 6 Comments/feedback on the lab itself

- As a group we really enjoyed this lab, it was helpful getting us familiar with the testing process, and using some concepts we learned in class in a real time environment. Additionally, we all learned a lot about JUnit test, and how to write them correctly. We found the lab document itself great and very easy to understand. Furthermore, the lab structure allowed for effective learning of testing methodologies and signified the importance of testing in a variety of methods. 
