package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.RequestsPage;
import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"react-root\"]/div/nav/ul/li[2]/a/span")
	WebElement requestsLink;

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public RequestsPage clickOnRequestsLink(){
		requestsLink.click();
		return new RequestsPage();
	}
	
	
	
}
