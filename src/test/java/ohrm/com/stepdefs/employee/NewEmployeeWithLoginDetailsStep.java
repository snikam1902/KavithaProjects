package ohrm.com.stepdefs.employee;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ohrm.com.pages.AddEmployeePage;
import ohrm.com.pages.DashBoardPage;
import ohrm.com.stepdefs.BaseStep;

public class NewEmployeeWithLoginDetailsStep {

    private BaseStep baseStep;
    private AddEmployeePage addEmployeePage;
    private DashBoardPage dashBoardPage;

    public NewEmployeeWithLoginDetailsStep(BaseStep bStep){
        baseStep = bStep;
        addEmployeePage = new AddEmployeePage(baseStep.getDriver());
    }

    /*
    @Given("^I logged in$")
    public void LoginAsAdmin()  {
        
    } */

    @Given("^when I select create login details check box on the Add Employee overlay$")
    public void when_i_select_create_login_details_check_box_on_the_add_employee_overlay()  {
        
    }

    @When("^I select the create login details check box$")
    public void i_select_the_create_login_details_check_box()  {
        
    }

    @When("^I fill the add employee form with below details:$")
    public void i_fill_the_add_employee_form_with_below_details()  {
        
    }

    @Then("^I should see login details sections on the Add Employee overlay$")
    public void i_should_see_login_details_sections_on_the_add_employee_overlay()  {
        
    }

    @Then("^new employee should be created successfully$")
    public void new_employee_should_be_created_successfully()  {
        
    }

    @And("^'Add Employee' is selected from the submenu items under the PIM module in the dashboard$")
    public void add_employee_is_selected_from_the_submenu_items_under_the_pim_module_in_the_dashboard()  {
        
    }

    @And("^I am on Add Employee overlay window$")
    public void i_am_on_add_employee_overlay_window()  {
        
    }

    @And("^I should see the default status as \"([^\"]*)\"$")
    public void i_should_see_the_default_status_as_something(String strArg1)  {
        
    }

    /*
    @And("^I click save button$")
    public void clickSaveBtn()  {
        
    } */

    @And("^new employee should be shown in the Employee list page$")
    public void new_employee_should_be_shown_in_the_employee_list_page()  {
        
    }

}
