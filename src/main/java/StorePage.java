import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class StorePage extends PageObject {

    @FindBy(id = "catalog_bottomfilters_block")
    private WebElement pageLoaded;

    @FindBy(className = "g-i-tile-i-box-desc")
    private List<WebElement> allItemsOnPage;

    @FindBy(className = "g-i-tile-i-box-desc")
    private WebElement oneItemOnPage;


    public StorePage(WebDriver driver){
        super(driver);
    }

    public boolean checkPageLoaded(){
        return pageLoaded.isDisplayed();
    }

    public List<WebElement> getAllItemsOnPage() {
        return allItemsOnPage;
    }

    public WebElement getOneItemOnPage(){
        return oneItemOnPage;
    }

    public String getItemPrice(WebElement item){
        WebElement rawItemPrice = item.findElement(By.className("g-price-uah"));
        return rawItemPrice.getText();
    }

    public String getItemName(WebElement item){
        WebElement itemName = item.findElement(By.cssSelector(".g-i-tile-i-title.clearfix"));
        return itemName.getText();
    }

    public boolean isItemTopSeller(WebElement item){
        try{
            item.findElement(By.cssSelector(".g-tag.g-tag-icon-middle-popularity.sprite"));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


}
