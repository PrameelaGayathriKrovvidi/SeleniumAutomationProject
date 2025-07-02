import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest {

	WebDriver driver;

	
    @BeforeClass
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLoginWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement inventoryContainer = driver.findElement(By.id("inventory_container"));
        Assert.assertTrue(inventoryContainer.isDisplayed(), "Login failed or inventory not displayed.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
