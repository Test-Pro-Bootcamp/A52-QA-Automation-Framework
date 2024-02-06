import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {

        String nameSong = "Pluto";
        String namePlaylist = "TestPro Playlist";
        String expectedSongAddedMessage = "Added 1 song into \"" + namePlaylist + ".\"";
        login("demo@class.com", "te$t$tudent");
        Thread.sleep(2000);
        searchSong(nameSong);
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist(namePlaylist);
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

    public void searchSong(String nameSong) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(nameSong);
        Thread.sleep(2000);
    }
    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist (String namePlaylist) throws InterruptedException {
        //We created a playlist named "Test Pro Playlist"
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlist.click();
        Thread.sleep(2000);
    }
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
