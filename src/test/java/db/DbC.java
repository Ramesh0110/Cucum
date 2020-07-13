package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DbC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";
		
		Connection c=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Demo", "root", "root");
		Statement s =c.createStatement();
		ResultSet r=s.executeQuery("select * from test rownum=1");
		
		while(r.next()) {
			
	
//	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//	WebDriver driver=new ChromeDriver();
//	driver.get("https://www.facebook.com/");
					
	//driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(r.getString("name"));
	//driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(r.getString("phone"));
			System.out.println(r.getString("name"));
			System.out.println(r.getString("phone"));
		}

	}
	

}
