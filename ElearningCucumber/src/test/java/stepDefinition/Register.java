package stepDefinition;
import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	WebDriver driver;
	@Before
	public void bt()
	{
		String mybrowser = "chrome";
		String driverPath="C:\\Users\\ABHI\\Desktop\\chromedriver.exe";
		String driverPath1="C:\\Users\\ABHI\\Desktop\\geckodriver.exe";

		if(mybrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver=new ChromeDriver();
			driver.manage().window().maximize();

		}
		else if(mybrowser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",driverPath1);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();

		}
	}

	@After
	public void at() throws InterruptedException
	{

		Thread.sleep(3000);
		driver.close();
	}
	@Given("User has naviatged to url: {string}")
	public void user_has_launched_elearn_url(String string) {
		driver.get(string);

	}

	@When("User clicks on SignUp link")
	public void user_clicks_on_sign_up_link() {
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();

	}

	@Then("User should land on Registration page")
	public void user_should_land_on_registration_page() {
		Assert.assertEquals("My Organization - My education - Registration", driver.getTitle());


	}

	@When("User enter mandatory fields: {string},{string},{string},{string},{string},{string}")
	public void user_enter_mandatory_fields(String firstName, String lastName, String email, String userName, String password, String confirmPassword) {
		driver.findElement(By.xpath("//input[@id='registration_firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='registration_lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='registration_email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='pass1']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='pass2']")).sendKeys(confirmPassword);


	}

	@When("clicks on Register button on same page")
	public void click_on_register_button_on_same_page() {
		driver.findElement(By.xpath("//button[@id='registration_submit']")).click();

	}

	@Then("Message shown on next page: {string}")
	public void message_shown_on_next_page(String expected) {
		String actual=driver.findElement(By.xpath("//p[contains(text(),'Dear')]")).getText().replaceAll("\\r\\n|\\r|\\n","");
		System.out.println(expected);
		//Assert.assertEquals(expected,actual );
		assertEquals(actual, expected);
	}
	
	@When("click on right top arrow")
	public void click_on_right_top_arrow() throws InterruptedException {
		driver.findElement(By.xpath("//a/span[@class='caret']")).click();
		Thread.sleep(1000);
	}

	@Then("user profile with entered {string} should be displayed")
	public void user_profile_with_entered_should_be_displayed(String expected) throws InterruptedException {
		String actual=driver.findElement(By.xpath("//p[contains(text(),'.com')]")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(expected, actual);
	}

	@Then("User go to Home Page")
	public void user_go_to_home_page() throws InterruptedException {
		driver.findElement(By.linkText("Homepage")).click();
		Thread.sleep(1000);

	}

	@When("clicks on Compose link")
	public void click_on_compose_link() throws InterruptedException {
		driver.findElement(By.linkText("Compose")).click();
		Thread.sleep(1000);

	}

	@Then("NewMessage page should be displayed with title = {string}")
	public void new_message_page_should_be_displayed_with_title(String expected) {
		Assert.assertEquals( expected, driver.getTitle());

	}

	@When("user enter data for SendTo, Subject, messgae")
	public void user_enter_data_for_sen_to_subject_messgae() throws InterruptedException {

		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("spark");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='select2-dropdown select2-dropdown--below']//li[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='compose_message_title']")).sendKeys("tset");
		Thread.sleep(1000);

	}

	@When("clicks on Send message button")
	public void click_on_send_message_button() throws InterruptedException {

		driver.findElement(By.xpath("//button[@id='compose_message_compose']")).click();
		Thread.sleep(1000);

	}

	@Then("User should see acknowledgement message in Inbox")
	public void user_should_see_acknowledgement_message_in_inbox_page() {

		String driver1=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText(), driver1);

	}

	@Then("Logout the browser")
	public void logout_the_browser() throws InterruptedException {

		driver.findElement(By.xpath("//a/span[@class='caret']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();

	}


}
