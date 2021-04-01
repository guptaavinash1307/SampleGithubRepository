package PKG1;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Scrript1 {

	// step1
	static ExtentReports extent = new ExtentReports();
	// step2
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");

	@BeforeSuite
	public void BeforeSutite() {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("report.html");
		extent.attachReporter(sparkReporter);
	}

	@AfterSuite
	public void AfterSuite() {
		extent.flush();
	}

	@Test
	public void DemoExtentReports1() {
		ExtentTest test = extent.createTest("TC1_DemoExtentReports1");
		test.log(Status.INFO, "Launching Chorme Browser");
		test.info("Opening url on browser:" + "http://stackoverflow.com");
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\CG-DTE\\Desktop\\Wells_Fargo\\selenium_workspace\\chromedriver.exe");
	
		driver.get("http://stackoverflow.com");
		test.info("Clicking on Login  button");
		driver.findElement(By.linkText("Log in")).click();
		System.out.println("Test1 cllicked to the Login Button");
		test.pass("we have succesfully clicked on Login Button");
		test.info("Closing Browser");
		test.info("DIsponssing selenium sessions");
		driver.quit();
	}

	@Test
	public void DemoExtenetReport2() {
		//Negiative scea
		ExtentTest test = extent.createTest("TC2_DemoExtentReports2");
		test.log(Status.INFO, "Launching Chorme Browser");
		test.info("Opening url on browser:" + "http://stackoverflow.com");
				
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\CG-DTE\\Desktop\\Wells_Fargo\\selenium_workspace\\chromedriver.exe");
        
        // Initialize browser
        WebDriver driver = new ChromeDriver();
		driver.get("http://stackoverflow.com");
		test.info("Clicking on Login  button");
		try {
		driver.findElement(By.linkText("Log ")).click();
		//Above link is wrong "Log" it should be "Log in" so we can say that we are using Negavtive Sceanrios
		}
		catch (NoSuchElementException e) {
			System.out.println("could not locate the element");
			test.fail("Unabel to find th Login Button");
		}
		test.pass("we have succesfully clicked on Login Button");
		test.info("Closing Browser");
		test.info("DIsponssing selenium sessions");
		driver.quit();

	}

}
