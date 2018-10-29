package local.kor.stepdifinition;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pages.MainPage;
import webdriver.WebDriverSingletone;

public class OpenDraftMessageSteps {
    Logger logger = Logger.getLogger(getClass());
    MainPage mainPage = MainPage.getMainPageSingletone(WebDriverSingletone.getDriver());

    @И("^пользователь переходит в раздел \"([^\"]*)\"$")
    public void goToDraft(String value){
        logger.info("переход в раздел \"черновики\"");
        mainPage.openDrafts();

    }

    @И("^пользователь открывает последнее письмо в разделе \"([^\"]*)\"$")
    public void openLastDrat(String arg0) {
        logger.info("открываем последний черновик");
        mainPage.clickLastDraft();
    }




    @Тогда("^поле \"([^\"]*)\" должно содержать значение \"([^\"]*)\"$")
    public void checkNewMessageFields(String field, String value)  {
        switch (field){
            case ("получатель"):
                logger.info("проверка поля " + field);
                Assert.assertEquals(value,mainPage.getTxtDestinationAssert());
                break;
            case ("тема"):
                logger.info("проверка поля " + field);
                // Assert.assertEquals(value,mainPage.getTxtTheme().getText());
                break;
            case ("тело письма"):
                logger.info("проверка поля " + field);
                // Assert.assertEquals(value,mainPage.getTxtBody().getText());
                break;
            default:{
                logger.fatal("произошел сбой проверки соответствия полей при создании нового письма");
            }
        }
    }
}
