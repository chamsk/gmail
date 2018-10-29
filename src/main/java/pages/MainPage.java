package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.Keys;

public class MainPage extends AbstractPage {



    private static MainPage mainPageSingletone;

    @FindBy(xpath = "//a[contains(@href, 'https://accounts.google.com/SignOutOptions?hl=ru&continue=https://mail.google.com/mail&service=mail')]")
    private WebElement btnAccGoogle;

    @FindBy(className = "gb_Eb")
    private WebElement txtEmailFieldForAccert;

    //@FindBy(css = "#\\3a 44 > div > div")
    //@FindBy(xpath = "//*[@id=\":43\"]/div/div")
    //@FindBy(css = "#\\3a 43 > div > div")
    @FindBy(xpath = "//*[@id=\":43\"]/div/div")
    private WebElement btnCreateMessage;

    @FindBy(name = "to")
    private WebElement txtDestination;

    @FindBy(name = "subjectbox")
    private WebElement txtTheme;

    @FindBy(xpath = "//div[@aria-label=\"Тело письма\"]")
    private WebElement txtBody;

    @FindBy(xpath = "/html/body/div[28]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div/div/div/table/tbody/tr/td/img[@aria-label=\"Сохранить и закрыть\"]")
    private WebElement btnCloseFormOfCreatedMessage;

    //третий сценарий
    @FindBy(css = "#\\3a 4g > div > div.aio.UKr6le > span > a")
    private WebElement btnDrafts;

    @FindBy(xpath = "//*[@id=\":2\"]/div/div[2]/div[3]/div[1]/div/table/tbody/tr")
    private WebElement lastOfDrafts;

    //@FindBy(css = "#\\3a hx")
    @FindBy(xpath = "//*([@email=\"al-korotkov@mail.ru\"]")
    private WebElement txtDestinationAssert;




    private MainPage(WebDriver webDriver) {
        super(webDriver);
    }


    public static MainPage getMainPageSingletone(WebDriver driver) {
        if(mainPageSingletone == null){
            mainPageSingletone = new MainPage(driver);
        }
        return mainPageSingletone;
    }



    public void clickOnAccount(){ btnAccGoogle.click(); }

    public String getCurrentUser(){ return txtEmailFieldForAccert.getText(); }

    public void createMessage(){ btnCreateMessage.click(); }

    public void fillDestination(String s){ txtDestination.sendKeys(s); }

    public void fillTheme(String s){txtTheme.sendKeys(s);}

    public void fillBody(String s){txtBody.sendKeys(s);}

    public void closeFormOfCreatedMessage(){
        btnCloseFormOfCreatedMessage.click();
    }

    public void openDrafts(){
        btnDrafts.click();
    }

    public void clickLastDraft(){
        lastOfDrafts.click();
    }

    public String getTxtDestinationAssert() {
        return txtDestinationAssert.getText();
    }

}
