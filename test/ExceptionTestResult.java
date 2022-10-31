package test;

public class ExceptionTestResult extends TestResult {

    protected ExceptionTestResult() {
        super(EXCEPTION);
    }

    protected ExceptionTestResult(String m) {
        super(EXCEPTION, m);
    }

    @Override
    public String toHtml() {
        return "<tr> <td style='background-color:lightyellow;'>EXCEPTION</td> <td>" + this.getTestId() + "</td>  <td>" + this.getErrorMessage() + "</td> </tr>";
    }

}
