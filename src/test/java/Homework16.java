import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.SuiteGenerator;
import org.w3c.dom.html.HTMLInputElement;

import java.time.Duration;


public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigationTest() {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://qa.koel.app";
            driver.get(url);

            WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
            registrationLink.click();
            WebElement registrationText = driver.findElement(By.xpath("//div[@class='login-wrapper']/h2"));
            Assert.assertTrue(registrationText.isDisplayed());
            driver.quit();


        }
    }


