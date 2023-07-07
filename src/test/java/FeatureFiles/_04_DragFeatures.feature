Feature: Drag Functionality
  Background:
    Given Open Application
    When Navigate To Drag Page

  @Smoke
  Scenario: Drag And Drop
    When User Completes Drag And Drop
    Then Success Message Should Display