package test;

import java.util.List;

public class TestReporterTerminal implements TestReporter{

    public TestReporterTerminal(){

    }

    @Override
    public void generateReport(List<TestResult> passed, List<TestResult> failed, List<TestResult> exception) {
        System.out.println("--PASSED TESTS--");
        for(int i=0; i < passed.size(); i++){
            System.out.println("PASSED " + passed.get(i).getTestId() + ":" +passed.get(i).getErrorMessage());
        }
        System.out.println("\n");
        System.out.println("--FAILED TESTS--");
        for(int i=0; i < failed.size(); i++){
            System.out.println("FAILED " + failed.get(i).getTestId() + ":" +failed.get(i).getErrorMessage());
        }
        System.out.println("\n");
        System.out.println("--EXCEPTION TESTS--");
        for(int i=0; i < exception.size(); i++){
            System.out.println("EXCEPTION " + exception.get(i).getTestId() + ":" + exception.get(i).getErrorMessage());
        }
    }
    
}
