package reports;
//Before you create this class add dependency from the extent report

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	static ExtentReports extentReports;

	public static ExtentReports initialReports() {
		if (extentReports == null) {
			extentReports = new ExtentReports();
			// we use ExtentSparkReporter class to define our Report
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent_report.html");
			sparkReporter.config().setReportName("CMS Enterprise Automation Test Report");
			sparkReporter.config().setTheme(Theme.DARK);
			// how extent report object with the sparkReporter
			extentReports.attachReporter(sparkReporter);
			// How extentReports object connect spartReporter
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("Tester", System.getProperty("user.name"));
			extentReports.setSystemInfo("OS", System.getProperty("os.name")); // OS = Operating System
			extentReports.setSystemInfo("OS Version", System.getProperty("os.version"));
			extentReports.setSystemInfo("OS Arch", System.getProperty("os.arch"));
			extentReports.setSystemInfo("Environment", "SIT"); // QA or SIT = System Integration Test, UAT = User
																// Acceptance Test
		}
		return extentReports;
	}

	/*
	 * 1) extent report dependency in pom.xml file, update maven project 2) Create
	 * ExtentReportManager class and define the report 3) Create TestManager to
	 * connect test and report 4) Update Loggers class 5) Update in Base class
	 */

}
