
Feature:


Scenario Outline: Estimate Age from Name and Birthday


    Given I am on the age estimation website
    When I enter my name as "<Name>"
    And I enter my birthday as "<Birthday>"
    And I click the "Submit" button
    Then I should see an estimated age of "<ExpectedAge>" displayed on the screen
    Examples:

      | Name             | Birthday    | ExpectedAge |
      | Ertug Batar      | 21.11.1988  | 34          |
      | John Doe         | 15.05.1990  | 33          |


  Scenario Outline: Invalid Date Format

    Given I am on the age estimation website
    When I enter my name as "<Name>"
    And I enter my birthday as "<Birthday>"
    And I click the "Submit" button
    Then I should see an error message indicating the correct date format


    Examples:
      | Name          | Birthday     |
      | Jane Smith    | 01.01.01     |
      | Alex Johnson  | 02.02.01     |




  Scenario Outline: Future Birthday
    Given I am on the age estimation website
    When I enter my name as "<Name>"
    And I enter my birthday as "<Birthday>"
    And I click the "Submit" button
    Then I should see an error message indicating that the birthdate is in the future
    Examples:
      | Name          | Birthday     |
      | Username      | 01.01.4444   |
      | Username1     | 01.01.3333   |
