import org.junit.Ignore;
import org.junit.Test;


import java.util.List;
import java.util.Map;

public class SmartphonePageTests extends BaseTest {
    private String testUrl = "https://rozetka.com.ua/ua/mobile-phones/c80003/page=%d;preset=smartfon/";

    @Test
    public void getAllNamesTest(){

        List<String> testResults = TestMethods.getAllItemNamesOnPage(driver,testUrl,3);
        Mocks.textFileMock(testResults);
    }

/*    @Test
    public void getAllTopSellersOnPageTest(){
        Map testResults = TestMethods.getAllTopSellerNamesPricesOnPage(driver, testUrl, 3);
        Mocks.excelFileMock(testResults);
    }*/

/*    @Test
    public void getNamesInPriceRangeTest(){
        Map testResults = TestMethods.getNamesInPriceRange(driver, testUrl,5, 3000, 6000);
        Mocks.excelFileMock(testResults);
    }*/

    @Test
    public void getTopSellerAndNamesInPriceRangeTest(){
        Map topSellers = TestMethods.getAllTopSellerNamesPricesOnPage(driver, testUrl, 3);
        Map priceRange = TestMethods.getNamesInPriceRange(driver,testUrl,5,3000, 6000);
        Mocks.excelFileMock(topSellers);
        Mocks.excelFileMock(priceRange);
    }


}
