import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTest extends BaseTest {

    @Test
    public void playSongTest() {
        String songName = "Riqui-Riqui";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("demo@class.com", "te$t$tudent");
        WebElement favoritePlayListLink = getDriver().findElement(By.xpath("//li[contains(@class, 'favorites')]/a"));
        favoritePlayListLink.click();
        WebElement song = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//section[@id='favoritesWrapper']//td[text()='%s']", songName))));
        actions.doubleClick(song).perform();
        WebElement soundBar = getDriver().findElement(By.cssSelector("[data-test='soundbars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
}
