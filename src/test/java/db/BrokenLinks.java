package db;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException

	{
		WebDriverManager.firefoxdriver().arch64().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/");
		
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);

			String url = ele.getAttribute("href");
			System.out.println(url);
			//System.out.println("it will give the exact amount of links available ...");
			verifyLinkActive(url);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("alert('hello world');");
			Thread.sleep(5);
		}
	}


	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_INTERNAL_ERROR);}
			
		} catch (Exception e) {
		}
	}
}