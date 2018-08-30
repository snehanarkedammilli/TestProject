import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.RequestsPage;

public class RequestsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	RequestsPage requestsPage;

	public RequestsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		requestsPage = homePage.clickOnRequestsLink();
	}

	@Test(priority = 1)
	public void clickOnRequestsLinkTest() {

		String beforeXpath = "//table/tbody/tr[";
		String afterXpath = "]";

		for (int i = 1; i <= 5; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement tableRow = driver.findElement(By.xpath(actualXpath));

			Actions actions = new Actions(driver);
			actions.moveToElement(tableRow).click().build().perform();

			WebElement table = driver.findElement(By.xpath("//div[contains(@class,'feed-activity-list')]"));

			System.out.println(table.getSize());

			WebElement textArea = driver
					.findElement(By.xpath("//textarea[@placeholder='Leave a message and hit enter...']"));

			textArea.sendKeys("This is Selenium test,this is a New request");
			textArea.click();

			WebElement status = driver.findElement(
					By.xpath("//*[@id=\"react-root\"]/div/div[4]/div/div/div/div[2]/div[1]/div/div[2]/div/span[3]"));

			String statusCode = status.getText();
			String statusNew = "New";
			String statusIssued = "Issued";

			System.out.println(statusCode);

			if (statusCode.equals(statusNew)) {

				System.out.println("hfjasdfa");
				textArea.sendKeys("This is Selenium test,this is a New request");
				textArea.click();
				// textArea.sendKeys(Keys.F5);
			}

			else if (statusCode.equals(statusIssued)) {
				System.out.println("hfjasdfa");
				textArea.sendKeys("This is Selenium test,this is an Issued request");
				// textArea.sendKeys(Keys.F5);
				textArea.click();
			}

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
