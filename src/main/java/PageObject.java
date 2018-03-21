import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    //following never used however required to have
    public PageObject(){};

    PageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
