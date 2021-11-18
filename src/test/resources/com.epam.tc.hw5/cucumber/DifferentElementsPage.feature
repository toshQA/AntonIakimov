Feature: Different Elements Page

  Scenario: Different Elements Page Test
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    When I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown
    When I select 'Water' checkbox
    And I select 'Wind' checkbox
    And I select 'Selen' radiobutton
    And I select 'Yellow' in the dropdown menu
    Then Logs for done actions are displayed
