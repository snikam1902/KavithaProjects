package ohrm.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends  BasePage{

    @FindBy(how = How.ID, using="plusButtonID")  //find the plus button id or
    private WebElement plusButton;

    public EmployeeListPage(WebDriver driver){
       super(driver);
    }

    public void AddEmployee(){
        plusButton.click();
    }
}
