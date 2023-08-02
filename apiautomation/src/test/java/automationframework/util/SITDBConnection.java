package automationframework.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import automationframework.resources.Config;
import automationframework.resources.Utils;

public class SITDBConnection extends Utils {

	public static String DBURL = "jdbc:oracle:thin:@ldap://oraoid.ics.express.tnt:389/C3TEST1,cn=OracleContext,dc=com,dc=tnt";
	public static String DB_UserName = "couser";
	public static String DB_Password = "couser";
	public static String JDBC_driver = "oracle.jdbc.driver.OracleDriver";
	String query1, query2, query_CIS;
	public static String CON_ID;
	public static String result;
	Connection con;
	Statement stmt;
	public ResultSet rs;
	public ResultSet rs1;

	public SITDBConnection createconnection() throws ClassNotFoundException, SQLException {
		Class.forName(Config.getConfigs().getPropertyValue("JDBC_DRIVER"));
		con = DriverManager.getConnection(Config.getConfigs().getPropertyValue("SIT_DB_URL"),
				Config.getConfigs().getPropertyValue("SIT_DB_USERNAME"),
				Config.getConfigs().getPropertyValue("SIT_DB_PASSWORD"));

		return new SITDBConnection();
	}

	public ResultSet createquery(String Id) throws SQLException {
		query1 = "select * from CORCOV01 where CON_ID='" + Id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query1);

		return rs;
	}

	public ResultSet createqueryForLocCd(String Id) throws SQLException {
		query1 = "select * from ncrblv01 where BUL_CSYS_ID='" + Id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query1);

		return rs;
	}

	public ResultSet createqueryForRefTx(String Customer_Ref_Tx) throws SQLException {
		query1 = "select * from CORCOV01 where CON_CLNT_REF_TX='" + Customer_Ref_Tx + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query1);

		return rs;
	}
}
