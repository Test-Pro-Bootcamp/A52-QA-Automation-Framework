import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;

public class Homework17 extends BaseTest {

@Test

public void addSongToPlaylist() {
    LoginPage loginPage = new LoginPage(getDriver());
    loginPage.login("dzmitry.kimber@testpro.io", "1qAY76Rs");

    WebElement song = getDriver().findElement(By.xpath("//ol[@class=\"top-song-list\"]/li[1]"));
    WebElement viewAll = getDriver().findElement(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']"));
    viewAll.click();
    song.click();
    WebElement AddTo = getDriver().findElement(By.cssSelector("button[data-test='add-to-btn']"));
    AddTo.click();
    WebElement hw17 = getDriver().findElement(By.cssSelector("li[class='playlist playlist']"));
    hw17.click();
    Assert.assertTrue(hw17.isDisplayed());


}
}
