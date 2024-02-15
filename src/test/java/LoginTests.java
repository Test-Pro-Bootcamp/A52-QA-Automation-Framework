import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTests extends BaseTest {
@Test(description = "Check if user logs in with correct credentials", priority = 1, groups = "Smoke")

public void loginTest() {

    login("demo@class.com", "te$t$tudent");
    WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
    Assert.assertTrue(avatar.isDisplayed()); //true
}
}