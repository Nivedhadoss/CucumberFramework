package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import base.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbaySearch extends BrowserFactory{
	
	
	public static String sURL = "https://www.ebay.com/";
	



@Given("I should navigate to Ebay URL")
public void i_should_navigate_to_ebay_url() {
	driver.get(sURL);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Polling Every .5sec or 500ms
}

@When("I will type the product and select the product catagory")
public void i_will_type_the_product_and_select_the_product_catagory() {
	WebElement oText,oDrop;
	oText = driver.findElement(By.id("gh-ac"));
	oText.sendKeys("iPhone");
	oDrop = driver.findElement(By.id("gh-cat"));
	Select oSelect = new Select(oDrop);
	oSelect.selectByVisibleText("Cell Phones & Accessories");
}


@When("^I will type the multiple product name as (\\D+) and select the multiple product catagory as (\\D+)$")
public void i_will_type_the_multiple_product_name_as_i_phone_and_select_the_multiple_product_catagory_as_cell_phones_accessories(String prodName,String prodCatagory) {
	WebElement oText,oDrop;
	oText = driver.findElement(By.id("gh-ac"));
	oText.sendKeys(prodName);
	oDrop = driver.findElement(By.id("gh-cat"));
	Select oSelect = new Select(oDrop);
	oSelect.selectByVisibleText(prodCatagory);
}

@When("I will type the product name from the below data table as a map")
public void i_will_type_the_product_name_from_the_below_data_table_as_a_map(DataTable dataTable) {
	List<Map<String, String>> rows = dataTable.asMaps();
	WebElement oText,oDrop;
	for (Map<String, String> row : rows) {
		String prodName = row.get("ProductName");
		String prodCat = row.get("ProductCatagory");
		oText = driver.findElement(By.id("gh-ac"));
		oText.clear();
		oText.sendKeys(prodName);
		oDrop = driver.findElement(By.id("gh-cat"));
		Select oSelect = new Select(oDrop);
		oSelect.selectByVisibleText(prodCat);
	}
}


@When("I will click on search button")
public void i_will_click_on_search_button() {
    WebElement oBtn;
    oBtn = driver.findElement(By.id("gh-btn"));
	oBtn.click();
}

@Then("I should see the search product result")
public void i_should_see_the_search_product_result() {
	WebElement oResult;
	oResult = driver.findElement(By.xpath("(//h1[@class='srp-controls__count-heading']/span)[1]"));
	String sResult = oResult.getText();
	System.out.println("Result is : "+sResult);
	sResult = sResult.replaceAll("[^0-9]", "");
	int iResult = Integer.parseInt(sResult);
	System.out.println("Number Result is : "+iResult);
	}


}
