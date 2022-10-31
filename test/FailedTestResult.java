package test;

public class FailedTestResult extends TestResult {
;

    protected FailedTestResult() {
        super(FAILED);
    }

    protected FailedTestResult(String m) {
        super(FAILED, m);
    }

    @Override
    public String toHtml() {
        return "<tr> <td style='background-color:red;'>FAILED</td> <td>" + this.getTestId() + "</td> <td>" + this.getErrorMessage() + "</td> </tr>";
    }

}
