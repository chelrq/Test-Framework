package test;
/**
 * An interface to encapsulate a single test
 */
public abstract class Test {

    private String testId;

    /**
     * Create a test with the given id
     * @param id Name (or other identifier) of the test
     */
    public Test(String id) {
        testId = id;
    }

    /**
     * Run this test and return its results.
     * All of the code for a single test is in implementations of this method.
     * @return Whether this test passed or failed
     */
    public abstract TestResult runTest();

    /**
     * Get the identifier for this test
     * @return this test's id
     */
    public String getTestId() {
        return testId;
    }
}