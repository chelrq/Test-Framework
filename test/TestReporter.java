package test;
/**
 * Generates an HTML report of the test results.  The report is divided into three
 * sections: passed, failed, and exception.
 */
import java.util.List;

public interface TestReporter {
    
    /**
     * Generate a report listing details of the passed, failed, and exception tests
     * @param passed A list of test results of the passed tests
     * @param failed A list of test results of the failed tests
     * @param exception A list of test results of the exception tests
     */
    public void generateReport(List<TestResult> passed, 
                             List<TestResult> failed, 
                             List<TestResult> exception);
}
