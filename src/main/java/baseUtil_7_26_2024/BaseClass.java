package baseUtil_7_26_2024;

import java.lang.reflect.Method;
//import java.lang.module.Configuration;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import reports.ExtentReportManager;
import reports.TestManager;
import utils.Configuration;

import static utils.IConstant.*;
import common.CommonAction;

public class BaseClass {

	public WebDriver driver;
	public HomePage homePage;
	Configuration configuration;
	ExtentReports extentReports;
	ExtentTest extentTest;
	String browserName;

	@BeforeSuite
	public void initialReporting() {
		extentReports = ExtentReportManager.initialReports();
	}

	@BeforeClass
	public void beforeClassSetUp() {
		configuration = new Configuration();
	}

	// newly added
	@BeforeMethod
	public void initialTest(Method method) {
		extentTest = TestManager.createTest(extentReports, method.getName());
		extentTest.assignCategory(method.getDeclaringClass().getName());
	}

	@BeforeMethod
	public void setup(@Optional(CHROME) String browserName) {
		this.browserName = browserName;
		initDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.get(configuration.getProperties(URL));
		driver.get(configuration.getProperties(URL));
		// How can we convert a String to Long type
		long pageLoadWait = Long.parseLong(configuration.getProperties(PAGELOAD_WAIT));
		long implicitlyWait = Long.parseLong(configuration.getProperties(IMPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		initClass();
	}

	public void initDriver(String browserName) {
		// String browserName = configuration.getProperties(BROWSER);
		switch (browserName) {
		case CHROME:
			System.setProperty("webDriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case EDGE:
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}

	}

	public void initClass() {
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for (String group : result.getMethod().getGroups()) {
			extentTest.assignCategory(group);
		}

		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test PASSED");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.addScreenCaptureFromPath(CommonAction.getSreenShot(method.getName(), driver));
			extentTest.log(Status.FAIL, "Test FAILED");
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test SKIPPED");
		}
	}

	@AfterSuite
	public void publishReport() {
		extentReports.flush();
	}

	// create config.properties file in src/main/resoures
	// create utils package
	// Inside utils, create enum Constant, Interface IConstant, Configuration class
	// Bring changes in Base class
	// static import necessary for ---> import static utils.IConstant.*

}
