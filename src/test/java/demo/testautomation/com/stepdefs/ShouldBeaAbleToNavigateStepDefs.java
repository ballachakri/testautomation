package demo.testautomation.com.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.testautomation.com.pageobjects.GoogleHomePage;
import demo.testautomation.com.pageobjects.TruNarrativeHomePage;
import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Asserting that the strap line “Easy Onboarding. Smooth Transactions. Insightful Compliance.”  as appears TruNarrative home page.
 */
public class ShouldBeaAbleToNavigateStepDefs {

    private GoogleHomePage googleHomePage;

    @Step("opening the web browser.")
    @Given("I am on the google home page")
    public void i_am_on_the_google_home_page() {
        googleHomePage = new GoogleHomePage();
        googleHomePage.openGoogleHomePage();
    }

    @Step("Entering the word to search as :{searchProduct}")
    @When("I search for a product {string}")
    public void i_search_for_a_product(String searchProduct) {
        googleHomePage.enterSearchProduct(searchProduct).clickSearchButton();
    }

    @Step("Asserting that matching search results show TruNarrative as first result and URL link points to https://www.trunarrative.com/")
    @Then("I should be able to view TrurNarrative as result and url points to the website")
    public void i_should_be_able_to_view_TrurNarrative_as_result_and_url_points_to_the_website() {

        assertThat("Search results found matching TruNarrative is not first, please investigate",
                googleHomePage.getSearchResultsURLs().get(0), equalTo("https://www.trunarrative.com/"));

        assertThat("Search Results found first link is not pointing to the TruNarrative website, please investigate",
                googleHomePage.getSearchResultsURLs(), hasItem("https://www.trunarrative.com/"));
    }

    @Step("Clicking on the first result link on the google results page")
    @Then("I click on the first results link of result")
    public void i_click_on_the_first_results_link_of_result() {
        googleHomePage.navigateToTruNarrative();
    }

    @Step("Asserting that 'Easy Onboarding.  Smooth Transactions.  Insightful Compliance.' that appears on TruNarrative home page")
    @Then("I should be able to navigate to the TruNarrative Website")
    public void i_should_be_able_to_navigate_to_the_TruNarrative_Website() {

        assertThat("Not landed on the TruNarrative home page, please investigate",
                new TruNarrativeHomePage().getStrapIDTitle().contains
                        ("Easy Onboarding.  Smooth Transactions.  Insightful Compliance."));
    }
}
