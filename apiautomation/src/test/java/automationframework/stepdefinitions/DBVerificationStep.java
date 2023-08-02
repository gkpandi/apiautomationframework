package automationframework.stepdefinitions;

import java.sql.ResultSet;

import automationframework.TestContext;
import automationframework.util.CommonSystemsDBConnection;
import automationframework.util.PostgresDBConnection;

public class DBVerificationStep extends CommonAPI {

	protected CommonSystemsDBConnection conn1;
	protected PostgresDBConnection postgresConn;
	protected ResultSet resultSet;

	public DBVerificationStep(TestContext context) {
		super(context);
		conn1 = this.testContext.connection;
		postgresConn = this.testContext.postgresConnection;
	}
}