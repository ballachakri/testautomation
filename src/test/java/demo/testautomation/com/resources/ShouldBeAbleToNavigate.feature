# Scenario is to navigate to TruNarrative website

Feature: TA-102 User shoud be able to Navigate to TruNarrative Website

As a end user
I will search for TruNarrative on google website
Then I should be able to view all the macting results
And I will click on the first link
Then I should be redirected to TruNarrative website

Scenario: Should be able to navigate to TruNarratibe website
Given I am on the google home page
When I search for a product "TruNarrative"
Then I should be able to view TrurNarrative as result and url points to the website
And I click on the first results link of result
Then I should be able to navigate to the TruNarrative Website
