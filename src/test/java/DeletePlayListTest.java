import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DeletePlayListTest extends BaseTest {

    @Test
    public void deletePlayListTest() {
        String playListName = "TestPlayListForDeleting";
        login("demo@class.com", "te$t$tudent");
        WebElement addPlayListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists i[role='button']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
        actions.moveToElement(addPlayListButton).perform();
        addPlayListButton.click();
        WebElement createPlayListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        createPlayListButton.click();
        WebElement playListNameInput = driver.findElement(By.cssSelector("[name='create-simple-playlist-form']>input"));
        playListNameInput.sendKeys(playListName);
        playListNameInput.sendKeys(Keys.ENTER);

        WebElement playList =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li/a[text()='TestPlayListForDeleting']")));
        playList.click();
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn-delete-playlist')]")));
        deleteButton.click();
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//section[@id='playlists']//li/a[text()='TestPlayListForDeleting']"))));
    }

    @Test
    public void addPlayListTest() throws InterruptedException {
        String playListName = "TestPlayListForDeleting";
        login("demo@class.com", "te$t$tudent");
        List<WebElement> playLists = driver.findElements(By.cssSelector("#playlists li"));
        int previousSize = playLists.size();
        WebElement addPlayListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists i[role='button']")));
        Thread.sleep(3000);
        addPlayListButton.click();
        WebElement createPlayListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        createPlayListButton.click();
        WebElement playListNameInput = driver.findElement(By.cssSelector("[name='create-simple-playlist-form']>input"));
        playListNameInput.sendKeys(playListName);
        playListNameInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'success')]")));
        playLists = driver.findElements(By.cssSelector("#playlists li"));
        int actualSize = playLists.size();
        Assert.assertNotEquals(actualSize, previousSize); // previousSize != actualSize
    }
}
