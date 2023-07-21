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

import com.aventstack.extentreports.Status;

import BaseClass.baseTest;
import ObjectRepository.amazon_MiniTv_obj;
import Reports.ExtentManager;

public class amazon_MiniTv_fun {

	baseTest bt = new baseTest();
	WebDriverWait wait = new WebDriverWait(bt.driver, 30);

	amazon_MiniTv_obj lp = PageFactory.initElements(bt.driver, amazon_MiniTv_obj.class);

	public void login() throws InterruptedException, IOException {

		String actualTitle = bt.driver.getTitle();
	

		String expectedTitle = "Watch Free Web Series & Short Films Online | Amazon miniTV";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title is verfied");
			ExtentManager.logpass(Status.PASS, "Title is verfied", true);

		} else {
			System.err.println("Title is not verified");
		}

		lp.webSeries.click();

		bt.impwait(50);

		lp.preferedSeries.click();

		for (int i = 1; i <= 3; i++) {

			bt.driver.findElement(By.xpath("//h2[contains(text(),'Season  " + i + "')]")).click();
			bt.impwait(50);

			if (i == 1) {
				bt.driver.findElement(By.xpath(
						"//*[@id='__next']/div/div/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/div[1]/div[2]/a/div/span[1]/span/img"))
						.click();
			} else if (i == 2) {
				bt.driver.findElement(By.xpath(
						"//*[@id='__next']/div/div/div/div/div[2]/div[1]/div/div[2]/div[2]/div/div/div[1]/div[2]/a/div/span[1]/span/img"))
						.click();

			} else {
				bt.driver.findElement(By.xpath(
						"//*[@id='__next']/div/div/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[2]/a/div/span[1]/span/img"))
						.click();

			}
			bt.impwait(50);

			Actions a = new Actions(bt.driver);

			a.moveToElement(bt.driver.findElement(By.xpath("//div[@data-testid='titleScreen_player_watermark']")))
					.perform();
			bt.impwait(50);
			lp.playButton.click();
			bt.impwait(50);
			String pb = lp.playBack.getAttribute("alt");
			System.out.println(pb);
			if (pb.equals("play")) {
				bt.impwait(50);
				System.out.println("Season " + i + "Episode 1 video is paused");
				ExtentManager.logpass(Status.PASS,"Season " + i + "Episode 1 video is paused", true);
			} else {
				System.err.println("Season " + i + "Episode 1 video is not paused");
				ExtentManager.logpass(Status.FAIL,"Season " + i + "Episode 1 video is not paused", true);
			}
			Assert.assertEquals(pb, "play", "Passed");
        
			lp.playButton.click();
			 Thread.sleep(5000);
			 bt.impwait(200);
			 a.moveToElement(bt.driver.findElement(By.xpath("//div[@data-testid='titleScreen_player_watermark']")))
				.perform();
			
			pb = lp.playBack.getAttribute("alt");
			System.out.println(pb);
			if (pb.equals("pause")) {
				System.out.println("Season " + i + "Episode 1 video is played");
				bt.impwait(50);
				ExtentManager.logpass(Status.PASS,"Season " + i + "Episode 1 video is played", true);
			} else {
				ExtentManager.logpass(Status.FAIL, "Season " + i + "Episode 1 video is not played", true);
				System.err.println("Season " + i + "Episode 1 video is not played");
			}

			assertEquals(pb, "pause", pb);
			
			

			lp.playButton.click();

			bt.driver.findElement(By.xpath("//img[@alt='close']")).click();
			bt.impwait(50);

			ExtentManager.logpass(Status.PASS, "Season " + i + "Episode 1 is selected and played", true);

		}

	}

}
