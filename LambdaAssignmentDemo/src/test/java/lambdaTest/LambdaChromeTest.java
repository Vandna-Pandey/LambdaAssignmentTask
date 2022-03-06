package lambdaTest;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LambdaChromeTest {
	
	WebDriver driver;
	Properties prop;
	LambdaMethods lambda = new LambdaMethods(driver, prop);

	@BeforeTest
	public void launchbrowser() throws IOException {
		lambda.chromeBrowserLoading();
	}
	@Test
	void lambdaTest() throws InterruptedException{
		lambda.testScenario1();
		lambda.testScenario2();
		lambda.testScenario3();
	}
	@AfterTest
	public void closeBrowser() 
	{
		lambda.closeBrowser();
	}
}
