package local.kor.stepdifinition;

import org.apache.log4j.Logger;
import cucumber.api.java.ru.И;
import pages.MainPage;
import webdriver.WebDriverSingletone;

public class CreateMessageSteps {
    Logger logger = Logger.getLogger(getClass());
    MainPage mainPage = MainPage.getMainPageSingletone(WebDriverSingletone.getDriver());



    @И("^пользователь решает создать \"([^\"]*)\"$")
    public void crateMessage(String button) {
        logger.info("создание нового письма");
        mainPage.createMessage();
    }


    @И("^пользователь запоняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void fillFieldOfNewMessage(String field, String value)  {
        switch (field){
            case ("получатель"):
                mainPage.fillDestination(value);
                logger.info("заполнение поля "+ field);
                break;
            case ("тема"):
                mainPage.fillTheme(value);
                logger.info("заполнение поля "+ field);
                break;
            case ("сообщение"):
                mainPage.fillBody(value);
                logger.info("заполнение поля "+ field);
                break;
        }
    }

    @И("^пользователь закрывает созданное письмо$")
    public void closeForm() throws Throwable {
        logger.info("закрытие формы нового письма");
        mainPage.closeFormOfCreatedMessage();
    }

}
