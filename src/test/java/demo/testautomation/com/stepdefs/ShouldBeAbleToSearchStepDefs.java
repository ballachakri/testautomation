package demo.testautomation.com.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.testautomation.com.globalutils.BaseUIPageObject;
import demo.testautomation.com.pageobjects.GoogleHomePage;
import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Asserting that TruNarrative is the search results match returned as first in google search and the url points to: https://trunarrative.com/
 */
public class ShouldBeAbleToSearchStepDefs {

    private GoogleHomePage googleHomePage;

    @Step("opening the web browser.")
    @Given("As a end user")
    public void as_a_end_user() {
        googleHomePage = new GoogleHomePage();
        googleHomePage.openGoogleHomePage();
    }

    @Step("Entering the word to search as :{searchItem}")
    @When("I search for word {string} on google website")
    public void i_search_for_word_on_google_website(String searchItem) {
        googleHomePage.enterSearchProduct(searchItem).clickSearchButton();
    }

    @Step("Asserting that matching search results show TruNarrative as first result and URL link points to https://www.trunarrative.com/")
    @Then("I should be able to view all the relevant matching results")
    public void i_should_be_able_to_view_all_the_relevant_matching_results() {

        assertThat("Search results found matching TruNarrative is not first, please investigate",
                googleHomePage.getSearchResultsURLs().get(0), equalTo("https://www.trunarrative.com/"));

        assertThat("Search Results found first link is not pointing to the TruNarrative website, please investigate",
                googleHomePage.getSearchResultsURLs(), hasItem("https://www.trunarrative.com/"));
    }
}
