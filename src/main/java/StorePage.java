import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


class StorePage extends PageObject {

    @FindBy(className = "g-i-tile-i-box-desc")
    private List<WebElement> allItemsOnPage;


    StorePage(WebDriver driver){
        super(driver);
    }

    List<WebElement> getAllItemsOnPage() {
        return allItemsOnPage;
    }

    String getItemPrice(WebElement item){
        WebElement rawItemPrice = item.findElement(By.className("g-price-uah"));
        return rawItemPrice.getText();
    }

    String getItemName(WebElement item){
        WebElement itemName = item.findElement(By.cssSelector(".g-i-tile-i-title.clearfix"));
        return itemName.getText();
    }

    boolean isItemTopSeller(WebElement item){
        try{
            item.findElement(By.cssSelector(".g-tag.g-tag-icon-middle-popularity.sprite"));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


}
