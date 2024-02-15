import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class Homework20 extends BaseTest {

        @Test
        public void deletePlayListTest() throws InterruptedException {
            String playListName = "PlayListForDeleting";
            login("demo@class.com", "te$t$tudent");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists i[role='button']")));
            WebElement addPlayListButton = driver.findElement(By.cssSelector("#playlists i[role='button']"));
            addPlayListButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
            WebElement createPlayListButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
            createPlayListButton.click();
            WebElement playListNameInput = driver.findElement(By.cssSelector("[name='create-simple-playlist-form']>input"));
            playListNameInput.sendKeys(playListName);
            playListNameInput.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li/a[text()='PlayListForDeleting']")));
            WebElement playList = driver.findElement(By.xpath("//section[@id='playlists']//li/a[text()='PlayListForDeleting']"));
            playList.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-delete-playlist')]")));
            WebElement deleteButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-delete-playlist')]"));
            deleteButton.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("//section[@id='playlists']//li/a[text()='PlayListForDeleting']")));
            Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//section[@id='playlists']//li/a[text()='PlayListForDeleting']"))));
        }

        }

