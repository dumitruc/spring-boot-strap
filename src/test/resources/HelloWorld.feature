@rest-ws
Feature: Spring boot service
  As a test analyst
  I want to ensure that the designed schema satisfies the business requirements
  So that the system can receive/reject data based on defined requirements

  Scenario: Validate the schema checks the quantity correctly
    Given we have a valid XML template shiporder.xml
    And is valid against the schema xsd file name
    When I set the order quantity to order quantity in the XML
    Then the schema validation accepts the input as type
