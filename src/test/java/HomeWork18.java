import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HomeWork18 extends BaseTest {
// PlaySongTest
    @Test
    public void playSongTest() {
        String songName = "BossStatus";
        login("lev.isenov@testpro.io", "d3la1lhX");
        WebElement favoritePlayListLink = driver.findElement(By.xpath("//li[contains(@class, 'favorites')]/a"));
        favoritePlayListLink.click();
        WebElement song = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//section[@id='favoritesWrapper']//td[text()='BossStatus']", songName))));
        actions.doubleClick(song).perform();
        WebElement soundBar = driver.findElement(By.cssSelector("[data-test='soundbars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
}