import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(description = "Check if user login with correct credentials", priority = 1, groups = "Smoke")
    public void loginTest() {
        login("demo@class.com", "te$t$tudent");
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        Assert.assertFalse(avatar.isDisplayed()); // true
    }

<<<<<<< HEAD
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://testpro.io/";
        driver.get(url);

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
=======
    @Test(groups = "Regression")
    public void loginWithEmptyCredentials() {
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        login("demo@class.com", "");
        Assert.assertTrue(logo.isDisplayed());
>>>>>>> eaa46827de5ef77852ac724dc03e17a15170bdad
    }
}
