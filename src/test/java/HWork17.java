import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HWork17 extends BaseTest {

    @Test
    public void addSongToPlayListTest() {
        String songName = "Riqui-Riqui";
        login("yelena.filenkova@testpro.io", "Te$tPro$tudent24");
        WebElement searchInput = driver.findElement(By.cssSelector("#searchForm>input"));
        searchInput.sendKeys(songName);
       searchInput.sendKeys(Keys.ENTER);

       WebElement likeButton = driver.findElement(By.xpath("//section[@id='searchExcerptsWrapper']//button[contains(@title,'Riqui-Riqui')]/i[@data-test='btn-like-unliked']"));
        likeButton.click();
       WebElement favoritePlayListLink = driver.findElement(By.xpath("//li[contains(@class, 'favorites')]/a"));
        favoritePlayListLink.click();
       String favoriteSong = "//section[@id='favoritesWrapper']//td[contains(text(), '%s')]";
        WebElement favoriteSongElement = driver.findElement(By.xpath(String.format(favoriteSong, songName)));
        Assert.assertTrue(favoriteSongElement.isDisplayed());
    }
}
