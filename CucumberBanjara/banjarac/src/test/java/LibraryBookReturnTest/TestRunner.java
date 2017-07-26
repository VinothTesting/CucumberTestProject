package LibraryBookReturnTest;
 
import org.junit.runner.RunWith; 
import cucumber.junit.Cucumber; 

@RunWith(Cucumber.class) 
//@Cucumber.Options(format = {"pretty", "html:target/cucumber"}) 
@Cucumber.Options(format = {  
  "pretty", "html:target/cucumber", "json:target/cucumber/gmailreport.json", "junit:target/cucumber/junit.xml"})
public class TestRunner { }