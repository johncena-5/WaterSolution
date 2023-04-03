package GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementingClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		String method = result.getMethod().getMethodName();
		test = report.createTest(method);
		Reporter.log(method+" testScript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+" passed");
		Reporter.log(MethodName+" testscript execution success");
		
	}

	public void onTestFailure(ITestResult result) {
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Java/FailedtestScript.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = dest.getAbsolutePath();
		test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+" skip");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("test execution skipped");
		
	}

	public void onStart(ITestContext context) {
		
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtendReport/report.html");
		htmlreport.config().setDocumentTitle("TEST YANTRA");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("HOUSE RENTAL APPLICATION");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("os", "windows");
		report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/House_Rental_Application/index.php");
		report.setSystemInfo("Reporter", "waris");
	}

	public void onFinish(ITestContext context) {
		
		report.flush();
		
	}
}
