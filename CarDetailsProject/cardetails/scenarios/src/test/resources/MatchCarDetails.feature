
Feature: 
To verify the vehicle details from csv files against vehicleEnquiry site 

  Scenario: Verify vehicle make and color details from csv files with vehicleEnquiry site
    
    Given I use fileSystemBean service on available csv files from "/Users/Parimala/Desktop/Kishore/CarDetailsProject/cardetails/get-carfiles-details/src/test/resourcefiles/testdata"
    And I run enquiry against each car from each csv file
    Then each car details should be matched to vehicleEnquiry site
