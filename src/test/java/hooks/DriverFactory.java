package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class DriverFactory {
	private WebDriver driver;

	
	@After(value = "@Smoke")
	public void closeBrowser() {
	driver.quit();
	}

	//@AfterStep
	@AfterStep
	public void afterStep(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "FailedScreen");
		}
	}
}
