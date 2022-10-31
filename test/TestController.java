package test;
/**
 * The TestController is the interface describing the essential flow for managing a test suite.
 */
public interface TestController {
    
    /**
     * Add the given test to the test suite.  
     * 
     * If many tests have the same rank, there is no specified ordering
     * in which the tests must run.
     * 
     * @param id Identifier for test.  Assumed to be unique
     * @param test Test to be added
     * @param rank Ordering for when to run the test.
     */
    public void addTest(Test test, double rank);

    /**
     * Run all tests in the test suite and collect the results.
     * The results are not returned but stored internally.
     * 
     * If certain tests are specified, only those tests are run
     * and they are run in that order.
     * If no tests are specified, then all tests are run in order
     * of their declared rank.
     * 
     */
    public void runTests();

    /**
     * Create a report of all the results of the tests that have been run.
     */
    public void createReport();
}
