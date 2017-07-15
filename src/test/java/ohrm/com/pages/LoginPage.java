package ohrm.com.pages;

import ohrm.com.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.NAME, using="txtUsername")
    public WebElement userName;

    @FindBy(how = How.NAME, using="txtPassword")
    public WebElement password;

    @FindBy(how = How.NAME, using="Submit")
    public WebElement loginBtn;

    @FindBy(how = How.XPATH, using="//div[@id='social-icons']/a[1]")
    public WebElement linkedInLnk;

    //TODO - find out the ids or link text
    @FindBy(how = How.XPATH, using="//div[@id='social-icons']/a[2]")
    public WebElement faceBookLnk;

    @FindBy(how = How.XPATH, using="//div[@id='social-icons']/a[3]")
    public WebElement twitterLnk;

    @FindBy(how = How.XPATH, using="//div[@id='social-icons']/a[4]")
    public WebElement youTubeLnk;

    @FindBy(how = How.XPATH, using="//div[@id='social-icons']/a[1]/img")
    public WebElement linkedInImg;

    //TODO - find out the ids or link text
    @FindBy(how = How.XPATH, using="//div[@id='social-icons']/a[2]/img")
    public WebElement faceBookImg;

    @FindBy(how = How.XPATH, using="//div[@id='social-icons']/a[3]/img")
    public WebElement twitterImg;

    @FindBy(how = How.XPATH, using="//div[@id='social-icons']/a[4]/img")
    public WebElement youTubeImg;

    @FindBy(how = How.ID, using="spanMessage")
    public WebElement errorMsg;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void open(){
        driver.get(Util.login_URL);
    }

    public void Login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginBtn.click();
    }

    public String getErrorMsg(){
        return errorMsg.getText();
    }
}
