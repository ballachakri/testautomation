package demo.testautomation.com.pageobjects;

import demo.testautomation.com.globalutils.BaseUIPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Page object > Trunarrative Home Page.
 * <p>
 * To identify web elements from the TruNarrative home page and perform actions.
 * <p>
 * included allure steps annotation to foe information purpose.
 */

public class TruNarrativeHomePage extends BaseUIPageObject<TruNarrativeHomePage> {

    @FindBy(css = "div[class='module right equal'] h4")
    private WebElement strapidTitle;

    @FindBy(css = "ul#menu-main-menu > li:nth-of-type(5) > a")
    private WebElement moreMenu;

    @FindBy(css = "li:nth-of-type(5)  ul > li:nth-of-type(2) > a")
    private WebElement leaderShipTeamSubMenu;

    @FindBy(css = "section[class*='team-members'] div h2")
    private List<WebElement> leaderShipTeamName;

    @FindBy(css = "p[class='sub']")
    private List<WebElement> leaderShipTeamRole;

    @Step("Returning the text of the strap it from the home page")
    public String getStrapIDTitle() {
        return strapidTitle.getText();
    }

    @Step("Clicking on the leadership team sub menu")
    public TruNarrativeHomePage clickLeaderShipMenu() {
        new Actions(driver).moveToElement(moreMenu).click().build().perform();
        leaderShipTeamSubMenu.click();
        return this;
    }

    @Step("Returns the Leadership team members and their role")
    public Map<String, String> getLeaderShipTeamList() {
        Map<String, String> teamList = new HashMap<String, String>();
        String name, role;
        for (int i = 0; i < leaderShipTeamName.size(); i++) {
            name = leaderShipTeamName.get(i).getText();
            role = leaderShipTeamRole.get(i).getText();
            teamList.put(name, role);
        }
        return teamList;
    }
}

