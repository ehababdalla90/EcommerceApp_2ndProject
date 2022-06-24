@Runner
  Feature: Switch currencies | logged user could switch between currencies US-Euro
    Scenario: logged user could switch between currencies
      Given user navigate to home

      And logged user choose Euro from dropdown menu
      And loop in all products that has Euro sign
