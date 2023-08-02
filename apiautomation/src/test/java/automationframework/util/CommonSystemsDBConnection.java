package automationframework.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import automationframework.resources.Config;
import automationframework.resources.Utils;

public class CommonSystemsDBConnection extends Utils {
	String query1;
	public static String CON_ID;
	public static String result;
	private Connection con;
	private Boolean isConnected;
	Statement stmt;
	public ResultSet rs;
	public ResultSet rs1;

	public void createconnection() throws SQLException, ClassNotFoundException {
		Class.forName(Config.getConfigs().getPropertyValue("JDBC_DRIVER"));
		con = DriverManager.getConnection(Config.getConfigs().getPropertyValue("CON_DB_URL"),
				Config.getConfigs().getPropertyValue("CON_DB_USERNAME"),
				Config.getConfigs().getPropertyValue("CON_DB_PASSWORD"));
		isConnected = true;
	}

	public ResultSet createqueryForShipmentErrorTable(String Id) throws SQLException {
		query1 = "select * from CORBEV01 where CON_ID='" + Id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query1);
		return rs;
	}

	public ResultSet createqueryForArticleTable(String Id) throws SQLException {
		query1 = "select * from CORARV01 where CON_ID='" + Id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query1);
		return rs;
	}

	public ResultSet createqueryForDangerousGoodsTable(String Id, int cdg_number) throws SQLException {
		query1 = "select * from CORDGV01 where CON_ID='" + Id + "'and CDG_NR='" + cdg_number + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query1);
		return rs;
	}

	public ResultSet createqueryForAddressTable(String Id, String addressTypeCode) throws SQLException {
		query1 = "select * from CORCNV01 where CON_ID='" + Id + "' and CPN_TYPE_CD='" + addressTypeCode + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query1);
		return rs;
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
