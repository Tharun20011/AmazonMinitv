package TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BaseClass.baseTest;
import functionalityRepository.amazon_MiniTv_fun;


public class amazon_MiniTv {
	

	baseTest bt = new baseTest();

	@BeforeSuite
	public void browser() throws Exception {

		bt.initbrowser();
		bt.driver.get("https://www.amazon.in/minitv");
		

	}

	

	@Test(priority = 1)
	public void loginpositive() throws Exception {

		amazon_MiniTv_fun ltp = new amazon_MiniTv_fun();

		ltp.login();

	}

	

	@AfterSuite
	public void browserquit() throws Exception {

		bt.driver.quit();

	}

}
