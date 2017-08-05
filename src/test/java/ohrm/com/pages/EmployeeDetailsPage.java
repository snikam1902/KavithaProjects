package ohrm.com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeDetailsPage extends BasePage {

    @FindBy(how= How.XPATH, using="//div[@class='container col s12']/ul[2]/li[2]/ul/li/span")
    public  WebElement title;

    @FindBy(how=How.ID, using="employee_id")
    public WebElement empID;

    public EmployeeDetailsPage(WebDriver driver){
        super(driver);
    }

    public String getTitile(){
        return title.getText();
    }

    public String getEmpID(){
        return empID.getText();
    }

}
