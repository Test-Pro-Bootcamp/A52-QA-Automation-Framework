import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16 extends BaseTest {
    @Test
    public void registrationNavigationTest(){
        // GIVEN
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";

//       WHEN
        driver.get(url);
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();

        // THEN
        String registrationUrl = "https://qa.koel.app/registration";
        // WebElement registrationAcc = driver.findElement(By.xpath("//h2[contains(text(), 'Register new account or')]"));
//      Assert.assertTrue(registrationAcc.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
        driver.quit();

    }
}
