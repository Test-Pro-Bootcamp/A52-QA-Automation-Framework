import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Homework19 extends BaseTest {

        @Test
        public void deletePlayListTest() throws InterruptedException {
            String playListName = "TestPlayListForDeleting";
            login("demo@class.com", "te$t$tudent");

            WebElement createNewPlayList = driver.findElement(By.xpath("//*[@id='playlists']/h1/i"));
            createNewPlayList.click();
//            WebElement playListNameInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/nav/section[2]/form/input"));
//            playListNameInput.sendKeys(playListName);
//            playListNameInput.sendKeys(Keys.ENTER);

            WebElement playList = driver.findElement(By.xpath("//section[@id='playlists']/li/a/text()='TestPlayListForDeleting'"));
            playList.click();
            WebElement deleteButton = driver.findElement(By.xpath("//button(contains(@class, 'btn-delete-playlist'))"));
            deleteButton.click();
            Thread.sleep(3000);
            Assert.assertFalse(playList.isDisplayed());



        }

    }
