package com.Udemy.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.Udemy.utilities.MonitoringMail;
import com.Udemy.utilities.TestConfig;
import com.Udemy.utilities.Utilities;
import com.Udemy.base.Page;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListener extends Page implements ITestListener, ISuiteListener {

	public String messageBody;
	
	public void onTestStart(ITestResult result) {
		t = reports.startTest(result.getName().toUpperCase() +" Passed "+ result.getTestName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			Utilities.captureScreenshot();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		t.log(LogStatus.FAIL, result.getName().toUpperCase()+" FAILED with exception" + result.getThrowable());
		t.log(LogStatus.FAIL, t.addScreenCapture(Utilities.screenshotName));
		
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");
		reports.endTest(t);
		reports.flush();
	}
	
	public void onTestSkipped(ITestResult result) {
		t.log(LogStatus.SKIP, result.getName().toUpperCase()+" SKIPPED");
		reports.endTest(t);
		reports.flush();
	}
	
	public void onTestSuccess(ITestResult result) {
		t.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		reports.endTest(t);
		reports.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		MonitoringMail mail = new MonitoringMail();
		
		try {
			messageBody = "http://" +InetAddress.getLocalHost().getHostName()+":8080/job/PageObjectModelFramework/HTML_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
