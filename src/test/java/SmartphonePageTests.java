import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.List;
import java.util.Map;

public class SmartphonePageTests extends BaseTest {
    private String testUrl = "https://rozetka.com.ua/ua/mobile-phones/c80003/page=%d;preset=smartfon/";

    @Rule
    public TestName testName = new TestName();


    @Test
    public void getAllNamesTest(){

        List<String> testResults = TestMethods.getAllItemNamesOnPage(driver,testUrl,1);
        FileHelper resultFile =  new FileHelper(testName.getMethodName()+ ".txt");
        resultFile.writeResultFile(testResults);
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
        Map topSellers = TestMethods.getAllTopSellerNamesPricesOnPage(driver, testUrl, 1);
        Map priceRange = TestMethods.getNamesInPriceRange(driver,testUrl,1,3000, 6000);
        FileHelper resultFile = new FileHelper(testName.getMethodName() +  ".xsl");
        ExcelHelper excelWorkbook = new ExcelHelper();
        excelWorkbook.populateSheet("TopSellers", topSellers);
        excelWorkbook.populateSheet("PriceRange", priceRange);

        resultFile.writeResultsFile(excelWorkbook);
        //Mocks.excelFileMock(topSellers);
        //Mocks.excelFileMock(priceRange);
    }


}
