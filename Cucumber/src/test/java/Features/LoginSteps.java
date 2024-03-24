package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.util.HashMap;
import java.util.Map;

public class LoginSteps {

    private WebDriver driver;
    private Map<String, Map<String, String>> testDataMap;

    @Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        testDataMap = generateTestDataMap();
    }

    public Map<String, Map<String, String>> generateTestDataMap() {
        Map<String, Map<String, String>> testDataMap = new HashMap<>();
        // Adding test data with IDs
        testDataMap.put("1", createTestData("standard_user", "secret_sauce"));
        testDataMap.put("2", createTestData("locked_out_user", "secret_sauce"));
        testDataMap.put("3", createTestData("problem_user", "secret_sauce"));
        testDataMap.put("4", createTestData("performance_glitch_user", "secret_sauce"));
        testDataMap.put("5", createTestData("error_user", "secret_sauce"));
        testDataMap.put("6", createTestData("visual_user", "secret_sauce"));
        return testDataMap;
    }

    private Map<String, String> createTestData(String username, String password) {
        Map<String, String> testData = new HashMap<>();
        testData.put("username", username);
        testData.put("password", password);
        return testData;
    }

    @Given("User is on the SauceDemo login page")
    public void user_is_on_the_sauce_demo_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User logs in with ID {string}")
    public void user_logs_in_with_id(String id) {
        Map<String, String> testData = testDataMap.get(id);
        driver.findElement(By.id("user-name")).sendKeys(testData.get("username"));
        driver.findElement(By.id("password")).sendKeys(testData.get("password"));
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // Add assertion or validation for successful login
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}