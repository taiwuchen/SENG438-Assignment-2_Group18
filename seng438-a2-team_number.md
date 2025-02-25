**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group: 18      |
|-----------------|
| Abdul Rafay                |   
| Mohammed Azmath Khan              |   
| Taiwu Chen               |   
| Hashir Naved                |   



# 1 Introduction

In this lab we tested several methods from JFreeChart, an open-source Java framework for chart calculation, creation and display. We explored the basics of automated unit testing using JUnit and mock objects. We applied black-box test case design techniques such as Equivalence Class Testing (ECT) and Boundary Value Testing (BVT).

# 2 Detailed description of unit test strategy

Our general plan for testing each method was first partitioning inputs into valid and invalid inputs based on the documentation provided. Then we found the equivalent classes and identified boundary values.

**Input Partitions: DataUtilities**

1. calculateColumnTotal(Values2D data, int column)

Valid

1. column = 2 ( a “middle” index)
2. Boundary
    1. column = 0 (first index)
    2. column = last index
    3. large values for data
    4. small values for data

Invalid

1. column = negative index (less than 0)
2. column = out of bounds index (greater than column size)
3. data = null
4. calculateRowTotal(Values2D data, int row)

Valid

1. row = 2 ( a “middle” index)
2. Boundary
    1. row = 0 (first index)
    2. row = last index
    3. large values for data
    4. small values for data

Invalid

1. row = negative index (less than 0)
2. row = out of bounds index (greater than column size)
3. data = null
4. getCumulativePercentages(KeyedValues data)

Valid

1. KeyValues = keys: [0,1,2] values:[5,9,2]

Invalid

1. data = null
2. createNumberArray(double[] data)

Valid

1. N/A

Invalid

1. Invalid data type passed in (null) gives InvalidParameterException
2. createNumberArray2D(double[][] data)

Valid

1. N/A

Invalid

1. Invalid data type passed in (null) gives InvalidParameterException

**Input Partitions: Range**

1. getLength()

Valid

1. range between two positive integers
2. range between a negative and positive integer
3. range between a negative integer and positive double
4. Boundary
    1. range between equal integers, ie. where length is 0
    2. range between a large negative and a large positive integer

*No invalid inputs for this method*

1. contains(double value)

Valid

1. Value is the front range
2. Value is end range
3. Value is between positive range
4. Value is between negative range
5. Value is outside of range positively
6. Value is outside of range negatively
7. Value has decimals

*Method does not throw exceptions thus no invalid inputs were tested*

1. toString()

Valid

1. Value between -1.0 and 1.0 (base)
2. Value between two positive numbers
3. Value between two negative numbers
4. Value between a negative and a positive number

*No exceptions ⇔ no invalid inputs tested*

1. intersects(double lower, double upper)

Valid

1. Exact same range
2. Range with upper bound equal to original lower bound
3. Range with upper bound enclosed in original range and lower bound smaller than original lowerbound
4. Range with same lower bound and enclosed upper bound
5. Range with lower bound smaller than original lower bound, and upper bound bigger than original upper bound
6. Range with bigger lower bound than original lower bound, and smaller upper bound than original upper bound
7. Range that’s bigger than original upper bound

Invalid

1. Range with lower bound same as original upper bound
2. Range with lower bound enclosed in original range
3. Range with lower bound enclosed in original range and upper bound equal to original upper bound
4. Range that’s smaller than original lower bound
5. equals(java.lang.Object obj)

Valid

1. Range object with same lower and upper
2. Range object with bigger lower and smaller upper
3. Range object with bigger lower and same upper
4. Range object with smaller lower and same upper
5. Range object with bigger lower and upper
6. Range object with smaller lower and upper

Invalid

1. Range object with same lower and bigger upper
2. Range object with same lower and smaller upper
3. constrain(double value)

Valid

1. Value as upper bound
2. Value as lower bound
3. Value contained in range
4. Value bigger than upper bound

Invalid

1. Value smaller than lower bound

# 3 Test cases developed

The following test cases were developed for methods in each class.

**Class: DataUtilities**

| Method | Test Case | Related Partition Number |
| --- | --- | --- |
| calculateColumnTotal | calculateColumnTotal_firstColumnIndex | 1b i |
| calculateColumnTotal | calculateColumnTotal_middleColumnIndex | 1a |
| calculateColumnTotal | calculateColumnTotal_lastColumnIndex | 1b ii |
| calculateColumnTotal | calculateColumnTotal_outOfBoundsColumnIndex | 1d |
| calculateColumnTotal | calculateColumnTotal_negativeColumnIndex | 1c |
| calculateColumnTotal | alculateColumnTotal_nullDataObject | 1e |
| calculateRowTotal | calculateRowTotal_firstRowIndex | 2b i |
| calculateRowTotal | calculateRowTotal_middleRowIndex | 2a |
| calculateRowTotal | calculateRowTotal_lastRowIndex | 2b ii |
| calculateRowTotal | calculateRowTotal_outOfBoundsRowIndex | 2d |
| calculateRowTotal | calculateRowTotal_negativeRowIndex | 2c |
| calculateRowTotal | calculateRowTotal_nullDataObject | 2e |
| getCumulativePercentages | getCumulativePercentages_checkKeys | 3a |
| getCumulativePercentages | getCumulativePercentages_firstValue | 3a |
| getCumulativePercentages | getCumulativePercentages_lastValue | 3a |
| getCumulativePercentages | getCumulativePercentages_nullDataObject | 3b |
| createNumberArray | testcreateNumberArray | 4a |
| createNumberArray | testcreateNumberArrayOne | 4b |
| createNumberArray | createNumberArrayException | 4c |
| createNumberArray2D | testcreateNumberArray2D | 5a |
| createNumberArray2D | createNumberArrayException2D | 5b |

