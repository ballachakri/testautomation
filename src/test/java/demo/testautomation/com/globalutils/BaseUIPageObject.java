package demo.testautomation.com.globalutils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base User Interface to setup the browser and initialize the Page Factory
 * <p>
 * Allows to choose different Browsers and also can as parameter in command line
 */
public class BaseUIPageObject<H extends BaseUIPageObject> {

    public static WebDriver driver;
    private String browser = "chrome";

    public BaseUIPageObject() {
        PageFactory.initElements(driver, this);
    }

    public void setUpTheBrowser() {

        switch (browser) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            case "ie": {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            }
            default: {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
        }
    }

    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    public void tearDown() {
        driver.quit();
    }
}