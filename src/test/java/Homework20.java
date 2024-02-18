//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.devtools.v85.input.Input;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class Homework20 extends BaseTest {

        @Test
        public void deletePlayListTest() {
            // GIVEN
            String playListName = "PlayListForDeleting";
            login("demo@class.com", "te$t$tudent");

            // WHEN
            clickAddPlayListButton();
            clickCreatePlayListButton();
            enterPlayListName(playListName);
            pressEnterInPlayListNameInput();
            waitUntilPlayListIsVisible(playListName);
            openPlayList(playListName);
            clickDeleteButton();
            waitUntilPlayListIsInvisible(playListName);

            // THEN
            assertPlayListDeleted(playListName);
        }

        private void clickAddPlayListButton() {
            WebElement addPlayListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists i[role='button']")));
            addPlayListButton.click();
        }
        private void clickCreatePlayListButton() {
            WebElement createPlayListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
            createPlayListButton.click();
        }

        private void enterPlayListName(String playListName) {
            WebElement playListNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='create-simple-playlist-form']>input")));
            playListNameInput.sendKeys(playListName);
        }

        private void pressEnterInPlayListNameInput() {
            WebElement playListNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='create-simple-playlist-form']>input")));
            playListNameInput.sendKeys(Keys.ENTER);
        }

        private void waitUntilPlayListIsVisible(String playListName) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li/a[text()='" + playListName + "']")));
        }

        private void openPlayList(String playListName) {
            WebElement playList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li/a[text()='" + playListName + "']")));
            playList.click();
        }

        private void clickDeleteButton() {
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-delete-playlist')]")));
            deleteButton.click();
        }

        private void waitUntilPlayListIsInvisible(String playListName) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//section[@id='playlists']//li/a[text()='" + playListName + "']")));
        }

        private void assertPlayListDeleted(String playListName) {
            Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//section[@id='playlists']//li/a[text()='" + playListName + "']"))));
        }
    }