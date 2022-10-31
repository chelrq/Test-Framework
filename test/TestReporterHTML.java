package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class TestReporterHTML implements TestReporter{
    PrintStream output;

    public TestReporterHTML(File fileName){
        super();
        try {
            output = new PrintStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateReport(List<TestResult> passed, List<TestResult> failed, List<TestResult> exception) {
      String[] typeTest = {"PASSED","FAILED","EXCEPTION"};
      for(int i= 0; i < 3; i++){
        output.println("<h2>" + typeTest[i] + " Tests" + "</h2>");
        output.println("<style> th, td { padding: 15px; } table, th, td { border: 1px solid black; border-collapse: collapse; } </style>");
        output.println("<table>  <tr style = 'background-color: lightblue;'> <th>Result</th> <th>Test ID</th>");
        if(i==0){
          output.println("</tr>");
          for(int j=0; j < passed.size(); j++){
            output.println(passed.get(j).toHtml());
          }
        }
        else {
          output.println("<th>Message</th> </tr>");
          if(i==1){
            for(int j=0; j < failed.size(); j++){
              output.println(failed.get(j).toHtml());
            }
          }
          else if(i==2){
            for(int j=0; j < exception.size(); j++){
              output.println(exception.get(j).toHtml());
            }
          }
        }
      output.println("</table>");
    }
      
  }
}
