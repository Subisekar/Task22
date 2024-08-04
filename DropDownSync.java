import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;



public class DropDownSync {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {
	
	// WebDriver driver = new ChromeDriver();	
			ChromeDriver driver = new ChromeDriver();
			WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(20));// declaration
			
			driver.get("https://phptravels.com/demo/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			WebElement firstNameField = driver.findElement(By.xpath("//input[@name ='first_name']"));
			firstNameField.sendKeys("Selenium");
			
			WebElement lastNameField = driver.findElement(By.xpath("//input[@name ='last_name']"));
			lastNameField.sendKeys("Testing");
			
			WebElement businessField = driver.findElement(By.xpath("//input[@name ='business_name']"));
			businessField.sendKeys("Software Testing");
			
			WebElement email = driver.findElement(By.xpath("//input[@name ='email' and @placeholder = 'Email']"));
			email.sendKeys("test@test.com");
			
			WebElement num1 = driver.findElement(By.xpath("//span[@id = 'numb1']"));
			String value1 = num1.getText();
			
			WebElement num2 = driver.findElement(By.xpath("//span[@id = 'numb2']"));
			String value2 = num2.getText();
			
			int sum = Integer.parseInt(value1)+Integer.parseInt(value2);
			String sumvalue = Integer.toString(sum);
			
			WebElement resultField = driver.findElement(By.xpath("//input[@id = 'number']"));
			resultField.sendKeys(sumvalue);
			
			WebElement Number = driver.findElement(By.name("whatsapp"));
			Number.sendKeys("7871356547");
			
//			
	WebElement submit = driver.findElement(By.xpath("//button[@id='demo']"));
	mywait.until(ExpectedConditions.elementToBeClickable(submit));
	Actions act = new Actions(driver);
	act.moveToElement(submit).click().perform();
	
	TakesScreenshot screenshot =(TakesScreenshot)driver;
	File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	File desFile = new File("C:\\Users\\Subth\\OneDrive\\Desktop\\TrackingFolder\\SeleniumResult.png");
	FileUtils.copyDirectory(srcFile, desFile);
	
	
	
		
}
}
