package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class New_test {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


	public void open_browser() throws InterruptedException {
		driver.get("https://www.expedia.co.in/");
		Thread.sleep(1300);
		
		
	}
		


	public void dep_dest() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(@class, 'uitk-tab-text') and contains(text(), 'Flights')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(@class, 'uitk-tab-text') and contains(text(), 'One-way')]")).click();
		Thread.sleep(3000);
		WebElement departureButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Leaving from']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", departureButton);

		WebElement departureInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Leaving from']")));
		departureInputField.sendKeys("Kolkata, India (CCU-Netaji Subhash Chandra Bose Intl.)");
		Thread.sleep(5000);
		departureInputField.sendKeys(Keys.ENTER);

		WebElement destinationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Going to']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", destinationButton);

		WebElement destinationInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Going to']")));
		destinationInputField.sendKeys("Hyderabad, India (HYD-Rajiv Gandhi Intl.)");
		Thread.sleep(5000);
		destinationInputField.sendKeys(Keys.ENTER);
	}

	public void Date() throws InterruptedException {
		WebElement date = driver.findElement(By.xpath("//button[@class='uitk-fake-input uitk-form-field-trigger' and @data-stid='uitk-date-selector-input1-default']"));
		date.click();
		Thread.sleep(3000);
		WebElement new_date = driver.findElement(By.xpath("//*[@id=\"FlightSearchForm_ONE_WAY\"]/div/div[2]/div/section/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr[3]/td[4]/div/div[2]"));
		new_date.click();  
		Thread.sleep(3000);
		WebElement submit_button = driver.findElement(By.xpath("//button[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary uitk-layout-flex-item' and @data-stid='apply-date-selector']"));
		submit_button.click();
		Thread.sleep(3000);
	}

	public void No_of_travellers() throws InterruptedException {

		WebElement traveller_button = driver.findElement(By.xpath("//button[@class='uitk-menu-trigger open-traveler-picker-observer-root uitk-fake-input uitk-form-field-trigger' and @aria-label='Travelers, 1 traveler']"));
		traveller_button.click();
		WebElement increase_adult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and @aria-label='Increase the number of adults']")));
		increase_adult.click();
		Thread.sleep(3000);
		WebElement traveller_submit = driver.findElement(By.xpath("//button[@id='travelers_selector_done_button']"));
		traveller_submit.click();
		Thread.sleep(3000);

	}

	public void Search_captcha() {

		WebElement search = driver.findElement(By.xpath("//button[@id='search_button']"));
		search.click();

		try {
			WebElement captchaHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='uitk-heading uitk-heading-5']")));
			System.out.println("Captcha detected: " + captchaHeading.getText());
			System.out.println("Please solve the captcha manually. The script will pause here.");
			Thread.sleep(60000);  // Wait for 1 minute to solve captcha manually. Adjust as needed.
		} catch (Exception e) {
			System.out.println("No captcha detected or unable to handle captcha.");
		}

	}

	public void Select_flight() throws InterruptedException {

		WebElement select_flight=driver.findElement(By.xpath("//button[@class='uitk-card-link' and @stid='FLIGHTS_DETAILS_AND_FARES-index-1-leg-0-fsr-FlightsActionButton']"));
		select_flight.click();
		Thread.sleep(15000);
		driver.quit();

	}


	public static void main(String[] args) throws InterruptedException {

		New_test obj1 = new New_test();
		obj1.open_browser();
		//obj1.region();
		obj1.dep_dest();
		obj1.Date();
		obj1.No_of_travellers();
		obj1.Search_captcha();
		obj1.Select_flight();
	}
}
