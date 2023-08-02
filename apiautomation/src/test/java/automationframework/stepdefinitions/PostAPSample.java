package automationframework.stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import automationframework.TestContext;
import automationframework.pojo.Device;
import automationframework.resources.APIResources;
import automationframework.resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class PostAPSample extends DBVerificationStep{

	protected Device device;
	
	public PostAPSample(TestContext context) {
		super(context);
	}
	
	@Given("user has created payload to add new device")
	public void user_has_created_payload_to_add_new_device() throws JsonParseException, JsonMappingException, IOException {
		this.device = MAPPER.readValue(Utils.AddItemPayload, Device.class);
		req = given().spec(requestSpecification(Utils.getGobalValues("POSTURL")))
				.body(device);
		resspec = new ResponseSpecBuilder().build();
		response = req.log().body().post(APIResources.PostAPISample.getResource()).then().log().body().spec(resspec)
				.extract().response();
	}

	@Then("system saved new device details")
	public void system_saved_new_device_details() {
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		JsonPath js = new JsonPath(response.asString());
		assertEquals("Year value in response is not same as in passed in request", device.getData().getYear(),
				js.get("data.year"));
		assertEquals(js.get("id")!=null,true);
	}

	@Then("verify the response status code")
	public void verify_the_response_status_code() {
	    System.out.println("API Returns the status code as " + response.getStatusCode());
	}
}