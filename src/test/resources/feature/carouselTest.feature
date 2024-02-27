Feature: Carousel Test
  Scenario: Verify that The Carousel is automate change to next Slide
    Given User access to the website
    When User wait till the carousel change slide
    Then User can see the slide has been changed
  Scenario: Verify that The Carousel is change to next Slide when user click on next button
    Given User access to the website
    When User click on the next button
    Then User can see the slide has been changed to next slide
  Scenario: Verify that The Carousel is change to last Slide when user click on back button
    Given User access to the website
    When User click on the back button
    Then User can see the slide has been changed to last slide