package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Kor on 26.10.2018.
 */
public class LoginPage extends AbstractPage{
    private static LoginPage loginPageSingleton;

    @FindBy(id = "identifierId")
    private WebElement txtGName;

    @FindBy(id = "identifierNext")
    private WebElement btnLogin;

    @FindBy(name = "password")
    private WebElement txtGPassword;

  //  @FindBy(id = "identifierNext")
    @FindBy(id = "passwordNext")
    private WebElement btnPassword;

    @FindBy(className ="WaidBe")
    private WebElement btnMail;


    private LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static LoginPage getLoginPageSingleton(WebDriver driver) {
        if(loginPageSingleton == null){
            loginPageSingleton = new LoginPage(driver);
        }
        return loginPageSingleton;
    }

    public void fillGname(String s) {
        txtGName.sendKeys(s);
    }

    public void open(String url){
        webDriver.get(url);
    }

    public void clickNextLogin(){ btnLogin.click(); }

    public void fillPassword(String s){ txtGPassword.sendKeys(s); }

    public void clickNextPassword(){
        btnPassword.sendKeys(Keys.ENTER);
    }

    public void goMail(){ btnMail.click(); }


}
