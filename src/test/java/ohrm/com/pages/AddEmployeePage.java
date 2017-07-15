package ohrm.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddEmployeePage extends BasePage{

    @FindBy(how= How.ID, using="firstName")
    private WebElement firstName;

    @FindBy(how= How.ID, using="middleName")
    private WebElement middleName;

    @FindBy(how= How.ID, using="lastName")
    private WebElement lastName;

    @FindBy(how= How.ID, using="employeeId")
    private WebElement empID;

    @FindBy(how= How.XPATH, using="//*[@id='location_inputfileddiv']/div/input")
    private WebElement location;

    @FindBy(how= How.XPATH, using="//*[@id='location_inputfileddiv']/div/ul/li/span")
    private List<WebElement> locations;

    @FindBy(how= How.ID, using="addPhotographBtn")
    private WebElement addPhotographButton;

    @FindBy(how= How.ID, using="systemUserSaveBtn")
    private WebElement saveButton;


    @FindBy(how= How.ID, using="systemUserCacelBtn")
    public WebElement cancelButton;

    public AddEmployeePage(WebDriver driver){
        super(driver);
    }

    public String getEmpId(){
        return empID.getText();
    }
    public void createEmployee(String firstName, String middleName, String lastName, String location){
        this.firstName.sendKeys(firstName);
        this.middleName.sendKeys(middleName);
        this.lastName.sendKeys(lastName);
        this.locations.get(1).click(); // use the input and select the value
        this.saveButton.click();
    }

    public void cancel(){
        this.cancelButton.click();
    }

    public void addPhotograph(){
        this.addPhotographButton.click();
    }
}
