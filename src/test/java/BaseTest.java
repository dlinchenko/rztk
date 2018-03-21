import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class BaseTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "webdrivers" + File.separator +"chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
