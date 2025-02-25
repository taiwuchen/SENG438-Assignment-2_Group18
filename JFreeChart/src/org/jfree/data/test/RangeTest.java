package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;


public class RangeTest {
	private Range exampleRange;
	private Range negativeRange;
    private Range positiveRange;
    private Range zeroRange;
   
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    negativeRange = new Range(-0.4,-0.1);
    positiveRange = new Range(8.01,24.11);
    zeroRange = new Range(0,0);

    }


//getCentralValue

 	@Test
 	/**
 	 * A method testing the getCentralValue() method for a negative output
 	 */
 	public void centralValueShouldBeNegative() {
 		Range values = new Range(-10, 5);
 		assertEquals("The central value of -10 and 5 should be -2.5", -2.5, values.getCentralValue(), .001d);
 	}

 	@Test
 	/**
 	 * A method testing the getCentralValue() method for a zero output
 	 */
 	public void centralValueShouldBeZero() {
 		Range values = new Range(-10, 10);
 		assertEquals("The central value of -10 and 10 should be 0", 0, values.getCentralValue(), .001d);
 	}

 	@Test
 	/**
 	 * A method testing the getCentralValue() method for a positive output
 	 */
 	public void centralValueShouldBePositive() {
 		Range values = new Range(-5, 10);
 		assertEquals("The central value of -5 and 10 should be 2.5", 2.5, values.getCentralValue(), .001d);
 	}

 	
//contains
    
    @Test
    /**
 	 * Test to see is contains() returns true for value above the lower bound
 	 */
    public void rangeContainsAboveLowerBound() { 
    	exampleRange = new Range(-10, 10);
    	assertEquals("Range should contain -9.95",
    	        true, exampleRange.contains(-9.95));
    }
    
    @Test
    /**
 	 * Test to see is contains() returns true for value below the upper bound
 	 */
    public void rangeContainsBelowUpperBound() {
    	exampleRange = new Range(-10, 10);
    	assertEquals("Range should contain 9.99",
    	        true, exampleRange.contains(9.99));
    }
     
    @Test
    /**
 	 * Test to see is contains() returns false for value above the upper bound
 	 */
    public void rangeDoesntContainAboveUpperBound() { 
    	exampleRange = new Range(-10, 10);
    	assertEquals("Range should not contain 10.1",
    	        false, exampleRange.contains(10.1));
    }
       
    @Test
    /**
 	 * Test to see is contains() returns false for value below the lower bound
 	 */
    public void rangeDoesntContainBelowLowerBound() { 
    	exampleRange = new Range(-10, 10);
    	assertEquals("Range should  not contain -10.01",
    	        false, exampleRange.contains(-10.01));
    }
    
    
//getLength
    
    @Test
    /**
 	 * This test checks one of the equivalence classes by checking the length of the following class of inputs: (Positive, Positive)
 	 */
    public void testGetLengthPositivePositive() {   
        exampleRange = new Range(1,5);  // setting range to (1,5)
        assertEquals("The length of the range is:",
        4, exampleRange.getLength(), .000000001d);  // Expected output 4
    }
    
    @Test
    /**
 	 * // This test checks one of the equivalence classes by checking the length of the following class of inputs: (Negative, Positive)
 	 */
    public void testGetLengthNegativePositive() {    
        exampleRange = new Range(-1,5); // setting range to (-1,5)
        assertEquals("The length of the range is:",
        6, exampleRange.getLength(), .000000001d); // Expected output 6
    }
    
    @Test
    /**
 	 * This test checks one of the equivalence classes by checking the length of the following class of inputs: (Negative, Negative)
 	 */
    public void testGetLengthNegativeNegative() { 
        exampleRange = new Range(-7,-5); // setting range to (-7,-5)
        assertEquals("The length of the range is:",
        2, exampleRange.getLength(), .000000001d); // Expected output 2
    }
    
    
 //getLowerBound

    @Test
    /**
 	 * This test checks negative lower bound of range
 	 */
    public void testNegativeRangeGetLower(){
        assertEquals("Lower bound of negative range",-0.4,negativeRange.getLowerBound(),.000000001d);
    }
    
    @Test
    /**
 	 * This test checks positive lower bound of range
 	 */
    public void testPositiveRangeGetLower(){
        assertEquals("Lower bound of positive range",8.01,positiveRange.getLowerBound(),.000000001d);
    }
    
    @Test
    /**
 	 * This test checks zero lower bound of range
 	 */
    public void testZeroRangeGetLower(){
        assertEquals("Lower",0,zeroRange.getLowerBound(),.000000001d);
    }
 	
 	
//equals

 	@Test
 	/**
 	 * A method testing the equals method for equality between two Range objects
 	 */
 	public void equalsTestForSameRange() {
 		Range values1 = new Range(-10, 10);
 		Range values2 = new Range(-10, 10);
 		assertEquals("Both input ranges have the same bounds", true, values1.equals(values2));
 	}

 	@Test
 	/**
 	 * A method testing the equals method for inequality between two Range objects
 	 * 
 	 */
 	public void equalsTestForLowerRange() {
 		Range values1 = new Range(-10, 10);
 		Range values2 = new Range(-20, 10);
 		assertEquals("The input ranges have different lower bounds", false, values1.equals(values2));
 	}
 	
 	@Test
 	/**
 	 * A method testing the equals method for null objects
 	 * 
 	 */
    public void equalsNull() {
        assertFalse(exampleRange.equals(null));
    }
 	
 	
 	@After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
 	
}
