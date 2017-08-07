package ohrm.com.stepdefs.login;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ohrm.com.Util;
import ohrm.com.pages.LoginPage;
import ohrm.com.stepdefs.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginStep {

    private BaseStep baseStep;
    private LoginPage loginPage;
    private String userName;
    private String password;
    private WebDriver driver;


    public LoginStep(BaseStep bStep){
        baseStep = bStep;
        driver = baseStep.getDriver();
        loginPage = new LoginPage(baseStep.getDriver());
    }

    @Given("^I am on the login page$")
    public void openLoginPage()  {
        loginPage.open();
        assertEquals(Util.login_URL, baseStep.getDriver().getCurrentUrl());
    }

    @When("^I enter userName as \"([^\"]*)\", password as \"([^\"]*)\"$")
    public void enterInvalidOrBlankDetails(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @When("^I login with below credentials")
    public void enterValidDetails(DataTable table) {
        this.userName = table.raw().get(0).get(0);
        this.password = table.raw().get(0).get(1);;
    }

    @And("^I select login")
    public void login()  {
        loginPage.Login(userName, password);
    }

    @Then("^I should see required \"([^\"]*)\"$")
    public void verifyRequiredMsg(String validationMessage)  {
        assertEquals(loginPage.getErrorMsg(), validationMessage);
    }

    @Then("^I should see invalid \"([^\"]*)\"$")
    public void verifyInvalidMsg(String validationMessage)  {
        String msg = baseStep.getDriver().findElement(By.xpath("//*[@class='toast-message']")).getText();
        assertEquals(msg, validationMessage);
    }

    @Then("^I should be redirected to the retryLogin page$")
    public void verifyRetryLoginPageDisplayed()  {
        assertTrue(baseStep.getDriver().getCurrentUrl().endsWith("retryLogin"));
    }

    @Then("^I should be on the dashboard page$")
    public void verifyDashBoardDisplayed()  {
        assertTrue(baseStep.getDriver().getCurrentUrl().endsWith("dashboard/index"));
    }
}
