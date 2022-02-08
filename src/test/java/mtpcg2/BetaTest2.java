package mtpcg2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BetaTest2 {
		@Test
		public void B1() {
			WebDriverManager.chromedriver().setup();
			WebDriver driver4000 = new ChromeDriver();
			driver4000.get("https://www.facebook.com/");
			
		}
}
