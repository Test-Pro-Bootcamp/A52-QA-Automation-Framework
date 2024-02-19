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

            WebElement addPlayListButton = driver.findElement(By.cssSelector("#playlists i[role='button']"));

//            WebElement
//            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
//            actions.moveToElement(addPlayListButton).perform();
            addPlayListButton.click();
            WebElement createPlayListButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
            createPlayListButton.click();
            WebElement playListNameInput = driver.findElement(By.cssSelector("[name='create-simple-playlist-form']>input"));
            playListNameInput.sendKeys(playListName);
            playListNameInput.sendKeys(Keys.ENTER);

            WebElement playList = driver.findElement(By.xpath("//section[@id='playlists']//li/a[text()='TestPlayListForDeleting']"));
            playList.click();
            WebElement deleteButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-delete-playlist')]"));
            deleteButton.click();
            Assert.assertFalse(playList.isDisplayed());

        }

    }
