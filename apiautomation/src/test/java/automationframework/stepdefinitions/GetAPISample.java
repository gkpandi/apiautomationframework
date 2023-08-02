package automationframework.stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import automationframework.TestContext;
import automationframework.resources.APIResources;
import automationframework.resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class GetAPISample extends DBVerificationStep{

	public GetAPISample(TestContext context) {
		super(context);
	}

	@Given("user hit the GET API to get records")
	public void user_hit_the_GET_API_to_get_records() throws IOException {
		req = given().relaxedHTTPSValidation()
				.spec(requestSpecification(Utils.getGobalValues("BASEURL")));
		resspec = new ResponseSpecBuilder().build();
		response = req.log().body().get(APIResources.GetAPISample.getResource()).then().log().body()
				.spec(resspec).extract().response();
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	@Then("validate the response data and the status code")
	public void validate_the_response_data_and_the_status_code() {
		System.out.println("Status received => " + response.getStatusLine()); 
		System.out.println("Response=>" + response.prettyPrint());
		JsonPath js = new JsonPath(response.asString());
		System.out.println("Country  :" + js.get("name.common[0]"));
		Assert.assertEquals(js.get("name.common[0]"), "American Samoa");
	}
}
