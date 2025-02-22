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

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
