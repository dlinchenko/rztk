import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "webdrivers" + File.separator +"chromedriver");
        driver = new ChromeDriver();
    }


    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
