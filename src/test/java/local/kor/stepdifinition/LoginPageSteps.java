package local.kor.stepdifinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.MainPage;
import webdriver.WebDriverSingletone;

import java.util.concurrent.TimeUnit;


public class LoginPageSteps {
    private WebDriver driver;

    LoginPage loginPage;
    MainPage mainPage;
    public Logger logger = Logger.getLogger(getClass());



    @Before
    public void setUp() {
        driver = WebDriverSingletone.getDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }



    @Пусть("^открыта страница входа в приложение '(.+)'$")
    public void openLoginPage(String url) {
        switch (url){
            case "https://accounts.google.com":
                loginPage = LoginPage.getLoginPageSingleton(driver);
                logger.info("создание экземпляра loginPage");
                loginPage.open(url);
                logger.info("открывается страница " + url);
                break;
             default:{logger.fatal("произошел сбой в методе openLoginPage()");
             throw new IllegalArgumentException();}

        }

    }



    @И("^пользователь вводит в поле \"([^\"]*)\" значение \"([^\"]*)\"$")
    public void fillLoginField(String field, String value) throws Throwable {
        switch (field){
            case ("телефон или адрес эл.почты"):{
                loginPage.fillGname(value);
                logger.info("поле \"имя\" заполнено");
                break;
            }
            case ("пароль"):{
                loginPage.fillPassword(value);
                logger.info("поле \"пароль\" заполнено");
                break;
            }
            default: {
                logger.fatal("некорректное значение " + field + ", " + value);
                throw new IllegalArgumentException("Invalid field name" + field);
            }
        }


    }

    @И("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void clickButton(String button) {
        switch (button){
            case "далее для логина":
                loginPage.clickNextLogin();
                break;
            case "далее для пароля":
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                loginPage.clickNextPassword();
                break;
            case "аккаунт google":
                mainPage.clickOnAccount();
                break;
            case "почта":
                loginPage.goMail();
                break;
            default:
            {
                logger.fatal("что-то пошло не так в методе clickButton. Значение кнопки " + button);
                throw new IllegalArgumentException("No button");
            }

        }
    }

    @Тогда("^откроется \"([^\"]*)\"$")
    public void openMainPage(String page) {
        switch (page){
            case "главная страница":
                mainPage = MainPage.getMainPageSingletone(driver);
                logger.info("создание экземпляра mainPage");
                break;
             default:{
                 logger.fatal("некорректное значение создания страницы- " + page);
                 throw new IllegalArgumentException();
             }
        }

    }

    @Тогда("^в правом верхнем углу можно увидеть \"([^\"]*)\"$")
    public void checkEmailField(String mail) {
        logger.info("проверка значения " + mail);
        Assert.assertEquals(mail, mainPage.getCurrentUser());
    }





}


