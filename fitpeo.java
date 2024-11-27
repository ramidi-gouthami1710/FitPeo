package AutoSuggestions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

public class fitpeo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","C:\\Users\\91960\\eclipse-workspace\\seleniumA1\\chromedriver-win32\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();

//Navigate to url//****
driver.get("https://www.fitpeo.com/");
WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));
revenueCalculatorLink.click();
Thread.sleep(1000);

WebElement element = driver.findElement(By.xpath("//div[contains(@class,'MuiInputBase-root ')]/parent::div"));
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true);", element);
//
//Thread.sleep(2000);
//ele1.sendKeys("220");
Thread.sleep(1000);

//scroll to 820/
WebElement slider = driver.findElement(By.xpath("//input[contains(@type,'range')]/parent::span[contains(@class,'Mui')]"));
Actions actions = new Actions(driver);
actions.clickAndHold(slider).moveByOffset((int) 94, 2).release().perform();
//
//WebElement textField = driver.findElement(By.id(":r0:")); // Replace with actual ID or XPath
//textField.clear();
//textField.sendKeys("560");
// select cpt codes//
driver.findElement(By.xpath("(//label//span//input[contains(@type,'checkbox')])[1]")).click();
driver.findElement(By.xpath("(//label//span//input[contains(@type,'checkbox')])[2]")).click();
driver.findElement(By.xpath("(//label//span//input[contains(@type,'checkbox')])[3]")).click();
driver.findElement(By.xpath("(//label//span//input[contains(@type,'checkbox')])[8]")).click();

////Validate Total Recurring Reimbursement://
//
try {
    String totalReimbursement = driver.findElement(By.xpath("//p[contains(text(),'Total Recurring Reimbursement ')]/descendant::p")).getText();
    String expectedValue = "$111105";

    Assert.assertEquals(expectedValue, totalReimbursement);
    System.out.println("ExpectedValue and actualValues are same");
    System.out.println("CalculatedValue" + totalReimbursement);
    Thread.sleep(1000);
    driver.quit();
} catch (NoSuchElementException e) {
    System.out.println("Element not found: " + e.getMessage());

	}
	}
}
	

