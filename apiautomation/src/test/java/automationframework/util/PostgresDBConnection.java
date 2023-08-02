package automationframework.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;

import automationframework.resources.Config;
import automationframework.resources.Utils;

public class PostgresDBConnection extends Utils {
	String query_postgres;
	public static String CON_ID;
	public static String result;
	Connection con;
	Statement stmt;
	public ResultSet rs;
	public ResultSet rs1;
	public ResultSet resultsetPostgres;

	public PostgresDBConnection createconnection() throws ClassNotFoundException, SQLException {
		Class.forName(Config.getConfigs().getPropertyValue("POSTGRES_DRIVER"));
		con = DriverManager.getConnection(Config.getConfigs().getPropertyValue("POSTGRES_DB_URL"),
				Config.getConfigs().getPropertyValue("POSTGRES_DB_USERNAME"),
				Config.getConfigs().getPropertyValue("POSTGRES_DB_PASSWORD"));
		return new PostgresDBConnection();
	}

	public PostgresDBConnection createconnectionForDGTable() throws ClassNotFoundException, SQLException {
		Class.forName(Config.getConfigs().getPropertyValue("POSTGRES_DRIVER"));
		con = DriverManager.getConnection(Config.getConfigs().getPropertyValue("POSTGRES_DB_URL"),
				Config.getConfigs().getPropertyValue("POSTGRES_DB_DG_USERNAME"),
				Config.getConfigs().getPropertyValue("POSTGRES_DB_PASSWORD"));

		return new PostgresDBConnection();
	}

	public PostgresDBConnection createconnectionForArticleTable() throws ClassNotFoundException, SQLException {
		Class.forName(Config.getConfigs().getPropertyValue("POSTGRES_DRIVER"));
		con = DriverManager.getConnection(Config.getConfigs().getPropertyValue("POSTGRES_DB_URL"),
				Config.getConfigs().getPropertyValue("POSTGRES_DB_ARTICLE_USERNAME"),
				Config.getConfigs().getPropertyValue("POSTGRES_DB_PASSWORD"));

		return new PostgresDBConnection();
	}

	public ResultSet createqueryForRefTx(String Customer_Ref_Tx) throws SQLException {
		query_postgres = "select * from CORCOV01 where CON_CLNT_REF_TX='" + Customer_Ref_Tx + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_postgres);

		return rs;
	}

	public ResultSet createqueryForShipmentErrorTable(String Id) throws Throwable {
		query_postgres = "select * from shipment.shipment_error_vw where shipment_uu_id='" + Id + "'";
		stmt = con.createStatement();
		resultsetPostgres = stmt.executeQuery(query_postgres);
		return resultsetPostgres;
	}

	public ResultSet createqueryForAddressTable(String Id, String addressTypeCode) throws Throwable {
		query_postgres = "select * from shipment.shipment_address_vw where shipment_uu_id='" + Id
				+ "' and address_type_cd='" + addressTypeCode + "'";
		stmt = con.createStatement();
		resultsetPostgres = stmt.executeQuery(query_postgres);
		Thread.sleep(1000);
		return resultsetPostgres;
	}

	public ResultSet createqueryForDGTable(String Id, int DgSequenceNumber) throws Throwable {
		query_postgres = "select * from shipment.shipment_dg_vw where shipment_uu_id='" + Id + "' and dg_sequence_nbr='"
				+ DgSequenceNumber + "'";
		stmt = con.createStatement();
		resultsetPostgres = stmt.executeQuery(query_postgres);
		return resultsetPostgres;
	}

	public ResultSet createqueryForArticleTable(String Id) throws Throwable {
		query_postgres = "select * from shipment.shipment_article_vw  where shipment_uu_id='" + Id + "'";
		stmt = con.createStatement();
		resultsetPostgres = stmt.executeQuery(query_postgres);
		return resultsetPostgres;
	}

	public ResultSet createqueryForPostgresDatabaseDiachriticCharacter(String Id, String addressTypeCode)
			throws Throwable {
		query_postgres = "select * from shipment.shipment_address_vw where shipment_uu_id='" + Id
				+ "' and address_type_cd='" + addressTypeCode + "'";
		stmt = con.createStatement();
		resultsetPostgres = stmt.executeQuery(query_postgres);
		return resultsetPostgres;
	}

	public ResultSet createqueryForPostgresDatabase(String Id) throws Throwable {
		query_postgres = "select * from shipment.shipment_vw where shipment_nbr='" + Id + "'";
		stmt = con.createStatement();
		resultsetPostgres = stmt.executeQuery(query_postgres);
		return resultsetPostgres;
	}

	public ResultSet createqueryForPostgresDatabaseWithUUID(String Id) throws Throwable {
		query_postgres = "select * from shipment.shipment_vw where shipment_uu_id='" + Id + "'";
		stmt = con.createStatement();
		resultsetPostgres = stmt.executeQuery(query_postgres);
		return resultsetPostgres;
	}

	@AfterClass
	public PostgresDBConnection closeConnection() throws SQLException {
		con.close();
		return new PostgresDBConnection();

	}
}
