package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingletone {
    private static WebDriver driver = null;


    public static WebDriver getDriver() {
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    private WebDriverSingletone() {
        System.setProperty("webdriver.chrome.driver", "D:\\school\\gmailTest\\chromedriver.exe");

    }

}
