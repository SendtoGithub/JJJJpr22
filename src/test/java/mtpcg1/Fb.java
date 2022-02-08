package mtpcg1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
@Test(groups= {"all"})
public class Fb {
	WebDriver driver4000;

  @Test (priority=1,dataProvider="fbinfo",groups={"smoke","regression"})
  public void fbdetails(String firstname,String surname,String phnum,String password) throws Throwable{
	  driver4000.get("https://www.facebook.com/");
	  driver4000.findElement(By.xpath("//a[text()='Create New Account']")).click();
	  driver4000.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
	  driver4000.findElement(By.xpath("//input[@name='lastname']")).sendKeys(surname);
	  driver4000.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(phnum);
	  driver4000.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys(password);
	  
	 WebElement wbe = driver4000.findElement(By.id("day"));
	  Select sl = new Select(wbe);
	  sl.selectByVisibleText("1");
	 driver4000.findElement(By.xpath("//label[text()='Female']/following::input[1]")).click();
	 Thread.sleep(5000);
//	 driver4000.findElement(By.xpath("//a[@id='terms-link']")).click();
//      Thread.sleep(5000);
  }
 
  @Test(priority=2,groups= {"sanity"})
  public void Terms() throws Throwable {
      driver4000.get("https://www.facebook.com/legal/terms/update");
	  driver4000.findElement(By.id("email")).sendKeys("xyz@gmail.com");
	  driver4000.findElement(By.id("pass")).sendKeys("xyz");
	  String acttitle= driver4000.getTitle();
	 System.out.println(acttitle);	  
	 
  }
  @BeforeClass(alwaysRun = true)
  public void beforetest() {
	  WebDriverManager.chromedriver().setup();
	  driver4000 = new ChromeDriver();
	  driver4000.manage().window().maximize();
	  driver4000.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }

  @AfterClass(alwaysRun = true)
  public void aftertest() {
	  driver4000.quit();
  }

@DataProvider(name="fbinfo")
public Object fbdata() throws IOException {
	 String path = "E:\\5555555\\Fbcrtinfo.xlsx";
	   Util ut = new Util(path);
	int ttlrows = ut.rowcount("Sheet1");
	int ttlcols = ut.columcount("Sheet1", 1);
	   
	Object datainfo[][] = new Object[ttlrows][ttlcols];
	for(int i=1; i<=ttlrows; i++) {
		for(int j=0; j<ttlcols; j++) {
			datainfo[i-1][j] = ut.getcell("Sheet1", i, j);
		}
	}
	return datainfo;
	
}
  
}  
  
  //String firstname,String surname,String phnum,String password
/*  <class name="mtpcg2.BetaTest2"/>
  <class name="mtpcg1.TestingApp1"/>
  /*
   
   
    @BeforeTest
  public void beforeTest() {
  }
   @AfterTest
  public void afterTest() {
  }
  
     @BeforeClass
  public void beforeClass() {
   }
    @AfterClass
  public void afterClass() {
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
 
 
 
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }
*/

