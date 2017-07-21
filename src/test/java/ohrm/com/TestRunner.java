package ohrm.com;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/features/",
                 tags={"@login"},
                 format={"json:target/cucumber.json", "html:target/site/cucumber-pretty"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
