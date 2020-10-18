@All
Feature: Validating Elearning appliaction

  @Signup
  Scenario Outline: Register a user new user at elearningm1 and send Message from his/her account
    Given User has naviatged to url: "http://elearningm1.upskills.in/"
    When User clicks on SignUp link
    Then User should land on Registration page
    When User enter mandatory fields: "<FirstName>","<LastName>","<Email>","<Username>","<Password>","<ConfirmPwd>"
    And clicks on Register button on same page
    Then Message shown on next page: "Dear <FirstName> <LastName>,Your personal settings have been registered."
    When click on right top arrow
    Then user profile with entered "<Email>" should be displayed
    Then User go to Home Page
    When clicks on Compose link
    Then NewMessage page should be displayed with title = "My Organization - My education - Compose message"
    When user enter data for SendTo, Subject, messgae
    And clicks on Send message button
    Then User should see acknowledgement message in Inbox

    Examples: 
      | FirstName      | LastName   | Email                 | Username         | Password | ConfirmPwd |
      | testsparktonyy | testwaynee | spark12@fsitorbit.com | sparktes2t123456 | test5688 | test5688   |
