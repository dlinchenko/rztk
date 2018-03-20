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
        List<String> testResults = TestMethods.getAllItemNamesOnPage(driver,testUrl,3);

        FileHelper resultFile =  new FileHelper(testName.getMethodName()+ ".txt");
        resultFile.writeResultFile(testResults);

        //could not make it working with my gmail mail
        //MailHelper mail = new MailHelper();
        //mail.sendMessage(resultFile.getResultFilePath(), testName.getMethodName(), resultFile.getResultFileName());

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
    public void getTopSellerAndNamesInPriceRangeTest() throws Exception {
        Map topSellers = TestMethods.getAllTopSellerNamesPricesOnPage(driver, testUrl, 3);
        Map priceRange = TestMethods.getNamesInPriceRange(driver,testUrl,5,3000, 6000);

        FileHelper resultFile = new FileHelper(testName.getMethodName() +  ".xls");
        ExcelHelper excelWorkbook = new ExcelHelper();
        excelWorkbook.populateSheet("TopSellers", topSellers, "desc");
        excelWorkbook.populateSheet("PriceRange_3000_6000", priceRange, "desc");

        resultFile.writeResultsFile(excelWorkbook);

        //could not make it working with my gmail mail
        //MailHelper mail = new MailHelper();
        //mail.sendMessage(resultFile.getResultFilePath(), testName.getMethodName(), resultFile.getResultFileName());
    }


}
