package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestControllerImpl implements TestController {

    private ArrayList<String> multitest = new ArrayList<String>();
    private TestResult[] report;
    private int size = 0;
    private MinPriorityQueue list = new MinPriorityQueue();
    TestReporterHTML htmlFile;

    public TestControllerImpl(String args[]){
        if(args.length != 0){
            if(args[0].equals("-h")){
                File fileName = new File(args[1]);
                htmlFile = new TestReporterHTML(fileName);
                for(int i = 2; i < args.length; i++){
                    multitest.add(args[i]);
                }
            }
            else{
                for(int i = 0; i < args.length; i++){
                    multitest.add(args[i]);
                }   
            }
        }

    }

    @Override
    public void addTest(Test test, double rank) {
        if(multitest.isEmpty()){
            list.enqueue(test, rank);
            size++;
        }
        else{
            for(int i = 0; i < multitest.size(); i++){
                if(test.getTestId().equals(multitest.get(i))){
                    list.enqueue(test, (double) i);
                    size++;
                }
            }
        }
    }

    @Override
    public void runTests() {
        Test t = null;
        report = new TestResult[size];
        for(int i = 0; i < size; i++){
            try{
                t = (Test) list.dequeue();
                report[i] = t.runTest();
                report[i].setTest(t);
            }
            catch(Exception e){
                if(e.getMessage() != null){
                    report[i] = TestResult.createExceptionResult("Unexpected exception occured: " + e.getMessage());
                    report[i].setTest(t);
                }
                report[i] = TestResult.createExceptionResult("Unexpected exception occured");
                report[i].setTest(t);
            }
        }
        createReport();
    }

    @Override
    public void createReport() {
        TestReporter reporter = new TestReporterTerminal();
        List<TestResult> passed = new ArrayList<TestResult>();
        List<TestResult> failed = new ArrayList<TestResult>();
        List<TestResult> exception = new ArrayList<TestResult>();
        for(int i = 0; i < size; i++){
            if(report[i].isPassed()){
                passed.add(report[i]);
            } 
            else if(report[i].isFailed()){
                failed.add(report[i]);
            }
            else if(report[i].isException()){
                exception.add(report[i]);
            }
        }
        if(htmlFile == null){
            reporter.generateReport(passed,failed,exception);
        }
        else{
            htmlFile.generateReport(passed,failed,exception);
        }
    }

}
