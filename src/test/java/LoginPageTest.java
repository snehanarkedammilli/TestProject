import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class LoginPageTest extends TestBase{ 
	
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
	super();
	}


		@BeforeMethod
		public void setUp() {
			initialization();
			loginPage=new LoginPage();
		}
		
		
		@Test(priority=1)
		public void LoginTest() {
			homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		}
		

		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		








}