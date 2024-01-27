import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String url = "https://testpro.io/";

        driver.get(url);
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys("demo@class.com");
        passwordInput.sendKeys("te$t$tudent");
        loginButton.click();

    @Test(enabled = false, description = "Check if user login with correct credentials", priority = 1, groups = "Smoke")
    public void loginTest() {
        login("demo@class.com", "te$t$tudent");
      
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        Assert.assertTrue(avatar.isDisplayed()); // true
    }

    @Test
    public void loginWithEmptyCredentials() {
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        login("demo@class.com", "");
        Assert.assertTrue(logo.isDisplayed());
    }
}
