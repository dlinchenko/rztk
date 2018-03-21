import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TestMethods {

    static List<String> getAllItemNamesOnPage(WebDriver driver, String testUrl, int pageCount){
        List<String> testResults = new ArrayList<>();
        for(String url: Helpers.generateTestUrls(testUrl, pageCount)) {
            driver.get(url);
            StorePage page = new StorePage(driver);
            for(WebElement item: page.getAllItemsOnPage()) {
                testResults.add(page.getItemName(item));
            }
        }

        return testResults;
    }

    static Map getAllTopSellerNamesPricesOnPage(WebDriver driver, String testUrl, int pageCount){
        Map testResults = new HashMap();
        for(String url: Helpers.generateTestUrls(testUrl, pageCount)){
            driver.get(url);
            StorePage page = new StorePage(driver);
            for(WebElement item: page.getAllItemsOnPage()){
                if(page.isItemTopSeller(item)){
                    testResults.put(page.getItemName(item), Helpers.getPrice(page.getItemPrice(item)));
                }
            }
        }
        return testResults;
    }

    static Map getNamesInPriceRange(WebDriver driver, String testUrl, int pageCount, int gt, int lt){
        Map testResults = new HashMap();
        for(String url: Helpers.generateTestUrls(testUrl,pageCount)){
            driver.get(url);
            StorePage page = new StorePage(driver);
            for(WebElement item:page.getAllItemsOnPage()){
                String price = page.getItemPrice(item);
                if ((Helpers.getPrice(price)>gt) && (Helpers.getPrice(price)<lt)){
                    testResults.put(page.getItemName(item), Helpers.getPrice(page.getItemPrice(item)));
                }
            }
        }
        return testResults;
    }

}
