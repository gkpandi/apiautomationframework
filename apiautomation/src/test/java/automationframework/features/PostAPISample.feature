Feature: Call Post API to insert device data into the system

@PostAPISample
Scenario: Add new device with relevant details
	Given user has created payload to add new device
	Then system saved new device details
  And verify the response status code