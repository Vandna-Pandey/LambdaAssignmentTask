package lambdaTest;

import static lambdaTest.LambdaTestConstants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class LambdaMethods {

	WebDriver driver;
	Properties prop;
	SoftAssert softAssert = new SoftAssert();

	public LambdaMethods(WebDriver anroidDriver, Properties appiumProp) {
		driver = anroidDriver;
		prop = appiumProp;
	}

	public void chromeBrowserLoading() throws IOException {

		File file = new File(PropertyPath);
		FileInputStream fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);

		System.setProperty(NameofChromeBrowser, PathofChromeBrowser);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(LamdaTestURL);
		Reporter.log("LambdaTest Launch...");

		driver.findElement(By.xpath("//span[contains(text(),'Got it')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public void firefoxBrowserLoading() throws IOException {

		File file = new File(PropertyPath);
		FileInputStream fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);

		System.setProperty(NameofEdgeBrowser, PathofEdgeBrowser);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(LamdaTestURL);
		Reporter.log("LambdaTest Launch...");

		driver.findElement(By.xpath("//span[contains(text(),'Got it')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void sauceLabsLogin() throws InterruptedException {
		// driver.findElement(By.xpath(prop.getProperty("Login"))).click();
		System.out.println("It works");
	}

	public void testScenario1() {
		driver.findElement(By.linkText("Simple Form Demo")).click();

		String Url = "https://www.lambdatest.com/selenium-playground/simple-form-demo";
		softAssert.assertTrue(Url.contains("simple-form-demo"));

		String actuallamdaTestMessage = "Welcome to LambdaTest";
		driver.findElement(By.id("user-message")).sendKeys(actuallamdaTestMessage);
		driver.findElement(By.id("showInput")).click();

		String expectedlamdaTestMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();
		System.out.println(expectedlamdaTestMessage);
		softAssert.assertEquals(actuallamdaTestMessage, expectedlamdaTestMessage);

	}

	public void testScenario2() throws InterruptedException {

		driver.findElement(By.xpath("//div[4]/p/i")).click();

		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		WebElement defualtSliderValue15 = driver.findElement(By.id("rangeSuccess"));
		System.out.println(defualtSliderValue15.getText());

		int x = 22;
		WebElement slider = driver.findElement(By.id("slider3"));
		int width = slider.getSize().getWidth();
		int height = slider.getSize().getHeight();
		// System.out.println(width);
		// System.out.println(height);

		Actions move = new Actions(driver);
		move.moveToElement(slider, ((width * x) / 100), ((height * x) / 100)).click();
		move.build().perform();

		WebElement afterMoveSliderValue = driver.findElement(By.id("rangeSuccess"));
		System.out.println(afterMoveSliderValue.getText());

		System.out.println("Slider moved");
	}

	public void testScenario3() throws InterruptedException {

		driver.findElement(By.xpath("//p/i")).click();
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// String amsg=driver.findElement(By.xpath("//form[@id='seleniumform']/div[6]"));
		// String amsg=driver.findElement(By.xpath("//p[contains(text(),'Please fill out
		// this field.')]"));
		/*
		 * Thread.sleep(2000); Alert alert = driver.switchTo().alert();
		 * System.out.println(alert.getText());
		 */
		
		// String alertMessage= driver.switchTo().alert().getText();
		// System.out.println(amsg);

		driver.findElement(By.id("name")).sendKeys("Vandna");
		driver.findElement(By.id("inputEmail4")).sendKeys("test123@gmail.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("test@123");
		driver.findElement(By.id("company")).sendKeys("Techno Pvt Ltd");
		driver.findElement(By.id("websitename")).sendKeys("www.google.com");

		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText("United States");

		driver.findElement(By.id("inputCity")).sendKeys("Bangalore");
		driver.findElement(By.id("inputAddress1")).sendKeys("Bangalore");
		driver.findElement(By.id("inputAddress2")).sendKeys("Phoenix Mall");
		driver.findElement(By.id("inputState")).sendKeys("Karnataka");
		driver.findElement(By.id("inputZip")).sendKeys("560048");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String msg = driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us, we will get back to you shortly.')]")).getText();
		System.out.println(msg);
		softAssert.assertTrue(
		driver.getPageSource().contains("Thanks for contacting us, we will get back to you shortly."));
		softAssert.assertAll();
	}

	public void closeBrowser() {
		// driver.quit();
	}
}
