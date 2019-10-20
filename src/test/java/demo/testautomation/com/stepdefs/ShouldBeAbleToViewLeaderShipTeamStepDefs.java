package demo.testautomation.com.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.testautomation.com.globalutils.BaseUIPageObject;
import demo.testautomation.com.pageobjects.GoogleHomePage;
import demo.testautomation.com.pageobjects.TruNarrativeHomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.qameta.allure.Step;
import org.hamcrest.collection.IsMapContaining;

import java.util.Map;

/**
 * Asserting that the TruNarrative leadership team consists of 9 people and the people names with their respective roles:
 */
public class ShouldBeAbleToViewLeaderShipTeamStepDefs{

 private GoogleHomePage googleHomePage;
 private TruNarrativeHomePage truNarrativeHomePage;
 private Map<String,String> TeamRoleList;

    @Step("opening the web browser.")
    @Given("I am on the google website")
    public void i_am_on_the_google_website() {
        googleHomePage=new GoogleHomePage();
        googleHomePage.openGoogleHomePage();
    }

    @Step("Entering the word to search as :{searchWord}")
    @When("I search for the word {string}")
    public void i_search_for_the_word(String searchWord) {
        googleHomePage.enterSearchProduct(searchWord).clickSearchButton();
    }

    @Step("Asserting that matching search results show TruNarrative as first result and URL link points to https://www.trunarrative.com/")
    @Then("I should be able to view all results")
    public void i_should_be_able_to_view_all_results() {

        assertThat("Search results found matching TruNarrative is not first, please investigate",
                googleHomePage.getSearchResultsURLs().get(0), equalTo("https://www.trunarrative.com/"));

        assertThat("Search Results found first link is not pointing to the TruNarrative website, please investigate",
                googleHomePage.getSearchResultsURLs(), hasItem("https://www.trunarrative.com/"));
    }

    @Step("Clicking on the first result link on the google results page")
    @Then("I will click the first url link of the results")
    public void i_will_click_the_first_url_link_of_the_results() {
        googleHomePage.navigateToTruNarrative();
    }

    @Step("Asserting that 'Easy Onboarding.  Smooth Transactions.  Insightful Compliance.' that appears on TruNarrative home page")
    @Then("I will be landing on TruNarrative website")
    public void i_will_be_landing_on_TruNarrative_website() {

        assertThat("Not landed on the TruNarrative home page, please investigate",
                new TruNarrativeHomePage().getStrapIDTitle().contains
                        ("Easy Onboarding.  Smooth Transactions.  Insightful Compliance."));
    }

    @Step("Clicking on the Leadership team sub menu")
    @Then("I will navigate to the Leadership team")
    public void i_will_navigate_to_the_Leadership_team() {
        truNarrativeHomePage=new TruNarrativeHomePage();
        truNarrativeHomePage.clickLeaderShipMenu();
    }

    @Step("Asserting that in leadership team there are 9 peaple and their names matches with their role")
    @Then("I should be able to view all the leadership team and their roles")
    public void i_should_be_able_to_view_all_the_leadership_team_and_their_roles() {

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



