package com.pronoydas.utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestNGListner  implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		if(Objects.nonNull(result)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			System.out.println(sw.toString());
		}
		TakesScreenshot driver = (TakesScreenshot) result.getTestContext().getAttribute("DRIVER");
        String screenshot = driver.getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";
        String htmlImage = String.format(htmlImageFormat, screenshot);
        Reporter.log(htmlImage);
	}
	
	


}
