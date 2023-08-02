package automationframework;

import automationframework.util.CommonSystemsDBConnection;
import automationframework.util.PostgresDBConnection;
import automationframework.util.SITDBConnection;

public class TestContext {

	public CommonSystemsDBConnection connection;
	public PostgresDBConnection postgresConnection;
	public SITDBConnection connectionSIT;

	public TestContext() {
		connection = new CommonSystemsDBConnection();
		postgresConnection = new PostgresDBConnection();
		connectionSIT=new SITDBConnection();
	}
}