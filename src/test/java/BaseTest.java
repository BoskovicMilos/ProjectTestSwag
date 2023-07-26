import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

ChromeDriver driver;

    public ChromeDriver openBrowser(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
