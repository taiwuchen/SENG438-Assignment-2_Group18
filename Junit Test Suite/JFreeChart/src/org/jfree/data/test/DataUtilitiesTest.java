package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {

    private Mockery context;
    private Values2D values;
    private KeyedValues keyedValues;

    @Before
    public void setUp() {
        context = new Mockery();
        values = context.mock(Values2D.class);
        keyedValues = context.mock(KeyedValues.class);
    }

    // =========================================================================
    //  calculateColumnTotal tests (jMock)
    // =========================================================================

    /**
     * Provided Example:
     * calculateColumnTotalForTwoValues: Using jMock to test calculateColumnTotal with 2 values.
     */
    @Test
    public void calculateColumnTotal_firstColumnIndex() {
        // Provided example: testing first column with 2 values.
        Mockery mockingContext = new Mockery();
        final Values2D localValues = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {{
            one(localValues).getRowCount();
            will(returnValue(2));
            one(localValues).getValue(0, 0);
            will(returnValue(7.5));
            one(localValues).getValue(1, 0);
            will(returnValue(2.5));
        }});
        double result = DataUtilities.calculateColumnTotal(localValues, 0);
        assertEquals("The column total should be 10.0", 10.0, result, 0.000000001d);
    }

    /**
     * calculateColumnTotal_middleColumnIndex
     * Scenario: Summing values for a middle column (e.g., column = 1) in a 3-row table.
     */
    @Test
    public void calculateColumnTotal_middleColumnIndex() {
        context.checking(new Expectations() {{
            one(values).getRowCount();
            will(returnValue(3));
            one(values).getValue(0, 1);
            will(returnValue(2.5));
            one(values).getValue(1, 1);
            will(returnValue(1.0));
            one(values).getValue(2, 1);
            will(returnValue(3.0));
        }});
        double result = DataUtilities.calculateColumnTotal(values, 1);
        assertEquals("Sum of column 1 should be 6.5", 6.5, result, 0.000000001d);
    }

    /**
     * calculateColumnTotal_lastColumnIndex
     * Scenario: Summing values for the last column (e.g., column = 2) in a 2-row table.
     */
    @Test
    public void calculateColumnTotal_lastColumnIndex() {
        context.checking(new Expectations() {{
            one(values).getRowCount();
            will(returnValue(2));
            one(values).getValue(0, 2);
            will(returnValue(10.0));
            one(values).getValue(1, 2);
            will(returnValue(-2.5));
        }});
        double result = DataUtilities.calculateColumnTotal(values, 2);
        assertEquals("Sum of column 2 should be 7.5", 7.5, result, 0.000000001d);
    }

    /**
     * calculateColumnTotal_outOfBoundsColumnIndex
     * Scenario: Column index out-of-bounds (e.g., 10) should return 0.0 (if that is the spec).
     */
    @Test
    public void calculateColumnTotal_outOfBoundsColumnIndex() {
        context.checking(new Expectations() {{
            one(values).getRowCount();
            will(returnValue(2));
            // Note: If the method checks for valid column count, you could add an expectation for getColumnCount()
        }});
        double result = DataUtilities.calculateColumnTotal(values, 10);
        assertEquals("Out-of-bounds column should return 0.0", 0.0, result, 0.000000001d);
    }

    /**
     * calculateColumnTotal_negativeColumnIndex
     * Scenario: Negative column index (e.g., -1) should return 0.0 (if that is the spec).
     */
    @Test
    public void calculateColumnTotal_negativeColumnIndex() {
        context.checking(new Expectations() {{
            one(values).getRowCount();
            will(returnValue(2));
        }});
        double result = DataUtilities.calculateColumnTotal(values, -1);
        assertEquals("Negative column index should return 0.0", 0.0, result, 0.000000001d);
    }

    /**
     * calculateColumnTotal_nullDataObject
     * Scenario: Null Values2D object should throw IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void calculateColumnTotal_nullDataObject() {
        DataUtilities.calculateColumnTotal(null, 0);
    }

    // =========================================================================
    //  calculateRowTotal tests (using jMock)
    // =========================================================================

    /**
     * calculateRowTotal_firstRowindex
     * Scenario: Sum the first row in a table with 3 columns.
     */
    @Test
    public void calculateRowTotal_firstRowindex() {
        context.checking(new Expectations() {{
            one(values).getColumnCount();
            will(returnValue(3));
            one(values).getValue(0, 0);
            will(returnValue(2.0));
            one(values).getValue(0, 1);
            will(returnValue(3.0));
            one(values).getValue(0, 2);
            will(returnValue(5.0));
        }});
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("Row 0 total should be 10.0", 10.0, result, 0.000000001d);
    }

    /**
     * calculateRowTotal_middleRowIndex
     * Scenario: Sum the middle row in a table with 3 rows and 3 columns.
     */
    @Test
    public void calculateRowTotal_middleRowIndex() {
        context.checking(new Expectations() {{
            one(values).getColumnCount();
            will(returnValue(3));
            one(values).getValue(1, 0);
            will(returnValue(1.0));
            one(values).getValue(1, 1);
            will(returnValue(2.5));
            one(values).getValue(1, 2);
            will(returnValue(0.5));
        }});
        double result = DataUtilities.calculateRowTotal(values, 1);
        assertEquals("Row 1 total should be 4.0", 4.0, result, 0.000000001d);
    }

    /**
     * calculateRowTotal_lastRowindex
     * Scenario: Sum the last row in a table with 2 rows and 3 columns.
     */
    @Test
    public void calculateRowTotal_lastRowindex() {
        context.checking(new Expectations() {{
            one(values).getColumnCount();
            will(returnValue(3));
            one(values).getValue(1, 0);
            will(returnValue(5.0));
            one(values).getValue(1, 1);
            will(returnValue(-1.0));
            one(values).getValue(1, 2);
            will(returnValue(2.0));
        }});
        double result = DataUtilities.calculateRowTotal(values, 1);
        assertEquals("Last row total should be 6.0", 6.0, result, 0.000000001d);
    }

    /**
     * calculateRowTotal_outOfBoundsRowIndex
     * Scenario: Out-of-bounds row index (e.g., 10) returns 0.0.
     */
    @Test
    public void calculateRowTotal_outOfBoundsRowIndex() {
        context.checking(new Expectations() {{
            one(values).getRowCount();
            will(returnValue(2));
            one(values).getColumnCount();
            will(returnValue(3));
        }});
        double result = DataUtilities.calculateRowTotal(values, 10);
        assertEquals("Out-of-bounds row should return 0.0", 0.0, result, 0.000000001d);
    }

    /**
     * calculateRowTotal_negativeRowIndex
     * Scenario: Negative row index (e.g., -1) returns 0.0.
     */
    @Test
    public void calculateRowTotal_negativeRowIndex() {
        context.checking(new Expectations() {{
            one(values).getColumnCount();
            will(returnValue(3));
        }});
        double result = DataUtilities.calculateRowTotal(values, -1);
        assertEquals("Negative row index should return 0.0", 0.0, result, 0.000000001d);
    }

    /**
     * calculateRowTotal_nullDataObject
     * Scenario: Null Values2D object should throw IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void calculateRowTotal_nullDataObject() {
        DataUtilities.calculateRowTotal(null, 0);
    }

    // =========================================================================
    //  getCumulativePercentages tests (using jMock)
    // =========================================================================

    /**
     * getCumulativePercentages_checkKeys
     * Scenario: Verify that keys in the result match those in the input.
     */
    @Test
    public void getCumulativePercentages_checkKeys() {
        context.checking(new Expectations() {{
            one(keyedValues).getItemCount();
            will(returnValue(3));
            one(keyedValues).getKey(0); will(returnValue("A"));
            one(keyedValues).getKey(1); will(returnValue("B"));
            one(keyedValues).getKey(2); will(returnValue("C"));
            one(keyedValues).getValue(0); will(returnValue(2));
            one(keyedValues).getValue(1); will(returnValue(3));
            one(keyedValues).getValue(2); will(returnValue(5));
        }});
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals("Key at index 0 should be A", "A", result.getKey(0));
        assertEquals("Key at index 1 should be B", "B", result.getKey(1));
        assertEquals("Key at index 2 should be C", "C", result.getKey(2));
    }

    /**
     * getCumulativePercentages_firstValue
     * Scenario: The first cumulative percentage should equal (first value/total).
     */
    @Test
    public void getCumulativePercentages_firstValue() {
        context.checking(new Expectations() {{
            one(keyedValues).getItemCount();
            will(returnValue(3));
            one(keyedValues).getKey(0); will(returnValue("A"));
            one(keyedValues).getKey(1); will(returnValue("B"));
            one(keyedValues).getKey(2); will(returnValue("C"));
            one(keyedValues).getValue(0); will(returnValue(2));
            one(keyedValues).getValue(1); will(returnValue(3));
            one(keyedValues).getValue(2); will(returnValue(5));
        }});
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        // Total is 10, so first cumulative percentage is 2/10 = 0.2
        assertEquals("First cumulative percentage should be 0.2", 0.2, result.getValue(0).doubleValue(), 0.000000001d);
    }

    /**
     * getCumulativePercentages_lastValue
     * Scenario: The last cumulative percentage should be 1.0.
     */
    @Test
    public void getCumulativePercentages_lastValue() {
        context.checking(new Expectations() {{
            one(keyedValues).getItemCount();
            will(returnValue(3));
            one(keyedValues).getKey(0); will(returnValue("A"));
            one(keyedValues).getKey(1); will(returnValue("B"));
            one(keyedValues).getKey(2); will(returnValue("C"));
            one(keyedValues).getValue(0); will(returnValue(2));
            one(keyedValues).getValue(1); will(returnValue(3));
            one(keyedValues).getValue(2); will(returnValue(5));
        }});
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals("Last cumulative percentage should be 1.0", 1.0, result.getValue(2).doubleValue(), 0.000000001d);
    }

    /**
     * getCumulativePercentages_nullDataObject
     * Scenario: Null KeyedValues should throw IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getCumulativePercentages_nullDataObject() {
        DataUtilities.getCumulativePercentages(null);
    }

    // =========================================================================
    //  createNumberArray tests (no mocking required)
    // =========================================================================

    /**
     * testcreateNumberArray
     * Scenario: Convert a double array to a Number array.
     */
    @Test
    public void testcreateNumberArray() {
        double[] data = {1.0, 2.5, 3.5};
        Number[] result = DataUtilities.createNumberArray(data);
        assertEquals("Array length should match", data.length, result.length);
        assertEquals("Element 0 should be 1.0", 1.0, result[0]);
        assertEquals("Element 1 should be 2.5", 2.5, result[1]);
        assertEquals("Element 2 should be 3.5", 3.5, result[2]);
    }

    /**
     * testcreateNumberArrayOne
     * Scenario: Single-element array conversion.
     */
    @Test
    public void testcreateNumberArrayOne() {
        double[] data = {42.0};
        Number[] result = DataUtilities.createNumberArray(data);
        assertEquals("Single-element array length", 1, result.length);
        assertEquals("Element 0 should be 42.0", 42.0, result[0]);
    }

    /**
     * createNumberArrayException
     * Scenario: Passing null should throw IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void createNumberArrayException() {
        DataUtilities.createNumberArray(null);
    }

    // =========================================================================
    //  createNumberArray2D tests (no mocking required)
    // =========================================================================

    /**
     * testcreateNumberArray2D
     * Scenario: Convert a 2D double array to a 2D Number array.
     */
    @Test
    public void testcreateNumberArray2D() {
        double[][] data = { {1.0, 2.0}, {3.5, 4.5} };
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertEquals("Row count should match", 2, result.length);
        assertEquals("Column count for row 0 should match", 2, result[0].length);
        assertEquals("Column count for row 1 should match", 2, result[1].length);
        assertEquals("Element [0][0] should be 1.0", 1.0, result[0][0]);
        assertEquals("Element [0][1] should be 2.0", 2.0, result[0][1]);
        assertEquals("Element [1][0] should be 3.5", 3.5, result[1][0]);
        assertEquals("Element [1][1] should be 4.5", 4.5, result[1][1]);
    }

    /**
     * createNumberArrayException2D
     * Scenario: Passing null 2D array should throw IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void createNumberArrayException2D() {
        DataUtilities.createNumberArray2D(null);
    }
}