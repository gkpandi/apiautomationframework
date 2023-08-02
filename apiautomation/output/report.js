$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/automationframework/features/PostAPISample.feature");
formatter.feature({
  "name": "Call Post API to insert device data into the system",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add new device with relevant details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PostAPISample"
    }
  ]
});
formatter.step({
  "name": "user has created payload to add new device",
  "keyword": "Given "
});
formatter.match({
  "location": "automationframework.stepdefinitions.PostAPSample.user_has_created_payload_to_add_new_device()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "system saved new device details",
  "keyword": "Then "
});
formatter.match({
  "location": "automationframework.stepdefinitions.PostAPSample.system_saved_new_device_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the response status code",
  "keyword": "And "
});
formatter.match({
  "location": "automationframework.stepdefinitions.PostAPSample.verify_the_response_status_code()"
});
formatter.result({
  "status": "passed"
});
});