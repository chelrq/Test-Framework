package test;

public class PassedTestResult extends TestResult {

    protected PassedTestResult() {
        super(PASSED);
    }


    protected PassedTestResult(String m) {
        super(PASSED, m);
    }

    @Override
    public String toHtml() {
        return "<tr> <td style='background-color:lightgreen;'>PASSED</td> <td>" + this.getTestId() +  "</tr>";
    }

}
