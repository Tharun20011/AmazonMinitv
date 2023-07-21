package functionalityRepository;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClass.baseTest;
import ObjectRepository.amazon_MiniTv_obj;
import Reports.ExtentManager;

public class loginTestPratcis2 {

	baseTest bt = new baseTest();

	amazon_MiniTv_obj lp = PageFactory.initElements(bt.driver, amazon_MiniTv_obj.class);

	@Test
	public void login() throws InterruptedException, IOException {

		bt.initbrowser();
		bt.driver.get("https://www.amazon.in/minitv");

		String actualTitle = bt.driver.getTitle();

		String expectedTitle = "Watch Free Web Series & Short Films Online | Amazon miniTV";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title is verfied");

		} else {
			System.err.println("Title is not verified");
		}
		Thread.sleep(1000);
		lp.webSeries.click();

		bt.impwait(50);

		lp.preferedSeries.click();

		bt.driver.findElement(By.xpath("//h2[contains(text(),'Season  " + 1 + "')]")).click();
		bt.impwait(50);

		bt.driver.findElement(By.xpath(
				"//*[@id='__next']/div/div/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/div[1]/div[2]/a/div/span[1]/span/img"))
				.click();

		bt.impwait(50);

		Actions a = new Actions(bt.driver);

		a.moveToElement(bt.driver.findElement(By.xpath("//div[@data-testid='titleScreen_player_watermark']")))
				.perform();
		bt.impwait(50);
		lp.playButton.click();
		JavascriptExecutor js = (JavascriptExecutor) bt.driver;

		js.executeScript("jwplayer().play();");

	}

}
