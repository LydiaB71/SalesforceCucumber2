package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	WebDriver driver;
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		
		driver.get("https://login.salesforce.com/");
	}
	
	@Given("user enters correct username and password")
	public void user_enters_correct_username_and_password() {
		driver.get("https://login.salesforce.com/");
		WebElement email= driver.findElement(By.id("username"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(email));// check more ExpectedConditions methods
		email.clear();
		email.sendKeys("lbierer@gmail.com");
		System.out.println("user name entered");
		WebElement passwrd=driver.findElement(By.id("password"));
		passwrd.clear();
		passwrd.sendKeys("tx2200108");
		System.out.println("password entered");
	
	}
    @Given("user enters correct username")
    public void user_enters_correct_username() {
		driver.get("https://login.salesforce.com/");
		WebElement email= driver.findElement(By.id("username"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(email));// check more ExpectedConditions methods
		email.clear();
		email.sendKeys("lbierer@gmail.com");
		System.out.println("user name entered");
	}
	@When("user enters {string} into username field")
	public void user_enters_into_username_field(String username) {
		WebElement email= driver.findElement(By.id("username"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(email));// check more ExpectedConditions methods
		email.clear();
		email.sendKeys(username);
		System.out.println("user name entered");
	}

	@When("user enters {string} into password field")
	public void user_enters_into_password_field(String password) {
		WebElement passwrd=driver.findElement(By.id("password"));
		passwrd.clear();
		passwrd.sendKeys(password);
		System.out.println("password entered");
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		WebElement login=driver.findElement(By.id("Login"));
		login.click();
		System.out.println("login button clicked"); 
	}
	@When("user clicks on Remember Me check box")
	public void user_clicks_on_Remember_Me_check_box() {
		WebElement rememberMe=driver.findElement(By.id("rememberUn"));
		rememberMe.click();
		System.out.println("remember me checked"); 
	}
	@When("user clicks on logout button")
	public void user_click_on_logout_button() {
		WebElement userMenu=driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[1]/span"));
		userMenu.click();
		WebElement logout=driver.findElement(By.linkText("Logout"));
		logout.click();
		System.out.println("logout button clicked"); 
	}
	@When("user clicks on Forgot password")
	public void user_clicks_on_Forgot_password() {
		WebElement forgotPWLink=driver.findElement(By.id("forgot_password_link"));
		forgotPWLink.click();
		System.out.println("forgot password link clicked"); 
	}
	@When("user provides username {string}")
	public void user_provides_username(String username) {
		WebElement enterUsername = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input[1]"));
	    enterUsername.clear();
	    enterUsername.sendKeys(username);
	    System.out.println("username is provided");
	}
	
	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
        WebElement submitUsername = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input[2]"));
		submitUsername.click();
		System.out.println("continue button clicked"); 
	}
	
	
	@Then("verify page title {string}")
	public void verify_page_title(String expectedString) {
		
		String actual=driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains(actual));
		System.out.println("extracted title is="+actual);
		Assert.assertEquals(actual, expectedString);
		
	}
	@Then("verify no password error message is {string}")
	public void verify_no_password_error_message_is(String expectedString) {
		
		WebElement errorMsg=driver.findElement(By.id("error"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		String actual = errorMsg.getText();
		System.out.println("extracted message is="+actual);
		Assert.assertEquals(actual, expectedString);
		
	}
	@Then("verify username field is {string}")
	public void verify_username_field_is(String expectedString) {
		
		WebElement usernameField=driver.findElement(By.id("idcard-identity"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		String actual = usernameField.getText();
		System.out.println("stored username is="+actual);
		Assert.assertEquals(actual, expectedString);
		
	}
	@Then("password reset message is {string}")
	public void password_reset_message_is(String expectedString) {
		
		WebElement resetMsg=driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div/p[1]"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(resetMsg));
		String actual = resetMsg.getText();
		System.out.println("extracted message is="+actual);
		Assert.assertEquals(actual, expectedString);
		
	}
	@Then("password error message is {string}")
	public void password_error_message_is(String expectedString) {
		
		WebElement resetMsg=driver.findElement(By.id("error"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(resetMsg));
		String actual = resetMsg.getText();
		System.out.println("extracted message is="+actual);
		Assert.assertEquals(actual, expectedString);
		
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
