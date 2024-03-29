package crm.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import crm.drivers.Driver;
import crm.enums.ConfigProperties;
import crm.factories.DriverFactory;
import crm.objectRepository.HomePage;
import crm.objectRepository.LoginPage;


public class BaseClass {

	protected WebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite(groups = { "SMOKE", "SANITY" })
	public void bsConfig() {
		System.out.println("====== DB Connection Successful ======");
	}

	@BeforeClass(alwaysRun = true)
	@Parameters("xmlbrowser")
	public void bcConfig(@Optional String xmlbrowser, ITestContext context) throws Exception {

		if (xmlbrowser!=null) {
			driver = Driver.initDriver(xmlbrowser, DriverFactory.browserVersion);
		} else {
			String browser = PropertyUtils.get(ConfigProperties.BROWSER);
			driver = Driver.initDriver(browser, DriverFactory.browserVersion);
		}

	}

	@BeforeMethod(groups = { "SMOKE", "SANITY" })
	public void bmConfig() {
		String username = PropertyUtils.get(ConfigProperties.USERNAME);
		String passpowd = PropertyUtils.get(ConfigProperties.PASSWORD);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, passpowd);

		System.out.println("====== Login to App Successful ======");
	}

	@AfterMethod(groups = { "SMOKE", "SANITY" })
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logOutOfApp(driver);
		System.out.println("====== Logout of App Successful ======");
	}

	@AfterClass(groups = { "SMOKE", "SANITY" })
	public void acConfig() {
	//	driver.quit();
		System.out.println("====== Browser Closed ======");
	}

	@AfterSuite(groups = { "SMOKE", "SANITY" })
	public void asConfig() {
		System.out.println("====== DB Connection Closed ======");
	}
}