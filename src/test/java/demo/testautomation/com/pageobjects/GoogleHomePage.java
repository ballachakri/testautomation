package demo.testautomation.com.pageobjects;

import demo.testautomation.com.globalutils.BaseUIPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Page object > Google Home Page.
 * <p>
 * To initialized Page Factory and identify web elements on google home page and perform actions.
 * <p>
 * included allure steps annotation to foe information purpose.
 */
public class GoogleHomePage extends BaseUIPageObject<GoogleHomePage> {
    private final String TEST_ENV = "https://www.google.com/";

    @FindBy(css = "input[name='q']")
    private WebElement searchTextBox;

    @FindBy(css = "div[data-hveid='CAYQAQ'] link")
    private WebElement linkPointing;

    @FindBy(css = "div[id='rso'] a")
    private List<WebElement> allResults;

    public GoogleHomePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Set up the Google Home Page")
    public void openGoogleHomePage() {
        driver.get(TEST_ENV);
    }

    @Step("Entering the product as: {product}.")
    public GoogleHomePage enterSearchProduct(String product) {
        searchTextBox.sendKeys(product);
        return this;
    }

    @Step("Clicking the search button.")
    public GoogleHomePage clickSearchButton() {
        searchTextBox.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Returning the search results URLs.")
    public List<String> getSearchResultsURLs() {
        List<String> allSearchResults = new ArrayList<String>();
        for (WebElement url : allResults) {
            String urlResults = url.getAttribute("href");
            allSearchResults.add(urlResults);
        }
        return allSearchResults;
    }

    @Step("Clicking on the first URL")
    public GoogleHomePage navigateToTruNarrative() {
        for (WebElement urlTitle : allResults) {
            String results = urlTitle.getText();
            try {
                if (results.endsWith("trunarrative.com")) {
                    urlTitle.click();
                    break;
                }
            } catch (Exception e) {
                e.getStackTrace();
            }

        }
        return this;
    }
}
