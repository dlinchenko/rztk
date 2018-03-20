import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.util.*;

public class DetergentPageTest extends BaseTest{
    private String testUrl = "https://rozetka.com.ua/ua/sredstva-dlya-stirki4632103/c4632103/page=%d/";

    @Test
    public void getNamesInPriceRangeTest(){
        Map testResults = TestMethods.getNamesInPriceRange(driver,testUrl,1,100, 300);
        Mocks.sqlMock(testResults);
    }
}
