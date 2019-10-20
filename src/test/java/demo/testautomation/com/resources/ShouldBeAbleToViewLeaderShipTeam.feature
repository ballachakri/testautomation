# Scenario is to view all the leadership team

Feature: TA-103 Should be able view to the leadership team and their role

 As a end user
 I will search for TruNarrative on google website
 then is should be able view all the matching results
 and i will click the firs link of the results
 then i will landing on TruNarrative website
 and i will navigate to Leadership team
 then i should be able to view all leadership team

Scenario: A scenario
    Given I am on the google website
    When I search for the word "<TruNarrative>"
    Then I should be able to view all results
    Then I will click the first url link of the results
    And I will be landing on TruNarrative website
    And I will navigate to the Leadership team
    Then I should be able to view all the leadership team and their roles