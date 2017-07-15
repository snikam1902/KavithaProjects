package ohrm.com;

import cucumber.api.CucumberOptions;

@CucumberOptions(features="src/test/features/",
                 tags={"@newEmployee"},
                 format={"json:target/cucumber.json", "html:target/site/cucumber-pretty"})
public class TestRunner {

}
