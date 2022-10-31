package test;
/**
 * Tracks the results of a single test.
 * Tests may optionally report some message describing the test or the result.
 * Each test is marked as having passed, failed, or caused an unexpected exception.
 */
public abstract class TestResult {

    // Constants for printing each type of test result
    protected static final String PASSED = "PASSED";
    protected static final String FAILED = "FAILED";
    protected static final String EXCEPTION = "EXCEPTION";

    protected final String type;
    private final String message;
    private Test test;

    protected TestResult(String t) {
        type = t;
        message = "";
    }

    protected TestResult(String t, String m) {
        type = t;
        message = m;
    }

    /**
     * Create a test result for a test that has passed.
     * 
     * TODO: Create the class PassedTestResult
     * 
     * @return a PassedTestResult
     */
    public static TestResult createPassedResult() {
        return new PassedTestResult();
    }

    /**
     * Create a test result for a test that has passed.
     * 
     * @param msg An accompanying message for the test
     * @return a PassedTestResult
     */
    public static TestResult createPassedResult(String msg) {
        return new PassedTestResult(msg);
    }

    /**
     * Create a test result for a test that has failed.
     * The createFailedResult(String msg) is preferred
     * because the message provides information as to
     * why the test failed.
     * 
     * TODO: Create the class FailedTestResult
     * 
     * @return a FailedTestResult
     */
    public static TestResult createFailedResult() {
        return new FailedTestResult();
    }

    /**
     * Create a test result for a test that has failed.
     * 
     * @param msg An accompanying message for the test
     * @return a FailedTestResult
     */
    public static TestResult createFailedResult(String msg) {
        return new FailedTestResult(msg);
    }

    /**
     * Create a test result for a test that has caused an
     * unanticipated exception.
     * The createExceptionResult(String msg) is preferred
     * because the message provides information as to
     * why the test failed.
     * 
     * TODO: Create the class ExceptionTestResult
     * 
     * @return a ExceptionTestResult
     */
    public static TestResult createExceptionResult() {
        return new ExceptionTestResult();
    }

    /**
     * Create a test result for a test that has failed.
     * 
     * @param msg An accompanying message for the test
     * @return a FailedTestResult
     */
    public static TestResult createExceptionResult(String msg) {
        return new ExceptionTestResult(msg);
    }

    /**
     * Returns true iff this TestResult represents a passed test.
     * @return true iff this TestResult represents a passed test
     */
    public boolean isPassed() {
        return type == PASSED;
    }

    /**
     * Returns true iff this TestResult represents a failed test.
     * @return true iff this TestResult represents a failed test
     */
    public boolean isFailed() {
        return type == FAILED;
    }

    /**
     * Returns true iff this TestResult represents an exception test.
     * @return true iff this TestResult represents an exception test
     */
    public boolean isException() {
        return type == EXCEPTION;
    }

    /**
     * Assign a test to this test result. 
     * @param t The test to which this result pertains
     */
    public void setTest(Test t) {
        test = t;
    }

    /**
     * Get the associated test
     * @return the test for this result
     */
    public Test getTest() {
        return test;
    }

    /**
     * Get the identifier for the test
     * @return the test's id if test has been set
     * @throws IllegalStateException if the test has not been set
     */
    public String getTestId() {
        if (test != null) {
            return test.getTestId();
        } else {
            throw new IllegalStateException("The test has not yet been defined for this result.");
        }
    }

    /**
     * Get the message associated with the result
     * @return the message
     */
    public String getErrorMessage() {
        return message;
    }
    
    public String toString() {
        return type + " " + test.getTestId() + ":" + message;
    }

    /**
     * Generate a String for a line in a HTML table
     * @return HTML representing this test result
     */
    public abstract String toHtml();

}
