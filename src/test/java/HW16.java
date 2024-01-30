import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class HW16 {

    WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "https://qa.koel.app/";
        driver.get(url);
    @Test
        public void registrationNavigationTest() {
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();

  //      Assert.assertEquals(driver.getCurrentUrl(), url);
  //      driver.quit();
}
