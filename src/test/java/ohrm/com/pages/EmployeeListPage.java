package ohrm.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage {

    private WebDriver driver;
    public String URL="URL";

    @FindBy(how = How.ID, using="plusButtonID")  //find the plus button id or
    private WebElement plusButton;

    public EmployeeListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AddEmployee(){
        plusButton.click();
    }
}