**Class: Range**

| Method | Test Case | Related Partition Number |
| --- | --- | --- |
| getLength | getLength_positiveIntegers | 1a |
| getLength | getLength_negativeAndPositiveIntegers | 1b |
| getLength | getLength_negativeAndPositiveDoubles | 1c |
| getLength | getLength_largeNegativeAndPositive | 1d ii |
| getLength | getLength_zero | 1d i |
| contains | contains_frontRange | 2a |
| contains | contains_endRange | 2b |
| contains | contains_betweenRangePositive | 2c |
| contains | contains_betweenRangeNegative | 2d |
| contains | contains_outRangePositive | 2e |
| contains | contains_outRangeNegative | 2f |
| contains | contains_withinRangeDecimal | 2g |
| toString | testBaseCase | 3a |
| toString | edgecasePositivePositive | 3b |
| toString | edgecaseNegativeNegative | 3c |
| toString | edgecaseNegativePositive | 3d |
| equals | rangeShouldBeEqual (parameter 0) | 5a |
| equals | rangeShouldNotBeEqual (parameter 1) | 5b |
| equals | rangeShouldNotBeEqual (parameter 2) | 5c |
| equals | rangeShouldNotBeEqual (parameter 3) | 5d |
| equals | rangeShouldNotBeEqual (parameter 4) | 5g |
| equals | rangeShouldNotBeEqual (parameter 5) | 5h |
| equals | rangeShouldNotBeEqual (parameter 6) | 5e |
| equals | rangeShouldNotBeEqual (parameter 7) | 5f |
| constrain | constrainedInRange | 6a |
| constrain | constrainedUpperBound | 6b |
| constrain | constrainedLowerBound | 6c |
| constrain | constrainedTowardLowerBound | 6e |
| constrain | constrainedTowardUpperBound | 6d |


**Benefits and Drawbacks of Mocking**

We used Mocking to test the methods in DataUtilities that use the interfaces Values2D and KeyedValues. Because these methods take in interfaces as parameters, we do not know how the inherited classes may function. Mocking allows us to return any values or throw any exceptions we want, when we want. Mocking creates a fake version of an external or internal service to mimic the real one which allows tests to run more quickly and reliably. Mock objects isolate the dependencies, so if a test fails it's due to unit code and not the dependencies. However mocks should properly understand all the dependencies otherwise they may not represent real world behavior accurately. Mocking requires knowing how the tested methods are implemented, otherwise tests can fail because the method implementation was not understood properly. As well, mocking may lead to tight coupling between mocks and code during testing.

# 4 How the team work/effort was divided and managed

We divided up the methods between us and each team member wrote unit tests for two or three methods. Then we pushed our code to GitHub and reviewed each other’s test cases. We each wrote tests for the following methods:

**Azmath:**

- *DataUtilities:* calculateColumnTotal & calculateRowTotal
- *Range:* getLength

**Abdul:**

- *DataUtilities:*  getCumulativePercentages
- *Range:* contains

**Taiwu:**

- *Data Utilities:* createNumberArray & createNumberArray2D
- *Range:* toString

**Hashir:**

- *Data Utilities: N/A*
- *Range: equals, constrain, intersects*

# 5 Difficulties encountered, challenges overcome, and lessons learned

**Azmath:** It was a bit difficult coming up with the partitions and boundary values for testing some methods as the documentation was limited or unclear. So some things were left to the tester’s assumptions and understanding. For example, the documentation stated that for the calculateColumnTotal method, a total of zero will be returned for invalid inputs but then stated an InvalidParameterException is thrown if an invalid data object is passed in.

**Abdul:** Specific to the getCumulativePercentages function, I found mocking one the KeyedValues object parameter to be complex. This is because there was no way to create and assign values to the object without seeing the code for it, meaning I had to mock all of its function calls. Similarly, I found writing unit tests for black box testing to be difficult and potentially counterproductive as I spent additional time mocking functions in which the function I am testing may never even call. This sometimes made it difficult to identify whether a test was failing due to how it was created or due to the function itself. The documentation was also slightly vague for this function as it did not specify what should happen in specific use cases. For example if the KeyedValues contained a negative value we do not know what the expected output of the function should be. Without this information, unit tests could not be written for it.

**Taiwu:** I would say it was a bit more challenging than the first assignment; a lot more to learn, however. One thing I noticed was that certain methods’ testing would have multiple opinions on how to go about testing them, specifically createNumberArray. Overall, I personally learnt a lot and am looking forward to the upcoming assignments.

**Hashir:** Theorizing boundary values and making sure all cases were covered was challenging. In the range class, there were several functions such as intersects and equals where I found bugs in scenarios that I had not considered earlier. I learned the importance of utilizing parameterized tests when working with redundant test cases. Both equals and intersects classes had two basic outcomes; true or false. By using parameterized tests, I was able to set up two general functions which were run through a dataset depending on their expected outcomes.


# 6 Comments/feedback on the lab itself

**Azmath:** Overall the lab was a good introduction to black-box testing, using JUnit and JMock. There were some discrepancies between the lab document and the JFreeChart SUT provided (for example: the number of methods specified in the lab document for Range versus how many were in the code files).

**Abdul:** The lab was a great introduction to using JUnit and JMock. I appreciated that there were instructions on how to set up your eclipse environment for running unit tests. This displayed the benefits and drawbacks of black box testing and why it is needed.

**Taiwu:** The lab itself was a great way to get started with automated testing using JUnit. I did find the instructions to be of great help overall.

**Hashir:** I really enjoyed that lab as it gave a hands-on experience on testing a sizable system. I believe it helped me grasp the concepts of unit testing and gave me a good idea on how to test for external dependencies using mocking.

