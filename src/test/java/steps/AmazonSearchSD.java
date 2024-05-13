package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSearchSD extends BrowserFactory{
	
	String sURL = "https:www.amazon.in/";
	
	
	
	@Given("User should navigate to Amazon")
	public void user_should_navigate_to_amazon() {
		driver.navigate().to(sURL);
		System.out.println("Title is : "+driver.getTitle());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  
	}

		
		@When("User search with multiple products in Amazon called")
		public void user_search_with_multiple_products_called(DataTable dataTable) {
		 List<Map<String, String>> searchs = dataTable.asMaps();
			for (Map<String, String> search : searchs) {
				WebElement oProduct,oDropDown,oButton;
				oProduct = driver.findElement(By.id("twotabsearchtextbox"));
				oProduct.clear();
				oProduct.sendKeys(search.get("ProdName"));
				
				oDropDown = driver.findElement(By.id("searchDropdownBox"));
				Select oSelect = new Select(oDropDown);
				oSelect.selectByVisibleText(search.get("ProdCat"));
				
				oButton = driver.findElement(By.id("nav-search-submit-button"));
				oButton.click();
			}
	} 

	@Then("Validate the Amazon search result")
	public void validate_the_search_result() {
		WebElement oResult;
		oResult = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]"));
		String sResult = oResult.getText(); 
	    System.out.println("Result is : "+sResult);
	}

}
