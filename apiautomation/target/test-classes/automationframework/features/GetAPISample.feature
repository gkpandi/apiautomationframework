Feature: Get API Details without any runtime parameter

@GetAPIWithoutParam
Scenario: Fetch all the records using this GET API
	Given user hit the GET API to get records
	Then validate the response data and the status code