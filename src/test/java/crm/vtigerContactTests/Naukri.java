package crm.vtigerContactTests;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Naukri {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		//Launch the url
		driver.get("https://www.naukri.com/mnjuser/profile?id=&altresid");
		//Send user id and password
		driver.findElement(By.id("usernameField")).sendKeys("crispycherry4u@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Passw0rd");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Complete']")).click();
		Thread.sleep(5000);
		WebElement resumebut = driver.findElement(By.linkText("Upload"));
		// click the button
		resumebut.click();
		Thread.sleep(3000);
		String filename =  "C:\\Users\\ansum\\Downloads\\sampleResume.pdf";
		// set content in clipboard
		StringSelection clipcon = new StringSelection(filename);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipcon, null);
		Robot robot = new Robot();
		robot.delay(1000);
		// Paste-Ctrl+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		// Release control key
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// Press enter key
		robot.keyPress(KeyEvent.VK_ENTER);
		// Release enter key
		robot.keyRelease(KeyEvent.VK_ENTER);
  }
}