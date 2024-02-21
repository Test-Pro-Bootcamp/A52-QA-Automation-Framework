import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homwork16 extends BaseTest {

    @Test

    public void  registrationNavigation() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement registrationLink = driver.findElement(By.cssSelector("[href = 'registration']"));
        registrationLink click ();
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),registrationUrl);
        driver.quit();

       /* WebElement registrationText = driver.findElement(By.xpath("//h2[contains(text(),'Register new account or']"));
        Assert.assertTrue(registrationText.isDisplayed());
        driver.quit();*/


    }
}



