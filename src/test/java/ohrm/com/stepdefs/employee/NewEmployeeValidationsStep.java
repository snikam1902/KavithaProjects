package ohrm.com.stepdefs.employee;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ohrm.com.pages.AddEmployeePage;
import ohrm.com.pages.DashBoardPage;
import ohrm.com.pages.LoginPage;
import ohrm.com.stepdefs.BaseStep;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class NewEmployeeValidationsStep {

    private BaseStep baseStep;
    private AddEmployeePage addEmployeePage;
    private DashBoardPage dashBoardPage;

    public NewEmployeeValidationsStep(BaseStep bStep){
        this.baseStep = bStep;
    }
    /*  This method exists in the NewEmployeeStep
    @Given("^I logged in$")
    public void logInAsAdmin()  {
        LoginPage loginPage = new LoginPage(baseStep.getDriver());
        loginPage.Login("admin", "admin");
    }

*/
    @And("^I am on the DashboardPage$")
    public void verifyDashBoard()  {
        WebDriver driver = baseStep.getDriver();
        dashBoardPage = new DashBoardPage(driver);
        assertEquals("", driver.getCurrentUrl());
    }

    @And("^PIM menu on the left had side panel is exapanded$")
    public void expandPIM()  {
        dashBoardPage.expandPIMMenu();
    }

    @And("^I click on Add Employee link under the PIM menu$")
    public void clickAddEmpLink()  {
        dashBoardPage.selectAddEmployee();
    }

    @When("^I enter the following details$")
    public void fillTheForm(Map<String, String> table)  {

    }

    /* duplicates
    @When("^I click Save button$")
    public void clickSaveBtn()  {
        
    }
*/
    @Then("^I should get validation message as \"([^\"]*)\"$")
    public void verifyValidations(String message, String strArg1)  {
        
    }
}
