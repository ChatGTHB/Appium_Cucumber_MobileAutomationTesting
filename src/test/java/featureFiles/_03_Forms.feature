Feature: Forms Functionality

  Background:
    Given Open Application
    When Navigate To Forms Page

  @Smoke
  Scenario: Turn On Switch
    When User Turns On Switch
    Then The Switch Should Be Turned On

  @Smoke
  Scenario: Select An Option From Dropdown
    When User Opens Dropdown Menu
    And Selects Second Option
    Then Second Option Should Be Selected