import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RenamePlayListTest extends BaseTest {
    String newPlayListName = "New playlist";
    String currentPlayListName = "TestPro Playlist";

    @Test
    public void deletePlayListTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//section[@id='playlists']//li/a[text()='%s']", currentPlayListName))));
        actions.contextClick(playList).perform();
        Thread.sleep(3000);
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-testid, 'playlist-context-menu-edit')]")));
        editButton.click();
        WebElement renamePlaylistInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li//input[@type='text']")));
        for (int i = 0; i < currentPlayListName.length(); i ++) {
            renamePlaylistInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlaylistInput.sendKeys(newPlayListName);
        renamePlaylistInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'success')]")));

        Assert.assertEquals(newPlayListName, playList.getText());

        playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//section[@id='playlists']//li/a[text()='%s']", newPlayListName))));
        Thread.sleep(3000);
        actions.contextClick(playList).perform();
        editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-testid, 'playlist-context-menu-edit')]")));
        editButton.click();
        renamePlaylistInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li//input[@type='text']")));
        for (int i = 0; i < newPlayListName.length(); i ++) {
            renamePlaylistInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlaylistInput.sendKeys(currentPlayListName);
        renamePlaylistInput.sendKeys(Keys.ENTER);
    }
}
