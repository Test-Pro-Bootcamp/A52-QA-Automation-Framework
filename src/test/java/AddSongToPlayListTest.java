import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongToPlayListTest extends BaseTest {

    @Test
    public void
    addSongToPlayListTest() throws InterruptedException {
        String songName = "BossStatus";
        login("Lev.isenov@testpro.io", "d3la1lhX");
        WebElement allSongs = driver.findElement(By.cssSelector("a[class='songs']"));
        allSongs.click();
        WebElement searchInput = driver.findElement(By.cssSelector("#searchForm>input"));
        searchInput.sendKeys(songName);
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement likeButton = driver.findElement(By.xpath("//section[@id='searchExcerptsWrapper']//button[contains(@title, 'BossStatus')]/i[@data-test='btn-like-unliked']"));
        likeButton.click();
        WebElement favoritePlayListLink = driver.findElement(By.xpath("//li[contains(@class, 'favorites')]/a"));
        favoritePlayListLink.click();
        String favoriteSong = "//section[@id='favoritesWrapper']//td[contains(text(), '%s')]";
        WebElement favoriteSongElement = driver.findElement(By.xpath(String.format(favoriteSong, songName)));
        Assert.assertTrue(favoriteSongElement.isDisplayed());
    }
}
