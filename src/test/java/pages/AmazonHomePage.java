package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.PropertyReader;

public class AmazonHomePage {
	
	String sURL = PropertyReader.readDataFromPropertyFile("environment", "amazon");
	private WebDriver driver;
	private By productNameTxt = By.id("twotabsearchtextbox");
	private By prodCatagoryDrop = By.id("searchDropdownBox");
	private By searchButton = By.id("nav-search-submit-button");
	private By searchResult = By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]");
	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateURL() {
		driver.navigate().to(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	} 
	
	public void enterProductName(String prodName) {
		WebElement oProduct;
		oProduct = driver.findElement(productNameTxt);
		oProduct.clear();
		oProduct.sendKeys(prodName);
	}
	
	public void selectProductCatagory(String prodCat) {
		WebElement oDropDown;
		oDropDown = driver.findElement(prodCatagoryDrop);
		Select oSelect = new Select(oDropDown);
		oSelect.selectByVisibleText(prodCat);
	}
	
	public void clickSearchButton() {
		WebElement oButton = driver.findElement(searchButton);
		oButton.click();
	}
	
	public String getsearchResult() {
		WebElement oResult;
		oResult = driver.findElement(searchResult);
		String sResult = oResult.getText();
		return sResult;
	}
	
	
}
