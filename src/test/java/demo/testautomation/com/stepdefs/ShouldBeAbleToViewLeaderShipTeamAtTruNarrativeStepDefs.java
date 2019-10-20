package demo.testautomation.com.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.testautomation.com.globalutils.BaseUIPageObject;
import demo.testautomation.com.pageobjects.GoogleHomePage;
import demo.testautomation.com.pageobjects.TruNarrativeHomePage;
import io.qameta.allure.Step;
import org.hamcrest.collection.IsMapContaining;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Combined all the Scenario for the given user story
 *
 * Asserting that the TruNarrative leadership team consists of 9 people and the people names with their respective roles:
 */

public class ShouldBeAbleToViewLeaderShipTeamAtTruNarrativeStepDefs {

    private GoogleHomePage googleHomePage;
    private TruNarrativeHomePage truNarrativeHomePage;

    @Step("opening the web browser.")
    @Given("As a end user I am on the google homepage.")
    public void as_a_end_user_I_am_on_the_google_homepage() {
    googleHomePage = new GoogleHomePage();
    googleHomePage.openGoogleHomePage();
    }

    @Step("Entering the word to search as :{searchWord}")
    @When("I search for a  word {string}")
    public void i_search_for_a_word(String searchItem)  {
      googleHomePage.enterSearchProduct(searchItem).clickSearchButton().clickSearchButton();
    }

    @Step("Asserting that matching search results show TruNarrative as first result and URL link points to https://www.trunarrative.com/")
    @Then("I should be able to view TrurNarrative and url points to the website")
    public void i_should_be_able_to_view_TrurNarrative_and_url_points_to_the_website() {

        assertThat("Search results found matching TruNarrative is not first, please investigate",
                googleHomePage.getSearchResultsURLs().get(0), equalTo("https://www.trunarrative.com/"));

        assertThat("Search Results found first link is not pointing to the TruNarrative website, please investigate",
                googleHomePage.getSearchResultsURLs(), hasItem("https://www.trunarrative.com/"));
    }

    @Step("Clicking on the first result link on the google results page")
    @When("I click on the first results link")
    public void i_click_on_the_first_results_link() {
        googleHomePage.navigateToTruNarrative();
    }

    @Step("Asserting that 'Easy Onboarding.  Smooth Transactions.  Insightful Compliance.' that appears on TruNarrative home page")
    @Then("I should be able to land on the TruNarrative homepage")
    public void i_should_be_able_to_land_on_the_TruNarrative_homepage() {

        assertThat("Not landed on the TruNarrative home page, please investigate",
               new TruNarrativeHomePage().getStrapIDTitle().contains
                        ("Easy Onboarding.  Smooth Transactions.  Insightful Compliance."));
    }

    @Step("Clicking on the Leadership team sub menu")
    @When("I Navigate to the TruNarrative Team page")
    public void i_Navigate_to_the_TruNarrative_Team_page() {
        truNarrativeHomePage =new TruNarrativeHomePage();
        truNarrativeHomePage.clickLeaderShipMenu();
    }

    @Step("Asserting that in leadership team there are 9 peaple and their names matches with their role")
    @Then("I should be able view all the Leadership team and their respective roles")
    public void i_should_be_able_view_all_the_Leadership_team_and_their_respective_roles() {

        assertThat("Leadership team members list is not displayed correctly, please investigate",
                truNarrativeHomePage.getLeaderShipTeamList().size()==9);

        assertThat("Leadership team member name and role do not match, please investigate",
                truNarrativeHomePage.getLeaderShipTeamList(), IsMapContaining.hasEntry("John Lord","Founder & CEO"));

        assertThat("Leadership team member name and role do not match, please investigate",
                truNarrativeHomePage.getLeaderShipTeamList(), IsMapContaining.hasEntry("David Eastaugh","Chief Technology Officer"));

        assertThat("Leadership team member name and role do not match, please investigate",
                truNarrativeHomePage.getLeaderShipTeamList(), IsMapContaining.hasEntry("Nicola Janney","Human Resources Manager"));
    }

}
