package automationframework.stepdefinitions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.databind.ObjectMapper;

import automationframework.TestContext;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CommonAPI {

	protected TestContext testContext;

	public CommonAPI(TestContext context) {
		this.testContext = context;
		MAPPER = new ObjectMapper();
	}

	public CommonAPI() {
		MAPPER = new ObjectMapper();
	}

	protected RequestSpecification req;
	protected ResponseSpecification resspec;
	protected Response response;
	protected ObjectMapper MAPPER;

	public RequestSpecification requestSpecification(String Url) throws IOException {
		if (req == null) {

			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

			req = new RequestSpecBuilder().setBaseUri(Url).addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req.relaxedHTTPSValidation();
		}
		return req;
	}

	/*public ShipmentRoot setDynamicFields(File fileSource) throws Throwable {
		ShipmentRoot shipmentRoot = MAPPER.readValue(fileSource, ShipmentRoot.class);
		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString();
		shipmentRoot.getShipment().setUuid(uuidAsString);

		Long number = ThreadLocalRandom.current().nextLong(910000000000L, 910999999999L);
		shipmentRoot.getShipment().setFxTrackingNbr(number.toString());
		shipmentRoot.getShipment().setCustomerRefTxt(number.toString());
		return shipmentRoot;
	}*/
}
