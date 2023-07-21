package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import BaseClass.baseTest;

public class amazon_MiniTv_obj {
 baseTest bt = new baseTest();

	public amazon_MiniTv_obj(WebDriver driver) {
		
		this.bt.driver = bt.driver;
	}

//Using FindBy for locating elements
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Web Series')]")
	public  WebElement webSeries;
	@FindBy(how = How.XPATH, using = "//img[@alt='Please Find Attached - Season 3 - Watch Free']")
	public  WebElement preferedSeries;
	@FindBy(how = How.XPATH, using = "//button[@data-testid='titleScreen_descriptionCard_playButton']")
	public  WebElement watchButton;

	@FindBy(how = How.XPATH, using = "//div[1][@class='BottomPanel_playbackButton__5BdAb']")
	public  WebElement playButton;
	
	@FindBy(how = How.XPATH, using = "//video[@class='shaka-video']")
	public  WebElement waterMark;
	
	@FindBy(how = How.XPATH, using = "//div[1][@class='BottomPanel_playbackButton__5BdAb']/img")
	public  WebElement playBack;
	
	@FindBy(how = How.XPATH, using = "//div[1][@class='BottomPanel_playbackButton__5BdAb']/img")
	public  WebElement playTiming;
	
	
	
}
