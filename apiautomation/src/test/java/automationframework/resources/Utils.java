package automationframework.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;

	public RequestSpecification requestSpecification(String Url) throws IOException {
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(Url).addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public static String getGobalValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/automationframework/resources/global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

	// Paths to json payloads
	public static File AddItemPayload = new File(System.getProperty("user.dir")
			+ "/src/test/java/automationframework/resources/TestData/Test/AddItemPayload.json");
}
