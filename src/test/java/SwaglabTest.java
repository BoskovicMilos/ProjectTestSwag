import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwaglabTest extends BaseTest{
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;

    CheckoutStepOnePage checkoutStepOnePage;


    @BeforeMethod

    public void SetUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage= new CheckoutStepOnePage(driver);



    }

    @Test
    public void login() {
        loginPage.inputUsername("standard_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test

    public void buyProduct()
    {
        loginPage.inputUsername("standard_user","secret_sauce");
        inventoryPage.addBackpack();
        inventoryPage.clickOnCart();
        Assert.assertEquals(cartPage.getInfoPrice(),"$29.99");
        Assert.assertEquals(cartPage.getProductName(),"Sauce Labs Backpack");

        cartPage.clickCheckout();
        checkoutStepOnePage.inputPersonalInfo("Milos", "Boskovic", "11070");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        checkoutStepOnePage.finish.click();
        Assert.assertEquals(checkoutStepOnePage.getInfoMessage(),"Thank you for your order!");


    }
@AfterMethod

    public void after()
{
    driver.quit();
}
}
