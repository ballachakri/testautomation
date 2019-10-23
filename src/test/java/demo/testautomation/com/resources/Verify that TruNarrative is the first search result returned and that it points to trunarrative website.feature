Feature: Verify that TruNarrative is the first search result returned and that it points to TrNarrative website

As a end user
I will search for TruNarrative on the google website
Then I should be able to view all relevant matching results


Scenario: Verify that TruNarrative is the first search result returned and that it points to trunarrative website
    Given As a end user
    When I search for word "TruNarrative" on google website
    Then I should be able to view all the relevant matching results

