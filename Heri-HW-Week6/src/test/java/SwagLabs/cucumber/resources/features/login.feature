Feature: Login ke Web SWAG LABS

  @Regression @Positive
  Scenario: Succes Login
    Given Halaman Login Web
    When Input user-name
    And Input password
    And click login button
    Then User in on Dashboard Page

  @Regression @Negative
  Scenario: Failed Login
    Given Halaman Login Web
    When Input user-name
    And Input Invalid password
    And click login button
    Then User get error message