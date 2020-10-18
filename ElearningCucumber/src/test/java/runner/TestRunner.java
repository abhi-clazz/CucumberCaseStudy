package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features ={"src/test/resources/Features/ElearningRegister.feature"},
glue = {"StepDefinition"},
dryRun=false, 
monochrome = true,  
strict=true,
plugin ={"html:testout/cucumber.html","junit:testout/cucumber.xml","json:testout/cucumber.json"}	
		)
public class TestRunner {

}