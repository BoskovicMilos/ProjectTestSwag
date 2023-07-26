import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
    @FindBy (className = "inventory_item_price")
    WebElement price;
    @FindBy ( className = "inventory_item_name")
    WebElement nameOfProduct;
    @FindBy ( name = "checkout")
    WebElement checkoutButton;

    public CartPage(ChromeDriver driver)
    {
       this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getInfoPrice()
    {
        return price.getText();
    }
    public String getProductName()
    {
        return nameOfProduct.getText();
    }

    public void clickCheckout()
    {
        checkoutButton.click();
    }
}
