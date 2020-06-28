package exampleProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	public static void main(String[] args) {
//		getConnection();
		// createTable();
		//for (int i = 0; i < 15; i++)
		createCustomer("Danny", "123456789", "Male", "23", "Random Note...");

//		createCustomer("Daivd", "4441122211", "Female", "25", "Important Customer");
//		
//		ArrayList<String> list = getCustomers();
//		
//		for (String string : list) {
//			System.out.println(string);
//		}
	}

	public static void createCustomer(String name, String phone, String gender, String age, String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement("INSERT INTO customer" + "(name, phone, gender, age, note) "
					+ "VALUE " + "('" + name + "','" + phone + "','" + gender + "','" + age + "','" + note + "')"); // string이라
																													// ''로
																													// 묶어야함
			// ('name','phone','gender','age','note')
			insert.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<String> getCustomers() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, phone, gender FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while (results.next()) { // next() 다음데이터 없으면 false
				list.add("Name : " + results.getString("name") + " Phone : " + results.getString("phone") + " Gender : "
						+ results.getString("gender"));
			}
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static String[][] getCustomers2() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, phone, gender, age, note FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) { // next() 다음데이터 없으면 false
				list.add(new String[] { results.getString("name"), results.getString("phone"),
						results.getString("gender"), results.getString("age"), results.getString("note") });
			}
			System.out.println("The data has been fetched.");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS "
					+ "customer(id int NOT NULL AUTO_INCREMENT," + "name varChar(255)," + "phone varChar(255),"
					+ "gender varChar(255)," + "age varChar(255)," + "note varChar(255)," + "PRIMARY KEY(id))");
			create.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}

	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12351214";
			String user = "sql12351214";
			String pass = "TbRGFB8sW8";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("The Connection Successful");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
