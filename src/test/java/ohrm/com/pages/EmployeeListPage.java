package ohrm.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends  BasePage{

    @FindBy(how = How.XPATH, using="//div[@class='fixed-action-btn floating-add-btn tooltipped']/a")  //find the plus button id or
    public WebElement plusButton;


    public EmployeeListPage(WebDriver driver){
       super(driver);
    }

    public void clickPlusBtn(){
        plusButton.click();
    }
}
