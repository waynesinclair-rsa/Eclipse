package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.messages.types.Duration;
import static org.junit.Assert.*;

public class LoginSteps {
	
    WebDriver driver;
	
	@Given("that I am on the Mercury Tours login page")
	public void that_i_am_on_the_mercury_tours_login_page() {
		//System.out.println("In LoginSteps");
	      System.setProperty("webdriver.chrome.driver", "D:\\My Eclipse\\Drivers\\chromedriver_win32_Chrome99\\chromedriver.exe");
	        driver = new ChromeDriver();
	        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.manage().timeouts().scriptTimeout(java.time.Duration.ofSeconds(30));
	        driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(60));

	        String baseUrl = "http://localhost:8081/mtours";
	        // launch browser and direct it to the Base URL
	        driver.get(baseUrl);
	        WebDriverWait w;
	        w = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	        w.until(ExpectedConditions.presenceOfElementLocated(By.name("t_signon")));
	        String pageTitle = driver.getTitle();
	        System.out.println("Page title is: " + pageTitle);
	        String expectedTitle = "Welcome: Mercury Tours";
	        assertEquals("Not on correct landing page", driver.getTitle(), expectedTitle);
	}

	@When("I logon with my credentials")
	public void i_logon_with_my_credentials() {
        String username = "User1", password = "Pass1";
        driver.findElement(By.name("userName")).click();
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();;
	}

	@Then("I navigate to home page")
	public void i_navigate_to_home_page() {
	       assertTrue((driver.getPageSource().contains("Use our Flight Finder")));
	        driver.close();
	}
}
