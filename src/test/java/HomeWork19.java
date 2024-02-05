import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork19 extends BaseTest {
    // DeletePlayList
    @Test
    public void deletePlayListTest() {

            String playListName = "PlayListForDeletingTest";
            login("lev.isenov@testpro.io", "d3la1lhX");
            WebElement addPlayListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
            // #playlists i[role='button']
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
            actions.moveToElement(addPlayListButton).perform();
            addPlayListButton.click();
            WebElement createPlayListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
            createPlayListButton.click();
            // [name='create-simple-playlist-form']>input
            WebElement playListNameInput = driver.findElement(By.cssSelector("input[name='name']"));
            playListNameInput.sendKeys(playListName);
            playListNameInput.sendKeys(Keys.ENTER);
            WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li/a[text()='PlayListForDeletingTest']")));
            playList.click();
            WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn-delete-playlist')]")));
            deleteButton.click();
            Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//section[@id='playlists']//li/a[text()='PlayListForDeletingTest']"))));
        }


    }
