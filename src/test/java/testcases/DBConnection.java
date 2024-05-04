package testcases;

import java.sql.SQLException;

import utility.DbManager;

public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id=2"));

	}

}
