@Runner
Feature: search for a product
  #scenario 1

  Scenario Outline: user could search using product name
    Given user navigates to the website
    And  user search on "<product>" in search box text field
    And user could find relative "<product>" results
    Examples:
      |product|
      |Apple  |
#      |book |
#      |Book |


  #scenario 2
# Scenario Outline: User could search by using product sku
#   Given user navigates to the website
#   And  user search on "<productSku>" in search box text field
#   And user could search by using productSku "<productSku>" result
#   Examples:
#   |productSku|
#   |AP_MBP_13 |
#   |APPLE_CAM |











