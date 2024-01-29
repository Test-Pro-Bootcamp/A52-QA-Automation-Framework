import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(enabled = false, description = "Check if user login with correct credentials", priority = 1, groups = "Smoke")
    public void loginTest() {
        login("lev.isenov@testpro.io", "d3la1lhX");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String url = "https://testpro.io/";

        driver.get(url);
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys("lev.isenov@testpro.io");
        passwordInput.sendKeys("d3la1lhX");
        loginButton.click();
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
