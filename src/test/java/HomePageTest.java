import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.RequestsPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	RequestsPage requestsPage;
	
	public HomePageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void verifyRequestsLinkTest(){
		requestsPage = homePage.clickOnRequestsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
