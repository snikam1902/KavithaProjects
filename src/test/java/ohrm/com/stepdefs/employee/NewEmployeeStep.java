package ohrm.com.stepdefs.employee;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ohrm.com.Util;
import ohrm.com.pages.AddEmployeePage;
import ohrm.com.pages.DashBoardPage;
import ohrm.com.pages.EmployeeListPage;
import ohrm.com.pages.LoginPage;
import ohrm.com.stepdefs.BaseStep;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class NewEmployeeStep {

    private BaseStep baseStep;
    private AddEmployeePage addEmployeePage;
    private EmployeeListPage empListPage;
    private DashBoardPage dashBoardPage;
    private LoginPage loginPage;

    public NewEmployeeStep(BaseStep bStep){
        baseStep = bStep;
    }

    @Given("^I logged in$")
    public void logInAsAdmin()  {
        loginPage = new LoginPage(baseStep.getDriver());
        loginPage.open();
        loginPage.Login(Util.adminUid, Util.adminPwd);
    }

    @And("^I am on the Dashboard page$")
    public void goToDashBoard()  {
        dashBoardPage = new DashBoardPage(baseStep.getDriver());
        //wait till the page is loaded?
    }
    @And("^I expand the PIM module on the left hand side panel$")
    public void expandPIMMendu()  {
        dashBoardPage.expandPIMMenu();
    }

    @Then("^I should see Configuration, Employee List, Add Employee, Bulk Update and Reports links$")
    public void verifyMenuLinks()  {
        // assert that Add employee link is present
        assertTrue(dashBoardPage.addEmpLink.isDisplayed());
        assertTrue(dashBoardPage.EmpListLink.isDisplayed());
    }


    @When("^I click on Employee List link$")
    public void clickOnEmployeeLink()  {
        dashBoardPage.selectEmployeeListPage();
        empListPage = new EmployeeListPage(baseStep.getDriver());
        //assert page url
    }

    @Then("^I should be on the employee list page$")
    public void verifyEmpListPageOpened()  {
        assertEquals(empListPage.URL, baseStep.getDriver().getCurrentUrl() );
    }

    @And("^I should see plus button on top right corner of the page$")
    public void verifyPlusButtonDisplayed()  {

    }

    @When("^I click 'Add Employee' link under the PIM menu$")
    public void clickOnAddEmployeeLink()  {
        dashBoardPage.selectAddEmployee();
        addEmployeePage = new AddEmployeePage(baseStep.getDriver());
    }


    @When("^I click top right corner plus button on the Employee List page$")
    public void clickPlusButton()  {
        empListPage.AddEmployee();
    }

    @Then("^I should see Add Employee overlay$")
    public void verifyAddEmpOverlay()  {
        // verify that Add Emp is open
    }

    @And("^default employee id should be displayed$")
    public void verifyDefaultEmpIdDisplayed()  {

    }

    @When("^I fill the form$")
    public void fillTheFom(Map<String, String> table)   {
        // get the data and fill the form
    }

    @And("^I click save button$")
    public void clickSaveBtn()  {
        //addEmployeePage.createEmployee();
    }

    @Then("^new employee should be saved$")
    public void verifyNewEmpSaved()  {
        
    }

    @And("^I should see the employee list$")
    public void verifyEmpList()  {
        
    }


    @And("^\"([^\"]*)\" and \"([^\"]*)\" should be displayed in the employee list page as links.$")
    public void verifyEmpListedInEmpListPage(String firstname, String lastname)  {
        
    }

    // write more scenarios
    @Given("^I am on the Add Employee overlay$")
    public void openAddEmployee()  {
        LoginPage loginPage = new LoginPage(baseStep.getDriver());
        loginPage.Login("admin", "admin");
        dashBoardPage = new DashBoardPage(baseStep.getDriver());
        dashBoardPage.expandPIMMenu();
        dashBoardPage.selectAddEmployee();
        addEmployeePage = new AddEmployeePage(baseStep.getDriver());
    }

    @When("^I click ESC button$")
    public void clickESCBtn()  {
        //addEmployeePage.cancelButton.sendKeys(Keys.ESCAPE);
        Actions action = new Actions(baseStep.getDriver());
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    @When("^I Cancel button$")
    public void clickCancelButton()  {
        addEmployeePage.cancel();
    }

    @When("^I click any where outside the Add Employee overlay$")
    public void clickOutSide()  {
        //driver.findElement(By.xpath("//html")).click();
        // or click on the parent window elements
    }

    @Then("^I should see error message that employee id already exists$")
    public void verifyEmpIdAlreadyExists()  {
        // check how the error is shown and then assert it shouwn
    }

    @Then("^image should be shown in the Add Employee window$")
    public void verifyImage()  {
        
    }

    @Then("^I should see error message that image is big$")
    public void verfiyThatImageIsBig()  {
        
    }

    @Then("^Add Employee window should be closed$")
    public void verifyWindowClosed()  {
        
    }

    @And("^I edit the default employee id as \"([^\"]*)\"$")
    public void editEmployeeID(String strArg1)  {
        
    }

    @And("^\"([^\"]*)\" employee id should be displayed in the employee list page$")
    public void verifyNewEmployeeIDDisplayed(String strArg1)  {
        
    }

    @And("^I click Add Photograph button$")
    public void clickAddPhotograph()  {
        
    }

    @And("^I select an image of the size 1mb from the open window$")
    public void selectAnImage()  {
        
    }

    @And("^I select an image of the size 2mb from the open window$")
    public void selectBigImage()  {
        
    }
}