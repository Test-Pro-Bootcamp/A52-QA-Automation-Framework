import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    LoginPage loginPage = null;

    @Test(description = "Check if user login with correct credentials", priority = 1, groups = "Smoke")
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        HomePage homePage = new HomePage(driver);
        Assert.assertFalse(homePage.getAvatar().isDisplayed()); // true
    }

    @Test(groups = "Regression", dataProvider = "incorrectCredentials", dataProviderClass = DataProviderCredentials.class)
    public void loginWithEmptyCredentials(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.getLogo().isDisplayed());
    }
}
