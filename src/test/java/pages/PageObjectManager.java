package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private WebDriver driver;
	private AmazonHomePage amazonHomePage;
	private EbayHomePage ebayHomePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public EbayHomePage getEbayPage() {
		if(ebayHomePage == null) {
			ebayHomePage = new EbayHomePage(driver);
		}else {
			return ebayHomePage;
		}
		return ebayHomePage;
	}
	
	public AmazonHomePage getAmazonPage() {
		if(amazonHomePage == null) {
			amazonHomePage = new AmazonHomePage(driver);
		}else {
			return amazonHomePage;
		}
		return amazonHomePage;
	}
	
	
	
}
