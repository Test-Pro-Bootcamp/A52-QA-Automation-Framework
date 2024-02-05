import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginTests extends BaseTest {

    @Test

    public void loginTest() {

        login("lev.isenov@testpro.io", "d3la1lhX");
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys("lev.isenov@testpro.io");
        passwordInput.sendKeys("d3la1lhX");
        loginButton.click();
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        Assert.assertTrue(avatar.isDisplayed());// true
    }

    @Test
    public void loginWithEmptyCredentials() {
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        login("", "");
        Assert.assertFalse(avatar.isDisplayed()); // true
    }

    @Test(groups = "Regression", dataProvider = "incorrectCredentials", dataProviderClass = DataProviderCredentials.class)
    public void loginWithEmptyCredentials(String email, String password) {
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        login(email, password);
        Assert.assertTrue(logo.isDisplayed());
    }
}
