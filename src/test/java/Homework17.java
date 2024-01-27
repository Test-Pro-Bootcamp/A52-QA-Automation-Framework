import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app";
        driver.get(url);

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys("demo@class.com");
        passwordInput.sendKeys("te$t$tudent");
        loginButton.click();

        WebElement CreateNewPlaylist = driver.findElement(By.cssSelector("[title='Create a new playlist']"));
        CreateNewPlaylist.click();
        WebElement EnterPlaylistName = driver.findElement(By.cssSelector("#playlists>form>input[type=text]"));
        EnterPlaylistName.sendKeys("myPLAYLIST");
        Assert.assertTrue(EnterPlaylistName.isDisplayed());
        driver.quit();


        }
    }
