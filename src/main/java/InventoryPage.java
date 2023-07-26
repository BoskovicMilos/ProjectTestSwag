import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage{
    @FindBy( id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;
    @FindBy ( className = "shopping_cart_badge")
    WebElement cart;

    public InventoryPage (ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addBackpack()
    {
        backpack.click();
    }
    public void clickOnCart()
    {
        cart.click();
    }
}

