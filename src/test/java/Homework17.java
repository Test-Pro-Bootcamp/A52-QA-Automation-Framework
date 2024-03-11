import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

@Test

public void addSongToPlaylist() {
    LoginPage page = new LoginPage(driver);
    page.login("dzmitry.kimber@testpro.io","1qAY76Rs");
    WebElement song = driver.findElement(By.xpath("//ol[@class=\"top-song-list\"]/li[1]"));
    WebElement viewAll = driver.findElement(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']"));
    viewAll.click();
    song.click();
    WebElement AddTo = driver.findElement(By.cssSelector("button[data-test='add-to-btn']"));
    AddTo.click();
    WebElement Playlist17 = driver.findElement(By.cssSelector("a[class='active']"));
    Playlist17.click();
    Assert.assertEquals("Added 1 song into {Playlist17}"());
}
}
